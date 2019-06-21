package com.cn.view.kuchunJFrame.GongYong;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import com.cn.control.kuchunframe.kucundiaobo.AddShangPinMouseListener;
import com.cn.control.kuchunframe.kucundiaobo.Send_ShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.ShangPinMohuChaXunDocumentListener;
import com.cn.control.kuchunframe.kucundiaobo.chooseshangpin.DeleteShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.chooseshangpin.JRSX_XiuGaiShangPinAction;
import com.cn.control.kuchunframe.kucundiaobo.chooseshangpin.XiuGaiShangPinMouseListener;
import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.addshangpin.AddShangPinDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.GongYong.AddSanPingCulomns;
import com.cn.util.InitTreePane;
import com.cn.view.kuchunJFrame.BaosunBaoyi;
import com.cn.view.kuchunJFrame.ChaifenKunbang;
import com.cn.view.kuchunJFrame.KucunDiaobo;
/**
 * ������Ʒ�Ի���
 * @author finey
 *
 */


public class AddSanPingDialog extends JDialog {
	private KucunDiaobo kDialog;
	private BaosunBaoyi bDialog;
	private ChaifenKunbang cDialog;
	//�������������ֱ�־,0 Ϊ��֣�1Ϊ����
	private String flag;
	//�������־���֣�0Ϊ����1Ϊ����
	private String bFlag;
	//����Vector
	private Vector vo1 = new Vector();
	private Vector vo2 = new Vector();
	private Vector vo3 = new Vector();

	private Vector ve1 = new Vector();
	private Vector ve2 = new Vector();
	private Vector ve3 = new Vector();

	//������ѡ��Ʒ
	private JButton addBtn;
//	�޸�
	private JButton aterBtn;
	//��Ʒ�嵥
	private JTable spqdtable;
	//��Ʒ�б�
	private  JTable splbtable;
	//��ѡ��Ʒ
	private JTable sxsptable;
	//��ߵ�һ��ѡ�����model
	private  AllTableModel tableModel1;
	//��ߵڶ���ѡ�����model
	private AllTableModel tableModel2;
	//�ұ�����model
	private AllTableModel tableModel3;
	
	
	//�����ϱ��
	private JTextField spbhfield ;
	
	//��Ʒ�������ṹ
	private JTree tree;
	
	
	//��ø��ര��
	public KucunDiaobo getKDialog() {
		return kDialog;
	}
	
	public String getBFlag() {
		return bFlag;
	}


	public JButton getAterBtn() {
		return aterBtn;
	}

	public BaosunBaoyi getBDialog() {
		return bDialog;
	}

	public ChaifenKunbang getCDialog() {
		return cDialog;
	}
	//��ȡ��־
	public String getFlag() {
		return flag;
	}

	//��ȡvector 
	public Vector getVo3() {
		return vo3;
	}

	public Vector getVo1() {
		return vo1;
	}

	public Vector getVo2() {
		return vo2;
	}

	public Vector getVe1() {
		return ve1;
	}

	public Vector getVe2() {
		return ve2;
	}

	public Vector getVe3() {
		return ve3;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	//�����Ʒ��Ϣ�����ı���
	public JTextField getSpbhfield() {
		return spbhfield;
	}
	
	//jtable��Ϣ�Ļ�ȡ
	//��Ʒ�б�
	public JTable getSplbtable() {
		return splbtable;
	}
//��Ʒ�嵥
	public JTable getSpqdtable() {
		return spqdtable;
	}
//��ѡ��Ʒ
	public JTable getSxsptable() {
		return sxsptable;
	}

	//��ȡ��ģʽ
	public AllTableModel getTableModel1() {
		return tableModel1;
	}

	public AllTableModel getTableModel2() {
		return tableModel2;
	}

	public AllTableModel getTableModel3() {
		return tableModel3;
	}
	
/*	public AddSanPingDialog(JDialog dialog, String title,String name){
		super(dialog,title,true);
		init();
		addGetDatas(name);
	}*/
	//����������
	public AddSanPingDialog(KucunDiaobo dialog, String title,String name){
		super(dialog,title,true);
		init();
		kDialog = dialog;
		addGetDatas(name);
		this.setVisible(true);
	}
	//�����細��
	public AddSanPingDialog(BaosunBaoyi dialog, String title,String name,String bflag){
		super(dialog,title,true);
		init();
		this.bFlag = bflag;
		bDialog = dialog;
		addGetDatas(name);
	}
	
	//������󴰿�
	public AddSanPingDialog(ChaifenKunbang dialog, String title,String name,boolean b,String flag){
		super(dialog,title,true);
		init();
		cDialog = dialog;
		this.flag = flag;
		addGetDatas(name);
	}
	
	//��ʼ�������Ʒͬʱ��ѡ��ֿ�����Ʒ��Ϣ��ѯ����
	private void addGetDatas(String name){
//		Vector datas = AddShangPinDataToView.dataToView(name);
		Object[][]datas = AddShangPinDataToView.dataToView(name);
//		tableModel1.setDataVector(datas,AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName1));
		tableModel1.setDataVector(datas,AddSanPingCulomns.ColumnName1);
//		spqdtable.setRowSelectionInterval(0, 0);
	}
	
	//------------------------------------------------
	private void init(){
		this.setSize(new Dimension(950,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.add(createPane());
		this.setResizable(false);
	}
	//------------------------------------------------
	//�������
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		//�ֱ����
		JSplitPane splitPane = new JSplitPane();
		
		//����������
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout(2,2));
		leftPane.setBorder(new TitledBorder("ѯ����Ʒ�б�"));
		leftPane.add(initLeftPane());
		splitPane.setLeftComponent(leftPane);

		//�ұ����Ľ���
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		rightPane.setBorder(new TitledBorder("��ѡ��Ʒ"));
		rightPane.add(initRightPane());
		
		splitPane.setRightComponent(rightPane);
		//splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(500);
		splitPane.setDividerSize(0);
		mainPane.add(splitPane);
		return mainPane;
	}
	//------------------------------------------------
	//��ʹ��������
	private JPanel initLeftPane(){
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout());
		//------------------------------
		JPanel northPane = new JPanel();
		JLabel lab = new JLabel("������Ʒ��Ż����ƣ� ");
		spbhfield = new JTextField(10);
		{
			spbhfield.getDocument().addDocumentListener(new ShangPinMohuChaXunDocumentListener(this));
		}
		addBtn = new JButton("������ѡ��Ʒ��F8��");
		{
			addBtn.addActionListener(new AddShangPinMouseListener(this));
		}
		northPane.add(lab);
		northPane.add(spbhfield);
		northPane.add(addBtn);
		leftPane.add(northPane,BorderLayout.NORTH);
		//----------------------------------
		
		JTabbedPane  tabblePane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		//����ѡ�
		JPanel pane1 = createPane1();
		JPanel pane2 = createPane2();
		
		tabblePane.add("��Ʒ�嵥",pane1);
		tabblePane.add("��Ʒ�б�",pane2);
		
		leftPane.add(tabblePane);
		return leftPane;
	}
	//------------------------------------------------
	//��һ��ѡ����
	 private JPanel createPane1(){
         JPanel pane = new JPanel();
         pane.setLayout(new BorderLayout());
         
       vo1 =  AllTableModel.getVectorDataFromObj(AddSanPingCulomns.data);
       ve1 = AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName1);
         
       tableModel1 = new AllTableModel(vo1,ve1);
       spqdtable = new JTable(tableModel1);
       spqdtable.addMouseListener(new AddShangPinMouseListener(this));
         
         //���̶���С
       spqdtable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
 		 //���Ϊ true��������������߽��ڵ���������
       spqdtable.setOpaque(true);
       //��ȡ����(0,0)
       spqdtable.requestFocus();
       
/*       ListSelectionModel listSelectionModel = new DefaultListSelectionModel();   
		listSelectionModel .setSelectionInterval(0, 0);   
		spqdtable.setSelectionModel(listSelectionModel);*/ 
//       spqdtable.setRowSelectionInterval(0, 0);
 		//����Զ�����
       spqdtable.setAutoCreateRowSorter(true);
 		//��һ��������
         pane.add(new JScrollPane(spqdtable));
		 return pane;
		 
	 }
	//------------------------------------------------
	 //�ڶ���ѡ����
	 private JPanel createPane2(){
		    JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			//�ֱ����
			JSplitPane splitPane = new JSplitPane();
			
			//����������
			JPanel leftPane = new JPanel();
			leftPane.setLayout(new BorderLayout());
			
			leftPane.add(new JScrollPane(new InitTreePane(tree).getPane()),
					BorderLayout.CENTER);
			splitPane.setLeftComponent(leftPane);
		
			JPanel rightPane = new JPanel();
			rightPane.setLayout(new BorderLayout());
			
			JPanel tablePane = new JPanel();
			vo2 =  AllTableModel.getVectorDataFromObj(AddSanPingCulomns.data);
		    ve2 = AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName2);
			 tableModel2 = new AllTableModel(vo2,ve2);
			//�½�һ�����
			 splbtable = new JTable(tableModel2);
			//���̶���С
			 splbtable.setPreferredScrollableViewportSize(new Dimension(360, 450));
			//���Ϊ true��������������߽��ڵ���������
			tablePane.setOpaque(true);
			//����Զ�����
			splbtable.setAutoCreateRowSorter(true);
			//��һ��������
			tablePane.add(new JScrollPane(splbtable,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),BorderLayout.CENTER);
			
			rightPane.add(new JScrollPane(tablePane));
			splitPane.setRightComponent(rightPane);
			splitPane.setOneTouchExpandable(true);
			splitPane.setDividerLocation(120);
			splitPane.setDividerSize(2);
			pane.add(splitPane);
			return pane;
	 }
	//------------------------------------------------
		
	//��ʹ���ұ����
	private JPanel initRightPane(){
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		
		//////��ͬ�Ĺ��ܲ��ֱ����������
		/*if(this.getOwner() instanceof BaosunBaoyi){
			vo3 = AllTableModel.getVectorDataFromObj(AddSanPingCulomns.data);
			ve3 = AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName3);
		}*/
		
		vo3 = AllTableModel.getVectorDataFromObj(AddSanPingCulomns.data);
		ve3 = AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName3);
		
		tableModel3 = new AllTableModel(vo3,ve3);
		sxsptable = new JTable(tableModel3);
        //���̶���С
		sxsptable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
		 //���Ϊ true��������������߽��ڵ���������
		
/*		ListSelectionModel listSelectionModel = new DefaultListSelectionModel(); 
		listSelectionModel .setSelectionInterval(0, 0); 
		sxsptable.setSelectionModel(listSelectionModel);*/
		
		sxsptable.setOpaque(true);
		//����Զ�����
		sxsptable.setAutoCreateRowSorter(true);
		//��һ��������
        rightPane.add(new JScrollPane(sxsptable));
        
        JPanel btnPane = new JPanel();
        btnPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        aterBtn = new JButton("�޸�(F3)");
        JButton deleteBtn = new JButton("ɾ��(Del)");
        JButton okBtn = new JButton("ȷ��(F5)");
        {
        	JRSX_XiuGaiShangPinAction lis = new JRSX_XiuGaiShangPinAction(this);
        	sxsptable.addMouseListener(lis);
        	aterBtn.addActionListener(lis);
        	
        	deleteBtn.addActionListener(new DeleteShangPinAction(this));
        	okBtn.addActionListener(new Send_ShangPinAction(this));
        }
        JButton canncerBtn = new JButton("ȡ��(F4)");
        canncerBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddSanPingDialog.this.dispose();
			}
        });
        btnPane.add(aterBtn);
        btnPane.add(deleteBtn);
        btnPane.add(okBtn);
        btnPane.add(canncerBtn);
        
        rightPane.add(btnPane,BorderLayout.SOUTH);
		return rightPane;
	}
	
	//------------------------------------------------
	
/*	public static void main(String[] args) {
		new AddSanPingDialog(null,"������Ʒ");
	}*/

}
