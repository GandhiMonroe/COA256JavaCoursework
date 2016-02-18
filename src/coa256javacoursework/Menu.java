/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework;

import static coa256javacoursework.COA256JavaCoursework.routeInfo;
import coa256javacoursework.admin.admin;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static coa256javacoursework.price.createPrice;
import static coa256javacoursework.time.createTime;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BenDiliberto
 */
public class Menu {

    public static JFrame menuFrame = new JFrame("Menu");

    public static void createMenu() {
        JPanel buttons = new JPanel(new GridLayout(0, 1));
        menuFrame.add(buttons);

        JButton time = new JButton("Time");
        time.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
                createTime();
            }
        });

        JButton price = new JButton("Price");
        price.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
                try {
                    createPrice();
                } catch (ParseException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton route = new JButton("Route");
        route.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                route route = new route();
                menuFrame.dispose();
                route.createRoute();
            }
        });

        JButton split = new JButton("Split Ticket");
        split.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connection connection = new connection();
                menuFrame.dispose();
                connection.createConnect();
            }
        });

        JButton sort = new JButton("Sort Routes");
        sort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sort sort = new sort();
                menuFrame.dispose();
                sort.createSort();
            }
        });

        JButton admin = new JButton("Admin");
        admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin admin = new admin();
                menuFrame.dispose();
                admin.createAdmin();
            }
        });

        JButton end = new JButton("End");
        end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttons.add(time);
        buttons.add(price);
        buttons.add(route);
        buttons.add(split);
        buttons.add(sort);
        buttons.add(admin);
        buttons.add(end);
        menuFrame.pack();
        menuFrame.setVisible(true);
    }
    
    public boolean checkStation(String start, String end){
        for(int i=0;i<routeInfo.size();i++){
            if(start == routeInfo.get(i).get(0)){
                if(end == routeInfo.get(i).get(1)){
                    return true;
                }
            }
        }
        return false;
    }
}
