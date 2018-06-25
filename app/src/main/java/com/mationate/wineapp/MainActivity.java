package com.mationate.wineapp;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.mationate.wineapp.models.Wine;

public class MainActivity extends AppCompatActivity {

    private MainActivityFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_wine);

                ImageButton button = dialog.findViewById(R.id.saveWineBtn);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText inputName = dialog.findViewById(R.id.nameEt);
                        EditText inputAge = dialog.findViewById(R.id.yearEt);
                        EditText inputType = dialog.findViewById(R.id.typeEt);
                        String name = inputName.getText().toString();
                        String year = inputAge.getText().toString();
                        String type = inputType.getText().toString();


                        if (name.trim().length() > 0) {

                            Wine wine = new Wine();
                            wine.setWineName(name);
                            wine.setWineYear(year);
                            wine.setWineType(type);
                            wine.save();
                            fragment.updateList(wine);
                        }
                        dialog.dismiss();

                    }
                });

                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });
    }


}
