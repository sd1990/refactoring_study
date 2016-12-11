package org.songdan.refactoring.chap1.after;

/**
 * 为了应对计费规则的改变，创建Price类型，不同movie.priceCode的计费规则是不同的
 * Created by SongDan on 2016/12/11.
 */
public abstract class Price {

    public abstract double getCharge(int rentalDays);

    public int getFrequestPoints(int rentalDays){
        return 1;
    }
}
