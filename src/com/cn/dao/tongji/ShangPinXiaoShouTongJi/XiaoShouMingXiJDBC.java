package com.cn.dao.tongji.ShangPinXiaoShouTongJi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class XiaoShouMingXiJDBC {
	/*
	 * 查出各类单据信息
	 * djID 单据号
	 * isGetBZ 是否查出备注
	 */
    public static Vector getXiaoShouMingXiData(String date1,String date2,String leiBie,String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql = null;
	 	       // JTextField leiBie=cg.getShangPinText(),
	 	      //  mingCheng=cg.getShangPinNameText(); //获取主界面组建
	 	    	if("所有类别".equals(leiBie)&&mingCheng.equals("")){
				sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
						"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
						",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
						"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo "+
                        "where xs_Id=xsd_dh and sp_Id=xsd_Id  and kh_Id=xs_khId  and to_date('"+date1+"','YYYY-MM-DD')-"+
						"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
						"tb_sell_main.xs_xsdate>0";
				}
	 	    	
	 	    	else if(!"所有类别".equals(leiBie)&&mingCheng.equals("")){
	 	    		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_sblb,tb_khinfo "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id and kh_Id=xs_khId  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and tb_sblb.sblb_Id=sp_lb and sblb_Name='"+leiBie+"'";
	 	    	}
	 	    	else if("所有类别".equals(leiBie)&&!mingCheng.equals("")){
	 	    		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id and kh_Id=xs_khId and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and (sp_Name='"+mingCheng+"' or sp_Id like '%"+mingCheng+"%')";
	 	    	}
	 	    	else{
	 	    		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_sblbtb_khinfo "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id and kh_Id=xs_khId and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and tb_sblb.sblb_Id=sp_lb and sblb_Name='"+leiBie+"' " +
							" and (sp_Name='"+mingCheng+"' or sp_Id like '%"+mingCheng+"%')";
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
    
    public static Vector getXiaoShouHuiZongData(String date1,String date2,String leiBie,String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql = null;
	 	       // JTextField leiBie=cg.getShangPinText(),
	 	      //  mingCheng=cg.getShangPinNameText(); //获取主界面组建
	 	    	if("所有类别".equals(leiBie)&&mingCheng.equals("")){
	 	    		sql =" select sp_Id,sp_Name,sp_sccs,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2),sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0";}
	 	    	else if(!"所有类别".equals(leiBie)&&mingCheng.equals("")){
	 	    		sql =" select sp_Id,sp_Name,sp_sccs,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2),sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_sblb "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and tb_sblb.sblb_Id=sp_lb and sblb_Name='"+leiBie+"'";;
	 	    	}
	 	    	else if("所有类别".equals(leiBie)&&!mingCheng.equals("")){
	 	    		sql =" select sp_Id,sp_Name,sp_sccs,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2),sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and (sp_Name='"+mingCheng+"' or sp_Id like '%"+mingCheng+"%')";
	 	    	}
	 	    	else{
	 	    		sql =" select sp_Id,sp_Name,sp_sccs,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2),sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_sblb "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and tb_sblb.sblb_Id=sp_lb and sblb_Name='"+leiBie+"'" +
							"and (sp_Name='"+mingCheng+"' or sp_Id like '%"+mingCheng+"%')";
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
    public static Vector getXiaoShouTongJiData(String date1,String date2,String leiBie,String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql = null;
	 	       // JTextField leiBie=cg.getShangPinText(),
	 	      //  mingCheng=cg.getShangPinNameText(); //获取主界面组建
	 	    	if("所有类别".equals(leiBie)&&mingCheng.equals("")){
	 	    		sql=" select sblb_Name, sum(xsd_num),sum(xsd_szje),round((sum(xsd_szje)-sum(sp_jj*xsd_num)),2), " +
	 	    				"round((sum(xsd_szje)-sum(sp_jj*xsd_num))/sum(xsd_szje),2) " +
	 	    				"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_sblb " +
	 	    				"where xs_Id=xsd_dh and sp_Id=xsd_Id and to_date('2000-10-10','YYYY-MM-DD')-"+
						"tb_sell_main.xs_xsdate<0 and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and sp_lb=sblb_Id group by sblb_Name";
	 	    		}
	 	    	else if(!"所有类别".equals(leiBie)&&mingCheng.equals("")){
	 	    		sql=" select sblb_Name, sum(xsd_num),sum(xsd_szje),round((sum(xsd_szje)-sum(sp_jj*xsd_num)),2), " +
	    				"round((sum(xsd_szje)-sum(sp_jj*xsd_num))/sum(xsd_szje),2) " +
	    				"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_sblb " +
	    				"where xs_Id=xsd_dh and sp_Id=xsd_Id and to_date('2000-10-10','YYYY-MM-DD')-"+
				"tb_sell_main.xs_xsdate<0 and to_date('"+date1+"','YYYY-MM-DD')-"+
			"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
			"tb_sell_main.xs_xsdate>0 and sp_lb=sblb_Id and sblb_Name='"+leiBie+"' "+" group  by sblb_Name";
	 	    	}
	 	    	else if("所有类别".equals(leiBie)&&!mingCheng.equals("")){
	 	    		sql=" select sblb_Name, sum(xsd_num),sum(xsd_szje),round((sum(xsd_szje)-sum(sp_jj*xsd_num)),2), " +
	    				"round((sum(xsd_szje)-sum(sp_jj*xsd_num))/sum(xsd_szje),2) " +
	    				"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_sblb " +
	    				"where xs_Id=xsd_dh and sp_Id=xsd_Id and to_date('2000-10-10','YYYY-MM-DD')-"+
				"tb_sell_main.xs_xsdate<0 and to_date('"+date1+"','YYYY-MM-DD')-"+
			"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
			"tb_sell_main.xs_xsdate>0 and sp_lb=sblb_Id and (sp_Name='"+mingCheng+"' or sp_Id like '%"+mingCheng+"%')" +
			" group by sblb_Name";
	 	    	}
	 	    	else{
	 	    		sql=" select sblb_Name, sum(xsd_num),sum(xsd_szje),round((sum(xsd_szje)-sum(sp_jj*xsd_num)),2), " +
	    				"round((sum(xsd_szje)-sum(sp_jj*xsd_num))/sum(xsd_szje),2) " +
	    				"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_sblb " +
	    				"where xs_Id=xsd_dh and sp_Id=xsd_Id and to_date('2000-10-10','YYYY-MM-DD')-"+
				"tb_sell_main.xs_xsdate<0 and to_date('"+date1+"','YYYY-MM-DD')-"+
			"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
			"tb_sell_main.xs_xsdate>0 and sp_lb=sblb_Id  and sp_lb=sblb_Id and sblb_Name='"+leiBie+"'  " +
					"and (sp_Name='"+mingCheng+"' or sp_Id like '%"+mingCheng+"%')" +
			" group by sblb_Name";
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
