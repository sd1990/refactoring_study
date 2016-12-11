package org.songdan.refactoring.chap1.after;

/**
 * Created by SongDan on 2016/12/11.
 */
public class RegularPrice extends Price {

    @Override
    public double getCharge(int rentalDays) {
        double thisAmount = 0;
        thisAmount += 2;
        if (rentalDays > 2) {
            thisAmount += (rentalDays - 2) * 1.5;
        }
        return thisAmount;
    }

}
