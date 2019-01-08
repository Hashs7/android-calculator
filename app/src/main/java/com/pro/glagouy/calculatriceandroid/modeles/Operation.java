package com.pro.glagouy.calculatriceandroid.modeles;

public class Operation {
    private double val1;
    private double val2;
    private String operator;

    public Operation(double val1, double val2, String operator){
        this.val1 = val1;
        this.val2 = val2;
        this.operator = operator;
    }

    public double calculate(){
        switch (operator){
            case "/":
                return val1 / val2;
            case "x":
                return val1 * val2;
            case "-":
                return val1 - val2;
            case "+":
                return val1 + val2;
        }
        return 0;
    }
}
