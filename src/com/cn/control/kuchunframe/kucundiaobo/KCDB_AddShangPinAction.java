package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * 
 * �����Ʒ��ť�ļ�����
 * ͨ��ѡ��ֿ���ɸѡ��ͬ�ֿ��е���Ʒ��Ϣ
 * ����������
 * @author Administrator
 *
 */
public class KCDB_AddShangPinAction implements ActionListener {
	private KucunDiaobo dialog;
	
	public KCDB_AddShangPinAction(KucunDiaobo dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = dialog.getComboDCCK().getSelectedItem().toString().trim();
		String name1 = dialog.getComboDRCK().getSelectedItem().toString().trim();
		if(name.equals(name1)){
			JOptionPane.showMessageDialog(null, "����������ֿ�����ͬ��");
		} else{
			new AddSanPingDialog(dialog,"������Ʒ(������)",name);
		}
	}
}
