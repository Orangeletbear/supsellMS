package com.cn.control.tongjiframe.ShangPinXiaoShouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.ShangPinXiaoShouTongJi.GongHuoJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.GoodsXiaoShouTongJi;
   
public class GongHuoListener implements ActionListener{
	GoodsXiaoShouTongJi frame;   //主界面参数
    public GongHuoListener(GoodsXiaoShouTongJi frame){
    	this.frame=frame;
    }      //构造器
	public void actionPerformed(ActionEvent e) {   
			 Vector gongHuoColumn;
			
			
				try {
					gongHuoColumn = GongHuoJDBC.getGongHuoData(DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate()),
							DateConventer.dateToStr(frame.getDatePickerTo3().getSelectedDate()),
							frame.getShangPinText1().getSelectedItem().toString(),frame.getGongHuoText().getText());
					//System.out.println("Df"+frame.getShangPinText().getText()+"jdf"+frame.getShangPinNameText().getText());
					//System.out.println(DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate())+
							DateConventer.dateToStr(frame.getDatePickerTo3().getSelectedDate());
					frame.getDtm4().setDataVector(gongHuoColumn,
							AllTableModel.getVectorFromObj(tongJiModel.dtm4Names));
					if(gongHuoColumn.size() ==0){
						return;
					}
					frame.getGongHuoBiao().requestFocus();
					frame.getGongHuoBiao().setRowSelectionInterval(0, 0);
					frame.getJiLu1().setText("记录数: "+frame.getDtm4().getRowCount());
					
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
				}
				
		
	}
}
