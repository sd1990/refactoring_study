package org.songdan.refactoring.chap1.after;

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
        for (Rental rental : rentals) {
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.getCharge())
                    .append("\n");
        }
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("Your earned ").append(getTotalFrequentPoints()).append(" frequent renter points");
        return result.toString();
    }

    /**
     * 用来打印客户的租赁情况，金额，以及积分，返回相关的HTML字符串<br/>
     * 抽取可复用的代码后，添加新功能变得很简单,只需要更改表头，表尾就可以
     * @return HTML字符串
     */
    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<H1>Rentals for <EM>").append(getName()).append("<EM></H1>\n");
        for (Rental rental : rentals) {
            result.append(rental.getMovie().getTitle()).append(":").append(rental.getCharge())
                    .append("<br/>\n");
        }
        result.append("<P>Amount owed <EM>").append(getTotalCharge()).append("</EM></P>\n");
        result.append("<P>On this rental Your earned <EM>").append(getTotalFrequentPoints()).append("<EM> frequent renter points</P>");
        return result.toString();
    }

    /**
     * 获取所有的租金；<br/>
     * 用于去除临时变量
     * @return 所有的租金
     */
    public double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getCharge();
        }
        return result;
    }

    public int getTotalFrequentPoints() {
        int result = 0;
        for (Rental rental : rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }


}
