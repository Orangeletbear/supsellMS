package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.border.TitledBorder;

import com.cn.dao.xiaoshou.guketuihuo.AddGoodsInfoFind;
import com.cn.dao.xiaoshou.guketuihuo.JDBCTuiHuoDanJuFind;
import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.jinhuo.AddSanPingCulomns;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfoDialog;
/**
 * 该监听器的作用是使
 * 商品信息（销售退货）对话框一打开
 * 就显示相关数据
 * @author Administrator
 *
 */
public class GoodsInfoListener extends WindowAdapter {
	
	String khName;
	private GoodsInfoDialog dialog;
	int row;
	
	public GoodsInfoListener(GoodsInfoDialog dialog,String khName,int row){
		this.dialog = dialog;
		this.khName = khName;
		this.row = row;
	}

	public void windowOpened(WindowEvent e){
		
		//设置GoodsInfoDialog上方的信息
		Vector data = JDBCDanJuFind.getGoodsData(khName);
		
		dialog.getGoodId().setText(""+((Vector)data.get(row)).get(0));
		dialog.getGoodName().setText(""+((Vector)data.get(row)).get(1));
		dialog.getGoodName().setForeground(Color.RED);
		dialog.getDanWei().setText(""+((Vector)data.get(row)).get(2));
		dialog.getXingHao().setText(""+((Vector)data.get(row)).get(3));
		dialog.getColor().setText(""+((Vector)data.get(row)).get(4));
		dialog.getTuiHuoDanJia().setText(""+((Vector)data.get(row)).get(5));
		dialog.getTuiHuoDanJia().setForeground(Color.RED);
		dialog.getKuCun().setText(""+((Vector)data.get(row)).get(6));
		dialog.getKuCun().setForeground(Color.RED);
		dialog.getShuLiang().setText("1");
		dialog.getShuLiang().setForeground(Color.RED);
		
		//设置表格标题
	     dialog.getBiaoGePanel().setBorder(new TitledBorder(""+khName+"消费该商品记录"));
		
	     //设置GoodsInfoDialog的表格信息
		
		 String spName = ((Vector)data.get(row)).get(1).toString();
		 Vector data2 =null;
	
		 data2= AddGoodsInfoFind.getData(khName, spName);
		 if(data2.size() > 0){
			 dialog.getTableModel().setDataVector(data2,
				      AllTableModel.getVectorFromObj(DialogCulomnModel.columNames));
			dialog.getTable().requestFocus();
			dialog.getTable().setRowSelectionInterval(0, 0);
		 
		 }
		
	}
}
