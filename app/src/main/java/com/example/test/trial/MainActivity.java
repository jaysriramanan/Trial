package com.example.test.trial;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button button,button2;
    ConstraintLayout constraintLayout;
    ConstraintSet constraintSet;
    TextView child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout=findViewById(R.id.constraintLayout);

        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTextView();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CustomSpinner.class);
                startActivity(intent);
            }
        });
    }

    public void addTextView(){
        int prevId;
        if(child!=null){
            prevId=child.getId();
        }
        else{
            prevId=0;
        }
        child = new TextView(this);
        child.setText("This is a sample text");
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        child.setLayoutParams(params);
        child.setId(View.generateViewId());
        child.setTextSize(24f);
        constraintLayout.addView(child);
        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(child.getId(), ConstraintSet.START, prevId, ConstraintSet.START);
        constraintSet.connect(child.getId(), ConstraintSet.END, prevId, ConstraintSet.END);
        //constraintSet.connect(child.getId(), ConstraintSet.BOTTOM, R.id.button, ConstraintSet.TOP);
        if(prevId==0) {
            constraintSet.connect(child.getId(), ConstraintSet.TOP, prevId, ConstraintSet.TOP);
        }
        else{
            constraintSet.connect(child.getId(), ConstraintSet.TOP, prevId, ConstraintSet.BOTTOM);
        }
        constraintSet.applyTo(constraintLayout);
    }
}
