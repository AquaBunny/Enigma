package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class InputForm extends JFrame{
    private JPanel MainPanel;
    private JTextField input;
    private JButton encodeButton;
    private JButton submitButton;
    private JLabel TopLabel;
    private JTextField shiftyCount;
    private boolean encode = true;

    InputForm() {
        super("Input");
        setContentPane(MainPanel);
        setLocation(1920/2,1080/2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Displays object
        pack();
        setVisible(true);
        //Submit button listener, used to take the input
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encode(input.getText(), shiftyCount.getText());
            }
        });
        //Swaps encode and decode
        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swapEncodeDecode();
            }
        });
        input.addKeyListener(new KeyAdapter() {
        });
    }

    private void swapEncodeDecode() {
        if(encode && encodeButton.getText().equals("Decode")) {
            encodeButton.setText("Encode");
            TopLabel.setText("To encode:");
            encode = true;
        } else if(encodeButton.getText().equals("Encode")) {
            encodeButton.setText("Decode");
            TopLabel.setText("To decode:");
            encode = false;
        } else {
            encodeButton.setText("Encode");
            TopLabel.setText("To encode:");
            encode = true;
        }
        this.pack();
    }

    private void encode(String inputLine, String shiftAmount) {
        int shifty;
        try {
            shifty = Integer.parseInt(shiftAmount);
        } catch (Exception e) {
            shifty = 1;
        }
        inputLine = inputLine.toUpperCase();
        char[] working = inputLine.toCharArray();
        if(encode) {
            for(int i = 0; i < working.length; ++i) {
                if(working[i] == ' ') {

                } else if(working[i] + shifty > 90) {
                    int temp = 90-working[i];
                    working[i] = (char) (65+(shifty-temp)-1);
                } else {
                    working[i] += shifty;
                }
            }
        } else {
            for(int i = 0; i < working.length; ++i) {
                if(working[i] == ' ') {

                }else if(working[i] - shifty < 65) {
                    int temp = working[i] - 65;
                    working[i] =(char) (90 - (shifty-temp)+1);
                } else {
                    working[i] -= shifty;
                }
            }
        }
        String fixedOutput = "";
        for(int i = 0; i < working.length; i++) {
            if(working[i] != ',') {
                fixedOutput += ""+working[i];
            }
        }
        Output output = new Output(fixedOutput);
    }
}
