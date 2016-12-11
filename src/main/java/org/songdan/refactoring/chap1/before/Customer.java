package org.songdan.refactoring.chap1.before;

import java.util.ArrayList;
import java.util.List;

/**
 * 消费者类
 * Created by SongDan on 2016/12/11.
 */
public class Customer {

    private List<Rental> rentals = new ArrayList<>();

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    /**
     * 用来打印客户的租赁情况，金额，以及积分，返回相关的报表字符串
     * @return
     */
    public String statement() {
        StringBuilder result = new StringBuilder("Rental Recode for ").append(getName()).append("\n");
        /*
        1、遍历所有的租赁对象，获取每一部movie的租金和对应的积分
        2、对租金和积分进行累加
        3、返回对应的字符串
         */
        double totalAmount = 0d;
        //积分
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            int priceCode = rental.getMovie().getPriceCode();
            //租金
            double thisAmount = 0d;
            //由于每一个movie的租金和积分计算都是有movie.priceCode决定的，所以要条件判断
            switch (priceCode) {
                case Movie.REGULAR:
                    thisAmount+=2;
                    if (rental.getDaysRented()>2) {
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (rental.getDaysRented()>3) {
                        thisAmount += (rental.getDaysRented() - 3)*1.5;
                    }
                    break;
                default:
                    break;
            }
            //计算积分
            frequentRenterPoints++;
            if (rental.getMovie().getPriceCode()==Movie.NEW_RELEASE&&rental.getDaysRented()>1) {
                frequentRenterPoints++;
            }
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("Your earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }
}
