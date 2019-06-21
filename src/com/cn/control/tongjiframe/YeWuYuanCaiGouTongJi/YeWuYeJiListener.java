package com.cn.control.tongjiframe.YeWuYuanCaiGouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.YeWuYuanXiaoShouTongJi.YeWuYeJiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.YeWuYuanMainFrame;
   
public class YeWuYeJiListener implements ActionListener{
	YeWuYuanMainFrame frame;   //主界面参数
    public YeWuYeJiListener(YeWuYuanMainFrame frame){
    	this.frame=frame;
    }      //构造器
	public void actionPerformed(ActionEvent e) {   
			 Vector yeJiColumn;
				try {
					yeJiColumn = YeWuYeJiJDBC.getYeJiData(DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate()),
							DateConventer.dateToStr(frame.getDatePickerTo3().getSelectedDate()),
							(String)frame.getNames1().getSelectedItem());
					//System.out.println(DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate())+
							//DateConventer.dateToStr(frame.getDatePickerTo3().getSelectedDate());
					frame.getYeJiDtm().setDataVector(yeJiColumn,
							AllTableModel.getVectorFromObj(tongJiModel.yeJiNames));
					
					if(yeJiColumn.size() ==0){
						return;
					}
					frame.getYeJiBiao().requestFocus();
					frame.getYeJiBiao().setRowSelectionInterval(0, 0);
					frame.getJiLuShu3().setText("记录数："+frame.getYeJiDtm().getRowCount());
					
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
				}
				
		
	}
}
