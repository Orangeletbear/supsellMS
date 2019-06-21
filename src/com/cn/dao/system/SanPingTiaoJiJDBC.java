package com.cn.dao.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;

/**
 * ��Ʒ����JDBC����
 * @author finey
 *
 */

public class SanPingTiaoJiJDBC {

	/**
	 * ��Ʒ������Ϣ��ѯ
	 * @param lbName ��Ʒ���
	 * @param spName  ��Ʒ����
	 * @return
	 */
     public static Vector getSPBaseMassege(String lbName,String spName){
    	 
    	 Vector data = new Vector();
      	
      	 String sql = "select sp.sp_id,sp.sp_Name,sp.sp_sj,sp.sp_jj,sp.sp_sj,"+
      		 			" sp.sp_ggxh,sp.sp_color,sp.sp_zdkc,"+
      		 			" sp.sp_sftj,sp.sp_hyj,sp.sp_tj,"+
      		 			"(sp.sp_tjdateto-sp.sp_tjdatefrom) �ؼ�����,sp.sp_tjdatefrom,"+
      		 			" sp.sp_tjdateto,sp.sp_isuse,sp.sp_dzl,sp.sp_sccs,sp.sp_bz"+
      		 			" from tb_spinfo sp,tb_sblb lb"+
      		 			" where sp.sp_lb = lb.sblb_id"+
      	 			" and (sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')";
      	 		
         if("�������".equals(lbName)==false){
         	sql = sql+" and lb.sblb_name = '"+lbName+"'";
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
  			return data;
  		} finally{
  			JDBCTool.freeResorse(rs, st, conn);
  		}
      	
      	return data;
     }
     
     /**
 	 * ���������Ʒ�ĸ��ֿͻ�������Ϣ
 	 * @param spID  ��Ʒ��
 	 * @return
 	 */
      public static Vector getSPXiaoMassege(String spID){
     	 
     	 Vector data = new Vector();
       	
       	 String sql = "select hyj.hyjb_name,sp.sp_name,sp.sp_sj,sp.sp_zk,"+
       	 					"hyj.hyjb_jbzk,'��',(sp.sp_zk*hyj.hyjb_jbzk) �����ۿ�,"+
       	 					"sp.sp_sftj,'0',(sp.sp_sj*(sp.sp_zk*hyj.hyjb_jbzk)) ���յ���"+
       	 				" from tb_hyjb hyj,tb_spinfo sp"+
       	 				" where sp.sp_id = '"+spID+"'";
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
       * ����һ����Ʒ ��ţ����ظ���Ʒ������Ϣ
       * spID ��Ʒ���
       * @return 
       */
      public static Vector getAData(String spID){

      	     Vector data = new Vector();
        	
        	 String sql = "select * from tb_spinfo sp where sp.sp_id = '"+spID+"'";
        	 
        	 Connection conn = JDBCTool.getConnection();
    	     Statement st = null;
    		 ResultSet  rs = null;
    		
    		 try {
    			    st = conn.createStatement();
    				rs = st.executeQuery(sql);
    				//��ȡ���е�����
    				int columnCount = rs.getMetaData().getColumnCount();
    				while(rs.next()){
    					for(int column = 1;column<=columnCount;column++){
    						data.add(rs.getObject(column));
    					}
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
       * ���ĺõļ۸�д�����ݿ�
       * @param data  �ı�����ݰ�
       * @return �Ƿ�д��
       */
      public static boolean changeSPPrice(Vector<String> data){
    	  
     	 String sql = "update tb_spinfo sp "+
     		 			" set sp.sp_jj = ? ,sp.sp_sj = ?,sp.sp_zk = ?, "+
     		 			" sp.sp_sftj = ?,sp.sp_tj = ?,sp.sp_hyj = ?, "+
     		" sp.sp_isuse = ?,sp.sp_tjdatefrom = to_date(?,'YYYY-MM-DD') , "+
     		" sp.sp_tjdateto = to_date(?,'YYYY-MM-DD') "+
     		" where sp.sp_id = ?";
     	 
     	 Connection conn = JDBCTool.getConnection();
     	 PreparedStatement ps = null;
 		
 		try {
 			ps = conn.prepareStatement(sql);
 			ps.setFloat(1, new Float(data.get(2)).floatValue());
 			
 			ps.setFloat(2, new Float(data.get(3)).floatValue());
 			
 			ps.setFloat(3, new Float(data.get(4)).floatValue());
 			
 			
 			ps.setString(4, data.get(5));
 			
 			ps.setFloat(5, new Float(data.get(6)).floatValue());
 			
 			ps.setFloat(6, new Float(data.get(7)).floatValue());
 			
 			ps.setString(7, data.get(8));
 			
 			ps.setString(8, data.get(10));
 			
 			ps.setString(9, data.get(11));
 			
 			ps.setString(10, data.get(0));
 		    
 			ps.executeUpdate();
 			
 			
 		} catch (SQLException e) {
 			e.printStackTrace();
 			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
 			return false;
 		} finally{
 			JDBCTool.freeResouse(ps, conn);
 		}

    	  
    	  return true;
      }
     
}
