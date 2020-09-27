
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String personName = request.getParameter("personName");
		String personPassword = request.getParameter("personPassword");
		Object login = request.getParameter("login");

		if (!isValid(personName, personPassword)) {
			PrintWriter writer = response.getWriter();
			writer.println("Inputs cannot be empty!");
			return;
		}

		try {
			if (login != null) {
				processLogin(request, response);
				return;
			}

			processRegister(request, response);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private boolean isValid(String name, String password) {
		if (name == null || name == "") {
			return false;
		}

		if (password == null || password == "") {
			return false;
		}

		return true;
	}

	private void processRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			makeCookie(request, response);
			return;
		}

		boolean isRegistered = false;
		for (Cookie cookie : cookies) {
			String personName = request.getParameter("personName");
			if (!cookie.getName().equals(personName)) {
				continue;
			}

			isRegistered = true;
			// You have already registered
			PrintWriter writer = response.getWriter();
			writer.println("<b>You've already registered!</b>");
			break;
		}

		if (!isRegistered) {
			makeCookie(request, response);
		}
	}

	private void makeCookie(HttpServletRequest request, HttpServletResponse response) {
		String personName = request.getParameter("personName");
		String personPassword = request.getParameter("personPassword");

		Cookie userCookie = new Cookie(personName, personPassword);
		userCookie.setMaxAge(1800);
		response.addCookie(userCookie);
	}

	private void processLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cookie[] cookies = request.getCookies();
		PrintWriter writer = response.getWriter();
		if (cookies == null) {
			// register
			writer.println("<b>Please register!</b>");
			return;
		}

		boolean isRegistered = false;
		for (Cookie cookie : cookies) {
			String personName = request.getParameter("personName");
			if (!cookie.getName().equals(personName)) {
				continue;
			}

			isRegistered = true;
			writer.println("Welcome back!");
			break;
		}

		if (!isRegistered) {
			writer.println("<b>Please register!</b>");
		}
	}
}
