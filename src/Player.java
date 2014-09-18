import java.util.ArrayList;


public class Player {

    //Name, hand, score
	private String Name;
	private ArrayList<Card> Hand;
    private int Score;

	public Player(String name, ArrayList<Card> hand, int score){
		Name = name;
		Hand = hand;
        Score = score;
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

    public int getScore(){
        return Score;
    }

    public void setScore(int s){
        Score = s;
    }

    public void addToHand(Card c){
		Hand.add(c);
	}
	
	public void removeFromHand(Card c){
		Hand.remove(c);
	}

}
