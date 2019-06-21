package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import com.cn.dao.jinhuo.jinhuoguanli.JDBCShangPinXinXi;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi;
/**
 * 双击表格数据行，弹出商品信息dialog，与JDBC交互获取数据初始化dialog界面
 * @author Administrator
 *
 */
public class ShangPinXinXiListener implements WindowListener {

	ShangPinXinXi dialog;
	String spid;
	
	public ShangPinXinXiListener(ShangPinXinXi dialog,String spid){
		this.dialog = dialog;
		this.spid =spid;
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
		//初始化数据
		Vector v = JDBCShangPinXinXi.getData(spid);
		//由于toString出现null不好办，所以用山寨版
		dialog.getShangpinbianhao().setText(""+v.remove(0));
		
		dialog.getShangpinmingcheng().setText(""+v.remove(0));
		dialog.getShangpinmingcheng().setForeground(Color.RED);//商品名称设为红色字体
		
		dialog.getGuigexinghao().setText(""+v.remove(0));
		//tmp用来将一个数据同时赋给  基本单位  和  选择单位
 		String tmp = ""+v.remove(0);
		dialog.getJibendanwei().setText(tmp);
		////////////对于comboBox的关联多单位暂时没写！！！！！！！！
		dialog.getXuanzedanwei().addItem(tmp);
		dialog.getShengchanchangshang().setText(""+v.remove(0));
		dialog.getYanse().setText(""+v.remove(0));
		
		dialog.getDangqiankucun().setText(""+v.remove(0));
		dialog.getDangqiankucun().setForeground(Color.RED);//当前库存设为红色字体
		
		dialog.getBeizhu().setText(""+v.remove(0));
		dialog.getCankaojinjia().setText(""+v.remove(0));
		
		//初始化表
		dialog.getATM().setDataVector(JDBCShangPinXinXi.getRowData(spid), 
				ColumnNames.gonghuojilu_columnNames);
		
		
		
	}

}
