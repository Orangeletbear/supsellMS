package com.cn.dao.tongji.YeWuYuanCaiGouTongJi;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class YeWuYuanCaiGouJDBC {
	 public static Vector getCaiGouData(String date1,String date2,String mingCheng) {
	    	Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			
			try {
				String[] sql=new String[2];
				if("����ҵ��Ա".equals(mingCheng)){
				
					sql[0]="select cg_date,cg_jbr,'�ɹ�����',cg_Id,cg_yfje,cg_sfje,tb_ckinfo.ck_name,tb_ghsinfo.ghs_name,cg_czy,null " +
						      "from tb_cg_main,tb_ghsinfo,tb_ckinfo where cg_ghs=tb_ghsinfo.ghs_id and cg_lkid=tb_ckinfo.ck_id " +
						      "and to_date('"+date1+"','YYYY-MM-DD')-tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 ";
					sql[1]="select th_date,th_jbr,'�ɹ��˻�',th_Id,th_yfje,th_sfje,tb_ckinfo.ck_name,tb_ghsinfo.ghs_name,th_czy,null " +
                              "from tb_th_main,tb_ghsinfo,tb_ckinfo where th_ghs=tb_ghsinfo.ghs_id and th_ckId=tb_ckinfo.ck_id " +
                              "and to_date('"+date1+"','YYYY-MM-DD')-tb_th_main.th_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_th_main.th_date>0 ";
               }
				else{

					sql[0]="select cg_date,cg_jbr,'�ɹ�����',cg_Id,cg_yfje,cg_sfje,tb_ckinfo.ck_name,tb_ghsinfo.ghs_name,cg_czy,null " +
						      "from tb_cg_main,tb_ghsinfo,tb_ckinfo where cg_ghs=tb_ghsinfo.ghs_id and cg_lkid=tb_ckinfo.ck_id " +
						      "and to_date('"+date1+"','YYYY-MM-DD')-tb_cg_main.cg_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_cg_main.cg_date>0 and cg_jbr='"+mingCheng+"'";
                  
					sql[1]="select th_date,th_jbr,'�ɹ��˻�',th_Id,th_yfje,th_sfje,tb_ckinfo.ck_name,tb_ghsinfo.ghs_name,th_czy,null " +
                              "from tb_th_main,tb_ghsinfo,tb_ckinfo where th_ghs=tb_ghsinfo.ghs_id and th_ckId=tb_ckinfo.ck_id " +
                              "and to_date('"+date1+"','YYYY-MM-DD')-tb_th_main.th_date<0 and to_date('"+date2+"','YYYY-MM-DD')-" +
								"tb_th_main.th_date>0 and th_jbr='"+mingCheng+"'";
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
		 	    	//}
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
				
			} finally{
				JDBCTool.freeResorse(rs, st, conn);
			}
			
	    	return data;
	    }
}
