package com.cn.control.systemframe.huiyuanxinxi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
import com.cn.view.systemJFrame.huiyuanguanli.HuiYuanTableCellRender;
/**
 * ��Ա��������
 * @author finey
 *
 */
public class HYJiFenQingLingAction implements ActionListener {
	
	
	HuiYanGuangLiFrame frame;
	public HYJiFenQingLingAction( HuiYanGuangLiFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		 int choice =  JOptionPane.showConfirmDialog(
	        		frame, "�Ƿ񽫸û�Ա��������","����",
	        		 JOptionPane.YES_NO_OPTION, 1);
          //��ȷ��ɾ������
	     if(choice == JOptionPane.YES_OPTION){
	    	 int row = frame.getHyXinXiT().getSelectedRow();
	         String hyid = frame.getHyXinXiTM().getValueAt(row, 0).toString();
	         
	         HuiYuanXinGLJDBC.huiYuanJiFenSetO(hyid);
	         
	         
	         Vector data = HuiYuanXinGLJDBC.getHuiYuanBaseM("");
	         //���½�������
	         frame.getHyXinXiTM().setDataVector(data,
	     		   AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName11));
	         
	         JButton bi = (JButton) arg0.getSource();
	         
	         //����ÿ�е���Ⱦ��
	         HuiYuanTableCellRender render = new HuiYuanTableCellRender();
	 		
	 		
	 	    for(int i = 0; i < KuCunKunCBDCulomns.KuCunColumnName1.length; i++) {
	 	    	frame.getHyXinXiT().getColumnModel().getColumn(i).setCellRenderer(render);
	 	    }
	         bi.setEnabled(false);
	         
	     }else{
	    	 return;
	     }
		
		
        
        

	}

}
