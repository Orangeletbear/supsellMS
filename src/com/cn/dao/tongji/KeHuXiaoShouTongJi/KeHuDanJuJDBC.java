package com.cn.dao.tongji.KeHuXiaoShouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class KeHuDanJuJDBC {
	/*
	 * 查出各类单据信息
	 * djID 单据号
	 * isGetBZ 是否查出备注
	 */
    public static Vector getDanJuData(String date1,String date2,String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		String sql[] = new String[2];
		try {
			
	 	       // JTextField leiBie=cg.getShangPinText(),
	 	      //  mingCheng=cg.getShangPinNameText(); //获取主界面组建
			if(mingCheng.equals("")){
				sql[0]=" select kh_name,xs_xsdate,xsd_dh,'商品销售付款',xs_ysje,xs_ssje," +
    			"(xs_ssje-xs_ysje),xs_jbr,xs_czy,xs_bz from tb_sell_main," +
    			" tb_sell_detail,tb_khinfo where xs_id=xsd_dh "+
                " and  kh_id=xs_khid and to_date('"+date1+"','YYYY-MM-DD')-"+
		        "tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
		        "tb_sell_main.xs_xsdate>0 ";
			sql[1]="select kh_name,kh_th_date,khthd_dh,'商品退货付款',kh_th_ytje,kh_th_stje,"+
    			" (kh_th_stje-kh_th_ytje),kh_th_jbr,kh_th_czy,kh_th_bz from tb_khth_main,"+
    			"  tb_khth_detail,tb_khinfo where kh_th_id=khthd_dh "+
                " and  kh_id=kh_th_name and to_date('"+date1+"','YYYY-MM-DD')-"+
		        "kh_th_date<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
		        "kh_th_date>0   ";
	 	    	}
			else{
				sql[0]=" select kh_name,xs_xsdate,xsd_dh,'商品销售付款',xs_ysje,xs_ssje," +
	    			"(xs_ssje-xs_ysje),xs_jbr,xs_czy,xs_bz from tb_sell_main," +
	    			" tb_sell_detail,tb_khinfo where xs_id=xsd_dh "+
                    " and  kh_id=xs_khid and to_date('"+date1+"','YYYY-MM-DD')-"+
			        "tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
			        "tb_sell_main.xs_xsdate>0 and kh_name like '%"+mingCheng+"%'";
				sql[1]="select kh_name,kh_th_date,khthd_dh,'商品退货付款',kh_th_ytje,kh_th_stje,"+
	    			" (kh_th_stje-kh_th_ytje),kh_th_jbr,kh_th_czy,kh_th_bz from tb_khth_main,"+
	    			"  tb_khth_detail,tb_khinfo where kh_th_id=khthd_dh "+
                    " and  kh_id=kh_th_name and to_date('"+date1+"','YYYY-MM-DD')-"+
			        "kh_th_date<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
			        "kh_th_date>0 and kh_name like '%"+mingCheng+"%'   ";
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
