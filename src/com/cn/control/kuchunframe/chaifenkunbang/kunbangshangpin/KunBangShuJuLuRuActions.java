package com.cn.control.kuchunframe.chaifenkunbang.kunbangshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import com.cn.dao.kuchun.chaifenkunbang.chafenshangpin.ChaiFenShangPinPutinDatabase;
import com.cn.dao.kuchun.chaifenkunbang.kunbangshangpin.KunBangShangPinPutinDatabase;
import com.cn.util.DateConventer;
import com.cn.view.kuchunJFrame.ChaifenKunbang;

/**
 * ������Ʒ����¼�룬������Ʒ���
 * @author Administrator
 *
 */
public class KunBangShuJuLuRuActions implements ActionListener{
	
	private ChaifenKunbang dialog;
	
	public KunBangShuJuLuRuActions(ChaifenKunbang dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		//����¼��
		//( ���󵥺� , �����, ����,�������Ʒ, �������, ������, ����Ա, ��ע )
		Vector vo1 = new Vector();
		vo1.add(dialog.getLabelKBDH().getText());
		vo1.add(dialog.getComboKBCK().getSelectedItem().toString());
		try {
			vo1.add(DateConventer.dateToStr(dialog.getDate2().getSelectedDate(),"yyyy-mm-dd"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		vo1.add(dialog.getLabelKBSP().getText());
		vo1.add(dialog.getTextKBSL().getText());
		vo1.add(dialog.getComboJBR2().getSelectedItem().toString());
		vo1.add(dialog.getFrame().getUser());//����Ա
		vo1.add(dialog.getTextBZ2().getText());
		
		
		//�����Ʒ¼��
		//( ��Ʒ��, ����(FK), ����, �ܽ�� )
		Vector vo2 = new Vector();
		int row = dialog.getTableKB().getRowCount();
		for(int i = 0; i < row; i ++){
			Vector ve = new Vector();
			ve.add(dialog.getTableKB().getValueAt(i, 0));
			ve.add(dialog.getLabelKBDH().getText().toString());
			ve.add(dialog.getTableKB().getValueAt(i, 5));//����
			ve.add(dialog.getTableKB().getValueAt(i, 6));//���
			vo2.add(ve);
		}
		
		//���������ݸ���
		//������Ʒ����
		String bcmc = dialog.getLabelKBSP().getText();
		String bcsl = dialog.getTextKBSL().getText().trim();
		
		//����ɵ���Ʒ��������
		String []nameVo = new String [row];
		String []numVo = new String [row];
		for(int i = 0; i < row; i ++){
			nameVo[i] = dialog.getTableKB().getValueAt(i, 0).toString();
			numVo[i] = dialog.getTableKB().getValueAt(i, 5).toString();
		}
		
		
		KunBangShangPinPutinDatabase.putinKunbangZongdan(vo1);//�����ܵ�¼��
		KunBangShangPinPutinDatabase.putinKunbangXiangbiao(vo2);//������Ʒ¼��
		KunBangShangPinPutinDatabase.updatas1(bcmc, bcsl);//������ɵ���Ʒ����
		KunBangShangPinPutinDatabase.updatas2(nameVo, numVo);//���������Ʒ����
		
		//��������ÿ�
		dialog.getTableModelKB().setDataVector(null, dialog.getVe2());
		//�洢���ݵ�vector�ÿ�
		dialog.getVector2().removeAllElements();
	}
	
	
}
