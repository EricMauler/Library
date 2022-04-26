package fr.fms.entities;

public class Cart {
	private int id;
	private double total;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cart(int id, double total) {
		super();
		this.id = id;
		this.total = total;
	}
	
}
