package mum.cs472.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HintServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("./resources/jsp/age.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean err = false;
        String age = request.getParameter("age");
        int nAge = 0;
        try {
            nAge = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            request.setAttribute("msg", "Wrong format");
            RequestDispatcher view = request.getRequestDispatcher("./resources/jsp/age.jsp");
            view.forward(request, response);
            err = true;
        }
        if (!err) {
            if (nAge > 100 || nAge < 4) {
                request.setAttribute("msg", "Entered number is out of bound");
                RequestDispatcher view = request.getRequestDispatcher("./resources/jsp/age.jsp");
                view.forward(request, response);
                err = true;
            }
        }
        if (!err) {
            Quiz2 model = new Quiz2();
            HttpSession ss = request.getSession();
            model.setAge(nAge);
            ss.putValue("model", model);
            response.sendRedirect("./QuizServlet22");
        }
    }

}