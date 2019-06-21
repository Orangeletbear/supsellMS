package com.cn.view.systemJFrame.shangpingxinxidialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.dao.system.DanWeiColorJDBC;
import com.cn.model.AllTableModel;

/**
 *��λ�����ӹ���
 * @author Administrator
 *
 */
public class DanWeiManager extends JDialog{
	
	private JTable colorTable;
	private AllTableModel colorTableM;
	String[] culomns = {"��   ��"};
	JButton cancer = new JButton("ȡ��");
	JButton delete = new JButton("ɾ��");
	JButton addBtn = new JButton("����");
	//��λ��������
	JTextField danName = new JTextField(5);
	
	public DanWeiManager(JDialog dialog,String title,boolean model){
		super(dialog,title,model);
		init();
		
		
		
	}
    private void init(){
    	this.setSize(200, 250);
    	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	this.setLayout(new BorderLayout());
    	//�����
    	
    	JPanel pane = new JPanel();
		pane.setBorder(new TitledBorder("��λ"));
		pane.setLayout(new BorderLayout());
		colorTableM = new AllTableModel(new Object[][]{},culomns);
		colorTable = new JTable(colorTableM);
		//colorTable.setPreferredScrollableViewportSize(new Dimension(230,400));
		colorTable.setAutoCreateRowSorter(true);
		pane.add(new JScrollPane(colorTable));
		this.add(pane);
		//���ư�ť���

    	JPanel pane1 = new JPanel();
		
		pane = new JPanel();
		pane.setLayout(new GridLayout(5,1,10,5));
		
		pane.add(danName);
		pane.add(addBtn);
		pane.add(delete);
		pane.add(cancer);
		pane1.add(pane);
		this.add(pane1,BorderLayout.EAST);
		
		addActionListener();
		initData();
    	this.setLocationRelativeTo(null);
    	this.setResizable(false);
    	this.setVisible(true);
    }
    private void addActionListener(){
    	//ȡ������
    	cancer.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				DanWeiManager.this.dispose();
			}
    		
    	});
    	
    	addBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String danW = danName.getText().toString();
				if(danW.equals("")){
					return;
				}
				DanWeiColorJDBC.addADanWei(danW);
				initData();
			}
    		
    	});
    
    	delete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int row  = colorTable.getSelectedRow();
				if(row == -1){
					return ;
				}
				String danW = colorTableM.getValueAt(
						row, 0).toString();
				
				DanWeiColorJDBC.deleDanWei(danW);
				initData();
				
			}
    		
    	});
    	
    	
    }
    private void initData(){
    	Vector data = DanWeiColorJDBC.getAllDanWeiM();
    	colorTableM.setDataVector(data,AllTableModel.getVectorFromObj(culomns));
    }
    
    public static void main(String[] args){
    	new DanWeiManager(null,"��λ����",true);
    } 
    
}
