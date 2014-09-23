import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Ion Guard on 9/17/2014.
 */
public class Game implements GameMode{

    //Game with game things
    //Make game objects
    //Players, Rules/mode?, Goal?, Run?
	//Rename this to War implements Game
    private int score;
    private ArrayList<Player> playerList = new ArrayList<Player>();
    private String gameName;

    public Game(String gameName){
        this.gameName = gameName;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public String getGameName(){
        return gameName;
    }

    public void addPlayer(Player p){
        playerList.add(p);
    }

    public void removePlayer(Player p){
        playerList.remove(p);
    }

    public void printPlayerList(){
        for(Player p : playerList)
            System.out.println(p.getName());
    }

    public void run() {
        //Run the specified game?
        ArrayList<Card> DeckofCards = new ArrayList<Card>(52);
        CardStack cd = new CardStack();
        Deck deck = new Deck(DeckofCards);
        deck.generateNewDeck();
        deck.shuffle();

       
        int decksize = deck.getDeck().size();
        for(int i = 0; i < decksize/2; i++){
        	for(Player p : playerList){
        		p.addToHand(deck.drawCard());
        	}
        }

        //For war I should implement a linked list instead
        LinkedList<Card> warpile1 = new LinkedList<Card>();
        LinkedList<Card> warpile2 = new LinkedList<Card>();
        int handsize = playerList.get(0).getHand().size();
        for(int i = 0; i < handsize; i++){
            warpile1.add(playerList.get(0).getHand().get(i));
            warpile2.add(playerList.get(1).getHand().get(i));
        }

        //System.out.println("P1: " + warpile1.size() + " P2: " + warpile2.size());
        while(warpile1.size() > 0 && warpile2.size() > 0){
            if(warpile1.peek().getCardValue() > warpile2.peek().getCardValue()){
                //Player one wins
                Card temp = warpile2.poll();
                warpile1.push(temp);
                warpile1.add(warpile1.poll());
            }else {
                if (warpile1.peek().getCardValue() < warpile2.peek().getCardValue()) {
                    //Player 2 wins
                    Card temp = warpile1.poll();
                    warpile2.push(temp);
                    warpile2.add(warpile2.poll());
                } else {
                    //Tie, do duel
                    //remove first card of each pile, add next 3 from each deck to the duel pile, check first card
                    //Have to account for a deck having less than 4 cards and when to stop the while loop
                    ArrayList<Card> duelPile = new ArrayList<Card>();
                    int winner = 0;
                    int d = 4;
                    if(warpile1.size() - 1 < d)
                        d = warpile1.size() - 1;
                    if(warpile2.size() - 1 < d)
                        d = warpile2.size() - 1;

                    while (warpile1.peek().getCardValue() == warpile2.peek().getCardValue()) {
                        for(int i = 0; i < d; i++) {
                            duelPile.add(warpile1.poll());
                            duelPile.add(warpile2.poll());
                        }
                        if (warpile1.peek().getCardValue() > warpile2.peek().getCardValue())
                            winner = 1; //p1 wins
                        if (warpile1.peek().getCardValue() < warpile2.peek().getCardValue())
                            winner = 2; //p2 wins
                    }
                    if (winner == 1)
                        warpile1.addAll(duelPile);
                    if (winner == 2)
                        warpile2.addAll(duelPile);
                }
            }
        }

        if(warpile1.size() > 0)
            System.out.println(playerList.get(0).getName() + " Wins");
        else
            System.out.println(playerList.get(1).getName() + " Wins");

        /*for(int i = 0; i < player1.getHand().size(); i++){
            if(compareCards(player1.getHand().get(i), player2.getHand().get(i))) {
                int s1 = player1.getScore();
                player1.setScore(++s1);
            }
            else {
                int s2 = player2.getScore();
                player2.setScore(++s2);
            }
        }*/
        /*
        if(player1.getScore() > player2.getScore())
            System.out.println(player1.getName() + " Wins with " + player1.getScore() + " points");
        else if(player1.getScore() < player2.getScore())
            System.out.println(player2.getName() + " Wins with " + player2.getScore() + " points");
        else
            System.out.println("Tie");
            */
    }

    public static void printCards(ArrayList<Card> cards){
        //Print out deck
        for(int i = 0; i < cards.size(); i++)
            System.out.println(cards.get(i).getCardName() + " of " + cards.get(i).getCardSuit());
    }

    public int compareCards(Card c, Card d){
    	//forgot about this, use it
        if(c.getCardValue() > d.getCardValue())
            return 1;
        if(c.getCardValue() < d.getCardValue())
            return -1;
        return 0;
    }

}
