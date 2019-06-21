package com.cn.view.systemJFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.XiTongWeiHu.BeiFenDialog;
import com.cn.view.systemJFrame.XiTongWeiHu.MiMaDialog;
import com.cn.view.systemJFrame.XiTongWeiHu.NianZhongJieSuanDialog;
import com.cn.view.systemJFrame.XiTongWeiHu.RiZhiDialog;
/**
 * ϵͳ���������ϵͳά��
 * @author Administrator
 *
 */
public class SystemWeiHuFrame extends JDialog implements ActionListener {
	MainFrame frame;
	//ϵͳ����/�ָ����ݰ�ť
	private JButton beiFenBtn;
	//ϵͳ��ʼ��
	private JButton systemInitBtn;
	//�޸�����
	private JButton changeSecretBtn;
	//���ս���
	private JButton yearConclusionBtn;
	//�鿴��־
	private JButton lookLogBtn;
	//��Ȩ�����ӡ
	private JButton tiaoMaPrintBtn;
	//�������
	private JButton baiBiaoSheJiBtn;
	//���ڽ���
	private JButton chuQiJiangZBtn;
	//�˳�
	private JButton exitBtn;
	
	public SystemWeiHuFrame(MainFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.frame=frame;
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(400,380));
        this.add(createPane());
        changeSecretBtn.addActionListener(this);
        lookLogBtn.addActionListener(this);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
	}
	/*
	 * ѡ��ļ���
	 */
	private JPanel createPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new GridLayout(3,3,40,40));
		//ϵͳ����/�ָ����ݰ�ť
		beiFenBtn  = new JButton(new ImageIcon("res/AcionIcon/shujubeifenyuhuifu.jpg"));
		beiFenBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new BeiFenDialog(SystemWeiHuFrame.this,"ϵͳ������ָ�",true);
			}
			
		});
		beiFenBtn.setMargin(new Insets(0,0,0,0));
		//ϵͳ��ʼ��
		systemInitBtn = new JButton(new ImageIcon("res/AcionIcon/xitongchushihua.jpg"));
		systemInitBtn.setMargin(new Insets(0,0,0,0));
		//�޸�����
		changeSecretBtn = new JButton(new ImageIcon("res/AcionIcon/xiugaimima.jpg"));
		changeSecretBtn.setMargin(new Insets(0,0,0,0));
		//���ս���
		yearConclusionBtn = new JButton(new ImageIcon("res/AcionIcon/nianzhongjiesuan.jpg"));
		yearConclusionBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new NianZhongJieSuanDialog(SystemWeiHuFrame.this,"���ս���");
			}
			
		});
		
		yearConclusionBtn.setMargin(new Insets(0,0,0,0));
		//�鿴��־
		lookLogBtn = new JButton(new ImageIcon("res/AcionIcon/chakanrizhi.jpg"));
		lookLogBtn.setMargin(new Insets(0,0,0,0));
		//��ӡ����
		tiaoMaPrintBtn = new JButton(new ImageIcon("res/AcionIcon/tiaomadaying.jpg"));
		tiaoMaPrintBtn.setMargin(new Insets(0,0,0,0));
		//�������
		baiBiaoSheJiBtn = new JButton(new ImageIcon("res/AcionIcon/baobiaosheji.jpg"));
		baiBiaoSheJiBtn.setMargin(new Insets(0,0,0,0));
		//���ڽ���
		chuQiJiangZBtn = new JButton(new ImageIcon("res/AcionIcon/chuqijiangzhang.jpg"));
		chuQiJiangZBtn.setMargin(new Insets(0,0,0,0));
		//�˳�
		exitBtn = new JButton(new ImageIcon("res/AcionIcon/tuichu.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				SystemWeiHuFrame.this.dispose();
			}
			
		});
		
		mainPane.add(beiFenBtn);
		mainPane.add(systemInitBtn);
		mainPane.add(changeSecretBtn);
		mainPane.add(yearConclusionBtn);
		mainPane.add(lookLogBtn);
		mainPane.add(tiaoMaPrintBtn);
		mainPane.add(baiBiaoSheJiBtn);
		mainPane.add(chuQiJiangZBtn);
		mainPane.add(exitBtn);
		
		pane.add(mainPane);
		return pane;
	}
	

	public MainFrame getFrame() {
		return frame;
	}

	public void actionPerformed(ActionEvent e) {
         if(e.getSource()==changeSecretBtn){
        	 new MiMaDialog(this,"�޸�����",true);
         }		
         if(e.getSource()==lookLogBtn){
        	 new RiZhiDialog(this,"�鿴��־",true);
         }
	}

}
