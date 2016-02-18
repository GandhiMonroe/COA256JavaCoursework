/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework.admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author BenDiliberto
 */
public class inputStops {
    JTextField stopEntry = new JTextField();
    ArrayList<String> temp = new ArrayList<>();
    public void createStops(String start, String end){
        final JFrame inputFrame = new JFrame();
        inputFrame.setLayout(new GridLayout(1,2));
        JPanel inputPanel = new JPanel(new GridLayout(1,2));
        JPanel buttons = new JPanel(new GridLayout(0,1));
        inputFrame.add(inputPanel);
        inputFrame.add(buttons);
        JLabel enter = new JLabel("Enter stop:");
        inputPanel.add(enter);
        inputPanel.add(stopEntry);
        temp.clear();
        temp.add(start);
        temp.add(end);
        JButton addStop = new JButton("Add");
        addStop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                newStops(temp);
            }
        });
        JButton returnMenu = new JButton("Return to Admin menu");
        returnMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                admin admin = new admin();
                admin.addTemp(temp);
                inputFrame.dispose();
                admin.createAdmin();
            }
        });
        buttons.add(addStop);
        buttons.add(returnMenu);
        inputFrame.pack();
        inputFrame.setVisible(true);
    }
    
    public ArrayList<String> newStops(ArrayList<String> temp){
        String stop = stopEntry.getText();
        temp.add(stop);
        for(int i=0;i<temp.size();i++){
            System.out.println(temp.get(i));
        }
        return temp;
    }
}
