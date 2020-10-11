package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	
	if (request.getParameter("username") != null && request.getParameter("password") != null) {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    
	    AccountService accountService = new AccountService();
	    if (accountService.login(username, password) != null) {
		session.setAttribute("user", username);
		getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	    } else {
		// Display error message
	    }	    
	} else {
	    // Display error message
	}
    }
}
