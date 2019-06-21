package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import com.cn.dao.jinhuo.jinhuoguanli.JDBCShangPinXinXi;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi2;

public class AddWindowListenerRIGHT implements WindowListener{
	
	AddShangPingDialog addShang;
	ShangPinXinXi2 shang;
	
	public AddWindowListenerRIGHT(ShangPinXinXi2 shang){
		this.shang = shang;
		this.addShang = shang.getDialog();
	}

	public void windowActivated(WindowEvent e) {
		
	}

	public void windowClosed(WindowEvent e) {
		
	}

	public void windowClosing(WindowEvent e) {
		
	}

	public void windowDeactivated(WindowEvent e) {
		
	}

	public void windowDeiconified(WindowEvent e) {
		
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
		int tmp = addShang.getSplbtable1().getSelectedRow();//选中是哪一行
		if(tmp != -1){
			Object spid = addShang.getData().get(tmp).get(0);//该行数据的第一个就是  商品编号
		
			//初始化数据
			Vector v = JDBCShangPinXinXi.getData((String)spid);
		
			//由于toString出现null不好办，所以用山寨版
			shang.getShangpinbianhao().setText(""+v.remove(0));
		
			shang.getShangpinmingcheng().setText(""+v.remove(0));
			shang.getShangpinmingcheng().setForeground(Color.RED);//商品名称设为红色字体
		
			shang.getGuigexinghao().setText(""+v.remove(0));
			//argDanwei用来将一个数据同时赋给  基本单位  和  选择单位
			String argDanwei = ""+v.remove(0);
			shang.getJibendanwei().setText(argDanwei);
			////////////对于comboBox的关联多单位暂时没写！！！！！！！！
			shang.getXuanzedanwei().addItem(argDanwei);
			shang.getShengchanchangshang().setText(""+v.remove(0));
			shang.getYanse().setText(""+v.remove(0));
		
			shang.getDangqiankucun().setText(""+v.remove(0));
			shang.getDangqiankucun().setForeground(Color.RED);//当前库存设为红色字体
		
			shang.getBeizhu().setText(""+v.remove(0));
			shang.getCankaojinjia().setText(""+addShang.getData().get(tmp).get(3));//tmp行第四列是进价
			shang.getShuliang().setText(""+addShang.getData().get(tmp).get(4));//tmp行第五列是进价
		}
	}

}
