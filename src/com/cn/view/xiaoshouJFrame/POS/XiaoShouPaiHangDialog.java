package com.cn.view.xiaoshouJFrame.POS;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * POS�������жԻ��� ,��������ѡ�����Ʒ�������У�
 * ����Ա�������У���Ʒ�����������
 * 
 * @author Administrator
 *
 */
public class XiaoShouPaiHangDialog extends JDialog {
	
	/*
	 * ��Ʒ��������ѡ��ϵ����
	 */
	
	private JPanel tab1_panel = new JPanel();
	
	
	/*
	 * ����Ա��������ѡ��ϵ����
	 */
	JPanel tab2_panel = new JPanel();
	
	
	/*
	 * ��Ʒ�����������ѡ��ϵ����
	 */
	JPanel tab3_panel = new JPanel();

    //	��������ϵ����
	private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton daYinButton = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
	private JButton tuiChuButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	
    //�м�����ϵ����
	
	private TimeSpinnerPanel timeSpinner = new TimeSpinnerPanel();
	private JButton shiJianButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	private JTextField lieBeiText = new JTextField(10);
	private JButton chaXunButton = new JButton("��ѯ(F2)");
	
	
	
	public XiaoShouPaiHangDialog(JFrame frame, String title,boolean model) {
		super(frame,title,model);
		init();
	}
	
	
	public void init() {
		
	}
	
	
	/**
	 * ��Ʒ��������ѡ��ϵ�����Ĳ���
	 */
	
	
	
	/**
	 * ����Ա��������ѡ��ϵ�����Ĳ���
	 */
	
	
	
	
	
	/**
	 * ��Ʒ�����������ѡ��ϵ�����Ĳ���
	 */
	
	
}
