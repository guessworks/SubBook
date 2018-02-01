
/*
 *
 * SubListAdapter
 *
 * January 30, 2018
 *
 * Copyright (c) 2018 Lauren H.-Leblanc, CMPUT 301,
 * University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions
  * of the Code of Student Behaviour at the University of Alberta.
 */

package com.example.subbook;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Represents an ArrayAdapter that deals with a SubList object.
 *
 * @author Lauren HL
 * @see SubList
 * @see Subscription
 * @see NewSubscription
 * @see MainActivity
 */
public class SubListAdapter extends ArrayAdapter {
    /*
     * code adapted from
     * https://appsandbiscuits.com/listview-tutorial-android-12-ccef4ead27cc
     */
    private Activity context;
    private SubList subList;

    public SubListAdapter(Activity context, SubList subList){

        super(context,R.layout.listviewrow , (List) subList);
        this.subList = subList;

    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listviewrow, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView SubName = (TextView) rowView.findViewById(R.id.subListTitle);
        TextView SubDate = (TextView) rowView.findViewById(R.id.subListDate);
        TextView SubCharge = (TextView) rowView.findViewById(R.id.subListCharge);
        TextView SubComment = (TextView) rowView.findViewById(R.id.SubListComment);

        //this code sets the values of the objects to values from the arrays
        SubName.setText(subList.getSubName(position));
        SubDate.setText(subList.getSubDate(position).toString());
        SubCharge.setText(subList.getSubDate(position).toString());
        SubComment.setText(subList.getSubComment(position));

        return rowView;
    }
}

