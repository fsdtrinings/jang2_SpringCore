package com.mkj.bank.entity;

public class Stocks {

	private String stockName;
	private int currentPrice;
	private int purchasePrice;
	private int unitsInHand;
	public Stocks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stocks(String stockName, int currentPrice, int purchasePrice, int unitsInHand) {
		super();
		this.stockName = stockName;
		this.currentPrice = currentPrice;
		this.purchasePrice = purchasePrice;
		this.unitsInHand = unitsInHand;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public int getUnitsInHand() {
		return unitsInHand;
	}
	public void setUnitsInHand(int unitsInHand) {
		this.unitsInHand = unitsInHand;
	}
	@Override
	public String toString() {
		return "Stocks [stockName=" + stockName + ", currentPrice=" + currentPrice + ", purchasePrice=" + purchasePrice
				+ ", unitsInHand=" + unitsInHand + "]";
	}
	
	
}
