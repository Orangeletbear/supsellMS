package com.cn.view.xiaoshouJFrame.guketuihuo.dialog;

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

import com.cn.control.xiaoshouframe.guketuihuo.GaoJiChaXunSureAction;
import com.cn.control.xiaoshouframe.guketuihuo.TuiHuoChaZhaoKeHuButtonAction;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.util.JDatePicker;

/** 
 *  �öԻ����ǹ˿��˻���ѯѡ���
 *  ���¸߼���ѯ��ť�������ĶԻ���
 *  ���Ը��ݿͻ����ơ��������ڡ��ֿ����ƺ�
 *  ����Ա��ѯ���˿��˻�����Ϣ
 * @author Administrator
 *
 */
public class GaoJiChaXun extends JDialog {

	private JTextField keHuText = new JTextField(15);
	
	private DefaultComboBoxModel ckboxModel; 
	private JComboBox ckbox;
    private JComboBox czybox ;
	private DefaultComboBoxModel czybxModel;	  

	private JButton button = new JButton(new ImageIcon("res/AcionIcon/3.jpg"));
	private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JButton sureButton = new JButton("ȷ��(F5)");
	private JButton exitButton = new JButton("�˳�(F4)");
	public GaoJiChaXun(JDialog frame,String title,boolean model){
		super(frame,title,model);
		
		init();
	}
	
	public void init() {
		this.setSize(350,350);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(createPanel());
		this.setVisible(true);
	}
	
	public JPanel createPanel() {
     JPanel panel = new JPanel();
		
		Box keHuName = Box.createHorizontalBox();
		keHuName.add(new JLabel("�ͻ�����:"));
		keHuName.add(keHuText);
		button.setMargin(new Insets(0,0,0,0));
		button.addActionListener(new TuiHuoChaZhaoKeHuButtonAction(this));
		keHuName.add(button);
	
		Box kaiDan = Box.createHorizontalBox();
		kaiDan.add(new JLabel("��������: "));
		kaiDan.add(dataPicker1);
		
		Box zhi = Box.createHorizontalBox();
		zhi.add(new JLabel("  ��    "));
		zhi.add(Box.createHorizontalStrut(25));
		zhi.add(dataPicker2);
		
		Box cangKuName = Box.createHorizontalBox();
		cangKuName.add(new JLabel("�ֿ�����: "));
		ckboxModel = new DefaultComboBoxModel(JDBCGetInfo.getCangKuData());
		ckboxModel.addElement("���вֿ�");
		ckbox= new JComboBox(ckboxModel);
		cangKuName.add(ckbox);
		
		Box caoZuoYuan = Box.createHorizontalBox();
		caoZuoYuan.add(new JLabel("����Ա:    "));
		czybxModel = new DefaultComboBoxModel(JDBCGetInfo.getJingBanRenData());
		czybxModel.addElement("���в���Ա");
		czybox = new JComboBox(czybxModel);

		caoZuoYuan.add(czybox);
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(sureButton);
		sureButton.addActionListener(new GaoJiChaXunSureAction(this));
		buttonBox.add(Box.createHorizontalStrut(40));
		buttonBox.add(exitButton);
		exitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
		Box box = Box.createVerticalBox();
	    box.add(keHuName);
	    box.add(Box.createVerticalStrut(25));
	    box.add(kaiDan);
	    box.add(Box.createVerticalStrut(25));
	    box.add(zhi);
	    box.add(Box.createVerticalStrut(25));
	    box.add(cangKuName);
	    box.add(Box.createVerticalStrut(25));
	    box.add(caoZuoYuan);
	    box.add(Box.createVerticalStrut(25));
	    box.add(buttonBox);
	    
	    panel.add(box);
		return panel;
	}
	public JDatePicker getDataPicker1() {
		return dataPicker1;
	}

	public JDatePicker getDataPicker2() {
		return dataPicker2;
	}

	public JTextField getKeHuText() {
		return keHuText;
	}
	public JComboBox getCkBox() {
		return ckbox;
	}

	public JComboBox getCzyBox() {
		return czybox;
	}



	
	public static void main(String[] args){
		new GaoJiChaXun(null,"����",true);
	}
}
