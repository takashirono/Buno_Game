/*
 * ComputerPlayer.java
 * 
 * Computer Science 112, Boston University
 * 
 * serves as a blueprint for objects that
 * represent a single Buno computer player.
 */


import java.util.*;

class ComputerPlayer extends Player{
    //constructor for computer player
    public ComputerPlayer(String name){
        super(name);
    }
    
    /* a printHand method that overrides the
     * inherited version of that method. This
     * version of the method should simply print
     * the number of cards in the
     * ComputerPlayer‘s hand.
     */
    public void printHand(){
        if (this.getNumCards() == 1){
            System.out.println("Computer's hand: " + this.getNumCards() + " card");
        }else {
            System.out.println("Computer's hand: " + this.getNumCards() + " cards");
        }
    }
    
    /* a getPlay method that overrides the inherited
     * version of that method. This version of the
     * method should figure out if the computer has
     * a card that matches the card at the top of the
     * discard pile (this card is passed in as the second
     * parameter of the method). If the computer doesn’t
     * have a matching card, the method should return -1
     * so that the computer will end up drawing a card.
     * If the computer does have one or more matching cards,
     * the method should return the index of the card that
     * should be played.
     */
    public int getPlay(Scanner scan, Card topPile){
        // valList is a new list of ints with values of each cards
        int[] valList = new int[this.getNumCards()];
        // the maxVal is a int holding the maxValue of the cards
        int maxVal = -1;
        // maxValCount holds the amount of same maxValues exisitng in the cards
        int maxValCount = 0;
        // maxCardVal is used when there are more than one maxVal cards to determine which card has the highest value and in which color
        int maxCardVal = 0;
        // return value used to return the index of the card to be discarded
        int maxCardValIndex = 0;
        
        
        for (int i=0;i<this.getNumCards();i++){
            if (this.getCardFromHand(i).getValue() == topPile.getValue() || this.getCardFromHand(i).getColor() == topPile.getColor()){
                valList[i] = this.getCardFromHand(i).getValue();
            } else {
                valList[i] = -1;
            }
        }
        
        for (int i=0;i<this.getNumCards();i++){
            if (valList[i] >= maxVal){
                maxVal = valList[i];
            }
        }

        for (int i=0;i<this.getNumCards();i++){
            if (valList[i] == maxVal && maxVal != -1){
                maxValCount ++;
            }
        }

        
        // if there are two or more cards which is disposable and same value
        if (maxValCount > 1){
            for(int i=0;i<this.getNumCards();i++){
                if (valList[i] == maxVal){
                    maxCardVal = maxVal;
                    // tests if there are any cards which has higher value than the max value with same color as the maxVal cards.
                    for (int j=0;j<this.getNumCards();j++){
                        if ( i!= j && this.getCardFromHand(i).getColor() == this.getCardFromHand(j).getColor()){
                            if (this.getCardFromHand(j).getValue() > maxCardVal){
                                maxCardValIndex = j;
                                maxCardVal = this.getCardFromHand(j).getValue();
                            }
                        }
                    }
                }
            }
            if (maxCardVal == maxVal){
                for (int i=0;i<this.getNumCards();i++){
                    if (valList[i] == maxVal){
                        maxCardValIndex = i;
                        return maxCardValIndex;
                        
                    }
                }
            }
            
            return maxCardValIndex;
        } else if (maxValCount == 0){
            return -1;
        } else {
            for (int i=0;i<this.getNumCards();i++){
                //System.out.println(valList[i]);
              if (valList[i] == maxVal){
                maxCardValIndex = i;
              }
            }
            return maxCardValIndex;
        }
    }
}