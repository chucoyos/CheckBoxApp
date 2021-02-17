package com.example.checkboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    CheckBox checkBox1, checkBox2;
    Button button;
    TextView textView;

    @SuppressLint("DefaultLocale")
    public void calculateValue(View view) {
        if (TextUtils.isEmpty(et1.getText().toString()) || TextUtils.isEmpty(et2.getText().toString())) {
            textView.setText(R.string.valid_input);
        } else {

            String input1 = et1.getText().toString();
            String input2 = et2.getText().toString();

            int value1 = Integer.parseInt(input1);
            int value2 = Integer.parseInt(input2);

            int addValues = value1 + value2;
            int subtractValues = value1 - value2;

            if (checkBox1.isChecked() && !checkBox2.isChecked()) {
                textView.setText(String.format("%s%d", getResources().getText(R.string.add_result), addValues));
            } else if (checkBox2.isChecked() && !checkBox1.isChecked()) {
                textView.setText(String.format("%s%d", getResources().getText(R.string.subtract_result), subtractValues));
            } else if (checkBox1.isChecked() && checkBox2.isChecked()) {
                textView.setText(String.format("%s%d%s%d", getResources().getText(R.string.add_result), addValues,
                        getResources().getText(R.string.subtract_result), subtractValues));
            } else {
                textView.setText(R.string.empty_box);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
    }
}