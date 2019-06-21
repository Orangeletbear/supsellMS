package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
/**
 * 增加商品(顾客退货）对话框上的
 * 商品类别树所对应的监听器
 * @author Administrator
 *
 */
public class AddTuiHuoGoods_TreeMouseListener extends MouseAdapter {

	private GuKeTuiHuoDialog mainDialog;
	private AddTuiHuoGoodsDialog dialog;
	
	public AddTuiHuoGoods_TreeMouseListener(AddTuiHuoGoodsDialog dialog){
		this.dialog = dialog;
	}
	
	public void mouseClicked(MouseEvent e ){
		mainDialog = dialog.getMaindialog();
		String khName = mainDialog.getKeHuText1().getText();
		
		if(e.getClickCount() == 1 && e.getButton() == 1){
			String splb = dialog.getTree().getLastSelectedPathComponent().toString().trim();
      	
			Vector data = JDBCDanJuFind.getGoodsData(khName, splb);
			
			dialog.getSplb_tableModel().setDataVector(data,
					AllTableModel.getVectorFromObj(DialogCulomnModel.leftColumnName));
					      	   
		}else 	if(e.getClickCount() == 2 && e.getButton() == 1){
		  new GoodsInfoDialog(dialog,"商品信息（销售退货）");
					      	   
		}
	}
	
}
