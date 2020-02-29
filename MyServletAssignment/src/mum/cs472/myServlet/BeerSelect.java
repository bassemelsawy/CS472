package mum.cs472.myServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class BeerSelect extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String c = request.getParameter("color");
        BeerExpert be = new BeerExpert();
        List result = be.getBrands(c);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Beer Selection Advice<br>");
        Iterator it = result.iterator();
        while (it.hasNext()) {
            out.print("<br>try : " + it.next());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.print("<html>\n" +
                "  <body>\n" +
                "    <h1 align=\"center\">Beer Selection Page</h1>\n" +
                "    <form method=\"POST\" action=\"BeerSelect\">\n" +
                "      Select beer characteristics\n" +
                "      <p>\n" +
                "        Color:\n" +
                "        <select name=\"color\" size=\"1\">\n" +
                "          <option value=\"light\"> light </option>\n" +
                "          <option value=\"amber\"> amber </option>\n" +
                "          <option value=\"brown\"> brown </option>\n" +
                "          <option value=\"dark\"> dark </option>\n" +
                "        </select>\n" +
                "        <br /><br />\n" +
                "        <center><input type=\"SUBMIT\" /></center>\n" +
                "      </p>\n" +
                "    </form>\n" +
                "  </body>\n" +
                "</html>");
    }
}