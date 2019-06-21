package com.cn.control.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.dao.toolbar.JDBCDanJuFindGetData;
import com.cn.model.AllTableModel;
import com.cn.view.toolbar.KuChunFind;
import com.cn.view.toolbar.TableCulomnModel;
/*
 * 工具栏上的库存查询监听器
 */
public class CuCunFindAction implements ActionListener {
	
	KuChunFind frame;
	public CuCunFindAction(KuChunFind frame) {
	    this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		   //仓库名
           String canKuName = frame.getChanKu().getSelectedItem().toString();
           //商品名或商品号
           String spName = frame.getSpField().getText().toString();
           //商品类别
           String splb = frame.getLbField().getSelectedItem().toString();
           //是否查零库存商品
           boolean isGetO = frame.getBox().isSelected();
           
           Vector data = JDBCCuCunFind.getData(canKuName, spName,splb,isGetO);
			frame.getTableMo().setDataVector(data,
					AllTableModel.getVectorFromObj(TableCulomnModel.KuChunCaXunColumnName));
           
	}

}
