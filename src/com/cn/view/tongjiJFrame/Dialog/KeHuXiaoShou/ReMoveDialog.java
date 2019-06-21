package com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cn.util.GBC;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;

public class ReMoveDialog extends JDialog implements ActionListener{
	JButton queDing,tuiChu;
	KeHuXiaoShouMainFrame frame;
	JLabel danHao;
	JLabel keHuName;
	JLabel yingFu;
	JLabel shiFu;
     public ReMoveDialog(KeHuXiaoShouMainFrame frame,String title,boolean b){
    	 super(frame,title,b);
    	 this.frame=frame;
    	 init();
     }
     private void init(){
    	 this.setSize(250,250);
    	 this.setLocationRelativeTo(this);
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new GridBagLayout());
    	 jp.add(new JLabel("即将删除的销售单:"),new GBC(0,0).setInsets(10, 5, 10, 10));
    	 danHao=new JLabel(frame.getZhangWuDtm().getValueAt(frame.getZhangWuBiao().getSelectedRow(), 2).toString());
    	 danHao.setForeground(Color.red);
    	 jp.add(danHao,new GBC(1,0).setInsets(10, 5, 10, 10));
    	 jp.add(new JLabel("客户名称:"),new GBC(0,1).setInsets(10, 5, 10, 10));
    	 keHuName=new JLabel(frame.getZhangWuDtm().getValueAt(frame.getZhangWuBiao().getSelectedRow(), 0).toString());
    	 keHuName.setForeground(Color.red);
    	 jp.add(keHuName,new GBC(1,1).setInsets(10, 5, 10, 10));
    	 jp.add(new JLabel("应付金额:"),new GBC(0,2).setInsets(10, 5, 10, 10));
    	 yingFu=new JLabel(frame.getZhangWuDtm().getValueAt(frame.getZhangWuBiao().getSelectedRow(), 4).toString());
    	 yingFu.setForeground(Color.red);
    	 jp.add(yingFu,new GBC(1,2).setInsets(10, 5, 10, 10));
    	 jp.add(new JLabel("实付金额:"),new GBC(0,3).setInsets(10, 5, 10, 10));
    	 shiFu=new JLabel(frame.getZhangWuDtm().getValueAt(frame.getZhangWuBiao().getSelectedRow(), 5).toString());
    	 shiFu.setForeground(Color.red);
    	 jp.add(shiFu,new GBC(1,3).setInsets(10, 5, 10, 10));
    	 queDing=new JButton("确定");
    	 tuiChu=new JButton("退出");
    	 jp.add(queDing,new GBC(0,4).setInsets(10, 5, 10, 10));
    	 jp.add(tuiChu,new GBC(1,4).setInsets(10, 5, 10, 10));
    	 queDing.addActionListener(this);
    	 tuiChu.addActionListener(this);
    	 this.add(jp);
    	 this.setVisible(true);
}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tuiChu){
			this.dispose();
		}
		if(e.getSource()==queDing){
			frame.getZhangWuDtm().removeRow(frame.getZhangWuBiao().getSelectedRow());
			this.dispose();
		}
	}
}