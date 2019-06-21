package com.cn.view.xiaoshouJFrame.guketuihuo.dialog;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.control.xiaoshouframe.guketuihuo.AlterGoodsListener;
import com.cn.control.xiaoshouframe.guketuihuo.AlterGoodsSureAction;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;

/**
 * �˿��˻��Ի����й˿��˻�ѡ�
 * �ϵĵ����޸���Ʒ��ť
 * ��˫�����ϵı��ʱ���ֵĶԻ���
 * @author Administrator
 *
 */
public class AlterGoodsDialog extends JDialog {
	
	//������
	private GuKeTuiHuoDialog dialog;
	

	//һ��ʼ��ʱ�������ݣ�������Դ�ڸ��������˻�ѡ�����ѡ�����
	public AlterGoodsDialog(GuKeTuiHuoDialog dialog,String title){
		super(dialog,title,true);
		this.dialog = dialog;
		this.addWindowListener(new AlterGoodsListener(this));
		init();
		
	}
	//��Ʒ���
	private JLabel spId= new JLabel();
	//��Ʒ����
	private JLabel spName= new JLabel();
	//����ͺ�
	private JLabel xingHao= new JLabel();
	//��λ
	private JLabel danWei= new JLabel();
	//��������
	private JLabel changShang= new JLabel();
	//��ɫ
	private JLabel color= new JLabel();
	//��ǰ���
	private JLabel kuCun= new JLabel();
	//��ע
	private JLabel beiZhu= new JLabel();
	
	private JTextField danJia = new JTextField(10);
	private JTextField shuLiang = new JTextField(10);
	
	private JButton sure = new JButton("ȷ��");
	
	
	private void init(){
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);//�̶���С
		this.setSize(500, 250);
		this.setLocationRelativeTo(null);
		
		
		this.setLayout(new BorderLayout());
		this.add(initCenterPanel(),BorderLayout.CENTER);
		this.add(createSouthPanel(),BorderLayout.SOUTH);
	
		this.setVisible(true);
		
	}
//panel1
	private JPanel initCenterPanel(){
		JPanel panel1 = new JPanel();
		//
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new TitledBorder("��Ʒ��Ϣ"));

		centerPanel.setLayout(new GridLayout(5,0,1,8));
		centerPanel.add(new JLabel("��Ʒ���:"));
		centerPanel.add(spId);
		centerPanel.add(new JLabel("��Ʒ����:"));
		centerPanel.add(spName);
		centerPanel.add(new JLabel("����ͺ�:"));
		centerPanel.add(xingHao);
		centerPanel.add(new JLabel("������λ:"));
		centerPanel.add(danWei);
		centerPanel.add(new JLabel("��������:"));
		centerPanel.add(changShang);
		centerPanel.add(new JLabel("��       ɫ:"));
		centerPanel.add(color);
		centerPanel.add(new JLabel("��ǰ���:"));
		centerPanel.add(kuCun);
		centerPanel.add(new JLabel("��       ע:"));
		centerPanel.add(beiZhu);
		
		centerPanel.add(new JLabel("�˻�����:"));
		centerPanel.add(danJia);
		centerPanel.add(new JLabel("��       ��:"));
		centerPanel.add(shuLiang);
		
		return centerPanel;
	}

	
	public JPanel createSouthPanel(){
		JPanel southPanel = new JPanel();
		JButton exit = new JButton("�˳�");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AlterGoodsDialog.this.dispose();
			}
		});
		
		southPanel.add(sure);
		sure.addActionListener(new AlterGoodsSureAction(dialog,this));
		southPanel.add(new JLabel("                        "));
		southPanel.add(exit);
		
		return southPanel;
	}
	
	public GuKeTuiHuoDialog getDialog() {
		return dialog;
	}
	public JLabel getSpName() {
		return spName;
	}
	public void setSpName(JLabel spName) {
		this.spName = spName;
	}

	public JLabel getSpId() {
		return spId;
	}
	public JLabel getXingHao() {
		return xingHao;
	}
	public JLabel getDanWei() {
		return danWei;
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
	public JTextField getDanJia() {
		return danJia;
	}
	public JTextField getShuLiang() {
		return shuLiang;
	}
}
