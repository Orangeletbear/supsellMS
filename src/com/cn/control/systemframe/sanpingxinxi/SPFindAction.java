package com.cn.control.systemframe.sanpingxinxi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.TableCellRenderer;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.MyTableCellRender;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
/**
 * ��Ʒ��Ϣ�µĲ�ѯ������
 * @author finey
 *
 */
public class SPFindAction implements ActionListener {
	private ShangPingGuangLiFrame frame;
	
	public SPFindAction(ShangPingGuangLiFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		
		String lbName = frame.getTree().
					getLastSelectedPathComponent().toString().trim();
		String spName = frame.getSpbhfield().getText().toString().trim();
		//�����ݿ�ȡ������
		System.out.println(lbName+"   "+ spName);
        Vector data = SanPingGuanLiJDBC.getSPBaseMassege(lbName, spName);
        //���½�������
        frame.getTableModel().setDataVector(data,
    		   AllTableModel.getVectorFromObj(SPTJTableCulomns.SPTLColumnName));
       //������Ⱦ������
	    TableCellRenderer cellRenderer = new MyTableCellRender();
		//����ÿ�е���Ⱦ��
	    for(int i = 0; i < SPTJTableCulomns.SPTLColumnName.length; i++) {
	    	frame.getSptable().getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
	    }
	}

}
