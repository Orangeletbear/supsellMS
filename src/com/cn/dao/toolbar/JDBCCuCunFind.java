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
 * 工具栏上库存查询窗口中的DAO
 */
public class JDBCCuCunFind {
	/*
	 * 获得所有定义好的仓库名
	 * 返回所有仓库名
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
			JOptionPane.showMessageDialog(null,"数据库发生错误，初始化失败!");
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
	 * 查出给定仓库，名称的商品信息
	 * ckName 仓库名
	 * spName 商品名
	 * spLb 商品类别
	 * isGetO 是否查出商品为零的数据
	 * 返回二维数据对象
	 */
    public static Vector getData(String ckName,
    				String spName ,String spLb ,boolean isGetO){
    	//二维数据
    	Vector data = new Vector();
    	
    	String sql ="select sp.sp_id,sp.sp_name,sp.sp_ggxh,sp.sp_dw,"+
        "sp.sp_zdkc,sp.sp_sj,sp.sp_sccs,sp.sp_color,sp.sp_bz"+ 
        " from tb_spinfo sp";
    	
    	//是否查 出库存为零的商品
    	if(!isGetO){
    		if("所有仓库".equals(ckName)){
    			if("所有类别".equals(spLb)){
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
    			if("所有类别".equals(spLb)){
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
    		if("所有仓库".equals(ckName)){
    			if("所有类别".equals(spLb)){
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
    			if("所有类别".equals(spLb)){
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
    /*
     *获取商品所有类别 
     *返回字符串数组，存所有类别
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
			JOptionPane.showMessageDialog(null,"数据库发生错误，数据初始化失败!");
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
