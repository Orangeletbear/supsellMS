package com.cn.dao.pos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * POS�ͻ��˵����ݿ⽻��
 * @author finey
 *
 */
public class POSJDBC {
   /**
    * ȡ��	  
    * @return
    */
   public static int getNumber(String date){
	   	int num = 1;
		String sql = "select * from tb_posxfb_main po " +
						"where po.posxfb_id like '"+date+"'";
 	 		
		Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		try {
			    st = conn.createStatement();
				rs = st.executeQuery(sql);
				//��ȡ���е�����
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
                     num++;
			    }
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			return num;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
	  return num;
   }
   
   /**
    * ȡ����Ʒ������Ϣ��ѡ�����
    * ckName �ֿ���
    * spID ��Ʒ������Ʒ��
    * @return
    */
   public static Vector getSPMassage(String ckName,String spID){
	   
	    Vector data = new Vector();
	   	
		String sql = "select sp.sp_id,sp.sp_name,sp.sp_tm,sp.sp_dw,"+
						"sp.sp_ggxh,sp.sp_color,sp.sp_sftj "+
						" from tb_spinfo sp ,tb_ckinfo ck"+
						" where (sp.sp_id like '%"+spID+"%' or sp.sp_name like '%"+spID+"%')" +
						"and ck.ck_id = sp.sp_syck and ck.ck_name = '"+ckName+"'";
		
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
			return data;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
 	
 	 return data;
   }
   /**
    * ȡ����Ʒ������Ϣ��ȷ����
    * ckName �ֿ���
    * spID ��Ʒ��
    * @return
    */
   public static Vector getCirterSPMassege(String ckName,int num ,String spID){
	   
	    Vector data = new Vector();
	   	data.add(num);
		String sql = "select sp.sp_id,sp.sp_name,sp.sp_dw,"+
						" sp.sp_dj,sp.sp_zk,(sp.sp_zk*sp.sp_dj),1,(sp.sp_zk*sp.sp_dj)"+
						" from tb_spinfo sp ,tb_ckinfo ck"+
						" where sp.sp_id = '"+spID+"'"+
						" and ck.ck_id = sp.sp_syck and ck.ck_name = '"+ckName+"'";
		
		Connection conn = JDBCTool.getConnection();
		
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			    st = conn.createStatement();
				rs = st.executeQuery(sql);
				//��ȡ���е�����
				int columnCount = rs.getMetaData().getColumnCount();
				rs.next();
					
				for(int column = 1;column<=columnCount;column++){
					data.add(rs.getObject(column));
					}	
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			return data;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
 	
 	 return data;

   }
   

   	/*
   	 * �������Ա����
   	 * �������вֿ���
   	 */
       public static String[] getAllWorker(){
       	Vector tmp = new Vector();
       	String [] data= null;
       	String sql = "select yh.yg_Name from tb_yginfo yh";
       	
       	Connection conn = JDBCTool.getConnection();
   	    Statement st = null;
   		ResultSet  rs = null;
   		try {
   			st = conn.createStatement();
   			rs= st.executeQuery(sql);
   			while(rs.next()){
                    tmp.add(rs.getString(1));
   			}
   		} catch (SQLException e) {
   			e.printStackTrace();
   			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
   			return new String []{};
   		} finally{
   			JDBCTool.freeResorse(rs, st, conn);
   		}
       	data = new String[tmp.size()];
   		for(int i = 0;i<tmp.size();i++){
   			data[i] = tmp.get(i).toString();
   		}
       	return data;
       } 
  
}
