package com.cn.dao.tongji.KeHuXiaoShouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
public class KeHuFuKuanJDBC {
	/*
	 * ������൥����Ϣ
	 * djID ���ݺ�
	 * isGetBZ �Ƿ�����ע
	 */
    public static Vector getFuKuanData(String date1,String date2,String mingCheng) {
    	Vector data = new Vector();
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			String sql[] = new String [2];
	 	       // JTextField leiBie=cg.getShangPinText(),
	 	      //  mingCheng=cg.getShangPinNameText(); //��ȡ�������齨
			if(mingCheng.equals("")){
				sql[0]="   select xs_id,xs_xsdate,'��Ʒ����',xs_ssje,kh_name ,xs_jbr,xs_czy,xs_bz"+
	            " from tb_sell_main,tb_khinfo"+
	            " where  xs_khid=kh_id and to_date('"+date1+"','YYYY-MM-DD')-tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						"tb_sell_main.xs_xsdate>0 ";
	 	         sql[1]="select kh_th_id,kh_th_date,'��Ʒ�˻�',kh_th_stje,kh_name,kh_th_jbr,kh_th_czy,kh_th_bz"+
	            " from tb_khth_main,tb_khinfo where kh_th_name=kh_id and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
						"kh_th_date>0 ";
	 	      
	 	    	}
		else{
			sql[0]="   select xs_id,xs_xsdate,'��Ʒ����',xs_ssje,kh_name ,xs_jbr,xs_czy,xs_bz"+
            " from tb_sell_main,tb_khinfo"+
            " where  xs_khid=kh_id and to_date('"+date1+"','YYYY-MM-DD')-tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
					"tb_sell_main.xs_xsdate>0 and kh_name='"+mingCheng+"'";
 	         sql[1]="select kh_th_id,kh_th_date,'��Ʒ�˻�',kh_th_stje,kh_name,kh_th_jbr,kh_th_czy,kh_th_bz"+
            " from tb_khth_main,tb_khinfo where kh_th_name=kh_id and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
					"kh_th_date>0 and kh_name='"+mingCheng+"'";
 	      
			}
			for(int i=0;i<sql.length ;i++){
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
