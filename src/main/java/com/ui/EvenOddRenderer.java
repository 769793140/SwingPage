package com.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EvenOddRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;
   // private List<String[]> positioins;

   /* public EvenOddRenderer(List<String[]> _positioins){
        this.positioins = _positioins;
    }*/

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int col) {
        this.setForeground(new Color(222, 222,
                222));
        this.setFont(new Font("微软雅黑", Font.BOLD, 14));
        if (row%2==0){
            this.setBackground(new Color(249, 249, 249));
        }else{
            this.setBackground(Color.white);
        }

        /*for(int i=0; i<table.getRowCount(); i++){
            if (row == i){
                this.setBackground(Color.white);
            }
        }
        for(String[] rowAndCol : this.positioins){
            int _row= Integer.valueOf(rowAndCol[0]);
            int _col= Integer.valueOf(rowAndCol[1]);

            if( _row == row && _col == col) {
                this.setBackground(Color.yellow);
            }
        }*/
        this.setText(value.toString());
        return this;
    }
}
