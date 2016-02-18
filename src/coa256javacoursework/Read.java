/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author BenDiliberto
 */
public class Read {

    private String path;

    public Read(String file_path) {
        path = file_path;
    }

    public ArrayList<ArrayList<String>> OpenFile(String fileName) {
        ArrayList<ArrayList<String>> textData = new ArrayList<>();
        try {
            File fileRead = new File(fileName);
            if (!fileRead.exists()) {
                FileNotFoundException noFile = new FileNotFoundException();
                throw noFile;
            }
            FileReader fr = new FileReader(fileName);
            BufferedReader textReader = new BufferedReader(fr);

            int numberOfLines = readLines(fileName);
            String line;
            int i;
            for (i = 0; i < numberOfLines; i++) {
                line = textReader.readLine();
                String[] split = line.split("\\s+");
                List<String> l = Arrays.<String>asList(split);
                ArrayList<String> al = new ArrayList<>(l);
                textData.add(al);
            }
            textReader.close();
            return textData;
        } catch (FileNotFoundException noFile) {
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "File does not exist");
        } catch (IOException ex) {
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "Error with file reading, please"
                    + " check the file contents and format");
        }
        return textData;
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
