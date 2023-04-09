// CinemaHall.java
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.Random;

public class CinemaHall extends JFrame
{
	private JButton[][] buttons;
	private Random rand;
	
	public CinemaHall()
	{
		super("Cinema Hall");
		setLayout(new GridLayout(11, 14, 5, 5));
		
		rand = new Random();
		int randRow = 0, randCol = 0;
		
		buttons = new JButton[11][14];
		
		Icon armchair = new ImageIcon(getClass().getResource("armchair.png"));
		Icon armchairBw = new ImageIcon(getClass().getResource("armchair-bw.png"));
		Icon armchairGreen = new ImageIcon(getClass().getResource("armchair-green.png"));
		
		for(int row = 0; row < 11; row++)
		{
			for(int col = 0; col < 14; col++)
			{
				buttons[row][col] = new JButton(armchairBw);
				buttons[row][col].setRolloverIcon(armchairGreen);				
				add(buttons[row][col]);
			}
		}
	}
	
	public static void main(String[] args)
	{
		CinemaHall cinameHall = new CinemaHall();
		cinameHall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cinameHall.setSize(1300, 800);
		cinameHall.setVisible(true);
	}
}