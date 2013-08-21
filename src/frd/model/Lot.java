package frd.model;

import java.util.Date;
import java.util.List;

public class Lot {
	private int idLot;
	private int idProduct;
	private Date createDate;
	private Date dueDate;
	private int initialAmount;
	private int currentAmount;
	private List<Movement> movements;
	
	public Lot(){}

	public int getidLot() {
		return idLot;
	}
	public void setidLot(int idLot) {
		this.idLot = idLot;
	}	
	public int getidProduct() {
		return idProduct;
	}
	public void setidProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public int getInitialAmount() {
		return initialAmount;
	}
	public void setInitialAmount(int initialAmount) {
		this.initialAmount = initialAmount;
	}
	public int getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}
	public List<Movement> getMovements() {
		return movements;
	}
	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}	
}
