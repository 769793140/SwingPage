package com.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.util.Vector;

public class MyTable extends JTable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MyTable()
    {

    }
    public MyTable(Object[][] tableDate,String[] name)
    {
        super(tableDate,name);
    }

    /**
     * @Override
     */
    @Override
    public JTableHeader getTableHeader()
    {
        JTableHeader tableHeader = super.getTableHeader();
        tableHeader.setReorderingAllowed(false);   //设置表格列不可重排
        DefaultTableCellRenderer hr =(DefaultTableCellRenderer)tableHeader.getDefaultRenderer();  //获得表格头的单元格对象

        hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);  //列名居中
        return tableHeader;

    }
    /**
     * @Override
     */
    @Override
    public TableCellRenderer getDefaultRenderer(Class<?>columnClass)
    {
        DefaultTableCellRenderer cr =(DefaultTableCellRenderer)super.getDefaultRenderer(columnClass);
        cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);  //单元格内容居中
        return cr;
    }
    /**
     * @Override
     */
    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;   //单元格不可修改
    }
}
