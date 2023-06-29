
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainWindow extends JFrame 
{
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private final BorderLayout layout;

    private JLabel sessionLabel;
    private JComboBox sessionComboBox;
    private final String[] listVals = {"Apple", "Orange", "Banana"};

    private JButton saveButton;
    private JButton receipButton;

    private JButton[][] seats;

    public MainWindow()
    {
        Border blackline = BorderFactory.createLineBorder(Color.black); 
        Border redline = BorderFactory.createLineBorder(Color.red); 
        Border blueline = BorderFactory.createLineBorder(Color.blue); 

        layout = new BorderLayout(5, 5);
        
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(100, 60));
        topPanel.setBorder(blackline);

        sessionLabel = new JLabel("Time: ");
        sessionComboBox = new JComboBox(listVals);

        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(sessionLabel);
        topPanel.add(sessionComboBox);

        middlePanel = new JPanel();
        middlePanel.setPreferredSize(new Dimension(100, 60));
        middlePanel.setBorder(redline);
        middlePanel.setLayout(new GridLayout(4, 6, 5, 5));

        seats = new JButton[4][6];
        Icon armchairBw = new ImageIcon(getClass().getResource("armchair-bw.png"));
		Icon armchairGreen = new ImageIcon(getClass().getResource("armchair-green.png"));
        
        for(int row = 0; row < 4; row++)
		{
			for(int col = 0; col < 6; col++)
			{
				seats[row][col] = new JButton(armchairBw);
				seats[row][col].setRolloverIcon(armchairGreen);				
				middlePanel.add(seats[row][col]);
			}
		}

        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(100, 60));
        bottomPanel.setBorder(blueline);

        saveButton = new JButton("Save");
        receipButton = new JButton("Receipt");

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(saveButton, BorderLayout.WEST);
        bottomPanel.add(receipButton, BorderLayout.EAST);

        setLayout(layout);
        
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1200, 500);
        mainWindow.setVisible(true);
    }
}
