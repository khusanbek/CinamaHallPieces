// TwoPanelButtonAction.java
import javax.swing.UIManager.*;
import javax.swing.UIManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;

public class TwoPanelButtonAction extends JFrame
{
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton defaultColor;
	
	private JLabel myLabel;
	
	private FlowLayout leftLayout;
	
	public TwoPanelButtonAction()
	{
		super("Panel frame");
		
		leftPanel = new JPanel();
		leftPanel.setSize(150, 150);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
		//leftPanel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		BoxLayout boxLayout = new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
		leftPanel.setLayout(boxLayout);
		
		rightPanel = new JPanel();
		rightPanel.setSize(450, 150);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		button1 = new JButton("Red");
		button2 = new JButton("Gray");
		button3 = new JButton("Yellow");
		defaultColor = new JButton("Default");
		
		
		PanelListener panelListener = new PanelListener();
		
		button1.addActionListener(panelListener);
		button2.addActionListener(panelListener);
		button3.addActionListener(panelListener);
		defaultColor.addActionListener(panelListener);
		
		myLabel = new JLabel("My label");
		
		leftPanel.add(button1);
		leftPanel.add(button2);
		leftPanel.add(button3);
		leftPanel.add(defaultColor);
				
		rightPanel.add(myLabel);
		
		// setLayout(new FlowLayout());
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel);
		//add();
	}
	
	private class PanelListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e){  
			
			if(e.getSource() == button1)
				myLabel.setForeground(Color.RED);
			
			if(e.getSource() == button2)
				myLabel.setForeground(Color.GRAY);
			
			if(e.getSource() == button3)
				myLabel.setForeground(Color.YELLOW);
			
			if(e.getSource() == defaultColor)
				myLabel.setForeground(Color.BLACK);
		}
	}
	
	public static void main(String[] args)
	{
		try {
			
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			
			
		} catch (Exception e) {
		// If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		TwoPanelButtonAction myFrame = new TwoPanelButtonAction();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(700, 400);
		myFrame.setVisible(true);
		
		System.out.println("Hello world!");
	}
}