package com.cn.dao.jinhuo.jinhuoguanli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

/**
 * ˫����������У�������Ʒ��Ϣdialog����JDBC������ȡ���ݳ�ʼ��dialog����
 * @author Administrator
 *
 */
public class JDBCShangPinXinXi {
	
	
	
	
	/**
	 * ��ȡĳһ�����ݵ�spID������JLabel������
	 */
	public static Vector getData(String spID){
		Vector<Object> data = new Vector<Object>();
		
		//��ѯ ��spID��Ҫ��ȡ�������У���Ʒ��ţ���Ʒ���ƣ�����ͺţ�������λ���������̣���ɫ����ǰ��棬��ע
		//                           �ο�����
		
		String sql = "select tb.sp_id,tb.sp_name,tb.sp_ggxh,tb.sp_dw,tb.sp_sccs,tb.sp_color,tb.sp_zdkc,tb.sp_bz,"+
	       " tb.sp_jj"+
	       " from tb_spinfo tb"+
	       " where tb.sp_id ='"+spID+"'";
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//��������
		
		try {
			st = conn.createStatement();//����statement����
			rs= st.executeQuery(sql);//����executeUpdate/Query��������SQL���
			
			int lieshu = rs.getMetaData().getColumnCount();//ͳ������
			
			while(rs.next()){
				for(int i = 1; i <= lieshu ; i ++){
					data.add( rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return data;
	}
	

	
	/**
	 * ��ȡĳһ�����ݵ�spID��������Ʒ��Ϣdialog��table������
	 */
	public static Vector getRowData(String spID){
		Vector data = new Vector();
		
		//		�������ڣ����ݺţ���λ���ɹ����ۣ��������ܽ��
		
		String sql = "select tm.cg_date,tm.cg_id,tb.sp_dw,tb.sp_jj,td.cgd_num,td.cgd_spzje "+
		  " from tb_cg_detail td,tb_cg_main tm,tb_spinfo tb "+
		  " where td.cgd_spid ='"+spID+"'"+
		  " and td.cgd_spdh = tm.cg_id"+
		  " and tb.sp_id = td.cgd_spid";
		
		
		Statement st = null;
		ResultSet  rs = null;
		Connection conn = JDBCTool.getConnection();//��������
		
		try {
			st = conn.createStatement();//����statement����
			rs= st.executeQuery(sql);//����executeUpdate/Query��������SQL���
			
			int lieshu = rs.getMetaData().getColumnCount();//ͳ������
			
			while(rs.next()){
				Vector<Object> tmp = new Vector<Object>();//�洢ÿ������ 
				
				for(int i = 1; i <= lieshu ; i ++){
					tmp.add( rs.getObject(i));
				}
				data.add(tmp);/////ÿ��������Ϊdata��һ��Ԫ��
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
			return null;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
		
		return data;
	}

}
