package com.cn.control.kuchunframe.kucundiaobo.addshangpin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

public class KCDB_AddShangPinOKAction implements ActionListener {
	private AddShangPinXinXiDialog dialog;
	
	public KCDB_AddShangPinOKAction(AddShangPinXinXiDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		/*Object[]obj = null;
		
		if((JButton)e.getSource() == dialog.getBtnYes()){
			obj[0]=dialog.getLabelSPMC().getText();//商品名称
			obj[1]=(null);//商品单位
			obj[2]=dialog.getLabelGGXH().getText();
			obj[3]=dialog.getLabelYS().getText();
			obj[4]=dialog.getLabelCBDJ().getText();
			
			
			 * 比较调拨数量跟库存的大小
			 * 
			 
			String counts = dialog.getLabelDQKC().getText();
			int count = Integer.valueOf(counts);
			
			String nums = dialog.getTextDBSL().getText().trim();
			int num = Integer.valueOf(nums);
			
			if(num <= count){
				obj[5]=num;
			} else {
				obj[5]=count;
				new JOptionPane("调拨数量大于库存数量！！！");
			}
			
			
			 * 计算调拨总金额
			 
			int danJia = Integer.valueOf((String) obj[4]);
			int shuLiang = Integer.valueOf((String)obj[5]);
			int zongJinE = shuLiang*danJia;
			obj[6] = zongJinE;
			
//			System.out.println();
			
//			vo=(dialog.getLabelDQKC().getText());//数量
		
			
		}*/	
	}

}
