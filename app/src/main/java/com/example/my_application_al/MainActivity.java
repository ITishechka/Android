package com.example.my_application_al;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.my_application_al.R;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private double firstValue = Double.NaN;
    private double secondValue;
    private char currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                display.append(button.getText());
            }
        };

        findViewById(R.id.btn_0).setOnClickListener(numberClickListener);
        findViewById(R.id.btn_1).setOnClickListener(numberClickListener);
        findViewById(R.id.btn_2).setOnClickListener(numberClickListener);
        findViewById(R.id.btn_3).setOnClickListener(numberClickListener);
        findViewById(R.id.btn_4).setOnClickListener(numberClickListener);
        findViewById(R.id.btn_5).setOnClickListener(numberClickListener);
        findViewById(R.id.btn_6).setOnClickListener(numberClickListener);
        findViewById(R.id.btn_7).setOnClickListener(numberClickListener);
        findViewById(R.id.btn_8).setOnClickListener(numberClickListener);
        findViewById(R.id.btn_9).setOnClickListener(numberClickListener);
        findViewById(R.id.btn_dot).setOnClickListener(numberClickListener);

        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
                firstValue = Double.NaN;
                secondValue = Double.NaN;
                currentOperation = ' ';
            }
        });

        findViewById(R.id.btn_plus).setOnClickListener(operationClickListener);
        findViewById(R.id.btn_minus).setOnClickListener(operationClickListener);
        findViewById(R.id.btn_multiply).setOnClickListener(operationClickListener);
        findViewById(R.id.btn_divide).setOnClickListener(operationClickListener);

        findViewById(R.id.btn_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Double.isNaN(firstValue)) {
                    String text = display.getText().toString();
                    if (!text.equals("")) {
                        secondValue = Double.parseDouble(text);
                        switch (currentOperation) {
                            case '+':
                                firstValue = firstValue + secondValue;
                                break;
                            case '-':
                                firstValue = firstValue - secondValue;
                                break;
                            case '*':
                                firstValue = firstValue * secondValue;
                                break;
                            case '/':
                                if (secondValue != 0) {
                                    firstValue = firstValue / secondValue;
                                } else {
                                    display.setText("Error");
                                    return;
                                }
                                break;
                        }
                        display.setText(String.valueOf(firstValue));
                        firstValue = Double.NaN;
                        currentOperation = ' ';
                    }
                }
            }
        });
    }

    private View.OnClickListener operationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!Double.isNaN(firstValue)) {
                String text = display.getText().toString();
                if (!text.equals("")) {
                    secondValue = Double.parseDouble(text);
                    switch (currentOperation) {
                        case '+':
                            firstValue = firstValue + secondValue;
                            break;
                        case '-':
                            firstValue = firstValue - secondValue;
                            break;
                        case '*':
                            firstValue = firstValue * secondValue;
                            break;
                        case '/':
                            if (secondValue != 0) {
                                firstValue = firstValue / secondValue;
                            } else {
                                display.setText("Error");
                                return;
                            }
                            break;
                    }
                }
            } else {
                String text = display.getText().toString();
                if (!text.equals("")) {
                    firstValue = Double.parseDouble(text);
                }
            }
            Button button = (Button) v;
            currentOperation = button.getText().charAt(0);
            display.setText("");
        }
    };
}