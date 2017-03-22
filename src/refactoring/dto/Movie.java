package refactoring.dto;


import refactoring.price.ChildrenPrice;
import refactoring.price.NewReleasePrice;
import refactoring.price.Price;
import refactoring.price.PriceFactory;
import refactoring.price.ReqularPrice;

public class Movie {

	private String title;
	private Price price;


	public Movie(String title, int priceCode) {		
		this.title = title;
		setPriceCode(priceCode);
	}
	
	public int getPriceCode() {
		return price.getPriceCode();
	}
	
	public void setPriceCode(int priceCode) {
		price = PriceFactory.getPrice(priceCode);		// 관련되는 것 만 수정 가능
	}
	
	public String getTitle() {
		return title;
	}

	public double getCharge(int daysRented) {		
		return price.getCharge(daysRented);
	}

	public int getFrequentRentalPoints(int aDaysRented) {
		return price.getFrequentRentalPoints(aDaysRented);
	}
}

