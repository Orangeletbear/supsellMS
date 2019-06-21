package com.cn.view.systemJFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cn.view.toolbar.RemaindDialog;
import com.cn.view.toolbar.TableCulomnModel;
/**
 * ϵͳ��һЩ���öԻ���
 * @author finey
 *
 */
public class OtherSetFrame extends JDialog {

	/*
	 * ��Ŀ��ȫ��
	 */
	private JTextField allName = new JTextField(44);
	/*
	 * ��Ŀ����
	 */
	private JTextField simpleName = new JTextField(15);
	/*
	 * ��Ŀ����ϵ�绰
	 */
	private JTextField tell = new JTextField(15);
	/*
	 * ��Ŀ��ϵ��ַ
	 */
	private JTextField address = new JTextField(44);
	/*
	 * �ڶ�������ϵĵ���ȡ
	 */
	JComboBox card2Box = new JComboBox(new String[]{"ƽ������","�������"});
	JCheckBox box1 = new JCheckBox("�����ֽ����й���");
	JCheckBox box2 = new JCheckBox("����ʱ�����޸����۵���");
	JCheckBox box3 = new JCheckBox("���Ϊ��ʱ��������");
	JCheckBox box4 = new JCheckBox("�ɹ�����������ʱ��ԭʼ����");
	JCheckBox box5 = new JCheckBox("�ɹ��˻�ʱֻ���˸ù����̹�Ӧ����Ʒ");
	JCheckBox box6 = new JCheckBox("�ؼ���Ʒ�������");
	JCheckBox box7 = new JCheckBox("��������˳���Ʒ���۴���");
	JCheckBox box8 = new JCheckBox("ʹ�ñ�׼������Ʒ��������Ʒ");
	JCheckBox box9 = new JCheckBox("��Ʒ�ɱ���Ϊ��ʱ��������");
	JCheckBox box10 = new JCheckBox("��Ʒ���������ظ�");
	JCheckBox box11 = new JCheckBox("������Ʒ������Ϣʱ��Ʒ�Զ����");
	JCheckBox box12 = new JCheckBox("�����˻�ʱֻ���˸ÿͻ����۵���Ʒ");
	/*
	 * С��λ��
	 */
	private JTextField number = new JTextField(5);
	/*
	 * ���������
	 */
	JCheckBox box31 = new JCheckBox("posǰ������ʱ����ģ����ѯ");
	JCheckBox box32 = new JCheckBox("posǰ�˹����浱��ҵ���Ϣ");
	JCheckBox box33 = new JCheckBox("posǰ������ʱ��Աֻ��ˢ������");
	JCheckBox box34 = new JCheckBox("posǰ����ʾ��Ʒ�������");
	private JTextField number31 = new JTextField(3);
	private JTextField number32 = new JTextField(3);
	/*
	 * ���ĸ�ѡ�
	 */
	JCheckBox box41 = new JCheckBox("����Զ��Web���ʹ���");
	
	/*
	 * �����ѡ�
	 */
	private JTextField number51 = new JTextField(2);
	private JTextField number52 = new JTextField(2);
	private JTextField number53 = new JTextField(2);
	private JTextField number54 = new JTextField(2);
	
	public OtherSetFrame(JFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(500,400));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
	}
	/*
	 * ѡ��ļ���
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		JTabbedPane  tabblePane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		
		JPanel pane1 = createPane1();
		JPanel pane2 = createPane2();
		JPanel pane3 = createPane3();
		JPanel pane4 = createPane4();
		JPanel pane5 = createPane5();
		
		tabblePane.add("��Ŀ����Ϣ",pane1);
		tabblePane.add("ϵͳ����",pane2);
		tabblePane.add("POS��������",pane3);
		tabblePane.add("Զ�̷�������",pane4);
		tabblePane.add("���ӳ���������",pane5);
		
		mainPane.add(tabblePane);
		
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("ȷ��");
		JButton cancerBtn = new JButton("ȡ��");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				OtherSetFrame.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		
		
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
	}
	/*
	 * ��һ��ѡ�
	 */
	private JPanel createPane1(){
        JPanel pane = new JPanel();
        
        JPanel inpane = new JPanel();
        inpane.setLayout(new GridLayout(8,1,10,4));
        
        
        inpane.add(new JLabel());
       
        
        JPanel tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel teamAllName = new JLabel("��Ŀ��ȫ��:");
        allName.setText("�޵�������Ŀ������");
        tempPane.add(teamAllName);
        tempPane.add(allName);
        inpane.add(tempPane);
        
        inpane.add(new JLabel());
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel teamSimpleName = new JLabel("��Ŀ����:");
        simpleName.setText("�޵�����");
        JLabel teamTell = new JLabel("��Ŀ��绰:");
        tempPane.add(teamSimpleName);
        tempPane.add(simpleName);
        tempPane.add(teamTell);
        tell.setText("0731-88888888");
        tempPane.add(tell);
        inpane.add(tempPane);
        
        inpane.add(new JLabel());
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel teamAddress = new JLabel("��Ŀ���ַ:");
        tempPane.add(teamAddress);
        address.setText("���ϴ�ѧ���������������");
        tempPane.add(address);
        inpane.add(tempPane);
        
        inpane.add(new JLabel());
        //inpane.add(new JLabel());
        
        pane.add(inpane);

		return pane;
	}
	
	/*
	 * �ڶ���ѡ�
	 */
	private JPanel createPane2(){
		
		JPanel pane = new JPanel();
        
        JPanel inpane = new JPanel();
        inpane.setLayout(new GridLayout(8,2));

        JPanel tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lab = new JLabel("�ɹ�/�˻��ĵ���ȡ");
        tempPane.add(lab);
        tempPane.add(card2Box);
        inpane.add(tempPane);
        
        box2.setSelected(true);
        box3.setSelected(true);
        box4.setSelected(true);
        box5.setSelected(true);
        box9.setSelected(true);
        box10.setSelected(true);
        box11.setSelected(true);
        box12.setSelected(true);
        
        inpane.add(box7);
        inpane.add(box1);
        inpane.add(box8);
        inpane.add(box2);
        inpane.add(box9);
        inpane.add(box3);
        inpane.add(box10);
        inpane.add(box4);
        inpane.add(box11);
        inpane.add(box5);
        inpane.add(box12);
        inpane.add(box6);
       
        
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        tempPane.add( new JLabel("ϵͳС��λ��: "));
        number.setText("2");
        tempPane.add(number);
        tempPane.add( new JLabel("λ"));
        inpane.add(tempPane);
        
        inpane.add(new JLabel());
        
        pane.add(inpane);

		return pane;
		
	}
	private JPanel createPane3(){
		

		JPanel pane = new JPanel();
        
        JPanel inpane = new JPanel();
        inpane.setLayout(new GridLayout(6,2));
        inpane.add(new JLabel());
        inpane.add(new JLabel());
        inpane.add(new JLabel());
        inpane.add(new JLabel());
       
        box31.setSelected(true);
        inpane.add(box31);
        inpane.add(box32);
        inpane.add(box33);
        inpane.add(box34);
        

        JPanel tempPane = new JPanel();
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        tempPane.add( new JLabel("POS�˽���С��λ��: "));
        number31.setText("1");
        tempPane.add(number31);
        tempPane.add( new JLabel("λ"));
        inpane.add(tempPane);
    
       
        tempPane = new JPanel();
        tempPane = new JPanel();
        tempPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        tempPane.add( new JLabel("POS����Ʒ����С��λ��: "));
        number32.setText("2");
        tempPane.add(number32);
        tempPane.add( new JLabel("λ"));
        inpane.add(tempPane);
        
        inpane.add(new JLabel());
        
        pane.add(inpane);

		return pane;
		
		
	}
	/*
	 * ���ĸ�ѡ�
	 */
	private JPanel createPane4(){    
       
		JPanel pane = new JPanel();
		
		pane.add(box41);
		pane.add(new JLabel("Զ�̷��ʶ˿�:"));
		
		JTextField field = new JTextField(4);
		field.setText("888");
		field.setEditable(false);
		
		JButton btn = new JButton("��������");
		btn.setEnabled(false);
		pane.add(field);
		pane.add(btn);
		
		return pane;
		
	}
	/*
	 * �����ѡ�������
	 */
	private JPanel createPane5(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.add(new JLabel(new ImageIcon("res/AcionIcon/sptm.jpg")),BorderLayout.NORTH);
		
		JPanel tmpPane = new JPanel();
		tmpPane.add(new JLabel("��Ʒ����λ��: "));
		number51.setText("0");
		tmpPane.add(number51);
		
		tmpPane.add(new JLabel("��Ʒ������λ��: "));
		number52.setText("0");
		tmpPane.add(number52);
		
		tmpPane.add(new JLabel("����λ��: "));
		number53.setText("0");
		tmpPane.add(number53);
		
		tmpPane.add(new JLabel("С��λ��: "));
		number54.setText("2");
		tmpPane.add(number54);
		
		pane.add(tmpPane);
		pane.add(new JLabel(new ImageIcon("res/AcionIcon/remind.jpg")),BorderLayout.SOUTH);
		return pane;
		
	}
	public static void main(String[] args) {
		new OtherSetFrame((JFrame)null,"ϵͳ����",true);
	}

}
