package com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.xiaoshoudanjuchaxun.DanJuColumnames;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;

public class DanJuFindAction implements ActionListener {

	private DanJuChaXunDialog dialog;
	
	public DanJuFindAction(DanJuChaXunDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		String xs_id =dialog.getPanel_center_keHuText().getText();
		String strDate1 = null;
		String strDate2 = null; 
		
		JDatePicker datePicker1 = dialog.getPanel_center_chaXunShiJian();
		JDatePicker datePicker2 = dialog.getPanel_center_zhi();
	    
 
     	Vector data = null;
     	Vector data2 = null;
     	JLabel label = dialog.getShangPinMingXiLabel();
		try {
			strDate1 = DateConventer.dateToStr(datePicker1.getSelectedDate(),"yyyy-MM-dd");
			strDate2 = DateConventer.dateToStr(datePicker2.getSelectedDate(),"yyyy-MM-dd");
			data = JDBCDanJuFind.getData(xs_id,strDate1,strDate2);	

		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
	
		if(data.size() > 0 ){
		dialog.getTabelModel().setDataVector(data,
				AllTableModel.getVectorFromObj(DanJuColumnames.zongBiaoColumnames));
		//���ñ���һ�����ݱ�ѡ��
		dialog.getHuiZongTable().requestFocus();
		dialog.getHuiZongTable().setRowSelectionInterval(0,0);
		
		//��ʼ״̬����ϸ����ʾ���ܱ�ĵ�һ�����ݵ���Ʒ��Ϣ
		String danHao = (String) dialog.getTabelModel().getValueAt(0,0);
		
		label.setText(danHao+"         "+(String) dialog.getTabelModel().getValueAt(0,2));
		label.setForeground(Color.RED);
		data2 = JDBCDanJuFind.getDate(danHao);	

		dialog.getTabelModel2().setDataVector(data2,
		AllTableModel.getVectorFromObj(DanJuColumnames.mingXiBiaoColumnames));
		}else{
			label.setText("");
			dialog.getTabelModel().setDataVector(data,
					AllTableModel.getVectorFromObj(DanJuColumnames.zongBiaoColumnames));
			dialog.getTabelModel2().setDataVector(null,
					AllTableModel.getVectorFromObj(DanJuColumnames.mingXiBiaoColumnames));
			String message = "û�з��������ļ�¼����ѯʱ��Ϊ��"+strDate1+"��"+strDate2
			+"���ݺ�/�ͻ�����Ϊ"+xs_id;
			JOptionPane.showMessageDialog(dialog, message);
		}
		 
	}

}
