package com.cn.view.tongjiJFrame.Dialog.ShangPinXiaoShouDialog;

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
import com.cn.view.tongjiJFrame.CaiGouTongJiMainFrame;
import com.cn.view.tongjiJFrame.GoodsXiaoShouTongJi;
import com.cn.view.tongjiJFrame.Dialog.CaiGouTongJiCheckDialog;
import com.cn.view.tongjiJFrame.Dialog.GBC;
import com.cn.view.tongjiJFrame.Dialog.TongJiGongHuoShangDialog;



public class GoodsGuoLvDialog extends JDialog implements ActionListener {
    GoodsXiaoShouTongJi frame;
    JLabel gongHuoShang,cangKu,jingBanRen,danJu,danJuLable;//标示输入信息的JLabel
	JButton queDing,tuiChu,chaXun; //确定，退出和查询按钮
	JTextField showT;    //供货商名的输入框
	JComboBox cangKuBox,jingBanRenBox;//3个JComboBox
	/**
	 * 该方法向用户提供添加单据数据的窗口，其中有4个JLabel和3个JComboBox,
	 * 和1个JTextField以及3个按钮，分别为取消和确定,查询。
	 * @param frame
	 * @param title
	 * @param modal
	 */
      public GoodsGuoLvDialog(GoodsXiaoShouTongJi frame,String title,boolean modal){
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
    	  jingBanRen=new JLabel("经办人");
    	  danJu=new JLabel("单据类型");
    	  showT=new JTextField();
    	  showT.setPreferredSize(new Dimension(100,20));
    	  cangKuBox=new JComboBox(JDBCCuCunFind.getCanKuData());
    	  cangKuBox.addItem("所有仓库");
    	  cangKuBox.setSelectedItem("所有仓库");
    	  
    	  cangKuBox.setPreferredSize(new Dimension(100,20));
    	  jingBanRenBox=new JComboBox(POSJDBC.getAllWorker());
    	  jingBanRenBox.addItem("所有业务员");
    	  jingBanRenBox.setSelectedItem("所有业务员");
    	  
    	  jingBanRenBox.setPreferredSize(new Dimension(100,20));
    	  danJuLable=new JLabel("销售单");
    	  danJuLable.setPreferredSize(new Dimension(100,20));
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
    	  jp.add(danJuLable,new GBC(1,3).setInsets(5, 5, 5, 5));
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
    			String keHu=showT.getText();
    			String cangKu=cangKuBox.getSelectedItem().toString();
    	      	String jingBanRen=jingBanRenBox.getSelectedItem().toString();
    	      	String date1=DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate());
    	      	String date2=DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate());
    	      	if("所有仓库".equals(cangKu)&&"所有业务员".equals(jingBanRen)){
    	      		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id  and kh_Id=xs_khId  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and kh_name='"+keHu+"'";
    	      	}
    	     	else if(!"所有仓库".equals(cangKu)&&"所有业务员".equals(jingBanRen)){
    	     		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo,tb_ckinfo "+
                    "where xs_Id=xsd_dh and xs_chName=ck_id and sp_Id=xsd_Id  and kh_Id=xs_khId  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and kh_name='"+keHu+"' and ck_name='"+cangKu+"'";
			       
    	      	}
    	      	else if("所有仓库".equals(cangKu)&&!"所有业务员".equals(jingBanRen)){
    	      		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id  and kh_Id=xs_khId  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and kh_name='"+keHu+"' and xs_jbr='"+jingBanRen+"'";
    	      	}
    	      	else if(!"所有仓库".equals(cangKu)&&!"所有业务员".equals(jingBanRen)){
    	      		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo,tb_ckinfo "+
                    "where xs_Id=xsd_dh and xs_chName=ck_id and sp_Id=xsd_Id  and kh_Id=xs_khId  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and kh_name='"+keHu+"' and ck_name='"+cangKu+"' and xs_jbr='"+jingBanRen+"'";
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
        	 new KeHuJDialog(GoodsGuoLvDialog.this,"查询客户",true);
         }	
         if(e.getSource()==tuiChu){
        	 this.dispose();
         }
         if(e.getSource()==queDing){
        	frame.getDtm1().setDataVector(getChaZhaoXinxi(), AllTableModel.getVectorFromObj(tongJiModel.dtm1Names));
        	this.dispose();
         }
         
	}
	public JTextField getShowT() {
		return showT;
	}
      
}
