package com.cn.control.jinhuoframe.caigoutuihuo;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCFindGoodsInfo;
import com.cn.view.jinhuoJFrame.jdialog.caigoutuihuo.TuiHuoShangPin;

/**
 * ������Ʒ(��Ʒ����)�Ի����ϵ�
 * ��Ʒ���������Ӧ�ļ�����
 * @author Administrator
 *
 */
public class FuckTreeMouseListener extends MouseAdapter {

	private TuiHuoShangPin dialog;
	
	public FuckTreeMouseListener(TuiHuoShangPin dialog){
		this.dialog = dialog;
	}
	
	public void mouseClicked(MouseEvent e ){
		
		if(e.getClickCount() == 1 || e.getClickCount() == 2){
			String splb = dialog.getTree().
						getLastSelectedPathComponent().toString().trim();
      	
			 dialog.setSpqdtable_data(JDBCFindGoodsInfo.getlbData(splb));
			
			dialog.getSplb_tableModel().setDataVector(dialog.getSpqdtable_data(),
					dialog.getSpqdtable_columnName());
		}
					      	   
		
	}
}