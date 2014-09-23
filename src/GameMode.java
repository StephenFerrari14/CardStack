/**
 * Created by Ion Guard on 9/18/2014.
 */
public interface GameMode {
	//Rename Game or keep GameMode?

    void run();

    String getGameName();

    void addPlayer(Player p);

    void printPlayerList();

}
