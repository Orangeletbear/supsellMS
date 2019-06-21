package com.cn.control.tongjiframe.KeHuXiaoShouTongJi;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.cn.dao.tongji.KeHuXiaoShouTongJi.KeHuXiaoFeiMingXiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;

public class KeHuXiaoFeiMouseListener extends MouseAdapter implements MouseListener {
	private KeHuXiaoShouMainFrame frame;
	Vector XinXiColumn;

   public KeHuXiaoFeiMouseListener(KeHuXiaoShouMainFrame frame){
	 this.frame=frame;
 }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 if(e.getButton()==1){
		DefaultTableModel dtm=frame.getHuiZongDtm();
	  String message=(String)dtm.getValueAt(frame.getHuiZongBiao().getSelectedRow(), 0);
	  XinXiColumn = KeHuXiaoFeiMingXiJDBC.getKeHuMingXiData(message);
	//System.out.println(frame.getYeWuYuanBox().getSelectedItem().toString());
	frame.getMingXiDtm().setDataVector(XinXiColumn,
			AllTableModel.getVectorFromObj(tongJiModel.mingXiNames1));
	frame.getDanJuShu1().setText("单据合计："+frame.getMingXiDtm().getRowCount());
 }
}

}
