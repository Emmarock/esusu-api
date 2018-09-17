package com.emmarock.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

public class Contribution implements Serializable{
    @Id
    private String id;
    private String amount;
    private Date date;
    private String contributorId;
    private String notificationStatus;
    private String transactionType;

    public Contribution() {
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getContributorId() {
        return contributorId;
    }

    public void setContributor(String contributorId) {
        this.contributorId = contributorId;
    }
}
