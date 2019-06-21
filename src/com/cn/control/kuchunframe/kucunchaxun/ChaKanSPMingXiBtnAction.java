package com.cn.control.kuchunframe.kucunchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import com.cn.dao.kuchun.DanQianKuCunJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.kuchunchaxun.ChaKanMingXiDialog;
/**
 * 查看商品明细监听器
 * @author Administrator
 *
 */
public class ChaKanSPMingXiBtnAction implements ActionListener {
	private ChaKanMingXiDialog frame;
	public ChaKanSPMingXiBtnAction(ChaKanMingXiDialog frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		Date dateFrom = null;
		Date dateTo = null;
         try {
			dateFrom = frame.getDateFrom().getSelectedDate();
			dateTo = frame.getDateTo().getSelectedDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}
         
	   String datef = DateConventer.dateToStr(dateFrom, "yyyy-MM-dd");
	   String datet = DateConventer.dateToStr(dateTo, "yyyy-MM-dd");
	   
	   String spId = frame.getSpIdFromP();
	   String ckName = frame.getCanKuBox().getSelectedItem().toString();
        //从数据库中取出数据
	   Vector data = DanQianKuCunJDBC.getSPMingXiData(
			   					datef,datet,spId,ckName);
	   //更新界面数据
		frame.getTableMO().setDataVector(data,
				AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunDeTailFind));  
        frame.getDanJuNum().setText("单据数: "+data.size()); 
         
	}

}
