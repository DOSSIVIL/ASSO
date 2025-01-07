package com.ecommerce.paiement.web.model;


import com.ecommerce.paiement.web.enums.Method;
import com.ecommerce.paiement.web.enums.State;
import jakarta.persistence.*;


@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int transaction_id;
    private int customer_id;
    @Enumerated(EnumType.STRING)
    private Method payment_method;
    @Enumerated(EnumType.STRING)
    private State payment_state;

    public Payment(){

    }

    public Payment(int id, int transaction_id, int customer_id, Method payment_method, State payment_state){
        this.id = id;
        this.transaction_id = transaction_id;
        this.customer_id = customer_id;
        this.payment_method = payment_method;
        this.payment_state = payment_state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Method getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(Method payment_method) {
        this.payment_method = payment_method;
    }

    public State getPayment_state() {
        return payment_state;
    }

    public void setPayment_state(State payment_state) {
        this.payment_state = payment_state;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                ", customer_id=" + customer_id +
                ", payment_method='" + payment_method + '\'' +
                ", payment_state='" + payment_state + '\'' +
                '}';
    }
}
