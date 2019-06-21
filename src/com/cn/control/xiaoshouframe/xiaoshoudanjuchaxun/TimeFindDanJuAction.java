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
 * ���۵��ݲ�ѯ�Ի����ϵ�
 * panel_center_RIQI��ť����Ӧ�ļ�����
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
		JMenuItem todayItem = new JMenuItem("����");
		todayItem.addActionListener(new TimeAction());
		
		JMenuItem yesterDayItem = new JMenuItem("����");
		yesterDayItem.addActionListener(new TimeAction());
		
		JMenuItem dayItem = new JMenuItem("ǰ��");
		dayItem.addActionListener(new TimeAction());
		
		JMenuItem weekItem = new JMenuItem("�������");
		weekItem.addActionListener(new TimeAction());
		
		todayItem.addActionListener(new TimeAction());
		JMenuItem  monthItem = new JMenuItem("���һ��");
		JMenuItem benYueItem = new JMenuItem("����");
		JMenuItem shangYueItem = new JMenuItem("����");
		JMenuItem timeItem = new JMenuItem("����ʱ��");
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
