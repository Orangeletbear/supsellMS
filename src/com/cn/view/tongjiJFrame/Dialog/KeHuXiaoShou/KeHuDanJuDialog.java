package com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.model.AllTableModel;
import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;
import com.cn.view.tongjiJFrame.ShangPingCaiGouMainFrame;


public class KeHuDanJuDialog extends JDialog {
	 KeHuXiaoShouMainFrame frame; //������
     JLabel danHao,kaiDanDate,needMoney,payMoney;//�⼸��JLable������ʾ���ţ��������ڣ�Ӧ������ʵ�����
     JLabel caiGouJinHuoDan;    //��������
     JLabel danHaoShow,kaiDanDateShow,needMoneyShow,payMoneyShow;//��ʾ���ţ��������ں�Ӧ����ʵ�����
     JTable mainTable;  //��ʾ�ı�
     DefaultTableModel dtm;
     String tableNames[]={"��Ʒ����","����ͺ�","����","����","�ܽ��","��Ӧ������","������","�ֿ�����"};
     String column[][];
     /**
      * �÷���������ʾ��Ʒ��һЩ������Ϣ���������ɸ�JLabel��һ��JTable
      */
      public KeHuDanJuDialog(KeHuXiaoShouMainFrame frame,String title,boolean modal){
    	  super(frame,title,modal);
    	  this.frame=frame;
    	  init();
      }
     
 	 public Vector getLabel(){
 		String sql=null;
 		 Vector v = new Vector();
 		 if(frame.getDanJuDtm().getValueAt(frame.getDanJuBiao().getSelectedRow(), 0).toString().startsWith("XS")){
 	 sql="select xs_xsdate,xs_ysje,xs_ssje from tb_sell_main where xs_id='"+
 	 frame.getDanJuDtm().getValueAt(frame.getDanJuBiao().getSelectedRow(), 0)+"'";}
 		 
 		 if(frame.getDanJuDtm().getValueAt(frame.getDanJuBiao().getSelectedRow(), 0).toString().startsWith("XT")){
 		 	 sql="select kh_th_date,kh_th_ytje,kh_th_stje from tb_khth_main where kh_th_id='"+
 		 	 frame.getDanJuDtm().getValueAt(frame.getDanJuBiao().getSelectedRow(), 0)+"'";}
 		 
 		
 		 
 		 
 	 Connection conn = JDBCTool.getConnection();
 	    Statement st = null;
 		ResultSet  rs = null;
 			try {
 				 st = conn.createStatement();
 				 rs = st.executeQuery(sql);
 				 int columnCount = rs.getMetaData().getColumnCount();
 				 rs.next();
 				 for(int column = 1;column<=columnCount;column++){
 						v.add(rs.getObject(column));
 					}
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			return v;
 	 }

 	 public Vector getTable(){
 		String sql=null;
 		
 		if(frame.getDanJuDtm().getValueAt(frame.getDanJuBiao().getSelectedRow(), 0).toString().startsWith("XS")){
 		 sql="select sp_name,sp_ggxh,sp_dj,xsd_num,xsd_szje,sp_sccs,xs_jbr,ck_name from " +
 		 		" tb_sell_main,tb_sell_detail,tb_spinfo,tb_ckinfo " +
 		 		" where xs_id=xsd_dh and xsd_id=sp_id and  xs_chName=ck_id and xs_id='"+
 		 		frame.getDanJuDtm().getValueAt(frame.getDanJuBiao().getSelectedRow(), 0).toString()+"'";
 		}
 		else if(frame.getDanJuDtm().getValueAt(frame.getDanJuBiao().getSelectedRow(), 0).toString().startsWith("XT")){
 			 sql="select sp_name,sp_ggxh,sp_dj,khthd_num,khthd_zje,sp_sccs,kh_th_jbr,ck_name from " +
		 		" tb_khth_main,tb_khth_detail,tb_spinfo,tb_ckinfo " +
		 		" where kh_th_id=khthd_dh and  khthd_thxdId=sp_id and   kh_th_chName=ck_id and kh_th_id='"+
		 		frame.getDanJuDtm().getValueAt(frame.getDanJuBiao().getSelectedRow(), 0).toString()+"'";
 	 		}
 		
	 		
 		 Vector data = new Vector();
 	    	Connection conn = JDBCTool.getConnection();
 		    Statement st = null;
 			ResultSet  rs = null;
 		try{
 				    st = conn.createStatement();
 					rs = st.executeQuery(sql);
 					//��ȡ���е�����
 					int columnCount = rs.getMetaData().getColumnCount();
 					while(rs.next()){
 						Vector tmp = new Vector();
 						for(int column = 1;column<=columnCount;column++){
 							tmp.add(rs.getObject(column));
 						}
 				    data.add(tmp);
 				}
 		 	    	
 			} catch (SQLException e) {
 				e.printStackTrace();
 				JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
 				
 			} finally{
 				JDBCTool.freeResorse(rs, st, conn);
 			}
 	    	
 	    	return data;
 	    }
 	 
      private void init(){
    	  this.setSize(800,500);
    	  this.setLocationRelativeTo(null);//�����������
    	  
    	  JPanel jp=new JPanel();
    	  jp.setLayout(new BorderLayout());
    	  /*
    	   * ���������ʵ���������
    	   */
    	  JPanel caiGouP=new JPanel();
    	  caiGouP.setLayout(new GridBagLayout());
    	  caiGouJinHuoDan=new JLabel("��Ʒ����");
    	  caiGouJinHuoDan.setFont(new Font("����",Font.BOLD,20));//���������С����ɫ
    	  caiGouJinHuoDan.setForeground(Color.red);
    	  caiGouP.add(caiGouJinHuoDan);
    	  danHao=new JLabel("����");
    	  kaiDanDate=new JLabel("��������");
    	  needMoney=new JLabel("Ӧ�����");
    	  payMoney=new JLabel("ʵ�����");
    	  danHaoShow=new JLabel( frame.getDanJuDtm().getValueAt(frame.getDanJuBiao().getSelectedRow(), 0).toString());
    	  danHaoShow.setPreferredSize(new Dimension(200, 18));
    	  danHaoShow.setBorder(new LineBorder(Color.red));
    	  kaiDanDateShow=new JLabel(getLabel().get(0).toString());
    	  kaiDanDateShow.setPreferredSize(new Dimension(200, 18));
    	  kaiDanDateShow.setBorder(new LineBorder(Color.red));
    	  needMoneyShow=new JLabel(getLabel().get(1).toString());
    	  needMoneyShow.setPreferredSize(new Dimension(180, 18));
    	  needMoneyShow.setBorder(new LineBorder(Color.red));
    	  payMoneyShow=new JLabel(getLabel().get(2).toString());
    	  payMoneyShow.setPreferredSize(new Dimension(180, 18));
    	  payMoneyShow.setBorder(new LineBorder(Color.red));
    	  dtm=new AllTableModel(column,tableNames);
    	  dtm.isCellEditable(0, 0);
    	  mainTable=new JTable(dtm);
    	  dtm.setDataVector(getTable(),
    				AllTableModel.getVectorFromObj(tableNames));
    	  JScrollPane jsp=new JScrollPane(mainTable);
    	  
    	  JPanel jp1=new JPanel();
    	  jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
    	  jp1.setBorder(new LineBorder(Color.lightGray,2,true));
    	  jp1.add(danHao);
    	  jp1.add(danHaoShow);
    	  jp1.add(kaiDanDate);
    	  jp1.add(kaiDanDateShow);
    	 
    	  JPanel jp2=new JPanel();
    	  jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
    	  jp2.add(needMoney);
    	  jp2.add(needMoneyShow);
    	  jp2.add(payMoney);
    	  jp2.add(payMoneyShow);
    	  jp2.setBorder(new LineBorder(Color.lightGray,2,true));
    	  
    	  JPanel centreP=new JPanel();
    	  centreP.setLayout(new BorderLayout());
    	  centreP.add(jp1,BorderLayout.NORTH);
    	  centreP.add(jsp,BorderLayout.CENTER);
    	  centreP.add(jp2,BorderLayout.SOUTH);
    	  jp.add(caiGouP,BorderLayout.NORTH);
    	  jp.add(centreP);
    	  this.add(jp);
    	  this.setVisible(true);
    	  
      }
}
