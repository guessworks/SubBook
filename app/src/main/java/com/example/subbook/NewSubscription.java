/*
 *
 * NewSubscription
 *
 * January 24, 2018
 *
 * Copyright (c) 2018 Lauren H.-Leblanc, CMPUT 301,
 * University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions
  * of the Code of Student Behaviour at the University of Alberta.
 */

package com.example.subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/**
 * A subactivity which allows the user to enter a new subscription.
 *
 * @author Lauren H.-L.
 * @see Subscription
 * @see SubList
 * @see MainActivity
 */
public class NewSubscription extends AppCompatActivity {

    private String name;
    private Date date;
    private Double charge;
    private String comment;
    private Subscription sub;

    /**
     * On creation of the activity, it displays the layout.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_subscription);
    }

    /**
     * Called when the "add" button is clicked. Interprets the user entered
     * text and sends it back to MainActivity.
     *
     * @param view
     */
    public void onClick(View view){
        int error;

        this.getInput();
        try {
            this.checkInput();
            //no errors, continue
            sub = new Subscription(charge, date, name, comment);
            Intent returnData = new Intent();
            returnData.putExtra("newSub", sub);
            setResult(RESULT_OK, returnData);
            finish();
        }
        catch(NegativeChargeException ex){
            //shows a message
            Toast toast = new Toast(getApplicationContext());
            toast.makeText(getApplicationContext(), "Monthly Charge can't be negative", Toast.LENGTH_SHORT);
        }
        catch(EmptyFieldException ex){
            //implement
            Toast toast = new Toast(getApplicationContext());
            toast.makeText(getApplicationContext(), "Name, Date, and Monthly charge cannot be left blank.", Toast.LENGTH_SHORT);
        }
    }

    /**
     * Gets the user entered text from the view objects and places it in variables.
     */
    public void getInput() {
        EditText editText = (EditText) findViewById(R.id.editText);
        name = editText.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        date = (Date) editText2.getText();
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String temp = editText3.getText().toString();
        charge = Double.parseDouble(temp);
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        comment = editText5.getText().toString();
    }

    /**
     * Throws exception if user entered text is invalid.
     *
     * @throws NegativeChargeException Thrown if monthly charge is negative.
     * @throws EmptyFieldException Thrown if an essential field is empty.
     */
    public void checkInput() throws NegativeChargeException, EmptyFieldException {
        if (charge < 0) {
            throw new NegativeChargeException();
        }
        if ((name.length() == 0) || (charge == 0.00) || (date == null)){
            throw new EmptyFieldException();
        }
        if (comment.length() == 0){
            comment = "";
        }
    }
}
