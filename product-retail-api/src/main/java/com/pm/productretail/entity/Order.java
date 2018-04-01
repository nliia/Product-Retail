package com.pm.productretail.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "product_order")
public class Order extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private AppUser orderCreator;
    private String status;

    @ManyToOne
    @JoinColumn
    private Department orderReciever;

    public AppUser getOrderCreator() {
        return orderCreator;
    }

    public void setOrderCreator(AppUser orderCreator) {
        this.orderCreator = orderCreator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Department getOrderReciever() {
        return orderReciever;
    }

    public void setOrderReciever(Department orderReciever) {
        this.orderReciever = orderReciever;
    }
}
