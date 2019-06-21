package com.cn.control.systemframe.sanpingxinxi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.table.TableCellRenderer;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.MyTableCellRender;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
/**
 * 商品管理中的选择树鼠标监听器
 * @author Administrator
 *
 */
public class SelectTreeAction extends MouseAdapter {

	private ShangPingGuangLiFrame frame;
	public SelectTreeAction(ShangPingGuangLiFrame frame) {
		this.frame = frame;
	}

	public void mouseClicked(MouseEvent e) {
           if(e.getButton() == 1){
        	   
        	   String lbName = frame.getTree().getLastSelectedPathComponent().toString().trim();
        	   String spName = frame.getSpbhfield().getText().toString().trim();
        	   
        	   Vector data = SanPingGuanLiJDBC.getSPBaseMassege(lbName, spName);
               //更新界面数据
               frame.getTableModel().setDataVector(data,
           		   AllTableModel.getVectorFromObj(SPTJTableCulomns.SPTLColumnName));
        	   
               //创建渲染器对象
       	    TableCellRenderer cellRenderer = new MyTableCellRender();
       		//设置每列的渲染器
       	    for(int i = 0; i < SPTJTableCulomns.SPTLColumnName.length; i++) {
       	    	frame.getSptable().getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
       	    }
               
           }
	}
}
