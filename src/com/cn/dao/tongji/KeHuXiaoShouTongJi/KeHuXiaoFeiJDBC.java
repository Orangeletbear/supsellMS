package com.cn.dao.tongji.KeHuXiaoShouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class KeHuXiaoFeiJDBC {
	/*
	 * 查出各类单据信息
	 * djID 单据号
	 * isGetBZ 是否查出备注
	 */
    public static Vector getXiaoFeiData(String date1,String date2,String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql = null;
	 	       // JTextField leiBie=cg.getShangPinText(),
	 	      //  mingCheng=cg.getShangPinNameText(); //获取主界面组建
			if(mingCheng.equals("")){
	 	    	sql=" select xsd_id,sp_name,sp_dw,xsd_num,xsd_szje,sp_ggxh,sp_color," +
	 	    		"sp_sccs,xs_bz from tb_sell_main,tb_sell_detail,tb_spinfo where xs_id=xsd_dh "+
                    " and  sp_id=xsd_id and to_date('"+date1+"','YYYY-MM-DD')-"+
					" tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					" tb_sell_main.xs_xsdate>0 ";
	 	    	}
			else{
				sql="select sp_id,sp_name,sp_dw,xsd_num,xsd_szje,sp_ggxh,sp_color," +
	 	    		"sp_sccs,xs_bz from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo where xs_id=xsd_dh "+
                    " and  sp_id=xsd_id and kh_id=xs_khid and to_date('"+date1+"','YYYY-MM-DD')-"+
					" tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					" tb_sell_main.xs_xsdate>0 and kh_name like '%"+mingCheng+"%'";
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
