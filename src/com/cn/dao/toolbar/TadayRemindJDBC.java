package com.cn.dao.toolbar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/*
 * �������ϵĽ������Ѵ����е����ݿ��Ʋ�
 */
public class TadayRemindJDBC {
  /*
   * ��ȡ�汨������
   * spName ���ڲ鿴����Ʒ�Ƿ񱨾�
   * ����Ľ��Ϊ���С��һ��������������Ϣ
   */
	public static Vector getCuCunBJData(String spName){
		//��ά����
    	Vector data = new Vector();
    	
    	String sql ="select  tb.sp_id,tb.sp_name,tb.sp_ggxh,tb.sp_dw,"+
    						"tb.sp_color,tb.sp_zdkc"+
    					" from tb_spinfo tb "+
    					" where tb.sp_zdkc <= 0"+
    					" and (tb.sp_id like '%"+spName+"%' or tb.sp_name like '%"+spName+"%')";
    	
    	//�Ƿ�� �����Ϊ�����Ʒ
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
	 * Ӧ�տ��������ݲ�ѯ
	 * @param khName �ͻ���
	 * @return  ����Ҫ�������
	 * conD ��ѯ����
	 * dayNum ����
	 */
	public static Vector getYingShouKTXData(String khName,
			                  String conD,String dayNum){  
		//��ά����
    	Vector data = new Vector();
    	
    	String sql =" select * from ("+
    			"select kh.kh_name na,tb.xs_id id,tb.xs_xsdate,tb.xs_ysje,"+
    			"tb.xs_ssje,(tb.xs_ysje-tb.xs_ssje) mon,"+
    			"(tb.xs_xsdate+100) ֹ��,ceil(sysdate-tb.xs_xsdate) daNum,"+
    			" tb.xs_jbr from  tb_sell_main tb ,tb_khinfo kh "+
    			" where kh.kh_id = tb.xs_khid ) intb"+
    			" where(intb.id like '%"+khName+"%' or intb.na like '%"+khName+"%')";
    	
    	if(">=".equals(conD)){
    		 sql = sql+" and intb.daNum >= "+dayNum+" and intb.mon > 0";
    	}
    	if("<=".equals(conD)){
    		sql = sql+ " and intb.daNum <= "+dayNum+" and intb.mon > 0";
    	}
        if("=".equals(conD)){
        	sql = sql+" and intb.daNum = "+dayNum+" and intb.mon > 0";
    	}
    	
    	
    	//�Ƿ�� �����Ϊ�����Ʒ
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
	/*
	 * ��Ʒ��������
	 * spName ��Ʒ������
	 * conD ��ѯ����
	 * dayNum ����
	 */
    public static Vector getPassData(String spName,String conD,String dayNum){
    	//��ά����
    	Vector data = new Vector();
    	String sql =null;
    	if(">=".equals(conD)){
    		sql ="select * from "+
			"(select sp.sp_id id ,sp.sp_name name,"+
					"sp.sp_ggxh,sp.sp_color,sp.sp_zdkc,"+
					"sp.sp_tjdatefrom,sp.sp_tjdateto,ceil(sp.sp_tjdateto-sysdate) daynum"+
				" from tb_spinfo sp) inta"+
			" where inta.daynum >= "+dayNum+
			" and (inta.id like '%"+spName+"%' or inta.name like '%"+spName+"%')";

    	}
    	if("<=".equals(conD)){
    		sql ="select * from "+
			"(select sp.sp_id id ,sp.sp_name name,"+
					"sp.sp_ggxh,sp.sp_color,sp.sp_zdkc,"+
					"sp.sp_tjdatefrom,sp.sp_tjdateto,ceil(sp.sp_tjdateto-sysdate) daynum"+
				" from tb_spinfo sp) inta"+
			" where inta.daynum < "+dayNum+
			" and (inta.id like '%"+spName+"%' or inta.name like '%"+spName+"%')";

    	}
        if("=".equals(conD)){
        	sql ="select * from "+
			"(select sp.sp_id id ,sp.sp_name name,"+
					"sp.sp_ggxh,sp.sp_color,sp.sp_zdkc,"+
					"sp.sp_tjdatefrom,sp.sp_tjdateto,ceil(sp.sp_tjdateto-sysdate) daynum"+
				" from tb_spinfo sp) inta"+
			" where inta.daynum = "+dayNum+
			" and (inta.id like '%"+spName+"%' or inta.name like '%"+spName+"%')";

    	}
    	
    	//�Ƿ�� �����Ϊ�����Ʒ
    	Connection conn = JDBCTool.getConnection();
    	PreparedStatement ps = null;
		ResultSet  rs = null;
		
		try {
			   ps = conn.prepareStatement(sql);
			   //ps.setInt(1, 10);
			   //System.out.println(new Integer(dayNum).intValue());
			   rs = ps.executeQuery(sql);
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
			JDBCTool.freeResorse(rs, ps, conn);
		}
    	return data;
    }
	
}
