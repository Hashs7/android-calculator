package com.pro.glagouy.calculatriceandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String viewValue;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = findViewById(R.id.tv_result);
    }

    private void updateView() {
        this.textView.setText(this.viewValue);
    }

    /**
     *
     * @param view
     */
    public void numberClick(View view) {
        int valuePress = Integer.parseInt(view.getTag().toString());
        this.viewValue += valuePress;
        System.out.println(valuePress);
        updateView();
    }

    /**
     *
     * @param view
     */
    public void operationClick(View view) {
        String valuePress = (String) view.getTag();
        this.viewValue += valuePress;
        updateView();
    }
}
