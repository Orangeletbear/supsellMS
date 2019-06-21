package com.cn.control.kuchunframe.kucunchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import com.cn.dao.kuchun.DanQianKuCunJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
/**
 * 库存查询里面的商品变动动监听
 * @author Administrator
 *
 */
public class SPBianDongBtnAction implements ActionListener {

	private KuCunChaXunFrame frame;
	
	public SPBianDongBtnAction(KuCunChaXunFrame frame) {
		
		this.frame = frame;
		
	}

	public void actionPerformed(ActionEvent e) {
		//两个起始日期
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = frame.getDatePickerTo1().getSelectedDate();
			toDate = frame.getDatePickerTo2().getSelectedDate();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		//商品编号或名称
		String spName =frame.getMchbhfield21().getText().toString().trim();
		
		Vector data = DanQianKuCunJDBC.getSPBianDongData(fromDate,toDate,spName);
		//数据加入表模式中
		frame.getTableMode2().setDataVector(data,
		AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunColumnName2));
		
	}

}
