package com.cn.control.tongjiframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.tongji.YeWuYuanCaiGouTongJi.HuiZongJDBC;
import com.cn.dao.tongji.YeWuYuanCaiGouTongJi.MingXiJDBC;
import com.cn.dao.tongji.YeWuYuanCaiGouTongJi.YeWuYuanCaiGouJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.view.tongjiJFrame.CaiGouTongJiMainFrame;

public class danJuListener implements ActionListener {
	private CaiGouTongJiMainFrame frame;
   public danJuListener(CaiGouTongJiMainFrame frame){
	   this.frame=frame;
   }
   /*
    * ʵ�ּ����������¸�������е�����
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
         Vector CaiGouCloumn;
         Vector HuiZongCloumn;
         Vector MingXiCloumn; //��ѯ���ĸ������������������vector���洢
         try {
			CaiGouCloumn = YeWuYuanCaiGouJDBC.getCaiGouData(DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate()),
						DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate()),
						frame.getYeWuYuanBox().getSelectedItem().toString());
			         frame.getDft1().setDataVector(CaiGouCloumn,
					AllTableModel.getVectorFromObj(tongJiModel.danJuNames));
			         frame.getJiLu().setText("��¼��: "+frame.getDft1().getRowCount());
			        if(CaiGouCloumn.size() ==0){
			        	return;
			        }
			         frame.getDanJuBiao().requestFocus();
			         frame.getDanJuBiao().setRowSelectionInterval(0, 0);
			         frame.getXinXiLabel().setText("��Ϣ����ϸ�б�"+frame.getDft1().getValueAt(frame.getDanJuBiao().getSelectedRow(), 3));
			
			MingXiCloumn = MingXiJDBC.getMingXiData(DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate()),
					DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate()),
					frame.getYeWuYuanBox().getSelectedItem().toString());
		frame.getDft2().setDataVector(MingXiCloumn,
				AllTableModel.getVectorFromObj(tongJiModel.mingXiNames));
		frame.getJiLu1().setText("��¼��: "+frame.getDft2().getRowCount());
		frame.getMingXiBiao().requestFocus();
		frame.getMingXiBiao().setRowSelectionInterval(0, 0);
		
		HuiZongCloumn = HuiZongJDBC.getHuiZongData(DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate()),
				DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate()),
				frame.getYeWuYuanBox().getSelectedItem().toString());
	      frame.getDft3().setDataVector(HuiZongCloumn,
			AllTableModel.getVectorFromObj(tongJiModel.huiZongNames));
	      frame.getPinZhong1().setText("Ʒ�ֺϼ�: "+frame.getDft3().getRowCount());
	      frame.getHuiZongBiao().requestFocus();
	      frame.getHuiZongBiao().setRowSelectionInterval(0, 0); //����һ������Ϊѡ�е���
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
		}
         
	}

}
