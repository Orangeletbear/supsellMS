package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.jinhuo.AddSanPingCulomns;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;

/**
 * 顾客退货选项卡中的添加退货商品
 * 按钮所对应的监听器
 * @author Administrator
 *
 */

public class AddTuiHuoShangPinAction extends WindowAdapter {
	
	private GuKeTuiHuoDialog mainDialog ;
	private AddTuiHuoGoodsDialog dialog;

	public AddTuiHuoShangPinAction(AddTuiHuoGoodsDialog dialog){
		this.dialog = dialog;
	}
	/////////窗口打开时加入数据
	public void windowOpened(WindowEvent e) {
		  Vector data  = null;
		  mainDialog = dialog.getMaindialog();
		  String khName = mainDialog.getKeHuText1().getText();
		  data = JDBCDanJuFind.getGoodsData(khName);
		
		  if(data.size() > 0){
			  dialog.getSpqd_tableModel().setDataVector(data,
						AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName1));
			  dialog.getSpqdtable().requestFocus();
			  dialog.getSpqdtable().setRowSelectionInterval(0, 0);
		  }
		
	    // 

	}

}
