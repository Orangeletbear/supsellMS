package com.cn.dao.kuchun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;

/**
 * ��ǰ��洰���е�JDBC���ݴ���
 * @author Administrator
 *
 */
public class DanQianKuCunJDBC {
  /**
   * 
   * @param ckName  �ֿ���
   * @param lbName  �����
   * @param spName  ��Ʒ��Ż�����
   * @param isGetO  �Ƿ������Ϊ�����Ʒ
   * @return  ���ز���Ľ������ά����
   */
   public static Vector getSPBDQKData(String ckName,
		         String lbName,String spName,boolean isGetO){
    	
    	Vector data = new Vector();
    	
    	String sql ="select sp.sp_id,sp.sp_name,sp.sp_dw,sp.sp_zdkc,"+
		"intb.sumN,sp.sp_jj,sp.sp_jj,sp.sp_sj,(sp.sp_zdkc*sp.sp_jj),"+
		"sp.sp_ggxh,sp.sp_color,sp.sp_sccs,sp.sp_bz"+
	   " from tb_spinfo sp,"+
	   	"(select tb.xsd_id inid,sum(tb.xsd_num) sumN"+
	   			" from tb_sell_detail tb "+ 
	   			"group by tb.xsd_id ) intb"+
	   			" where sp.sp_id = intb.inid(+)";
    	
    	//�Ƿ�� �����Ϊ�����Ʒ
    	if(!isGetO){
    		if("���вֿ�".equals(ckName)){
    			if("�������".equals(lbName)){
    				sql =sql+      
                    " and (sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"; 
    			}else{
    				sql =sql+ 
                   " and sp.sp_lb = (select intb.sblb_id"+
                    					" from tb_sblb intb"+ 
                    					" where intb.sblb_name = '"+lbName+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"; 
    			}
    		}else{
    			if("�������".equals(lbName)){
    				sql =sql+        
                    " and sp.sp_syck = (select tb.ck_Id"+
                    						" from tb_ckinfo tb"+
                    						" where tb.ck_Name  = '"+ckName+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"; 
    			}else{
    				sql =sql+
                    " and sp.sp_syck = (select tb.ck_Id"+
                    						" from tb_ckinfo tb"+
                    						" where tb.ck_Name  = '"+ckName+"')"+
                   " and sp.sp_lb = (select intb.sblb_id"+
                    					" from tb_sblb intb"+ 
                    	                " where intb.sblb_name = '"+lbName+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"; 
    			}
    			
    		}
    		
    	}else{
    		if("���вֿ�".equals(ckName)){
    			if("�������".equals(lbName)){
    				sql =sql+       
                    " and (sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"+
                    " and sp.sp_zdkc <> 0"; 
    			}else{
    				sql =sql+       
                    " and sp.sp_lb = (select intb.sblb_id"+
                    					" from tb_sblb intb"+ 
                    					" where intb.sblb_name = '"+lbName+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"+
                    " and sp.sp_zdkc <> 0"; 
    			}
    		}else{
    			if("�������".equals(lbName)){
    				sql =sql+       
                    " and sp.sp_syck = (select tb.ck_Id"+
                    						" from tb_ckinfo tb"+
                    						" where tb.ck_Name  = '"+ckName+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"+
                    " and sp.sp_zdkc <> 0"; 
    			}else{
    				sql =sql+      
                    " and sp.sp_syck = (select tb.ck_Id"+
                    						" from tb_ckinfo tb"+
                    						" where tb.ck_Name  = '"+ckName+"')"+
                   " and sp.sp_lb = (select intb.sblb_id"+
                    					" from tb_sblb intb"+ 
                    					" where intb.sblb_name = '"+lbName+"')"+
                    " and( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"+
                    " and sp.sp_zdkc <> 0"; 
    			}
    			
    		}
    	}
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.createStatement();
				rs = st.executeQuery(sql);
				//��ȡ���е�����
				int columnCount = rs.getMetaData().getColumnCount();
				
				while(rs.next()){
					Vector tmp = new Vector();
					for(int column = 1;column<=columnCount;column++){
						tmp.add(rs.getObject(column));
					}
			    data.add(tmp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
    	
    	return data;
    }

   /**
    * ��Ʒ��Ϣ��ѯ
    * @param lbName
    * @param spName  ��Ʒ��Ż�����
    * @return  ���ز���Ľ������ά����
    */
    public static Vector getSPXinXiData(String lbName,String spName){
     	
     	Vector data = new Vector();
     	
     	String sql ="select sp.sp_id,sp.sp_name,sp.sp_jj,"+
     		"sp.sp_sj,sp.sp_dw,sp.sp_ggxh,sp.sp_color,"+
     		"sp.sp_sccs,sp.sp_bz"+
     		" from tb_spinfo sp"+
     		" where ( sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')";
     	
        if("�������".equals(lbName)==false){
        	sql = sql+" and sp.sp_lb = (select intb.sblb_id"+
                    	   " from tb_sblb intb"+ 
                    		" where intb.sblb_name = '"+lbName+"')";
        }
     	Connection conn = JDBCTool.getConnection();
 	    Statement st = null;
 		ResultSet  rs = null;
 		
 		try {
 			st = conn.createStatement();
 				rs = st.executeQuery(sql);
 				//��ȡ���е�����
 				int columnCount = rs.getMetaData().getColumnCount();
 				while(rs.next()){
 					Vector tmp = new Vector();
 					for(int column = 1;column<=columnCount;column++){
 						tmp.add(rs.getObject(column));
 					}
 			    data.add(tmp);
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
   
    
    /**
     * ����ѯ�е���Ʒ�䶯��ѯ
     * @param fromDate ��ʼ����
     * @param toDate  ��������
     * @param spName  ��Ʒ��Ż�����
     * @return  ���ز���Ľ������ά����
     */
     public static Vector getSPBianDongData(Date fromDate,
    		 Date toDate,String spName){
    	 
      	String fromDateT = DateConventer.dateToStr(fromDate, "yyyy-MM-dd");
      	String toDateT = DateConventer.dateToStr(toDate, "yyyy-MM-dd");
      	
      	Vector data = new Vector();
      	
      	String sql = "select sp.sp_id,sp.sp_name,sp.sp_zdkc,"+
        " alltb.cgSum,alltb.cgtSum,(alltb.cgSum - alltb.cgtSum) cgheji,"+
        " alltb.xsSum,alltb.xstSum,(alltb.xsSum - alltb.xstSum ) xsheji "+
        " from (select asp.id id,asp.cgSum cgSum,asp.cgtSum cgtSum,"+
        " asp.xsSum xsSum,xstb.xstSum xstSum "+
        " from (select asp.id id,asp.cgSum cgSum,asp.cgtSum cgtSum,xst.xsSum xsSum"+
		  " from(select asp.id id,asp.cgSum cgSum,cgt.cgtSum cgtSum"+
				  " from (select sp.sp_id id,cgt.cgSum cgSum"+
         " from tb_spinfo sp,("+
          " select cgd.cgd_spid spid,sum (cgd.cgd_num) cgSum"+
           " from tb_cg_main cgm,tb_cg_detail cgd"+
           " where cgm.cg_id  = cgd.cgd_spdh"+
           " and (cgm.cg_date - to_date(?,'yyyy-mm-dd')) >= 0 "+
           " and (to_date(?,'yyyy-mm-dd') - cgm.cg_date) >= 0"+
          " group by cgd.cgd_spid) cgt"+
         " where sp.sp_id = cgt.spid(+)) asp,"+
        " (select cgtd.thd_spid cgtid,sum(cgtd.thd_num) cgtSum"+
         " from tb_th_main cgtm,tb_th_detail cgtd"+
         " where cgtm.th_id = cgtd.thd_spdh"+
         " and (cgtm.th_date - to_date(?,'yyyy-mm-dd')) >= 0 "+
         " and (to_date(?,'yyyy-mm-dd') - cgtm.th_date) >= 0"+
         " group by cgtd.thd_spid ) cgt "+
         " where asp.id = cgt.cgtid(+)) asp,"+
         " (select xsd.xsd_id spid,sum(xsd.xsd_num) xsSum"+
         " from tb_sell_main xs,tb_sell_detail xsd"+
         " where xs.xs_id = xsd.xsd_dh"+
         " and (xs.xs_xsdate - to_date(?,'yyyy-mm-dd')) >= 0 "+
         " and (to_date(?,'yyyy-mm-dd') - xs.xs_xsdate) >= 0"+
         " group by xsd.xsd_id ) xst"+
         " where asp.id = xst.spid(+)) asp,"+
         " (select xstd.khthd_thxdid spn ,sum(xstd.khthd_num) xstSum"+
         " from tb_khth_main xsth,tb_khth_detail xstd"+
         " where xsth.kh_th_id  = xstd.khthd_dh"+
         " and (xsth.kh_th_date - to_date(?,'yyyy-mm-dd')) >= 0 "+
         " and (to_date(?,'yyyy-mm-dd') - xsth.kh_th_date) >= 0"+
         " group by xstd.khthd_thxdid ) xstb"+
         " where asp.id = xstb.spn(+)) alltb, tb_spinfo sp"+
         " where sp.sp_id = alltb.id"+
         " and (sp.sp_id like '%"+spName+"%' or sp.sp_name like '%"+spName+"%')"+
      	 " and not (alltb.cgSum = 0 and alltb.cgtSum = 0 "+
      	 " and alltb.xsSum = 0 and alltb.xstSum = 0)";

      	Connection conn = JDBCTool.getConnection();
      	PreparedStatement ps = null;
  		ResultSet  rs = null;
  		
  		try {
  		        ps = conn.prepareStatement(sql);
  		        
  		        ps.setString(1, fromDateT);
  		        ps.setString(2, toDateT);
  		        ps.setString(3, fromDateT);
		        ps.setString(4, toDateT);
		        ps.setString(5, fromDateT);
  		        ps.setString(6, toDateT);
  		        ps.setString(7, fromDateT);
		        ps.setString(8, toDateT);
		        
  				rs = ps.executeQuery();
  				//��ȡ���е�����
  				int columnCount = rs.getMetaData().getColumnCount();
  				while(rs.next()){
  					Vector tmp = new Vector();
  					for(int column = 1;column<=columnCount;column++){
  						tmp.add(rs.getObject(column));
  					}
  			    data.add(tmp);
  			}
  			
  		} catch (SQLException e) {
  			e.printStackTrace();
  			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
  			return data;
  		} finally{
  			JDBCTool.freeResorse(rs, ps, conn);
  		}
      	
      	return data;
      }
   /*
    * ���鿴�еģ��鿴��ϸ
    * fromDate ��������
    * toDate ��������
    * spId ��Ʒ���
    * ckName
    */
     public static Vector getSPMingXiData(String fromDate,
    		 String toDate ,String spId,String ckName){
    	 
    	
       	Vector data = new Vector();
       	String sql[] =new String[9];
       	//��Ʒ�ɹ�
       	
       	sql[0] ="select cg.cg_date,cg.cg_id,'�ɹ����',ghs.ghs_name,inb.num,"+
       			"0,inb.spdj,inb.zje,ck.ck_name,cg.cg_jbr,cg.cg_czy"+
       			" from tb_cg_main cg,tb_ckinfo ck,tb_ghsinfo ghs,"+
       			"( select cgd.cgd_spdh dh,cgd.cgd_num num ,"+
       				"(sp.sp_jj*cgd.cgd_num) zje,sp.sp_jj spdj"+
       		    " from tb_cg_detail cgd ,tb_spinfo sp "+
       		   " where cgd.cgd_spid = sp.sp_id"+
       		   " and cgd.cgd_spid = ? ) inb"+
       		   " where cg.cg_id = inb.dh and"+
       		   " cg.cg_lkid = ck.ck_id "+
       		    " and (cg.cg_date - to_date(?,'yyyy-mm-dd')) >= 0 "+
       		    " and (to_date(?,'yyyy-mm-dd') - cg.cg_date) >= 0 "+
       		   " and ghs.ghs_id = cg.cg_ghs";
       	
    	//�ɹ��˻�
       	sql[1] ="select th.th_date,th.th_id,'�ɹ��˻�',ghs.ghs_name,0,"+
       			"inb.num,inb.spdj,inb.zje,ck.ck_name,th.th_jbr,th.th_czy"+
       			" from  tb_th_main th,tb_ckinfo ck,tb_ghsinfo ghs,"+
       			"( select thd.thd_spdh dh,thd.thd_num num ,"+
       				"(sp.sp_jj*thd.thd_num) zje,sp.sp_jj spdj"+
       			" from tb_th_detail thd ,tb_spinfo sp "+
       			" where thd.thd_spid = sp.sp_id "+
       			" and thd.thd_spid = ?) inb"+
       			" where th.th_id = inb.dh and"+
       			" th.th_ckid = ck.ck_id "+
       			" and (th.th_date - to_date(?,'yyyy-mm-dd')) >= 0 "+
       			" and (to_date(?,'yyyy-mm-dd') -th.th_date) >= 0"+
       			" and ghs.ghs_id = th.th_ghs";
       //���۳���
       	sql[2] ="select xs.xs_xsdate,xs.xs_id,'���۳���',kh.kh_name,0,"+
       			" inb.num,inb.spdj,inb.zje,ck.ck_name,xs.xs_jbr,xs.xs_czy"+
       		" from tb_sell_main xs,tb_ckinfo ck,tb_khinfo kh,"+
       		" ( select xsd.xsd_dh dh,xsd.xsd_num num ,(xsd.xsd_num*sp.sp_sj) zje,sp.sp_sj spdj"+
       		" from tb_sell_detail xsd ,tb_spinfo sp "+
       		" where xsd.xsd_id = sp.sp_id "+
       		" and xsd.xsd_id like ?) inb"+
       		" where xs.xs_id = inb.dh and xs.xs_khid = kh.kh_id "+
       		" and ck.ck_id = xs.xs_chname "+
       		" and (xs.xs_xsdate - to_date(?,'yyyy-mm-dd')) >= 0"+
       		" and (to_date(?,'yyyy-mm-dd') - xs.xs_xsdate) >= 0";
       			
       	
    	//�����˻�
       	sql[3] ="select th.kh_th_date,th.kh_th_id,'�����˻�',kh.kh_name,0,"+
       			"inb.num,inb.spdj,inb.zje,th.kh_th_chname,th.kh_th_jbr,th.kh_th_czy"+
       			" from tb_khth_main th,tb_ckinfo ck,tb_khinfo kh,"+
       			" ( select thd.khthd_dh dh,thd.khthd_num num ,"+
       		" (thd.khthd_num*sp.sp_sj) zje,sp.sp_sj spdj"+
       		" from tb_khth_detail thd ,tb_spinfo sp"+
       		" where thd.khthd_thxdid = sp.sp_id "+
       		" and thd.khthd_thxdid like ?) inb"+
       		" where th.kh_th_id = inb.dh and kh.kh_id = th.kh_th_name "+
       		"  and ck.ck_id = th.kh_th_chname "+
       		"  and (th.kh_th_date - to_date(?,'yyyy-mm-dd')) >= 0 "+
       		"  and (to_date(?,'yyyy-mm-dd') - th.kh_th_date) >= 0 ";
       	
       	
    	//��Ʒ����
       	sql[4] ="select tb.kctb_tbdate,tb.kctb_ckid,'������',' ',inb.num,"+
       				"inb.num,inb.spdj,inb.zje,ck.ck_name,tb.kctb_jbr,tb.kctb_czy"+
       				" from tb_kctb_main tb,tb_ckinfo ck,"+
       				" ( select tbd.kctbd_tbdh dh,tbd.kctbd_num num ,"+
       				" (tbd.kctbd_num*sp.sp_jj) zje,sp.sp_jj spdj"+
       				" from tb_kctb_detail tbd ,tb_spinfo sp "+
       				" where  tbd.kctbd_spId = sp.sp_id"+
       				" and tbd.kctbd_spid = ? ) inb"+
       				" where tb.kctb_id  = inb.dh and"+
       				" tb.kctb_ckid = ck.ck_id "+
       				" and (tb.kctb_tbdate - to_date(?,'yyyy-mm-dd')) >= 0 "+
       				" and (to_date(?,'yyyy-mm-dd') - tb.kctb_tbdate) >= 0";

       	
      //��Ʒ����
       	sql[5] ="select bs.bs_date,bs.bs_id,'��Ʒ����','',0,inb.num,"+
       				"inb.spdj,inb.zje,ck.ck_name,bs.bs_jbr,bs.bs_czy"+
       				" from tb_bs_main bs,tb_ckinfo ck,"+
       				"( select bsd.bsd_xbid dh,bsd.bsd_num num,"+
       						"(bsd.bsd_num*sp.sp_jj) zje,sp.sp_jj spdj"+
       				" from tb_bs_detail bsd ,tb_spinfo sp "+
       				" where bsd.bsd_xspid = sp.sp_id"+
       				" and bsd.bsd_xspid = ?) inb"+
       				" where bs.bs_id = inb.dh and"+
       				" bs.bs_ck = ck.ck_id "+
       				" and (bs.bs_date - to_date(?,'yyyy-mm-dd')) >= 0 "+
       				" and (to_date(?,'yyyy-mm-dd') - bs.bs_date) >= 0";

       
    	   //��Ʒ����
       	sql[6] ="select byt.by_date,byt.by_id,'��Ʒ����',' ',inb.num,"+
       			"0,inb.spdj,inb.zje,ck.ck_name,byt.by_jbr,byt.by_czy"+
       			" from tb_by_main byt,tb_ckinfo ck,"+
       			"( select byd.byd_cdid dh,byd.byd_num num,"+
       			"(byd.byd_num*sp.sp_jj) zje,sp.sp_jj spdj"+
       			" from tb_by_detail byd ,tb_spinfo sp "+
       			" where byd.byd_spid = sp.sp_id "+
       			" and byd.byd_spid = ?) inb"+
       			" where byt.by_id = inb.dh and byt.by_ck = ck.ck_id "+
       			" and (byt.by_date - to_date(?,'yyyy-mm-dd')) >= 0 "+
       			" and (to_date(?,'yyyy-mm-dd') - byt.by_date) >= 0";
       
       	
    	   //��Ʒ���
       	sql[7] ="select cf.cf_date,cf.cf_id,'��Ʒ�۷�',' ',0,"+
       			"cf.cf_cfnum,sp.sp_jj,(sp.sp_jj*cf.cf_cfnum) zje,"+
       			"ck.ck_name,cf.cf_jbr,cf.cf_czy"+
       			" from tb_cf_main cf,tb_ckinfo ck,tb_spinfo sp"+
       			" where cf.cf_bcfspid = sp.sp_id and cf.cf_lk = ck.ck_id "+
       			  " and cf.cf_bcfspid = ?"+
       			" and (cf.cf_date - to_date(?,'yyyy-mm-dd')) >= 0 "+
       			" and (to_date(?,'yyyy-mm-dd') - cf.cf_date) >= 0 ";

       	//��Ʒ����
       	sql[8] ="select kb.kb_date,kb.kb_id,'��Ʒ����',' ',kb.kb_num,"+
       			"0,sp.sp_jj,(sp.sp_jj*kb.kb_num) zje,"+
       			"ck.ck_name,kb.kb_jbr,kb.kb_czy"+
       			" from tb_kb_main kb,tb_ckinfo ck,tb_spinfo sp"+
       			" where kb.kb_cspid = sp.sp_id and kb.kb_ck = ck.ck_id "+
       			" and kb.kb_cspid = ?"+
       			" and (kb.kb_date - to_date(?,'yyyy-mm-dd')) >= 0 "+
       			" and (to_date(?,'yyyy-mm-dd') - kb.kb_date) >= 0 ";
       	
       	if(!"���вֿ�".equals(ckName)){
       		sql[0] = sql[0]+" and ck.ck_name = '"+ckName+"'";
       		sql[1] = sql[1]+" and ck.ck_name = '"+ckName+"'";
       		sql[2] = sql[2]+" and ck.ck_name = '"+ckName+"'";
       		sql[3] = sql[3]+" and ck.ck_name = '"+ckName+"'";
       		sql[4] = sql[4]+" and ck.ck_name = '"+ckName+"'";
       		sql[5] = sql[5]+" and ck.ck_name = '"+ckName+"'";
       		sql[6] = sql[6]+" and ck.ck_name = '"+ckName+"'";
       		sql[7] = sql[7]+" and ck.ck_name = '"+ckName+"'";
       		sql[8] = sql[8]+" and ck.ck_name = '"+ckName+"'";
       		
       	}  
       	Connection conn = JDBCTool.getConnection();
       	PreparedStatement ps = null;
   		ResultSet  rs = null;
   		
   		try {
   		        for(int i =0;i<sql.length;i++){
   		            ps = conn.prepareStatement(sql[i]);
   		            ps.setString(1,spId );
   		            ps.setString(2,fromDate );
   		            ps.setString(3,toDate );

    				rs = ps.executeQuery();
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
   			return data;
   			
   		} finally{
   			JDBCTool.freeResorse(rs, ps, conn);
   		}
       	
       	return data;
    	 
    	 
     }
}
