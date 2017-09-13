package com.yous.learningtwo.host;

import java.sql.Timestamp;

/**
 * Created by syou on 2017/9/10.
 */
public class Order {
    private int orderId;
    private Timestamp bookingTime;
    private String content;

    public Order(int orderId,Timestamp bookingTime,String content){
        this.orderId=orderId;
        this.bookingTime=bookingTime;
        this.content=content;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Timestamp bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
