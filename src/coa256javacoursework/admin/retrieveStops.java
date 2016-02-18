/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework.admin;

import static coa256javacoursework.admin.admin.extraStops;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author BenDiliberto
 */
public class retrieveStops {
    public void retrieveFile() throws IOException{
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            extraStops.clear();
            extraStops = OpenFile(selectedFile.toString());
        }
    }
    
    public ArrayList<ArrayList<String>> OpenFile(String fileName) throws IOException{
        FileReader fr = new FileReader(fileName);
        BufferedReader textReader = new BufferedReader(fr);
        
        int numberOfLines = readLines(fileName);
        ArrayList<ArrayList<String>> textData = new ArrayList<ArrayList<String>>();
        
        String line;
        
        int i;
        for (i=0;i < numberOfLines;i++){
            line = textReader.readLine();
            String[] split = line.split("\\s+");
            List<String> l = Arrays.<String>asList(split);
            ArrayList<String> al = new ArrayList<String>(l);
            textData.add(al);
        }
        
        textReader.close();
        return textData;
    }
    
    int readLines(String filepath) throws IOException{
        FileReader file_to_read = new FileReader(filepath);
        BufferedReader bf = new BufferedReader(file_to_read);
        
        String aLine;
        int numberOfLines = 0;
        
        while ( ( aLine = bf.readLine( ) ) != null ) {
            numberOfLines++;
        }
        bf.close();
        
        return numberOfLines;
    }
    
    public ArrayList<String> readRoute(String filepath) throws IOException{
        FileReader fr = new FileReader(filepath);
        BufferedReader textReader = new BufferedReader(fr);
        
        int numberOfLines = readLines(filepath);
        ArrayList<String> textData = new ArrayList<String>();
        
        String line;
        
        int i;
        for (i=0;i < numberOfLines;i++){
            line = textReader.readLine();
            textData.add(line);
        }
        
        textReader.close();
        return textData;
    }
}
