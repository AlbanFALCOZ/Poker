package Poker;

public class Carte {

    private int value;
    private String color;

    public Carte(int value, String color){
        this.value = value;
        this.color = color;
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