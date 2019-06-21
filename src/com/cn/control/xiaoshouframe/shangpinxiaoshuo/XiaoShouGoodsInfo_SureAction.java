package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.shangpinxiaoshou.DialogColumnNamesModel;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo;

/**
 * 商品信息（销售商品）对话框上的
 * 确定按钮所对应的监听器
 * 
 */
   public class XiaoShouGoodsInfo_SureAction implements ActionListener {
	 //父窗口  
	 private AddXiaoShouGoodsDialog mainDialog;
	private  XiaoShouGoodsInfo dialog;
	
	public XiaoShouGoodsInfo_SureAction(XiaoShouGoodsInfo dialog){
		this.dialog = dialog;
		mainDialog  = dialog.getDialog();
	}
	
	public void actionPerformed(ActionEvent e) {
		//存放要向父窗口左边表格返回的数据
		Vector<String> data  = new Vector<String>();
		
	
		String spName = dialog.getGoodName().getText();
		String danWei = dialog.getDanWei().getText();
		String danJia = dialog.getCanKaoShouJia().getText();
		String daZhe = dialog.getDaZhe().getText();
		String zheHouJia = dialog.getDanJia().getText();
		String shuLiang = dialog.getShuLiang().getText();
		String zje = dialog.getZje().getText();
		String kuCun = dialog.getKuCun().getText();
		
		String canKaoShouJia = dialog.getCanKaoShouJia().getText();
	
		
		if(Float.parseFloat(dialog.getDaZhe().getText())<= 1.0 
				&& Float.parseFloat(shuLiang) < Float.parseFloat(kuCun)){
			data.add(spName);
			data.add(danWei);
			data.add(danJia);
			data.add(daZhe);
			data.add(zheHouJia);
			data.add(shuLiang);
			data.add(zje);
			
		    Vector	data1 =dialog.getDialog().getData();
			data1.add(data);
			
			dialog.getDialog().getSxsp_tableModel().setDataVector(data1, 
					AllTableModel.getVectorFromObj(DialogColumnNamesModel.columnNames));
			
			dialog.dispose();
			
		}else if ("".equals(dialog.getDaZhe().getText())||Float.parseFloat(dialog.getDaZhe().getText()) >1.0 
				   ||Float.parseFloat(dialog.getDaZhe().getText()) <=0.0) {
			       JOptionPane.showMessageDialog(dialog, "打折率设置有错,请重新设置!","系统提示", 
					       JOptionPane.DEFAULT_OPTION, null);
		}else if ( Float.parseFloat(shuLiang) > Float.parseFloat(kuCun)){
			
			  int n = JOptionPane.showOptionDialog(dialog, "库存数量小于销售数量，继续销售吗？", "系统提示", 
					  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
		       if(n == JOptionPane.YES_OPTION){
		    	   data.add(spName);
		   		data.add(danWei);
		   		data.add(danJia);
		   		data.add(daZhe);
		   		data.add(zheHouJia);
		   		data.add(shuLiang);
		   		data.add(zje);
		   		
		   	    Vector	data1 =dialog.getDialog().getData();
		   		data1.add(data);
		    	
		    	dialog.getDialog().getSxsp_tableModel().setDataVector(data1, 
						AllTableModel.getVectorFromObj(DialogColumnNamesModel.columnNames));
				
				dialog.dispose();
	 
		    }
	
		}
	    //添加要向商品销售对话框表中返回的数据
		
		Vector<Object> vector = new Vector<Object>();
		//添加商品编号
		vector.add(mainDialog.getSpqd_tableModel().getValueAt(
				 mainDialog.getSpqdtable().getSelectedRow(), 0));
		//添加商品名称
		vector.add(dialog.getGoodName().getText());
		//添加单位
		vector.add(dialog.getDanWei().getText());
		//添加规格型号
		vector.add(mainDialog.getSpqd_tableModel().getValueAt(
				mainDialog.getSpqdtable().getSelectedRow(), 3));
		//添加颜色
		vector.add(dialog.getColor().getText());
		
		//添加单价
		vector.add(canKaoShouJia);
		//添加打折率
		vector.add(daZhe);
		//添加折后价
		vector.add(danJia);
		//添加数量
		vector.add(shuLiang);
		//添加总金额
		vector.add(zje);

		mainDialog.getMainData().add(vector);
		
		}

}


