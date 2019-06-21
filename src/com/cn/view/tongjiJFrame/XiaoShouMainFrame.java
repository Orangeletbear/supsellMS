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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.cn.control.tongjiframe.ShangPinPaiHang.PaiHangListener;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.JDatePicker;
import com.cn.view.tongjiJFrame.Dialog.JinHuoDialog;
import com.cn.view.tongjiJFrame.Dialog.TuiHuoDialog;

public class XiaoShouMainFrame extends JDialog implements ActionListener {
	/*
	 * ������ť�Լ��������е����
	 */
	JButton daYin,jinHuo,tuiHuo,daoChu,tuiChu,chaXun;
	JLabel caiGouDate,zhi,cangKu,shangPingMing;
	JComboBox box;
	JDatePicker datePickerTo,datePickerTo1;
	/*
	 * JTable��model��JLabel
	 */
	JTable biaoGeJTable;
	JLabel jiLu;
	DefaultTableModel dtm;
	
	JTextField cangKuKind;
	/**
	 * �ķ���������һ��JDialog���ڣ���������5����ť����һ�����������Լ�һ��JTable��5����ť�ֱ���
	 * ��ӡ�������ο����˻��ο����������˳������������в��ҵ�ʱ��Σ����ҵĲֿ����ƺ���Ʒ���ơ�
	 */
	 public XiaoShouMainFrame(JFrame owner,String title,boolean model){
    	 super(owner,title,model);
    	 init();
    	 }
     private void init(){
    	 this.setSize(800, 500);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		 this.setLocationRelativeTo(null);//�����������
		 
		 JPanel jp=new JPanel();
		 jp.setLayout(new BorderLayout());
		 /*
		  * ��ť��ʵ�������
		  */
		 JPanel buttonP=new JPanel();
		 buttonP.setBorder(new LineBorder(Color.lightGray,2,true));
		 buttonP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 daYin=new JButton(new ImageIcon("res\\AcionIcon\\print.jpg"));
		 daYin.setMargin(new Insets(0,0,0,0));
		 buttonP.add(daYin);
		 jinHuo=new JButton(new ImageIcon("res\\AcionIcon\\jinhuochangkao.jpg"));
		 jinHuo.setMargin(new Insets(0,0,0,0));
		 buttonP.add(jinHuo);
		 
		 tuiHuo=new JButton(new ImageIcon("res\\AcionIcon\\tuihuochangkao.jpg"));
		 tuiHuo.setMargin(new Insets(0,0,0,0));
		 buttonP.add(tuiHuo);
		 
		 daoChu=new JButton(new ImageIcon("res\\AcionIcon\\import.jpg"));
		 daoChu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(daoChu);
		 
		 tuiChu=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu.setMargin(new Insets(0,0,0,0));
		 buttonP.add(tuiChu);
		 /*
		  * ��������ʵ�������
		  */
		 caiGouDate=new JLabel("�ɹ�ʱ��");
		 zhi=new JLabel("��");
		 datePickerTo= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo1= new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 cangKu=new JLabel("�ֿ⣺");
		 shangPingMing=new JLabel("��Ʒ����");
		 box=new JComboBox(JDBCCuCunFind.getCanKuData());
		 box.addItem("���вֿ�");
		 box.setSelectedItem("���вֿ�");
		 
		 cangKuKind=new JTextField(10);
		 chaXun=new JButton("��ѯ");
		 JPanel northP=new JPanel();
		 northP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 northP.add(caiGouDate);
		 northP.add(datePickerTo);
		 northP.add(zhi);
		 northP.add(datePickerTo1);
		 northP.add(box);
		 northP.add(cangKu);
		 northP.add(box);
		 northP.add(shangPingMing);
		 northP.add(cangKuKind);
		 northP.add(chaXun);
		 /*
		  * JTable��ʵ�������
		  */
		 dtm=new AllTableModel(tongJiModel.biaoGecolumn,tongJiModel.biaoGeNames);
		 dtm.isCellEditable(0, 0);
		 biaoGeJTable=new JTable(dtm);
		 JScrollPane biaoGeJS=new JScrollPane(biaoGeJTable);
		 jiLu=new JLabel("��¼����");
		 jiLu.setForeground(Color.red);
		 JPanel jiLuP=new JPanel();
		 jiLuP.setLayout(new FlowLayout(FlowLayout.LEFT));
		 jiLuP.add(jiLu);
		 JPanel biaoGeP=new JPanel();
		 biaoGeP.setLayout(new BorderLayout());
		 biaoGeP.add(jiLuP,BorderLayout.SOUTH);
		 biaoGeP.add(biaoGeJS);
		 
		 /*
		  * ������������
		  */
		 JPanel centreP=new JPanel();
		 centreP.setLayout(new BorderLayout());
		 centreP.add(northP,BorderLayout.NORTH);
		 centreP.add(biaoGeP);
		 
		 jp.add(buttonP,BorderLayout.NORTH);
		 jp.add(centreP);
		 addAction();
		 chaXun.addActionListener(l);
		 this.add(jp);
		 this.setVisible(true);
     }
     public ActionListener l=new PaiHangListener(this);
     /*
      * �����������
      */
     private void addAction(){
    	 jinHuo.addActionListener(this);
    	 tuiHuo.addActionListener(this);
    	 daoChu.addActionListener(this);
    	 tuiChu.addActionListener(this);
     }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new XiaoShouMainFrame(null,"",true);
	}
/**
 * ��������ʵ��
 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jinHuo){
			new JinHuoDialog(this,"�����ο�",true);
		}
		if(e.getSource()==tuiHuo){
			new TuiHuoDialog(this,"�˻��ο�",true);
		}
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
		if(e.getSource()==tuiChu){
			this.dispose();
		}
	}
public JButton getDaYin() {
	return daYin;
}
public JButton getJinHuo() {
	return jinHuo;
}
public JButton getTuiHuo() {
	return tuiHuo;
}
public JButton getDaoChu() {
	return daoChu;
}
public JButton getTuiChu() {
	return tuiChu;
}
public JButton getChaXun() {
	return chaXun;
}
public JLabel getCaiGouDate() {
	return caiGouDate;
}
public JLabel getZhi() {
	return zhi;
}
public JLabel getCangKu() {
	return cangKu;
}
public JLabel getShangPingMing() {
	return shangPingMing;
}
public JComboBox getBox() {
	return box;
}

public JDatePicker getDatePickerTo() {
	return datePickerTo;
}
public JDatePicker getDatePickerTo1() {
	return datePickerTo1;
}
public JTable getBiaoGeJTable() {
	return biaoGeJTable;
}
public JLabel getJiLu() {
	return jiLu;
}
public DefaultTableModel getDtm() {
	return dtm;
}
public JTextField getCangKuKind() {
	return cangKuKind;
}
public ActionListener getL() {
	return l;
}

}
