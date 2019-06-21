package com.cn.view.systemJFrame.Operator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import com.cn.dao.system.OperatorDB;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.OperatorSet;
import com.cn.view.systemJFrame.Operator.privateTree.PrivateTree;

 
/**
 * ���Ӳ���Ա�Ի���
 * @author finey
 *
 */
public class AddOperator2 extends JDialog {
      
	private JTextField ex1;
	private JTextField ex3;
	private JTextField ex2;
	private JPasswordField ex4;
	private JPasswordField ex5;
	//Ȩ�޼�
	JCheckBox [] priBox;
	private JButton bx1;
    private String isOperator;
    private boolean isChange;
    
    
    OperatorSet add;
    JLabel tmpLabe ;
    /**
     * 
     * @param add  ������
     * @param title  ����
     * @param isOperator  �Ƿ����Ա
     * @param isChange  �Ƿ�Ϊ�޸�
     */
	public AddOperator2(OperatorSet add,String title,
			String isOperator,boolean isChange){
		
		super(add,title,true);
		this.add = add;
		this.isOperator = isOperator;
		this.isChange = isChange;
		this.setLayout(new BorderLayout());
        
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
        this.add(init(),BorderLayout.WEST);
		this.add(initTree(),BorderLayout.EAST);
		this.add(SouthPane(),BorderLayout.SOUTH);
		this.pack();
		this.setResizable(false);
		if(isChange){
			initData();
		}
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
     /**
      *  ���ݳ�ʼ��������
      */
	private void initData(){
		
	     OperatorSet frame = (OperatorSet)(this.getOwner());
	     
	     int row = frame.getTable().getSelectedRow();
	     
	     Vector data = OperatorDB.getData(
	        frame.getOperatorModel().getValueAt(row, 0).toString());
        
	     ex1.setText(data.get(0).toString());
	     ex2.setText(data.get(1).toString());
	     if(data.get(3)==null){
	    	 ex3.setText("");
	     }else{
	    	 ex3.setText(data.get(3).toString());
	     }
	     if(data.get(2)==null){
	    	 ex4.setText("");
		     ex5.setText("");
	     }else{
	    	 ex4.setText(data.get(2).toString());
		     ex5.setText(data.get(2).toString());
	     }
	     
	     for(int i = 0;i<6;i++){
	    	 if(data.get(i+6).equals("��")){
	    		 priBox[i].setSelected(false);
	    	 }
	    	  
	     }

	     ex1.setEditable(false);
	     tmpLabe.setVisible(false);
	     
	}

	private JPanel init() {
         JPanel pa = new JPanel();
         pa.setLayout(new GridLayout(6,1,10,10));
         
         ex1 = new JTextField(15);
	     ex2 = new JTextField(15);
		 ex3 = new JTextField(15);
		 ex4 = new JPasswordField(15);
		 ex5 = new JPasswordField(15);
	
	     JLabel labe  = new JLabel("�û���ţ�");
		 JLabel labe1 = new JLabel("�û����ƣ�");
		 JLabel labe2 = new JLabel("����ְ��");
		 JLabel labe3 = new JLabel("�û����룺");
		 JLabel labe4 = new JLabel("ȷ�����룺");
         
		 tmpLabe  = new JLabel("ע�� ����Ա���Ϊ��λ");
		 tmpLabe.setForeground(Color.red);
		 pa.add(tmpLabe);
		 
		 
		 JPanel tmpPane = new JPanel();
		 tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		 tmpPane.add(labe);
		 tmpPane.add(ex1);
		 pa.add(tmpPane);
		 
		 tmpPane = new JPanel();
		 tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		 tmpPane.add(labe1);
		 tmpPane.add(ex2);
		 pa.add(tmpPane);
		 
		 tmpPane = new JPanel();
		 tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		 tmpPane.add(labe2);
		 tmpPane.add(ex3);
		 pa.add(tmpPane);
		 
		 tmpPane = new JPanel();
		 tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		 tmpPane.add(labe3);
		 tmpPane.add(ex4);
		 pa.add(tmpPane);
		 
		 tmpPane = new JPanel();
		 tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		 tmpPane.add(labe4);
		 tmpPane.add(ex5);
		 pa.add(tmpPane);
		 
  		 pa.setBorder(new TitledBorder("����Ա��Ϣ"));
         return pa;
            
		
	} 
	/**
	 *  Ȩ�����ĳ�ʼ��
	 * @return
	 */
	private JPanel initTree(){
		JPanel pane = new JPanel();
		//pane.setLayout(new BorderLayout());
		
		//PrivateTree selectTree = new PrivateTree();
		//pane.add(selectTree.getTreePane());
		
		priBox = new JCheckBox[6];
		
		priBox[0] = new JCheckBox("�ɹ�����Ȩ");
		priBox[1] = new JCheckBox("���۹���Ȩ");
		priBox[2] = new JCheckBox("������Ȩ");
		priBox[3] = new JCheckBox("����ͳ��Ȩ");
		priBox[4] = new JCheckBox("�ճ�����Ȩ");
		priBox[5] = new JCheckBox("ϵͳ����Ȩ");
		
		for(int i =  0;i < 6;i++){
			priBox[i].setSelected(true);
			pane.add(priBox[i]);
		}
		
		
		pane.setBorder(new TitledBorder("����ԱȨ������"));
		pane.setPreferredSize(new Dimension(150,300));
		return pane;
	}
	
	
	private JPanel SouthPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.RIGHT,60,5));
		bx1= new JButton("ȷ��(F5)") ;
		
		bx1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Vector data = new Vector();
				//Ȩ�����ݰ�
				String [] priData = new String [6];
			     data.add(ex1.getText());
			     data.add(ex2.getText());
			     data.add(ex3.getText());
			     
			     String psName = new String(ex4.getPassword());
			     String cpsName = new String(ex5.getPassword());
			     if(psName.equals("")||cpsName.equals("")){
			    	 JOptionPane.showMessageDialog(null,"���벻��Ϊ��");
			    	 return;
			     }
			     if(!psName.equals(cpsName)){
			    	 JOptionPane.showMessageDialog(null,"�����������");
			    	 return;
			     }
			     data.add(psName);
			     //data.add(isOperator);
			     
			     for(int i = 0;i<6;i++){
			    	 if(priBox[i].isSelected()){
			    		 priData[i] = "��";
			    	 }else{
			    		 priData[i] = "��";
			    	 }
			     }
			     
			     boolean isOK = false;
			     if(isChange){
			    	 int row = add.getTable().getSelectedRow();
				     data.add(add.getOperatorModel()
			    	         .getValueAt(row, 3).toString());
			    	 isOK = OperatorDB.alterOperator(data,priData);
			     }else{
			    	 data.add(isOperator);
			    	 isOK = OperatorDB.addOperator(data,priData);
			     }
			     if(!isOK){
			    	 JOptionPane.showMessageDialog(null,"������鿴�����Ƿ���ȷ");
			    	 return;
			     }else{
			    	 String user = ((MainFrame)add.getOwner()).getUser();
			    	 if(isChange){
			    		 Log.traceLog(" ����Ա ",user,
			    				 "  �޸��˲���Ա "+ex2.getText()+"����Ϣ");
			    	 }else{
			    		 Log.traceLog(" ����Ա ",user,
			    				 "  ���Ӳ���Ա "+ex2.getText()+"����Ϣ");
			    	 }
			    	 JOptionPane.showMessageDialog(null,"��         ��");
			    	 add.initData();
			    	 AddOperator2.this.dispose();
			     }
				
			}
			
			
	    	 
	     });
	    JButton bx2 = new JButton("�˳�(F4)");
	    bx2.addActionListener(new ActionListener(){
			 
			public void actionPerformed(ActionEvent e) {
			     AddOperator2.this.dispose();
				
			}
	    	 
	     });
	     pane.add(bx1);
	     pane.add(bx2);
	     
		return pane;
	}
	
	 
}
