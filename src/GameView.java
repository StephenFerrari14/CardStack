import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

class DrawPanel extends JPanel {

	Image imgFace;
	Image imgBack;
	int height = 320;
	int width = 480;

	public DrawPanel() {

		loadImage();
		Dimension dm = new Dimension(imgFace.getWidth(null), imgFace.getHeight(null));
		setPreferredSize(dm);
	}

	private void loadImage() {
		imgFace = new ImageIcon("CardFace.png").getImage();
		imgBack = new ImageIcon("CardBack.png").getImage();
		//imgFace = imgFace.getScaledInstance((int)(imgFace.getWidth(null)*1.5), (int)(imgFace.getHeight(null)*1.5), 1);
		imgBack = imgBack.getScaledInstance(imgBack.getWidth(null)*2, imgBack.getHeight(null)*2, 1);

	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(imgFace, width/2 - imgFace.getWidth(null), height/2 - imgFace.getHeight(null) , null);
		g2d.drawImage(imgFace, width/2 + imgFace.getWidth(null), height/2 - imgFace.getHeight(null) , null);
		g2d.drawImage(imgBack, imgBack.getWidth(null), height/2 - imgBack.getHeight(null) , null);
		g2d.drawImage(imgBack, width - imgBack.getWidth(null), height/2 - imgBack.getHeight(null) , null);

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}
}


public class GameView extends JFrame{

	public static void main(String[] args) {
		//1 Clubs, 2 Diamonds, 3 Hearts, 4 Spades
		//Naming scheme is 101 for Ace of Clubs, 413 for King of Spades
		//Generate the deck, maybe change it to generate a list of card objects?

		Table kitchenTable = new Table();
		kitchenTable.start();

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GameView gv = new GameView();
				gv.setVisible(true);
				gv.init();
			}
		});
	}

	//View for the game
	public void init() {

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

		pack();

		DrawPanel dpnl = new DrawPanel();
		add(dpnl);

        /*
        JLabel label1 = new JLabel("4 of Diamonds", JLabel.CENTER);
        label1.setHorizontalTextPosition(JLabel.LEFT);
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        add(label1);
        */

		pack();

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
}
