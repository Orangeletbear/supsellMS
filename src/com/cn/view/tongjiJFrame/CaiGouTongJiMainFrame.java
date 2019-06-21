package com.cn.view.tongjiJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.cn.control.tongjiframe.danJuListener;
import com.cn.control.tongjiframe.danJuMouseListener;
import com.cn.dao.pos.POSJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.JDatePicker;
import com.cn.view.tongjiJFrame.Dialog.CaiGouTongJiCheckDialog;
import com.cn.view.tongjiJFrame.Dialog.DanJuDialogTwo;

public class CaiGouTongJiMainFrame extends JDialog implements ActionListener {
	/*
	 * 5����ť�Ͳ������е����
	 */
	JButton check,checkDanJu,daoChu,daYin,tuiChu,tongJi;
	JLabel caiGouDate,zhi,yeWuYuanName;
	JDatePicker datePickerTo,datePickerTo2; 
	JComboBox yeWuYuanBox;
	/*
	 * ҵ��Ա�ɹ����ݱ�ѡ��е�JTable��JLael
	 */
	JLabel jiLu;
	JTable danJuBiao;
	/*
	 * ������ϸ��Ϣ���е�JTable��JLael
	 */
	JLabel pinZhong, xinXiLabel;
	JTable xinXiBiao;
	/*
	 * ��Ʒ��ϸ��ѡ��е�JTable��JLael
	 */
	JLabel jiLu1;
	JTable mingXiBiao;
	/*
	 * ��Ʒ���ܱ�ѡ��е�JTable��JLael
	 */
	JLabel pinZhong1;
	JTable huiZongBiao;
	
	
	JTabbedPane mainJPane;   //ѡ�����
	DefaultTableModel dft1,dft2,dft3,dft4;

	/**
	 * �ķ���������һ��JDialog���ڣ���������5����ť����һ�����������Լ�����ѡ���5����ť�ֱ���
	 * ���ң��鿴���ݣ���������ӡ���˳������������в��ҵ�ʱ��Σ����ҵ�ҵ��Ա���ơ�
	 * ѡ��ֱ���ҵ��Ա�ɹ����ݱ���Ʒ��ϸ����Ʒ���ܱ�����ҵ��Ա�ɹ����ݱ��а���һ�����ݵ�
	 * ������ϸ��Ϣ��
	 */
	public CaiGouTongJiMainFrame(JDialog owner,String title,boolean model){
   	 super(owner,title,model);
   	 init();
    }
	 public CaiGouTongJiMainFrame(JFrame owner,String title,boolean model){
    	 super(owner,title,model);
    	 init();
     }
     private void init(){
    	 this.setSize(800, 500);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		 //this.pack();
		 this.setLocationRelativeTo(null);//�������������
		 
		 JPanel jp=new JPanel();
		 jp.setLayout(new BorderLayout());
		 /*
		  * ��������ťʵ��������ӵ�һ�������
		  */
		 JPanel buttonP=new JPanel();
		 buttonP.setBorder(new LineBorder(Color.lightGray,2,true));
		 buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 check=new JButton(new ImageIcon("res\\AcionIcon\\find.jpg"));
		 check.setMargin(new Insets(0,0,0,0));
		 buttonP.add(check);
		 checkDanJu=new JButton(new ImageIcon("res\\AcionIcon\\chakuangdanju.jpg"));
		 checkDanJu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(checkDanJu);
		 daoChu=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(daoChu);
		 daYin=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin.setMargin(new Insets(0,0,0,0));
		 buttonP.add(daYin);
		 tuiChu=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(tuiChu);
		 /*
		  * ���������е����ʵ��������ӵ�һ�������
		  */
		 caiGouDate=new JLabel("�ɹ�����");
		 zhi=new JLabel("��");
		 yeWuYuanName=new JLabel("ҵ��Ա���ƣ�");
		 yeWuYuanBox=new JComboBox(POSJDBC.getAllWorker());
		 yeWuYuanBox.addItem("����ҵ��Ա");
		 yeWuYuanBox.setSelectedItem("����ҵ��Ա");
		 
		 tongJi=new JButton("ͳ��");
		 datePickerTo= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo2= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 JPanel northP=new JPanel();
		 northP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 northP.add(caiGouDate);
		 northP.add(datePickerTo);
		 northP.add(zhi);
		 northP.add(datePickerTo2);
		 northP.add(new JLabel("              "));
		 northP.add(yeWuYuanName);
		 northP.add(yeWuYuanBox);
		 northP.add(tongJi);
		 
		 /*
		  * ����������������ӵ�������
		  */
		 JPanel centreP=new JPanel();
		 centreP.setLayout(new BorderLayout());
		 centreP.add(northP,BorderLayout.NORTH);
		 centreP.add(addPane());
		 
		 jp.add(buttonP,BorderLayout.NORTH);
		 jp.add(centreP);
		 addAction();
		 tongJi.addActionListener(l);//��Ӽ�����
		 danJuBiao.addMouseListener(m);
		 this.add(jp);
		 this.setVisible(true);
     }
     public ActionListener l=new danJuListener(this);
     public MouseListener m=new danJuMouseListener(this);
     /*
      * ��Ӳ�����ѡ�
      */
		 public  JTabbedPane addPane(){
			 mainJPane=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT);
			 dft1=new AllTableModel(tongJiModel.danJuColumn,tongJiModel.danJuNames);
			 dft2=new AllTableModel(tongJiModel.mingXiColumn,tongJiModel.mingXiNames);
			 dft3=new AllTableModel(tongJiModel.huiZongColumn,tongJiModel.huiZongNames);
			 dft4=new AllTableModel(tongJiModel.xinXiColumn,tongJiModel.xinXiNames);
			 dft1.isCellEditable(0, 0);
			 dft2.isCellEditable(0, 0);
			 dft3.isCellEditable(0, 0);
			 dft4.isCellEditable(0, 0);
			 danJuBiao=new JTable(dft1);
			 danJuBiao.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane danJuJS=new JScrollPane(danJuBiao);
			 mingXiBiao=new JTable(dft2);
			 huiZongBiao=new JTable(dft3);
			 xinXiBiao=new JTable(dft4);
			 xinXiBiao.setPreferredScrollableViewportSize(new Dimension(200,50));
			 JScrollPane xinXiJS=new JScrollPane(xinXiBiao);
			 xinXiLabel=new JLabel("��Ϣ����ϸ�б�");
			 xinXiLabel.setForeground(Color.red);
			 pinZhong=new JLabel("Ʒ�ֺϼƣ�");
			 pinZhong.setForeground(Color.red);
			 JPanel xinXiP=new JPanel();
			 xinXiP.setLayout(new FlowLayout(FlowLayout.LEFT));
			 xinXiP.add(pinZhong);
             JPanel p1=new JPanel();
             p1.setLayout(new BorderLayout());
             p1.add(xinXiLabel,BorderLayout.NORTH);
             p1.add(xinXiJS,BorderLayout.CENTER);
             p1.add(xinXiP,BorderLayout.SOUTH);
             
             jiLu=new JLabel("��¼����");
             jiLu.setForeground(Color.red);
			 JPanel p2=new JPanel();
			 p2.setLayout(new FlowLayout(FlowLayout.LEFT));
			 p2.add(jiLu);
			 p2.setBorder(new LineBorder(Color.LIGHT_GRAY));
			 JPanel danJuP=new JPanel();
			 danJuP.setLayout(new BorderLayout());
			 
			 danJuP.add(p2,BorderLayout.SOUTH);
			
			 danJuP.add(danJuJS);
			 JPanel danJuZongP=new JPanel();
			 danJuZongP.setLayout(new BorderLayout());
			 danJuZongP.add(p1,BorderLayout.SOUTH);
			 danJuZongP.add(danJuP);
			 
			 jiLu1=new JLabel("��¼����");
			 jiLu1.setForeground(Color.red);
			 JPanel p3=new JPanel();
			 p3.setLayout(new FlowLayout(FlowLayout.LEFT));
			 p3.add(jiLu1);
			 mingXiBiao=new JTable(dft2);
			 JScrollPane mingXiJS=new JScrollPane(mingXiBiao);
			 JPanel mingXiZongBiao=new JPanel();
			 mingXiZongBiao.setLayout(new BorderLayout());
			 mingXiZongBiao.add(p3,BorderLayout.SOUTH);
			 mingXiZongBiao.add(mingXiJS);
			 
			 pinZhong1=new JLabel("Ʒ�ֺϼƣ�");
			 pinZhong1.setForeground(Color.red);
			 JPanel huiZongP=new JPanel();
			 huiZongP.setLayout(new FlowLayout(FlowLayout.LEFT));
			 huiZongP.add(pinZhong1);
			 huiZongBiao=new JTable(dft3);
			 JScrollPane huiZongJS=new JScrollPane(huiZongBiao);
             JPanel huiZongZongBiao=new JPanel();
             huiZongZongBiao.setLayout(new BorderLayout());
             huiZongZongBiao.add(huiZongP,BorderLayout.SOUTH);
             huiZongZongBiao.add(huiZongJS);
            
			 mainJPane.add("ҵ��Ա�ɹ����ݱ�",danJuZongP);
			 mainJPane.add("��Ʒ��ϸ��",mingXiZongBiao);
			 mainJPane.add("��Ʒ���ܱ�",huiZongZongBiao);
			 return mainJPane;
		 }
		 /*
		  * ��Ӽ�����
		  */
		  private void addAction(){
		    	 check.addActionListener(this);
		    	 checkDanJu.addActionListener(this);
		    	 daoChu.addActionListener(this);
		    	 tuiChu.addActionListener(this);
		     }
		
		 /*
		  * ʵ�ּ�����
		  * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		  */
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==check){
				new CaiGouTongJiCheckDialog(CaiGouTongJiMainFrame.this,"����",true);
			}
			if(e.getSource()==daoChu){
				JFileChooser chooser = new JFileChooser("D:");
			    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			    chooser.setFileFilter(new FileNameExtensionFilter("png & GIF Images",
			        "png", "gif","txt","exe"));
			    int value = chooser.showSaveDialog(this);
			    System.out.println("value : " + value);
			    if(value == JFileChooser.APPROVE_OPTION) {
			      File f = chooser.getSelectedFile();
			    }
			    
			}
			if(e.getSource()==tuiChu){
		    	this.dispose();
		    }
		    if(e.getSource()==checkDanJu){
		    	new DanJuDialogTwo(this,"���ݱ�",true);
		    }
		}
		/*
		 * ��ȡget����
		 */
		public JDatePicker getDatePickerTo() {
			return datePickerTo;
		}
		public JDatePicker getDatePickerTo2() {
			return datePickerTo2;
		}
		public DefaultTableModel getDft1() {
			return dft1;
		}
		public DefaultTableModel getDft2() {
			return dft2;
		}
		public JComboBox getYeWuYuanBox() {
			return yeWuYuanBox;
		}
		public JButton getCheck() {
			return check;
		}
		public JButton getCheckDanJu() {
			return checkDanJu;
		}
		public JButton getDaoChu() {
			return daoChu;
		}
		public JButton getDaYin() {
			return daYin;
		}
		public JButton getTuiChu() {
			return tuiChu;
		}
		public JButton getTongJi() {
			return tongJi;
		}
		public JLabel getCaiGouDate() {
			return caiGouDate;
		}
		public JLabel getYeWuYuanName() {
			return yeWuYuanName;
		}
		
		public JLabel getJiLu() {
			return jiLu;
		}
		public JTable getDanJuBiao() {
			return danJuBiao;
		}
		public JLabel getPinZhong() {
			return pinZhong;
		}
		public JTable getXinXiBiao() {
			return xinXiBiao;
		}
		public JLabel getJiLu1() {
			return jiLu1;
		}
		public JTable getMingXiBiao() {
			return mingXiBiao;
		}
		public JLabel getPinZhong1() {
			return pinZhong1;
		}
		public JTable getHuiZongBiao() {
			return huiZongBiao;
		}
		public JTabbedPane getMainJPane() {
			return mainJPane;
		}
		public DefaultTableModel getDft3() {
			return dft3;
		}
		public DefaultTableModel getDft4() {
			return dft4;
		}
		
        public JLabel getXinXiLabel() {
			return xinXiLabel;
		}
        public static void main(String args[]){
	
        }		
	
}
