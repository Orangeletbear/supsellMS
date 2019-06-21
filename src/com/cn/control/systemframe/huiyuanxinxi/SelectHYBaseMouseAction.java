package com.cn.control.systemframe.huiyuanxinxi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
import com.cn.view.systemJFrame.huiyuanguanli.AddHuiYuan;

public class SelectHYBaseMouseAction extends MouseAdapter {

	private HuiYanGuangLiFrame frame;  
	public SelectHYBaseMouseAction(HuiYanGuangLiFrame frame) {
		this.frame = frame;
	}

	public void mouseClicked(MouseEvent arg0) {
         
        	  
        	if(arg0.getClickCount() ==1 || arg0.getClickCount() ==2){
        		int row = frame.getHyXinXiT().getSelectedRow();

            	String hyid = frame.getHyXinXiTM().getValueAt(row, 0).toString();
            	String hyName = frame.getHyXinXiTM().getValueAt(row, 1).toString();
				  
	        	frame.getXfdLab().setText(hyName);
	        	  
	        	Vector data = HuiYuanXinGLJDBC.getHuiYuanXiaoFeiMassege(
	        			"2000-1-1","2222-2-2",hyid);
	        	  
	        	frame.getHyXianXiXinXiTM().setDataVector(data,
	        	AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName12));
				
				
				String jiFen = frame.getHyXinXiTM().getValueAt(
						frame.getHyXinXiT().getSelectedRow(), 3).toString();
				if(!jiFen.equals("0")){
					frame.getJfqlBtn().setEnabled(true);
				}else{
					frame.getJfqlBtn().setEnabled(false);
				}
				
				}
				if(arg0.getClickCount() ==2){
					new AddHuiYuan(frame,"ÐÞ¸Ä»áÔ±",true);
				}
        	  
        	  
        	  
        	
        	  
        	  
        	  
          
	}
	
}
