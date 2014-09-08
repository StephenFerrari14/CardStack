import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;


public class CardStack {
	
	private ArrayList<Integer> Deck = new ArrayList<Integer>(52);
	static String[] SUITS = {"Club", "Diamond", "Heart", "Spade"};
	static String[] cardValue = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public CardStack(ArrayList<Integer> d){
        Deck = d;
    }

    public void setDeck(ArrayList<Integer> d){
        Deck = d;
    }

    public ArrayList<Integer> getDeck(){
        return Deck;
    }

    //Make getters and setters
 
	public static void main(String[] args) {
        //1 Clubs, 2 Diamonds, 3 Hearts, 4 Spades
        //Naming scheme is 101 for ace of clubs
        //Generate the deck
        ArrayList<Integer> deck = new ArrayList<Integer>(52);
        for(int x = 1; x <= 4; x++){
            for(int y = 1; y <= 13; y++){
                deck.add((x)*100 + y);
            }
        }


        CardStack cd = new CardStack(deck);

        Collections.shuffle(cd.Deck);
        cd.printDeck(cd.Deck);
				
	}

    public int pickCard(ArrayList<Integer> deck){
        int selection = deck.get(0);
        deck.remove(0);
        setDeck(deck);
        return selection;
    }
	
	public void printDeck(ArrayList<Integer> deck){
		//Print out deck
		for(int i = 0; i < deck.size(); i++)
			System.out.println(deck.get(i));
	}
	
	

}
