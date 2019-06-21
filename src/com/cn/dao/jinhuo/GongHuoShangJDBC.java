package com.cn.dao.jinhuo;

import java.util.Vector;

/**
 * 将供货商table数据获取
 * @author Administrator
 *
 */
public class GongHuoShangJDBC {

	/**
	 * @return返回所有供货商数据
	 */
	public static Vector getGongHuoShang(){
		
		String sql = "select * from tb_ghsinfo "; 
	
		return NomalJDBC.gongJu(sql);
		
	}
	/**
	 * 返回符合要求的供货商数据
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
	 * 返回符合要求  名字   的供货商数据
	 */
	public static Vector getName(String chazhao){
		String sql = "select ghs.* "+
			" from tb_ghsinfo ghs "+
			" where ghs.ghs_name = '"+chazhao+"' ";
		
		return NomalJDBC.gongJu(sql);
	}
	 
}
