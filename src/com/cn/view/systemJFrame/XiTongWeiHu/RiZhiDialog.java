package com.cn.view.systemJFrame.XiTongWeiHu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.dao.system.GetCZYHaoJDBC;
import com.cn.dao.system.RiZhiJDBC;
import com.cn.model.AllTableModel;
import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
import com.cn.util.JDatePicker;
import com.cn.util.Log;
import com.cn.view.systemJFrame.SystemWeiHuFrame;

public class RiZhiDialog extends JDialog implements ActionListener {
	SystemWeiHuFrame frame;
	JButton qingKong,tuiChu,chaXun;
	JTextField Text;
	JDatePicker datePickerTo,datePickerTo1;
	JLabel jiLu;
	JTable riZhiTable;
	DefaultTableModel riZhiDtm;          //�����еĸ����
	String riZhiNames[]={"��־����","����Ա","��־����"};
	String riZhiColumn[][];                  //��־TABLE
	public RiZhiDialog(SystemWeiHuFrame frame,String title,boolean b){
		super(frame,title,b);
		this.frame=frame;
		init();
	}
	private void  init(){
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);                //�����������
		JPanel jp=new JPanel();
		jp.setLayout(new BorderLayout());
		riZhiDtm=new AllTableModel(riZhiColumn,riZhiNames);
		riZhiDtm.isCellEditable(0, 0);
		riZhiTable=new JTable(riZhiDtm);
		riZhiTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		riZhiTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		riZhiTable.getColumnModel().getColumn(2).setPreferredWidth(500);  //��ı���������
		JScrollPane js=new JScrollPane(riZhiTable);
		jiLu=new JLabel("��¼����");                               //ͳ�Ƽ�¼��
		jiLu.setForeground(Color.red);
		JPanel labelP=new JPanel();
		labelP.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelP.add(jiLu);
		jp.add(northP(),BorderLayout.NORTH);
		jp.add(js,BorderLayout.CENTER);
		jp.add(labelP,BorderLayout.SOUTH);
		qingKong.addActionListener(this);
		tuiChu.addActionListener(this);
		chaXun.addActionListener(this);         //��Ӽ�����
		this.add(jp);
		this.setVisible(true);
	}
	/*
	 * ��ȡ�����汱���Ĳ�ѯ���
	 */
	public JPanel northP(){
		JPanel jp=new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		 qingKong=new JButton(new ImageIcon("res\\AcionIcon\\clear.jpg"));
		 qingKong.setMargin(new Insets(0,0,0,0));
		 jp.add(qingKong);
		 tuiChu=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu.setMargin(new Insets(0,0,0,0));
		 jp.add(tuiChu);
		 jp.add(new JLabel("  �鿴ʱ��: "));
		 datePickerTo=new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 datePickerTo1=new JDatePicker(JDatePicker.STYLE_CN_DATE);
		 jp.add(datePickerTo);
		 jp.add(new JLabel(" �� "));
		 jp.add(datePickerTo1);
		 jp.add(new JLabel("��־����\\����Ա"));
		 Text=new JTextField();
		 Text.setPreferredSize(new Dimension(80,20));
		 //Text.setBorder(new LineBorder(Color.LIGHT_GRAY));
		 jp.add(Text);
		 chaXun=new JButton(new ImageIcon("res/smallIcon/01.png"));
		 chaXun.setMargin(new Insets(0,0,0,0));
		 jp.add(chaXun);
		 Text.setToolTipText("�������ٲ�������ģ����ѯ����Ϊ�������");
		 Text.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				try {
					Vector ve=RiZhiJDBC.getData(DateConventer.dateToStr(datePickerTo.getSelectedDate()),
							 DateConventer.dateToStr(datePickerTo1.getSelectedDate()),Text.getText());
					riZhiDtm.setDataVector(ve, AllTableModel.getVectorFromObj(riZhiNames));
					jiLu.setText("��¼��: "+riZhiDtm.getRowCount());           //��ѯ���ݿ��е�����
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			 
		 });

		return jp;
	}
	public void actionPerformed(ActionEvent e) {
         if(e.getSource()==tuiChu){
        	 this.dispose();
         }	
         if(e.getSource()==chaXun){
        	 try {
				Vector ve=RiZhiJDBC.getData(DateConventer.dateToStr(datePickerTo.getSelectedDate()),
						 DateConventer.dateToStr(datePickerTo1.getSelectedDate()),Text.getText());
				riZhiDtm.setDataVector(ve, AllTableModel.getVectorFromObj(riZhiNames));
				jiLu.setText("��¼��: "+riZhiDtm.getRowCount());           //��ѯ���ݿ��е�����
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         }
         if(e.getSource()==qingKong){
        	 int choice =  JOptionPane.showConfirmDialog(this,
						" ��ɾ��������־��ɾ���󲻿ɻָ���ȷ��ɾ���� ","�˳�����",
		        		 JOptionPane.YES_NO_OPTION, 3);
			     if(choice == JOptionPane.YES_OPTION){
		          		 String sql = "  delete  tb_logmessage ";
		      		 	Connection conn = JDBCTool.getConnection();
		  			    Statement st = null;
		  			    conn=JDBCTool.getConnection();
		  			    try {
		  					st=conn.createStatement();
		  					st.executeUpdate(sql);
		  				} catch (SQLException e1) {
		  					// TODO Auto-generated catch block
		  					e1.printStackTrace();
		  				}finally{
		  					JDBCTool.freeResouse(st, conn);
		  				}                                             //�����ݿ��ж����ݽ������
		  				 JOptionPane joptionP= new JOptionPane();
			          		//chaZhaoB.add(joptionP);
			          		JOptionPane.showMessageDialog(this, "��־ɾ���ɹ�");
			          		joptionP.setVisible(true);     //���������ʾ
			          		
			          		Date date = new Date();
			           	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			           	   String time = formatter.format(date); //��ȡ��ǰʱ��
			           	   String name=frame.getFrame().getUser();
			           	   String message="���������־����";
			           	   Vector v=new Vector();
			           	   v.add(time);
			           	   v.add(name);
			           	   v.add(message);
			           	   Log.logMessageToDataDB(v);  
			               Vector ve = null;
						try {
							ve = RiZhiJDBC.getData(DateConventer.dateToStr(datePickerTo.getSelectedDate()),
									 DateConventer.dateToStr(datePickerTo1.getSelectedDate()),Text.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						  riZhiDtm.setDataVector(ve, AllTableModel.getVectorFromObj(riZhiNames));
			           	   jiLu.setText("��¼��: "+riZhiDtm.getRowCount());
			           	
         }
	}
}
}