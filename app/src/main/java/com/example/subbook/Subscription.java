package com.example.subbook;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lauren on 2018-01-22.
 */

public class Subscription implements Serializable {

    private Double monthlyCharge;
    private Date dateStarted;
    private String subName;
    private String comment;

    //constructors
    public Subscription( Double charge, Date date, String name, String comment){
        //a value for comment is supplied
        this.monthlyCharge = charge;
        this.dateStarted = date;
        this.subName = name;
        this.comment = comment;
    }

    public Subscription( Double charge, Date date, String name){
        //no comment has been supplied, so it is set to blank
        this.monthlyCharge = charge;
        this.dateStarted = date;
        this.subName = name;
    }

    private Subscription() {
        //leaving all fields blank should not be allowed
        this( 0.0, new Date(), "Default", "");
    }

    //getter methods for all private values
    public Double getCharge() {
        return this.monthlyCharge;
    }

    public Date getDate() {
        return this.dateStarted;
    }

    public String getName() {
        return this.subName;
    }

    public String getComment() {
        return this.comment;
    }


    //setter methods for all private values
    public void setCharge( Double charge ) {
        this.monthlyCharge = charge;
    }

    public void setDate( Date date ) {
        this.dateStarted = date;
    }

    public void setName( String name ){
        this.subName = name;
    }

    public void setComment( String comment ){
        this.comment = comment;
    }
}
