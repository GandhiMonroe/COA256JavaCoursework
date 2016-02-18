/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework;

import static coa256javacoursework.COA256JavaCoursework.routeInfo;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BenDiliberto
 */
public class connection {

    public ArrayList<String> connections = new ArrayList<String>();

    public void createConnect() {
        final JFrame connectFrame = new JFrame();
        JPanel connectPanel = new JPanel();
        try{
        String start;
        String end;
        start = JOptionPane.showInputDialog("From:");
        end = JOptionPane.showInputDialog("To:");
        if(start.isEmpty() || end.isEmpty()){
            IOException emptyInput = new IOException();
            throw emptyInput;
        }
        Menu menu = new Menu();
        JButton returnMenu = new JButton("Return to Menu");
        DefaultTableModel model = new DefaultTableModel(0, 5);
        JTable table = new JTable(model);
        connectPanel.add(new JScrollPane(table));
        returnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connectFrame.dispose();
                Menu menu = new Menu();
                menu.createMenu();
            }
        });
        for (int i = 0; i < routeInfo.size(); i++) {
            connections = searchConnect(i, start, end);
            if (!connections.isEmpty()) {
                Object[] stockArr = new Object[connections.size()];
                stockArr = connections.toArray(stockArr);
                model.addRow(stockArr);
            }
        }
        returnMenu.setPreferredSize(new Dimension(150, 40));
        connectPanel.add(returnMenu);
        connectFrame.add(connectPanel);
        connectFrame.pack();
        connectFrame.setVisible(true);
        }catch(IOException emptyInput){
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "One/Both input(s) are invalid");
            createConnect();
        }
    }

    public ArrayList<String> searchConnect(int i, String start, String end) {
        ArrayList<String> singleTrain = new ArrayList<String>();
        ArrayList<String> firstSearch = routeInfo.get(i);
        String newStart;
        if (firstSearch.indexOf(start) == 0) {
            newStart = firstSearch.get(1);
            int k;
            for (k = 0; k < routeInfo.size(); k++) {
                ArrayList<String> secondSearch = routeInfo.get(k);
                if (secondSearch.indexOf(newStart) == 0) {
                    if (secondSearch.indexOf(end) == 1) {
                        singleTrain.add(firstSearch.get(0));
                        singleTrain.add(firstSearch.get(1));
                        singleTrain.add(secondSearch.get(1));
                        Double cost = Double.parseDouble(firstSearch.get(2))
                                + Double.parseDouble(secondSearch.get(2));
                        String stringCost = cost.toString();
                        int time = Integer.parseInt(firstSearch.get(3))
                                + Integer.parseInt(secondSearch.get(3));
                        String stringTime = time + "";
                        singleTrain.add(stringCost);
                        singleTrain.add(stringTime);
                        return singleTrain;
                    }
                }
            }
        }
        return singleTrain;
    }
}
