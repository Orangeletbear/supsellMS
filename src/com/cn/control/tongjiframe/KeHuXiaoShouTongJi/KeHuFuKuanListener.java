package com.cn.control.tongjiframe.KeHuXiaoShouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.KeHuXiaoShouTongJi.KeHuFuKuanJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;

public class KeHuFuKuanListener implements ActionListener {
	private KeHuXiaoShouMainFrame frame;
	Vector FuKuanColumn;

   public KeHuFuKuanListener(KeHuXiaoShouMainFrame frame){
	 this.frame=frame;
 }

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	try {       
		FuKuanColumn = KeHuFuKuanJDBC.getFuKuanData(DateConventer.dateToStr(frame.getDatePickerTo4().getSelectedDate()),
						DateConventer.dateToStr(frame.getDatePickerTo5().getSelectedDate()),
						frame.getQuanBuKeHu().getText());
		            frame.getDanJuDtm().setDataVector(FuKuanColumn,
						AllTableModel.getVectorFromObj(tongJiModel.danJuNames1));
		            if(FuKuanColumn.size() == 0){
		            	return;
		            }
		            frame.getDanJuBiao().requestFocus();
		            frame.getDanJuBiao().setRowSelectionInterval(0, 0);
		            frame.getJiLuShuLiang().setText("¼ÇÂ¼ÊýÁ¿: "+frame.getDanJuDtm().getRowCount());
	} catch (ParseException e1) {
		
	}
}
	
}


