package com.cn.dao.jinhuo.caigoudanju;

import java.util.Vector;

import com.cn.dao.jinhuo.NomalJDBC;
/**
 * �ɹ����ݲ�ѯ��
 * 		��ѯ �ɹ�����Ҫ��ȡ�������У�
 *		���ݺţ��������ڣ����������ƣ��ֿ����ƣ�Ӧ����ʵ����Ƿ����Żݽ��������ͣ�ԭʼ���ţ������ˣ�����Ա����ע
 */
public class JDBCCaiGouDanJu {

	public static Vector getCaiGou(String qishiDate,String jieshuDate,String gongHuoShang){
		Vector data = new Vector();
		
		if(gongHuoShang.equals("")){
			
			String sql = " select zhu.cg_id,zhu.cg_date,gh.ghs_name,cang.ck_name,"+
		       " zhu.cg_yfje,zhu.cg_sfje,(zhu.cg_yfje -zhu.cg_sfje -zhu.cg_yhje),zhu.cg_yhje,"+
		       " '�ɹ�����','',zhu.cg_jbr,zhu.cg_czy,zhu.cg_bz "+
			   " from tb_cg_main zhu,tb_ckinfo cang,tb_ghsinfo gh "+
			   " where zhu.cg_lkid = cang.ck_id "+
		       " and zhu.cg_ghs = gh.ghs_id "+
		       " and zhu.cg_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+ 
			   " and to_date('"+jieshuDate+"','yyyy-mm-dd') ";
		
			data = NomalJDBC.gongJu(sql);
			
		}else{
			
			String sql = " select zhu.cg_id,zhu.cg_date,gh.ghs_name,cang.ck_name,"+
		       " zhu.cg_yfje,zhu.cg_sfje,(zhu.cg_yfje -zhu.cg_sfje -zhu.cg_yhje),zhu.cg_yhje,"+
		       " '�ɹ�����','',zhu.cg_jbr,zhu.cg_czy,zhu.cg_bz "+
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
		//		��ѯ �ɹ������Ʒ���Ա�Ҫ��ȡ�������У�
		//��Ʒ��ţ���Ʒ���ƣ���λ�����ۣ��������ܽ�����ͺţ���ɫ
		
			String sql = "select shu.sp_id,shu.sp_name,shu.sp_dw,shu.sp_dj,"+
	       "xiang.cgd_num,xiang.cgd_spzje,shu.sp_ggxh,shu.sp_color "+
	       " from tb_cg_detail xiang,tb_spinfo shu "+
	       " where xiang.cgd_spid = shu.sp_id "+
	       " and xiang.cgd_spdh = '"+danHao+"'";
	
			data = NomalJDBC.gongJu(sql);
	
		return data;
	
	}
}
