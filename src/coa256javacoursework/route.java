/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework;

import static coa256javacoursework.Menu.createMenu;
import static coa256javacoursework.admin.admin.extraStops;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;

/**
 *
 * @author BenDiliberto
 */
public class route {

    public void createRoute() {
        String start;
        String end;
        try {
            final JFrame routeFrame = new JFrame();
            start = JOptionPane.showInputDialog("From:");
            end = JOptionPane.showInputDialog("To:");
            if (start.isEmpty() || end.isEmpty()) {
                IOException emptyInput = new IOException();
                throw emptyInput;
            }
            Menu menu = new Menu();
                String filename = "stopsInfo.txt";
                File f = new File(filename);
                JPanel routePanel = new JPanel(new GridLayout(0, 1));
                if (f.exists() && !f.isDirectory()) {
                    JLabel title = new JLabel("Below are the stops located between "
                            + start + " and " + end);
                    routeFrame.add(routePanel);
                    routePanel.add(title);
                    ArrayList<String> routes = readRoute(filename);
                    ArrayList<String[]> parts = new ArrayList<String[]>();
                    int i;
                    for(i = 0;i<routes.size();i++){
                        String[] route = routes.get(i).split("\\s+");
                        parts.add(route);
                    }
                    for (i = 0; i < routes.size(); i++) {
                        String[] currentRoute = parts.get(i);
                        if(start.equals(currentRoute[0])){
                            if(end.equals(currentRoute[1])){
                                for(int j=2;j<currentRoute.length;j++){
                        JLabel label = new JLabel(currentRoute[j]);
                        routePanel.add(label);
                                }
                            }
                        }
                    }
                } else {
                    JLabel title = new JLabel("Below are the stops located between "
                            + start + " and " + end);
                    routeFrame.add(routePanel);
                    routePanel.add(title);
                    int i;
                    for(i=0;i<extraStops.size();i++){
                        if(start == extraStops.get(i).get(0)){
                            if(end == extraStops.get(i).get(1)){
                            JLabel label = new JLabel(extraStops.get(i).get(2));
                            routePanel.add(label);
                            }
                        }
                    }
                }
                JButton routeButton = new JButton("Return to menu");
                routeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        routeFrame.dispose();
                        createMenu();
                    }
                });
                routePanel.add(routeButton);
                routeFrame.add(routePanel);
                routeFrame.pack();
                routeFrame.setVisible(true);
            } catch (IOException emptyInput) {
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "One/Both of the inputs are empty."
                    + " Please ensure both are filled out before continuing");
            createRoute();
        }
    }

    int readLines(String filepath) throws IOException {
        FileReader file_to_read = new FileReader(filepath);
        BufferedReader bf = new BufferedReader(file_to_read);

        String aLine;
        int numberOfLines = 0;

        while ((aLine = bf.readLine()) != null) {
            numberOfLines++;
        }
        bf.close();

        return numberOfLines;
    }

    public ArrayList<String> readRoute(String filepath) throws IOException {
        FileReader fr = new FileReader(filepath);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = readLines(filepath);
        ArrayList<String> textData = new ArrayList<String>();

        String line;

        int i;
        for (i = 0; i < numberOfLines; i++) {
            line = textReader.readLine();
            textData.add(line);
        }

        textReader.close();
        return textData;
    }
}
