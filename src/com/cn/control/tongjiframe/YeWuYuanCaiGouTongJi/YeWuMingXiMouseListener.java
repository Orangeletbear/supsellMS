package com.cn.control.tongjiframe.YeWuYuanCaiGouTongJi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.cn.dao.tongji.YeWuYuanXiaoShouTongJi.YeWuMingXiMouseJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.view.tongjiJFrame.YeWuYuanMainFrame;

public class YeWuMingXiMouseListener extends MouseAdapter implements MouseListener {
	private YeWuYuanMainFrame frame;
	Vector XinXiColumn;

   public YeWuMingXiMouseListener(YeWuYuanMainFrame frame){
	 this.frame=frame;
 }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 if(e.getButton()==1){
		DefaultTableModel dtm=frame.getXiaoShouDtm();
	  String message=(String)dtm.getValueAt(frame.getXiaoShouBiao().getSelectedRow(), 0);
	  XinXiColumn = YeWuMingXiMouseJDBC.getYeWuMingXiData(message);
	  frame.getXiangQing().setText("单据号:  "+message);
	frame.getMingXiDtm().setDataVector(XinXiColumn,
			AllTableModel.getVectorFromObj(tongJiModel.mingXiNames2));
	frame.getJiLuShu().setText("记录数："+frame.getMingXiDtm().getRowCount());
 }
}

}
