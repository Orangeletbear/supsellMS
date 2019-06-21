package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo2;
/**
 * 第二个商品信息（商品销售）对话框上的
 * 确定按钮所对应的监听器
 * 
 */
public class GoodsInfo2_SureAction implements ActionListener {
	 
	private XiaoShouGoodsInfo2 dialog;
	 //父窗口  
	 private AddXiaoShouGoodsDialog mainDialog;
	 
	public GoodsInfo2_SureAction(XiaoShouGoodsInfo2 dialog){
		this.dialog = dialog;
		this.mainDialog = dialog.getDialog();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//获取增加商品（商品销售）对话框右表被选择的行
		int row = dialog.getDialog().getSxsptable().getSelectedRow();
		
		AllTableModel model = dialog.getDialog().getSxsp_tableModel();
		
		String shuLiang = dialog.getShuLiang().getText();
		String daZhe = dialog.getDaZhe().getText();
		String danJia = dialog.getDanJia().getText();
		String zje = dialog.getZje().getText();
		String canKaoShouJia = dialog.getCanKaoShouJia().getText();
		String kuCun = dialog.getKuCun().getText();
		
		
		if(Float.parseFloat(dialog.getDaZhe().getText())<= 1.0 
				&& Float.parseFloat(shuLiang) < Float.parseFloat(kuCun)){
			
			model.setValueAt(canKaoShouJia, row, 2);
			model.setValueAt(daZhe, row, 3);
		    model.setValueAt(danJia, row, 4);
			model.setValueAt(shuLiang, row, 5);
			model.setValueAt(zje, row, 6);
			
			dialog.dispose();
			
		}else if ("".equals(dialog.getDaZhe().getText())||Float.parseFloat(dialog.getDaZhe().getText()) >1.0
				||Float.parseFloat(dialog.getDaZhe().getText()) >1.0 ) {
			       JOptionPane.showMessageDialog(dialog, "打折率设置有错,请重新设置!","系统提示", 
					       JOptionPane.DEFAULT_OPTION, null);
		}else if ( Float.parseFloat(shuLiang) > Float.parseFloat(kuCun)){
			
			  int n = JOptionPane.showOptionDialog(dialog, "库存数量小于销售数量，继续销售吗？", "系统提示", 
					  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
		       if(n == JOptionPane.YES_OPTION){
		    		
		   		model.setValueAt(canKaoShouJia, row, 2);
		   		model.setValueAt(daZhe, row, 3);
		   	    model.setValueAt(danJia, row, 4);
		   		model.setValueAt(shuLiang, row, 5);
		   		model.setValueAt(zje, row, 6);
		   		
		   		dialog.dispose();
		  
		    }
	
		}
     
	/*	  Vector data= mainDialog.getMainData();	
		  Vector o;
		  
	      Iterator itr = data.iterator();
	      while(itr.hasNext()) {
	         o = (Vector) itr.next();
	         o.setElementAt(canKaoShouJia, 5);
	         o.setElementAt(daZhe, 6);
	         o.setElementAt(danJia, 7);
	         o.setElementAt(shuLiang, 8);
	         o.setElementAt(zje, 9);
	         
	      }
	     */
           
	}

}
