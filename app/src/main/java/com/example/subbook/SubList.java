package com.example.subbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Claude on 2018-01-22.
 */

public class SubList {
    //has an ArrayList object which contains all created Subscription objects
    //can add, edit, search (by subscription name) and delete subscriptions from the list
    private ArrayList<Subscription> subListObj;

    public SubList(){
        subListObj = new ArrayList<Subscription>();
    }

    public void newSub(Subscription newSubscription) {
        subListObj.add(newSubscription);
    }

    public int searchForSub( String targetName ) {
        //searches for a subscription by name; returns the index of the subscription
        int index;
        boolean found = false;

        for (index = 0; index < subListObj.size(); index++) {
            //iterates through the list and returns the index of the subscription object
            if (Objects.equals(subListObj.get(index).getName(), targetName)) {
                found = true;
                break;
            }
        }
        if (Objects.equals(found, true)) {
            return index;
        }
        else {
            return -1;
        }
    }

    public String getSubName(int index){
        //gets the subscription name based on the index
        return subListObj.get(index).getName();
    }

    public Date getSubDate(int index){
        //gets the subscription date based on the index
        return subListObj.get(index).getDate();
    }

    public Double getSubCharge(int index){
        //gets the subscription charge based on the index
        return subListObj.get(index).getCharge();
    }

    public String getSubComment(int index){
        //gets the subscription charge based on the index
        return subListObj.get(index).getComment();
    }

    public void editSub(int index, Double charge, Date date, String name, String comment){
        //replaces the values of a subscription at a certain index with the supplied values
        subListObj.get(index).setCharge(charge);
        subListObj.get(index).setDate(date);
        subListObj.get(index).setName(name);
        subListObj.get(index).setComment(comment);
    }

    public void deleteSub(int index) {
        //deletes the sub at a particular index (determined by searchForSub())
        subListObj.remove(index);
    }
}
