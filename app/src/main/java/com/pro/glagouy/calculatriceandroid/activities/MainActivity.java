package com.pro.glagouy.calculatriceandroid.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pro.glagouy.calculatriceandroid.R;
import com.pro.glagouy.calculatriceandroid.modeles.Operation;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String displayValue = "";
    private Double value1;
    private Double value2;
    private TextView textView;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = findViewById(R.id.tv_result);
    }

    /**
     * Update TextView values
     */
    private void updateView() {
        this.textView.setText(this.displayValue);
    }

    /**
     *  HandleButtonClick
     * @param view la vue qui a déclenchée l'event
     */
    public void inputClick(View view) {
        String valuePress = view.getTag().toString();
        this.displayValue += valuePress;
        updateView();
    }

    /**
     *
     * @param view
     */
    public void operatorClick(View view){
        this.operator = view.getTag().toString();
        inputClick(view);
    }

    /**
     *
     * @param view
     */
    public void calculate(View view) {
        String[] values = this.displayValue.split(String.format("\\%s", this.operator));
        this.value1 = Double.parseDouble(values[0]);
        this.value2 = Double.parseDouble(values[1]);

        Double result;
        try {
            result = new Operation(this.value1, this.value2, operator).calculate();
            this.displayValue = result.toString();
            updateView();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *
     * @param view
     */
    public void delete(View view) {
        if(this.displayValue.length() < 1){
            return;
        }
        Integer index = this.displayValue.length();
        this.displayValue = this.displayValue.substring(0, index - 1);
        updateView();
    }
}
