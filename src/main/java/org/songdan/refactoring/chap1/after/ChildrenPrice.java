package org.songdan.refactoring.chap1.after;

/**
 * Created by SongDan on 2016/12/11.
 */
public class ChildrenPrice extends Price {

    @Override
    public double getCharge(int rentalDays) {
        double thisAmount = 1.5;
        if (rentalDays>3) {
            thisAmount += (rentalDays - 3)*1.5;
        }
        return thisAmount;
    }

}
