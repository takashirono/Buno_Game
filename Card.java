public class Card {
    /* The smallest possible value that a Card can have. */
    public static final int MIN_VALUE = 0;
    
    /* The possible colors that a Card can have. */
    public static final String[] COLORS = {"blue", "green", "red", "yellow"};

    /* Define the third class constant here. */
    public static final int MAX_VALUE = 9;
    /* Put the rest of your class definition below. */
    public static boolean isValidColor (String color){
     for (int i = 0; i < COLORS.length; i++){
      if (COLORS[i] == color){
       return true;
      }
     }
     return false;
    }

    private String color;
    private int value;

    public void setColor (String inColor){
     if (isValidColor(inColor) ){
      this.color = inColor;
     } else {
      throw new IllegalArgumentException();
     }
    }

    public void setValue(int inVal){
     if (inVal <= MAX_VALUE && inVal >= MIN_VALUE){
      this.value = inVal;
     } else {
      throw new IllegalArgumentException();
     }
    }

    public Card(String color, int value){
     setColor(color);
     setValue(value);
    }

    public String getColor(){
     return this.color;
    }

    public int getValue(){
     return this.value;
    }

    public String toString(){
        return this.color + " " + this.value;
    }

    public boolean matches (Card newCard){
        if (newCard == null) {
            return false;
        } else if (this.color == newCard.getColor() || this.value == newCard.getValue()){
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Card newCard){
        if (newCard == null){
            return false;
        } if (this.color == newCard.getColor() && this.value == newCard.getValue()){
            return true;
        } else {
            return false;
        }
    }

    
}
    
