package com.cn.control.kuchunframe.kucunchaxun;

import java.util.Vector;

import com.cn.dao.kuchun.DanQianKuCunJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;

/**
 * ��ѯ��һ���������ദ�õ��ķ���
 * @author finey
 *
 */
public class CunChunPublicFindData {
	
    public static void setSPDataFromDatabase(KuCunChaXunFrame frame,
    		String ckName,String spName){
    	
    	Vector data =DanQianKuCunJDBC.getSPXinXiData(ckName, spName);
    	
    	frame.getTableMode3().setDataVector(data,
          		 AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunColumnName3));
    	
    }
}
