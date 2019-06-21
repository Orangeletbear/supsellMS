package com.cn.dao.tongji.YeWuYuanCaiGouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class MingXiJDBC {
	 public static Vector getMingXiData(String date1,String date2,String mingCheng) {
	    	Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String[] sql=new String[2];
				if("所有业务员".equals(mingCheng)){
				
					
				 sql[0]="select cg_Id,cg_date,tb_ghsinfo.ghs_Name,cgd_spId,tb_spinfo.sp_Name,tb_ckinfo.ck_Name,sp_dw,sp_dj,cgd_num,(sp_dj*cgd_num),sp_ggxh,sp_color,cg_jbr" +
						      " from tb_cg_main,tb_ghsinfo,tb_ckinfo,tb_cg_detail,tb_spinfo where cg_ghs=tb_ghsinfo.ghs_id and cg_lkid=tb_ckinfo.ck_id " +
						      "and to_date('"+date1+"','YYYY-MM-DD')-tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id and" +
								" tb_spinfo.sp_Id=cgd_spId";
				 sql[1]="select th_Id,th_date,tb_ghsinfo.ghs_Name,thd_spId,tb_spinfo.sp_Name,tb_ckinfo.ck_Name,sp_dw,sp_dj,thd_num,(sp_dj*thd_num),sp_ggxh,sp_color,th_jbr" +
						      " from tb_th_main,tb_ghsinfo,tb_ckinfo,tb_th_detail,tb_spinfo where th_ghs=tb_ghsinfo.ghs_id and th_ckId=tb_ckinfo.ck_id " +
						      "and to_date('"+date1+"','YYYY-MM-DD')-tb_th_main.th_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_th_main.th_date>0 and tb_th_detail.thd_spdh=tb_th_main.th_Id and" +
								" tb_spinfo.sp_Id=thd_spId";
              }
				else{

					 sql[0]="select cg_Id,cg_date,tb_ghsinfo.ghs_Name,cgd_spId,tb_spinfo.sp_Name,tb_ckinfo.ck_Name,sp_dw,sp_dj,cgd_num,(sp_dj*cgd_num),sp_ggxh,sp_color,cg_jbr" +
				      " from tb_cg_main,tb_ghsinfo,tb_ckinfo,tb_cg_detail,tb_spinfo where cg_ghs=tb_ghsinfo.ghs_id and cg_lkid=tb_ckinfo.ck_id " +
				      "and to_date('"+date1+"','YYYY-MM-DD')-tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						"tb_cg_main.cg_date>0 and tb_cg_detail.cgd_spdh=tb_cg_main.cg_Id and" +
						" tb_spinfo.sp_Id=cgd_spId and cg_jbr='"+mingCheng+"'";
		 sql[1]="select th_Id,th_date,tb_ghsinfo.ghs_Name,thd_spId,tb_spinfo.sp_Name,tb_ckinfo.ck_Name,sp_dw,sp_dj,thd_num,(sp_dj*thd_num),sp_ggxh,sp_color,th_jbr" +
				      " from tb_th_main,tb_ghsinfo,tb_ckinfo,tb_th_detail,tb_spinfo where th_ghs=tb_ghsinfo.ghs_id and th_ckId=tb_ckinfo.ck_id " +
				      "and to_date('"+date1+"','YYYY-MM-DD')-tb_th_main.th_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						"tb_th_main.th_date>0 and tb_th_detail.thd_spdh=tb_th_main.th_Id and" +
						" tb_spinfo.sp_Id=thd_spId and th_jbr='"+mingCheng+"'";
				}
				
		 	    	for(int i=0;i<sql.length;i++){
				    st = conn.createStatement();
					rs = st.executeQuery(sql[i]);
					//获取表中的列数
					int columnCount = rs.getMetaData().getColumnCount();
					while(rs.next()){
						Vector tmp = new Vector();
						for(int column = 1;column<=columnCount;column++){
							tmp.add(rs.getObject(column));
						}
				    data.add(tmp);
				}
		 	    //	}	
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
