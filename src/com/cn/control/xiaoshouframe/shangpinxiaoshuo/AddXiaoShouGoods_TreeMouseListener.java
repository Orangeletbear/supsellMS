package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCFindGoodsInfo;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo;

/**
 * ������Ʒ(��Ʒ����)�Ի����ϵ�
 * ��Ʒ���������Ӧ�ļ�����
 * @author Administrator
 *
 */
public class AddXiaoShouGoods_TreeMouseListener extends MouseAdapter {

	private AddXiaoShouGoodsDialog dialog;
	
	public AddXiaoShouGoods_TreeMouseListener(AddXiaoShouGoodsDialog dialog){
		this.dialog = dialog;
	}
	
	public void mouseClicked(MouseEvent e ){
		
		if(e.getClickCount() == 1 && e.getButton() == 1){
			String splb = dialog.getTree().getLastSelectedPathComponent().toString().trim();
      	
			Vector data = JDBCFindGoodsInfo.getlbData(splb);
			
			dialog.getSplb_tableModel().setDataVector(data,
					AllTableModel.getVectorFromObj(DialogCulomnModel.leftColumnName));
					      	   
		}else 	if(e.getClickCount() == 2 && e.getButton() == 1){
		  new XiaoShouGoodsInfo(dialog,"��Ʒ��Ϣ����Ʒ���ۣ�");
					      	   
		}
	}
}
