package com.cn.control.tongjiframe.KeHuXiaoShouTongJi;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.cn.dao.tongji.KeHuXiaoShouTongJi.KeHuDanJuMingXiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;
import com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou.CheckDialog;

public class KeHuDanJuMouseListener extends MouseAdapter implements MouseListener {
	public KeHuXiaoShouMainFrame frame;
	Vector XinXiColumn;
	Vector FuKuanColumn;

   public KeHuDanJuMouseListener(KeHuXiaoShouMainFrame frame){
	 this.frame=frame;
 }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 if(e.getButton()==1){
		DefaultTableModel dtm=frame.getZhangWuDtm();
	  String message=(String)dtm.getValueAt(frame.getZhangWuBiao().getSelectedRow(), 2);
	  XinXiColumn = KeHuDanJuMingXiJDBC.getShangPinMingXiData(message);
	frame.getShangPinDtm().setDataVector(XinXiColumn,
			AllTableModel.getVectorFromObj(tongJiModel.shangPinNames));
	frame.getJuLuShu().setText("¼ÇÂ¼Êý£º"+frame.getShangPinDtm().getRowCount());
	
	String message1=(String)dtm.getValueAt(frame.getZhangWuBiao().getSelectedRow(), 2);
	FuKuanColumn = KeHuDanJuMingXiJDBC.getFuKuanMingXiData(message1);
   frame.getFuKuanDtm().setDataVector(FuKuanColumn,
		AllTableModel.getVectorFromObj(tongJiModel.fuKuanNames));
   if(e.getClickCount()==2){
	   new CheckDialog(frame,"",true);
   }
 }

	 
 

	}
}
