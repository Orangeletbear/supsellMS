package com.cn.control.kuchunframe.kucunpandian;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.cn.dao.kuchun.kucunpandian.KucunPandianPutinDatabase;
import com.cn.dao.kuchun.kucunpandian.KunCunPanDianChaXunGetDatas;
import com.cn.view.kuchunJFrame.kucunpandian.PanYingPanKuiJDialog;

public class ShowCardAction implements ActionListener {
	private PanYingPanKuiJDialog dialog;
	private static int i = 0;
	public ShowCardAction(PanYingPanKuiJDialog dialog) {
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		CardLayout layout = dialog.getCardlayout();
		JPanel cardPane = dialog.getCenJpanel();
		JButton btn = (JButton)e.getSource();
		//���ڵ���2ʱ��һ����ť��Ч
		if(i < 2){
			if(btn == dialog.getBtnNext()){
				i ++;
				if(i > 2){
					i = 0;
				}
				layout.next(cardPane);
			}
		}
		////С��0ʱ��һ����ť��Ч
		if(i > 0){
			if(btn == dialog.getBtnLast()){
				i --;
				if(i < 0){
					i = 2;
				}
				layout.previous(cardPane);
			}
		}
		
		//��ʼ����һ������
		if( i == 0){
			
//			System.out.println(i + "����һ����ʼ��");
			
		}
		
		//�ڶ����������ݽ���
		if(i == 1){
			/*
			 * ����һ���еı���ÿ�
			 */
//			dialog.getTablemodel1().setDataVector(null, dialog.getVe1());
			
			Vector vo = KunCunPanDianChaXunGetDatas.allShangPinChaXun();
			dialog.getTablemodel2().setDataVector(vo, dialog.getVe2());
			dialog.getLabelJLS1().setText("��ѡ����" + vo.size() + "�̵㵥");
			
//			System.out.println(i + "���������ʼ��");
		}
		
		//����������
		if(i == 2){
			
			int row = dialog.getTable2().getRowCount();
			String []str = new String[row];
			for(int i = 0; i < row; i ++){
				str[i] = dialog.getTable2().getValueAt(i, 0).toString();
			}
			
			Vector vo = KunCunPanDianChaXunGetDatas.compareShangPinChaXun(str);
			dialog.getTablemodel3().setDataVector(vo, dialog.getVe3());
			dialog.getLabelJLS2().setText("" + vo.size());
			/*
			 * ���ڶ����еı�����
			 */
//			dialog.getTablemodel2().setDataVector(null, dialog.getVe2());
//			System.out.println(i + "����������ʼ��");
		}
		
		//�������
		if(btn == dialog.getBtnXZ()){
			////////////��ȡ���е�����
			if(i == 2){
				JTable table = dialog.getTable3();
				int row = table.getRowCount();
				int column = table.getColumnCount();
				Vector vo = new Vector();
				for(int i = 0; i < row; i ++){
						Vector tmp = new Vector();
						tmp.add(table.getValueAt(i, 0));
						tmp.add(table.getValueAt(i, 4));
						vo.add(tmp);
				}
				//////////////���¿��
				int choice = JOptionPane.showConfirmDialog(null,"���������ݲ��ָܻ������ȱ������ݿ⣡ȷ��Ҫ�޸��̵��е���Ʒ�Ŀ����",
							"������Ʒ���",JOptionPane.YES_NO_OPTION,1);
				if(choice == JOptionPane.YES_OPTION){
					KucunPandianPutinDatabase.updateKucun(vo);
					/*
					 * �����̵㵥��Ϣ
					 * �����̵���Ʒ��Ϣ
					 */
					KunCunPanDianChaXunGetDatas.clearPanDianShangPin();
					/*
					 * �̵㵥����ֱ�����,��Ϊ�и���ʷ��ѯ
					 * ����ȱ�� ���̵���δ�̵�ı�־,�̵�ʱ�޷�����
					 * 
					 * �������̵㵥�ϵ���Ʒ�Ѿ��̵��ÿ���
					 */
					
//					KunCunPanDianChaXunGetDatas.clearPanDianDan();
					KunCunPanDianChaXunGetDatas.clearPanDianBiaoZhi();
					
					dialog.getTablemodel3().setDataVector(null, dialog.getVe3());
				}
			}
		}
	}
}
