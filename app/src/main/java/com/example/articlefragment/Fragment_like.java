package com.example.articlefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_like extends Fragment {

    public Fragment_like() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View sendView = inflater.inflate(R.layout.fragment_like, container, false);
        final RadioGroup radioGroup = sendView.findViewById(R.id.radioGroupId);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                   //   View radioButton =    radioGroup.findViewById(checkedId);

                 // int index = radioGroup.indexOfChild(radioButton);
                // radioButton.getId()

               int btnID = group.getCheckedRadioButtonId();

             TextView textView = sendView.findViewById(R.id.textId);

             switch (btnID)
             {
                 case R.id.radioYes:
                     textView.setText("YES");
                     break;

                 case R.id.radioNo:
                     textView.setText("Thanks");
                     break;

                 default:
                     textView.setText("Nothing is implemented");
                     break;
             }



            }
        });
        return sendView;
    }
}