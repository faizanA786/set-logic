/*
 * Create.java
 * Handles set creation window
*/

package gui;

//dependancies
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import logic.*;

public class Create { 
    public void createMenu() { // responsible for creating the window for the set builder feature
        JFrame window = new JFrame("Set Builder");
        window.setSize(1000, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        JPanel numPanel = new JPanel();
        JPanel rangePanel = new JPanel();
        JPanel factorsPanel = new JPanel();
        JPanel outputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        titlePanel.add(new JLabel("(Seperate values by commas eg x,y,z)"));

        JLabel numLabel = new JLabel("Default number set N (Positive Integers)");
        numLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel rangeLabel = new JLabel("Default size of set 10 items");
        rangeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        JLabel factorsLabel = new JLabel("Enter factors of set (5, 7)");
        factorsLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // JTextField numEntry = new JTextField(20);
        // numEntry.setFont(new Font("Arial", Font.BOLD, 20));
        // JTextField rangeEntry = new JTextField(20);
        // rangeEntry.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField factorsEntry = new JTextField(20);
        factorsEntry.setFont(new Font("Arial", Font.BOLD, 20));

        numPanel.add(numLabel);
        // numPanel.add(numEntry);
        rangePanel.add(rangeLabel);
        // rangePanel.add(rangeEntry);
        factorsPanel.add(factorsLabel);
        factorsPanel.add(factorsEntry);

        JLabel outputLabel = new JLabel("<OUTPUT>");
        outputLabel.setFont(new Font("Arial", Font.BOLD, 30));
        outputPanel.add(outputLabel);

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.dispose();

                Menu menu = new Menu();
                menu.createMenu();
            }
        });

        JButton eval = new JButton("Construct");
        eval.setFont(new Font("Arial", Font.BOLD, 18));
        eval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // String[] numSets = (numEntry.getText().replaceAll("\\s+", "")).split(",");
                String[] factors = (factorsEntry.getText().replaceAll("\\s+", "")).split(",");
                // String range = (rangeEntry.getText().replaceAll("\\s+", ""));

                Builder builder = new Builder();
                outputLabel.setText(builder.buildSet(factors));
            }
        });

        buttonPanel.add(eval);
        buttonPanel.add(back);

        mainPanel.add(titlePanel);

        mainPanel.add(numPanel);
        mainPanel.add(rangePanel);
        mainPanel.add(factorsPanel);
        mainPanel.add(outputPanel);
        mainPanel.add(buttonPanel);

        window.add(mainPanel);
        window.setVisible(true);

        JOptionPane.showMessageDialog(window, "Note: This feature only works with numerical values!");
        //END createMenu
    }   
}
