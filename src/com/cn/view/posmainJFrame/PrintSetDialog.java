package com.cn.view.posmainJFrame;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * ��ӡ���öԻ���
 */
public class PrintSetDialog extends JDialog {
	
	//��ӡСƱ
    private JCheckBox printXP;
    //��ӡСƱ
    private JCheckBox printCX;
    //Ԥ������
    private JCheckBox lookYL;
    
    //��ӡ��ʽ
    private JComboBox printFS ;
    //ѡ���ӡ��
    private JComboBox choicePrint ;
    
    //����һ
    private JTextField title1 ;
    //�����
    private JTextField title2 ;
    //������
    private JTextField title3 ;
    //������
    private JTextField title4 ;
    
	public PrintSetDialog(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
		init();
	}
	
	private void init(){
		this.setSize(new Dimension(300,400));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocation(300, 200);
		this.add(createPane());
		//this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	public JPanel createPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(9,1,2,10));
		
		JPanel tmpPane = new JPanel();
		printXP = new JCheckBox("��ӡСƱ");
		printCX = new JCheckBox("��Ǯ��");
		lookYL = new JCheckBox("Ԥ������");
		tmpPane.add(printXP);
		tmpPane.add(printCX);
		tmpPane.add(lookYL);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
        tmpPane.add(new JLabel("�� ӡ   ʽ :"));  
        printFS = new JComboBox (new String[]{"��ͨ��ӡ��       ","POS��ӡ��   "});
        tmpPane.add(printFS);
        pane.add(tmpPane);
		
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("ѡ �� ��ӡ ��: "));
        choicePrint = new JComboBox (new String[]{"���͵�NOTE 2001   ","Microsoft XPS "});
        tmpPane.add(choicePrint);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("СƱ     ����1:"));
        title1 = new JTextField(15);
        tmpPane.add(title1);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("СƱ     ����2:"));
        title2 = new JTextField(15);
        tmpPane.add(title2);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("СƱ     ��ע1:"));
        title3 = new JTextField(15);
        tmpPane.add(title3);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("СƱ     ��ע2:"));
        title4 = new JTextField(15);
        tmpPane.add(title4);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("������۵�"));
        tmpPane.add(new JLabel("����˻���"));
        tmpPane.add(new JLabel("�Զ���СƱ"));
        pane.add(tmpPane);
		
        tmpPane = new JPanel();
        tmpPane.setLayout(new FlowLayout(FlowLayout.CENTER,40,2));
        JButton okBtn = new JButton("ȷ��(F5)");
        JButton exitBtn = new JButton("�˳�(F4)");
        tmpPane.add(okBtn);
        tmpPane.add(exitBtn);
        pane.add(tmpPane);
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				PrintSetDialog.this.dispose();
			}
			
		});
		
		return pane;
	}
	

}
