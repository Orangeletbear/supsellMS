package com.cn.dao.jinhuo.jinhuoguanli;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.JDBCTool;

public class JDBCLaoShangPinTianJia {
	
	public static Vector<Vector<Object>> getTB_SPINFO(){
		Vector<Vector<Object>> data= new Vector<Vector<Object>>();
		
		String sql = "select tb.sp_id,tb.sp_name,tb.sp_dw,tb.sp_ggxh,tb.sp_jj,tb.sp_zdkc,tb.sp_sj from tb_spinfo tb";
		
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
