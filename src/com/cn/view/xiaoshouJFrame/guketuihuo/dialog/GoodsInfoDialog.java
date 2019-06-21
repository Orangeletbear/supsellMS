package com.cn.view.xiaoshouJFrame.guketuihuo.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.xiaoshouframe.guketuihuo.GoodsInfoListener;
import com.cn.control.xiaoshouframe.guketuihuo.GoodsInfoSureAction;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.model.AllTableModel;
/**
 * ��Ʒ��Ϣ�������˻����Ի���
 * @author Administrator
 *
 */
public class GoodsInfoDialog extends JDialog {
	
 
	// private static AddTuiHuoGoodsDialog mainDialog;
	AddTuiHuoGoodsDialog  dialog;
	
  
  //��Ʒ���
  private JLabel goodId= new JLabel();
  //��Ʒ����
  private JLabel goodName= new JLabel();
  //����ͺ�
  private JLabel xingHao= new JLabel();
  //��������
  private JLabel changShang= new JLabel();
  //��ɫ
  private JLabel color= new JLabel();
  //��ǰ���
  private JLabel kuCun= new JLabel();
  //��ע
  private JLabel beiZhu= new JLabel();
  //��λ
  private JLabel danWei = new JLabel();
  //�˻�����
  private JTextField tuiHuoDanJia = new JTextField(10);
  //����
  private JTextField shuLiang = new JTextField(10);

  private JButton sure = new JButton("ȷ��");
	
	//
  private JTable table;
  private AllTableModel tableModel;
  
  
  private JPanel biaoGePanel;

  

//һ��ʼ���������ݣ�������Դ��������Ʒ�������˻����Ի�����߱���е�����
  public GoodsInfoDialog(AddTuiHuoGoodsDialog  dialog,String title) {
	  super(dialog,title,true);
	  this.dialog = dialog;
	  String kehu = dialog.getMaindialog().getKeHuText1().getText();
	  int row = dialog.getSpqdtable().getSelectedRow();
	  this.addWindowListener(new GoodsInfoListener(this,kehu,row));
	  init();
  }
  

  public void init() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);//�̶���С
		this.setSize(450, 400);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		this.add(panel1(),BorderLayout.NORTH);
		this.add(panel3(),BorderLayout.CENTER);
	
		this.setVisible(true);
  }


public JPanel getBiaoGePanel() {
	return biaoGePanel;
}
	//panel1
	private JPanel panel1(){
		JPanel panel1 = new JPanel();
		//
		JPanel panel_center = new JPanel();
		panel_center.setBorder(new TitledBorder("��Ʒ��Ϣ"));
		//panel_center.setBorder(new LineBorder(Color.GRAY,1) );//�߿�
		panel_center.setLayout(new GridLayout(5,0,1,10));
		panel_center.add(new JLabel("��Ʒ���:"));
		panel_center.add(goodId);
		panel_center.add(new JLabel("��Ʒ����:"));
		panel_center.add(goodName);
		panel_center.add(new JLabel("����ͺ�:"));
		panel_center.add(xingHao);
		panel_center.add(new JLabel("��     λ:"));
		panel_center.add(danWei);
		panel_center.add(new JLabel("��������:"));
		panel_center.add(changShang);
		panel_center.add(new JLabel("��      ɫ:"));
		panel_center.add(color);
		panel_center.add(new JLabel("��ǰ���:"));
		panel_center.add(kuCun);
		panel_center.add(new JLabel("��      ע:"));
		panel_center.add(beiZhu);
			
		panel_center.add(new JLabel("�˻�����:"));
		panel_center.add(tuiHuoDanJia);
		panel_center.add(new JLabel("����:"));
		panel_center.add(shuLiang);
		
		//
	JPanel panel_south = new JPanel();
	
		//
		JPanel pane2= new JPanel();
		JButton tuichu = new JButton("�˳�");
		tuichu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GoodsInfoDialog.this.dispose();
			}
		});
		pane2.setLayout(new FlowLayout(FlowLayout.CENTER,60,1));
		
		//ȷ�ϰ�ť�ϵļ�����
		sure.addActionListener(new GoodsInfoSureAction(dialog,this));
		pane2.add(sure);
		pane2.add(tuichu);
		
	
		panel_south.add(pane2);
			
		panel1.setLayout(new BorderLayout());
		panel1.add(panel_center,BorderLayout.CENTER);
		panel1.add(panel_south,BorderLayout.SOUTH);
		return panel1;
	}

	
//	panel3
	private JPanel panel3(){
	
	    biaoGePanel = new JPanel();
	  
		tableModel = new AllTableModel(
				    DialogCulomnModel.obj,DialogCulomnModel.columNames);
	    table = new JTable(tableModel);
		
	    biaoGePanel.add(new JScrollPane(table));

		return biaoGePanel;
	}
	
	public AllTableModel getTableModel() {
		return tableModel;
	}
	  
	public JTable getTable() {
		return table;
	}


	public JLabel getGoodId() {
		return goodId;
	}

	public JLabel getGoodName() {
		return goodName;
	}

	public JLabel getXingHao() {
		return xingHao;
	}

	public JLabel getColor() {
		return color;
	}

	public JLabel getKuCun() {
		return kuCun;
	}

	public JLabel getBeiZhu() {
		return beiZhu;
	}

	public JLabel getDanWei() {
		return danWei;
	}

	public JTextField getTuiHuoDanJia() {
		return tuiHuoDanJia;
	}

	public JTextField getShuLiang() {
		return shuLiang;
	}

}
