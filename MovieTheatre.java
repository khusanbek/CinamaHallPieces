import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import java.awt.BorderLayout;

public class MovieTheatre extends JFrame {
    
    private JPanel movieListPanel;
    private JPanel mainPanel;
    private JPanel receiptPanel;

    private JPanel mainTimePanel = new JPanel();
    private JLabel timeLabel = new JLabel("Time:");
    private String[] comboValues = {"One", "Two", "Three"};
    private JComboBox sessionComboBox = new JComboBox(comboValues);

    private JPanel seatsChooserPanel = new JPanel();
    private JPanel SaveReceiptPanel = new JPanel();

    public MovieTheatre() {

        super("Movie theatre");
        
        JLabel movieListLabel = new JLabel("Movie list");       
        JLabel mainWindowLabel = new JLabel("Main Window");     
        JLabel receiptLabel = new JLabel("Receipt Info");       
    
        // movie list panel
        movieListPanel = new JPanel();
        movieListPanel.setBorder(new TitledBorder(
            new LineBorder(Color.BLACK), "Movie list"));
        movieListPanel.setPreferredSize(new Dimension(250, 700));

        // main panel
        mainPanel = new JPanel();
        mainPanel.setBorder(new TitledBorder(
            new LineBorder(Color.BLACK), "Main window"));
        mainTimePanel.add(timeLabel);
        mainTimePanel.add(sessionComboBox);
        mainTimePanel.setBorder(new TitledBorder(
            new LineBorder(Color.BLACK), "Movie list"));

        seatsChooserPanel = new JPanel();
        seatsChooserPanel.setBorder(new TitledBorder(
            new LineBorder(Color.BLACK), "Movie list"));
        seatsChooserPanel.setPreferredSize(new Dimension(500, 200));

        // receipt Panel
        receiptPanel = new JPanel();
        receiptPanel.setBorder(new TitledBorder(
            new LineBorder(Color.BLACK), "Receipt info"));
        receiptPanel.setPreferredSize(new Dimension(300, 700));

        movieListPanel.add(movieListLabel);
        //mainPanel.add(mainWindowLabel);
        mainPanel.add(mainTimePanel);
        mainPanel.add(seatsChooserPanel);
        receiptPanel.add(receiptLabel);

        add(movieListPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        add(receiptPanel, BorderLayout.EAST);

        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new MovieTheatre();
    }
}
