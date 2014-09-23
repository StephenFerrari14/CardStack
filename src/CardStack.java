import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;



public class CardStack extends JFrame{

    public CardStack(){
        init(); 
    }
    
    private void init() {

    	JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon("exit.png");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Exit", icon);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        file.add(eMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);
        
        JPanel basic = new JPanel();
        basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
        add(basic);

        basic.add(Box.createVerticalGlue());

        JPanel bottom = new JPanel();
        bottom.setAlignmentX(1f);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));

        JButton ok = new JButton("OK");
        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        bottom.add(ok);
        bottom.add(Box.createRigidArea(new Dimension(5, 0)));
        bottom.add(close);
        bottom.add(Box.createRigidArea(new Dimension(15, 0)));

        basic.add(bottom);
        basic.add(Box.createRigidArea(new Dimension(0, 15)));

        setTitle("CardStack");
        setSize(480, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	CardStack ex = new CardStack();
                ex.setVisible(true);
            }
        });
        

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
