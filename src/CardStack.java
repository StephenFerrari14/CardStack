import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;



public class CardStack {//extends JFrame{

	static String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
	static String[] cardName = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	private ArrayList<Card> Hand = new ArrayList<Card>();

    //public static enum CARDTYPE {ACE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
    //public static enum CARDSUIT {CLUBS, DIAMONDS, HEARTS, SPADES};

    public CardStack(){
        //init();
    }

    /*
    //Try again Later

    private void init(){


        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        JButton quitButton = new JButton("Quit");
        quitButton.setSize(100, 100);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                        .addComponent(quitButton)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                        .addComponent(quitButton)
        );

        pack();

        setTitle("CardStack");
        setSize(480, 320);
        setBackground(Color.BLUE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    */

    /*
    private void doDrawing(Graphics g) {
        System.out.println("DoDraw");
        g.setColor(Color.BLUE);

        Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        setBackground(Color.white);
        doDrawing(g);
    }
    */

	public static void main(String[] args) {
        //1 Clubs, 2 Diamonds, 3 Hearts, 4 Spades
        //Naming scheme is 101 for Ace of Clubs, 413 for King of Spades
        //Generate the deck, maybe change it to generate a list of card objects?
        //

        /*
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CardStack c = new CardStack(new ArrayList<Card>());
                c.setVisible(true);
                BufferedImage image = null;
                    try {
                        image = ImageIO.read(new File("CardFace.png"));
                    } catch (IOException ex) {
                        // handle exception...
                    }

                JLabel cardPic = new JLabel(new ImageIcon(image));
                c.add(cardPic);
            }
        });
        */

        /*
        JFrame f = new JFrame("CardStack");
        f.setSize(600, 600);
        f.setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setSize(200,100);
        p.setBackground(Color.BLACK);
        f.setLayout(new FlowLayout());
        f.setLocationRelativeTo(null);
        f.add(p);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("CardFace.png"));
        }
        catch(IOException e){}
        g.drawImage(img, 100,100, null);
        Button button1 = new Button("Next");
        f.add(button1);
        f.pack();
        f.setVisible(true);
        */

        /*
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new JFrame("CardStack");
                frame.setContentPane(new Panel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();             // "this" JFrame packs its components
                frame.setLocationRelativeTo(null); // center the application window
                frame.setVisible(true);            // show it
                frame.setSize(480,320);
                frame.setBackground(Color.BLUE);
                Graphics g = frame.getGraphics();
                g.drawRect(0,0,480,320);
                g.setColor(Color.BLUE);
            }
        });*/

        ArrayList<Card> DeckofCards = new ArrayList<Card>();
        CardStack cd = new CardStack();
        Deck deck = new Deck(DeckofCards);
        deck.generateNewDeck();
        deck.shuffle();

        Player player1 = new Player("Steve", new ArrayList<Card>(), 0);
        Player player2 = new Player("Brett", new ArrayList<Card>(), 0);
        for(int i = 0; i < 7; i++){
            player1.addToHand(deck.drawCard());
            player2.addToHand(deck.drawCard());
        }
        
        //printCards(player1.getHand());
        //System.out.println();
        //printCards(player2.getHand());
        for(int i = 0; i < player1.getHand().size(); i++){
        	if(cd.compareCards(player1.getHand().get(i), player2.getHand().get(i))) {
                int s1 = player1.getScore();
                player1.setScore(++s1);
            }
        	else {
                int s2 = player2.getScore();
                player2.setScore(++s2);
            }
        }

        /*
        printCards(player1.getHand());
        System.out.println();
        printCards(player2.getHand());
        System.out.println(player1.getScore());
        System.out.println(player2.getScore());
        */

        if(player1.getScore() > player2.getScore())
        	System.out.println(player1.getName() + " Wins with " + player1.getScore() + " points");
        else if(player1.getScore() < player2.getScore())
        	System.out.println(player2.getName() + " Wins with " + player2.getScore() + " points");
        else
        	System.out.println("Tie");
        	
	}


	
	public static void printCards(ArrayList<Card> cards){
		//Print out deck
		for(int i = 0; i < cards.size(); i++)
			System.out.println(cards.get(i).getCardName() + " " + cards.get(i).getCardSuit());
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
