package com.cn.control.jinhuoframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeModel;

import com.cn.model.jinhuo.AddSanPingCulomns;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.model.kuchun.KunCunDefaultTreeCellRenderer;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
/**
 * ������Ʒ�Ի���
 * @author finey
 *
 */
public class AddSanPingDialog extends JDialog {
	
	//��Ʒ�б�
	private JTable splbtable;
	//��Ʒ�嵥
	private JTable spqdtable;
	//��ѡ��Ʒ
	private JTable sxsptable;
	//�����ϱ��
	private JTextField spbhfield ;
	
	//��Ʒ�������ṹ
	private JTree tree;
	
	
	public AddSanPingDialog(JDialog dialog, String title){
		super(dialog,title,true);
		init();
	}
	
	
	//------------------------------------------------
	private void init(){
		this.setSize(new Dimension(950,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocation(300, 200);
		this.setLayout(new BorderLayout());
		this.add(createPane());
		//this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	//------------------------------------------------
	//�������
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		//�ֱ����
		JSplitPane splitPane = new JSplitPane();
		
		//����������
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout(2,2));
		leftPane.setBorder(new TitledBorder("ѯ����Ʒ�б�"));
		leftPane.add(initLeftPane());
		splitPane.setLeftComponent(leftPane);

		//�ұ����Ľ���
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		rightPane.setBorder(new TitledBorder("��ѡ��Ʒ"));
		rightPane.add(initRightPane());
		
		splitPane.setRightComponent(rightPane);
		//splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(500);
		splitPane.setDividerSize(0);
		mainPane.add(splitPane);
		return mainPane;
	}
	//------------------------------------------------
	//��ʹ��������
	private JPanel initLeftPane(){
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout());
		//------------------------------
		JPanel northPane = new JPanel();
		JLabel lab = new JLabel("������Ʒ��Ż����ƣ� ");
		spbhfield = new JTextField(10);
		JButton addBtn = new JButton("������ѡ��Ʒ��F8��");
		northPane.add(lab);
		northPane.add(spbhfield);
		northPane.add(addBtn);
		leftPane.add(northPane,BorderLayout.NORTH);
		//----------------------------------
		
		JTabbedPane  tabblePane = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		//����ѡ�
		JPanel pane1 = createPane1();
		JPanel pane2 = createPane2();
		
		tabblePane.add("��Ʒ�嵥",pane1);
		tabblePane.add("��Ʒ�б�",pane2);
		
		leftPane.add(tabblePane);
		return leftPane;
	}
	//------------------------------------------------
	//��һ��ѡ����
	 private JPanel createPane1(){
         JPanel pane = new JPanel();
         pane.setLayout(new BorderLayout());
         splbtable = new JTable(AddSanPingCulomns.data,AddSanPingCulomns.ColumnName1);
         
         //���̶���С
         splbtable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
 		 //���Ϊ true��������������߽��ڵ���������
         splbtable.setOpaque(true);
 		//����Զ�����
         splbtable.setAutoCreateRowSorter(true);
 		//��һ��������
         pane.add(new JScrollPane(splbtable));
		 return pane;
		 
	 }
	//------------------------------------------------
	 //�ڶ���ѡ����
	 private JPanel createPane2(){
		    JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			//�ֱ����
			JSplitPane splitPane = new JSplitPane();
			
			//����������
			JPanel leftPane = new JPanel();
			leftPane.setLayout(new BorderLayout());
			
			leftPane.add(initTree(),BorderLayout.CENTER);
			splitPane.setLeftComponent(leftPane);
		
			JPanel rightPane = new JPanel();
			rightPane.setLayout(new BorderLayout());
			
			JPanel tablePane = new JPanel();
			//�½�һ�����
			spqdtable = new JTable(AddSanPingCulomns.data,AddSanPingCulomns.ColumnName2);
			//���̶���С
			spqdtable.setPreferredScrollableViewportSize(new Dimension(360, 450));
			//���Ϊ true��������������߽��ڵ���������
			tablePane.setOpaque(true);
			//����Զ�����
			spqdtable.setAutoCreateRowSorter(true);
			//��һ��������
			tablePane.add(new JScrollPane(spqdtable,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),
						BorderLayout.CENTER);
			
			rightPane.add(new JScrollPane(tablePane));
			splitPane.setRightComponent(rightPane);
			splitPane.setOneTouchExpandable(true);
			splitPane.setDividerLocation(120);
			splitPane.setDividerSize(2);
			pane.add(splitPane);
			return pane;
	 }
	//------------------------------------------------
	//��ʹ���ұ����
	private JPanel initRightPane(){
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		splbtable = new JTable(AddSanPingCulomns.data,AddSanPingCulomns.ColumnName2);
        //���̶���С
        splbtable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
		 //���Ϊ true��������������߽��ڵ���������
        splbtable.setOpaque(true);
		//����Զ�����
        splbtable.setAutoCreateRowSorter(true);
		//��һ��������
        rightPane.add(new JScrollPane(splbtable));
        
        JPanel btnPane = new JPanel();
        btnPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        JButton aterBtn = new JButton("�޸�(F3)");
        JButton deleteBtn = new JButton("ɾ��(Del)");
        JButton okBtn = new JButton("ȷ��(F5)");
        JButton canncerBtn = new JButton("ȡ��(F4)");
        
        btnPane.add(aterBtn);
        btnPane.add(deleteBtn);
        btnPane.add(okBtn);
        btnPane.add(canncerBtn);
        
        rightPane.add(btnPane,BorderLayout.SOUTH);
		return rightPane;
	}
	
	//------------------------------------------------
	/*
	 * ��Ʒ������ĳ�ʼ��
	 */
	private JPanel initTree(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    DefaultMutableTreeNode root = new DefaultMutableTreeNode("�������");
		
		DefaultMutableTreeNode drink = new DefaultMutableTreeNode("����");
		DefaultMutableTreeNode shuiGuo = new DefaultMutableTreeNode("ˮ����");
		DefaultMutableTreeNode yiLiao = new DefaultMutableTreeNode("������");
		DefaultMutableTreeNode shiPing = new DefaultMutableTreeNode("ʳƷ��");
		DefaultMutableTreeNode shengHuo = new DefaultMutableTreeNode("������");
		
		DefaultMutableTreeNode writeDrink = new DefaultMutableTreeNode("�׾�");
		DefaultMutableTreeNode redDrink = new DefaultMutableTreeNode("���");
		
	    root.add(drink); 
	    root.add(shuiGuo); 
	    root.add(yiLiao); 
	    root.add(shiPing); 
	    root.add(shengHuo);
	    
	    drink.add(writeDrink);
	    drink.add(redDrink);
	    //ָ��������ģ��
	    DefaultTreeModel treeModel = new DefaultTreeModel(root);
	    
	    tree = new JTree(treeModel);
	    
	    KunCunDefaultTreeCellRenderer render = new KunCunDefaultTreeCellRenderer();
	    
	    tree.setCellRenderer(render);
	    
	    tree.setCellEditor(new DefaultTreeCellEditor(tree, render) {
	        
	    });
	    pane.add(tree);
	    
	    pane.setBorder(new LineBorder(Color.gray));
	    pane.setBackground(Color.white);
		return pane;
	}
	public static void main(String[] args) {
		new AddSanPingDialog((JDialog)null,"������Ʒ");
	}

}
