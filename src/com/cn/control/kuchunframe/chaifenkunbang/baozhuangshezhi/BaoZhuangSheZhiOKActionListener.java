package com.cn.control.kuchunframe.chaifenkunbang.baozhuangshezhi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.chaifenkunbang.BaozhuangShezhiJDialog;

public class BaoZhuangSheZhiOKActionListener implements ActionListener {
	private BaozhuangShezhiJDialog dialog;
	public BaoZhuangSheZhiOKActionListener(BaozhuangShezhiJDialog dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		/*
		 * ���Ӱ�װ��Ϣ
		 */
		if(dialog.getFlag().equals("0")){

			//�ж��Ƿ���ڿ�ֵ
			for(String tmp: actions()){
				if(tmp.length() == 0){
					JOptionPane.showMessageDialog(null, "���ӵ���Ϣ����Ϊ��ֵ��");
					break;
				}
			}
			dialog.getDialog().getVo3().add(actions());
			dialog.getDialog().getTableModelBZ().setDataVector(dialog.getDialog().getVo3(),
					dialog.getDialog().getVe3());
			dialog.getDialog().getLabelHJ3().setText("" + dialog.getDialog().getVo3().size());
		}
		
		/*
		 * �޸İ�װ����
		 */
		if(dialog.getFlag().equals("1")){
			///////------------------------�������ֵ���䵽���������
			Vector vo = new Vector();
			//�ж��Ƿ���ڿ�ֵ
				if(dialog.getTextZFBL().toString().trim().length()>=0){
					int row = dialog.getDialog().getTableBZ().getSelectedRow();
					dialog.getDialog().getTableBZ().setValueAt(dialog.getTextZFBL().getText().toString(), row, 4);
				}else{
					JOptionPane.showMessageDialog(null, "���ӵ���Ϣ����Ϊ��ֵ��");
				}

			dialog.setVisible(true);
		}
		
		dialog.dispose();;
	}
	
	
	private Vector <String> actions(){
		Vector<String> vo = new Vector<String>();
		
		vo.add(dialog.getTextSPBH1().getText().trim());
		vo.add(dialog.getLabelSPName1().getText().trim());
		vo.add(dialog.getLabelDW1().getText().trim());
		vo.add(dialog.getComboSZCK1().getSelectedItem().toString().trim());
		vo.add(dialog.getTextZFBL().getText().trim());

		vo.add(dialog.getTextSPBH2().getText().trim());
		vo.add(dialog.getLabelSPName2().getText().trim());
		vo.add(dialog.getLabelDW2().getText().trim());
		vo.add(dialog.getComboSZCK2().getSelectedItem().toString().trim());
//		vo.add(dialog.getDialog().getFrame().getUser().trim());
		vo.add("cp");//ֻ���ڲ���
		
		return vo;
	}
}
