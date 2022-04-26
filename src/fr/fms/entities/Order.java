package fr.fms.entities;

import java.util.Date;

public class Order {
	private int idOrder;
	private double totalAmount;
	private Date date;
	
	public Order(int idOrder, double totalAmount, Date date) {
		super();
		this.idOrder = idOrder;
		this.totalAmount = totalAmount;
		this.date = date;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
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
	
	
}
