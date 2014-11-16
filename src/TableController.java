import java.awt.*;

public class TableController {
	
	//Controller for game
	GameView gv;

	public TableController(){

	}

	public void start(){
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				gv = new GameView();
				gv.setVisible(true);
				gv.init();
			}
		});
	}

}
