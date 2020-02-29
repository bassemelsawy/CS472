package mum.cs472.myServlet;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<p>HelloWorld</p>");
        out.print("</body></html>");
    }
}
