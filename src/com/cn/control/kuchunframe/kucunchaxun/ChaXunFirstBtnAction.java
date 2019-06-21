package com.cn.control.kuchunframe.kucunchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.DanQianKuCunJDBC;
import com.cn.dao.toolbar.JDBCDanJuFindGetData;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.model.kuchun.MyTableCellRender;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
import com.cn.view.toolbar.TableCulomnModel;
/*
 * ����ѯ�еĵ�һ������еĲ�ѯ������
 */
public class ChaXunFirstBtnAction implements ActionListener {
	
	KuCunChaXunFrame frame;
	
	public ChaXunFirstBtnAction(KuCunChaXunFrame frame) {
		
		this.frame = frame;
		
	}

	public void actionPerformed(ActionEvent arg0){
		//�ֿ���
		String ckName = frame.getChankuBox().getSelectedItem().toString();
		//��Ʒ���
		String spLbName =frame.getSplb().getSelectedItem().toString();
		//��Ʒ��Ż�����
		String spName =frame.getSpmcfield12().getText().toString().trim();
		//�Ƿ���Ϊ����Ʒ
		boolean isGetO = frame.getIsgetO().isSelected();
		
		Vector data = DanQianKuCunJDBC.getSPBDQKData(ckName,spLbName,spName,isGetO);
		//���ݼ����ģʽ��
		frame.getTableModel().setDataVector(data,
		AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunColumnName1));
		
        MyTableCellRender render = new MyTableCellRender();
		
		//����ÿ�е���Ⱦ��
	    for(int i = 0; i < KuCunKunCBDCulomns.KuCunColumnName1.length; i++) {
	    	frame.getHysxtable1().getColumnModel().getColumn(i).setCellRenderer(render);
	    }
		
	}

}
