package com.pro.glagouy.calculatriceandroid.modeles;

import android.util.Log;

/**
 * Calcule le résultat à chaque nouveau opérateur
 */
public class Operation {
    private Double firstValue;
    private Double lastValue;
    private String operator;

    public Operation(Double firstValue, Double lastValue, String operator) {
        this.firstValue = firstValue;
        this.lastValue = lastValue;
        this.operator = operator;
    }

    public Double calculate() throws Exception {
        if(operator != null){
            Log.w("WARN","Il y a un opérateur");
        }

        if(firstValue == null || lastValue == null) return null;

        switch (operator) {
            case "/":
                if (lastValue == 0) {
                    throw new Exception("Division par 0 impossible !");
                }
                return firstValue / lastValue;
            case "*":
                return firstValue * lastValue;
            case "-":
                return firstValue - lastValue;
            case "+":
                return firstValue + lastValue;
        }
        return 0.0;
    }
}
