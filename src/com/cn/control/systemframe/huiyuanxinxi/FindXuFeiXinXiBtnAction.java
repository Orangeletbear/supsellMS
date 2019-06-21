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
 * ��ѯ������Ϣ
 * @author Administrator
 *
 */
public class FindXuFeiXinXiBtnAction implements ActionListener {

	HuiYanGuangLiFrame frame;
	public FindXuFeiXinXiBtnAction(HuiYanGuangLiFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		//������ʼ����
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = frame.getXuFeiDate1().getSelectedDate();
			toDate = frame.getXuFeiDate2().getSelectedDate();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		//��Ʒ��Ż�����
		String hyId =frame.getDjfield2().getText();
		String dateFrom = DateConventer.dateToStr(fromDate, "yyyy-MM-dd");
		String dateTo= DateConventer.dateToStr(toDate, "yyyy-MM-dd");
		
		Vector data = HuiYuanXinGLJDBC.getHuiYuanXuFei(dateFrom, dateTo, hyId);
		//���ݼ����ģʽ��
		frame.getHyXuFeiTM().setDataVector(data,
		AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName2));
	}

}
