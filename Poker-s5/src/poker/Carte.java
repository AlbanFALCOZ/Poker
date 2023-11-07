package poker;

public class Carte {

    private int value;
    private String color;

    public Carte(int value, String color) {
        if ((color.equals("Tr")) || (color.equals("Ca")) || (color.equals("Co")) || color.equals("Pi")) this.color = color;
        else this.color = "Err";

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
                    this.value = -1;
                    break;
            }
        }
    }

    public boolean verifCarte(Carte other) {
        if ((value == other.getValue()) && (color.equals(other.getColor()))) return false;
        return true;
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