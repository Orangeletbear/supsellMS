package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfoDialog;
/**
 * ��Ʒ��Ϣ(�����˻�)
 * �Ի����ϵ�ȷ����ť����Ӧ�ļ�����
 * @author Administrator
 *
 */
public class GoodsInfoSureAction implements ActionListener {

	//������
	private  AddTuiHuoGoodsDialog mainDialog;
	//��ǰ����
	private GoodsInfoDialog dialog;
	
	public GoodsInfoSureAction(AddTuiHuoGoodsDialog mainDialog,GoodsInfoDialog dialog){
		this.mainDialog =mainDialog;
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		
		//���Ҫ���븸�����ұ߱���е�����
		Vector data1 = new Vector();
		
		Vector<String> data = new Vector<String>();
		//������Ʒ����
		data.add(dialog.getGoodName().getText());
		//���뵥λ
		data.add(dialog.getDanWei().getText());
		
		//��� �˻�����
		String tuiJiaString = dialog.getTuiHuoDanJia().getText();
		float tuiJia = 0;
		if(tuiJiaString.matches("\\d+[.]?\\d*")){//�ж� �˻������Ƿ����������ַ���
			data.add(tuiJiaString);
			tuiJia = Float.parseFloat(tuiJiaString);
		}else{//�������֣��˻�������Ϊ0
			data.add("0.00");
		}
		
		//�������
		String shuLiangString = dialog.getShuLiang().getText();
		float shuLiang = 0;
		if(shuLiangString.matches("\\d+")){//�ж�  ���� �Ƿ��ǺϷ�����
			shuLiang = Float.parseFloat(dialog.getShuLiang().getText());
			if(shuLiang == 0){
				JOptionPane.showMessageDialog(dialog,"��������Ϊ0��");
			}else{
				data.add(shuLiangString);
			}
		}else{
			JOptionPane.showMessageDialog(dialog,"��������Ϊ�ջ����������");
		}
		//����ܽ��
		float zje = shuLiang*tuiJia;
		data.add(""+zje);
		
		data1 =mainDialog.getData();
		data1.add(data);
		//System.out.println(data.size() > 0);
		if(data1.size() > 0){
		mainDialog.getSxsp_tableModel().setDataVector(data1,
					AllTableModel.getVectorFromObj(DialogCulomnModel.rightColumnName2));
			mainDialog.getSxsptable().requestFocus();
			mainDialog.getSxsptable().setRowSelectionInterval(0, 0);
				
		}
	
		//����ȷ�Ϻ���ͷŸô���
		dialog.dispose();
		
		
      //���Ҫ��˿��˻�ѡ����з��ص�����
		
		Vector<Object> vector = new Vector<Object>();
		//�����Ʒ���
		vector.add(mainDialog.getSpqd_tableModel().getValueAt(
				 mainDialog.getSpqdtable().getSelectedRow(), 0));
		//�����Ʒ����
		vector.add(dialog.getGoodName().getText());
		//��ӵ�λ
		vector.add(dialog.getDanWei().getText());
		//��ӵ���
		vector.add(tuiJia);
		//�������
		vector.add(shuLiang);
		//����ܽ��
		vector.add(zje);
		
		//��ӹ���ͺ�
		vector.add(mainDialog.getSpqd_tableModel().getValueAt(
				mainDialog.getSpqdtable().getSelectedRow(), 3));
		//�����ɫ
		vector.add(dialog.getColor().getText());
		
		mainDialog.getMainData().add(vector);

		
	 }

}
