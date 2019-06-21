package com.cn.control.posmainframe;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.cn.view.posmainJFrame.POSFrame;

public class HelpToolAction implements ActionListener {
	private POSFrame dialog;
	
	public HelpToolAction(POSFrame dialog) {
	    this.dialog  = dialog;
	
	}

	public void actionPerformed(ActionEvent e) {
	       if(dialog.getPane().isVisible()){
	    	   dialog.getHelpBtn().setIcon(new ImageIcon("res/smallIcon/blue_up.gif"));
	    	   dialog.getHelpBtn().setText("ÏÔÊ¾°ïÖú(F1)");
	    	   dialog.getHelpBtn().setMargin(new Insets(0,0,0,0));
	    	   dialog.getHelpBtn().setFont(new Font("Serif",Font.BOLD,15));
	           dialog.getPane().setVisible(false);
	           dialog.repaint();
	       
	       }else{
	    	   dialog.getHelpBtn().setIcon(new ImageIcon("res/smallIcon/blue_down.gif"));
	    	   dialog.getHelpBtn().setText("Òþ²Ø°ïÖú(F1)");
	    	   dialog.getHelpBtn().setMargin(new Insets(0,0,0,0));
	    	   dialog.getHelpBtn().setFont(new Font("Serif",Font.BOLD,15));
	    	   dialog.getPane().setVisible(true);
	    	   dialog.repaint();
	       }
	
	}

}
