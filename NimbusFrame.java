// NimbusFrame.java
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class NimbusFrame extends JFrame
{
	private UIManager.LookAndFeelInfo[] looks;
	private String[] lookNames;
	private JRadioButton[] radio;
	private ButtonGroup group;
	private JButton button;
	private JLabel label;
	private JComboBox comboBox;
	
	public NimbusFrame()
	{
		super("Nimbus Look And Feel");
		
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String[looks.length];
		
		for(int i = 0; i < looks.length; i++)
			lookNames[i] = looks[i].getName();
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3, 1, 0, 5));
		
		label = new JLabel("This is a " + lookNames[1] + "look-and-feel",
			SwingConstants.CENTER);
		northPanel.add(label);
		
		button = new JButton("JButton");
		northPanel.add(button);
		
		comboBox = new JComboBox(lookNames);
		northPanel.add(comboBox);
		
		radio = new JRadioButton[looks.length];
		
		JPanel southPanel = new JPanel();
		
		int rows = (int) Math.ceil(radio.length / 3.0);
		southPanel.setLayout(new GridLayout(rows, 3));
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args)
	{
		try {
			
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}		
		}
		catch (Exception e) {
		// If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		NimbusFrame nimbusFrame = new NimbusFrame();
		nimbusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nimbusFrame.setSize(400, 220);
		nimbusFrame.setVisible(true);
	}
}