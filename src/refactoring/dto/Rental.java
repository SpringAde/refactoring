package refactoring.dto;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		super();
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public double getCharge() { // 비디오물당 대여료
		// 1.일반물(2일)2000원,일일초과당1500원,적립1 ==> (2일 3000원) 일일초과2000, 적립 1
		// 2.아동물(3일)1500원,일일초과당1500,적립1 ==> (2일 2000원) 일일초과1500, 적립 1
		// 3.최신물(1일)3000원, 일일초과 3000,적립1+1 ==> (2일 4000원) 일일초과4000, 적립 1+1
		// 4.Html 출력형식을 요구.
		double result = 0;

		switch (movie.getPriceCode()) {
		case Movie.REGULAR:
			result = 0000;
			if (daysRented > 2) {
				result += (daysRented - 2) * 1500;
			}
			break;
		case Movie.NEW_RELEASE:
			result = daysRented * 4000;
			break;
		case Movie.CHILDREN:
			result = 1500;
			if (daysRented > 3) {
				result += (daysRented - 3) * 1500;
			}
			break;
		}
		return result;
	}
}
