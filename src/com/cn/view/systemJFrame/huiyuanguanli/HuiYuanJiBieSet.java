package com.cn.view.systemJFrame.huiyuanguanli;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
/**
 * ��Ա�����������
 * @author finey
 *
 */
public class HuiYuanJiBieSet extends JDialog {
     public static String [] tbCulomns = {
    	           "������","��������","�����ۿ�","��������","��������"};
	//����
	JButton add = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/add.jpg"));
	//�޸�
	JButton alter = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/atler.jpg"));
	//ɾ��
	JButton dele = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/delete.jpg"));
	//�˳�
	JButton exit = new JButton(
			new ImageIcon("/SuperSellMS/res/AcionIcon/exit.jpg"));
	
	AllTableModel tbMo = new AllTableModel(
			new Object[][]{},tbCulomns);
	
	JTable table = new JTable(tbMo);
	
	private JTextField jiBieF = new JTextField(10);
	
	
	JLabel countNum = new JLabel("0");
	
	
	
	public JLabel getCountNum() {
		return countNum;
	}

	public  HuiYuanJiBieSet(HuiYanGuangLiFrame frame,String title){
		super(frame,title,true);
   	     
		
		init();
	}
	
	  private void init(){
		  //���ô�С
		  //this.setSize(590,420);
		  this.setLayout(new BorderLayout());
		
		  //����رշ�ʽ
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		  this.add(initNorth(),BorderLayout.NORTH);
		  this.add(initCenter());
		  this.add(initSouth(),BorderLayout.SOUTH);
		  this.pack();
		  //��С���ɸı�
		  this.setResizable(false);
		  this.setLocationRelativeTo(null);
		  addListener();
		  //�Ի���ɼ�
		  initData();
		  this.setVisible(true);
	  }
	  /**
	   * ������Ϣ��ʼ��
	   */
	  public void initData(){
		    Vector data = HuiYuanXinGLJDBC.getHuiJiBieBaseM("");
			//���ݼ����ģʽ��
			this.getTbMo().setDataVector(data,
			AllTableModel.getVectorFromObj(tbCulomns));
			countNum.setText(" "+data.size());
	  }
	  
	  private void addListener(){
		  exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				HuiYuanJiBieSet.this.dispose();
			}
			  
		  });
		  
		  add.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					new AddHuiYuanJiBie(HuiYuanJiBieSet.this,
							"���Ӽ���",false);
				}
				  
		   });
		  alter.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(HuiYuanJiBieSet.this.getTabel().getSelectedColumn()<0){
						JOptionPane.showMessageDialog(null,"����ѡ��һ������");
						return;
					}else{
						new AddHuiYuanJiBie(HuiYuanJiBieSet.this,
								"�޸ļ���",true);
					}
					
				}
				  
		   });
		  dele.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(HuiYuanJiBieSet.this.getTabel().getSelectedColumn()<0){
						JOptionPane.showMessageDialog(null,"����ѡ��һ������");
						return;
					}
			        int choice =  JOptionPane.showConfirmDialog(
			        		HuiYuanJiBieSet.this, "����ɾ���󽫲��ָܻ����Ƿ�ɾ����","ɾ������",
			        		 JOptionPane.YES_NO_OPTION, 1);
			        
			        
			          //��ȷ��ɾ������
				     if(choice == JOptionPane.YES_OPTION){
				    	 int row = HuiYuanJiBieSet.this.getTabel().
				    	             getSelectedRow();
				    	 
				    	 String obj = HuiYuanJiBieSet.this.getTbMo()
				    	           .getValueAt(row, 0).toString();
				    	 boolean isDele = HuiYuanXinGLJDBC.deleJiBie(obj);
				    	 
				    	 if(isDele){
				    	        HuiYanGuangLiFrame hyframe = (HuiYanGuangLiFrame)HuiYuanJiBieSet.this.getOwner();
				    	      	MainFrame mframe = (MainFrame)hyframe.getOwner();
				    	      	String user = mframe.getUser();
				    	      	//д��־
				    	      	Log.traceLog("  ����Ա  ",user," ɾ���˻�Ա���� :  "+
				    	      	   HuiYuanJiBieSet.this.getTbMo().getValueAt(row, 1).toString()+"  ����Ϣ");
				    		 
				    		 JOptionPane.showMessageDialog(null,"���ݳɹ�ɾ��");
				    	     initData();
				    	 }
				     }
				}
		   });
	  }
	  
	private JPanel initNorth(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add.setMargin(new Insets(0,0,0,0));
		alter.setMargin(new Insets(0,0,0,0));
		dele.setMargin(new Insets(0,0,0,0));
		exit.setMargin(new Insets(0,0,0,0));
		
		pane.add(add);
		pane.add(alter);
		pane.add(dele);
		pane.add(exit);
		
		
		return pane;
	}
	
	
	private JPanel initCenter(){
		JPanel pane = new JPanel();
	
		pane.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		north.add(new JLabel("������Ϣ"));
		north.add(jiBieF);
		jiBieF.setToolTipText("���뼶���Ż�����ģ����ѯ");
        JButton findBtn = new JButton("��  ѯ");
        north.add(findBtn);
        pane.add(north,BorderLayout.NORTH);
        findBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				String jbIN = jiBieF.getText();
				Vector data = HuiYuanXinGLJDBC.getHuiJiBieBaseM(jbIN);
				//���ݼ����ģʽ��
				getTbMo().setDataVector(data,
				AllTableModel.getVectorFromObj(tbCulomns));
				countNum.setText(" "+data.size());
			}
        	
        });
        
        JPanel tbPane = new JPanel();
        table.setPreferredScrollableViewportSize(
        		new Dimension(500,200));
        table.setAutoCreateRowSorter(true);
        tbPane.add(new JScrollPane(table));
        table.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() ==2){
				 new AddHuiYuanJiBie(HuiYuanJiBieSet.this,"�޸ļ���",true);
				}
			}

			
        	
        });
        
        pane.add(tbPane);
		return pane;
	}
	
	private JPanel initSouth(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.add(new JLabel("��¼����  "));
		pane.add(countNum);
		return pane;
	}
	

	public JTextField getJiBieF() {
		return jiBieF;
	}

	public JTable getTabel() {
		return table;
	}

	public AllTableModel getTbMo() {
		return tbMo;
	}
	public static void main(String[] args) {
		new HuiYuanJiBieSet(null,"��Ա����");
	}
}
