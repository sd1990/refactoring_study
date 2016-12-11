package org.songdan.refactoring.chap1.after;

/**
 * 影片类
 * Created by SongDan on 2016/12/11.
 */
public class Movie {

    public static final int REGULAR = 0;

    public static final int NEW_RELEASE = 1;

    public static final int CHILDREN = 2;

    private String title;

    private int priceCode;

    private Price price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
        switch (priceCode) {
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case Movie.CHILDREN:
                price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public double getCharge(int rentalDays) {
        return price.getCharge(rentalDays);
    }

    public int getFrequentPoint(int rentalDays) {
        return price.getFrequestPoints(rentalDays);
    }
}
