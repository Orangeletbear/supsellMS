package com.cn.view.xiaoshouJFrame.guketuihuo.dialog;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.cn.util.GBC;
import com.cn.view.xiaoshouJFrame.commondialog.KeHuWindow;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
/**
 * 修改客户对话框
 * @author Administrator
 *
 */
public class AddKeHuDialog extends JDialog {

	private KeHuWindow window;
	private GuKeTuiHuoDialog dialog;
	//客户名称
	private JTextField khName = new JTextField(12);
	//联系人
	private JTextField lxr = new JTextField(12);
	//联系电话
	private JTextField lxdh = new JTextField(12);
	//联系地址
	private JTextField lxdz = new JTextField(12);
	//备注
	private JTextArea  beiZhu = new JTextArea(3,12);
	//默认客户
	JCheckBox mrkh = new JCheckBox("默认客户");
	//禁用
	JCheckBox jinYong = new JCheckBox("禁用");
	//期初应收
	JTextField qcys = new JTextField(5);
	
	public AddKeHuDialog(KeHuWindow window,String title){
		super(window,title);
		this.window = window;
		init();
	}
	
	public void init(){
		this.setSize(380,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(createPanel());
		this.setVisible(true);
	}

	public JPanel createPanel(){
		
		JPanel panel = new JPanel();
		
		GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        
        JLabel khLabel =  new JLabel("客户名称 :");
        layout.setConstraints(khLabel, new GBC(0, 0).setInsets(0, 2, 0, 2));
        panel.add(khLabel);
        layout.setConstraints(khName,new GBC(1,0,3,1).setInsets(10, 2, 10, 2));
        panel.add(khName);
       
        //panel.add(comp)
        JLabel lxrLabel =  new JLabel("联系人 :");
        layout.setConstraints(lxrLabel, new GBC(0, 1).setInsets(10, 2, 10, 2));
        panel.add(lxrLabel);
        layout.setConstraints(lxr,new GBC(1,1,3,1).setInsets(10, 2, 10, 2));
        panel.add(lxr);
        
        JLabel lxdhLabel =  new JLabel("联系电话:");
        layout.setConstraints(lxdhLabel, new GBC(0, 2).setInsets(10, 2, 10, 2));
        panel.add(lxdhLabel);
        layout.setConstraints(lxdh,new GBC(1,2,3,1).setInsets(10, 2, 10, 2));
        panel.add(lxdh);
        
       JLabel lxdzLabel =  new JLabel("联系地址:");
        layout.setConstraints(lxdzLabel, new GBC(0, 3).setInsets(10, 2, 10, 2));
        panel.add(lxdzLabel);
        layout.setConstraints(lxdz,new GBC(1,3,3,1).setInsets(10, 2, 10, 2));
        panel.add(lxdz);
        
        JLabel bzLabel =  new JLabel("备注:");
        layout.setConstraints(bzLabel, new GBC(0, 4).setInsets(10, 2, 10, 2));
        panel.add(bzLabel);
        
        JScrollPane scroll = new  JScrollPane(beiZhu,
        		       ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        		       ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ); 
        layout.setConstraints(scroll,new GBC(1,4,3,3).setInsets(10, 2, 10, 2));
        panel.add(scroll);
        
        JLabel qcysj = new JLabel("期初应收:");
        qcysj.setForeground(Color.RED);
        layout.setConstraints(qcysj, new GBC(0, 8).setInsets(10, 2, 4, 4));     
        panel.add(qcysj);
        
        
        layout.setConstraints(qcys, new GBC(1, 8).setInsets(10, 2, 4, 4));
        qcys.setText("0.0");
        panel.add(qcys);
        
        
        layout.setConstraints(jinYong, new GBC(2, 8).setInsets(10, 2, 4, 4));
        panel.add(jinYong);
        
        layout.setConstraints(mrkh, new GBC(3, 8).setInsets(10, 2, 4, 4));
        panel.add(mrkh);
        
      JButton sure = new JButton("确定");
        layout.setConstraints(sure, new GBC(2, 9).setInsets(4, 4, 4, 4));
        panel.add(sure);
        
        JButton exit = new JButton("退出");
        layout.setConstraints(exit, new GBC(3, 9).setInsets(4, 4, 4, 4));
        exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
        	
        });
        
        
        panel.add(exit);
       
		return panel;
	}
	
	public static void main(String[] args){
		new AddKeHuDialog(null,"修改客户");
	}
}

