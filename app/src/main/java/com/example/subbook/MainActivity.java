package com.example.subbook;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public SubList subList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subList = new SubList();
    }

    public void onClick(View view){
        Intent newSub= new Intent(this, NewSubscription.class);

        startActivityForResult(newSub, 5);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 5) {
            Subscription newSubscription = (Subscription) data.getExtras().get("newSub");
            subList.newSub(newSubscription);
            Toast toast = new Toast(getApplicationContext());
            toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT);
        }
    }

}
