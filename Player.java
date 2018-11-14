/*
 * Player.java
 * 
 * Computer Science 112, Boston University
 * 
 * serves as a blueprint for objects that
 * represent a single Buno player.
 */


import java.util.*;

class Player{
    // name of the player
    private String name;
    // list of Card objects to represent the player's cards in hand
    private Card[] cards;
    // amount of cards the player has
    private int numCards;
    
    //onstructor that takes a single parameter for the name of the player
    public Player(String name){
        this.name = name;
        this.cards = new Card[Buno.MAX_CARDS];
        this. numCards = 0;
    }
    
    //an accessor named getName that returns the player’s name
    public String getName(){
        return this.name;
    }
    
    //an accessor named getNumCards that returns the current number of cards in the player’s hand
    public int getNumCards(){
        return this.numCards;
    }
    
    //a toString method that just returns the player’s name
    public String toString(){
        return this.name;
    }
    
    /* a mutator named addCardToHand that takes a Card object as a parameter
     * and adds the specified card to the player’s hand, filling the array 
     * from left to right. Should return a boolean indicating success or 
     * failure
     */
    public boolean addCardToHand(Card card){
        if  (card == null){
            throw new IllegalArgumentException();
        }
        if (this.numCards == Buno.MAX_CARDS){
            return false;
        } else {
            this.cards[this.numCards] = card;
            this.numCards ++;
            return true;
        }
    }
    
    /*an accessor named getCardFromHand that takes an integer index
     * as a parameter and returns the Card at the specified position
     * in the player’s hand, without actually removing the card from
     * the hand.
     */
    public Card getCardFromHand(int int_index){
        if (this.numCards <= int_index){
            throw new IllegalArgumentException();
        }
        return this.cards[int_index];
    }
    
    /* an accessor method named getHandValue that computes and returns
     * the total value of the player’s current hand and extra 25 points
     * penalty if the hand has the maximum number of cards
     */
    public int getHandValue(){
        int sumCardVal = 0;
        for (int i=0; i<this.numCards; i++){
            sumCardVal += this.cards[i].getValue();
        }
        if (this.numCards == Buno.MAX_CARDS){
            sumCardVal += Buno.MAX_CARDS_PENALTY;
        }
        return sumCardVal;
        
    }
    
    
    /* an accessor method named printHand that prints the current contents
     * of the player’s hand, preceded by a heading that includes the player’s name.
     */
    public void printHand(){
        System.out.println(this.name + "'s hand:");
        for (int i=0; i<this.numCards;i++){
            System.out.println("  " + i + ": " + this.cards[i].getColor() + " " + this.cards[i].getValue());
        }
    }
    
    /* a mutator method named removeCardFromHand that takes an integer
     * index as a parameter and both removes and returns the Card at
     * that position of the player’s hand.
     */
    public Card removeCardFromHand(int int_index){
        if (int_index >= this.numCards){
            throw new IndexOutOfBoundsException();
        }
        Card removeCardHold = this.cards[int_index];
        if (this.numCards-1 == int_index){
            this.cards[this.numCards-1] = null;
            this.numCards --; 
        } else {
            this.cards[int_index] = this.cards[this.numCards-1];
            this.cards[this.numCards-1] = null;
            this.numCards --; 
        }
        return removeCardHold;
    }
    /* an accessor method named getPlay that determines and returns
     * the number corresponding to the player’s next play: either -1
     * if the player wants to draw a card, or the number/index of the
     * card that the player wants to discard from his/her hand.
     * The method should take two parameters: a Scanner object that can
     * be used to read from the console, and a Card object representing
     * the card that is currently at the top of the discard pile.
     */
    public int getPlay(Scanner scan, Card topPile){
        System.out.print("If you want to draw a card, type -1. If you want to discard a card, type the index number: ");
        int input = scan.nextInt();
        while ((input != -1 && input >= this.numCards) || input < -1){
            System.out.print("Invalid value, please try again: ");
            input = scan.nextInt();
        }
        if (input == -1){
            return -1;
        } else {
            return input;
        }
    }
    
    
    
}