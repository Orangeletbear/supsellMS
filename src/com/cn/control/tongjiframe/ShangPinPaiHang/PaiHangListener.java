package com.cn.control.tongjiframe.ShangPinPaiHang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;
import com.cn.dao.tongji.XiaoShouPaiHang.PaiHangJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.XiaoShouMainFrame;

public class PaiHangListener implements ActionListener {
	private XiaoShouMainFrame frame;
	Vector PaiHangColumn;

   public PaiHangListener(XiaoShouMainFrame frame){
	 this.frame=frame;
 }

public void actionPerformed(ActionEvent e) {
	try {       
		        PaiHangColumn = PaiHangJDBC.getPaiHangData(DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate()),
						DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate()),
						frame.getBox().getSelectedItem().toString(),frame.getCangKuKind().getText());
		        frame.getDtm().setDataVector(PaiHangColumn,
						AllTableModel.getVectorFromObj(tongJiModel.biaoGeNames));
		        frame.getJiLu().setText("¼ÇÂ¼Êý: "+frame.getDtm().getRowCount());
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
	
}


