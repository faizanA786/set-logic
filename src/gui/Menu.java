/*
 * Menu.java
 * Links features in main window
*/

package gui;

//dependancies
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Menu {
    public void createMenu() { // responsible for creating landing window upon launch
        JFrame window = new JFrame("Main Menu");
        window.setSize(600, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel evalPanel = new JPanel();
        JPanel buildPanel = new JPanel();

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("<html><u>Set Logic<u><html>");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        titlePanel.add(title);

        JButton evalSets = new JButton("Evaluate Expressions");
        evalSets.setFont(new Font("Arial", Font.BOLD, 36));
        evalSets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.dispose();

                Eval eval = new Eval();
                eval.createMenu();
            }
        });
        evalPanel.add(evalSets);

        JButton buildSet = new JButton("Set Builder");
        buildSet.setFont(new Font("Arial", Font.BOLD, 36));
        buildSet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.dispose();

                Create createSet = new Create();
                createSet.createMenu();
            }
        });
        buildPanel.add(buildSet);
        
        main.add(titlePanel);
        main.add(evalPanel);
        main.add(buildPanel);
        window.add(main);
        window.setVisible(true);
        //END createMenu
    }
}
