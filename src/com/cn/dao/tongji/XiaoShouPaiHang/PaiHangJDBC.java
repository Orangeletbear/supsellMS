package com.cn.dao.tongji.XiaoShouPaiHang;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class PaiHangJDBC {
	/*
	 * 查出各类单据信息
	 * djID 单据号
	 * isGetBZ 是否查出备注
	 */
    public static Vector getPaiHangData(String date1,String date2,String leiBie,String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql = null;
	 	       // JTextField leiBie=cg.getShangPinText(),
	 	      //  mingCheng=cg.getShangPinNameText(); //获取主界面组建
	 	    	if("所有仓库".equals(leiBie)&&mingCheng.equals("")){
				 sql ="select xsd_Id,sp_Name,xsd_num,xsd_szje,(xsd_szje-xsd_num*sp_jj), " +
						"round(((xsd_szje-xsd_num*sp_jj)/xsd_szje),2),sp_sccs "+
                    " from tb_sell_main,tb_spinfo,tb_sell_detail where xs_Id=xsd_dh and xsd_Id=sp_Id"+
				     "  and to_date('"+date1+"','YYYY-MM-DD')-" +
						"xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						"xs_xsdate>0"	;}
	 	    	else if(!"所有仓库".equals(leiBie)&&mingCheng.equals("")){
	 	    		sql ="select xsd_Id,sp_Name,xsd_num,xsd_szje,(xsd_szje-xsd_num*sp_jj), " +
					"round(((xsd_szje-xsd_num*sp_jj)/xsd_szje),2),sp_sccs "+
                " from tb_sell_main,tb_spinfo,tb_sell_detail,tb_ckinfo where ck_id=xs_chName and xs_Id=xsd_dh and xsd_Id=sp_Id"+
			     "  and to_date('"+date1+"','YYYY-MM-DD')-" +
					"xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
					"xs_xsdate>0 and ck_name='"+leiBie+"'" 	;
	 	    	}
	 	    	else if("所有仓库".equals(leiBie)&&!mingCheng.equals("")){
	 	    		sql ="select xsd_Id,sp_Name,xsd_num,xsd_szje,(xsd_szje-xsd_num*sp_jj), " +
					"round(((xsd_szje-xsd_num*sp_jj)/xsd_szje),2),sp_sccs "+
                " from tb_sell_main,tb_spinfo,tb_sell_detail where xs_Id=xsd_dh and xsd_Id=sp_Id"+
			     "  and to_date('"+date1+"','YYYY-MM-DD')-" +
					"xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
					"xs_xsdate>0 and sp_Name like '%"+mingCheng+"%'" ;
	 	    	}
	 	    	else{
	 	    		sql ="select xsd_Id,sp_Name,xsd_num,xsd_szje,(xsd_szje-xsd_num*sp_jj), " +
					"round(((xsd_szje-xsd_num*sp_jj)/xsd_szje),2),sp_sccs "+
                " from tb_sell_main,tb_spinfo,tb_sell_detail,tb_ckinfo where xs_chName=ck_id and xs_Id=xsd_dh and xsd_Id=sp_Id"+
			     "  and to_date('"+date1+"','YYYY-MM-DD')-" +
					"xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
					"xs_xsdate>0 and ck_name='"+leiBie+"'  and sp_Name like '%"+mingCheng+"%'";
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
