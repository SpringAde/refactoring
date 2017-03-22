package refactoring.dto;


import refactoring.price.ChildrenPrice;
import refactoring.price.NewReleasePrice;
import refactoring.price.Price;
import refactoring.price.ReqularPrice;

public class Movie {

	public static final int REGULAR = 1;
	public static final int NEW_RELEASE = 2;
	public static final int CHILDREN = 3;

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
		switch(priceCode){
		case Movie.CHILDREN:
			price =new ChildrenPrice();
			break;
		case Movie.REGULAR:
			price = new ReqularPrice();
			break;
		case Movie.NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("가격 코드가 잘못되었습니다.");
		}
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

