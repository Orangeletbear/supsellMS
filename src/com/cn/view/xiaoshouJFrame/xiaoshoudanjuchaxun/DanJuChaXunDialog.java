package com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.DanJuFindAction;
import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.MouseListe;
import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.TimeFindDanJuAction;
import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.XiangXiChaZhaoAction;
import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.ZhengDanTuiHuoAction;
import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.xiaoshoudanjuchaxun.DanJuColumnames;
import com.cn.util.JDatePicker;

/**
 * 
 * �������۹���ģ���е����۵��ݲ�ѯ�Ի���
 * @author Administrator
 *
 */
public class DanJuChaXunDialog extends JDialog {
	
	//��ϸ���Ұ�ť
	private JButton panel_north_xiangXiFound = new JButton(new ImageIcon("res/AcionIcon/xiangxichazhao.jpg"));
	//�鿴���ݰ�ť
	private JButton panel_north_chaKanDanJu = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	//�����˻���ť
	private JButton panel_north_tuiHuo= new JButton(new ImageIcon("res/AcionIcon/zhengdantuihuo.jpg"));
	//������ť
	private JButton panel2_north_daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	//��ӡ��ť
	private JButton panel_north_daYin = new JButton(new ImageIcon("res/AcionIcon/dayin.jpg"));
	//�˳���ť
	private JButton panel_north_tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
	
	//panel_center
    //��������
	private JDatePicker panel_center_chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	private JDatePicker panel_center_zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE); 
	private JButton panel_center_RIQI = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
    //�ͻ�/���ݲ�ѯ�ı���
	private JTextField panel_center_keHuText = new JTextField(10);
   
	//�ͻ�/���ݲ�ѯ��ť
	private JButton panel_center_chaXun = new JButton("��ѯ");
	//
	
	//���ܱ�
	
	private JTable huiZongTable;
	AllTableModel tabelModel  = new AllTableModel(DanJuColumnames.obj,
			DanJuColumnames.zongBiaoColumnames);
	private JLabel shangPinMingXiLabel = new JLabel(" ");
	//��ϸ��
	private  JTable mingXiTable;
	AllTableModel tabelModel2  = new AllTableModel(DanJuColumnames.obj,
			DanJuColumnames.mingXiBiaoColumnames);

   
	//��ʼ��ʱ������
    public DanJuChaXunDialog(JFrame frame,String title,boolean modal){
    	
    	super(frame,title,modal);
    	init();
    	this.setVisible(true);
    }
    
  //��ʼ��ʱ�����ܱ��д�������
    public DanJuChaXunDialog(JDialog dialog,String title,boolean modal){
    	
    	super(dialog,title,modal);
    	init();
    	initData();
    	//this.setVisible(true);
    }
     public void init() {
    
    	this.setSize(850, 600);
    	this.setResizable(false);
    	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.add(panel());
    	
    }
    
    
    private JPanel panel(){
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		panel.add(panel_north(),BorderLayout.NORTH);
		panel.add(panel_center(),BorderLayout.CENTER);
		JLabel label = new JLabel("");
		panel.add(label,BorderLayout.SOUTH);
		
		return panel;
	}
	//panel_north
	private JPanel panel_north(){
		JPanel panel_north = new JPanel();
		
		panel_north_xiangXiFound.setMargin(new Insets(0,0,0,0));
		panel_north_chaKanDanJu.setMargin(new Insets(0,0,0,0));
		panel_north_tuiHuo.setMargin(new Insets(0,0,0,0));
		panel2_north_daoChu.setMargin(new Insets(0,0,0,0));
		panel_north_daYin.setMargin(new Insets(0,0,0,0));
		panel_north_tuiChu.setMargin(new Insets(0,0,0,0));
		
		panel_north.setLayout(new FlowLayout(FlowLayout.LEFT,25,10));
		panel_north.add(panel_north_xiangXiFound);
		ActionListener listener = new  XiangXiChaZhaoAction(this);
		panel_north_xiangXiFound.addActionListener(listener);
		panel_north.add(panel_north_chaKanDanJu);
		panel_north.add(panel_north_tuiHuo);
		panel_north_tuiHuo.addActionListener(new ZhengDanTuiHuoAction(this));
		panel_north.add(panel2_north_daoChu);
		panel_north.add(panel_north_daYin);
		panel_north.add(panel_north_tuiChu);
		panel_north_tuiChu.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e) {
			
			    	 dispose();
			}
			
		});
		panel_north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		return panel_north;
	}
	//panel_center ��Ϊ������
	private JPanel panel_center(){
		JPanel panel_center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane = new JPanel();
		JPanel pane3 = new JPanel();
		pane.setLayout(new GridLayout(2,1));
		pane.setBorder(new TitledBorder("��Ʒ���ۻ���"));
		//pane1
	
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT,15,2));
		pane1.add(new JLabel("��ѯʱ�� :"));
		pane1.add(panel_center_chaXunShiJian);
		
		pane1.add(new JLabel("�� "));
		pane1.add(panel_center_zhi);
		panel_center_RIQI.setMargin(new Insets(0,0,0,0));
		panel_center_RIQI.addActionListener(new TimeFindDanJuAction(this));
		pane1.add(panel_center_RIQI);
		pane1.add( new JLabel("���ͻ�/���ݺŲ�ѯ:"));
		pane1.add(panel_center_keHuText);
		pane1.add(panel_center_chaXun);
		
		ActionListener listener = new DanJuFindAction(this);
		panel_center_chaXun.addActionListener(listener);
		
		huiZongTable = new JTable(tabelModel);
		huiZongTable.addMouseListener(new MouseListe(this,huiZongTable.getSelectedRow()));
	
		huiZongTable.setPreferredScrollableViewportSize(new Dimension(880,356));//���̶���С
	    mingXiTable = new JTable(tabelModel2);
		mingXiTable.setPreferredScrollableViewportSize(new Dimension(880,356));//���̶���С
		
		pane3.setLayout(new BorderLayout());
		JPanel pane4 = new JPanel();
		pane4.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane4.add(new JLabel("���ݵ���ϸ��Ϣ:"));
		pane4.add(shangPinMingXiLabel);
		pane3.add(pane4,BorderLayout.NORTH);
		pane3.add(new JScrollPane(mingXiTable));
		pane3.add(new JLabel("˵��:���ݱ��ѯ���۵���Ϣ�����ܱ�" +
				      "��ϸ���ѯ��ʾ���ܽ������Żݽ��"),BorderLayout.SOUTH);
		
		
		pane.add(new JScrollPane(huiZongTable));
		pane.add(pane3);
		
		
		panel_center.setLayout(new BorderLayout());
		panel_center.add(pane1,BorderLayout.NORTH);
		panel_center.add(pane,BorderLayout.CENTER);
		
		
		return panel_center;
	}
	public JTextField getPanel_center_keHuText() {
			return panel_center_keHuText;
		}

	public JDatePicker getPanel_center_chaXunShiJian() {
		return panel_center_chaXunShiJian;
	}

	public JDatePicker getPanel_center_zhi() {
		return panel_center_zhi;
	}

	public AllTableModel getTabelModel() {
		return tabelModel;
	}

	public AllTableModel getTabelModel2() {
		return tabelModel2;
	}

	public JTable getHuiZongTable() {
		return huiZongTable;
	}

	public JTable getMingXiTable() {
		return mingXiTable;
	}


	public JLabel getShangPinMingXiLabel() {
		return shangPinMingXiLabel;
	}

	public void initData(){
		 
		Vector data  = JDBCDanJuFind.getAllData();
	    tabelModel.setDataVector(data, 
				AllTableModel.getVectorFromObj(DanJuColumnames.zongBiaoColumnames));
		huiZongTable.setModel(tabelModel);
		
	}
	//������

	public static void main(String[] args){
		new DanJuChaXunDialog((JFrame)null,"���۵��ݲ�ѯ",true);
	}
}
