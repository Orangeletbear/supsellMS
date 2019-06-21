package com.cn.dao.jinhuo;

import java.util.Vector;


/**
 * 
 * @author Administrator
 *
 */
public class Tb_spinfonameJDBC {

public static Vector find(String spID){
		
	String sql = "select tb.sp_id "+
    " from tb_spinfo tb "+
    " where tb.sp_id ='"+spID+"' " +
    " or tb.sp_name ='"+spID+"' ";

	return NomalJDBC.gongJu(sql);

	}
}
