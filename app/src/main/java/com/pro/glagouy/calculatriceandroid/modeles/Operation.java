package com.pro.glagouy.calculatriceandroid.modeles;

public class Operation {
    private Integer val1;
    private Integer val2;
    private String operator;

    public Operation(Integer val1, Integer val2, String operator){
        this.val1 = val1;
        this.val2 = val2;
        this.operator = operator;
    }

    public Integer calculate(){
        switch (operator){
            case "/":
                return val1 / val2;
            case "*":
                return val1 * val2;
            case "-":
                return val1 - val2;
            case "+":
                return val1 + val2;
        }
        return 0;
    }
}
