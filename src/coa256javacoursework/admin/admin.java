/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework.admin;

import coa256javacoursework.Menu;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author BenDiliberto
 */
public class admin {
    JFrame adminFrame = new JFrame();
    DefaultListModel listModel = new DefaultListModel();
    JList startList = new JList(listModel);
    JList endList = new JList(listModel);
    stops stops = new stops();
    public static ArrayList<ArrayList<String>> extraStops = new ArrayList<ArrayList<String>>();
    public void createAdmin(){
        adminFrame.setLayout(new GridLayout(1,3));
        JPanel startPanel = new JPanel(new GridLayout(0,1));
        JLabel startLabel = new JLabel("From:");
        startPanel.add(startLabel);
        startPanel.add(startList);
        adminFrame.add(startPanel);
        JPanel endPanel = new JPanel(new GridLayout(0,1));
        JLabel endLabel = new JLabel("To:");
        endPanel.add(endLabel);
        endPanel.add(endList);
        adminFrame.add(endPanel);
        JPanel buttons = new JPanel(new GridLayout(0,1));
        adminFrame.add(buttons);
        populateCombos();
        JButton addRoute = new JButton("Input Route");
        addRoute.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String start = startList.getSelectedValue().toString();
                String end = endList.getSelectedValue().toString();
                adminFrame.setVisible(false);
                inputStops input = new inputStops();
                input.createStops(start,end);
            }
        });
        JButton saveRoute = new JButton("Save Route");
        saveRoute.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                saveStops save = new saveStops();
                save.fileChoice();
            }
        });
        JButton retrieveRoute = new JButton("Retrieve Route");
        retrieveRoute.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                retrieveStops retrieve = new retrieveStops();
                try {
                    retrieve.retrieveFile();
                } catch (IOException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton returnMenu = new JButton("Return to Menu");
        returnMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Menu menu = new Menu();
                adminFrame.dispose();
                Menu.menuFrame.setVisible(true);
            }
        });
        buttons.add(addRoute);
        buttons.add(saveRoute);
        buttons.add(retrieveRoute);
        buttons.add(returnMenu);
        adminFrame.pack();
        adminFrame.setVisible(true);
        for(int i = 0;i<extraStops.size();i++){
            System.out.println(extraStops.get(i));
        }
    }
    
    public void populateCombos(){
        String[] stops = {"Leicester","Loughborough","Nottingham","Derby","York"};
        listModel.clear();
        for(int i = 0;i<stops.length;i++){
            listModel.addElement(stops[i]);
        }
    }
    
    public void addTemp(ArrayList<String> temp){
        extraStops.add(temp);
    }
}
