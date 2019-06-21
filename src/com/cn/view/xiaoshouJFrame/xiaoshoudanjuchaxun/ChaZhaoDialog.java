package com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.ChaZhaoKeHuButtonAction;
import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.ChaZhaoSureAction;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.util.JDatePicker;
/**
 * 按客户名称、开单日期、仓库名称
 * 和操作员来查找销售单据的信息
 * @author Administrator
 *
 */
public class ChaZhaoDialog extends JDialog {

	private JTextField keHuName = new JTextField(15);
	
	private JButton button = new JButton(new ImageIcon("res/AcionIcon/3.jpg"));
	
	private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	
	private DefaultComboBoxModel ckboxModel; 
	private JComboBox ckbox;
    private JComboBox czybox ;
	private DefaultComboBoxModel czybxModel;	                                     

	private JButton sureButton = new JButton("确定(F5)");
	private JButton deleteButton = new JButton("退出(F4)");
	
	public ChaZhaoDialog(JDialog dialog,String title,boolean model){
		super(dialog,title,model);
		init();
	}
	
	public void init(){
		this.add(createPanel());
		this.setSize(350, 350);
	    this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public  JPanel createPanel(){
		JPanel panel = new JPanel();
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("客户名称:"));
		box1.add(keHuName);
		button.setMargin(new Insets(0,0,0,0));
		button.addActionListener(new ChaZhaoKeHuButtonAction(this));
		box1.add(button);
		
		
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("开单日期:"));
		box2.add(dataPicker1);
		
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("        至  "));
		box3.add(dataPicker2);
		
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("仓库名称:"));
		ckboxModel = new DefaultComboBoxModel(JDBCGetInfo.getCangKuData());
		ckboxModel.addElement("所有仓库");
		ckbox= new JComboBox(ckboxModel);
		box4.add(ckbox);
		
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("操作员:"));
		czybxModel = new DefaultComboBoxModel(JDBCGetInfo.getJingBanRenData());
		czybxModel.addElement("所有操作员");
		czybox = new JComboBox(czybxModel);

		box5.add(czybox);
		
		Box box6 = Box.createHorizontalBox();
		box6.add(sureButton);
		sureButton.addActionListener(new ChaZhaoSureAction(this));
		box6.add(Box.createHorizontalStrut(20));
		deleteButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		box6.add(deleteButton);
		
		Box box = Box.createVerticalBox();
		box.add(box1);
		box.add(Box.createVerticalStrut(25));
		box.add(box2);
		box.add(Box.createVerticalStrut(25));
		box.add(box3);
		box.add(Box.createVerticalStrut(25));
		box.add(box4);
		box.add(Box.createVerticalStrut(25));
		box.add(box5);
		box.add(Box.createVerticalStrut(25));
		box.add(box6);
		
		panel.add(box);
		return panel;
	}
	
	public JTextField getKeHuName() {
		return keHuName;
	}

	public JDatePicker getDataPicker1() {
		return dataPicker1;
	}

	public JDatePicker getDataPicker2() {
		return dataPicker2;
	}

	/*public ComboBoxModel getCkboxModel() {
		return ckboxModel;
	}

	public ComboBoxModel getCzybxModel() {
		return czybxModel;
	}*/

	public static void main(String[] args){
		new ChaZhaoDialog(null,"查找",true);
	}

	public JComboBox getCkbox() {
		return ckbox;
	}

	public JComboBox getCzybox() {
		return czybox;
	}
}
