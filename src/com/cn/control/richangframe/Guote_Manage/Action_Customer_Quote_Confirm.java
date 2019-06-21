package com.cn.control.richangframe.Guote_Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import com.cn.view.richangJFrame.Guote_Manage.JWindow_Customer_Quote_self;

public class Action_Customer_Quote_Confirm implements ActionListener,
		MouseListener {
	private JWindow_Customer_Quote_self jcqs;
	public Action_Customer_Quote_Confirm(
			JWindow_Customer_Quote_self jcqs) {
		this.jcqs = jcqs;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(jcqs.getTable().getSelectedRow());
		if(jcqs.getTable().getSelectedRow() != -1){
			Vector v = (Vector)jcqs.getTabelModel().getDataVector().get(jcqs.getTable().getSelectedRow());
//			jcqs.getDialog().getText_name().setText(v.get(1).toString());
			jcqs.dispose();
		}

	}

	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			if(jcqs.getTable().getSelectedRow() != -1){
				Vector v = (Vector)jcqs.getTabelModel().getDataVector().get(jcqs.getTable().getSelectedRow());
//				jcqs.getDialog().getText_name().setText(v.get(1).toString());
				jcqs.dispose();
			}
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
