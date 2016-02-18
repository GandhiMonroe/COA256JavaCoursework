/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework.admin;

import coa256javacoursework.Read;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author BenDiliberto
 */
public class stops {
    public ArrayList<ArrayList<String>> getStops() throws FileNotFoundException, IOException{
        String file_name = "stopsInfo.txt";
        ArrayList<ArrayList<String>> stopInfo = null;
        Read file = new Read( file_name );
        stopInfo = file.OpenFile(file_name);
        int i;
        for (i=0; i<stopInfo.size();i++){
            System.out.println(stopInfo.get(i));
        }
        return stopInfo;
    }
    
    public boolean checkFile(){
        File f = new File("stopsInfo");
        if(f.exists() && !f.isDirectory()) {
            return true;
        } else{
            return false;
        }
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
}
