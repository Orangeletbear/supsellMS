package com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.control.xiaoshouframe.shangpinxiaoshuo.XiaoShouGoodsInfoAction;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.XiaoShouGoodsInfo_DocumentListener;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.XiaoShouGoodsInfo_SureAction;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.util.JNumberField;
/**
 * ˫��������Ʒ����Ʒ���ۣ�
 * �Ի�����ߵı�ʱ���ֵĶԻ���
 * ����Ʒ��Ϣ����Ʒ���ۣ��Ի���
 * @author Administrator
 *
 */
public class XiaoShouGoodsInfo extends JDialog {

	//������
	  private  AddXiaoShouGoodsDialog dialog;
	 
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
	  //�ο��ۼ�
	  private JTextField canKaoShouJia = new JTextField();
	  //����
	  private JNumberField shuLiang = new JNumberField();
      //������
	  private JTextField daZhe = new JTextField();
	  //�ۺ󵥼�
	  private JLabel danJia = new JLabel(); 
	  //�ܼƽ��
	  private JLabel zje = new JLabel();
	  
	  private JButton sure = new JButton("ȷ��");
	  private JButton exit = new JButton("�˳�");
		
		//
	  private JTable table;
	  private AllTableModel tableModel;
	  
	  
	  private JPanel biaoGePanel;

	public XiaoShouGoodsInfo(AddXiaoShouGoodsDialog dialog,String title){
		super(dialog,title,true);
		this.dialog = dialog;
		int row = dialog.getSpqdtable().getSelectedRow();
		String kehu = dialog.getMaindialog().getKeHuText().getText();
		this.addWindowListener(new XiaoShouGoodsInfoAction(this,kehu,row));
		init();
	}
	
	public void init(){
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(createTopPanel());
		mainPanel.add(createBottomPanel());
		this.add(mainPanel);
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * �ϲ��������Ĳ���
	 * @return
	 */
	public JPanel createTopPanel(){
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new TitledBorder("��Ʒ��Ϣ"));
		topPanel.setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4,1,1,10));
		center.setLayout(new GridLayout(5,0,1,10));
		center.add(new JLabel("��Ʒ���:"));
		center.add(goodId);
		center.add(new JLabel("��Ʒ����:"));
		center.add(goodName);
		center.add(new JLabel("����ͺ�:"));
		center.add(xingHao);
		center.add(new JLabel("��     λ:"));
		center.add(danWei);
		center.add(new JLabel("��������:"));
		center.add(changShang);
		center.add(new JLabel("��      ɫ:"));
		center.add(color);
		center.add(new JLabel("��ǰ���:"));
		center.add(kuCun);
		center.add(new JLabel("��      ע:"));
		center.add(beiZhu);
		
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(2,1));
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("�ο��ۼ�:"));
		box1.add(canKaoShouJia);
		canKaoShouJia.getDocument().addDocumentListener(new XiaoShouGoodsInfo_DocumentListener(this));
		
		box1.add(new JLabel("Ԫ"));
		box1.add(Box.createHorizontalStrut(8));
		box1.add(new JLabel("������:"));
		box1.add(daZhe);
		daZhe.getDocument().addDocumentListener(new XiaoShouGoodsInfo_DocumentListener(this));
		box1.add(Box.createHorizontalStrut(8));
		box1.add(new JLabel("����:"));
		box1.add(shuLiang);
		shuLiang.getDocument().addDocumentListener(new XiaoShouGoodsInfo_DocumentListener(this));
		
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("�ۺ󵥼�:"));
		box2.add(danJia);
		box2.add(new JLabel("Ԫ"));
		box2.add(Box.createHorizontalStrut(100));
		JLabel label = new JLabel("1Ϊ������,0.8Ϊ�����!");
		label.setForeground(Color.RED);
		box2.add(label);
		box2.add(new JLabel("�ܼ�:"));
		box2.add(zje);
	    box2.add(new JLabel("Ԫ"));
	    
		south.add(box1);
		south.add(box2);
		
		topPanel.add(center,BorderLayout.CENTER);
		topPanel.add(south,BorderLayout.SOUTH);
		
		
		return topPanel;
	}
	/**
	 * �²��������Ĳ���
	 * @return
	 */
	
	public JPanel createBottomPanel(){
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
	//	north.setLayout(new FlowLayout(100));
		north.add(sure);
		sure.addActionListener(new XiaoShouGoodsInfo_SureAction(this));
		north.add(new JLabel("                           "));
		north.add(exit);
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
		biaoGePanel = new JPanel();
		tableModel = new AllTableModel(
			    DialogCulomnModel.obj,DialogCulomnModel.columNames);
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500,356));
        biaoGePanel.add(new JScrollPane(table));
        
        
        bottomPanel.add(north,BorderLayout.NORTH);
        bottomPanel.add(biaoGePanel,BorderLayout.CENTER);
		return bottomPanel;
	}
	
	
	public AddXiaoShouGoodsDialog getDialog() {
		return dialog;
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

	public JLabel getChangShang() {
		return changShang;
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

	public JTextField getCanKaoShouJia() {
		return canKaoShouJia;
	}

	public JTextField getShuLiang() {
		return shuLiang;
	}

	public JTextField getDaZhe() {
		return daZhe;
	}

	public JLabel getDanJia() {
		return danJia;
	}

	public JLabel getZje() {
		return zje;
	}

	public AllTableModel getTableModel() {
		return tableModel;
	}

	public JTable getTable() {
		return table;
	}

	public JPanel getBiaoGePanel() {
		return biaoGePanel;
	}

	public static void main(String[] args){
		new XiaoShouGoodsInfo(null,"");
	}
}
