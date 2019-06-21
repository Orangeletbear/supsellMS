package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.cn.dao.xiaoshou.guketuihuo.JDBCTuiHuoDanJuFind;
import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.model.xiaoshou.xiaoshoudanjuchaxun.DanJuColumnames;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;

/**
 * �˿��˻��Ի����е�
 * �˿��˻�ѡ��ϲ�ѯ��ť����Ӧ�ļ�����
 * @author Administrator
 *
 */
public class TuiHuoDanJuFindAction implements ActionListener {

private GuKeTuiHuoDialog dialog;
	
	public TuiHuoDanJuFindAction(GuKeTuiHuoDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		String xs_id =dialog.getKeHuText().getText();
		String strDate1 = null;
		String strDate2 = null; 
		
		JDatePicker datePicker1 = dialog.getDataPicker1();
		JDatePicker datePicker2 = dialog.getDataPicker2();
	    
        JLabel label = dialog.getInformation();
     	Vector data = null;
     	Vector data2 = null;
     	
		try {
			strDate1 = DateConventer.dateToStr(datePicker1.getSelectedDate(),"yyyy-MM-dd");
			strDate2 = DateConventer.dateToStr(datePicker2.getSelectedDate(),"yyyy-MM-dd");
			data = JDBCTuiHuoDanJuFind.getData(xs_id,strDate1,strDate2);	

		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
	
		if(data.size() > 0 ){
		dialog.getDanJuModel().setDataVector(data,
				AllTableModel.getVectorFromObj(TuiHuoTabelCulomnModel.QueryColumnNames));
		//���ñ���һ�����ݱ�ѡ��
		dialog.getDanJuTable().requestFocus();
		dialog.getDanJuTable().setRowSelectionInterval(0,0);
		
		//��ʼ״̬����ϸ����ʾ���ܱ�ĵ�һ�����ݵ���Ʒ��Ϣ
		String danHao = (String) dialog.getDanJuModel().getValueAt(0,0);
		label.setText(danHao+"         "+(String) dialog.getDanJuModel().getValueAt(0,2));
		label.setForeground(Color.RED);
		data2 = JDBCTuiHuoDanJuFind.getDate(danHao);	
       
		dialog.getXiangXiModel().setDataVector(data2,
		AllTableModel.getVectorFromObj(TuiHuoTabelCulomnModel.DanJuColumnNames));
		}else{
			label.setText("");
			dialog.getDanJuModel().setDataVector(data,
					AllTableModel.getVectorFromObj(TuiHuoTabelCulomnModel.QueryColumnNames));
			dialog.getXiangXiModel().setDataVector(null,
					AllTableModel.getVectorFromObj(TuiHuoTabelCulomnModel.DanJuColumnNames));
			String message = "û�з��������ļ�¼����ѯʱ��Ϊ��"+strDate1+"��"+strDate2
			+"���ݺ�/�ͻ�����Ϊ"+xs_id;
			JOptionPane.showMessageDialog(dialog, message);
		}
		 
	}


}
