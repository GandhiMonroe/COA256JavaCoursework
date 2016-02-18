/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework.admin;

import static coa256javacoursework.admin.admin.extraStops;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author BenDiliberto
 */
public class saveStops {
    public void fileChoice(){
        admin admin = new admin();
        final JFrame choiceFrame = new JFrame();
        choiceFrame.setLayout(new GridLayout(0,1));
        JButton defaultFile = new JButton("Do you want to use the default file?");
        defaultFile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try {
                        File file = new File("stopsInfo.txt");
                        BufferedWriter bw;
                        bw = new BufferedWriter(new FileWriter(file));
                        for(int i=0;i<extraStops.size();i++){
                            for(int j=0;j<extraStops.get(i).size();j++){
                                bw.write(extraStops.get(i).get(j) + " ");
                            }
                            bw.newLine();
                        }
                        bw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(saveStops.class.getName()).log(Level.SEVERE, null, ex);
                    }  
            }
        });
        JButton userFile = new JButton("Or a file of your specification?");
        userFile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                File file = new File("stopsInfo.txt");
                if(file.exists()){
                    file.delete();
                }
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("text file","txt");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showSaveDialog(choiceFrame);
                if(returnVal == JFileChooser.APPROVE_OPTION) {  
                    try {
                        BufferedWriter bw;
                        bw = new BufferedWriter(new FileWriter(chooser.getSelectedFile()));
                        for(int i=0;i<extraStops.size();i++){
                            for(int j=0;j<extraStops.get(i).size();j++){
                                bw.write(extraStops.get(i).get(j) + " ");
                            }
                            bw.newLine();
                        }
                        JOptionPane.showMessageDialog(new JFrame(),
                                "The file has been saved as " + chooser.getSelectedFile());
                        bw.close();
                        choiceFrame.dispose();
                    } catch (IOException ex) {
                        Logger.getLogger(saveStops.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }
            }
            });
        choiceFrame.add(defaultFile);
        choiceFrame.add(userFile);
        choiceFrame.pack();
        choiceFrame.setVisible(true);
    }
}
