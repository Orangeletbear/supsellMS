package com.cn.view.toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.toolbar.DanJuFindBtnAction;
import com.cn.control.toolbar.DanJuTableSelectAction;
import com.cn.model.AllTableModel;
/*
 * �������ϵĵ��ݲ�ѯ��ť�Ի���
 */
public class DanJuFindDialog extends JDialog {
	
	JCheckBox box = new JCheckBox("��ѯ���۵���ע");
	
	JLabel lblab = new JLabel("���뵥�ݺ�: ");
	//���ݺ������
	JTextField lbField = new JTextField(15);
	//��������
	JTable table;
	
	AllTableModel tabelModel  = new AllTableModel(TableCulomnModel.obj,
			TableCulomnModel.TodayColumnName1);
	
	//��������
	JTable table2;
	AllTableModel tabelModel1  = new AllTableModel(TableCulomnModel.obj,
			TableCulomnModel.DangJuFindColumnName1);
	
	
	public JTable getTable() {
		return table;
	}

	public JTable getTable2() {
		return table2;
	}

	public JCheckBox getBox() {
		return box;
	}

	public JTextField getLbField() {
		return lbField;
	}

	public DanJuFindDialog(JFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
	}

	/*
	 * �Ի��򲼾ֳ�ʹ��
	 */
	private void init(){
		this.setSize(new Dimension(850,550));
        this.add(createPane());
        
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
        /*table.requestFocus();
        table.setRowSelectionInterval(0,0);*/
        this.setVisible(true);
	}
	/*
	 * �м����ļ���
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		mainPane.add(initNorthPane(),BorderLayout.NORTH);
		//�����彨��
		JPanel centerPane = createCenterPane();
	    
		mainPane.add(centerPane);

		return mainPane;
	}
	/*
	 * ���湤������ť
	 */
	private JPanel initNorthPane(){
		JPanel pane = new JPanel();

		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		JButton exit = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exit.setMargin(new Insets(0,0,0,0));
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				DanJuFindDialog.this.dispose();
			}
			
		});
		
		JButton findDangju = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
		findDangju.setMargin(new Insets(0,0,0,0));
		
		JLabel lab = new JLabel("�ɲ���ɹ����������ɹ��˻��������۵��������˻�������ϸ��Ϣ,֧��ģ����ѯ");
		lab.setFont(new Font("",Font.PLAIN,17));
		lab.setPreferredSize(new Dimension(600,70));
		lab.setForeground(Color.red);
        
		pane.add(findDangju);
		pane.add(exit);
		pane.add(lab);

		return pane;
	}
	/*
	 * �������Ľ���
	 */
	private JPanel createCenterPane(){
		
		JPanel downPane = new JPanel();
		downPane.setLayout(new BorderLayout());
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		
		JButton findbtn = new JButton("��    ѯ");
		findbtn.addActionListener(new DanJuFindBtnAction(this));
        findbtn.setToolTipText("�ղ�ѯ��������");
		northPane.add(box);
		northPane.add(lblab);
		northPane.add(lbField);
		northPane.add(findbtn);
		
		downPane.add(northPane,BorderLayout.NORTH);
		//������
		JPanel tablePane = new JPanel();
		tablePane.setLayout(new GridLayout(2,1));
        
		//JPanel tmp = new JPanel();
		//tmp.setLayout(new BorderLayout());
		//�½�һ�����
		table = new JTable(tabelModel);
		//���̶���С
		table.setPreferredScrollableViewportSize(new Dimension(1000, 150));		
		table.setAutoCreateRowSorter(true);
		//tmp.add(new JScrollPane(table));
		JPanel pane2 = new JPanel();
		pane2.setLayout(new BorderLayout());
		pane2.setBorder(new TitledBorder("��ϸ����"));
	    table.addMouseListener(new DanJuTableSelectAction(this));
        //��2
		table2 = new JTable(tabelModel1);
		//�ӱ߿�
		
		//���̶���С
		table2.setPreferredScrollableViewportSize(new Dimension(750,150));
		pane2.add(new JScrollPane(table2));
		table2.setFont(new Font("����",Font.PLAIN,17));
		table2.setRowHeight(25);
		table2.setAutoCreateRowSorter(true);
		//��һ��������
		tablePane.add(new JScrollPane(table));
		tablePane.add(new JScrollPane(pane2));
		
		downPane.add(new JScrollPane(tablePane));

		return downPane;
	}

	public AllTableModel getTabelModel() {
		return tabelModel;
	}

	public AllTableModel getTabelModel1() {
		return tabelModel1;
	}

	public static void main(String[] args) {
		new DanJuFindDialog((JFrame)null,"ff",true);
	}

}
