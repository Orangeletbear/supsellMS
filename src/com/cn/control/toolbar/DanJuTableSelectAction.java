package com.cn.control.toolbar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.cn.dao.toolbar.JDBCDanJuFindGetData;
import com.cn.model.AllTableModel;
import com.cn.view.toolbar.DanJuFindDialog;
import com.cn.view.toolbar.TableCulomnModel;
/*
 *���ݲ�ѯ�µ�ѡһ���������ʱ�����������ϸ�б�����ʾ��ϸ��Ϣ
 */
public class DanJuTableSelectAction extends MouseAdapter {
	
	private DanJuFindDialog frame;

	
	public DanJuTableSelectAction(DanJuFindDialog frame) {
		this.frame = frame;
		
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==1){
			String danJuNum = (String) frame.getTabelModel().
			         getValueAt(frame.getTable().getSelectedRow(), 0);
			Vector data = JDBCDanJuFindGetData.getDetailData(danJuNum);
			frame.getTabelModel1().setDataVector(data,
					AllTableModel.getVectorFromObj(TableCulomnModel.DangJuFindColumnName1));
			
		}
	} 
}
