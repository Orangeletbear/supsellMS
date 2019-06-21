package com.cn.dao.jinhuo.caigoudanju;

import java.util.Vector;

import com.cn.dao.jinhuo.NomalJDBC;
/**
 * 采购单据查询：
 * 		查询 采购主表，要获取的数据有：
 *		单据号，开单日期，供货商名称，仓库名称，应付金额，实付金额，欠款金额，优惠金额，单据类型，原始单号，经办人，操作员，备注
 */
public class JDBCCaiGouDanJu {

	public static Vector getCaiGou(String qishiDate,String jieshuDate,String gongHuoShang){
		Vector data = new Vector();
		
		if(gongHuoShang.equals("")){
			
			String sql = " select zhu.cg_id,zhu.cg_date,gh.ghs_name,cang.ck_name,"+
		       " zhu.cg_yfje,zhu.cg_sfje,(zhu.cg_yfje -zhu.cg_sfje -zhu.cg_yhje),zhu.cg_yhje,"+
		       " '采购进货','',zhu.cg_jbr,zhu.cg_czy,zhu.cg_bz "+
			   " from tb_cg_main zhu,tb_ckinfo cang,tb_ghsinfo gh "+
			   " where zhu.cg_lkid = cang.ck_id "+
		       " and zhu.cg_ghs = gh.ghs_id "+
		       " and zhu.cg_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+ 
			   " and to_date('"+jieshuDate+"','yyyy-mm-dd') ";
		
			data = NomalJDBC.gongJu(sql);
			
		}else{
			
			String sql = " select zhu.cg_id,zhu.cg_date,gh.ghs_name,cang.ck_name,"+
		       " zhu.cg_yfje,zhu.cg_sfje,(zhu.cg_yfje -zhu.cg_sfje -zhu.cg_yhje),zhu.cg_yhje,"+
		       " '采购进货','',zhu.cg_jbr,zhu.cg_czy,zhu.cg_bz "+
			   " from tb_cg_main zhu,tb_ckinfo cang,tb_ghsinfo gh "+
			   " where zhu.cg_lkid = cang.ck_id "+
		       " and zhu.cg_ghs = gh.ghs_id "+
		       " and zhu.cg_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+ 
			   " and to_date('"+jieshuDate+"','yyyy-mm-dd') "+
		       " and zhu.cg_ghs = '"+gongHuoShang+"'";
					
			data =  NomalJDBC.gongJu(sql);
		}
		return data;
	}
	
/////////////////////////////////////////////////////////////////////////	
	/**
	 * 
	 */
	public static Vector getDanJuXiangXi(String danHao){
		Vector data = new Vector();
		//		查询 采购详表、商品属性表，要获取的数据有：
		//商品编号，商品名称，单位，单价，数量，总金额，规格型号，颜色
		
			String sql = "select shu.sp_id,shu.sp_name,shu.sp_dw,shu.sp_dj,"+
	       "xiang.cgd_num,xiang.cgd_spzje,shu.sp_ggxh,shu.sp_color "+
	       " from tb_cg_detail xiang,tb_spinfo shu "+
	       " where xiang.cgd_spid = shu.sp_id "+
	       " and xiang.cgd_spdh = '"+danHao+"'";
	
			data = NomalJDBC.gongJu(sql);
	
		return data;
	
	}
}
