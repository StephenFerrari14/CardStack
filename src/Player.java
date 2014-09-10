import java.util.ArrayList;


public class Player {
	
	private String Name;
	private ArrayList<Card> Hand;

	public Player(String name, ArrayList<Card> hand){
		Name = name;
		Hand = hand;
	}
	
	public String getName(){
		return Name;
	}
	
	public ArrayList<Card> getHand(){
		return Hand;
	}
	
	public void setName(String n){
		Name = n;
	}
	
	public void setHand(ArrayList<Card> hand){
		Hand = hand;
	}
	
	public void addToHand(Card c){
		Hand.add(c);
	}
	
	public void removeFromHand(Card c){
		Hand.remove(c);
	}

}
