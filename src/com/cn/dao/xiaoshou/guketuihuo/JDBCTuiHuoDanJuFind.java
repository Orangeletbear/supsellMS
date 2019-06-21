package com.cn.dao.xiaoshou.guketuihuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBCTuiHuoDanJuFind {
	/**
	 * ��������ʱ���ڵ������˻������ܱ�
	 * ֧�ֵ��ŵ�ģ����ѯ
	 * @param djID ��������
	 * @param date1 
	 * @param date2
	 * @return ����Ҫ��ĵ�����Ϣ
	 */
	
	  public static Vector getData(String djID,String date1,String date2){
	    	
	    	Vector data = new Vector();
	    	String sql = null;
	    	
	    	if("".equals(djID)){
	    		sql ="select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
	    				"'�����˻�',kh_th_jbr,kh_th_czy,kh_th_bz" +
	    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
	    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
	    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
	    				" and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0";
	    	}else{
	    		sql = "select deg.kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje," +
	    				"kh_th_stje,kh_th_ytje-kh_th_stje,'�����˻�',kh_th_jbr,kh_th_czy,kh_th_bz" +
	    				" from tb_khth_main,(select kh_Name,ck_Name,kh_th_Id" +
	    				        " from tb_khth_main,tb_khinfo,tb_ckinfo" +
	    				        " where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
	    				        "and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
	    				        "and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0) deg" +
	    			" where tb_khth_main.kh_th_Id = deg.kh_th_Id and (kh_Name = '"+djID+"'or deg.kh_th_Id like '%"+djID+"%')";
	    	}
	    	Connection conn = JDBCTool.getConnection();
	    	Statement st = null;
	    	ResultSet  rs = null;

	    	try {
	    		   st = conn.createStatement();
	    		   rs = st.executeQuery(sql);
	    			//��ȡ���е�����
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
	    		JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
	    		
	    	} finally{
	    		JDBCTool.freeResorse(rs, st, conn);
	    	}
	    	return data;
	  }   
	
	
	/**
	 * ���ͻ����ƣ��ֿ����ƣ�����Ա����
	 * ����ѯ��������֮����˻�������Ϣ
	 */
	  public static Vector getData(String khName,String chName,
			                String czyName,String date1,String date2){
	    	
	    	Vector data = new Vector();
	    	String sql = null;
	   
	    	 if(khName.equals("")){
		    		if("���вֿ�".equals(chName)){
		    			if("���в���Ա".equals(czyName)){
		    				sql ="select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
		    				"'��Ʒ����',kh_th_jbr,kh_th_czy,kh_th_bz" +
		    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
		    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
		    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
		    				" and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0";
		    			 }else{
		    				 sql ="select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
			    				"'��Ʒ����',kh_th_jbr,kh_th_czy,kh_th_bz" +
			    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
			    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
			    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
			    				" and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0" +
							    " and kh_th_czy = '"+czyName+"'" ;
		    			     } 
		    		 }else{
	 
		    			 if("���в���Ա".equals(czyName)){
		    				 sql ="select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
			    				"'��Ʒ����',kh_th_jbr,kh_th_czy,kh_th_bz" +
			    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
			    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
			    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
			    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"
			    				+"and ck_Name = '"+chName+"'";
			    			 }else{
			    				 sql ="select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
				    				"'��Ʒ����',kh_th_jbr,kh_th_czy,kh_th_bz" +
				    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
				    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
				    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
				    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"
				    				+"and ck_Name = '"+chName+"'"+
								    " and kh_th_czy = '"+czyName+"'" ;
			    			     } 
		    		 }
		    	}else{
		    		if("���вֿ�".equals(chName)){
		    			if("���в���Ա".equals(czyName)){
		    				sql = "select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
		    				"'��Ʒ����',kh_th_jbr,kh_th_czy,kh_th_bz" +
		    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
		    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
		    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
		    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"+
		    			   " and kh_Name = '"+khName+"'";
		    			 }else{
		    				 sql = "select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
			    				"'��Ʒ����',kh_th_jbr,kh_th_czy,kh_th_bz" +
			    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
			    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
			    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
			    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"+
			    			   " and kh_Name = '"+khName+"'"+
							    "and kh_th_czy = '"+czyName+"'" ;
		    			     } 
		    		 }else{
	 
		    			 if("���в���Ա".equals(czyName)){
		    				 sql = "select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
			    				"'��Ʒ����',kh_th_jbr,kh_th_czy,kh_th_bz" +
			    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
			    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
			    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
			    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"+
			    			   " and kh_Name = '"+khName+"'" +
							    "and ck_Name = '"+chName+"'" ;
			    			 }else{
			    				 sql = "select kh_th_Id,kh_th_date,kh_Name,ck_Name,kh_th_ytje,kh_th_stje,kh_th_ytje-kh_th_stje," +
				    				"'��Ʒ����',kh_th_jbr,kh_th_czy,kh_th_bz" +
				    				" from tb_khth_main,tb_khinfo,tb_ckinfo" +
				    				" where kh_th_Name = kh_Id and kh_th_chName = ck_Id " +
				    				"and to_date('"+date1+"','YYYY-MM-DD')-kh_th_date <= 0" +
				    				"and to_date('"+date2+"','YYYY-MM-DD')-kh_th_date >=0"+
				    			   " and kh_Name = '"+khName+"'" +
								    "and ck_Name = '"+chName+"'"+
								    "and kh_th_czy = '"+czyName+"'" ;
								    
			    			     } 
		    		 }
	    	}
	    		
	    	
	    	
	    
	    	Connection conn = JDBCTool.getConnection();
	    	Statement st = null;
	    	ResultSet  rs = null;

	    	try {
	    		   st = conn.createStatement();
	    		   rs = st.executeQuery(sql);
	    			//��ȡ���е�����
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
	    		JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
	    		
	    	} finally{
	    		JDBCTool.freeResorse(rs, st, conn);
	    	}
	    	return data;
	    	
	  }    
	  /**
	   * ��ѯ�����˻���������ϵ���Ϣ
	   * ���������˻��ܱ��ϱ�ѡ�������ϵĵ��ݺ�
	   * ��ѯ���õ����ϵ���Ʒ��Ϣ
	   * 
	   * @param id �����ܱ��ϵĵ��ݺ�
	   * @return �õ����ϵ���Ʒ��Ϣ
	   */
	 
	  public static Vector getDate(String id){
		  Vector data  = new Vector();
		  String sql = null;
		
		  sql = "select khthd_thxdId,sp_Name,sp_dw,sp_dj, khthd_num,khthd_zje," +
		  		"sp_ggxh,sp_color  " +
		  		" from tb_khth_detail,tb_spinfo,tb_khth_main" +
		  		" where khthd_thxdId = sp_Id and kh_th_Id = khthd_dh and kh_th_Id='"+id+"'";
		  Connection conn = JDBCTool.getConnection();
	      Statement st = null;
	      ResultSet  rs = null;

	    	try {
	    		   st = conn.createStatement();
	    		   rs = st.executeQuery(sql);
	    			//��ȡ���е�����
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
	    		JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
	    		
	    	} finally{
	    		JDBCTool.freeResorse(rs, st, conn);
	    	}
	    	return data;
	  } 
	 
	  /**
		 * ��ȡ����������һ��������˻����ݵĵ��ݺ�
		 * @param date
		 * @return
		 */
		public static ArrayList danJuId(String date){
			ArrayList data = new ArrayList();
			String sql = null;
			
			sql = "select kh_th_Id from tb_khth_main where kh_th_date = to_date('"+date+"','YYYY-MM-DD') ";
			
			Connection conn =JDBCTool.getConnection();
			Statement st = null;
			ResultSet rs = null;
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()){
					int column = rs.getMetaData().getColumnCount();
					for(int i = 1;i<=column;i++){
						data.add(rs.getObject(i));
					}
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			}finally {
				JDBCTool.freeResorse(rs, st, conn);
			}
			
			return data;
		}
		
		


}
