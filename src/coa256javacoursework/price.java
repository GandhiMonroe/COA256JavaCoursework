/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework;

import static coa256javacoursework.COA256JavaCoursework.routeInfo;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author BenDiliberto
 */
public class price {

    final static String DATE_FORMAT = "dd/MM/yyyy";

    public static void createPrice() throws ParseException {
        try {
            String start;
            String end;
            start = JOptionPane.showInputDialog("From:");
            end = JOptionPane.showInputDialog("To:");
            if (start.isEmpty() || end.isEmpty()) {
                IOException emptyInput = new IOException();
                throw emptyInput;
            }
            Menu menu = new Menu();
            String stringDate = JOptionPane.showInputDialog("Please enter the date you wish to travel in the format (dd/mm/yyyy):");
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(stringDate);
            if (!isDateValid(stringDate)) {
                Exception invalidDate = new Exception();
                throw invalidDate;
            }
            int i;
            for (i = 0; i < routeInfo.size(); i++) {
                ArrayList<String> temp = routeInfo.get(i);
                String[] stockArr = new String[temp.size()];
                stockArr = temp.toArray(stockArr);
                if (stockArr[0].equals(start)) {
                    if (stockArr[1].equals(end)) {
                        double doublePrice = Double.parseDouble(stockArr[2]);
                        DecimalFormat df = new DecimalFormat("0.00");
                        df.setMaximumFractionDigits(2);
                        String[] parts = stringDate.split("/");

                        if (getLastDay(parts, stringDate)) {
                            doublePrice = doublePrice - (doublePrice / 10);
                        }
                        parts[1] = changeMonth(parts[1]);
                        String stringPrice = df.format(doublePrice);
                        JOptionPane.showMessageDialog(new JFrame(),
                                "The price of this journey from " + start
                                + " to " + end + " will cost £" + stringPrice + " on "
                                + parts[0] + " " + parts[1] + " "
                                + parts[2] + ".");
                    }
                }
            menu.createMenu();
            }
            } catch (IOException emptyInput) {
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "One/Both of the inputs are empty."
                    + " Please ensure both are filled out before continuing");
            createPrice();
        } catch (Exception invalidDate) {
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "The date you have entered is invalid");
            createPrice();
        }
    }

    public static Boolean getLastDay(String[] parts, String stringDate) {
        int[] intParts = new int[3];
        intParts[0] = Integer.parseInt(parts[0]);
        intParts[1] = Integer.parseInt(parts[1]);
        intParts[2] = Integer.parseInt(parts[2]);
        Calendar c = Calendar.getInstance();
        c.set(intParts[2], intParts[1] - 1, intParts[0]);
        c.add(Calendar.DATE, 1);
        Date date = c.getTime();
        DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
        String newDate = DATE_FORMAT.format(date);
        String[] newParts = newDate.split("/");
        int newPart = Integer.parseInt(newParts[1]);
        if (newPart - 1 == intParts[1]) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String changeMonth(String part) {
        int month = Integer.parseInt(part);
        String monthString;
        switch (month) {
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
                monthString = "Invalid month";
                break;
        }
        return monthString;
    }
}
