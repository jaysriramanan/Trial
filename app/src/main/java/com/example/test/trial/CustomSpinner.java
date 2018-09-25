package com.example.test.trial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomSpinner extends AppCompatActivity {
    private ArrayList<SpinnerItem> spinnerList;
    private  CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_spinner);

        initList();

        Spinner spinner=findViewById(R.id.spinner);
        customAdapter=new CustomAdapter(this,spinnerList);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerItem clickedItem=(SpinnerItem)adapterView.getItemAtPosition(i);
                String text="You have choosen a "+clickedItem.getName();
                Toast.makeText(CustomSpinner.this,text,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initList(){
        spinnerList=new ArrayList<>();
        spinnerList.add(new SpinnerItem("Basketball",R.drawable.basketball));
        spinnerList.add(new SpinnerItem("Throwball",R.drawable.throwball));
        spinnerList.add(new SpinnerItem("Volleyball",R.drawable.volleyball));
        spinnerList.add(new SpinnerItem("Ping Pong",R.drawable.ttball));
        spinnerList.add(new SpinnerItem("Baseball",R.drawable.baseball));
        spinnerList.add(new SpinnerItem("Shot Put",R.drawable.shot_put_ball));
    }
}
