package refactoring.price;

import refactoring.dto.Movie;

public class PriceFactory {
	public static Price getPrice(int priceCode){
		Price price = null;
			switch(priceCode){
			case Price.CHILDREN:
				price =new ChildrenPrice();
				break;
			case Price.REGULAR:
				price = new ReqularPrice();
				break;
			case Price.NEW_RELEASE:
				price = new NewReleasePrice();
				break;
			case Price.ADULT:
				price = new AdultPrice();
				break;
			default:
				throw new IllegalArgumentException("가격 코드가 잘못되었습니다.");
			}
			return price;		
	}
}
