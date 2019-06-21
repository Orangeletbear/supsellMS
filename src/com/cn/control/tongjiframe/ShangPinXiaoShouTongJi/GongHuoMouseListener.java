package com.cn.control.tongjiframe.ShangPinXiaoShouTongJi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.cn.dao.tongji.ShangPinXiaoShouTongJi.GongHuoXiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.view.tongjiJFrame.GoodsXiaoShouTongJi;
import com.cn.view.tongjiJFrame.Dialog.ShangPinXiaoShouDialog.TongJiDialog;

public class GongHuoMouseListener extends MouseAdapter implements MouseListener {
	private GoodsXiaoShouTongJi frame;
	Vector XinXiColumn;

   public GongHuoMouseListener(GoodsXiaoShouTongJi frame){
	 this.frame=frame;
 }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 if(e.getButton()==1){
		DefaultTableModel dtm=frame.getDtm4();
	  String message=(String)dtm.getValueAt(frame.getGongHuoBiao().getSelectedRow(), 0);
		//System.out.println((String) dtm.getValueAt(frame.getGongHuoBiao().getSelectedRow(), 0));
	  XinXiColumn = GongHuoXiJDBC.getGongHuoXiData(message);
	//System.out.println(frame.getYeWuYuanBox().getSelectedItem().toString());
	frame.getDtm5().setDataVector(XinXiColumn,
			AllTableModel.getVectorFromObj(tongJiModel.dtm5Names));
	frame.getGongHuoShangXinXi().setText("供货商商品销售明细        "+
			frame.getDtm4().getValueAt(frame.getGongHuoBiao().getSelectedRow(), 0));
	if(e.getButton()==1&&e.getClickCount()==2){
		new TongJiDialog(frame,"单据查询",true);
	}
 }//
}

}

//public class GongHuoMouseListener extends MouseAdapter implements MouseListener {


