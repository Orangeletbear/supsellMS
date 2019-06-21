package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

/**
 * ����Ʒ��Ϣ��ʾ���ϵ���Ϣȷ������ӵ���ѡ�����
 * Ӧ��Ҫ���������������޸ģ�������
 * @author Administrator
 *
 */
public class TanChuXinXiOKAction implements ActionListener {
	private AddShangPinXinXiDialog dialog;
	private Vector<String>vo = new Vector<String>();
	public TanChuXinXiOKAction(AddShangPinXinXiDialog dialog){
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		/*
		 * Ϊ1ʱ��Ϊ�޸���Ʒ��Ϣ
		 */
		if(dialog.getFlag()==1){
			int row = dialog.getDialog().getSxsptable().getSelectedRow();
			if(row >= 0){
					dialog.getDialog().getTableModel3().setValueAt(dialog.getTextDBSL().getText(),row, 5);
					String dbNum = dialog.getTextDBSL().getText().toString();
					int db = Integer.valueOf(dbNum);
					String djNum = dialog.getLabelCBDJ().getText().toString();
					float dj = Float.valueOf(djNum);
					dialog.getDialog().getTableModel3().setValueAt(db * dj,row, 6);
			}
		}else{
			actions();
			dialog.getDialog().getTableModel3().setDataVector(dialog.getDialog().getVo3(),dialog.getDialog().getVe3());
//			dialog.getDialog().getSxsptable().setRowSelectionInterval(0, 0);
		}
		dialog.dispose();
	}
	
	private void actions(){
		String kcNum = dialog.getLabelDQKC().getText().toString();
		int kc = Integer.valueOf(kcNum);
		String dbNum = dialog.getTextDBSL().getText().toString();
		int db = Integer.valueOf(dbNum);
		String djNum = dialog.getLabelCBDJ().getText().toString();
		float dj = Float.valueOf(djNum);
		
		if(kc > 0 && db > 0){
			if(kc >= db){
				vo.add(dialog.getLabelSPMC().getText());
				vo.add(dialog.getLabelDW().getText().toString());
				vo.add(dialog.getLabelGGXH().getText());
				vo.add(dialog.getLabelYS().getText());
				vo.add(dialog.getLabelCBDJ().getText());
				vo.add(dialog.getTextDBSL().getText());
				vo.add("" + db * dj);
				
				dialog.getDialog().getVo3().add(vo);
			}else {
				JOptionPane.showMessageDialog(null, "�����������̫��,���������룡");
			}
		} else if(kc <= 0){
			JOptionPane.showMessageDialog(null, "��治�����뾡����вɹ���");
		}else if(db <= 0){
			JOptionPane.showMessageDialog(null, "ѡ����Ʒ��������Ϊ��!");
		}
		
	}
}
