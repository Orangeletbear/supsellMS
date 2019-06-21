package com.cn.control.systemframe.huiyuanxinxi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.util.DateConventer;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
/**
 * 查出会员消费信息
 * @author finey
 *
 */
public class FindHYXiaoFeiAction implements ActionListener {
	private HuiYanGuangLiFrame frame;
	
	public FindHYXiaoFeiAction(HuiYanGuangLiFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
          String dateFrom = null;
          String dateTo = null;
          String hyID = frame.getHyIDfield3().getText();
          try {
			dateFrom = DateConventer.dateToStr(
					  frame.getXiaoFeiDate1().getSelectedDate(), "yyyy-MM-dd");
			dateTo = DateConventer.dateToStr(
					  frame.getXiaoFeiDate2().getSelectedDate(), "yyyy-MM-dd");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		Vector data = HuiYuanXinGLJDBC.getHuiYuanXiaoFeiXinXi(dateFrom, dateTo, hyID);
 		//数据加入表模式中
 		frame.getHyXiaoFenTM().setDataVector(data,
 		AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName31));
 		
		
          
	}

}
