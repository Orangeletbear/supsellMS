package com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;
/**
 * 销售单据查询对话框上的
 * panel_center_RIQI按钮所对应的监听器
 * @author Administrator
 *
 */
public class TimeFindDanJuAction implements ActionListener {

   public static DanJuChaXunDialog dialog;
   
	public TimeFindDanJuAction(DanJuChaXunDialog dialog){
		   this.dialog = dialog;
	   }
   public static DanJuChaXunDialog getDialog() {
	return dialog;
  }

	public void actionPerformed(ActionEvent e) {
	
		
		JPopupMenu menu = new JPopupMenu();
		JMenuItem todayItem = new JMenuItem("今天");
		todayItem.addActionListener(new TimeAction());
		
		JMenuItem yesterDayItem = new JMenuItem("昨天");
		yesterDayItem.addActionListener(new TimeAction());
		
		JMenuItem dayItem = new JMenuItem("前天");
		dayItem.addActionListener(new TimeAction());
		
		JMenuItem weekItem = new JMenuItem("最近七天");
		weekItem.addActionListener(new TimeAction());
		
		todayItem.addActionListener(new TimeAction());
		JMenuItem  monthItem = new JMenuItem("最近一月");
		JMenuItem benYueItem = new JMenuItem("本月");
		JMenuItem shangYueItem = new JMenuItem("上月");
		JMenuItem timeItem = new JMenuItem("所有时间");
		menu.add(todayItem);
		menu.add(yesterDayItem);
		menu.add(dayItem);
		menu.add(new JSeparator());
		menu.add(weekItem);
		menu.add(monthItem);
		menu.add(new JSeparator());
		menu.add(benYueItem);
		menu.add(shangYueItem);
		menu.add(timeItem);
		//System.out.println(23);
		menu.show(dialog, 300, 140);
		
	}

}
