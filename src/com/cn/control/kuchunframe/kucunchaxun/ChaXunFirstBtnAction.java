package com.cn.control.kuchunframe.kucunchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.kuchun.DanQianKuCunJDBC;
import com.cn.dao.toolbar.JDBCDanJuFindGetData;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.model.kuchun.MyTableCellRender;
import com.cn.view.kuchunJFrame.KuCunChaXunFrame;
import com.cn.view.toolbar.TableCulomnModel;
/*
 * 库存查询中的第一个面板中的查询监听器
 */
public class ChaXunFirstBtnAction implements ActionListener {
	
	KuCunChaXunFrame frame;
	
	public ChaXunFirstBtnAction(KuCunChaXunFrame frame) {
		
		this.frame = frame;
		
	}

	public void actionPerformed(ActionEvent arg0){
		//仓库名
		String ckName = frame.getChankuBox().getSelectedItem().toString();
		//商品类别
		String spLbName =frame.getSplb().getSelectedItem().toString();
		//商品编号或名称
		String spName =frame.getSpmcfield12().getText().toString().trim();
		//是否查出为零商品
		boolean isGetO = frame.getIsgetO().isSelected();
		
		Vector data = DanQianKuCunJDBC.getSPBDQKData(ckName,spLbName,spName,isGetO);
		//数据加入表模式中
		frame.getTableModel().setDataVector(data,
		AllTableModel.getVectorFromObj(KuCunKunCBDCulomns.KuCunColumnName1));
		
        MyTableCellRender render = new MyTableCellRender();
		
		//设置每列的渲染器
	    for(int i = 0; i < KuCunKunCBDCulomns.KuCunColumnName1.length; i++) {
	    	frame.getHysxtable1().getColumnModel().getColumn(i).setCellRenderer(render);
	    }
		
	}

}
