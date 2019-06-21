
package com.cn.view.tongjiJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.cn.control.tongjiframe.KuCunTongJi.KuCunListener;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;

public class KuCunMainFrame extends JDialog implements ActionListener {
	/*
	 * 各个按钮以及查找栏中的组件
	 */
	JButton daoChu,daYin,tuiChu,chaXun;
	JLabel tongJiYue,nian,yueZhi,nianTwo,yue,cangKuName;	
	JComboBox cangKu;
	JSpinner js1,js2,js3,js4;
	/*
	 * 选项卡中的各组件
	 */
	JTabbedPane kuCunKa;
	JTable kuCunBiao;
	DefaultTableModel dtm;
	JLabel jiLu;
	
	/**
	 * 改方法创建了一个JDialog窗口，窗口中有3个按钮，和一个查找栏，以及一个选项卡。3个按钮分别是
	 * 导出，打印，退出。查找栏中有查找的时间段，查找的仓库名称。选项卡是一个表格显示选项卡。
	 */
	 public KuCunMainFrame(JFrame owner,String title,boolean model){
    	 super(owner,title,model);
    	 init();
    	 }
     private void init(){
    	 this.setSize(800, 500);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		 this.setLocationRelativeTo(null);//主界面的设置
		 
		 JPanel jp=new JPanel();
		 jp.setLayout(new BorderLayout());
		 /*
		  * JButton的实例化和添加
		  */
		 JPanel buttonP=new JPanel();
		 buttonP.setBorder(new LineBorder(Color.lightGray,2,true));
		 buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
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
		  * 查找栏中的各组件的实例化和添加
		  */
		 tongJiYue=new JLabel("统计月份");
		 nian=new JLabel("年");
		 yueZhi=new JLabel("月 至");
		 nianTwo=new JLabel("年");
		 yue=new JLabel("月");
		 cangKuName=new JLabel("仓库名称");
		 chaXun=new JButton("查询");
		 js1=new JSpinner(new SpinnerNumberModel(2010,0,2999,1));
		 js2=new JSpinner(new SpinnerNumberModel(01,01,12,1));
		 js3=new JSpinner(new SpinnerNumberModel(2010,0,2999,1));
		 js4=new JSpinner(new SpinnerNumberModel(10,01,12,1));
		 cangKu=new JComboBox(JDBCCuCunFind.getCanKuData());
		 cangKu.addItem("所有仓库");
		 cangKu.setSelectedItem("所有仓库");
		 JPanel northP=new JPanel();
		 northP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 northP.setBorder(new LineBorder(Color.lightGray,2,true));
		 northP.add(tongJiYue);
		 northP.add(js1);
		 northP.add(nian);
		 northP.add(js2);
		 northP.add(yueZhi);
		 northP.add(js3);
		 northP.add(nianTwo);
		 northP.add(js4);
		 northP.add(yue);
		 northP.add(cangKuName);
		 northP.add(cangKu);
		 northP.add(chaXun);
		 /*
		  * 选项卡的实例化以及添加
		  */
		 dtm=new AllTableModel(tongJiModel.kuCunColumn,tongJiModel.kuCunNames);
		 dtm.isCellEditable(0, 0);
		 kuCunBiao=new JTable(dtm);
		 JScrollPane centreP=new JScrollPane(kuCunBiao);
		 kuCunKa=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		 kuCunKa.add("表格显示",centreP);
		 jiLu=new JLabel("记录数：");
		 jiLu.setForeground(Color.red);
		 
		 JPanel southP=new JPanel();
		 southP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 southP.add(jiLu);
		 /*
		  * 将各个面板添加到主界面
		  */
		 JPanel jpTwo=new JPanel();
		 jpTwo.setLayout(new BorderLayout());
		 jpTwo.add(northP,BorderLayout.NORTH);
		 jpTwo.add(kuCunKa,BorderLayout.CENTER);
		 jpTwo.add(southP,BorderLayout.SOUTH);
		 jp.add(buttonP,BorderLayout.NORTH);
		 jp.add(jpTwo);
		addAction();
		chaXun.addActionListener(l);
		this.add(jp);
		this.setVisible(true);
		 
     }
     public ActionListener l=new KuCunListener(this);
     /*
      * 添加监听器
      */
     private void addAction(){
    	 daoChu.addActionListener(this);
    	 tuiChu.addActionListener(this);
     }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new KuCunMainFrame(null,"",true);
	}
/*
 * 实例化监听器
 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==daoChu){
			JFileChooser chooser = new JFileChooser("D:");
		    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    chooser.setFileFilter(new FileNameExtensionFilter("png & GIF Images",
		        "png", "gif","txt","exe"));
		    int value = chooser.showSaveDialog(this);
		    //int value = chooser.showOpenDialog(frame);
		    System.out.println("value : " + value);
		    if(value == JFileChooser.APPROVE_OPTION) {
		      File f = chooser.getSelectedFile();
		      //this.mingBianT.setText(f.getAbsolutePath());
		      //System.out.println(f.getAbsolutePath());
		    }
		}
		else{
			this.dispose();
		}
	}
	public JComboBox getCangKu() {
		return cangKu;
	}
	public JLabel getCangKuName() {
		return cangKuName;
	}
	public JButton getChaXun() {
		return chaXun;
	}
	public JButton getDaoChu() {
		return daoChu;
	}
	public JButton getDaYin() {
		return daYin;
	}
	public DefaultTableModel getDtm() {
		return dtm;
	}
	public JLabel getJiLu() {
		return jiLu;
	}
	
	public JSpinner getJs1() {
		return js1;
	}
	public JSpinner getJs2() {
		return js2;
	}
	public JSpinner getJs3() {
		return js3;
	}
	public JSpinner getJs4() {
		return js4;
	}
	public JTable getKuCunBiao() {
		return kuCunBiao;
	}
	public JTabbedPane getKuCunKa() {
		return kuCunKa;
	}
	public ActionListener getL() {
		return l;
	}
	public JLabel getNian() {
		return nian;
	}
	public JLabel getNianTwo() {
		return nianTwo;
	}
	public JLabel getTongJiYue() {
		return tongJiYue;
	}
	public JButton getTuiChu() {
		return tuiChu;
	}
	
	public JLabel getYue() {
		return yue;
	}
	public JLabel getYueZhi() {
		return yueZhi;
	}

}
