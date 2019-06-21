package com.cn.control.tongjiframe.ShangPinXiaoShouTongJi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.cn.dao.tongji.ShangPinXiaoShouTongJi.KeHuXiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.view.tongjiJFrame.GoodsXiaoShouTongJi;
import com.cn.view.tongjiJFrame.Dialog.ShangPinXiaoShouDialog.KeHuTongJiDialog;

public class KeHuMouseListener extends MouseAdapter implements MouseListener {
	private GoodsXiaoShouTongJi frame;
	Vector XinXiColumn;

   public KeHuMouseListener(GoodsXiaoShouTongJi frame){
	 this.frame=frame;
 }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 if(e.getButton()==1){
		DefaultTableModel dtm=frame.getDtm6();
	  String message=(String)dtm.getValueAt(frame.getKeHuBiao().getSelectedRow(), 0);
		//System.out.println((String) dtm.getValueAt(frame.getGongHuoBiao().getSelectedRow(), 0));
	  XinXiColumn = KeHuXiJDBC.getKeHuXiData(message);
	//System.out.println(frame.getYeWuYuanBox().getSelectedItem().toString());
	frame.getDtm7().setDataVector(XinXiColumn,
			AllTableModel.getVectorFromObj(tongJiModel.dtm7Names));
	frame.getKeHuXinXi().setText("客户销售商品明细 "+
			frame.getDtm6().getValueAt(frame.getKeHuBiao().getSelectedRow(), 0));
	if(e.getButton()==1&&e.getClickCount()==2){
		new KeHuTongJiDialog(frame,"单据查询",true);
	}
 }//
}

}

//public class GongHuoMouseListener extends MouseAdapter implements MouseListener {


