/**
 * Created by Ion Guard on 9/8/2014.
 */
public class Card {

    private int cardValue;
    private String cardSuit;
    private String cardName;

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