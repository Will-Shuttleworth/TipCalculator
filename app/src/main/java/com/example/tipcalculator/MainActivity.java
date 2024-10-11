package com.example.tipcalculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    EditText editTextBillAmount = null;
    TextView textViewTipAmount = null;
    RadioButton radioButtonTipTen = null;
    RadioButton radioButtonTipFifteen = null;
    RadioButton radioButtonTipTwenty = null;
    RadioGroup rg = null;
    DecimalFormat df = new DecimalFormat("£####.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = (EditText) findViewById(R.id.bill_amount);
        textViewTipAmount = (TextView) findViewById(R.id.tip_amount);
        radioButtonTipTen = (RadioButton)findViewById(R.id.ten);
        radioButtonTipFifteen = (RadioButton)findViewById(R.id.fifteen);
        radioButtonTipTwenty = (RadioButton)findViewById(R.id.twenty);
        rg = (RadioGroup) findViewById(R.id.tip_choices);
        rg.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(RadioGroup rg, int i){
        if(i==radioButtonTipTen.getId())
            textViewTipAmount.setText(df.format(Double.parseDouble(editTextBillAmount.getText().toString())*.10));
        else if(i==radioButtonTipFifteen.getId())
            textViewTipAmount.setText(df.format(Double.parseDouble(editTextBillAmount.getText().toString())*.15));
        else if(i==radioButtonTipTwenty.getId())
            textViewTipAmount.setText(df.format(Double.parseDouble(editTextBillAmount.getText().toString())*.20));
    }
}