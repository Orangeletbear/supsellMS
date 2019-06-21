package com.cn.dao.toolbar;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.util.JDBCTool;
/*
 * �������ϵĵ��ݲ�ѯJDBC����
 */
public class JDBCDanJuFindGetData {
	/*
	 * ������൥����Ϣ
	 * djID ���ݺ�
	 * isGetBZ �Ƿ�����ע
	 */
    public static Vector getData(String djID,boolean isGetBZ){
    	
    	Vector data = new Vector();
    	
    	String sql[] ={"select cgm.cg_id,cgm.cg_date,'�ɹ�������',ghi.ghs_name,"+
                              "cki.ck_name,cgm.cg_yfje,cgm.cg_sfje,"+
                              "cgm.cg_jbr,cgm.cg_bz "+
                              "from tb_cg_main cgm,tb_ghsinfo ghi ,tb_ckinfo cki"+
                             " where cgm.cg_ghs=ghi.ghs_id and cgm.cg_lkid = cki.ck_id"+
                              " and cgm.cg_id like '%"+djID+"%'",
    			       "select cgt.th_id,cgt.th_date,'�ɹ��˻���',ghi.ghs_name,"+
                            "cki.ck_name,cgt.th_yfje,cgt.th_sfje,"+
                             "cgt.th_jbr,cgt.th_cgbz "+
                            "from tb_th_main cgt,tb_ghsinfo ghi ,tb_ckinfo cki"+
                            " where cgt.th_ghs=ghi.ghs_id and cgt.th_ckid = cki.ck_id"+
                             " and cgt.th_id like '%"+djID+"%'",
    			       "select sem.xs_id,sem.xs_xsdate,'��Ʒ���۵�',kh.kh_name,"+
    			       	  	"ck.ck_name,sem.xs_ysje,sem.xs_ssje,"+
    			       	   "sem.xs_jbr,sem.xs_bz"+
    			       	    " from tb_sell_main sem,tb_ckinfo ck,tb_khinfo kh"+
    			       	   " where  sem.xs_chname = ck.ck_id " +
    			       	   "and kh.kh_id = sem.xs_khid and sem.xs_id like '%"+djID+"%'",
    			       	" select khth.kh_th_id,khth.kh_th_date,'�����˻���',kh.kh_name,"+
    			       	   	"ck.ck_name,khth.kh_th_ytje,khth.kh_th_stje,"+
    			       	   	"khth.kh_th_jbr,khth.kh_th_bz"+
    			       	   	" from tb_khth_main khth,tb_ckinfo ck,tb_khinfo kh"+
    			       	   	" where ck.ck_id = khth.kh_th_chname " +
    			       	   	" and kh.kh_id = khth.kh_th_name and  khth.kh_th_id like '%"+djID+"%'"
    			       };
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			for(int i = 0;i<sql.length;i++){
				rs = st.executeQuery(sql[i]);
				//��ȡ���е�����
				int columnCount = rs.getMetaData().getColumnCount();
				if(isGetBZ!=true){
					columnCount--;
				}
				while(rs.next()){
					Vector tmp = new Vector();
					for(int column = 1;column<=columnCount;column++){
						tmp.add(rs.getObject(column));
					}
			    data.add(tmp);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			return data;
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
    }
    
    /*
     * ȡ���õ��ݵ���ϸ��Ϣ
     * daJuNum ���ݺ�
     * ��������
     */
    public static Vector getDetailData(String daJuNum){
    	Vector data = new Vector();
    	
    	String sql[] ={"select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,"+
    						"sp.sp_color,sp.sp_sj,cgd.cgd_num,(sp.sp_sj*cgd.cgd_num) �ܽ��"+
    						" from tb_cg_detail cgd,tb_spinfo sp"+
    						" where cgd.cgd_spid = sp.sp_id"+
    						" and cgd.cgd_spdh like '"+daJuNum+"'",
                       "select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,"+
    						"sp.sp_color,sp.sp_sj,cgt.thd_num,(sp.sp_sj*cgt.thd_num) �ܽ��"+
    						" from tb_th_detail cgt,tb_spinfo sp"+
    						" where cgt.thd_spid = sp.sp_id"+
    						" and cgt.thd_spdh like '"+daJuNum+"'",
    			       "select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,"+
    						"sp.sp_color,sp.sp_sj,tb.xsd_num,(sp.sp_sj*tb.xsd_num) �ܽ��"+
    						" from tb_sell_detail tb,tb_spinfo sp"+
    						" where tb.xsd_id = sp.sp_id"+
    						" and tb.xsd_dh like '"+daJuNum+"'",
    					"select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_ggxh,"+
    						"sp.sp_color,sp.sp_sj,cgd.khthd_num,(sp.sp_sj*cgd.khthd_num) �ܽ��"+
    						" from tb_khth_detail cgd,tb_spinfo sp"+
    						" where cgd.khthd_thxdid = sp.sp_id"+
    						" and cgd.khthd_dh like '"+daJuNum+"'"
    			       };
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
			for(int i = 0;i<sql.length;i++){
				rs = st.executeQuery(sql[i]);
				//��ȡ���е�����
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
					Vector tmp = new Vector();
					for(int column = 1;column<=columnCount;column++){
						tmp.add(rs.getObject(column));
					}
			    data.add(tmp);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
    	
    	
    }
}
