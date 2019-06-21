package com.cn.view.tongjiJFrame.Dialog;

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
import com.cn.model.tongji.tongJiModel;
import com.cn.util.JDBCTool;
import com.cn.view.tongjiJFrame.ShangPingCaiGouMainFrame;


public class DanJuDialog extends JDialog {
	 ShangPingCaiGouMainFrame frame; //������
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
      public DanJuDialog(ShangPingCaiGouMainFrame frame,String title,boolean modal){
    	  super(frame,title,modal);
    	  this.frame=frame;
    	  init();
      }
     
 	 public Vector getLabel(){
 		 Vector v = new Vector();
 	 String sql="select cg_date,cg_yfje,cg_sfje from tb_cg_main where cg_id='"+
 	 frame.getDtm().getValueAt(frame.getShangPinTable().getSelectedRow(), 0)+"'";
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
 		 String sql="select sp_name,sp_ggxh,sp_dj,cgd_num,cgd_spzje,ghs_name,cg_jbr,ck_name " +
 		 		" from tb_cg_main,tb_cg_detail,tb_ghsinfo,tb_ckinfo,tb_spinfo" +
 		 		" where cg_id=cgd_spdh and cgd_spid=sp_id and cg_ghs=ghs_id and cg_lkid=ck_id and cg_id='"+
 		 		frame.getDtm().getValueAt(frame.getShangPinTable().getSelectedRow(), 0)+"'";
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
    	  caiGouJinHuoDan=new JLabel("�ɹ�������");
    	  caiGouJinHuoDan.setFont(new Font("����",Font.BOLD,15));//���������С����ɫ
    	  caiGouJinHuoDan.setForeground(Color.red);
    	  caiGouP.add(caiGouJinHuoDan);
    	  danHao=new JLabel("����");
    	  kaiDanDate=new JLabel("��������");
    	  needMoney=new JLabel("Ӧ�����");
    	  payMoney=new JLabel("ʵ�����");
    	  danHaoShow=new JLabel( frame.getDtm().getValueAt(frame.getShangPinTable().getSelectedRow(), 0).toString());
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
