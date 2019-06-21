package com.cn.control.tongjiframe.YeWuYuanCaiGouTongJi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.cn.dao.tongji.YeWuYuanXiaoShouTongJi.YeWuYeJiMouseJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.view.tongjiJFrame.YeWuYuanMainFrame;

public class YeWuYeJiMouseListener extends MouseAdapter implements MouseListener {
	private YeWuYuanMainFrame frame;
	Vector XinXiColumn;

   public YeWuYeJiMouseListener(YeWuYuanMainFrame frame){
	 this.frame=frame;
 }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 if(e.getButton()==1){
		DefaultTableModel dtm=frame.getYeJiDtm();
	  String message=(String)dtm.getValueAt(frame.getYeJiBiao().getSelectedRow(), 0);
	  XinXiColumn = YeWuYeJiMouseJDBC.getYeJiMingXiData(message);
	frame.getKeHuJinEmingXi().setText("业务员名：  "+message);
	frame.getYeJiXiDtm().setDataVector(XinXiColumn,
			AllTableModel.getVectorFromObj(tongJiModel.yeJiXiNames));
	frame.getJiLuShu5().setText("记录数："+frame.getYeJiXiDtm().getRowCount());
 }
}

}
