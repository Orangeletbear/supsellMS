package com.cn.control.systemframe.huiyuanxinxi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import com.cn.dao.kuchun.DanQianKuCunJDBC;
import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.util.DateConventer;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
/**
 * 查询续费信息
 * @author Administrator
 *
 */
public class FindXuFeiXinXiBtnAction implements ActionListener {

	HuiYanGuangLiFrame frame;
	public FindXuFeiXinXiBtnAction(HuiYanGuangLiFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		//两个起始日期
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = frame.getXuFeiDate1().getSelectedDate();
			toDate = frame.getXuFeiDate2().getSelectedDate();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		//商品编号或名称
		String hyId =frame.getDjfield2().getText();
		String dateFrom = DateConventer.dateToStr(fromDate, "yyyy-MM-dd");
		String dateTo= DateConventer.dateToStr(toDate, "yyyy-MM-dd");
		
		Vector data = HuiYuanXinGLJDBC.getHuiYuanXuFei(dateFrom, dateTo, hyId);
		//数据加入表模式中
		frame.getHyXuFeiTM().setDataVector(data,
		AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName2));
	}

}
