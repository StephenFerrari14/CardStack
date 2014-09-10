import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;


public class CardStack {
	
	private ArrayList<Integer> Deck = new ArrayList<Integer>(52);
	static String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
	static String[] cardName = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public CardStack(ArrayList<Integer> d){
        Deck = d;
    }

    public void setDeck(ArrayList<Integer> d){
        Deck = d;
    }

    public ArrayList<Integer> getDeck(){
        return Deck;
    }
 
	public static void main(String[] args) {
        //1 Clubs, 2 Diamonds, 3 Hearts, 4 Spades
        //Naming scheme is 101 for Ace of Clubs, 413 for King of Spades
        //Generate the deck, maybe change it to generate a list of card objects?
        //

        ArrayList<Integer> deck = new ArrayList<Integer>(52);
        for(int x = 1; x <= 4; x++){
            for(int y = 1; y <= 13; y++){
                deck.add((x)*100 + y);
            }
        }

        ArrayList<Card> DeckofCards = new ArrayList<Card>(52);
        CardStack cd = new CardStack(deck);

        for(int x = 0; x < 52; x++){
            Card c = cd.generateCard(deck.get(x));
            DeckofCards.add(c);
        }

        Collections.shuffle(cd.Deck);
        //cd.printDeck(cd.Deck);
        //for(int i = 0; i < cd.Deck.size(); i++)
         //   System.out.println(cd.Deck.get(i));
        printDeck(DeckofCards);
        //int picked = cd.pickCard(cd.Deck);
        //Card firstCard = cd.generateCard(picked);
        //System.out.println(firstCard.getCardName() + " of " + firstCard.getCardSuit());
				
	}

    public int pickCard(ArrayList<Integer> deck){
        int selection = deck.get(0);
        deck.remove(0);
        setDeck(deck);
        return selection;
    }

    public Card generateCard(int cV){
        int cardVal = cV % 100;
        String cardsuit = SUITS[((int)(cV/100))-1];
        String cardname = cardName[(cV % 100)-1];
        Card card = new Card(cardVal,cardname,cardsuit);
        return card;
    }
	
	public static void printDeck(ArrayList<Card> deck){
		//Print out deck
		for(int i = 0; i < deck.size(); i++)
			System.out.println(deck.get(i).getCardName() + " " + deck.get(i).getCardSuit());
	}
	
	

}
