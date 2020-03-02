package dev.mcarthur.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mcarthur.controllers.EmployeeController;

public class MasterServlet extends HttpServlet {

	public static EmployeeController ec = new EmployeeController();

	private static final long serialVersionUID = 1L;

	public MasterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {
		case "/ProjectOne/login.do": {

			ec.login(request, response);

			break;
		}

		case "/ProjectOne/getReimbursementsForEmployee.do": {

			ec.getReimbursementsForEmployee(request, response);

			break;
		}
		
		case "/ProjectOne/getReimbursementsForEmployeeId.do": {

			ec.getReimbursementsForEmployeeID(request, response);

			break;
		}
		
		case "/ProjectOne/viewAllReimbursements.do": {

			ec.viewAllReimbursements(request, response);

			break;
		}

		case "/ProjectOne/getReimbursementsByAmount.do": {

			ec.getReimbursementsByAmount(request, response);

			break;
		}

		case "/ProjectOne/getReimbursementsByDate.do": {

			ec.getReimbursementsByDate(request, response);

			break;
		}

		default: {
			response.sendError(404, "Invalid URI");
		}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {

		case "/ProjectOne/submitReimbursement.do": {

			ec.submitReimbursement(request, response);

			break;
		}
		default: {
			response.sendError(404, "Invalid URI");
		}
		}

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {

		case "/ProjectOne/approveReimbursement.do": {

			ec.approveReimbursement(request, response);

			break;
		}

		case "/ProjectOne/denyReimbursement.do": {

			ec.denyReimbursement(request, response);

			break;
		}
		default: {
			response.sendError(404, "Invalid URI");
		}
		}
	}
}
