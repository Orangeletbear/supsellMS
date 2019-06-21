package com.cn.view.kuchunJFrame.baosunbaoyi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.cn.control.kuchunframe.baosunbaoyi.BSBY_GaoJiChaXunAction;
import com.cn.dao.pos.POSJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.kuchun.BSBYModel;
import com.cn.view.kuchunJFrame.BaosunBaoyi;

/**
 * 
 * ��Ʒ������߼���ѯ��������
 * @author Administrator
 */
public class BSBY_GaoJiChaXunDialog extends JDialog {
	private BaosunBaoyi dialog;
	
	private JComboBox comboCK;//����ֿ�
	private JComboBox comboJBR;//������
	private JRadioButton rBtn; //���� ѡ���
	private JButton btnYes;//ȷ��
	private JButton btnNo;//ȡ��
	
	public BSBY_GaoJiChaXunDialog(BaosunBaoyi dialog,String title,boolean b){
		super(dialog,title,b);
		this.dialog = dialog;
		init();
	}
	
	private void init (){
		this.setSize(240, 180);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(add());
	}

	///////////////////////
	public BaosunBaoyi getDialog() {
		return dialog;
	}
	public JComboBox getComboCK() {
		return comboCK;
	}
	public JComboBox getComboJBR() {
		return comboJBR;
	}
	public JRadioButton getrBtn() {
		return rBtn;
	}
	public JButton getBtnYes() {
		return btnYes;
	}
	public JButton getBtnNo() {
		return btnNo;
	}

	private JPanel add(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(4,1));
		
		JPanel jpanel1 = new JPanel();
		JLabel label1 = new JLabel("����ֿ⣺");
		label1.setPreferredSize(new Dimension(100,30));
		comboCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		comboCK.addItem("���вֿ�");
		comboCK.setSelectedItem("���вֿ�");
		comboCK.setPreferredSize(new Dimension(100,30));
		jpanel1.add(label1);
		jpanel1.add(comboCK);
		
		JPanel jpanel2 = new JPanel();
		JLabel label2 = new JLabel("�����ˣ�");
		label2.setPreferredSize(new Dimension(100,30));
		comboJBR = new JComboBox(POSJDBC.getAllWorker());
		comboJBR.addItem("���о�����");
		comboJBR.setSelectedItem("���о�����");
		comboJBR.setPreferredSize(new Dimension(100,30));
		jpanel2.add(label2);
		jpanel2.add(comboJBR);
		
		JPanel jpanel3 = new JPanel();
		rBtn = new JRadioButton("ֻ��ѯ�̵㱨����Ʒ");
		rBtn.setForeground(Color.RED);
		jpanel3.add(rBtn);
		
		JPanel jpanel4 = new JPanel();
		jpanel4.setLayout(new FlowLayout(FlowLayout.CENTER,30,5));
		btnYes = new JButton("ȷ��");
		btnNo = new JButton("ȡ��");
		jpanel4.add(btnYes);
		jpanel4.add(btnNo);
		{
			btnYes.addActionListener(new BSBY_GaoJiChaXunAction(this));
			btnNo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					BSBY_GaoJiChaXunDialog.this.dispose();
				}
			});
		}
		{
			jpanel.add(jpanel1);
			jpanel.add(jpanel2);
			jpanel.add(jpanel3);
			jpanel.add(jpanel4);
		}
		return jpanel;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BSBY_GaoJiChaXunDialog(null,"",true).setVisible(true);
	}

}
