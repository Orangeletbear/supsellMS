package com.cn.dao.tongji.ShangPinXiaoShouTongJi;


	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Vector;
	import javax.swing.JOptionPane;
	import com.cn.util.JDBCTool;
	public class GongHuoJDBC {
		/*
		 * 查出各类单据信息
		 * djID 单据号
		 * isGetBZ 是否查出备注
		 */
	    public static Vector getGongHuoData(String date1,String date2,String leiBie,String mingCheng) {
	    	Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String sql = null;
		 	       // JTextField leiBie=cg.getShangPinText(),
		 	      //  mingCheng=cg.getShangPinNameText(); //获取主界面组建
		 	    	if("所有类别".equals(leiBie)&&mingCheng.equals("")){
					sql =" select sp_sccs,sum(cgd_num),sum(cgd_spzje),sum(xsd_num),sum(xsd_szje)," +
							"round(sum(xsd_num)/sum(cgd_num),3),round(sum(xsd_szje)-sum(xsd_num*sp_jj),3)," +
							"round(sum(xsd_szje)-sum(xsd_num*sp_jj)/sum(xsd_szje),3) "+
                          "from tb_spinfo,tb_sell_main,tb_sell_detail,tb_cg_main,tb_cg_detail "+
                          "where xs_Id=xsd_dh and sp_Id=xsd_Id and cgd_spid=sp_Id and cgd_spdh=cg_Id and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0" +
                          " group by sp_sccs";}
		 	    	else if(!"所有类别".equals(leiBie)&&mingCheng.equals("")){
		 	    		sql =" select sp_sccs,sum(cgd_num),sum(cgd_spzje),sum(xsd_num),sum(xsd_szje)," +
						"round(sum(xsd_num)/sum(cgd_num),3),round(sum(xsd_szje)-sum(xsd_num*sp_jj),3)," +
						"round(sum(xsd_szje)-sum(xsd_num*sp_jj)/sum(xsd_szje),3) "+
                      "from tb_spinfo,tb_sell_main,tb_sell_detail,tb_cg_main,tb_cg_detail,tb_sblb "+
                      "where xs_Id=xsd_dh and sp_Id=xsd_Id and cgd_spid=sp_Id  and cgd_spdh=cg_Id" +
                      " and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and sblb_Id=sp_lb and sblb_Name='"+leiBie+"' group by sp_sccs";
		 	    	}
		 	    	else if("所有类别".equals(leiBie)&&!mingCheng.equals("")){
		 	    		sql =" select sp_sccs,sum(cgd_num),sum(cgd_spzje),sum(xsd_num),sum(xsd_szje)," +
						"round(sum(xsd_num)/sum(cgd_num),3),round(sum(xsd_szje)-sum(xsd_num*sp_jj),3)," +
						"round(sum(xsd_szje)-sum(xsd_num*sp_jj)/sum(xsd_szje),3) "+
                      "from tb_spinfo,tb_sell_main,tb_sell_detail,tb_cg_main,tb_cg_detail "+
                      "where xs_Id=xsd_dh and sp_Id=xsd_Id and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and  sp_sccs='"+mingCheng+"' group by sp_sccs";
		 	    	}
		 	    	else{
		 	    		sql =" select sp_sccs,sum(cgd_num),sum(cgd_spzje),sum(xsd_num),sum(xsd_szje)," +
						"round(sum(xsd_num)/sum(cgd_num),3),round(sum(xsd_szje)-sum(xsd_num*sp_jj),3)," +
						"round(sum(xsd_szje)-sum(xsd_num*sp_jj)/sum(xsd_szje),3) "+
                      "from tb_spinfo,tb_sell_main,tb_sell_detail,tb_cg_main,tb_cg_detail,tb_sblb  "+
                      "where xs_Id=xsd_dh and sp_Id=xsd_Id  and cgd_spid=sp_Id and cgd_spdh=cg_Id and sblb_Id=sp_lb " +
                      " and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and sblb_Name='"+leiBie+"' and sp_sccs='"+mingCheng+"' group by sp_sccs";
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
