package com.student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StudentServlet() {
        super();
    }

    // POST method (Form submit)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔹 Get all form data
        String prn = request.getParameter("prn");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");

        // Checkbox (multiple values)
        String[] subjects = request.getParameterValues("sub");

        // 🔹 Set response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 🔹 Start HTML
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Details</title>");

        // 🔹 CSS Styling
        out.println("<style>");
        out.println("body { font-family: Arial; background: linear-gradient(to right, #74ebd5, #9face6); }");
        out.println(".card { width: 400px; margin: 60px auto; background: white; padding: 25px; border-radius: 10px; box-shadow: 0 0 10px gray; }");
        out.println("h2 { text-align: center; color: #333; }");
        out.println("p { font-size: 16px; }");
        out.println("a { text-decoration: none; color: white; background: #4CAF50; padding: 8px 12px; border-radius: 5px; }");
        out.println("a:hover { background: #45a049; }");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        // 🔹 Card Layout
        out.println("<div class='card'>");
        out.println("<h2>Student Details</h2>");

        out.println("<p><b>PRN:</b> " + prn + "</p>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>DOB:</b> " + dob + "</p>");
        out.println("<p><b>Gender:</b> " + gender + "</p>");

        // 🔹 Subjects
        out.println("<p><b>Subjects:</b> ");
        if (subjects != null) {
            for (String s : subjects) {
                out.println(s + " ");
            }
        } else {
            out.println("No subjects selected");
        }
        out.println("</p>");

        out.println("<br><center><a href='index.html'>Go Back</a></center>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }

    // GET method
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Please fill the form first</h2>");
        out.println("<a href='index.html'>Go to Form</a>");
        out.println("</body></html>");
    }
}