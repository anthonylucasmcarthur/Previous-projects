package dev.mcarthur.entities;

import java.util.Date;

public class Reimbursement {

	private int r_id;
	private int e_id;
	private double amount;
	private Date date;
	private String status;
	private String comment;
	private String managercomment;
	
	
	
	public Reimbursement() {
		super();
		
	}

	public Reimbursement(int r_id, int e_id, double amount, Date date, String status, String comment, String managercomment) {
		super();
		this.r_id = r_id;
		this.e_id = e_id;
		this.amount = amount;
		this.status = status;
		this.comment = comment;
		this.setManagercomment(managercomment);
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getManagercomment() {
		return managercomment;
	}

	public void setManagercomment(String managercomment) {
		this.managercomment = managercomment;
	}

	@Override
	public String toString() {
		return "Reimbursement [r_id=" + r_id + ", e_id=" + e_id + ", amount=" + amount + ", date=" + date + ", status="
				+ status + ", comment=" + comment + ", managercomment=" + managercomment + "]";
	}

	

	
	
	

	
	
	
	
}
