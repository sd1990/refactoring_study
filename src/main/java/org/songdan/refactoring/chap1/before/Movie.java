package org.songdan.refactoring.chap1.before;

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
    }
}
