package com.cn.view.toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cn.util.CloseFile;
/**
 * �����Ի���
 * @author finey
 *
 */
public class HelpDialog extends JDialog {

	public HelpDialog(JFrame frame,String help){
		super(frame,help,true);
		init();
		this.setVisible(true);
		
	}
	private void init(){
		this.setSize(400,500);
		this.setTitle("�����ĵ�");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(5,5));
		this.setLocationRelativeTo(null);
		this.setFont(new Font("Serif",Font.PLAIN,20));
		InputStream in = null;
		
		JLabel la = new JLabel("�йذ�����Ϣ����: ");
		la.setFont(new Font("Serif",Font.PLAIN,20));
		la.setPreferredSize(new Dimension(50,20));
		
		this.add(la,BorderLayout.NORTH);
		
        JTextArea helpDocument = new JTextArea();
        helpDocument.setBackground(new Color(146,204,215));
        helpDocument.setLineWrap(true);
        try {
        	byte [] b = new byte[1024];
        	int len =0;
			in = new FileInputStream("res/help.txt");
			while((len = in.read(b))!=-1){
				helpDocument.append(new String(b,0,len));
			}
			
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null,"�����ļ�û���ҵ�!!");
		    
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"�����ļ�û���ҵ�!!");
			CloseFile.free(in);
		}
		helpDocument.setEditable(false);
		helpDocument.setForeground(Color.blue);
		helpDocument.setFont(new Font("Serif",Font.PLAIN,20));
        this.add(new JScrollPane(helpDocument));
        
        
        
        
		JButton btn = new JButton("ȷ   ��");
		btn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				HelpDialog.this.dispose();
			}
			
			
		});
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));
		southPane.add(btn);
		this.add(southPane,BorderLayout.SOUTH);
		this.setResizable(false);

	}
	
	public static void main(String[] args) {
		new HelpDialog((JFrame)null,"�����Ի���");
	}

}
