import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;



public class CardStack {//extends JFrame{

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

        Table kitchenTable = new Table();
        kitchenTable.start();
        	
	}

}
