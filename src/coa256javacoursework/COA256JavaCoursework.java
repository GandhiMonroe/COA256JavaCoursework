/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework;

import java.util.ArrayList;

/**
 * TODO: Fix sorting of time and cost TODO: Implement split ticket
 */
/**
 *
 * @author BenDiliberto
 */
public class COA256JavaCoursework {

    public static ArrayList<ArrayList<String>> routeInfo;

    public static void main(String[] args) {

        String file_name = "routeInfo.txt";
        Read file = new Read(file_name);
        routeInfo = file.OpenFile(file_name);
        Menu.createMenu();
    }
}
