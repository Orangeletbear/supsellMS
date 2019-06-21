package com.cn.dao.tongji.YeWuYuanXiaoShouTongJi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class YeWuMingXiMouseJDBC {
	/*
	 * 查出各类单据信息
	 * djID 单据号
	 * isGetBZ 是否查出备注
	 */
    public static Vector getYeWuMingXiData(String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql = null;
	 	   if(mingCheng.toLowerCase().startsWith("xs")){
			sql="  select xsd_id,sp_name,sp_dw,sp_dj,xsd_num,xsd_szje,sp_ggxh,sp_color from tb_spinfo,tb_sell_detail"+
                "  where xsd_id=sp_id and xsd_dh='"+mingCheng+"'";}
	 	   else{
	 		   sql=" select posxfbd_spid,sp_name,sp_dw,sp_dj,posxfbd_num,posxfbd_zje,sp_ggxh,sp_color " +
	 		   		" from tb_spinfo,tb_posxfb_detail"+
                   "  where posxfbd_spId=sp_id and posxfbd_id='"+mingCheng+"'";
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
