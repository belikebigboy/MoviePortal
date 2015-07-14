package io.spring.movieportal.model.order;


import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private String orderNo;
    private int userId;
    private Date orderDate;
    private List<OrderLine> orderLines;
    private boolean isLimited;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public boolean isLimited() {
        return isLimited;
    }

    public void setIsLimited(boolean isLimited) {
        this.isLimited = isLimited;
    }
}
