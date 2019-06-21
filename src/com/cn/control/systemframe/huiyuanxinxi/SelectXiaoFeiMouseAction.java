package com.cn.control.systemframe.huiyuanxinxi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
/**
 * 选择表一条数据时的监听器
 * @author finey
 *
 */
public class SelectXiaoFeiMouseAction extends MouseAdapter {
	private HuiYanGuangLiFrame frame;  
	public SelectXiaoFeiMouseAction(HuiYanGuangLiFrame frame) {
		this.frame = frame;
	}

	public void mouseClicked(MouseEvent arg0) {
          if(arg0.getClickCount() ==1){
        	  int row = frame.getHyXiaoFenT().getSelectedRow();

        	  String xfDanHao = frame.getHyXiaoFenTM().getValueAt(row, 2).toString();
        	  
        	  frame.getDjId().setText("单据号："+xfDanHao);
        	  
        	  Vector data = HuiYuanXinGLJDBC.getHuiYuanXiaoFeiMingxi(xfDanHao);
        	  
        	  frame.getHyXiaoFenMinXiTM().setDataVector(data,
        	  AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName32));
        	  
        	  
        	  
          }
	}

	
}
