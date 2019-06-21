package com.cn.dao.tongji.KeHuXiaoShouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class KeHuZhangWuJDBC {
	/*
	 * ������൥����Ϣ
	 * djID ���ݺ�
	 * isGetBZ �Ƿ�����ע
	 */
    public static Vector getZhangWuData(String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql[]=new String[2];
			if(mingCheng.equals("")){
	 	    	sql[0]=" select kh_name,sum(xsd_szje),sum(khthd_zje),(sum(xsd_szje)-sum(khthd_zje)),sum(xs_ysje)-sum(kh_th_ytje),"+
                       " sum(xs_ssje)-sum(kh_th_ytje),sum(xs_ysje)-sum(kh_th_ytje)-sum(xs_ssje)-sum(kh_th_ytje)"+
                       " from tb_sell_main,tb_sell_detail,tb_khinfo,tb_khth_main,tb_khth_detail"+
                       " where xsd_dh=xs_id and xs_khid=kh_id and kh_th_id=khthd_dh and kh_th_name=kh_id " +
                       " group by kh_name ";
	 	    	
			   sql[1]="select kh_name,sum(xsd_szje),'0',sum(xsd_szje),sum(xs_ysje),sum(xs_ssje),sum(xs_ysje-xs_ssje)"+  
                       "  from tb_sell_main,tb_sell_detail,tb_khinfo"+
                       "  where xsd_dh=xs_id and xs_khid=kh_id and kh_name not in( select kh_name from tb_sell_main,tb_sell_detail,tb_khinfo,tb_khth_main,tb_khth_detail"+
                       " where xsd_dh=xs_id and xs_khid=kh_id and kh_th_id=khthd_dh and kh_th_name=kh_id " +
                       " group by kh_name ) "+
                       " group by kh_name";
				
	 	    	}
			else{
				sql[0]=" select kh_name,sum(xsd_szje),sum(khthd_zje),(sum(xsd_szje)-sum(khthd_zje)),sum(xs_ysje)-sum(kh_th_ytje),"+
                " sum(xs_ssje)-sum(kh_th_ytje),sum(xs_ysje)-sum(kh_th_ytje)-sum(xs_ssje)-sum(kh_th_ytje)"+
                " from tb_sell_main,tb_sell_detail,tb_khinfo,tb_khth_main,tb_khth_detail"+
                " where xsd_dh=xs_id and xs_khid=kh_id and kh_th_id=khthd_dh and kh_th_name=kh_id and kh_name='"+mingCheng+"' " +
                " group by kh_name ";
	    
				
			    sql[1]="select kh_name,sum(xsd_szje),'0',sum(xsd_szje),sum(xs_ysje),sum(xs_ssje),sum(xs_ysje-xs_ssje)"+  
                   "  from tb_sell_main,tb_sell_detail,tb_khinfo"+
                   "  where xsd_dh=xs_id and xs_khid=kh_id and kh_name='"+mingCheng+"' and kh_name not in(select kh_name from tb_sell_main,tb_sell_detail,tb_khinfo,tb_khth_main,tb_khth_detail"+
                " where xsd_dh=xs_id and xs_khid=kh_id and kh_th_id=khthd_dh and kh_th_name=kh_id and kh_name='"+mingCheng+"' " +
                " group by kh_name) "+
                   "  group by kh_name";
			  
		}
			
			
			for(int i=0;i<sql.length;i++){
			  st = conn.createStatement();
				rs = st.executeQuery(sql[i]);
				//��ȡ���е�����
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
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
    }
    

}
