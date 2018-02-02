package com.example.subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class NewSubscription extends AppCompatActivity {

    private String name;
    private Date date;
    private Double charge;
    private String comment;
    private Subscription sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_subscription);
    }




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

    public void getInput() {
        //transfers user input to local variables upon clicking the "add" button
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

    public void checkInput() throws NegativeChargeException, EmptyFieldException {
        //checks validity of input
        if (charge < 0) {
            throw new NegativeChargeException(); //to implement
        }
        if ((name.length() == 0) || (charge == 0.00) || (date == null)){
            throw new EmptyFieldException(); //to implement
        }
        if (comment.length() == 0){
            comment = "";
        }
    }
}
