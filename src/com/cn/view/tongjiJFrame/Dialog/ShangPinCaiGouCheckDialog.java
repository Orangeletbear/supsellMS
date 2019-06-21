package com.cn.view.tongjiJFrame.Dialog;

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

import com.cn.dao.pos.POSJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
import com.cn.view.tongjiJFrame.ShangPingCaiGouMainFrame;



public class ShangPinCaiGouCheckDialog extends JDialog implements ActionListener {
	ShangPingCaiGouMainFrame frame;
    JLabel gongHuoShang,cangKu,jingBanRen,danJu;//标示输入信息的JLabel
	JButton queDing,tuiChu,chaXun; //确定，退出和查询按钮
	JTextField showT;    //供货商名的输入框
	JComboBox cangKuBox,jingBanRenBox,danJuBox;//3个JComboBox
	
	JTextField danJuText;
	/**
	 * 该方法向用户提供添加单据数据的窗口，其中有4个JLabel和3个JComboBox,
	 * 和1个JTextField以及3个按钮，分别为取消和确定,查询。
	 * @param frame
	 * @param title
	 * @param modal
	 */
      public ShangPinCaiGouCheckDialog(ShangPingCaiGouMainFrame frame,String title,boolean modal){
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
    	  gongHuoShang=new JLabel("供货商:");
    	  cangKu=new JLabel("仓库");
    	  jingBanRen=new JLabel("经办人");
    	  danJu=new JLabel("单据");
    	  showT=new JTextField(12);
    	  cangKuBox=new JComboBox(JDBCCuCunFind.getCanKuData());
    	  cangKuBox.addItem("所有仓库");
    	  cangKuBox.setSelectedItem("所有仓库");
    	  cangKuBox.setPreferredSize(new Dimension(100,20));
    	  jingBanRenBox=new JComboBox(POSJDBC.getAllWorker());
    	  jingBanRenBox.addItem("所有经办人");
    	  jingBanRenBox.setSelectedItem("所有经办人");
    	  jingBanRenBox.setPreferredSize(new Dimension(100,20));
    	  danJuText=new JTextField("进货单");
    	  danJuText.setEditable(false);
    	  danJuText.setPreferredSize(new Dimension(100,20));
    	  queDing=new JButton("确定");
    	  tuiChu=new JButton("退出");
    	  chaXun=new JButton(new ImageIcon("res\\AcionIcon\\search.png"));
    	  chaXun.setMargin(new Insets(0,0,0,0));
    	  jp.add(gongHuoShang,new GBC(0,0).setInsets(5, 5, 5, 5));
    	  jp.add(showT,new GBC(1,0).setInsets(5, 5, 5, 5));
    	  jp.add(chaXun,new GBC(2,0).setInsets(5, 5, 5, 5));
    	  jp.add(cangKu,new GBC(0,1).setInsets(5, 5, 5, 5));
    	  jp.add(cangKuBox,new GBC(1,1).setInsets(5, 5, 5, 5));
    	  jp.add(jingBanRen,new GBC(0,2).setInsets(5, 5, 5, 5));
    	  jp.add(jingBanRenBox,new GBC(1,2).setInsets(5, 5, 5, 5));
    	  jp.add(danJu,new GBC(0,3).setInsets(5, 5, 5, 5));
    	  jp.add(danJuText,new GBC(1,3).setInsets(5, 5, 5, 5));
    	  jp.add(queDing,new GBC(0,4).setInsets(5, 5, 5, 5));
    	  jp.add(tuiChu,new GBC(2,4).setInsets(5, 5, 5, 5));
    	  chaXun.addActionListener(this);
    	  tuiChu.addActionListener(this);
    	  queDing.addActionListener(this);
    	  this.add(jp);
    	  this.setVisible(true);
      }
      public Vector getChaZhaoXinxi(){
    	  String sql=null;
          Vector data = new Vector();
      	  Connection conn = JDBCTool.getConnection();
    	    Statement st = null;
    		ResultSet  rs = null;
    		try {
    			String gongHuoShang=showT.getText();
    			String cangKu=cangKuBox.getSelectedItem().toString();
    	      	String jingBanRen=jingBanRenBox.getSelectedItem().toString();
    	      	String date1=DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate());
    	      	String date2=DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate());
    	      	if("所有仓库".equals(cangKu)&&"所有经办人".equals(jingBanRen)){
    	      		sql ="select tb_cg_main.cg_Id,tb_cg_main.cg_date" +
					",ghs_Name,tb_spinfo.sp_Name,tb_ckinfo.ck_Name," +
					"tb_spinfo.sp_dw,tb_spinfo. sp_dj,tb_cg_detail.cgd_num" +
					",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
					"tb_spinfo.sp_color,tb_cg_main.cg_jbr " +
					" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_ghsinfo  where " +
					"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
					"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
					" and cg_ghs=ghs_Id and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date<0and to_date('"+date2+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date>0 and ghs_name='"+gongHuoShang+"'"	;}
    	      	else if(!"所有仓库".equals(cangKu)&&"所有经办人".equals(jingBanRen)){
    	      		sql ="select tb_cg_main.cg_Id,tb_cg_main.cg_date" +
					",ghs_Name,tb_spinfo.sp_Name,tb_ckinfo.ck_Name," +
					"tb_spinfo.sp_dw,tb_spinfo. sp_dj,tb_cg_detail.cgd_num" +
					",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
					"tb_spinfo.sp_color,tb_cg_main.cg_jbr " +
					" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_ghsinfo  where " +
					"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
					"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
					" and cg_ghs=ghs_Id and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date<0and to_date('"+date2+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date>0" +
        					" and ck_name='"+cangKu+"' and ghs_name='"+gongHuoShang+"'";
    	      	}
    	      	else if("所有仓库".equals(cangKu)&&!"所有经办人".equals(jingBanRen)){
    	      		sql ="select tb_cg_main.cg_Id,tb_cg_main.cg_date" +
					",ghs_Name,tb_spinfo.sp_Name,tb_ckinfo.ck_Name," +
					"tb_spinfo.sp_dw,tb_spinfo. sp_dj,tb_cg_detail.cgd_num" +
					",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
					"tb_spinfo.sp_color,tb_cg_main.cg_jbr " +
					" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_ghsinfo  where " +
					"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
					"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
					" and cg_ghs=ghs_Id and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date<0and to_date('"+date2+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date>0"	 +
        					" and cg_jbr='"+jingBanRen+"' and ghs_name='"+gongHuoShang+"'";
    	      	}
    	      	else{
    	      		sql ="select tb_cg_main.cg_Id,tb_cg_main.cg_date" +
					",ghs_Name,tb_spinfo.sp_Name,tb_ckinfo.ck_Name," +
					"tb_spinfo.sp_dw,tb_spinfo. sp_dj,tb_cg_detail.cgd_num" +
					",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
					"tb_spinfo.sp_color,tb_cg_main.cg_jbr " +
					" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_ghsinfo  where " +
					"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
					"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
					" and cg_ghs=ghs_Id and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date<0and to_date('"+date2+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date>0"+
        					" and ck_name='"+cangKu+"' and cg_jbr='"+jingBanRen+"' and ghs_name='"+gongHuoShang+"'";
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
	public void actionPerformed(ActionEvent e) {
         if(e.getSource()==chaXun){
        	 new GongHuoShangDialog(ShangPinCaiGouCheckDialog.this,"查询供货商",true);
         }	
         if(e.getSource()==tuiChu){
        	 this.dispose();
         }
         if(e.getSource()==queDing){
        	frame.getDtm().setDataVector(getChaZhaoXinxi(), AllTableModel.getVectorFromObj(tongJiModel.tableNames));
        	this.dispose();
         }
         
	}
	public JTextField getShowT() {
		return showT;
	}
      
}
