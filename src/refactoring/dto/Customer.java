package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals;

	public Customer(String name) {
		super();
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	
	public void addRental(Rental aRental){
		this.rentals.add(aRental);
	}
	
	public String statement(){
		//대여료와  적립포인트 출력
		double totalAmount=0;//총대여료
		int frequentRanterPoints=0;//적립포인트


		StringBuilder sb = new StringBuilder();
		sb.append(getName() + "고객님의 대여기록\n");
		for(Rental each : rentals){
			double thisAmount = amountFor(each);	// 대여료 계산

			frequentRanterPoints ++;
			if(each.getMovie().getPriceCode()==Movie.NEW_RELEASE && each.getDaysRented()>1){
				frequentRanterPoints ++;
			}

			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), thisAmount));
			totalAmount += thisAmount;
		}//for loop

		sb.append(String.format("누적대여료 : %s%n 적립포인트 : %s%n", totalAmount,frequentRanterPoints));
		return sb.toString();
	}

	private double amountFor(Rental aRantal) {	
		//비디오물당 대여료 
		//1.일반물(2일)2000원,일일초과당1500원,적립1 ==> (2일 3000원) 일일초과2000, 적립 1
		//2.아동물(3일)1500원,일일초과당1500,적립1 ==> (2일 2000원) 일일초과1500, 적립 1
		//3.최신물(1일)3000원, 일일초과 3000,적립1+1	==> (2일 4000원) 일일초과4000, 적립 1+1
		//4.Html 출력형식을 요구.
		double result = 0;
		Movie movie = aRantal.getMovie();
		int priceCode = movie.getPriceCode();
		int daysRented = aRantal.getDaysRented();	//해당 비디오물의 대여 기간 

		switch(priceCode){
		case Movie.REGULAR:
			result = 0000;
			if(daysRented>2){
				result+=(daysRented-2)*1500;
			}
			break;
		case Movie.NEW_RELEASE:
			result = daysRented*4000;
			break;
		case Movie.CHILDREN:
			result = 1500;
			if(daysRented>3){
				result+=(daysRented-3)*1500;
			}
			break;
		}
		return result;
	}

	
	/******************************* 클라이언트 요구사항 *******************************/
	public String htmlStatement(){
		//대여료와  적립포인트 출력
		double totalAmount=0;//총대여료
		int frequentRanterPoints=0;//적립포인트


		StringBuilder sb = new StringBuilder();
		sb.append(getName() + "고객님의 대여기록\n");
		for(Rental each : rentals){
			double thisAmount = 0;	//비디오물당 대여료 
			//1.일반물(2일)2000원,일일초과당1500원,적립1 ==> (2일 3000원) 일일초과2000, 적립 1
			//2.아동물(3일)1500원,일일초과당1500,적립1 ==> (2일 2000원) 일일초과1500, 적립 1
			//3.최신물(1일)3000원, 일일초과 3000,적립1+1	==> (2일 4000원) 일일초과4000, 적립 1+1
			//4.Html 출력형식을 요구.
			Movie movie = each.getMovie();
			int priceCode = movie.getPriceCode();
			int daysRented = each.getDaysRented();	//해당 비디오물의 대여 기간 

			switch(priceCode){
			case Movie.REGULAR:
				thisAmount = 3000;
				if(daysRented>2){
					thisAmount+=(daysRented-2)*2000;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount = daysRented*4000;
				break;
			case Movie.CHILDREN:
				thisAmount = 2000;
				if(daysRented>3){
					thisAmount+=(daysRented-3)*1500;
				}
				break;
			}
			frequentRanterPoints ++;
			if(each.getMovie().getPriceCode()==Movie.NEW_RELEASE && each.getDaysRented()>1){
				frequentRanterPoints ++;
			}

			sb.append(String.format("nbsp;nbsp;%s nbsp;nbsp;%s<br>", each.getMovie().getTitle(), thisAmount));
			totalAmount += thisAmount;
		}//for loop

		sb.append(String.format("<p>누적대여료 : <Em>%s</em><br> 적립포인트 : <em>%s</em><br>", totalAmount,frequentRanterPoints));
		return sb.toString();		
	}
}

