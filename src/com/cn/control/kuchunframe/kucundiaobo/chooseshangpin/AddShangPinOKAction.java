package com.cn.control.kuchunframe.kucundiaobo.chooseshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.chooseshangpin.ChooseShangPinDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.GongYong.AddSanPingCulomns;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;
import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

/*
 * 商品信息栏上的确定按钮
 * 
 */
public class AddShangPinOKAction implements ActionListener {
	private AddShangPinXinXiDialog dialog;
	
	public AddShangPinOKAction(AddShangPinXinXiDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		 
		//获得数据查询 之后的数据
		dialog.getDialog().getVo3().add(ChooseShangPinDataToView.dataToView(dialog));
		
		//将交互得到的数据显示到表中
		dialog.getDialog().getTableModel3().setDataVector(dialog.getDialog().getVo3(),
				AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName3));
		
		((AddSanPingDialog)dialog.getOwner()).getSxsptable().setRowSelectionInterval(0, 0);
		
		//确定之后就消失对话框
		dialog.dispose();
	}
	
}