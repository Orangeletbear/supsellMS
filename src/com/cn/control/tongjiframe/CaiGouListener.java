package com.cn.control.tongjiframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.CaiGouJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.ShangPingCaiGouMainFrame;
   
public class CaiGouListener implements ActionListener{
	ShangPingCaiGouMainFrame cg;   //主界面参数
    public CaiGouListener(ShangPingCaiGouMainFrame cg){
    	this.cg=cg;
    }      //构造器
	public void actionPerformed(ActionEvent e) {   
			 Vector mingXiColumn;
			 Vector huiZongColumn;
			 Vector tongJiColumn;
			
				try {
					mingXiColumn = CaiGouJDBC.getMingXiData(DateConventer.dateToStr(cg.getDatePickerTo().getSelectedDate()),
							DateConventer.dateToStr(cg.getDatePickerTo2().getSelectedDate()),
							cg.getShangPinText().getSelectedItem().toString(),cg.getShangPinNameText().getText());
					cg.getDtm().setDataVector(mingXiColumn,
							AllTableModel.getVectorFromObj(tongJiModel.tableNames));
					cg.getJiLu().setText("记录数："+mingXiColumn.size());
					if(mingXiColumn.size() == 0){
						return;
					}
					
					cg.getShangPinTable().requestFocus();
					cg.getShangPinTable().setRowSelectionInterval(0, 0);
					
					huiZongColumn = CaiGouJDBC.getHuiZongData(DateConventer.dateToStr(cg.getDatePickerTo().getSelectedDate()),
						DateConventer.dateToStr(cg.getDatePickerTo2().getSelectedDate()),
							cg.getShangPinText().getSelectedItem().toString(),cg.getShangPinNameText().getText());
					cg.getDtm2().setDataVector(huiZongColumn,
						AllTableModel.getVectorFromObj(tongJiModel.huiZongName));
					cg.getShangPinShu().setText("商品数："+huiZongColumn.size());
					cg.getHuiZongTable().requestFocus();
					cg.getHuiZongTable().setRowSelectionInterval(0, 0);
					
					tongJiColumn = CaiGouJDBC.getTongJiData(DateConventer.dateToStr(cg.getDatePickerTo().getSelectedDate()),
							DateConventer.dateToStr(cg.getDatePickerTo2().getSelectedDate()),
								cg.getShangPinText().getSelectedItem().toString(),cg.getShangPinNameText().getText());
						cg.getDtm3().setDataVector(tongJiColumn,
							AllTableModel.getVectorFromObj(tongJiModel.tongJiName));
						cg.getJiLu1().setText("记录数："+tongJiColumn.size());
						cg.getTongJiTable().requestFocus();
						cg.getTongJiTable().setRowSelectionInterval(0, 0);
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
				}
				
		
	}
}
