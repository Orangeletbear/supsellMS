package com.cn.control.kuchunframe.chaifenkunbang.chaifenshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.chaifenkunbang.chafenshangpin.ChaiFenShangPinPutinDatabase;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

public class ChaiFenShuJuLuRuActions implements ActionListener{
	private ChaifenKunbang dialog;
	public ChaiFenShuJuLuRuActions(ChaifenKunbang dialog) {
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		//��ֵ�¼��
		//( ��ֵ��� , ��ֿ�, ����, ������Ʒ���, �������, ������, ����Ա,��ע )
		Vector vo1 = new Vector();
		vo1.add(dialog.getLabelCFDH().getText());
		vo1.add(dialog.getComboCFCK().getSelectedItem().toString());
		try {
			vo1.add(DateConventer.dateToStr(dialog.getDate1().getSelectedDate(),"yyyy-mm-dd"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		vo1.add(dialog.getLabelBCSPMC1().getText());
		vo1.add(dialog.getTextCFSL().getText());
		vo1.add(dialog.getComboJBR1().getSelectedItem().toString());
		vo1.add(dialog.getFrame().getUser());//����Ա
		vo1.add(dialog.getTextBZ1().getText());
		
		
		//�����Ʒ¼��
		//( ��Ʒ��, ����(FK), ����, �ܽ�� )
		Vector vo2 = new Vector();
		int row = dialog.getTableCF().getRowCount();
		for(int i = 0; i < row; i ++){
			Vector ve = new Vector();
			ve.add(dialog.getTableCF().getValueAt(i, 0));
			ve.add(dialog.getLabelCFDH().getText().toString());
			ve.add(dialog.getTableCF().getValueAt(i, 5));//����
			ve.add(dialog.getTableCF().getValueAt(i, 6));//���
			vo2.add(ve);
		}
		
		//���������ݸ���
		//������Ʒ����
		String bcmc = dialog.getLabelBCSPMC1().getText();
		String bcsl = dialog.getTextCFSL().getText().trim();
		
		//����ɵ���Ʒ��������
		String []nameVo = new String [row];
		String []numVo = new String [row];
		for(int i = 0; i < row; i ++){
			nameVo[i] = dialog.getTableCF().getValueAt(i, 0).toString();
			numVo[i] = dialog.getTableCF().getValueAt(i, 5).toString();
		}
		
		
		ChaiFenShangPinPutinDatabase.putinChaifenZongdan(vo1);//����ܵ�¼��
		ChaiFenShangPinPutinDatabase.putinChaifenXiangbiao(vo2);//�����Ʒ¼��
		ChaiFenShangPinPutinDatabase.updatas1(bcmc, bcsl);//��ֵ���Ʒ����
		ChaiFenShangPinPutinDatabase.updatas2(nameVo, numVo);//����ɵ���Ʒ����
		
		//����������ÿ�
		dialog.getTableModelCF().setDataVector(null, dialog.getVe1());
		//�洢���ݵ�vector�ÿ�
		dialog.getVector1().removeAllElements();
		}
}
