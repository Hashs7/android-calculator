package com.pro.glagouy.calculatriceandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pro.glagouy.calculatriceandroid.R;
import com.pro.glagouy.calculatriceandroid.modeles.Operation;

public class MainActivity extends AppCompatActivity {
    private String viewValue = "";
    private Integer value1;
    private Integer value2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = findViewById(R.id.tv_result);
    }

    /**
     * UpdateTextView values
     */
    private void updateView() {
        this.textView.setText(this.viewValue);
    }

    /**
     *  HandleButtonClick
     * @param view la vue qui a déclenchée l'event
     */
    public void numberClick(View view) {
        String valuePress = view.getTag().toString();
        this.viewValue += valuePress;
        updateView();
    }


    public void calculate(View view) {
        String operator = view.getTag().toString();

        String[] values = this.viewValue.split(operator);
        this.value1 = Integer.parseInt(values[0]);
        this.value2 = Integer.parseInt(values[1]);


        String valuePress = (String) view.getTag();
        System.out.println(valuePress +"value 1: "+ this.value1 + "  value 2:" + this.value2);
        this.viewValue += valuePress;

        Operation result = new Operation((double) this.value1, (double) this.value2, operator);
        System.out.println(result);
    }
}
