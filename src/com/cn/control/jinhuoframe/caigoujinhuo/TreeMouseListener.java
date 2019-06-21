package com.cn.control.jinhuoframe.caigoujinhuo;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCFindGoodsInfo;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo;

/**
 * 增加商品(商品销售)对话框上的
 * 商品类别树所对应的监听器
 * @author Administrator
 *
 */
public class TreeMouseListener extends MouseAdapter {

	private AddShangPingDialog dialog;
	
	public TreeMouseListener(AddShangPingDialog dialog){
		this.dialog = dialog;
	}
	
	public void mouseClicked(MouseEvent e ){
		
		if(e.getClickCount() == 1 || e.getClickCount() == 2){
			String splb = dialog.getTree().
						getLastSelectedPathComponent().toString().trim();
      	
			 dialog.setSpqdtable_data(JDBCFindGoodsInfo.getlbData(splb));
			
			dialog.getSplb_tableModel().setDataVector(dialog.getSpqdtable_data(),
					dialog.getSpqdtable_columnName());
		}
					      	   
		
	}
}
