package com.cn.control.tongjiframe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.cn.dao.tongji.YeWuYuanCaiGouTongJi.HuiZongJDBC;
import com.cn.dao.tongji.YeWuYuanCaiGouTongJi.XinXiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.CaiGouTongJiMainFrame;

public class danJuMouseListener extends MouseAdapter implements MouseListener {
	private CaiGouTongJiMainFrame frame;
	Vector XinXiColumn;

   public danJuMouseListener(CaiGouTongJiMainFrame frame){
	 this.frame=frame;
 }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 if(e.getButton()==1){
		DefaultTableModel dtm=frame.getDft1();
	  String message=(String)dtm.getValueAt(frame.getDanJuBiao().getSelectedRow(), 3);
	  XinXiColumn = XinXiJDBC.getMingXiData(message);
	 frame.getDft4().setDataVector(XinXiColumn,
			AllTableModel.getVectorFromObj(tongJiModel.xinXiNames));
	 frame.getPinZhong().setText("品种合计: "+frame.getDft4().getRowCount());
	 frame.getXinXiLabel().setText("信息的详细列表："+dtm.getValueAt(frame.getDanJuBiao().getSelectedRow(), 3));
 }
}

}
