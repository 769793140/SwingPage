package com.ui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class demo3 implements TreeSelectionListener {
    //容器
    JFrame frame;
    /**
     * 树
     */
    JTree tree;
    /**
     * 上部的标签
     */
    JLabel labelTop;
    /**
     * 下部的标签
     */
    JLabel labelDown;
    /**
     * 面板页
     */
    JClosableTabbedPane tabbedPane;
    /**
     * 树面板
     */
    JPanel panelTree;
    /**
     * 上部面板
     */
    JPanel panelTop;
    /**
     * 上部面板
     */
    JPanel panelDown;
    /**
     * 系统首页
     */
    JPanel panelSystem;
    /**
     * 滚动面板
     */
    JScrollPane scrollPane;

    public static void main(String[] args) {
        demo3 demo3 = new demo3();
        //demo3.setVisible(true);
    }

    demo3() {
        frame = new JFrame("系统");
        Container con = frame.getContentPane();
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建树
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("模块选择");
        String Teachers[][] = new String[3][];
        Teachers[0] = new String[]{"数据预览", "数据导入"};
        Teachers[1] = new String[]{"胡会强", "张春辉", "张春辉", "张春辉", "张春辉", "张春辉", "张春辉", "张春辉", "张春辉", "张春辉", "张春辉", "张春辉", "张春辉"};
        Teachers[2] = new String[]{"模型数据分析", "自定义数据分析", "批量数据分析", "批量数据明细分析"};
        String gradeNames[] = {"1 数据导入", "2 数据整理", "3 数据分析"};
        DefaultMutableTreeNode node = null;
        DefaultMutableTreeNode childNode = null;
        int length = 0;
        for (int i = 0; i < 3; i++) {
            length = Teachers[i].length;
            node = new DefaultMutableTreeNode(gradeNames[i]);
            for (int j = 0; j < length; j++) {
                childNode = new DefaultMutableTreeNode(Teachers[i][j]);
                node.add(childNode);
            }
            root.add(node);
        }
        panelTree = new JPanel(new BorderLayout());
        tree = new JTree(root);
        tree.setRowHeight(45);
        tree.setRootVisible(false);
        DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer) tree
                .getCellRenderer();
        cellRenderer.setLeafIcon(new ImageIcon(""));
        cellRenderer.setOpenIcon(new ImageIcon(""));
        cellRenderer.setClosedIcon(new ImageIcon(""));

        cellRenderer.setFont(new Font("微软雅黑", Font.PLAIN, 13));// 设置字体.
        cellRenderer.setBackgroundNonSelectionColor(Color.white);
        //设置选择时的背景颜色
        cellRenderer.setBackgroundSelectionColor(new Color(29, 176, 234));
        // cellRenderer.setBorderSelectionColor(Color.red);
        /*
         * 设置选时或不选时，文字的变化颜色
         */
        cellRenderer.setTextNonSelectionColor(Color.black);
        cellRenderer.setTextSelectionColor(Color.white);
        tree.putClientProperty("JTree.lineStyle", "None");
        tree.addTreeSelectionListener(this);//给整个树加选择监听
        tree.setMinimumSize(new Dimension(300, 560));
        //加入滚动面板
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(tree);
        scrollPane.setBackground(Color.white);
        scrollPane.setVisible(true);
        scrollPane.setPreferredSize(new Dimension(150, 800));
        //设置边框
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //con.add(scrollPane);
        panelTree.add(scrollPane, BorderLayout.CENTER);
        JLabel panelTreeLableLeft = new JLabel("               ");
        //设置标签显示
        panelTreeLableLeft.setOpaque(true);
        panelTreeLableLeft.setBackground(new Color(231, 238, 246));

        panelTree.add(panelTreeLableLeft, BorderLayout.WEST);

        JLabel panelTreeLableRight = new JLabel("               ");
        panelTreeLableRight.setOpaque(true);
        panelTreeLableRight.setBackground(new Color(231, 238, 246));
        panelTree.add(panelTreeLableRight, BorderLayout.EAST);
        //panelTree.add(tree);
        panelTree.setBackground(Color.LIGHT_GRAY);
        panelTree.setMinimumSize(new Dimension(100, 100));
        panelTree.setVisible(true);
        frame.getContentPane().add(panelTree, BorderLayout.WEST);
        // 设置窗口最小尺寸
        //frame.setMinimumSize(new Dimension(1060, 560));
        //上部按钮
        panelTop = new JPanel();
        labelTop = new JLabel(new ImageIcon("C:\\Users\\PC\\Desktop\\头部.png"));
        labelTop.setOpaque(true);
        labelTop.setBounds(0, 0, 0, 0);
        panelTop.add(labelTop);
        //panelTop.setBackground(Color.blue);
        frame.add(panelTop, BorderLayout.NORTH);
        //
        tabbedPane = new JClosableTabbedPane();
        tabbedPane.setBounds(0, 0, 0, 0);
        /*tabbedPane.setForeground(new Color(191, 191,
                191));*/
        //tabbedPane.setBackground(Color.white);
        //选项卡样式
        tabbedPane.setUI(new TabbedPaneUI("0x1eb0eb", "0xffffff"));
        //tabbedPane.setUI(new EclipseTabbedPaneUI());
        //tabbedPane.setUI(new MaterialTabbedPaneUI());
        tabbedPane.setOpaque(true);
        tabbedPane.setVisible(true);
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int count = tabbedPane.getTabCount();
                for (int i = 0; i < count; i++) {
                    if (i!=tabbedPane.getSelectedIndex()) {
                        tabbedPane.setForegroundAt(i,new Color(191, 191,
                                191));
                    }
                }
                tabbedPane.setForegroundAt(0,new Color(191, 191,
                        191));
                tabbedPane.setForegroundAt(tabbedPane.getSelectedIndex(),Color.white);

            }
        });

        panelSystem = new JPanel();
        panelSystem.setBackground(Color.white);
        tabbedPane.addTab("系统首页", panelSystem,false);
        tabbedPane.setBackgroundAt(0,Color.white);
        //tabbedPane.add("系统首页", demo3.cerateSystem("模型数据分析"));
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        panelDown = new JPanel();
        labelDown = new JLabel("下面");
        //设置字体
        // label.setFont(new Font(null, Font.PLAIN, 50));
        //设置居中
        // label.setHorizontalAlignment(SwingConstants.CENTER);
        panelDown.add(labelDown);
        panelDown.setBackground(Color.black);
        //frame.add(panelDown, BorderLayout.SOUTH);
        // 调整此窗口的大小，以适合其子组件的首选大小和布局
        frame.pack();
        frame.setVisible(true);
        //设置窗口尺寸是否固定不变
        //frame.setResizable(true);
        //frame.getContentPane().setBackground(Color.white);
    }

    //创建系统首页
    public static JPanel cerateSystem(String obj) {
        JPanel jPanel = new JPanel();
        MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(191, 191,
                191));
        if (obj.equals("模型数据分析")) {
            /**
             * 第一部分
             */
            JLabel jLabelOne = new JLabel("步骤一：选择数据库");
            //设置字体
            jLabelOne.setFont(new Font("微软雅黑", Font.BOLD, 17));
            jLabelOne.setForeground(new Color(78, 201, 243));
            //设置居左
            //jLabelOne.setHorizontalAlignment(SwingConstants.LEFT);
            JLabel jLabelOne2 = new JLabel("需要分析的表名称：反洗钱_南京证券股票交易流水_2013_07_09_15_52_52");
            jLabelOne2.setFont(new Font("微软雅黑", Font.BOLD, 17));
            jLabelOne2.setForeground(Color.black);
            String[] name = {"股票交易流水客户号", "股票交易流水客户名称", "股票交易流水股东账号", "股票交易流水成交日期", "股票交易流水成交时间", "股票交易流水股票代码"};
            Object[][] tableDate = new Object[3][6];
            for (int i = 0; i < 3; i++) {
                tableDate[i][0] = "1000" + i;
                for (int j = 1; j < 6; j++) {
                    tableDate[i][j] = 0;
                }
            }
            MyTable table = new MyTable(tableDate, name);
            // 水平线不显示
            // table.setShowHorizontalLines(false);
            //垂直线不显示
            //table.setShowVerticalLines(false);
            //设置网格线不显示
            table.setShowGrid(false);
            //设置不可对表格进行操作
            table.setEnabled(false);
            EvenOddRenderer tablecellRender = new EvenOddRenderer();
            table.setDefaultRenderer(Object.class, tablecellRender);
            //设置行高度
            table.setRowHeight(25);
           // table.setBorder(border);
            //设置大小
            JTableHeader tableHeader = table.getTableHeader();
            tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));
            tableHeader.setFont(new Font("微软雅黑", Font.PLAIN, 10));
            tableHeader.setBackground(new Color(247, 247,
                    247, 142));
            tableHeader.setForeground(Color.LIGHT_GRAY);

            table.setBackground(Color.WHITE);
            JScrollPane pane = new JScrollPane(table);
            pane.setPreferredSize(new Dimension(800, 100));
            pane.getViewport().setBackground(Color.WHITE);
            /**
             * 第二部分
             */
            JLabel jLabelTwo = new JLabel("步骤二：选择固化类型");
            //设置字体
            jLabelTwo.setFont(new Font("微软雅黑", Font.BOLD, 17));
            jLabelTwo.setForeground(new Color(78, 201, 243));
            //设置居中
            //jLabelTwo.setHorizontalAlignment(SwingConstants.LEFT);
            JTabbedPane jTabbedPane = new JTabbedPane();
            jTabbedPane.setUI(new MaterialTabbedPaneUI());
            //jTabbedPane.setUI(new MaterialTabbedPaneUI());
            jTabbedPane.setOpaque(true);

            /*jButtonDemo32.setBorder(border);*/
            jTabbedPane.setBorder(border);
            //jTabbedPane.setVisible(true);
            //jTabbedPane.setBounds(0, 50, 600, 150);
            JPanel jPanelDemo1 = new JPanel(new MigLayout("wrap1,insets 10 10 10 10", "", ""));
            jPanelDemo1.setBackground(Color.white);
            JLabel jPanelDemo1Label1 = new JLabel("交易类指标-ZJ01资金交易排行");
            JLabel jPanelDemo1Label2 = new JLabel("交易类指标-ZJ01资金交易排行");
            JLabel jPanelDemo1Label3 = new JLabel("交易类指标-ZJ01资金交易排行");
            JLabel jPanelDemo1Label4 = new JLabel("交易类指标-ZJ01资金交易排行");
            JLabel jPanelDemo1Label5 = new JLabel("交易类指标-ZJ01资金交易排行");
            jPanelDemo1Label1.setForeground(new Color(191, 191,
                    191));
            jPanelDemo1Label2.setForeground(new Color(191, 191,
                    191));
            jPanelDemo1Label3.setForeground(new Color(191, 191,
                    191));
            jPanelDemo1Label4.setForeground(new Color(191, 191,
                    191));
            jPanelDemo1Label5.setForeground(new Color(191, 191,
                    191));
            jPanelDemo1.add(jPanelDemo1Label1, "gaptop 10");
            jPanelDemo1.add(jPanelDemo1Label2, "gaptop 10");
            jPanelDemo1.add(jPanelDemo1Label3, "gaptop 10");
            jPanelDemo1.add(jPanelDemo1Label4, "gaptop 10");
            jPanelDemo1.add(jPanelDemo1Label5, "gaptop 10");

            jTabbedPane.setForeground(new Color(191, 191,
                    191));
            jTabbedPane.setBackground(Color.white);
            jTabbedPane.setBounds(10, 10, 300, 275);
            // jTabbedPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            jTabbedPane.add("银行类", jPanelDemo1);
            jTabbedPane.add("银行类", new JPanel());
            jTabbedPane.add("银行类", new JPanel());
            jTabbedPane.add("银行类", new JPanel());
            JPanel jPanelDemo2 = new JPanel();
            jPanelDemo2.setBackground(Color.white);
            jPanelDemo2.setLayout(new MigLayout("wrap1,insets 10 10 10 10", "", ""));
            JLabel lableDemo1 = new JLabel("模型功能描述:");
            lableDemo1.setFont(new Font("微软雅黑", Font.BOLD, 14));
            lableDemo1.setForeground(new Color(191, 191,
                    191));
            JLabel lableDemo2 = new JLabel("模型需要:");
            lableDemo2.setFont(new Font("微软雅黑", Font.BOLD, 14));
            lableDemo2.setForeground(new Color(191, 191,
                    191));
            JLabel lableDemo3 = new JLabel("模型需要:");
            lableDemo3.setFont(new Font("微软雅黑", Font.BOLD, 14));
            lableDemo3.setForeground(new Color(191, 191,
                    191));
            JTextField textDemo1 = new JTextField("原理：按客户对股票交易流水进行汇总排行，使用说明：阈值默认为大于等于10.000.00");
            textDemo1.setForeground(new Color(191, 191,
                    191));
            textDemo1.setOpaque(true);
            textDemo1.setBorder(border);
          /*  textDemo1.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    if (textDemo1.getText().isEmpty()){
                        textDemo1.setText("密码");
                    }
                }
            });*/
            JTextField textDemo2 = new JTextField();
            textDemo2.setBorder(border);
            JTextField textDemo3 = new JTextField();
            textDemo3.setBorder(border);
            jPanelDemo2.add(lableDemo1, "gaptop 10");
            jPanelDemo2.add(textDemo1, "h 35,w 520,span,gaptop 10");
            jPanelDemo2.add(lableDemo2, "gaptop 10");
            jPanelDemo2.add(textDemo2, "h 35,w 520,span,gaptop 10");
            jPanelDemo2.add(lableDemo3, "gaptop 10");
            jPanelDemo2.add(textDemo3, "h 35,w 520,span,gaptop 10");
            /**
             * 第三部分
             */
            JLabel jLabelThere = new JLabel("步骤三：模型应用");
            //设置字体
            jLabelThere.setFont(new Font("微软雅黑", Font.BOLD, 17));
            jLabelThere.setForeground(new Color(78, 201, 243));
            //设置居
            //jLabelThere.setHorizontalAlignment(SwingConstants.LEFT);
            JPanel jPanelDemo3 = new JPanel();
            jPanelDemo3.setBackground(Color.white);
            //jPanelDemo3.setLayout(new MigLayout("wrap3,insets 10 10 10 10", "grow", "center"));
            JLabel jLabelDemo3 = new JLabel("查询结果显示:");
            JButton jButtonDemo31 = new JButton("查询");
            jButtonDemo31.setBackground(Color.white);
            jButtonDemo31.setFont(new Font("微软雅黑", Font.BOLD, 14));
            jButtonDemo31.setForeground(new Color(191, 191,
                    191));

            JButton jButtonDemo32 = new JButton("导出");
            jButtonDemo32.setBackground(Color.white);
            jButtonDemo32.setFont(new Font("微软雅黑", Font.BOLD, 14));
            jButtonDemo32.setForeground(new Color(191, 191,
                    191));

            JTextArea jTextAreaDemo3 = new JTextArea();
            /*MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(192, 192,
                    192));*/
            /*jButtonDemo32.setBorder(border);*/
            jTextAreaDemo3.setBorder(border);
            // jPanelDemo3.add(jLabelDemo3,"span 1");
            //jPanelDemo3.add(jButtonDemo31,"split 2");
            //jPanelDemo3.add(jButtonDemo32,"wrap");
            //jPanelDemo3.add(jTextAreaDemo3,"h 150 ,w 1000,span");


            jPanel.setBackground(Color.white);
            jPanel.setLayout(new MigLayout("wrap10,insets 20 40 20 20", "", ""));
            jPanel.add(jLabelOne);
            jPanel.add(jLabelOne2, "wrap");
            jPanel.add(pane, "wrap,span,h 108 ,w 800,growx,gaptop 10,gapbottom 20");
            jPanel.add(jLabelTwo, "wrap");
            jPanel.add(jTabbedPane, "split 2,span 3,w 300,h 238,gaptop 10,gapbottom 20");
            //jPanel.add(jTabbedPane, "w 280,span,gaptop 10,gapbottom 20");
            jPanel.add(jPanelDemo2, "span 4,w 520,wrap,gaptop 10,gapbottom 20");
            jPanel.add(jLabelThere, "wrap,gapbottom 5");
            jPanel.add(jLabelDemo3, "span 1");
            jPanel.add(jButtonDemo31, "split,gapleft 500");
            jPanel.add(jButtonDemo32, "wrap");
            jPanel.add(jTextAreaDemo3, "span,h 150,w 1000");
        } else if (obj.equals("数据导入")) {
            jPanel.setBackground(Color.white);
            jPanel.setLayout(new BorderLayout());
            //左
            JPanel jPanelLeft = new JPanel();
            jPanelLeft.setBackground(Color.white);
            jPanelLeft.setLayout(new MigLayout("wrap10,insets 10 40 10 10", "", ""));
            JLabel lableDemo1 = new JLabel("请选择源数据文件:");
            lableDemo1.setFont(new Font("微软雅黑", Font.BOLD, 17));

            JLabel lableDemo2 = new JLabel("请选择源数据的列分隔符:");
            lableDemo2.setFont(new Font("微软雅黑", Font.BOLD, 17));

            JLabel lableDemo3 = new JLabel("请选择源数据的字段包含符:");
            lableDemo3.setFont(new Font("微软雅黑", Font.BOLD, 17));

            JLabel lableDemo4 = new JLabel("请输入生成文件名:");
            lableDemo4.setFont(new Font("微软雅黑", Font.BOLD, 17));

            JTextField textDemo1 = new JTextField();
            textDemo1.setOpaque(true);
            JTextField textDemo2 = new JTextField();
            JTextField textDemo3 = new JTextField();
            JTextField textDemo4 = new JTextField();

            JButton jButton4 = new JButton("数据导入");
            jButton4.setBackground(Color.white);
            //jButton4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
            jButton4.setForeground(new Color(192, 192,
                    192));

            jPanelLeft.add(lableDemo1, "gaptop 10");
            jPanelLeft.add(textDemo1, "h 35,w 400,span,gaptop 10");
            jPanelLeft.add(lableDemo2, "gaptop 10");
            jPanelLeft.add(textDemo2, "h 35,w 400,span,gaptop 10");
            jPanelLeft.add(lableDemo3, "gaptop 10");
            jPanelLeft.add(textDemo3, "h 35,w 400,span,gaptop 10");
            jPanelLeft.add(lableDemo4, "gaptop 10");
            jPanelLeft.add(textDemo4, "split 2,span 3,h 35,w 300,gaptop 10");
            jPanelLeft.add(jButton4, "span 4,h 35,w 50,gaptop 10,wrap");
            String[] name = {"1.单位客户客户名称", "2.单位客户客户号", "3.标准字段名称", "4.单位客户交易日期"};
            Object[][] tableDate = new Object[14][4];
            for (int i = 0; i < 14; i++) {
                tableDate[i][0] = "";
                for (int j = 1; j < 4; j++) {
                    tableDate[i][j] = "";
                }
            }
            MyTable table = new MyTable(tableDate, name);
            // 水平线不显示
            //table.setShowHorizontalLines(false);
            //垂直线不显示
           // table.setShowVerticalLines(false);
            table.setShowGrid(false);
            //设置不可对表格进行操作
            table.setEnabled(false);
            //选中时的颜色
            // table.setSelectionBackground(Color.black);
            EvenOddRenderer tablecellRender = new EvenOddRenderer();
            table.setDefaultRenderer(Object.class, tablecellRender);
            //表格填充整个容器
            table.setFillsViewportHeight(true);
            //设置行高
            table.setRowHeight(25);
            //table.setBorder(border);
           /* table.setColumnSelectionAllowed(true);
            table.setRowSelectionAllowed(true);*/
            JTableHeader tableHeader = table.getTableHeader();
            tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 40));
            tableHeader.setBackground(Color.white);
            tableHeader.setFont(new Font("微软雅黑", Font.BOLD, 14));
            tableHeader.setForeground(new Color(192, 192,
                    192));
            table.setBackground(Color.WHITE);
            JScrollPane pane = new JScrollPane(table);
            pane.setPreferredSize(new Dimension(800, 100));
            pane.getViewport().setBackground(Color.WHITE);
            jPanelLeft.add(pane, "growx,span,h 393,gaptop 10");
            jPanel.add(jPanelLeft, BorderLayout.CENTER);
            //右
            JTabbedPane jTabbedPaneRight = new JTabbedPane();
            jTabbedPaneRight.setUI(new TabbedPaneUI("0x1eb0eb", "0xffffff"));
            JPanel jPanelRight = new JPanel(new MigLayout("wrap1,insets 10 0 10 10", "", ""));
            jPanelRight.setBackground(Color.white);
            JTextField jTextField = new JTextField("字段查询");
            jTextField.setFont(new Font("微软雅黑", Font.BOLD, 14));
            jTextField.setForeground(new Color(192, 192,
                    192));
            jTextField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    if (jTextField.getText().equals("字段查询")) {
                        jTextField.setText("111");
                    }
                }
            });
            jPanelRight.add(jTextField, "h 35,w 400,span,gapbottom 10");
            JTextArea jTextArea = new JTextArea("\r\n" +
                    "   标准字段名称\r\n" +
                    "   报告机构编码\r\n" +
                    "   报告机构名称\r\n" +
                    "   报告生成日期\r\n" +
                    "   备用字段\r\n" +
                    "   被检查机构提供存款人名称\r\n" +
                    "   被检查机构提供存款人身份证件编号\r\n" +
                    "   被检查机构提供存款人身份证件种类\r\n" +
                    "   被检查机构提供法定代表人或负责人身份证件编号\r\n" +
                    "   被检查机构提供法定代表人或负责人身份证件种类\r\n" +
                    "   被检查机构提供法定代表人或负责人姓名\r\n" +
                    "   被检查机构提供久悬日期\r\n" +
                    "   被检查机构提供开户日期\r\n" +
                    "   被检查机构提供临时存款账户有效期\r\n" +
                    "   被检查机构提供销户日期\r\n" +
                    "   被检查机构提供账户名称\r\n" +
                    "   被检查机构提供账户性质\r\n" +
                    "   被检查机构提供账户账号\r\n" +
                    "   被检查机构提供账户状态\r\n" +
                    "   币种\r\n" +
                    "   采取措施\r\n" +
                    "   大额交易发生日期\r\n" +
                    "   大额交易特征代码\r\n" +
                    "   代办人国籍\r\n" +
                    "   代办人身份证明文件号码\r\n" +
                    "   代办人身份证明文件类型");
            //设置文本域不可编辑
            jTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 11));
            jTextArea.setEditable(false);
            jTextArea.setBorder(border);
            jPanelRight.add(jTextArea, "h 520 ,w 400,span 1 20,growy");
            jTabbedPaneRight.add("固有字段（银行类）", jPanelRight);
            jTabbedPaneRight.setForeground(Color.white);

            jTabbedPaneRight.setPreferredSize(new Dimension(300, 600));


            jPanel.add(jTabbedPaneRight, BorderLayout.EAST);

        }
        return jPanel;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        //叶子节点的监听
        if (selectionNode.isLeaf()) {
            int count = tabbedPane.getTabCount();
            boolean ret = false;
            for (int i = 0; i < count; i++) {
                if (selectionNode.toString().equals(tabbedPane.getTitleAt(i))) {
                    ret = true;
                    tabbedPane.setSelectedIndex(i);
                    tabbedPane.setBackgroundAt(i, new Color(32, 176, 236));
                    tabbedPane.setForegroundAt(i,Color.white);
                }
            }
            if (!ret) {
                /**
                 * 自定义所加属性，如果为true则产生关闭标签
                 */
                tabbedPane.addTab(selectionNode.toString(), demo3.cerateSystem(selectionNode.toString()),true);
                tabbedPane.setSelectedIndex(count);
                tabbedPane.setBackgroundAt(count, Color.BLUE);
                tabbedPane.setForegroundAt(count,Color.white);
            }

        }
    }

}
