package com.cn.dao.jinhuo.wanglaizhangwu;

import java.util.Vector;

import com.cn.dao.jinhuo.NomalJDBC;
import com.cn.dao.jinhuo.Tb_gongHuoShangJDBC;
/**
 * ��������Panel5������
 * ��ѯ�ɹ����������ɹ��˻�������ѯ�����У�
 * ���ݱ�ţ��������ڣ����ͣ���������������ƣ������ˣ�����Ա����ע
 *
 */
public class JDBCPanel5 {

	public static Vector getCaiGou(String qishiDate,String jieshuDate,String gongHuoShang){
		Vector data = new Vector();
		
		if(gongHuoShang.equals("")){//������Ϊnull������еĹ�����
		
			String sql = "select jin.cg_id,jin.cg_date,'�ɹ�����',jin.cg_sfje,ghs_name,"+
		       " jin.cg_jbr,jin.cg_czy,jin.cg_bz "+
		       " from tb_cg_main jin ,tb_ghsinfo " +
		       " where cg_ghs=ghs_id and jin.cg_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+
		       " and to_date('"+jieshuDate+"','yyyy-mm-dd')";
		
			Vector argData = NomalJDBC.gongJu(sql);
			for(Object tmp : argData){
				data.add(tmp);
			}
		
		
			sql =" select tui.th_id,tui.th_date,'�ɹ��˻�',tui.th_sfje,ghs_name,"+
		       " tui.th_jbr,tui.th_czy,tui.th_cgbz "+
		       " from tb_th_main tui ,tb_ghsinfo "+
		       " where th_ghs=ghs_id and tui.th_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+
		       " and to_date('"+jieshuDate+"','yyyy-mm-dd')";
			
			argData =  NomalJDBC.gongJu(sql);
			for(Object tmp : argData){
				data.add(tmp);
			}
		}else{
			String sql = "select jin.cg_id,jin.cg_date,'�ɹ�����',jin.cg_sfje,ghs_name,"+
		       " jin.cg_jbr,jin.cg_czy,jin.cg_bz "+
		       " from tb_cg_main jin ,tb_ghsinfo " +
		       " where cg_ghs=ghs_id and jin.cg_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+
		       " and to_date('"+jieshuDate+"','yyyy-mm-dd')"+
		         " and ghs_name ='"+gongHuoShang+"'";
					
			Vector argData =  NomalJDBC.gongJu(sql);
			for(Object tmp : argData){
				data.add(tmp);
			}
					
			sql =" select tui.th_id,tui.th_date,'�ɹ��˻�',tui.th_sfje,ghs_name,"+
		       " tui.th_jbr,tui.th_czy,tui.th_cgbz "+
		       " from tb_th_main tui ,tb_ghsinfo "+
		       " where th_ghs=ghs_id and tui.th_date between to_date('"+qishiDate+"','yyyy-mm-dd') "+
		       " and to_date('"+jieshuDate+"','yyyy-mm-dd')"+
		       " and ghs_name = '"+gongHuoShang+"'";
					
			argData = NomalJDBC.gongJu(sql);
			for(Object tmp : argData){
				data.add(tmp);
			}
		}
		
		return data;
	}
	
}
