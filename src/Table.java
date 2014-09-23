import java.util.ArrayList;
import java.util.Scanner;


public class Table {

	//Get it? Table because thats where you play card games
    //Make Table the gui maybe

    Scanner console = new Scanner(System.in);
	
	public Table(){

	}

    public void start(){
        System.out.println("*********************\n"
                + "     Card Stack      \n"
                + "*********************");
        startMenu();
    }

    public void startMenu(){

        System.out.println();
        System.out.println("1. Play War");
        System.out.println("9. Close");
        int input = console.nextInt();
        switch (input) {
            case 1:
                play();
            case 9:
                System.exit(0);
            default:
        }
    }
	
    public void play(){
        Game war = new Game("War");
        System.out.println("Playing " + war.getGameName());
        System.out.println("Enter Player 1's Name: ");
        String p1name = console.next();
        System.out.println("Enter Player 2's Name: ");
        String p2name = console.next();
        Player player1 = new Player(p1name, new ArrayList<Card>(52), 0);
        Player player2 = new Player(p2name, new ArrayList<Card>(52), 0);
        war.addPlayer(player1);
        war.addPlayer(player2);
        war.run();
        startMenu();
    }

}
