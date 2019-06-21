package com.cn.control.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.toolbar.JDBCDanJuFindGetData;
import com.cn.dao.toolbar.TadayRemindJDBC;
import com.cn.model.AllTableModel;
import com.cn.view.toolbar.RemaindDialog;
import com.cn.view.toolbar.TableCulomnModel;
/*
 * 今晶提醒中的库存报警提醒上的查询寻按钮监听器
 * 当库存小于一定数量时提醒( 默认为0 )
 */
public class TadayKuCunBaoJinBtnAction implements ActionListener {
	
	private RemaindDialog frame;
	
	public TadayKuCunBaoJinBtnAction(RemaindDialog frame) {
		this.frame = frame;
		
	}

	public void actionPerformed(ActionEvent arg0) {
	
		Vector data = TadayRemindJDBC.getCuCunBJData(
				    frame.getSpNamefield().getText().toString());
		frame.getKuCunBJtableMO().setDataVector(data,
		AllTableModel.getVectorFromObj(TableCulomnModel.TodayColumnName1));
		
	}

}
