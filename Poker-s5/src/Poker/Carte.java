package Poker;

public class Carte {

    private int value;
    private String color;



    public Carte(int value, String color) {
        this.color = color;
        if (value >= 2 && value <= 10) {
            this.value = value;
        } else{
            switch (value) {
                case 'V':
                    this.value = 11;
                    break;
                case 'D':
                    this.value = 12;
                    break;
                case 'R':
                    this.value = 13;
                    break;
                case 'A':
                    this.value = 14;
                    break;
                default:
                    this.value = 2;
                    break;
            }

        }
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