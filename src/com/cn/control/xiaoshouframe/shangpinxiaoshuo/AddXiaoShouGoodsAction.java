package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCFindGoodsInfo;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
//import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
/**
 * 增加商品（销售进货）
 * 对话框所对应的窗口打开事件
 * 
 * @author Administrator
 *
 */
public class AddXiaoShouGoodsAction extends WindowAdapter {

	private AddXiaoShouGoodsDialog dialog;
	//private ShangPinXiaoShouDialog mainDialog;
	
	public AddXiaoShouGoodsAction(AddXiaoShouGoodsDialog dialog){
		this.dialog = dialog;
	}
	public void windowOpened(WindowEvent e){
		Vector data = JDBCFindGoodsInfo.getData();
		if(data.size() > 0){
			dialog.getSpqd_tableModel().setDataVector(data,
					  AllTableModel.getVectorFromObj(DialogCulomnModel.leftColumnName) );
			dialog.getSpqdtable().requestFocus();
			dialog.getSpqdtable().setRowSelectionInterval(0, 0);
		}
	
		//mainDialog.get
	}
}
