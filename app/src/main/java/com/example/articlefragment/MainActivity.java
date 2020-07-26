package com.example.articlefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button dyBtn;

    boolean isFragmentDisplayed = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dyBtn = findViewById(R.id.btnId);


        dyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isFragmentDisplayed)
                {
                    displayFragment();
                }else
                {
                    closeFragment();
                }
            }
        });




    }

    public void displayFragment()
    {
        DynamicFragment dynamicFragment = DynamicFragment.newInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragmentContainer,dynamicFragment).addToBackStack(null).commit();

        dyBtn.setText(R.string.Closed);

        isFragmentDisplayed = true;

    }

    public void closeFragment()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();

        DynamicFragment dynamicFragment = (DynamicFragment) fragmentManager.findFragmentById(R.id.fragmentContainer);

        if(dynamicFragment!=null)
        {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(dynamicFragment).commit();

            dyBtn.setText(R.string.Open);

            isFragmentDisplayed = false;

        }


    }




}