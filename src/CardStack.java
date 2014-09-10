import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;


public class CardStack {
	
	private ArrayList<Card> Deck = new ArrayList<Card>(52);
	static String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
	static String[] cardName = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	private ArrayList<Card> Hand = new ArrayList<Card>();

    public CardStack(ArrayList<Card> d){
        Deck = d;
    }

    public void setDeck(ArrayList<Card> d){
        Deck = d;
    }

    public ArrayList<Card> getDeck(){
        return Deck;
    }
 
	public static void main(String[] args) {
        //1 Clubs, 2 Diamonds, 3 Hearts, 4 Spades
        //Naming scheme is 101 for Ace of Clubs, 413 for King of Spades
        //Generate the deck, maybe change it to generate a list of card objects?
        //
		
		//refactor to initDeck
        ArrayList<Integer> deck = new ArrayList<Integer>(52);
        for(int x = 1; x <= 4; x++){
            for(int y = 1; y <= 13; y++){
                deck.add((x)*100 + y);
            }
        }

        ArrayList<Card> DeckofCards = new ArrayList<Card>();
        CardStack cd = new CardStack(DeckofCards);

        for(int x = 0; x < 52; x++){
            Card c = cd.generateCard(deck.get(x));
            DeckofCards.add(c);
        }
        
        Collections.shuffle(DeckofCards);
        cd.setDeck(DeckofCards);
        
        cd.drawCard(cd.Deck, 5);
        Player player1 = new Player("Steve", cd.Hand);
        cd.Hand = new ArrayList<Card>();
        cd.drawCard(cd.Deck, 5);
        Player player2 = new Player("Brett", cd.Hand);
        
        printDeck(player1.getHand());
        System.out.println();
        printDeck(player2.getHand());		
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
	
	public void drawCard(ArrayList<Card> d, int n){
		for(int i = 0; i < n; i++){
			Hand.add(d.get(0));
			d.remove(0);
		}
	}
	
	public ArrayList<Card> shuffleDeck(ArrayList<Card> d){
		Collections.shuffle(d);
		return d;
	}

}
