package com.cn.control.tongjiframe.KeHuXiaoShouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.KeHuXiaoShouTongJi.KeHuDanJuJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;

public class KeHuDanJuListener implements ActionListener {
	private KeHuXiaoShouMainFrame frame;
	Vector DanJuColumn;

   public KeHuDanJuListener(KeHuXiaoShouMainFrame frame){
	 this.frame=frame;
 }

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	try {       
		DanJuColumn = KeHuDanJuJDBC.getDanJuData(DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate()),
						DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate()),
						frame.getKeHuNames().getText());
		        //System.out.println("djlf"+frame.getBox().getSelectedItem().toString()+"fdg"+frame.getCangKuKind().getText());
		        frame.getZhangWuDtm().setDataVector(DanJuColumn,
						AllTableModel.getVectorFromObj(tongJiModel.zhangWuNames));
		        if(DanJuColumn.size() ==0){
		        	return;
		        }
		        frame.getZhangWuBiao().requestFocus();
		        frame.getZhangWuBiao().setRowSelectionInterval(0, 0);
		        frame.getDanJuShu().setText("单据总数: "+frame.getZhangWuDtm().getRowCount());
		        frame.getDanJuXiangXi().setText("单据的详细信息："+frame.getZhangWuDtm().getValueAt(frame.getZhangWuBiao().getSelectedRow(), 2));
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
	}
}
	
}


