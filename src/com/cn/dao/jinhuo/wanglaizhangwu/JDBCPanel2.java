package com.cn.dao.jinhuo.wanglaizhangwu;

import java.util.Vector;

import com.cn.dao.jinhuo.NomalJDBC;
import com.cn.dao.jinhuo.Tb_gongHuoShangJDBC;

/**
 * 往来账务第二个界面的
 * @author Administrator
 *
 */
public class JDBCPanel2 {

	public static Vector getData(String qishiDate,String jieshuDate,String gongHuoShang){
		Vector data = new Vector();
		
		if(gongHuoShang.equals("")){//供货商为空查出所有
			//		采购祥表与采购主表，与商品属性表相连。。查询供货记录，要获取的数据有：
			//商品编号，商品名称，单位，数量，总金额，规格型号，颜色，生产厂商，备注
		
			String sql = "select sp.sp_id,sp.sp_name,sp.sp_dw,cai.cgd_num,cai.cgd_spzje, "+
		       " sp.sp_ggxh,sp.sp_color,sp.sp_sccs,sp.sp_bz "+ 
		       " from tb_cg_detail cai,tb_spinfo sp,tb_cg_main mai "+
		       " where sp.sp_id = cai.cgd_spid "+
		       " and cai.cgd_spdh = mai.cg_id "+
		       " and mai.cg_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+ 
		       			" and to_date('"+jieshuDate+"','yyyy-mm-dd')"; 
		
			data = NomalJDBC.gongJu(sql);
		}else{

			String sql = "select sp.sp_id,sp.sp_name,sp.sp_dw,cai.cgd_num,cai.cgd_spzje, "+
		       " sp.sp_ggxh,sp.sp_color,sp.sp_sccs,sp.sp_bz "+ 
		       " from tb_cg_detail cai,tb_spinfo sp,tb_cg_main mai "+
		       " where sp.sp_id = cai.cgd_spid "+
		       " and cai.cgd_spdh = mai.cg_id "+
		       " and mai.cg_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+ 
		       			" and to_date('"+jieshuDate+"','yyyy-mm-dd') and sp_sccs='"+gongHuoShang+"'"; 
			
			data = NomalJDBC.gongJu(sql);
		}
		return data;
	}
}
