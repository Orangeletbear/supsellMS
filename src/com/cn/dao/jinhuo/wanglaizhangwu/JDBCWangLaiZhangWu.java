package com.cn.dao.jinhuo.wanglaizhangwu;

import java.util.Vector;

import com.cn.dao.jinhuo.NomalJDBC;
import com.cn.dao.jinhuo.Tb_gongHuoShangJDBC;

/**
 * ���������һ�������
 * @author Administrator
 *
 */
public class JDBCWangLaiZhangWu {
	
	public static Vector getCaiGou(String qishiDate,String jieshuDate,String gongHuoShang){
		Vector data = new Vector();
		
		if(gongHuoShang.equals("")){
			//		��ѯ �ɹ�����Ҫ��ȡ�������У�
			//���������ƣ����ڣ����ţ����ͣ�Ӧ����ʵ����	Ƿ����Żݽ������ˣ�����Ա����ע
		
			String sql = "select gh.ghs_name,zhu.cg_date,zhu.cg_id,'����֧��',zhu.cg_yfje,"+
			"zhu.cg_sfje,(zhu.cg_yfje -zhu.cg_sfje -zhu.cg_yhje),"+
			"zhu.cg_yhje,zhu.cg_jbr,zhu.cg_czy "+
			" from tb_cg_main zhu,tb_ghsinfo gh "+
			" where zhu.cg_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+
			" and to_date('"+jieshuDate+"','yyyy-mm-dd') "+
			" and zhu.cg_ghs = gh.ghs_id ";
		
			Vector argData = NomalJDBC.gongJu(sql);
			for(Object tmp : argData){
				data.add(tmp);
			}
		
			//		��ѯ �˻�����Ҫ��ȡ�������У�
			//		���������ƣ����ڣ����ţ����ͣ�Ӧ����ʵ����Ƿ����Żݽ������ˣ�����Ա����ע
		
			sql ="select gh.ghs_name,ma.th_date,ma.th_id,'�˻�����',ma.th_yfje,"+
			" ma.th_sfje,(ma.th_yfje-ma.th_sfje),"+
			" '0',ma.th_jbr,ma.th_czy "+
			" from tb_th_main ma,tb_ghsinfo gh "+
			" where ma.th_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+
			" and to_date('"+jieshuDate+"','yyyy-mm-dd') "+
			" and ma.th_ghs = gh.ghs_id ";
			
			argData =  NomalJDBC.gongJu(sql);
			for(Object tmp : argData){
				data.add(tmp);
			}
		}else{
			String sql = "select gh.ghs_name,zhu.cg_date,zhu.cg_id,'����֧��',zhu.cg_yfje,"+
			"zhu.cg_sfje,(zhu.cg_yfje -zhu.cg_sfje -zhu.cg_yhje),"+
			"zhu.cg_yhje,zhu.cg_jbr,zhu.cg_czy "+
			" from tb_cg_main zhu,tb_ghsinfo gh "+
			" where zhu.cg_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+
			" and to_date('"+jieshuDate+"','yyyy-mm-dd') "+
			" and zhu.cg_ghs = gh.ghs_id and ghs_name='"+gongHuoShang+"'";
					
			Vector argData =  NomalJDBC.gongJu(sql);
			for(Object tmp : argData){
				data.add(tmp);
			}
					
			sql ="select gh.ghs_name,ma.th_date,ma.th_id,'�˻�����',ma.th_yfje,"+
			" ma.th_sfje,(ma.th_yfje-ma.th_sfje),"+
			" '0',ma.th_jbr,ma.th_czy "+
			" from tb_th_main ma,tb_ghsinfo gh "+
			" where ma.th_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+
			" and to_date('"+jieshuDate+"','yyyy-mm-dd') "+
			" and ma.th_ghs = gh.ghs_id and ghs_name='"+gongHuoShang+"'";
			
					
			argData = NomalJDBC.gongJu(sql);
			for(Object tmp : argData){
				data.add(tmp);
			}
		}
		
		return data;
	}
	
/////////////////////////////////////////////////////////////////////////	
	/**
	 * 
	 */
	public static Vector getDanJuXiangXi(String danHao){
		Vector data = new Vector();
		Vector argData;
		//		��ѯ �ɹ������Ʒ���Ա�Ҫ��ȡ�������У�
		//��Ʒ��ţ���Ʒ���ƣ���λ�����ۣ��������ܽ�����ͺţ���ɫ
		if(danHao.matches("CJ\\d*")){
			String sql = "select shu.sp_id,shu.sp_name,shu.sp_dw,shu.sp_dj,"+
	       "xiang.cgd_num,xiang.cgd_spzje,shu.sp_ggxh,shu.sp_color "+
	       " from tb_cg_detail xiang,tb_spinfo shu "+
	       " where xiang.cgd_spid = shu.sp_id "+
	       " and xiang.cgd_spdh = '"+danHao+"'";
	
			argData = NomalJDBC.gongJu(sql);
			for(Object tmp : argData){
				data.add(tmp);
			}
		}else{
			String sql = "select shu.sp_id,shu.sp_name,shu.sp_dw,shu.sp_dj,de.thd_num,"+
	       	  " de.thd_spzje,shu.sp_ggxh,shu.sp_color "+
	       	  " from tb_th_detail de,tb_spinfo shu "+
	       	  " where shu.sp_id = de.thd_spid "+
	       	  " and de.thd_spdh ='"+danHao+"'";
			argData = NomalJDBC.gongJu(sql);
			for(Object tmp : argData){
				data.add(tmp);
			}
		}
		
		return data;
	
	}
	

}
	



