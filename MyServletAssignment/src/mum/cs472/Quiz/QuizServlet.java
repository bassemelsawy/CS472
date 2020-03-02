package mum.cs472.Quiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class QuizServlet extends HttpServlet {
    private static final String $$$_SCORE_$$$ = "$$$SCORE$$$";
    private static final String $$$_SEQ_$$$ = "$$$SEQ$$$";
    private static final String QUIZ_HTML = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Quiz</title>\n" +
            "    <link href=\"resources/style.css\" rel=\"stylesheet\">\n" +
            "</head>\n" +
            "<body>\n" +
            "<fieldset>\n" +
            "    <legend>The Number Quiz</legend>\n" +
            "    <form method=\"get\">\n" +
            "\n" +
            "        <div class=\"input_line\">\n" +
            "            <h3>Your Current Score is " + $$$_SCORE_$$$ + " </h3>\n" +
            "            <h3>Guess The Number in the sequence : </h3>\n" +
            "            <h3>" + $$$_SEQ_$$$ + " </h3>\n" +
            "        </div>\n" +
            "        </div>\n" +
            "        <br>\n" +
            "        <div class=\"input_line\">\n" +
            "            <input type=\"number\" name=\"answer\">\n" +
            "        </div>\n" +
            "\n" +
            "        <div class=\"input_line\">\n" +
            "            <input class=\"input-submit\" type=\"submit\" value=\"Submit\">\n" +
            "        </div>\n" +
            "    </form>\n" +
            "</fieldset>\n" +
            "</body>\n" +
            "</html>";

    private static final String RESULT_PAGE = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Quiz</title>\n" +
            "    <link href=\"resources/style.css\" rel=\"stylesheet\">\n" +
            "</head>\n" +
            "<body>\n" +
            "<fieldset>\n" +
            "    <legend>The Number Quiz</legend>\n" +
            "        <div class=\"input_line\">\n" +
            "            <h3>Your Current Score is $$$SCORE$$$ </h3>\n" +
            "            <h3>You Have Completed The quiz with score $$$SCORE$$$ out of 5 </h3>\n" +
            "        </div>\n" +
            "        </div>\n" +
            "</fieldset>\n" +
            "</body>\n" +
            "</html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession s = req.getSession();
        Quiz quiz = (Quiz)s.getAttribute("quiz");
        if(quiz==null){
            quiz = new Quiz();
        }

        String asnwerStr = req.getParameter("answer");
        Boolean answerResult = true;

        if (asnwerStr != null) {
            int answer = Integer.parseInt(asnwerStr);
            if (quiz.checkAnswer(answer)) {
                quiz.IncrementScore();
            } else {
                answerResult = false;
            }
        }
        String quizPage = "";
        if (answerResult != false && quiz.getScore() < 5) {
            quizPage = QUIZ_HTML.replace($$$_SCORE_$$$, quiz.getScore().toString());
            quizPage = quizPage.replace($$$_SEQ_$$$, quiz.getCurrentQuestion());
        } else {
            quizPage = RESULT_PAGE.replace($$$_SCORE_$$$, quiz.getScore().toString());
        }
        s.setAttribute("quiz", quiz);
        PrintWriter out = resp.getWriter();
        out.print(quizPage);
    }
}
