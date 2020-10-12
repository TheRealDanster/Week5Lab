package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	
	if(request.getParameter("logout") != null) {
	    session.invalidate();
	    request.setAttribute("message", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
	
	if (session.getAttribute("username") != null) {
	    response.sendRedirect("home");
	} else {
	    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	
	if (!request.getParameter("username").equals("") && !request.getParameter("password").equals("")) {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    
	    AccountService accountService = new AccountService();
	    if (accountService.login(username, password) != null) {
		session.setAttribute("username", username);
		response.sendRedirect("home");
	    } else {
		request.setAttribute("message", "Incorrect username or password.");
		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	    }	    
	} else {
	    request.setAttribute("message", "Both username and password must be entered.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
    }
}
