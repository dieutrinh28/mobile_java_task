package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_popup_menu = findViewById(R.id.btn_popup_menu);
        btn_popup_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String message = item.toString();
        switch (item.getItemId()) {
            case R.id.option_settings:
            case R.id.option_favourites:
            case R.id.sub_option_email:
            case R.id.sub_option_phone:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message", "You clicked menu item " + message);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }


    private void showPopupMenu(View v) {
        PopupMenu popup_menu = new PopupMenu(MainActivity.this, v);
        popup_menu.getMenuInflater().inflate(R.menu.menu_popup, popup_menu.getMenu());
        popup_menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String message = menuItem.toString();
                switch (menuItem.getItemId()) {
                    case R.id.popup_reply:
                    case R.id.popup_forward:
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("message", "You clicked menu item " + message);
                        startActivity(intent);
                        return true;
                    default:
                        return false;
                }

            }

        });
        popup_menu.show();
    }





}