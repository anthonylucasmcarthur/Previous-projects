package dev.mcarthur.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.mcarthur.entities.Employee;
import dev.mcarthur.entities.Reimbursement;
import dev.mcarthur.services.EmployeeServices;
import dev.mcarthur.services.EmployeeServicesImpl;

public class EmployeeController {

	private EmployeeServices es = new EmployeeServicesImpl();
//	private  RequestDispatcher rd;

	public void login(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");

		String password = request.getParameter("password");

		Employee employee = es.login(username, password);

		PrintWriter pw;
		try {
			pw = response.getWriter();

			Gson gson = new Gson();

			if (employee == null) {
				pw.append("Wrong username or password");
			} else {
				pw.append(gson.toJson(employee));

				if (employee.isIsmanager() == true) {
					response.sendRedirect("http://localhost:8080/ProjectOne/manager1.html");
				} else {
					HttpSession sess = request.getSession();			
					sess.setAttribute("username", employee.getUsername());
					System.out.println(employee);
					
					response.sendRedirect("http://localhost:8080/ProjectOne/employee1.html");

					
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void submitReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = (String) request.getSession().getAttribute("username");
//		String username = request.getParameter("username");

		double amou = Double.parseDouble(request.getParameter("amount"));

		String comment = request.getParameter("comment");

		Reimbursement reimbursement = es.submitReimbursement(username, amou, comment);

		PrintWriter pw;

		pw = response.getWriter();

		Gson gson = new Gson();
		pw.append("You have successfully submitted a remiburement");
//		pw.append(gson.toJson(reimbursement));

	}

	public void getReimbursementsForEmployeeID(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

//		int id = Integer.parseInt(request.getParameter("id"));

		List<Reimbursement> reimbursements = es.getReimbursementsForEmployeeId();

		PrintWriter pw;

		pw = response.getWriter();

		Gson gson = new Gson();

		pw.append(gson.toJson(reimbursements));

	}

	public void getReimbursementsForEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		String username = (String) request.getSession().getAttribute("username");
		
//		String username = request.getParameter("username");

		Employee employee = es.getEmployeeByUsername(username);

		List<Reimbursement> reimbursements = es.getReimbursementsForEmployee(employee);

		PrintWriter pw;

		pw = response.getWriter();

		Gson gson = new Gson();

		pw.append(gson.toJson(reimbursements));

	}

	public void viewAllReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Reimbursement> reimbursements = es.viewAllReimbursements();

		PrintWriter pw;

		pw = response.getWriter();

		Gson gson = new Gson();

		pw.append(gson.toJson(reimbursements));

	}

	public void approveReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Reimbursement reimbursement = es.getReimbursementById(id);

		String comment = request.getParameter("comment");

		Reimbursement updatedreimbursement = es.approveReimbursement(reimbursement, comment);

		PrintWriter pw;

		pw = response.getWriter();

		Gson gson = new Gson();
		if (updatedreimbursement == null) {
			pw.append("Invalid reimbursement ID");
		} else {
			pw.append("You have successfully appoved a remiburement");
//			pw.append(gson.toJson(updatedreimbursement));
		}
	}

	public void denyReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Reimbursement reimbursement = es.getReimbursementById(id);

		String comment = request.getParameter("comment");

		Reimbursement updatedreimbursement = es.denyReimbursement(reimbursement, comment);

		PrintWriter pw;

		pw = response.getWriter();

		Gson gson = new Gson();
		if (updatedreimbursement == null) {
			pw.append("Invalid reimbursement ID");
		} else {
			pw.append("You have successfully denied a remiburement");
//			pw.append(gson.toJson(updatedreimbursement));
		}
	}

	public void getReimbursementsByAmount(HttpServletRequest request, HttpServletResponse response) throws IOException {

//		String amount = request.getParameter("amount");
//
//		double amo = Double.parseDouble(amount);

		List<Reimbursement> reimbursements = es.getReimbursementForAmount();

		PrintWriter pw = response.getWriter();

		Gson gson = new Gson();

		pw.append(gson.toJson(reimbursements));

	}

	public void getReimbursementsByDate(HttpServletRequest request, HttpServletResponse response) throws IOException {

//		String date = request.getParameter("date");

		Gson gson = new Gson();

//		Date da = gson.fromJson(date, Date.class);

		List<Reimbursement> reimbursements = es.getReimbursementsForDate();

		PrintWriter pw = response.getWriter();

		pw.append(gson.toJson(reimbursements));

	}
}
