package com.pro.glagouy.calculatriceandroid.modeles;

public class Operation {
    private Double val1;
    private Double val2;
    private String operator;

    public Operation(Double val1, Double val2, String operator){
        this.val1 = val1;
        this.val2 = val2;
        this.operator = operator;
    }

    public Double calculate(){
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
        return 0.0;
    }
}
