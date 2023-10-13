package Poker;

import java.util.HashMap;
import java.util.Map;

public class Cartes {

    private int value;
    private String color;

    public Cartes(int value,String color){
        this.value = value;
        this.color = color;
        System.out.println("test");
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public String toString(){
        return this.value + " de " + this.color;
    }
}