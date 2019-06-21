package com.cn.dao.toolbar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;
/*
 * �������Ͽ���ѯ�����е�DAO
 */
public class JDBCCuCunFind {
	/*
	 * ������ж���õĲֿ���
	 * �������вֿ���
	 */
    public static String[] getCanKuData(){
    	Vector tmp = new Vector();
    	String [] data= null;
    	String sql = "select tb.ck_name from tb_ckinfo tb";
    	
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
    
    /*
	 * ��������ֿ⣬���Ƶ���Ʒ��Ϣ
	 * ckName �ֿ���
	 * spName ��Ʒ��
	 * spLb ��Ʒ���
	 * isGetO �Ƿ�����ƷΪ�������
	 * ���ض�ά���ݶ���
	 */
    public static Vector getData(String ckName,
    				String spName ,String spLb ,boolean isGetO){
    	//��ά����
    	Vector data = new Vector();
    	
    	String sql ="select sp.sp_id,sp.sp_name,sp.sp_ggxh,sp.sp_dw,"+
        "sp.sp_zdkc,sp.sp_sj,sp.sp_sccs,sp.sp_color,sp.sp_bz"+ 
        " from tb_spinfo sp";
    	
    	//�Ƿ�� �����Ϊ�����Ʒ
    	if(!isGetO){
    		if("���вֿ�".equals(ckName)){
    			if("�������".equals(spLb)){
    				sql =sql+      
                    " where (sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"; 
    			}else{
    				System.out.println("have  O");
    				sql =sql+      
                   " where sp.sp_lb = (select intb.sblb_id"+
                    					" from tb_sblb intb"+ 
                    					" where intb.sblb_name = '"+spLb+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"; 
    			}
    		}else{
    			if("�������".equals(spLb)){
    				System.out.println("all hgggrrrrrrt but not O");
    				sql =sql+      
                    " where sp.sp_syck = (select tb.ck_Id"+
                    						" from tb_ckinfo tb"+
                    						" where tb.ck_Name  = '"+ckName+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"; 
    			}else{
    				sql =sql+      
                    " where sp.sp_syck = (select tb.ck_Id"+
                    						" from tb_ckinfo tb"+
                    						" where tb.ck_Name  = '"+ckName+"')"+
                   " and sp.sp_lb = (select intb.sblb_id"+
                    					" from tb_sblb intb"+ 
                    					" where intb.sblb_name = '"+spLb+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"; 
    			}
    			
    		}
    		
    	}else{
    		if("���вֿ�".equals(ckName)){
    			if("�������".equals(spLb)){
    				sql =sql+      
                    " where (sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"+
                    " and sp.sp_zdkc <> 0"; 
    			}else{
    				sql =sql+      
                   " where sp.sp_lb = (select intb.sblb_id"+
                    					" from tb_sblb intb"+ 
                    					" where intb.sblb_name = '"+spLb+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"+
                    " and sp.sp_zdkc <> 0"; 
    			}
    		}else{
    			if("�������".equals(spLb)){
    				sql =sql+      
                    " where sp.sp_syck = (select tb.ck_Id"+
                    						" from tb_ckinfo tb"+
                    						" where tb.ck_Name  = '"+ckName+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"+
                    " and sp.sp_zdkc <> 0"; 
    			}else{
    				sql =sql+      
                    " where sp.sp_syck = (select tb.ck_Id"+
                    						" from tb_ckinfo tb"+
                    						" where tb.ck_Name  = '"+ckName+"')"+
                   " and sp.sp_lb = (select intb.sblb_id"+
                    					" from tb_sblb intb"+ 
                    					" where intb.sblb_name = '"+spLb+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"+
                    " and sp.sp_zdkc <> 0"; 
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
    /*
     *��ȡ��Ʒ������� 
     *�����ַ������飬���������
     */
	public static String []  getSpLbData() {
		Vector tmp = new Vector();
    	String [] data= null;
    	String sql = "select tb.sblb_Name from tb_sblb tb";
    	
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
			JOptionPane.showMessageDialog(null,"���ݿⷢ���������ݳ�ʼ��ʧ��!");
			return new String[]{};
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
