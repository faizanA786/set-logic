package gui;

import java.awt.event.*;
import javax.swing.*;

public class Menu {
    public void createMenu() {
        JFrame window = new JFrame("Set Logic");
        window.setSize(400, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton evalSets = new JButton("Evaluate Expressions");
        evalSets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.dispose();

                Eval eval = new Eval();
                eval.createMenu();
            }
        });

        window.add(evalSets);
        window.setVisible(true);
    }
}
