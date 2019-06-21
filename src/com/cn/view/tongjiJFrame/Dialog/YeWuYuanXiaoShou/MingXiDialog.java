package com.cn.view.tongjiJFrame.Dialog.YeWuYuanXiaoShou;

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
import com.cn.util.JDBCTool;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;
import com.cn.view.tongjiJFrame.YeWuYuanMainFrame;


public class MingXiDialog extends JDialog {
	YeWuYuanMainFrame frame; //主窗口
     JLabel danHao,kaiDanDate,needMoney,payMoney;//这几个JLable用来标示单号，开单日期，应付金额和实付金额
     JLabel caiGouJinHuoDan;    //单号名称
     JLabel danHaoShow,kaiDanDateShow,needMoneyShow,payMoneyShow;//显示单号，开单日期和应付，实付金额
     JTable mainTable;  //显示的表
     DefaultTableModel dtm;
     String tableNames[]={"商品名称","规格型号","单价","数量","总金额","供应商名称","经办人","仓库名称"};
     String column[][];
     /**
      * 该方法用来显示商品的一些基本信息，包括若干个JLabel和一个JTable
      */
      public MingXiDialog(YeWuYuanMainFrame frame,String title,boolean modal){
    	  super(frame,title,modal);
    	  this.frame=frame;
    	  init();
      }
     
 	 public Vector getLabel(){
 		String sql=null;
 		 Vector v = new Vector();
 		 if( frame.getXiaoShouDtm().getValueAt(frame.getXiaoShouBiao().getSelectedRow(), 0).toString().toUpperCase().startsWith("XS")){
 	 sql="select  xs_xsdate,xs_jbr,xs_czy from tb_sell_main where xs_id='"+
 	 frame.getXiaoShouDtm().getValueAt(frame.getXiaoShouBiao().getSelectedRow(), 0).toString()+"'";}
 		 else{
 			 sql=" select  posxfb_date, yg_name,yg_name from tb_ posxfb_main,tb_yginfo where posxfb_dgyId=yg_id and posxfb_id='"+
 			frame.getXiaoShouDtm().getValueAt(frame.getXiaoShouBiao().getSelectedRow(), 0).toString()+"'";
 		 }
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
 		 if(frame.getXiaoShouDtm().getValueAt(frame.getXiaoShouBiao().getSelectedRow(), 0).toString().toUpperCase().startsWith("XS")){
 		 sql="select sp_name,sp_ggxh,sp_dj,xsd_num,xsd_szje,sp_sccs,xs_jbr,ck_name " +
 		 		" from tb_sell_main,tb_sell_detail,tb_ckinfo,tb_spinfo" +
 		 		" where xs_id=xsd_dh and xsd_id=sp_id  and xs_chName=ck_id and xs_id='"+
 		 		frame.getXiaoShouDtm().getValueAt(frame.getXiaoShouBiao().getSelectedRow(), 0).toString()+"'";}
 		 else{
 			  sql="select sp_name,sp_ggxh,sp_dj,posxfbd_num,posxfbd_zje,sp_sccs,yg_name,ck_name " +
		 		" from tb_posxfb_main,tb_posxfb_detail,tb_ckinfo,tb_spinfo,tb_yginfo " +
		 		" where  posxfb_Id=posxfbd_Id and   posxfbd_spId=sp_id  and posxfb_ckId=ck_id and posxfb_dgyId=yg_id  and posxfb_Id='"+
		 		frame.getXiaoShouDtm().getValueAt(frame.getXiaoShouBiao().getSelectedRow(), 0).toString()+"'";
 		 }
 		 Vector data = new Vector();
 	    	Connection conn = JDBCTool.getConnection();
 		    Statement st = null;
 			ResultSet  rs = null;
 		try{
 				    st = conn.createStatement();
 					rs = st.executeQuery(sql);
 					//获取表中的列数
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
 				JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
 				
 			} finally{
 				JDBCTool.freeResorse(rs, st, conn);
 			}
 	    	
 	    	return data;
 	    }
 	 
      private void init(){
    	  this.setSize(800,500);
    	  this.setLocationRelativeTo(null);//主界面的设置
    	  
    	  JPanel jp=new JPanel();
    	  jp.setLayout(new BorderLayout());
    	  /*
    	   * 各个组件的实例化与添加
    	   */
    	  JPanel caiGouP=new JPanel();
    	  caiGouP.setLayout(new GridBagLayout());
    	  caiGouJinHuoDan=new JLabel("销售单");
    	  caiGouJinHuoDan.setFont(new Font("宋体",Font.BOLD,15));//设置字体大小及颜色
    	  caiGouJinHuoDan.setForeground(Color.red);
    	  needMoney=new JLabel("经办人：");
    	  payMoney=new JLabel("操作员：");
    	  caiGouP.add(caiGouJinHuoDan);
    	  danHao=new JLabel("单号");
    	  kaiDanDate=new JLabel("开单日期");
    	  danHaoShow=new JLabel( frame.getXiaoShouDtm().getValueAt(frame.getXiaoShouBiao().getSelectedRow(), 0).toString());
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
