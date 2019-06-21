package com.cn.view.toolbar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.cn.control.toolbar.CuCunFindAction;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.util.PrintTableData;
import com.cn.util.SwingCommonPrinitTools;
/**
 * �������ϵĿ���ѯ�Ի���
 * @author finey
 *
 */
public class KuChunFind extends JDialog {
	//״̬���ϵ�����
    private JLabel allLabel = new JLabel("����Ϊ 0",JLabel.RIGHT);
    //״̬���ϵ��ܼ�λ
    private JLabel priceLabel  = new JLabel("�۸�Ϊ0.0",JLabel.RIGHT);
    
    JLabel cklab = new JLabel("�ֿ�: ");
    JComboBox chanKu = new JComboBox(JDBCCuCunFind.getCanKuData());
    
    JLabel lblab = new JLabel("��Ʒ��� : ");
    JComboBox lbField = new JComboBox(JDBCCuCunFind.getSpLbData());
	
	JLabel namelab = new JLabel("��Ʒ��Ż����� : ");
	JTextField spField = new JTextField(10);
	
	JButton findbtn = new JButton("��    ѯ");
	//�����
	AllTableModel tableMo;
	JTable table;
	JCheckBox box = new JCheckBox("����ʾ��ƷΪ�����Ʒ");
    public JComboBox getChanKu() {
		return chanKu;
	}
	
	public JComboBox getLbField() {
		return lbField;
	}

	public JTextField getSpField() {
		return spField;
	}
	public AllTableModel getTableMo() {
		return tableMo;
	}
	public JTable getTable() {
		return table;
	}
	public JCheckBox getBox() {
		return box;
	}
	
	
	public KuChunFind(JFrame frame,String title,boolean model){
		super(frame,title,model);
		
		init();
	}
	/*
	 * �������ñ�ǩ�ĳ�ʼ��
	 */
	private JPanel initLabel(){
		JPanel toolPane = new JPanel();
		toolPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		JButton exit = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exit.setMargin(new Insets(0,0,0,0));
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				KuChunFind.this.dispose();
			}
			
		});
		
		JButton print = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
		print.setMargin(new Insets(0,0,0,0));
		
		print.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SwingCommonPrinitTools().printTable(table.getModel(),"ccc");
			}
			
		});
		JButton export = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
		export.setMargin(new Insets(0,0,0,0));
		export.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", table, 
						TableCulomnModel.KuChunCaXunColumnName);
			}
			
		});
		toolPane.add(export);
		toolPane.add(print);
		toolPane.add(exit);
		return toolPane;
	}
	private void init(){
		
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);//�������
        this.setResizable(false);
        lbField.addItem("�������");
        chanKu.addItem("���вֿ�");
        lbField.setSelectedIndex(lbField.getItemCount()-1);
        chanKu.setSelectedIndex(chanKu.getItemCount()-1);
        this.setVisible(true);
        
	}
	/*
	 * ѡ��ļ���
	 */
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		mainPane.add(initLabel(),BorderLayout.NORTH);
		//�����彨��
		JPanel centerPane = createCenterPane();
	    
		JPanel southPane = createSouthPane();
		
		mainPane.add(centerPane);
		
		mainPane.add(southPane,BorderLayout.SOUTH);

		return mainPane;
	}
	/*
	 * �������Ľ���
	 */
	private JPanel createCenterPane(){
		
           
        final Object[][] data = {};
		
        JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		JPanel downPane = new JPanel();
		downPane.setLayout(new BorderLayout());
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		northPane.add(cklab);
		northPane.add(chanKu);
		northPane.add(lblab);
		northPane.add(lbField);
		northPane.add(namelab);
		northPane.add(spField);
		northPane.add(findbtn);
		northPane.add(box);
		//��ѯ��ť�Ӽ�����
        findbtn.addActionListener(new CuCunFindAction(this));
		downPane.add(northPane,BorderLayout.NORTH);
		//������
		JPanel tablePane = new JPanel();
		
		tableMo = new AllTableModel(data,
				TableCulomnModel.KuChunCaXunColumnName);
		//�½�һ�����
		table = new JTable(tableMo);
		//���̶���С
		table.setPreferredScrollableViewportSize(new Dimension(800, 300));
		table.setAutoCreateRowSorter(true);
		//���Ϊ true��������������߽��ڵ���������
		tablePane.setOpaque(true);
		//��һ��������
		tablePane.add(new JScrollPane(table),BorderLayout.CENTER);
		
		downPane.add(tablePane);
		splitPane.setRightComponent(downPane);
		splitPane.setDividerLocation(70);
		splitPane.setDividerSize(0);
		pane.add(splitPane,BorderLayout.CENTER);

		return pane;
	}
	
	/*
	 * ״̬���Ľ���
	 */
	 private JPanel createSouthPane(){
		 JPanel pane = new JPanel();
		 pane.setLayout(new GridLayout(1,4));
		 
		 pane.add(allLabel);
		 pane.add(priceLabel);
		 pane.add(new JLabel("  "));
		 pane.add(new JLabel("  "));
		 
		 
		 return pane;
		 
	 }
	public static void main(String[] args) {
		new KuChunFind((JFrame)null,"ff",true);
	}

}
