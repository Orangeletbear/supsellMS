package com.cn.view.jinhuoJFrame.jdialog.wanglaizhangwu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cn.dao.jinhuo.wanglaizhangwu.GHSJDBC;
import com.cn.model.AllTableModel;
import com.cn.util.GBC;
import com.cn.view.jinhuoJFrame.WangLaiZhangWu;

public class FuKuanKeHuJDailog extends JDialog implements ActionListener {
	WangLaiZhangWu frame;
	JButton queDing,tuiChu;
    JTable GHSTable;
	 DefaultTableModel GHS;
	 String GhsNames[]={"编号","供货商名称","联系人","联系电话","联系地址"};
	 String GhsColumn[][];
    public  FuKuanKeHuJDailog(WangLaiZhangWu frame,String title,boolean b){
		super(frame,title,b);
		this.frame=frame;
		init();
	}
	private void init(){
		this.setSize(450, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JPanel jp=new JPanel();
		jp.setLayout(new BorderLayout());
		JPanel northP=new JPanel();
		northP.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel northL=new JLabel("供货商信息");
		northL.setForeground(Color.red);
		northL.setFont(new Font(Font.SERIF,Font.BOLD,20));
		northP.add(northL);
		GHS=new AllTableModel(GhsColumn,GhsNames);
		GHS.isCellEditable(0, 0);
		GHSTable=new JTable(GHS);
		GHS.setDataVector(GHSJDBC.getJS(), AllTableModel.getVectorFromObj(GhsNames));
    	GHSTable.requestFocus();
    	GHSTable.setRowSelectionInterval(0, 0);
    	JScrollPane js=new JScrollPane(GHSTable);
		queDing=new JButton("确定");
		tuiChu=new JButton("退出");
		JPanel southP=new JPanel();
		southP.setLayout(new GridBagLayout());
		southP.add(queDing,new GBC(0,0).setInsets(10, 10, 10, 10));
		southP.add(tuiChu,new GBC(1,0).setInsets(10, 10, 10, 10));
		jp.add(northP,BorderLayout.NORTH);
		jp.add(js,BorderLayout.CENTER);
		jp.add(southP,BorderLayout.SOUTH);
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
			
			frame.getPanel5_center_gongHuoShangMingCheng().setText(GHS.getValueAt(GHSTable.getSelectedRow(), 1).toString());
		    this.dispose();
		}
	}
}
