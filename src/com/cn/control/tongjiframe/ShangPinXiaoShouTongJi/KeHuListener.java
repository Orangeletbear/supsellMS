package com.cn.control.tongjiframe.ShangPinXiaoShouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.ShangPinXiaoShouTongJi.KeHuJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.GoodsXiaoShouTongJi;
   
public class KeHuListener implements ActionListener{
	GoodsXiaoShouTongJi frame;   //主界面参数
    public KeHuListener(GoodsXiaoShouTongJi frame){
    	this.frame=frame;
    }      //构造器
	public void actionPerformed(ActionEvent e) {   
			 Vector keHuColumn;
			
				try {
					keHuColumn = KeHuJDBC.getKeHuData(DateConventer.dateToStr(frame.getDatePickerTo4().getSelectedDate()),
							DateConventer.dateToStr(frame.getDatePickerTo5().getSelectedDate()),
							frame.getShangPinText2().getSelectedItem().toString(),frame.getKeHuText().getText());
					frame.getDtm6().setDataVector(keHuColumn,
							AllTableModel.getVectorFromObj(tongJiModel.dtm6Names));
					
					if(keHuColumn.size() ==0){
						return;
					}
					frame.getKeHuBiao().requestFocus();
					frame.getKeHuBiao().setRowSelectionInterval(0, 0);
					frame.getJiLu2().setText("记录数: "+frame.getDtm6().getRowCount());
					
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
				}
				
		
	}
}
