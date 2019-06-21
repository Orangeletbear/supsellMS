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
 * 商品信息下的查询监听器
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
		//从数据库取出数据
		System.out.println(lbName+"   "+ spName);
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
