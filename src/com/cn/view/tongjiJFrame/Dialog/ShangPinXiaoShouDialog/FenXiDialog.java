package com.cn.view.tongjiJFrame.Dialog.ShangPinXiaoShouDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cn.model.AllTableModel;
import com.cn.view.tongjiJFrame.GoodsXiaoShouTongJi;
import com.cn.view.tongjiJFrame.Dialog.GBC;

public class FenXiDialog extends JDialog implements ActionListener{
     GoodsXiaoShouTongJi frame;
     JButton tuiChu;
     JLabel gongHuoShangName,shangPinName;
     JTable mainTable;
     DefaultTableModel mainDtm;
     String mainName[]={"销售数量","销售金额","销售利润","销售毛利率"};
     String mainColumn[][];
     public FenXiDialog(GoodsXiaoShouTongJi frame,String title,boolean b){
    	 super(frame,title,b);
    	 this.frame=frame;
    	 init();
     }
     private void init(){
    	 this.setSize(400,300);
    	 this.setLocationRelativeTo(null);
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new BorderLayout());
    	 tuiChu=new JButton(new ImageIcon("res\\AcionIcon\\exit.jpg"));
		 tuiChu.setMargin(new Insets(0,0,0,0));
		 gongHuoShangName=new JLabel(frame.getDtm1().getValueAt(frame.getMingXiBiao().getSelectedRow(), 4).toString());
    	 gongHuoShangName.setForeground(Color.red);
		 shangPinName=new JLabel(frame.getDtm1().getValueAt(frame.getMingXiBiao().getSelectedRow(), 3).toString());
         shangPinName.setForeground(Color.red);
		 JPanel labelP=new JPanel();
         labelP.setLayout(new GridBagLayout());
         labelP.add(tuiChu,new GBC(0,0,1,2).setInsets(5, 5, 5, 5));
         labelP.add(new JLabel("供货商名称"),new GBC(1,0).setInsets(5, 5, 5, 5));
         labelP.add(gongHuoShangName,new GBC(2,0).setInsets(5, 5, 5, 5));
         labelP.add(new JLabel("商品的名称"),new GBC(1,1).setInsets(5, 5, 5, 5));
         labelP.add(shangPinName,new GBC(2,1).setInsets(5, 5, 5, 5));
         mainColumn=new String[1][4];
         mainColumn[0][0]=frame.getDtm1().getValueAt(frame.getMingXiBiao().getSelectedRow(), 7).toString();
         mainColumn[0][1]=frame.getDtm1().getValueAt(frame.getMingXiBiao().getSelectedRow(), 8).toString();
         mainColumn[0][2]=frame.getDtm1().getValueAt(frame.getMingXiBiao().getSelectedRow(), 9).toString();
         mainColumn[0][3]=frame.getDtm1().getValueAt(frame.getMingXiBiao().getSelectedRow(), 10).toString();
         mainDtm=new AllTableModel(mainColumn,mainName);
         mainDtm.isCellEditable(0, 0);
         mainTable=new JTable(mainDtm);
         JScrollPane js=new JScrollPane(mainTable);
         
         jp.add(labelP,BorderLayout.NORTH);
         jp.add(js);
         tuiChu.addActionListener(this);
         this.add(jp);
         this.setVisible(true);
     }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
