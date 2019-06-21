package com.cn.control.systemframe.sanpingtiaojia;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.system.SanPingTiaoJiJDBC;
import com.cn.dao.toolbar.JDBCDanJuFindGetData;
import com.cn.model.AllTableModel;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.view.systemJFrame.SanpinTiaoJiaJFrame;
import com.cn.view.systemJFrame.shangpingxinxidialog.SPTiaoJiManage;
import com.cn.view.toolbar.TableCulomnModel;
/**
 * �������ʱ
 * @author finey
 *
 */
public class ClientTableMouseAcion extends MouseAdapter {

	private SanpinTiaoJiaJFrame frame;
	public ClientTableMouseAcion(SanpinTiaoJiaJFrame frame) {
		this.frame = frame;
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==1){
			
			String spId = (String) frame.getTableModel().
			         getValueAt(frame.getSptable().getSelectedRow(), 0);
			//�����ݿ���ȡ������
			Vector data = SanPingTiaoJiJDBC.getSPXiaoMassege(spId);
			
			frame.getTableModel2().setDataVector(data,
					AllTableModel.getVectorFromObj(SPTJTableCulomns.ColumnName12));
			
		}
		if(e.getClickCount()==2){
			if(frame.getSptable().getSelectedRowCount()==1){
				new SPTiaoJiManage(frame,"���۹���");
				frame.initDataFromDB();
			}else{
				JOptionPane.showMessageDialog(
						frame, "��ѡ��һ����Ա����");
			}
		}
	} 

}
