package mum.cs472.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class QuizServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ss = request.getSession();
        Quiz2 model;
        if (ss.isNew())
            model = new Quiz2();
        else
            model = (Quiz2) ss.getAttribute("model");
        String question = model.next();
        ss.putValue("model", model);
        request.setAttribute("score", model.getCorrectAnswers());
        request.setAttribute("question", question);
        request.setAttribute("age", model.getAge());
        RequestDispatcher view = request.getRequestDispatcher("./resources/jsp/quiz.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ss = request.getSession();
        Quiz2 model = (Quiz2) ss.getAttribute("model");

        if (Objects.nonNull(request.getParameter("answer"))
                && !request.getParameter("answer").equals(""))
            model.putAnswer(Integer.parseInt(request.getParameter("answer")));
        if (model.isGameFinished()) {
            String grade = "";
            int score = model.getCorrectAnswers();
            if (score >= 45 && score <= 50)
                grade = "A";
            else if (score >= 35 && score <= 44)
                grade = "B";
            else if (score >= 25 && score <= 34)
                grade = "C";
            else if (score < 25)
                grade = "NC";
            request.setAttribute("score", score);
            request.setAttribute("grade", grade);
            request.setAttribute("questions", model.getCountOfQuestions());
            request.setAttribute("age", model.getAge());
            RequestDispatcher view = request.getRequestDispatcher("./resources/jsp/result.jsp");
            view.forward(request, response);
        } else {
            ss.putValue("model", model);
            request.setAttribute("score", model.getCorrectAnswers());
            request.setAttribute("age", model.getAge());
            request.setAttribute("question", model.next());
            RequestDispatcher view = request.getRequestDispatcher("./resources/jsp/quiz.jsp");
            view.forward(request, response);
        }
    }

}