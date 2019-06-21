package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTable;

import com.cn.view.xiaoshouJFrame.commondialog.KeHuWindow;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.control.xiaoshouframe.guketuihuo.ChaZhaoKeHuButtonAction;
import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;

public class KeHuWindowSureButtonAction implements ActionListener {

	public KeHuWindow window;
	public static GuKeTuiHuoDialog dialog = ChaZhaoKeHuButtonAction.getDialog();
	
	public KeHuWindowSureButtonAction(KeHuWindow window){
		this.window = window;
	}
	public void actionPerformed(ActionEvent e) {
		  String str = null;
		  Vector data = null;
		  
		  JTable table = window.getTable();
	      int row = table.getSelectedRow();
	      String keHuName = (String) table.getValueAt(row, 1);
	      dialog.getKeHuText1().setText(keHuName);
	      
	      data = JDBCDanJuFind.getData(keHuName);
  
    	   if(((Vector)data.get(0)).get(0) == null){
    		   str = "      客户账目      应收金额: "+"0.0"+"          " +
        		"实收金额:"+"0.0" +"      " +"     客户欠款:"+"0.0";
    	   }else {
    		   str = "      客户账目      应收金额: "+((Vector)data.get(0)).get(0)+"          " +
        		"实收金额:"+((Vector)data.get(0)).get(1) +"      " +
        		"     客户欠款:"+((Vector)data.get(0)).get(2);
          
    	   }
    	   
	      dialog.getInfoLabel().setText(str);
	      window.dispose();

	}

}
