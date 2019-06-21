package com.cn.control.kuchunframe.baosunbaoyi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.baosunbaoyi.BaosunBaoyiPutinDatabase;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.mainJFrame.MainFrame;

/**
 * ���������е���Ϣ¼��
 * @author Administrator
 *
 */
public class BaoSunBaoYiShuJuLuRuAction implements ActionListener {
	private BaosunBaoyi dialog;
	public BaoSunBaoYiShuJuLuRuAction(BaosunBaoyi dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		//�����絥¼��
		Vector vo1 = new Vector();
		//(���� , �ֿ���, ����,������, ����Ա,��ע )
		String djlx = dialog.getComboDJLX1().getSelectedItem().toString();//��������
		vo1.add(dialog.getLabelDH().getText().toString());
		vo1.add(dialog.getComboCKMC().getSelectedItem().toString());
		try {
			vo1.add(DateConventer.dateToStr(dialog.getDate1().getSelectedDate(),"yyyy-mm-dd"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		vo1.add(dialog.getComboJBR().getSelectedItem().toString());
		vo1.add(dialog.getFrame().getUser().toString());
		vo1.add(dialog.getTextBZ().getText());
		
		
		//��������Ʒ¼��
		//( ��Ʒ��, ����(FK), ����, �ܽ�� )
		Vector vo2 = new Vector();
		
		int row = dialog.getTableBSBY1().getRowCount();
		for(int i = 0; i < row; i ++){
			Vector ve = new Vector();
			ve.add(dialog.getTableBSBY1().getValueAt(i, 0));
			ve.add(dialog.getLabelDH().getText().toString());
			ve.add(dialog.getTableBSBY1().getValueAt(i, 4));//����
			ve.add(dialog.getTableBSBY1().getValueAt(i, 5));//����
			vo2.add(ve);
		}
		
		//���������ݸ���
		String []nameVo = new String [row];
		String []numVo = new String [row];
		
		for(int i = 0; i < row; i ++){
			nameVo[i] = dialog.getTableBSBY1().getValueAt(i, 0).toString();
			numVo[i] = dialog.getTableBSBY1().getValueAt(i, 5).toString();
		}
		
		BaosunBaoyiPutinDatabase.insertZongDan(vo1, djlx);//¼�뱨�����ܵ�
		BaosunBaoyiPutinDatabase.insertShangPin(vo2, djlx);//¼�뱨������Ʒ
		BaosunBaoyiPutinDatabase.updatas(nameVo, numVo, djlx);//�������ݿ�
		
		dialog.getTableModel1().setDataVector(null, dialog.getVe1());
		dialog.getVector1().removeAllElements();
		dialog.getVector2().removeAllElements();
	}
}
