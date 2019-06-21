package com.cn.control.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.toolbar.TadayRemindJDBC;
import com.cn.model.AllTableModel;
import com.cn.view.toolbar.RemaindDialog;
import com.cn.view.toolbar.TableCulomnModel;
/*
 * 今日提醒上的，商品过期提醒
 */
public class TodayPassDateAction implements ActionListener {
	
	private RemaindDialog frame;
	
	public TodayPassDateAction(RemaindDialog frame) {
		
		this.frame = frame;
		
	}

	public void actionPerformed(ActionEvent arg0) {
	   Vector data = TadayRemindJDBC.getPassData(
			    frame.getSpNafield().getText().toString(),
			    frame.getComBox().getSelectedItem().toString(),
			    frame.getSpDayNum().getValue().toString());
	   frame.getGuoQiMO().setDataVector(data,
	   AllTableModel.getVectorFromObj(TableCulomnModel.TodayColumnName3));
	}

}
