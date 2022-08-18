package com.aryunin.love.models;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "sender")
    private String sender;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Message() {
    }

    public Message(String sender, String text, Date date) {
        this.sender = sender;
        this.text = text;
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public String getFormatedDate() {
        StringBuilder result = new StringBuilder("");

        // Day
        if (date.getDate() < 10) result.append("0");
        result.append(date.getDate());
        result.append(".");
        // Month
        if (date.getMonth() < 9) result.append("0");
        result.append(date.getMonth() + 1);
        result.append(".");
        // Year
        result.append(date.getYear() + 1900);

        return result.toString();
    }

    public String getFromatedTime() {
        StringBuilder result = new StringBuilder("");

        // Hours
        if(date.getHours() < 10) result.append(0);
        result.append(date.getHours());
        result.append(":");
        // Minutes
        if(date.getMinutes() < 10) result.append(0);
        result.append(date.getMinutes());
        result.append(":");
        // Seconds
        if(date.getSeconds() < 10) result.append(0);
        result.append(date.getSeconds());

        return result.toString();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
