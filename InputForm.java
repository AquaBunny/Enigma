package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class InputForm extends JFrame{
    private JPanel MainPanel;
    private JTextField input;
    private JButton encodeButton;
    private JButton submitButton;
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
                encode(input.getText());
            }
        });
        //Swaps encode and decode
        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swapEncodeDecode();
            }
        });
    }

    private void swapEncodeDecode() {
        if(encode && encodeButton.getText().equals("Decode")) {
            encodeButton.setText("Encode");
            encode = true;
        } else if(encodeButton.getText().equals("Encode")) {
            encodeButton.setText("Decode");
            encode = false;
        } else {
            encodeButton.setText("Encode");
            encode = true;
        }
        this.pack();
    }

    private void encode(String inputLine) {
        String outputString;
        inputLine = inputLine.toUpperCase();
        char[] working = inputLine.toCharArray();
        if(encode) {
            for(int i = 0; i < working.length; ++i) {
                if(working[i] == ' ') {

                } else if(working[i] == 90) {
                    working[i] = 65;
                } else {
                    working[i] += 1;
                }
            }
        } else {
            for(int i = 0; i < working.length; ++i) {
                if(working[i] == 65) {
                    working[i] = 90;
                } else {
                    working[i] -= 1;
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
