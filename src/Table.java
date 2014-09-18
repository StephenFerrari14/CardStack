import java.util.ArrayList;


public class Table {

	//Get it? Table because thats where you play card games
    //Make Table the gui
	//Table will have game type, scores, players,
	private String gametype;
	private int score;
	private ArrayList<Player> playerList;
	
	public Table(int score){
		this.score = score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}

}
