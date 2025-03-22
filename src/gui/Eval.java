package gui;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import logic.*;

public class Eval {
    public void createMenu() {
        JFrame window = new JFrame("Set Evaluation");
        window.setSize(1100, 600);
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
        firstLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel secondLabel = new JLabel("Second Set:");
        secondLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField firstSet = new JTextField(20);
        firstSet.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField secondSet = new JTextField(20);
        secondSet.setFont(new Font("Arial", Font.BOLD, 20));

        entryPanel.add(firstLabel);
        entryPanel.add(firstSet);
        entryPanel.add(secondLabel);
        entryPanel.add(secondSet);

        JComboBox<String> operation = new JComboBox<>(new String[] {"Union","Intersection","Complement"});
        operation.setFont(new Font("Arial", Font.BOLD, 22));
        routePanel.add(operation);

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

        JButton eval = new JButton("Evaluate");
        eval.setFont(new Font("Arial", Font.BOLD, 18));
        eval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String route = (String) operation.getSelectedItem();

                String[] set1 = (firstSet.getText()).split(",");
                String[] set2 = (secondSet.getText()).split(",");
                String[] result = null;

                switch (route) {
                    case "Union":
                        result = Union.eval(set1, set2);
                        break;
                    case "Intersection":
                        result = Intersection.eval(set1, set2);
                        break;
                    case "Complement":
                        result = Complement.eval(set1, set2);
                        break;
                    default:
                        break;
                }

                if (result != null) {
                    outputLabel.setText("{" + String.join(",", result) + "}");
                }
            }
        });

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
