import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Ion Guard on 9/17/2014.
 */
public class Game implements GameMode{

    //Game with game things
    //Make game objects
    //Players, Rules/mode?, Goal?, Run?
    private int score;
    private ArrayList<Player> playerList;
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

        Player player1 = new Player("Steve", new ArrayList<Card>(52), 0);
        Player player2 = new Player("Brett", new ArrayList<Card>(52), 0);
        int decksize = deck.getDeck().size();
        for(int i = 0; i < decksize/2; i++){
            player1.addToHand(deck.drawCard());
            player2.addToHand(deck.drawCard());
        }

        //For war I should implement a linked list instead
        LinkedList<Card> warpile1 = new LinkedList<Card>();
        LinkedList<Card> warpile2 = new LinkedList<Card>();
        int handsize = player1.getHand().size();
        for(int i = 0; i < handsize; i++){
            warpile1.add(player1.getHand().get(i));
            warpile2.add(player2.getHand().get(i));
        }

        //for(int j = 0; j < player1.getHand().size(); j++){
        //    if(compareCards(player1.getHand().get(j), player2.getHand().get(j))){

        //    }
        //}
        //Implement Face card rule or else its infinite
        while(warpile1.size() > 0 || warpile2.size() > 0){
            if(warpile1.peek().getCardValue() > warpile2.peek().getCardValue()){
                    //Player one wins
                Card temp = warpile2.poll();
                warpile1.push(temp);
                warpile1.add(warpile1.poll());
            }else if(warpile1.peek().getCardValue() > warpile2.peek().getCardValue()){
                    //Player 2 wins
                Card temp = warpile1.poll();
                warpile2.push(temp);
                warpile2.add(warpile2.poll());
            }else {
                //Tie
                warpile1.add(warpile1.poll());
                warpile2.add(warpile2.poll());
            }
        }

        if(warpile1.size() > 0)
            System.out.println(player1.getName() + "Wins");
        else
            System.out.println(player2.getName() + "Wins");

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

    public boolean compareCards(Card c, Card d){
        //Compare values
        //Return Higher? Lower? Boolean? Include different options?
        //Needs to account for equals case
        if(c.getCardValue() > d.getCardValue())
            return true;
        else
            return false;
    }

}
