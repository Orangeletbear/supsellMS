package com.cn.control.tongjiframe.KeHuXiaoShouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.KeHuXiaoShouTongJi.KeHuZhangWuJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;

public class KeHuZhangWuListener implements ActionListener {
	private KeHuXiaoShouMainFrame frame;
	Vector ZhuangWuColumn;

   public KeHuZhangWuListener(KeHuXiaoShouMainFrame frame){
	 this.frame=frame;
 }

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	ZhuangWuColumn = KeHuZhangWuJDBC.getZhangWuData(frame.getQuanBuKeHu1().getText());
	System.out.println(frame.getQuanBuKeHu1().getText());
	        frame.getKeHuDtm().setDataVector(ZhuangWuColumn,
					AllTableModel.getVectorFromObj(tongJiModel.keHuName));
	        frame.getKeHuShu().setText("¿Í»§Êý: "+frame.getKeHuDtm().getRowCount());
}
	
}




