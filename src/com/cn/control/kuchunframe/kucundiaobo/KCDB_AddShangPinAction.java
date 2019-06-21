package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.KucunDiaobo;
import com.cn.view.kuchunJFrame.GongYong.AddSanPingDialog;

/**
 * 
 * 添加商品按钮的监听器
 * 通过选择仓库来筛选不同仓库中的商品信息
 * 库存调拨窗体
 * @author Administrator
 *
 */
public class KCDB_AddShangPinAction implements ActionListener {
	private KucunDiaobo dialog;
	
	public KCDB_AddShangPinAction(KucunDiaobo dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = dialog.getComboDCCK().getSelectedItem().toString().trim();
		String name1 = dialog.getComboDRCK().getSelectedItem().toString().trim();
		if(name.equals(name1)){
			JOptionPane.showMessageDialog(null, "调入与调出仓库名相同！");
		} else{
			new AddSanPingDialog(dialog,"增加商品(库存调拨)",name);
		}
	}
}
