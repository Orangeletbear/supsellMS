package com.cn.control.systemframe.sanpingtiaojia;

import java.util.Vector;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.dao.system.SanPingTiaoJiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.view.systemJFrame.SanpinTiaoJiaJFrame;
/**
 * 商品调价中的公共更新数据的方法
 * @author Administrator
 *
 */
public class SPTiaoJiaGetDataPublic {
	
	public static void getDataAndSetData(SanpinTiaoJiaJFrame frame){
		
		String lbName = frame.getTree().getLastSelectedPathComponent().toString().trim();
 	    String spName = frame.getSpbhfield12().getText().toString().trim();
 	    System.out.println(lbName+"   "+ spName);
 	   
 	    Vector data = SanPingTiaoJiJDBC.getSPBaseMassege(lbName, spName);
        //更新界面数据
        frame.getTableModel().setDataVector(data,
    		   AllTableModel.getVectorFromObj(SPTJTableCulomns.ColumnName11));
 	   
       
		
		
		
	}
}
