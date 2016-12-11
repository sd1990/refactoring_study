package org.songdan.refactoring.chap1.before;

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
}
