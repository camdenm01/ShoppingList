package com.example.shoppinglist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    //list of 10 textview items
    private final TextView[] items = new TextView[10];
    //list of strings for the textviews to pull from
    private ArrayList<String> shoppingItems = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add each textview to the array
        items[0] = findViewById(R.id.textView);
        items[1] = findViewById(R.id.textView2);
        items[2] = findViewById(R.id.textView3);
        items[3] = findViewById(R.id.textView4);
        items[4] = findViewById(R.id.textView5);
        items[5] = findViewById(R.id.textView6);
        items[6] = findViewById(R.id.textView7);
        items[7] = findViewById(R.id.textView8);
        items[8] = findViewById(R.id.textView9);
        items[9] = findViewById(R.id.textView10);

        if(savedInstanceState != null){
            shoppingItems = savedInstanceState.getStringArrayList("ShoppingList");
            int i;
            //for each textview that has an item, make it visible and retrieve it's text upon creation
            if (shoppingItems != null && shoppingItems.size() > 0){
                for(i = 0; i < shoppingItems.size(); i++){
                    items[i].setVisibility(View.VISIBLE);
                    items[i].setText(shoppingItems.get(i));
                }
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        if(shoppingItems.size() != 0) {
            outState.putStringArrayList("ShoppingList", shoppingItems);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @NonNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String addedItem = data.getStringExtra(SecondActivity.EXTRA_ADD);
                shoppingItems.add(addedItem);
                //same loop as in onCreate to make all appropriate items visible and with correct text
                for(int i = 0; i < shoppingItems.size(); i++){
                    items[i].setVisibility(View.VISIBLE);
                    items[i].setText(shoppingItems.get(i));
                }
            }
        }
    }

    public void addShoppingItem(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}