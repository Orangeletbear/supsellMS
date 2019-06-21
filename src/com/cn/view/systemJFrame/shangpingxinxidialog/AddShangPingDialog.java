package com.cn.view.systemJFrame.shangpingxinxidialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.border.TitledBorder;

import com.cn.control.systemframe.sanpingxinxi.AddSPOKAcion;
import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.model.AllTableModel;
import com.cn.util.ChoiceSPLBAction;
import com.cn.util.JDatePicker;
import com.cn.view.jinhuoJFrame.CaiGouJinHuo;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;


/**
 * ������Ʒ��Ϣ�Ի���
 * @author finey
 *
 */
public class AddShangPingDialog extends JDialog {
	//��Ʒ���
	JTextField spLeiBie = new JTextField(12);
	//��Ʒ���
	JTextField spId = new JTextField(18);
	//��Ʒ��
	JTextField spName = new JTextField(18);
	//��Ʒ����
	JTextField spTiaoMa = new JTextField(18);
	//��Ʒ���
	JTextField spGuiGe = new JTextField(18);
	//��Ʒ��λ
	JComboBox spDangWei = new JComboBox(SanPingGuanLiJDBC.getSPDanWei());
	//��Ʒ��Ϳ��
	JTextField spKuChun = new JTextField(18);
	//��Ʒ��ɫ
	JComboBox  spColor = new JComboBox(SanPingGuanLiJDBC.getSPColor());
	//��ƷԤ�����
	JTextField spJingPrice = new JTextField(18);
	//��ƷԤ���ۼ�
	JTextField spShouPrice = new JTextField(18);
	
	//��Ʒʹ������
	JCheckBox spUseDate = new JCheckBox("ʹ�ñ�����");
	//��Ʒ������
	JTextField spBaoZhiQi = new JTextField(12);
	//��Ʒ��������
	JTextField spProductor = new JTextField(18);
	//��Ʒ��ע
	JTextField sp_bz = new JTextField(22);
	
	AllTableModel model ;
	//�����
	JTable table2;
	//��Ʒ�ۿ�
	JTextField spZheKou = new JTextField(12);
	JTextField spDuiHuanJiFen = new JTextField(12);
	
	JCheckBox spIsZhenPing = new JCheckBox("����Ʒ����Ϊ��Ʒ");
	JCheckBox spIsTeJia = new JCheckBox("��Ʒ���ؼ���Ʒ");
	JCheckBox spFirstJiangZhang = new JCheckBox("��Ʒ���ڽ���");
	
	JRadioButton useNo = new JRadioButton("ͣ��");
	JRadioButton useYes = new JRadioButton("����",true);
	
	//��Ʒ�ؼ�
	JTextField spTejia = new JTextField(18);
	//��Ա�ؼ�
	JTextField spHuiYuanTejia = new JTextField(18);
	//��Ʒ���ؼ�����
	JCheckBox haveTeJia = new JCheckBox("����Ʒ���ؼ�����");
	
	JDatePicker  dateFrom = new JDatePicker(
			JDatePicker.STYLE_CN_DATETIME);
	
	JDatePicker dateTo =  new JDatePicker(
			JDatePicker.STYLE_CN_DATETIME);
	
	
	public JTextField getSpTejia() {
		return spTejia;
	}

	public JTextField getSpHuiYuanTejia() {
		return spHuiYuanTejia;
	}

	public JCheckBox getHaveTeJia() {
		return haveTeJia;
	}

	public JDatePicker getDateFrom() {
		return dateFrom;
	}

	public JDatePicker getDateTo() {
		return dateTo;
	}

	public JTextField getSpLeiBie() {
		return spLeiBie;
	}

	public JTextField getSpId() {
		return spId;
	}

	public JTextField getSpName() {
		return spName;
	}

	public JTextField getSpTiaoMa() {
		return spTiaoMa;
	}

	public JTextField getSpGuiGe() {
		return spGuiGe;
	}

	public JComboBox getSpDangWei() {
		return spDangWei;
	}

	public JTextField getSpKuChun() {
		return spKuChun;
	}

	public JComboBox getSpColor() {
		return spColor;
	}

	public JTextField getSpJingPrice() {
		return spJingPrice;
	}

	public JTextField getSpShouPrice() {
		return spShouPrice;
	}

	public JCheckBox getSpUseDate() {
		return spUseDate;
	}

	public AllTableModel getModel() {
		return model;
	}

	public JTextField getSpBaoZhiQi() {
		return spBaoZhiQi;
	}

	public JTextField getSpProductor() {
		return spProductor;
	}

	public JTextField getSp_bz() {
		return sp_bz;
	}

	

	public JTable getTable2() {
		return table2;
	}

	public JTextField getSpZheKou() {
		return spZheKou;
	}

	public JTextField getSpDuiHuanJiFen() {
		return spDuiHuanJiFen;
	}

	public JCheckBox getSpIsZhenPing() {
		return spIsZhenPing;
	}

	public JCheckBox getSpIsTeJia() {
		return spIsTeJia;
	}

	public JCheckBox getSpFirstJiangZhang() {
		return spFirstJiangZhang;
	}

	public JRadioButton getUseNo() {
		return useNo;
	}

	public JRadioButton getUseYes() {
		return useYes;
	}

	
	public AddShangPingDialog(CaiGouJinHuo frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	
	public AddShangPingDialog(ShangPingGuangLiFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(700,500));
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
		
		//�������������
	    JPanel centerPane = initCenterPane();
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //�Ϸ����ƿ�
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("ȷ��");
		okBtn.addActionListener(new AddSPOKAcion(this));
		JButton cancerBtn = new JButton("ȡ��");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				AddShangPingDialog.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
	}
	
	private JPanel initCenterPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		JPanel leftPane = initLeftPane();
	
		JPanel rightPane = initRightPane();
		
		
		splitPane.setLeftComponent(leftPane);
		splitPane.setRightComponent(rightPane);
		splitPane.setDividerLocation(500);
		splitPane.setDividerSize(0);
		
		pane.add(splitPane,BorderLayout.CENTER);
		return pane;
	}
	//������
	private JPanel initLeftPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel leftUpPane = initLeftUpPane();
		JPanel leftDownPane = initLeftDownPane();
		
		pane.add(leftUpPane);
		pane.add(leftDownPane,BorderLayout.SOUTH);
		

		return pane;
	}
	//�ұ����
	private JPanel initRightPane(){
		JPanel pane = new JPanel();
		pane.setBorder(new TitledBorder("�Ѵ���Ʒ"));
		pane.setLayout(new BorderLayout());
		
		model = new AllTableModel(GetFinallyMassage.obj,
				GetFinallyMassage.table2culomns);
		table2 = new JTable(model);
        table2.setPreferredScrollableViewportSize(new Dimension(230,400));
		table2.setAutoCreateRowSorter(true);
        
		pane.add(new JScrollPane(table2));
        return pane;
	}
	//��ߵ��������
	private JPanel initLeftUpPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(7,2));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel tmpLab = new JLabel("�������: ");
	    JButton choiceBtn = new JButton("ѡ�����");
	    choiceBtn.setMargin(new Insets(0,0,0,0));
	    spLeiBie.setText("ѡ�����");
	    spLeiBie.setEditable(false);
	    tmpPane.add(tmpLab);
	    tmpPane.add(spLeiBie);
	    tmpPane.add(choiceBtn);
	    
	    choiceBtn.addMouseListener(
	      new ChoiceSPLBAction(this,spLeiBie,true,spId));
	    
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��Ʒ���: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spId);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��Ʒ����: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spName);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��Ʒ����: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spTiaoMa);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("����ͺ�: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spGuiGe);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��Ʒ��λ: ");
	    spDangWei.setMaximumRowCount(4);
	    tmpPane.add(tmpLab);
	    tmpPane.add(spDangWei);
	    JButton tmp = new JButton("��λ");
	    tmpPane.add(tmp);
	    pane.add(tmpPane);
	    
	    tmp.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new DanWeiManager(AddShangPingDialog.this,"��λ����",true);
			}
	    	
	    });
	    
	    
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("�������: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spKuChun);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��Ʒ��ɫ: ");
	    tmpPane.add(tmpLab);
	    spColor.setMaximumRowCount(4);
	    tmpPane.add(spColor);
	    JButton color = new JButton("��ɫ");
	    tmpPane.add(color);
	    pane.add(tmpPane);
	    
	    color.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new ColorMessager(AddShangPingDialog.this,"��ɫ����",true);
			}
	    	
	    });
	    
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("Ԥ�����: ");
	    spJingPrice.setText("0.0");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spJingPrice);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("Ԥ���ۼ�: ");
	    tmpPane.add(tmpLab);
	    spShouPrice.setText("0.0");
	    tmpPane.add(spShouPrice);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("�� ");
	    tmpPane.add(spUseDate);
	    tmpPane.add(spBaoZhiQi);
	    tmpPane.add(tmpLab);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��������: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spProductor);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��ע: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(sp_bz);
	    
	    pane.add(tmpPane);
	    pane.setBorder(new TitledBorder("��Ʒ������Ϣ"));
		return pane;
	}
	//��ߵ��������
	private JPanel initLeftDownPane(){
		
		JPanel tabPane = new JPanel();
		tabPane.setLayout(new BorderLayout());
		JTabbedPane tbp = new JTabbedPane();
		
		JPanel pane1 = new JPanel();
		pane1.setLayout(new GridLayout(4,2));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel tmpLab = new JLabel("��Ʒ�ۿ�: ");
	    tmpPane.add(tmpLab);
	    spZheKou.setText("1.0");
	    tmpPane.add(spZheKou);
	    pane1.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("0.9Ϊ���ۣ�1.0  Ϊ������ ");
	    tmpLab.setForeground(Color.red);
	    tmpPane.add(tmpLab);
	    pane1.add(tmpPane);
	 
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpPane.add(spIsZhenPing);
	    pane1.add(tmpPane);
	 
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("�һ�����: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spDuiHuanJiFen);
	    pane1.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpPane.add(spIsTeJia);
	    pane1.add(tmpPane);
	 
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		tmpLab = new JLabel("��Ʒ״̬: ");
		ButtonGroup grop = new ButtonGroup();
		
		grop.add(useNo);
		grop.add(useYes);
		
	    tmpPane.add(tmpLab);
	    tmpPane.add(useNo);
	    tmpPane.add(useYes);
	    pane1.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpPane.add(spFirstJiangZhang);
	    pane1.add(tmpPane);
	    

		
		JPanel pane2 = new JPanel();
		pane2.setLayout(new GridLayout(3,2));
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��Ʒ�ؼ�: ");
	    tmpPane.add(tmpLab);
	    spZheKou.setText("0.0");
	    tmpPane.add(spTejia);
	    pane2.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��Ա�ؼ�: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spHuiYuanTejia);
	    pane2.add(tmpPane);
	 
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpPane.add(haveTeJia);
	    pane2.add(tmpPane);
	 
	    pane2.add(new JLabel());
	    
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("���޴�: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(dateFrom);
	    pane2.add(tmpPane);
	    
	 
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(dateTo);
	    pane2.add(tmpPane);
		
	    
	    
	    
	    tbp.add("������Ϣ",pane1);
	    tbp.add("�ؼ���Ϣ",pane2);
	    
	    tabPane.add(tbp);
		return tabPane;
	}
	
	
	public static void main(String[] args) {
	}

}
