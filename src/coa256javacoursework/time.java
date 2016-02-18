/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework;

import static coa256javacoursework.COA256JavaCoursework.routeInfo;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author BenDiliberto
 */
public class time {

    public static void createTime() {
        String start;
        String end;
        try {
            start = JOptionPane.showInputDialog("From:");
            end = JOptionPane.showInputDialog("To:");
            if (start.isEmpty() || end.isEmpty()) {
                IOException emptyInput = new IOException();
                throw emptyInput;
            }
            Menu menu = new Menu();
            int i;
            for (i = 0; i < routeInfo.size(); i++) {
                ArrayList<String> temp = routeInfo.get(i);
                String[] stockArr = new String[temp.size()];
                stockArr = temp.toArray(stockArr);
                if (stockArr[0].equals(start)) {
                    if (stockArr[1].equals(end)) {
                        int timeTaken = Integer.parseInt(stockArr[3]);
                        int hours = timeTaken / 60;
                        int minutes = timeTaken - (hours * 60);
                        JOptionPane.showMessageDialog(new JFrame(),
                                "The journey from " + start + " to " + end + " will take "
                                + hours + " hours and " + minutes + " minutes.");
                    }
                }
            }
            menu.createMenu();
            }catch(IOException emptyInput){
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "One/Both input(s) are invalid");
            createTime();
        }
    }
}
