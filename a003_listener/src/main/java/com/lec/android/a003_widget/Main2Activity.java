package com.lec.android.a003_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText edit;

    Button division, plus, equal, multi, sub;
    Button cancel;

    String number;

    int value;
    int DIVISION = 0;
    int PLUS = 1;
    int MULTI = 2;
    int SUB = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edit = (EditText)findViewById(R.id.edit);
        number = "";


        division = (Button)findViewById(R.id.btn_division);
        plus = (Button)findViewById(R.id.btn_plus);
        equal = (Button)findViewById(R.id.btn_result);
        sub = (Button)findViewById(R.id.btn_sub);
        multi = (Button)findViewById(R.id.btn_multi);

        division.setOnClickListener(mListener);
        plus.setOnClickListener(mListener);
        equal.setOnClickListener(mListener);
        sub.setOnClickListener(mListener);
        multi.setOnClickListener(mListener);

        cancel = (Button)findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                number = "";
                edit.setText("");
            }
        });
    }

    Button.OnClickListener mListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch(v.getId()){
                case R.id.btn_division :
                    number = edit.getText().toString();
                    edit.setText("");
                    value = DIVISION;
                    Toast.makeText(Main2Activity.this, "/", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_plus :
                    number = edit.getText().toString();
                    edit.setText("");
                    value = PLUS;
                    Toast.makeText(Main2Activity.this, "+", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_sub :
                    number = edit.getText().toString();
                    edit.setText("");
                    value = SUB;
                    Toast.makeText(Main2Activity.this, "-", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_multi :
                    number = edit.getText().toString();
                    edit.setText("");
                    value = MULTI;
                    Toast.makeText(Main2Activity.this, "*", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_result :
                    if (value == MULTI) {
                        edit.setText("" + (Double.parseDouble(number) * Double.parseDouble(edit.getText().toString())));
                    } else if (value == SUB){
                        edit.setText("" + (Double.parseDouble(number) - Double.parseDouble(edit.getText().toString())));
                    } else if (value == PLUS){
                        edit.setText("" + (Double.parseDouble(number) + Double.parseDouble(edit.getText().toString())));
                    } else if (value == DIVISION){
                        edit.setText("" + (Double.parseDouble(number) / Double.parseDouble(edit.getText().toString())));
                    }
                    number = edit.getText().toString();
                    break;
            }
        }
    };


    public void onClick (View v)
    {
        switch(v.getId()){
            case R.id.btn_0 : edit.setText(edit.getText().toString() + 0); break;
            case R.id.btn_1 : edit.setText(edit.getText().toString() + 1); break;
            case R.id.btn_2 : edit.setText(edit.getText().toString() + 2); break;
            case R.id.btn_3 : edit.setText(edit.getText().toString() + 3); break;
            case R.id.btn_4 : edit.setText(edit.getText().toString() + 4); break;
            case R.id.btn_5 : edit.setText(edit.getText().toString() + 5); break;
            case R.id.btn_6 : edit.setText(edit.getText().toString() + 6); break;
            case R.id.btn_7 : edit.setText(edit.getText().toString() + 7); break;
            case R.id.btn_8 : edit.setText(edit.getText().toString() + 8); break;
            case R.id.btn_9 : edit.setText(edit.getText().toString() + 9); break;
        }
    }
}



