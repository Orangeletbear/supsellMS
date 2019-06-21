package com.cn.control.tongjiframe.ShangPinXiaoShouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.ShangPinXiaoShouTongJi.XiaoShouMingXiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.GoodsXiaoShouTongJi;
   
public class XiaoShouMingXiListener implements ActionListener{
	GoodsXiaoShouTongJi frame;   //主界面参数
    public XiaoShouMingXiListener(GoodsXiaoShouTongJi frame){
    	this.frame=frame;
    }      //构造器
	public void actionPerformed(ActionEvent e) {   
			 Vector mingXiColumn;
			 Vector huiZongColumn;
			 Vector tongJiColumn;
			
				try {
					mingXiColumn = XiaoShouMingXiJDBC.getXiaoShouMingXiData(DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate()),
							DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate()),
							frame.getShangPinText().getSelectedItem().toString(),frame.getShangPinNameText().getText());
					//System.out.println("Df"+frame.getShangPinText().getText()+"jdf"+frame.getShangPinNameText().getText());
					//System.out.println(DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate())+
							//DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate()));
					frame.getDtm1().setDataVector(mingXiColumn,
							AllTableModel.getVectorFromObj(tongJiModel.dtm1Names));
					frame.getJiLu().setText("记录数: "+frame.getDtm1().getRowCount());
					
					huiZongColumn = XiaoShouMingXiJDBC.getXiaoShouHuiZongData(DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate()),
						DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate()),
						frame.getShangPinText().getSelectedItem().toString(),frame.getShangPinNameText().getText());
					frame.getDtm2().setDataVector(huiZongColumn,
						AllTableModel.getVectorFromObj(tongJiModel.dtm2Names));
					
					tongJiColumn = XiaoShouMingXiJDBC.getXiaoShouTongJiData(DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate()),
							DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate()),
							frame.getShangPinText().getSelectedItem().toString(),frame.getShangPinNameText().getText());
					frame.getDtm3().setDataVector(tongJiColumn,
							AllTableModel.getVectorFromObj(tongJiModel.dtm3Names));
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		
	}
}
