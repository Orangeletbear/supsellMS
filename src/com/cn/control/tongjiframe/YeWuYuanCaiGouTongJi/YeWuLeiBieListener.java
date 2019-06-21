package com.cn.control.tongjiframe.YeWuYuanCaiGouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.YeWuYuanXiaoShouTongJi.YeWuLeiBieJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.YeWuYuanMainFrame;
   
public class YeWuLeiBieListener implements ActionListener{
	YeWuYuanMainFrame frame;   //主界面参数
    public YeWuLeiBieListener(YeWuYuanMainFrame frame){
    	this.frame=frame;
    }      //构造器
	public void actionPerformed(ActionEvent e) {   
			 Vector leiBieColumn;
				try {
					leiBieColumn = YeWuLeiBieJDBC.getLeiBieData(DateConventer.dateToStr(frame.getDatePickerTo4().getSelectedDate()),
							DateConventer.dateToStr(frame.getDatePickerTo5().getSelectedDate()),
							frame.getShangPinLeiBie().getSelectedItem().toString(),
							(String)frame.getNames2().getSelectedItem());
					frame.getLeiBieDtm().setDataVector(leiBieColumn,
							AllTableModel.getVectorFromObj(tongJiModel.leiBieNames));
					if(leiBieColumn.size() ==0){
						return;
					}
					frame.getLeiBieBiao().requestFocus();
					frame.getLeiBieBiao().setRowSelectionInterval(0, 0);
					frame.getJiLuShu4().setText("记录数："+frame.getLeiBieDtm().getRowCount());
				} catch (ParseException e1) {
					
				}
				
		
	}
}
