package com.company;

import javax.swing.*;

public class Output extends JFrame{
    private JPanel MainPanel;
    private JTextPane outputPane;

    Output(String s) {
        super("Output");
        setContentPane(MainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(1920/2, 1080/2);
        outputPane.setText(s);
        //Displays Object
        pack();
        setVisible(true);
    }
}
