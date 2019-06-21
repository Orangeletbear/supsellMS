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
 * 打印设置对话框
 */
public class PrintSetDialog extends JDialog {
	
	//打印小票
    private JCheckBox printXP;
    //打印小票
    private JCheckBox printCX;
    //预览报表
    private JCheckBox lookYL;
    
    //打印方式
    private JComboBox printFS ;
    //选择打印机
    private JComboBox choicePrint ;
    
    //标题一
    private JTextField title1 ;
    //标题二
    private JTextField title2 ;
    //标题三
    private JTextField title3 ;
    //标题四
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
		printXP = new JCheckBox("打印小票");
		printCX = new JCheckBox("打开钱箱");
		lookYL = new JCheckBox("预览报表");
		tmpPane.add(printXP);
		tmpPane.add(printCX);
		tmpPane.add(lookYL);
		pane.add(tmpPane);
		
		tmpPane = new JPanel();
        tmpPane.add(new JLabel("打 印   式 :"));  
        printFS = new JComboBox (new String[]{"普通打印机       ","POS打印机   "});
        tmpPane.add(printFS);
        pane.add(tmpPane);
		
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("选 择 打印 机: "));
        choicePrint = new JComboBox (new String[]{"发送到NOTE 2001   ","Microsoft XPS "});
        tmpPane.add(choicePrint);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("小票     标题1:"));
        title1 = new JTextField(15);
        tmpPane.add(title1);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("小票     标题2:"));
        title2 = new JTextField(15);
        tmpPane.add(title2);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("小票     脚注1:"));
        title3 = new JTextField(15);
        tmpPane.add(title3);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("小票     脚注2:"));
        title4 = new JTextField(15);
        tmpPane.add(title4);
        pane.add(tmpPane);
        
        tmpPane = new JPanel();
        tmpPane.add(new JLabel("设计销售单"));
        tmpPane.add(new JLabel("设计退货单"));
        tmpPane.add(new JLabel("自定义小票"));
        pane.add(tmpPane);
		
        tmpPane = new JPanel();
        tmpPane.setLayout(new FlowLayout(FlowLayout.CENTER,40,2));
        JButton okBtn = new JButton("确定(F5)");
        JButton exitBtn = new JButton("退出(F4)");
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
