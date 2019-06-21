package com.cn.dao.tongji;


	import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
import com.cn.util.JDatePicker;
import com.cn.view.tongjiJFrame.ShangPingCaiGouMainFrame;

	public class CaiGouJDBC {
		static ShangPingCaiGouMainFrame cg; 
		/*
		 * 查出各类单据信息
		 * djID 单据号
		 * isGetBZ 是否查出备注
		 */
	    public static Vector getMingXiData(String date1,String date2,String leiBie,String mingCheng) {
	    	Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String sql = null;
		 	       // JTextField leiBie=cg.getShangPinText(),
		 	      //  mingCheng=cg.getShangPinNameText(); //获取主界面组建
		 	    	if("所有类".equals(leiBie)&&mingCheng.equals("")){
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
							"tb_cg_main.cg_date>0"	;}
		 	    	else if(!"所有类".equals(leiBie)&&mingCheng.equals("")){
		 	    		sql ="select tb_cg_main.cg_Id,tb_cg_main.cg_date" +
						",ghs_Name,tb_spinfo.sp_Name,tb_ckinfo.ck_Name," +
						"tb_spinfo.sp_dw,tb_spinfo. sp_dj,tb_cg_detail.cgd_num" +
						",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
						"tb_spinfo.sp_color,tb_cg_main.cg_jbr " +
						" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_sblb,tb_ghsinfo  where " +
						"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
						"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
						" and cg_ghs=ghs_Id and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and tb_spinfo.sp_lb=tb_sblb.sblb_Id and tb_sblb.sblb_Name='"+leiBie+"'";
		 	    	}
		 	    	else if("所有类".equals(leiBie)&&!mingCheng.equals("")){
		 	    		sql ="select tb_cg_main.cg_Id,tb_cg_main.cg_date" +
						",ghs_Name,tb_spinfo.sp_Name,tb_ckinfo.ck_Name," +
						"tb_spinfo.sp_dw,tb_spinfo. sp_dj,tb_cg_detail.cgd_num" +
						",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
						"tb_spinfo.sp_color,tb_cg_main.cg_jbr " +
						" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_ghsinfo where " +
						"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
						"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
						" and cg_ghs=ghs_Id and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and (tb_spinfo.sp_Name like '%"+mingCheng+"%'or tb_spinfo.sp_Id like '%"+mingCheng+"%')";
		 	    	}
		 	    	else if(!"所有类".equals(leiBie)&&!mingCheng.equals("")){
		 	    		sql ="select tb_cg_main.cg_Id,tb_cg_main.cg_date" +
						",ghs_Name,tb_spinfo.sp_Name,tb_ckinfo.ck_Name," +
						"tb_spinfo.sp_dw,tb_spinfo. sp_dj,tb_cg_detail.cgd_num" +
						",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
						"tb_spinfo.sp_color,tb_cg_main.cg_jbr " +
						" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_sblb,tb_ghsinfo  where " +
						"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
						"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
						" and cg_ghs=ghs_Id and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and tb_spinfo.sp_lb=tb_sblb.sblb_Id and tb_sblb.sblb_Name='"+leiBie+"'" +
										" and (tb_spinfo.sp_Name like '%"+mingCheng+"%'or tb_spinfo.sp_Id like '%"+mingCheng+"%')";
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
				
			} finally{
				JDBCTool.freeResorse(rs, st, conn);
			}
	    	
	    	return data;
	    }
	    
	    public static Vector getHuiZongData(String date1,String date2,String leiBie,String mingCheng) {
	    	Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String sql = null;
		 	       // JTextField leiBie=cg.getShangPinText(),
		 	      //  mingCheng=cg.getShangPinNameText(); //获取主界面组建
		 	    	if("所有类".equals(leiBie)&&mingCheng.equals("")){
					sql ="select tb_cg_main.cg_Id" +
					",tb_spinfo.sp_Name," +
					"tb_spinfo.sp_dw,tb_cg_detail.cgd_num" +
					",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
					"tb_spinfo.sp_color" +
					" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo  where " +
					"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
					"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
					"  and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date<0and to_date('"+date2+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date>0"	;}
		 	    	else if(!"所有类".equals(leiBie)&&mingCheng.equals("")){
		 	    		sql ="select tb_cg_main.cg_Id" +
						",tb_spinfo.sp_Name," +
						"tb_spinfo.sp_dw,tb_cg_detail.cgd_num" +
						",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
						"tb_spinfo.sp_color"  +
						" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_sblb  where " +
						"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
						"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
						"  and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and tb_spinfo.sp_lb=tb_sblb.sblb_Id and tb_sblb.sblb_Name='"+leiBie+"'";
		 	    	}
		 	    	else if("所有类".equals(leiBie)&&!mingCheng.equals("")){
		 	    		sql ="select tb_cg_main.cg_Id" +
						",tb_spinfo.sp_Name," +
						"tb_spinfo.sp_dw,tb_cg_detail.cgd_num" +
						",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
						"tb_spinfo.sp_color"  +
						" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo  where " +
						"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
						"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
						"  and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and (tb_spinfo.sp_Name='"
								+mingCheng+"'or tb_spinfo.sp_Id like '%"+mingCheng+"%')";
		 	    	}
		 	    	else{
		 	    		sql ="select tb_cg_main.cg_Id" +
						",tb_spinfo.sp_Name," +
						"tb_spinfo.sp_dw,tb_cg_detail.cgd_num" +
						",(tb_spinfo. sp_dj*tb_cg_detail.cgd_num),tb_spinfo.sp_ggxh," +
						"tb_spinfo.sp_color"  +
						" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_sblb  where " +
						"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
						"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
						"  and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and tb_spinfo.sp_lb=tb_sblb.sblb_Id and tb_sblb.sblb_Name='"
								+leiBie+"'and (tb_spinfo.sp_Name='"+mingCheng+"'or tb_spinfo.sp_Id like '%"+mingCheng+"%')";
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
				
			} finally{
				JDBCTool.freeResorse(rs, st, conn);
			}
	    	
	    	return data;
	    }
	    public static Vector getTongJiData(String date1,String date2,String leiBie,String mingCheng) {
	    	Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String sql = null;
		 	       // JTextField leiBie=cg.getShangPinText(),
		 	      //  mingCheng=cg.getShangPinNameText(); //获取主界面组建
		 	    	if("所有类".equals(leiBie)&&mingCheng.equals("")){
					sql ="select tb_sblb.sblb_name,sum(tb_cg_detail.cgd_num),(sum(tb_cg_detail.cgd_spzje))" +
					" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_sblb where " +
					"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
					"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
					"  and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
							"tb_cg_main.cg_date>0 and tb_sblb.sblb_id=tb_spinfo.sp_lb group by tb_sblb.sblb_name";}
		 	    	else if(!"所有类".equals(leiBie)&&mingCheng.equals("")){
		 	    		sql ="select tb_sblb.sblb_name,sum(tb_cg_detail.cgd_num),(sum(tb_cg_detail.cgd_spzje))"  +
						" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_sblb  where " +
						"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
						"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
						"  and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and tb_spinfo.sp_lb=tb_sblb.sblb_Id and tb_sblb.sblb_Name='"+leiBie+"'" +
										" group by tb_sblb.sblb_name";
		 	    	}
		 	    	else if("所有类".equals(leiBie)&&!mingCheng.equals("")){
		 	    		sql ="select tb_sblb.sblb_name,sum(tb_cg_detail.cgd_num),(sum(tb_cg_detail.cgd_spzje))"  +
						" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_sblb  where " +
						"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
						"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
						"  and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and (tb_spinfo.sp_Name='"
								+mingCheng+"'or tb_spinfo.sp_Id like '%"+mingCheng+"%')" +
										"and tb_sblb.sblb_id=tb_spinfo.sp_lb group by tb_sblb.sblb_name";
		 	    	}
		 	    	else{
		 	    		sql ="select tb_sblb.sblb_name,sum(tb_cg_detail.cgd_num),(sum(tb_cg_detail.cgd_spzje))"  +
						" from tb_cg_detail,tb_spinfo,tb_cg_main,tb_ckinfo,tb_sblb  where " +
						"tb_cg_detail.cgd_spId=tb_spinfo.sp_Id and " +
						"tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id" +
						"  and tb_ckinfo.ck_Id=tb_cg_main.cg_lkID and to_date('"+date1+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and tb_spinfo.sp_lb=tb_sblb.sblb_Id and tb_sblb.sblb_Name='"
								+leiBie+"' and (tb_spinfo.sp_Name='"+mingCheng+"'or tb_spinfo.sp_Id like '%"+mingCheng+"%') " +
										"group by tb_sblb.sblb_name";
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
				
			} finally{
				JDBCTool.freeResorse(rs, st, conn);
			}
	    	
	    	return data;
	    }

	

}
