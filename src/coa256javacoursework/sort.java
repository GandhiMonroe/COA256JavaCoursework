/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coa256javacoursework;
import static coa256javacoursework.COA256JavaCoursework.routeInfo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BenDiliberto
 */

public class sort {
    DefaultTableModel model = new DefaultTableModel(0,4){
        public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Double.class;
                    case 3:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }
    };
    public void createSort(){
        final JFrame sortFrame = new JFrame();
        JPanel sortPanel = new JPanel();
        JTable sortTable = new JTable(model);
        JButton returnMenu = new JButton("Return to Menu");
        returnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                sortFrame.dispose();
                Menu menu = new Menu();
                menu.createMenu();
            }
        });
        returnMenu.setPreferredSize(new Dimension(150, 40));
        getTableValues();
        sortTable.setAutoCreateRowSorter(true);
        sortPanel.add(new JScrollPane(sortTable));
        sortPanel.add(returnMenu);
        sortFrame.add(sortPanel,BorderLayout.CENTER);
        sortFrame.pack();
        sortFrame.setVisible(true);
    }
    
    public void getTableValues(){
        Object[][] data = new Object[20][4];
        Object[] columns = {"From:","To:","Cost","Price"};
        for(int i=0;i<routeInfo.size();i++){
                data[i][0] = routeInfo.get(i).get(0);
                data[i][1] = routeInfo.get(i).get(1);
                data[i][2] = Double.parseDouble(routeInfo.get(i).get(2));
                data[i][3] = Integer.parseInt(routeInfo.get(i).get(3));
        }
        model.setDataVector(data,columns);
    }
}
