package fr.fms.entities;

import java.util.Date;

public class Order {
	private int IdOrder;
	private int IdCustomer;
	private double totalAmount;
	private Date date;
	
	public Order(double totalAmount, Date date, int IdCustomer) {
		super();
		this.totalAmount = totalAmount;
		this.date = date;
		this.setIdCustomer(IdCustomer);
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdCustomer() {
		return IdCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		IdCustomer = idCustomer;
	}

	public int getIdOrder() {
		return IdOrder;
	}
	
	
}
