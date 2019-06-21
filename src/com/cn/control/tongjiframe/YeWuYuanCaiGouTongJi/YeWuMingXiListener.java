package com.cn.control.tongjiframe.YeWuYuanCaiGouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.YeWuYuanXiaoShouTongJi.YeWuYuanMingXiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.YeWuYuanMainFrame;
   
public class YeWuMingXiListener implements ActionListener{
	YeWuYuanMainFrame frame;   //主界面参数
    public YeWuMingXiListener(YeWuYuanMainFrame frame){
    	this.frame=frame;
    }      //构造器
	public void actionPerformed(ActionEvent e) {   
			 Vector mingXiColumn;
				try {
					mingXiColumn = YeWuYuanMingXiJDBC.getMingXiData(DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate()),
							DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate()),
							(String)frame.getNames().getSelectedItem());
					frame.getXiaoShouDtm().setDataVector(mingXiColumn,
							AllTableModel.getVectorFromObj(tongJiModel.xiaoShouNames));
					if(mingXiColumn.size() ==0){
						return;
					}
					frame.getXiaoShouBiao().requestFocus();
					frame.getXiaoShouBiao().setRowSelectionInterval(0, 0);
					frame.getDanJuShu().setText("单据数: "+frame.getXiaoShouDtm().getRowCount());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
				}
				
		
	}
}
