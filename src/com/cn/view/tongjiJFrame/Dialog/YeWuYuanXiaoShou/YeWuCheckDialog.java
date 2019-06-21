package com.cn.view.tongjiJFrame.Dialog.YeWuYuanXiaoShou;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
import com.cn.view.tongjiJFrame.YeWuYuanMainFrame;
import com.cn.view.tongjiJFrame.Dialog.GBC;



public class YeWuCheckDialog extends JDialog implements ActionListener {
	YeWuYuanMainFrame frame;
    JLabel gongHuoShang,cangKu,jingBanRen,danJu;//标示输入信息的JLabel
	JButton queDing,tuiChu,chaXun; //确定，退出和查询按钮
	JTextField showT;    //供货商名的输入框
	JComboBox cangKuBox,danJuBox;//3个JComboBox

	String danJuNames[]={"所有单据","客户销售单","pos销售单"};
	/**
	 * 该方法向用户提供添加单据数据的窗口，其中有4个JLabel和3个JComboBox,
	 * 和1个JTextField以及3个按钮，分别为取消和确定,查询。
	 * @param frame
	 * @param title
	 * @param modal
	 */
      public YeWuCheckDialog(YeWuYuanMainFrame frame,String title,boolean modal){
    	  super(frame,title,modal);
    	  this.frame=frame;
    	  init();
      }
      private void init(){
    	  this.setSize(300, 300);
    	  this.setLocationRelativeTo(null);  //主界面的设置
    	  /*
    	   * 各个组件的实例化与添加
    	   */
    	  JPanel jp=new JPanel();
    	  jp.setLayout(new GridBagLayout());
    	  gongHuoShang=new JLabel("客户名称:");
    	  cangKu=new JLabel("仓库名称");
    	  danJu=new JLabel("单据类型");
    	  showT=new JTextField();
    	  showT.setPreferredSize(new Dimension(80,20));
    	  cangKuBox=new JComboBox(JDBCCuCunFind.getCanKuData());
    	  cangKuBox.addItem("所有仓库");
    	  cangKuBox.setSelectedItem("所有仓库");
    	  cangKuBox.setPreferredSize(new Dimension(80,20));
    	  danJuBox=new JComboBox(danJuNames);
    	  danJuBox.setPreferredSize(new Dimension(80,20));
    	  queDing=new JButton("确定");
    	  tuiChu=new JButton("退出");
    	  chaXun=new JButton(new ImageIcon("res\\AcionIcon\\search.png"));
    	  chaXun.setMargin(new Insets(0,0,0,0));
    	  jp.add(gongHuoShang,new GBC(0,0).setInsets(5, 5, 5, 5));
    	  jp.add(showT,new GBC(1,0).setInsets(5, 5, 5, 5));
    	  jp.add(chaXun,new GBC(2,0).setInsets(5, 5, 5, 5));
    	  jp.add(cangKu,new GBC(0,1).setInsets(5, 5, 5, 5));
    	  jp.add(cangKuBox,new GBC(1,1).setInsets(5, 5, 5, 5));
    	  jp.add(danJu,new GBC(0,2).setInsets(5, 5, 5, 5));
    	  jp.add(danJuBox,new GBC(1,2).setInsets(5, 5, 5, 5));
    	  jp.add(queDing,new GBC(0,3).setInsets(5, 5, 5, 5));
    	  jp.add(tuiChu,new GBC(2,3).setInsets(5, 5, 5, 5));
    	  chaXun.addActionListener(this);
    	  queDing.addActionListener(this);
    	  tuiChu.addActionListener(this);
    	  this.add(jp);
    	  this.setVisible(true);
      }
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==chaXun){
        	 new KeHUTongJiDialog(YeWuCheckDialog.this,"查询客户",true);
         }	
		 if(e.getSource()==tuiChu){
        	 this.dispose();
         }
		if(e.getSource()==queDing){
        	frame.getXiaoShouDtm().setDataVector(getChaZhaoXinxi(), AllTableModel.getVectorFromObj(tongJiModel.xiaoShouNames));
        	this.dispose();
         }
         
	}
	public JTextField getShowT() {
		return showT;
	}
      		
	 public Vector getChaZhaoXinxi(){
   	  String sql=null;
         Vector data = new Vector();
     	  Connection conn = JDBCTool.getConnection();
   	    Statement st = null;
   		ResultSet  rs = null;
   		try {
   			String keHu=showT.getText();
   			String cangKu=cangKuBox.getSelectedItem().toString();
   	      	String danJu=danJuBox.getSelectedItem().toString();
   	      	String date1=DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate());
   	      	String date2=DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate());
   	      	if("所有仓库".equals(cangKu)&&"所有单据".equals(danJu)){
   	      	sql="(select xs_id,xs_xsdate,xs_jbr,ck_name,'销售付款',xs_ysje,xs_ssje,round((sp_sj-sp_jj)*xsd_num,3)," +
 			" round(((sp_sj-sp_jj)*xsd_num)/xsd_szje,3),xs_czy,kh_name,xs_bz"+ 
             " FROM tb_sell_detail,tb_sell_main,tb_khinfo,tb_ckinfo,tb_spinfo "+
             " where xs_id=xsd_dh and xs_khid=kh_id and xs_chName=ck_id and sp_id=xsd_id and " +
             "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
			 "xs_xsdate>0 and kh_name='"+keHu+"' )"+"  union "+
 	      " (select posxfbd_id,posxfb_date,yg_name,ck_name,'现金',posxfb_yfje,posxfb_sfje,round((sp_sj-sp_jj)*posxfbd_num,3)," +
 	    		" round(((sp_sj-sp_jj)*posxfbd_num)/posxfbd_zje,3),yg_name,  posxfb_gkjb,posxfb_bz "+
                "  FROM tb_posxfb_main,tb_posxfb_detail,tb_ckinfo,tb_spinfo,tb_yginfo "+
                "  where posxfb_id=posxfbd_id  and posxfb_ckid=ck_id and posxfbd_spid=sp_id and posxfb_dgyId=yg_Id and " +
                "to_date('"+date1+"','YYYY-MM-DD')-posxfb_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
			    "posxfb_date>0 and posxfb_gkjb='"+keHu+"' )";
   	      	}
   	     	else if("所有仓库".equals(cangKu)&&"客户销售单".equals(danJu)){
   	     	sql="select xs_id,xs_xsdate,xs_jbr,ck_name,'销售付款',xs_ysje,xs_ssje,round((sp_sj-sp_jj)*xsd_num,3)," +
 			" round(((sp_sj-sp_jj)*xsd_num)/xsd_szje,3),xs_czy,kh_name,xs_bz"+ 
             " FROM tb_sell_detail,tb_sell_main,tb_khinfo,tb_ckinfo,tb_spinfo "+
             " where xs_id=xsd_dh and xs_khid=kh_id and xs_chName=ck_id and sp_id=xsd_id and " +
             "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
			 "xs_xsdate>0 and kh_name='"+keHu+"'";
			       
   	      	}
   	      	else if("所有仓库".equals(cangKu)&&"pos销售单".equals(danJu)){
   	      		sql = "select posxfbd_id,posxfb_date,yg_name,ck_name,'现金',posxfb_yfje,posxfb_sfje,round((sp_sj-sp_jj)*posxfbd_num,3)," +
 	    		" round(((sp_sj-sp_jj)*posxfbd_num)/posxfbd_zje,3),yg_name,  posxfb_gkjb,posxfb_bz "+
                "  FROM tb_posxfb_main,tb_posxfb_detail,tb_ckinfo,tb_spinfo,tb_yginfo "+
                "  where posxfb_id=posxfbd_id  and posxfb_ckid=ck_id and posxfbd_spid=sp_id and posxfb_dgyId=yg_Id and " +
                "to_date('"+date1+"','YYYY-MM-DD')-posxfb_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
			    "posxfb_date>0 and posxfb_gkjb='"+keHu+"'";
   	      	}
   	      	else if(!"所有仓库".equals(cangKu)&&"所有单据".equals(danJu)){
   	      	sql="(select xs_id,xs_xsdate,xs_jbr,ck_name,'销售付款',xs_ysje,xs_ssje,round((sp_sj-sp_jj)*xsd_num,3)," +
 			" round(((sp_sj-sp_jj)*xsd_num)/xsd_szje,3),xs_czy,kh_name,xs_bz"+ 
             " FROM tb_sell_detail,tb_sell_main,tb_khinfo,tb_ckinfo,tb_spinfo "+
             " where xs_id=xsd_dh and xs_khid=kh_id and xs_chName=ck_id and sp_id=xsd_id and " +
             "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
			 "xs_xsdate>0 and kh_name='"+keHu+"' and ck_name='"+cangKu+"')"+"  union "+
 	      " (select posxfbd_id,posxfb_date,yg_name,ck_name,'现金',posxfb_yfje,posxfb_sfje,round((sp_sj-sp_jj)*posxfbd_num,3)," +
 	    		" round(((sp_sj-sp_jj)*posxfbd_num)/posxfbd_zje,3),yg_name,  posxfb_gkjb,posxfb_bz "+
                "  FROM tb_posxfb_main,tb_posxfb_detail,tb_ckinfo,tb_spinfo,tb_yginfo "+
                "  where posxfb_id=posxfbd_id  and posxfb_ckid=ck_id and posxfbd_spid=sp_id and posxfb_dgyId=yg_Id and " +
                "to_date('"+date1+"','YYYY-MM-DD')-posxfb_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
			    "posxfb_date>0 and posxfb_gkjb='"+keHu+"'  and ck_name='"+cangKu+"')";
   	      	}
 	     	else if(!"所有仓库".equals(cangKu)&&"客户销售单".equals(danJu)){
 	     		sql="select xs_id,xs_xsdate,xs_jbr,ck_name,'销售付款',xs_ysje,xs_ssje,round((sp_sj-sp_jj)*xsd_num,3)," +
 	 			" round(((sp_sj-sp_jj)*xsd_num)/xsd_szje,3),xs_czy,kh_name,xs_bz"+ 
 	             " FROM tb_sell_detail,tb_sell_main,tb_khinfo,tb_ckinfo,tb_spinfo "+
 	             " where xs_id=xsd_dh and xs_khid=kh_id and xs_chName=ck_id and sp_id=xsd_id and " +
 	             "to_date('"+date1+"','YYYY-MM-DD')-xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
 				 "xs_xsdate>0 and kh_name='"+keHu+"' and ck_name='"+cangKu+"'";
			       
 	      	}
 	      	else if(!"所有仓库".equals(cangKu)&&"pos销售单".equals(danJu)){
 	      		sql = "select posxfbd_id,posxfb_date,yg_name,ck_name,'现金',posxfb_yfje,posxfb_sfje,round((sp_sj-sp_jj)*posxfbd_num,3)," +
 	    		" round(((sp_sj-sp_jj)*posxfbd_num)/posxfbd_zje,3),yg_name,  posxfb_gkjb,posxfb_bz "+
                "  FROM tb_posxfb_main,tb_posxfb_detail,tb_ckinfo,tb_spinfo,tb_yginfo "+
                "  where posxfb_id=posxfbd_id  and posxfb_ckid=ck_id and posxfbd_spid=sp_id and posxfb_dgyId=yg_Id and " +
                "to_date('"+date1+"','YYYY-MM-DD')-posxfb_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
			    "posxfb_date>0 and posxfb_gkjb='"+keHu+"' and ck_name='"+cangKu+"'";
 	      	}
 	      	
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
   			
   		} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
   			JDBCTool.freeResorse(rs, st, conn);
   		}
     	
     	return data;
     }
}

