package org.songdan.refactoring.chap1.test;

import org.junit.Assert;
import org.junit.Test;
import org.songdan.refactoring.chap1.before.Customer;
import org.songdan.refactoring.chap1.before.Movie;
import org.songdan.refactoring.chap1.before.Rental;

/**
 * 测试，保证重构的正确性
 * Created by SongDan on 2016/12/11.
 */
public class CustomerTest {

    @Test
    public void testStatement() {
        Customer bCustomer = new Customer("小明");
        Movie regular = new Movie();
        regular.setTitle("regular movie");
        regular.setPriceCode(Movie.REGULAR);
        Rental rental1 = new Rental();
        rental1.setMovie(regular);
        rental1.setDaysRented(5);
        bCustomer.addRental(rental1);
        Movie newRealse = new Movie();
        newRealse.setTitle("newRelease movie");
        newRealse.setPriceCode(Movie.NEW_RELEASE);
        Rental rental2 = new Rental();
        rental2.setMovie(newRealse);
        rental2.setDaysRented(2);
        bCustomer.addRental(rental2);
        Movie children = new Movie();
        children.setTitle("children movie");
        children.setPriceCode(Movie.CHILDREN);
        Rental rental3 = new Rental();
        rental3.setMovie(children);
        rental3.setDaysRented(4);
        bCustomer.addRental(rental3);
        String expectResult = bCustomer.statement();
        System.out.println(expectResult);
        //----------------------------------
        org.songdan.refactoring.chap1.after.Customer aCustomer = new org.songdan.refactoring.chap1.after.Customer("小明");
        org.songdan.refactoring.chap1.after.Movie aRegular = new org.songdan.refactoring.chap1.after.Movie();
        aRegular.setTitle("regular movie");
        aRegular.setPriceCode(Movie.REGULAR);
        org.songdan.refactoring.chap1.after.Rental aRental1 = new org.songdan.refactoring.chap1.after.Rental();
        aRental1.setMovie(aRegular);
        aRental1.setDaysRented(5);
        aCustomer.addRental(aRental1);
        org.songdan.refactoring.chap1.after.Movie aNewRealse = new org.songdan.refactoring.chap1.after.Movie();
        aNewRealse.setTitle("newRelease movie");
        aNewRealse.setPriceCode(Movie.NEW_RELEASE);
        org.songdan.refactoring.chap1.after.Rental aRental2 = new org.songdan.refactoring.chap1.after.Rental();
        aRental2.setMovie(aNewRealse);
        aRental2.setDaysRented(2);
        aCustomer.addRental(aRental2);
        org.songdan.refactoring.chap1.after.Movie aChildren = new org.songdan.refactoring.chap1.after.Movie();
        aChildren.setTitle("children movie");
        aChildren.setPriceCode(Movie.CHILDREN);
        org.songdan.refactoring.chap1.after.Rental aRental3 = new org.songdan.refactoring.chap1.after.Rental();
        aRental3.setMovie(aChildren);
        aRental3.setDaysRented(4);
        aCustomer.addRental(aRental3);
        Assert.assertEquals(expectResult,aCustomer.statement());
    }

}
