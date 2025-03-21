package gui;

import java.awt.event.*;
import javax.swing.*;

public class Eval {
    public void createMenu() {
        JFrame window = new JFrame("Set Evaluation");
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // sets to block-level panels

        JPanel titlePanel = new JPanel();
        JPanel entryPanel = new JPanel();
        JPanel routePanel = new JPanel();
        JPanel outputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        titlePanel.add(new JLabel("(Seperate values by commas eg 2,5,7)"));

        JLabel firstLabel = new JLabel("First Set:");
        JLabel secondLabel = new JLabel("Second Set:");

        JTextField firstSet = new JTextField(20);
        JTextField secondSet = new JTextField(20);

        entryPanel.add(firstLabel);
        entryPanel.add(firstSet);
        entryPanel.add(secondLabel);
        entryPanel.add(secondSet);

        JComboBox operation = new JComboBox<>(new String[] {"Union","Intersection","Complement"});
        routePanel.add(operation);

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(window, "Back");
            }
        });

        JButton eval = new JButton("Evaluate");
        eval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(window, "Evaluating");
                String route = (String) operation.getSelectedItem();
            }
        });

        JLabel outputLabel = new JLabel("OUTPUT");
        outputPanel.add(outputLabel);

        buttonPanel.add(eval);
        buttonPanel.add(back);

        mainPanel.add(titlePanel);
        mainPanel.add(entryPanel);
        mainPanel.add(routePanel);
        mainPanel.add(outputPanel);
        mainPanel.add(buttonPanel);

        window.add(mainPanel);
        window.setVisible(true);

    }
}
