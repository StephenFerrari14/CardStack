/**
 * Created by Ion Guard on 9/8/2014.
 */
public class Card {
    //Card class. Contains the value, suit, name of a card.
    //Assuming use of a standard deck of cards for now.

    private int cardValue;
    private String cardSuit;
    private String cardName;
    //Working on enums idea
    //private CARDTYPE m_type;
    //private CARDSUIT m_suit;
    /*public enum CARDTYPE {ACE (1), TWO (2), THREE (3), FOUR (4), FIVE (5), SIX (6), SEVEN (7), EIGHT (8), NINE (9), TEN (10), JACK (11), QUEEN (12), KING (13);

        private int value;
        CARDTYPE(int i) {
            value = i;
        }

        public int getValue(){
            return value;
        }
    };

    public static enum CARDSUIT {CLUBS, DIAMONDS, HEARTS, SPADES};
    */

    public Card(int cV, String cN, String cS){
        cardValue = cV;
        cardSuit = cS;
        cardName = cN;
    }

    public int getCardValue(){
        return cardValue;
    }
    public String getCardName(){
        return cardName;
    }
    public String getCardSuit(){
        return cardSuit;
    }

    public void setCardValue(int value){
        cardValue = value;
    }
    public void setCardName(String name){
        cardName = name;
    }
    public void setCardSuit(String suit){
        cardSuit = suit;
    }

}
