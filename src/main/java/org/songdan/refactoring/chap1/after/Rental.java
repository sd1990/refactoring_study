package org.songdan.refactoring.chap1.after;

/**
 * 租赁类
 * Created by SongDan on 2016/12/11.
 */
public class Rental {

    private Movie movie;

    private int daysRented;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    /**
     * 获取租金
     * @return
     */
    public double getCharge() {
        return movie.getCharge(getDaysRented());
    }

    /**
     * 获取积分
     * @return
     */
    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if (this.getMovie().getPriceCode() == Movie.NEW_RELEASE && this.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
