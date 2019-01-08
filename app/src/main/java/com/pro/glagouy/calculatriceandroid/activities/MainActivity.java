package com.pro.glagouy.calculatriceandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pro.glagouy.calculatriceandroid.R;

public class MainActivity extends AppCompatActivity {
    private String viewValue = "";
    private double value1;
    private double value2;
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
        int valuePress = Integer.parseInt(view.getTag().toString());
        this.viewValue += valuePress;
        updateView();
    }

    /**
     *  HandleOperationClick
     * @param view la vue qui a déclenchée l'event
     */
    public void operationClick(View view) {
        this.value1 = Double.parseDouble(this.viewValue);

        String valuePress = (String) view.getTag();
        System.out.println(valuePress);
        this.viewValue += valuePress;

        updateView();
    }
}
