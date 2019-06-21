package com.cn.control.mianframe;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.metal.MetalBorders;
import javax.swing.plaf.metal.MetalBorders.ToolBarBorder;

import com.cn.view.mainJFrame.MainFrame;
/**
 * 工具栏上的鼠标监听器
 * @author finey
 *
 */
public class ToolBarMouseListener extends MouseAdapter {
	MainFrame frame;
	//按钮的默认边框
	public static Border moRen;
	public ToolBarMouseListener(MainFrame frame) {
		this.frame = frame;
		ToolBarMouseListener.moRen = frame.getHuangban().getBorder();
		
	}

	public void mouseClicked(MouseEvent arg0) {

	}
    
	public void mouseEntered(MouseEvent arg0) {
        JButton tmp = (JButton)arg0.getSource();
        /*  tmp.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,
        		Color.blue, Color.red,Color.green,Color.magenta));*/
        //tmp.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        tmp.setBorder(new MatteBorder(1,1,3,5,new Color(107,186,210)));
        //tmp.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        
	}

	public void mouseExited(MouseEvent arg0) {
		JButton tmp = (JButton)arg0.getSource();
		tmp.setBorder(moRen);
	}

	public void mousePressed(MouseEvent arg0) {
           
	}

	public void mouseReleased(MouseEvent arg0) {

	}

}
