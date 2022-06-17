package com.example.chetnechet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView res;
    EditText num;
    RadioButton chet, neChet, allNum;
    Button addNum;
    int val, size, check=3;
    String number = "";
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = findViewById(R.id.result);
        num = findViewById(R.id.value);
        addNum = findViewById(R.id.addNum);

        chet = findViewById(R.id.chet);
        chet.setOnClickListener(radioButtonClickListener);
        neChet = findViewById(R.id.neChet);
        neChet.setOnClickListener(radioButtonClickListener);
        allNum = findViewById(R.id.allNum);
        allNum.setOnClickListener(radioButtonClickListener);

    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            switch (rb.getId()) {
                case R.id.chet:
                    check = 1;
                    render();
                    break;
                case R.id.neChet:
                    check = 2;
                    render();
                    break;
                case R.id.allNum:
                    check = 3;
                    render();
                    break;
                default:
                    break;
            }
        }
    };

    public void addNumbers(View view) {

        String value2 = num.getText().toString();
        val=Integer.parseInt(value2);

        //добавление
        numbers.add(val);
        size = numbers.size();
        render();

    }

    private void render() {
        if(check == 1){
            number = "";
            for (int i = 0; i < size; i++){
                if (numbers.get(i) % 2 == 0)
                    number = number + numbers.get(i) + ", ";
            }
            res.setText(number);
        }
        if(check == 2){
            number = "";
            for (int i = 0; i < size; i++){
                if (numbers.get(i) % 2 != 0)
                    number = number + numbers.get(i) + ", ";
            }
            res.setText(number);
        }
        if(check == 3){
            number = "";
            for (int i = 0; i < size; i++){
                number = number + numbers.get(i) + ", ";
            }
            res.setText(number);
        }
    }
}