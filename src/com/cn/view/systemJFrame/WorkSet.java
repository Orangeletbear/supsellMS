package com.cn.view.systemJFrame ;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.cn.dao.system.OperatorDB;
import com.cn.dao.system.WorkerDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.WorkerCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.Worker.AddWorker;
import com.cn.view.systemJFrame.Worker.ChangeWorker;
import com.cn.view.systemJFrame.Worker.FindWorker;
import com.cn.view.toolbar.KuChunFind;
/*
 * Ա�����öԻ���
 */
public class WorkSet extends JDialog {
	
	JButton btn1 = new JButton(
			new ImageIcon("res/AcionIcon/add.jpg"));
	JButton btn2 = new JButton(
			new ImageIcon("res/AcionIcon/atler.jpg"));
	JButton btn3 = new JButton(
			new ImageIcon("res/AcionIcon/delete.jpg"));
	JButton btn4 = new JButton(
			new ImageIcon("res/AcionIcon/find.jpg"));
	JButton btn5 = new JButton(
			new ImageIcon("res/AcionIcon/all.jpg"));
	JButton btn6 = new JButton(
			new ImageIcon("res/AcionIcon/import.jpg"));
	JButton btn7 = new JButton(
			new ImageIcon("res/AcionIcon/print.jpg"));
	JButton btn8 = new JButton(
			new ImageIcon("res/AcionIcon/exit.jpg"));
	
	JPanel bigPanel = new JPanel();
	
	static AllTableModel workerModel ;
	
	static JTable table;
	
	 
	
	public static JTable getTable() {
		return table;
	}
	public WorkSet(JDialog frame,String str){
		 
		super(frame,str,true);
		init();
		initData();
		this.setVisible(true); //����ɼ�
	}
	public WorkSet(MainFrame frame,String str){
		 
		super(frame,str,true);
		init();
		initData();
		this.setVisible(true); //����ɼ�
	}
	
	  private void initData() {
         Vector data = WorkerDB.getData();
         this.getWorkerModel().setDataVector(data,
        		 AllTableModel.getVectorFromObj(WorkerCulomns.workerNames));
		  
		  
	}

	private void init(){
		  //���ô�С
		  this.setSize(590,420);
		  //���ò��ַ�ʽ
		  bigPanel.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		  //�������
		  this.setLocationRelativeTo(null);
		  //���ùرշ�ʽ
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  addNorth();
		  addTable();
		  addSouth();
		  addListener();
		  this.toFront();
		  //��С���ɸı�
		  this.setResizable(false);
		 
		  //this.setVisible(true);
	  }
 
	private void addListener() {
		btn8.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				WorkSet.this.dispose();
			}});
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			 new AddWorker(WorkSet.this,"Ա������",true);
		}});
		
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(WorkSet.this.getTable().getSelectedRow()<0){
					JOptionPane.showMessageDialog(null,"����ѡ��һ�����ݣ�");
				}
				
				else{
				 new ChangeWorker(WorkSet.this,"�޸�Ա��",true);
			}}
		});
		btn3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(WorkSet.this.getTable().getSelectedRow()<0){
					JOptionPane.showMessageDialog(WorkSet.this,"��ѡ��һ�����ݣ�");
					return;
				}int worker = JOptionPane.showConfirmDialog(WorkSet.this,
						"�Ƿ�ȷ��Ҫɾ����ɾ���󲻿ɻָ�~", "ϵͳ��ʾ",JOptionPane.OK_CANCEL_OPTION,1);
				
				if(worker==JOptionPane.OK_OPTION){
					int row = WorkSet.this.getTable().getSelectedRow();
					Object obj = WorkSet.this.getWorkerModel().getValueAt(row, 0);
					boolean isdele=WorkerDB.deleteWorker(obj);
					if(isdele){
						Vector data = WorkerDB.getData();
						WorkSet.this.getWorkerModel().setDataVector(data,
								AllTableModel.getVectorFromObj(WorkerCulomns.workerNames));
						JOptionPane.showMessageDialog(WorkSet.this,"�ɹ�ɾ����");
					}else{
						JOptionPane.showMessageDialog(WorkSet.this, "�����ݷ���ҵ��,����ɾ��");
					}
					 
                     MainFrame mUser = (MainFrame)(WorkSet.this.getOwner());
                     String user=mUser.getUser();
		    	  
                     if(isdele){
                 	 Log.traceLog("����Ա��",user," ɾ����Ա����"+
                 	      obj.toString()+" ����Ϣ");
                   }
				}
				
			}
			
		});
		
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				 new FindWorker(WorkSet.this, "����Ա��" ,true);
			}
		});
		
		btn5.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Vector data = WorkerDB.getData();
				WorkSet.this.getWorkerModel().setDataVector(data,
						AllTableModel.getVectorFromObj(WorkerCulomns.workerNames));
			}});
	}
 
	
	private void addTable() {
		
		 String[] names = {"Ա������","ְ��","��ϵ�绰","��ϵ��ַ","��ע"};
		
		 String[][] data = new String[][]{};
		 
		 workerModel = new AllTableModel(data,WorkerCulomns.workerNames);
		 
		 table = new JTable(workerModel);
		 table.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2){
					new ChangeWorker(WorkSet.this, "�޸�Ա��", true);
				}
				
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		 
		 table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		 
		 table.setPreferredScrollableViewportSize(new Dimension(560,250));
		 
		 JPanel panel = new JPanel();
		 
		 panel.add(new JScrollPane(table),JScrollPane.HORIZONTAL_SCROLLBAR);
		 
		 bigPanel.add(panel,BorderLayout.CENTER);
		 this.add(bigPanel);
		 
	}

	private void addNorth() {
		 JPanel north = new JPanel();
		 north.add(btn1);
		 btn1.setMargin(new Insets(0,0,0,0));
		 north.add(btn2); 
		 btn2.setMargin(new Insets(0,0,0,0));
		 north.add(btn3); 
		 btn3.setMargin(new Insets(0,0,0,0));
		 north.add(btn4); 
		 btn4.setMargin(new Insets(0,0,0,0));
		 north.add(btn5); 
		 btn5.setMargin(new Insets(0,0,0,0));
		 north.add(btn6); 
		 btn6.setMargin(new Insets(0,0,0,0));
		 north.add(btn7);
		 btn7.setMargin(new Insets(0,0,0,0));
		 north.add(btn8);
		 btn8.setMargin(new Insets(0,0,0,0));
		 
		 bigPanel.add(north,BorderLayout.NORTH);
		 
		 this.add(bigPanel);
		
	}
	private void addSouth(){
		JPanel pa = new JPanel();
		JLabel be = new JLabel("");
		be.setFont(new Font("DIALOG",Font.PLAIN,12));
		pa.add(be);
		bigPanel.add(pa);
		this.add(bigPanel);
	}
	
	public static void main(String[] args) {
      
	}

	public JPanel getBigPanel() {
		return bigPanel;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public JButton getBtn4() {
		return btn4;
	}

	public JButton getBtn5() {
		return btn5;
	}

	public JButton getBtn6() {
		return btn6;
	}

	public JButton getBtn7() {
		return btn7;
	}

	public JButton getBtn8() {
		return btn8;
	}

	public static AllTableModel getWorkerModel() {
		return workerModel;
	}

}
 