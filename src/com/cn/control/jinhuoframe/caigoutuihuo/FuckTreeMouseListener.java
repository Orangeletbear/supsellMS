package com.cn.control.jinhuoframe.caigoutuihuo;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCFindGoodsInfo;
import com.cn.view.jinhuoJFrame.jdialog.caigoutuihuo.TuiHuoShangPin;

/**
 * 增加商品(商品销售)对话框上的
 * 商品类别树所对应的监听器
 * @author Administrator
 *
 */
public class FuckTreeMouseListener extends MouseAdapter {

	private TuiHuoShangPin dialog;
	
	public FuckTreeMouseListener(TuiHuoShangPin dialog){
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