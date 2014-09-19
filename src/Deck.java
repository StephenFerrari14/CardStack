import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ion Guard on 9/17/2014.
 */
public class Deck {

    //Deck class, going to contain a list of cards.
    //Shuffle, draw, get, set
    private ArrayList<Card> Deck = new ArrayList<Card>();
    static String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static String[] cardName = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Deck(ArrayList<Card> d){
        Deck = d;
    }

    public void setDeck(ArrayList<Card> d){
        Deck = d;
    }

    public ArrayList<Card> getDeck(){
        return Deck;
    }

    public Card drawCard(){
            return Deck.remove(0);
    }

    public void shuffle(){
        Collections.shuffle(Deck);
    }

    public void generateNewDeck(){
        ArrayList<Integer> deck = new ArrayList<Integer>(52);
        for(int x = 1; x <= 4; x++){
            for(int y = 1; y <= 13; y++){
                int cV = (x)*100 + y;
                Card c = generateCard(cV);
                Deck.add(c);
            }
        }
    }

    public Card generateCard(int cV){ //
        int cardVal = cV % 100;
        //int cardsuit = (int) cV/100;
        //int cardname = cV % 100;
        String cardsuit = SUITS[((int)(cV/100))-1];
        String cardname = cardName[(cV % 100)-1];
        return new Card(cardVal,cardname,cardsuit);
    }

}
