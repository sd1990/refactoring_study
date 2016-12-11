package org.songdan.refactoring.chap1.after;

/**
 * Created by SongDan on 2016/12/11.
 */
public class NewReleasePrice extends Price {

    @Override
    public double getCharge(int rentalDays) {
        double thisAmount = 0;
        return thisAmount += rentalDays * 3;
    }

    @Override
    public int getFrequestPoints(int rentalDays) {
        return (rentalDays > 1) ? 2 : 1;
    }
}
