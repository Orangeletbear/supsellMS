package com.cn.dao.jinhuo;

import java.util.Vector;

/**
 * ��������table���ݻ�ȡ
 * @author Administrator
 *
 */
public class GongHuoShangJDBC {

	/**
	 * @return�������й���������
	 */
	public static Vector getGongHuoShang(){
		
		String sql = "select * from tb_ghsinfo "; 
	
		return NomalJDBC.gongJu(sql);
		
	}
	/**
	 * ���ط���Ҫ��Ĺ���������
	 */
	public static Vector getSome(String chazhao){
		String sql = "select ghs.* "+
			" from tb_ghsinfo ghs "+
			" where ghs.ghs_id like '%"+chazhao+"%' "+
			" or ghs.ghs_name like '%"+chazhao+"%' "+
			" or ghs.ghs_lxr like '%"+chazhao+"%' ";
		
		return NomalJDBC.gongJu(sql);
	}
	
	/**
	 * ���ط���Ҫ��  ����   �Ĺ���������
	 */
	public static Vector getName(String chazhao){
		String sql = "select ghs.* "+
			" from tb_ghsinfo ghs "+
			" where ghs.ghs_name = '"+chazhao+"' ";
		
		return NomalJDBC.gongJu(sql);
	}
	 
}
