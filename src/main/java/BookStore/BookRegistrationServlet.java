package BookStore;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import model.Book;
import dao.BookDAO;

public class BookRegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        Book book = new Book(title, author, price);
        BookDAO dao = new BookDAO();

        boolean success = dao.addBook(book);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        if (success) {
            out.println("<h3>Book added successfully!</h3>");
        } else {
            out.println("<h3>Error adding book.</h3>");
        }
    }
}
