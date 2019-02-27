package com.pro.glagouy.calculatriceandroid.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pro.glagouy.calculatriceandroid.R;
import com.pro.glagouy.calculatriceandroid.modeles.Operation;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activité principale de la vue
 */
public class MainActivity extends AppCompatActivity {
    private String displayValue = "";
    private Double firstValue;
    private Double lastValue;
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
     * On touch egal
     * @param view
     */
    public void calculate(View view) {
        Log.w("WARN", "clikaaay");
        if(this.displayValue == null) return;
        if(this.operator == null) return;
        String[] values = this.displayValue.split(String.format("\\%s", this.operator));
        Log.w("WARN", this.operator);
        if(values[0] == null) return;
        if(values[1] == null) return;
        this.firstValue = Double.parseDouble(values[0]);
        Log.w("WARN", String.valueOf(this.firstValue));
        this.lastValue = Double.parseDouble(values[1]);
        Log.w("WARN", String.valueOf(this.lastValue));

        Double result;
        try {
            result = new Operation(this.firstValue, this.lastValue, this.operator).calculate();
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
