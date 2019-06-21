package com.cn.dao.tongji.KuCunTongJi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class KuCunJDBC {
	 public static Vector getKuCunData(String date1,String date2 ) {
	    	Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String sql=null;
				
				 sql="select distinct sp_tjdateFrom,ck_name,(cgd_num),(xsd_num),(thd_num),(khthd_num),(bsd_num),(posxfbd_num),(posxth_num),"+
                       " (cgd_spzje),(xsd_szje),(thd_spzje),(khthd_zje),(bsd_zje),(posxfbd_zje),(posxth_zje),"+
                       " (cgd_num),(cgd_spzje),(xsd_num),(posxfbd_num),(xsd_szje),(posxfbd_zje),"+
                       " (xsd_szje),(posxfbd_zje),(cgd_spzje)"+
                       "  from tb_spinfo "+
                      " full outer join tb_sell_detail on xsd_id=sp_id"+
                      " full outer join tb_ckinfo on sp_syck=ck_id"+
                      " full outer join tb_cg_detail on cgd_spid=sp_id"+
                      " full outer join tb_th_detail on thd_spid=sp_id"+
                      " full outer join tb_khth_detail on khthd_thxdid=sp_id"+
                      " full outer join tb_bs_detail on  bsd_xspId=sp_id"+
                      " full outer join tb_posxfb_detail on posxfbd_spId=sp_id"+
                      " full outer join tb_posxth_detail on  posxth_spId=sp_id" +
                      " where to_date('"+date1+"','YYYY-MM-DD')-sp_tjdateFrom<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"sp_tjdateFrom>0";
			
				    st = conn.createStatement();
					rs = st.executeQuery(sql);
					//获取表中的列数
					int columnCount = rs.getMetaData().getColumnCount();
					while(rs.next()){
						Vector tmp = new Vector();
						Vector<Integer> ve=new Vector<Integer>();
						tmp.add(rs.getString(1));
						tmp.add(rs.getString(2));
						for(int i=3;i<=columnCount;i++){
							if(rs.getString(i)!=null){
								ve.add(rs.getInt(i));
							}
							else{
								ve.add(0);
							}
						}
							tmp.add(ve.get(0)-ve.get(1)+ve.get(2)+ve.get(3)-ve.get(4)-ve.get(5)+ve.get(6));
							tmp.add(ve.get(7)-ve.get(8)+ve.get(9)+ve.get(10)-ve.get(11)-ve.get(12)+ve.get(13));
							tmp.add(ve.get(14));
							tmp.add(ve.get(15));
							tmp.add(ve.get(16)+ve.get(17));
							tmp.add(ve.get(18)+ve.get(19));
							tmp.add(ve.get(20)+ve.get(21)-ve.get(22));
						
				         data.add(tmp);
				}
		 	    //	}	
		 	    
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
				
			} finally{
				JDBCTool.freeResorse(rs, st, conn);
			}
			
	    	return data;
	    }
}
