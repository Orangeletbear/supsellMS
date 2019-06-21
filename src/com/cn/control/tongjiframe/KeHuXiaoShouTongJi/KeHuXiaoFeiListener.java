package com.cn.control.tongjiframe.KeHuXiaoShouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.KeHuXiaoShouTongJi.KeHuXiaoFeiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;

public class KeHuXiaoFeiListener implements ActionListener {
	private KeHuXiaoShouMainFrame frame;
	Vector DanJuColumn;

   public KeHuXiaoFeiListener(KeHuXiaoShouMainFrame frame){
	 this.frame=frame;
 }

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	try {       
		DanJuColumn = KeHuXiaoFeiJDBC.getXiaoFeiData(DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate()),
						DateConventer.dateToStr(frame.getDatePickerTo3().getSelectedDate()),
						frame.getKeHuNames1().getText());
		        //System.out.println("djlf"+frame.getBox().getSelectedItem().toString()+"fdg"+frame.getCangKuKind().getText());
		        frame.getHuiZongDtm().setDataVector(DanJuColumn,
						AllTableModel.getVectorFromObj(tongJiModel.huiZongNames1));
		        if(DanJuColumn.size() ==0){
		        	return;
		        }
		        frame.getHuiZongBiao().requestFocus();
		        frame.getHuiZongBiao().setRowSelectionInterval(0, 0);
		        frame.getJiLuShu1().setText("记录数："+frame.getHuiZongDtm().getRowCount());
		        frame.getDanJuXiangXi1().setText("商品销售明细："+frame.getHuiZongDtm().getValueAt(frame.getHuiZongBiao().getSelectedRow(), 1));
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
	}
}
	
}



