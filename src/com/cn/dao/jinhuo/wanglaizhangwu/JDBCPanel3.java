package com.cn.dao.jinhuo.wanglaizhangwu;

import java.util.Vector;

import com.cn.dao.jinhuo.NomalJDBC;
import com.cn.dao.jinhuo.Tb_gongHuoShangJDBC;
/**
 * 	销售祥表与销售主表，与商品属性表相连。。查询销售情况，要获取的数据有：
 *	商品编号，商品名称，单位，销售数量，销售总金额，利润，毛利率，规格型号，颜色，生产厂商，备注
 */
public class JDBCPanel3 {

	public static Vector getData(String qishiDate,String jieshuDate,String gongHuoShang){
		Vector data = new Vector();
		
		if(gongHuoShang.equals("")){
	
			String sql = "select sell.xsd_id,shang.sp_name,shang.sp_dw,sell.xsd_num,sell.xsd_szje,"+
				" (xsd_szje - xsd_num*shang.sp_jj), "+
				" substr((xsd_szje - xsd_num*shang.sp_jj)/sell.xsd_szje,0,4)*100,"+
				" shang.sp_ggxh,shang.sp_color,shang.sp_sccs,shang.sp_bz "+
				" from tb_sell_detail sell,tb_spinfo shang,tb_sell_main sellmain "+
				" where sell.xsd_id = shang.sp_id "+
				" and sell.xsd_dh = sellmain.xs_id "+
				" and sellmain.xs_xsdate between to_date('"+qishiDate+"','yyyy-mm-dd') "+
				" and to_date('"+jieshuDate+"','yyyy-mm-dd')";
		
			data = NomalJDBC.gongJu(sql);
		}else{
			
			String sql = "select sell.xsd_id,shang.sp_name,shang.sp_dw,sell.xsd_num,sell.xsd_szje,"+
			" (xsd_szje - xsd_num*shang.sp_jj), "+
			" substr((xsd_szje - xsd_num*shang.sp_jj)/sell.xsd_szje,0,4)*100,"+
			" shang.sp_ggxh,shang.sp_color,shang.sp_sccs,shang.sp_bz "+
			" from tb_sell_detail sell,tb_spinfo shang,tb_sell_main sellmain "+
			" where sell.xsd_id = shang.sp_id "+
			" and sell.xsd_dh = sellmain.xs_id "+
			" and sellmain.xs_xsdate between to_date('"+qishiDate+"','yyyy-mm-dd') "+
			" and to_date('"+jieshuDate+"','yyyy-mm-dd') and sp_sccs='"+gongHuoShang+"'";
	
			data = NomalJDBC.gongJu(sql);
		}
		return data;
	}
}
