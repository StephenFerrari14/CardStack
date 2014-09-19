import java.util.ArrayList;
import java.util.Scanner;


public class Table {

	//Get it? Table because thats where you play card games
    //Make Table the gui maybe

	public Table(){

	}

    public void start(){
        System.out.println("*********************\n"
                + "     Card Stack      \n"
                + "*********************");
        startMenu();
    }

    public void startMenu(){

        Scanner console = new Scanner(System.in);
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
        war.run();
        startMenu();
    }

}
