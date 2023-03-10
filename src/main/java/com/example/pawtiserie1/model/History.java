package com.example.pawtiserie1.model;


import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {

    public enum Status{
        Pregatire("In preparation"),
        Livrare("Delivery in progress"),
        Livrat("Delivered :)");
        public final String label;
        private Status(String label){
            this.label = label;
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyId;

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryAddress delivery;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "data")
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public DeliveryAddress getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryAddress delivery) {
        this.delivery = delivery;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public History(DeliveryAddress delivery, Status status, Date data) {
        this.delivery = delivery;
        this.status = status;
        this.data = data;
    }

    public History(Status status, Date data){
        this.status = status;
        this.data = data;
    }

    public History() {
    }
}
