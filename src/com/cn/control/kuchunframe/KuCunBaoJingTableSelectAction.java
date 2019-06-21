package com.cn.control.kuchunframe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import com.cn.dao.kuchun.KunCunBaoJinJDBC;
import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.view.kuchunJFrame.KucunBaojin;
import com.cn.view.toolbar.TableCulomnModel;
/**
 * 库存报警中的选择表数据监听器
 * @author finey
 *
 */
public class KuCunBaoJingTableSelectAction extends MouseAdapter {

	KucunBaojin frame;
	public KuCunBaoJingTableSelectAction(KucunBaojin frame) {
		this.frame = frame;
	}

	public void mouseClicked(MouseEvent arg0) {
          if(arg0.getClickCount() ==1){
        	  int row = frame.getTable1().getSelectedRow();

        	  String spID = frame.getTablemodel1().getValueAt(row, 0).toString();
        	  String spName = frame.getTablemodel1().getValueAt(row, 1).toString();
        	  
        	  frame.getTextJHXSMX().setText(spName);
        	  
        	  Vector data = KunCunBaoJinJDBC.getBaoJingSPXSMassege(spID);
        	  
        	  frame.getTablemodel2().setDataVector(data,
        	  AllTableModel.getVectorFromObj(TableCulomnModel.KuCunBaoJingXiaoXi));
          }
	}


}
