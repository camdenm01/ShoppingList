package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_ADD = "com.example.android.shoppinglist.extra.ADD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }


    public void addCheese(View view){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ADD, "Cheese");
        setResult(RESULT_OK, intent);
        finish();
    }
    public void addRice(View view){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ADD, "Rice");
        setResult(RESULT_OK, intent);
        finish();
    }
    public void addApples(View view){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ADD, "Apples");
        setResult(RESULT_OK, intent);
        finish();
    }
    public void addMilk(View view){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ADD, "Milk");
        setResult(RESULT_OK, intent);
        finish();
    }
    public void addBread(View view){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ADD, "Bread");
        setResult(RESULT_OK, intent);
        finish();
    }
}