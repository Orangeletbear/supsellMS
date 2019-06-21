package com.cn.control.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.toolbar.TadayRemindJDBC;
import com.cn.model.AllTableModel;
import com.cn.view.toolbar.RemaindDialog;
import com.cn.view.toolbar.TableCulomnModel;
/**
 * 今日提醒上的，应收款提醒
 * @author finey
 *
 */
public class TodayYingShouKuanAction implements ActionListener {

	private RemaindDialog frame;
	
	public TodayYingShouKuanAction(RemaindDialog frame) {
		this.frame = frame;
		
	}
	public void actionPerformed(ActionEvent arg0) {
		
		Vector data = TadayRemindJDBC.getYingShouKTXData(
			    frame.getKeHuNamefield().getText().toString(),
			    frame.getBox().getSelectedItem().toString(),
			    frame.getDayNum().getValue().toString());
	   frame.getYiShouTMO().setDataVector(data,
	   AllTableModel.getVectorFromObj(TableCulomnModel.TodayColumnName2));
	}

}
