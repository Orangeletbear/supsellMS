package com.cn.view.systemJFrame.shangpingxinxidialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.control.systemframe.sanpingxinxi.AtlerSPOKAction;
import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.util.ChoiceSPLBAction;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
/**
 * �޸���Ʒ��Ϣ�Ի���
 * @author finey
 *
 */
public class AtlerShangPingDialog extends JDialog {

	///��Ʒ���
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
	
	//�����
	JTable table1;
	//��Ʒ�ۿ�
	JTextField spZheKou = new JTextField(12);
	JTextField spDuiHuanJiFen = new JTextField(12);
	
	JCheckBox spIsZhenPing = new JCheckBox("����Ʒ����Ϊ��Ʒ");
	JCheckBox spIsTeJia = new JCheckBox("��Ʒ���ؼ���Ʒ");
	JCheckBox spFirstJiangZhang = new JCheckBox("��Ʒ���ڽ���");
	
	JRadioButton useYes = new JRadioButton("����");
	JRadioButton useNo = new JRadioButton("ͣ��");
	
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

	public JTextField getSpBaoZhiQi() {
		return spBaoZhiQi;
	}

	public JTextField getSpProductor() {
		return spProductor;
	}

	public JTextField getSp_bz() {
		return sp_bz;
	}

	public JTable getTable1() {
		return table1;
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

	
	
	public AtlerShangPingDialog(JDialog frame,String title,boolean model,String spID){
		super(frame,title,model);
		init();
		initData(spID);
		this.setVisible(true);
	}
	
    private void initData(String obj){
    	
		
		//ȡ�ñ�������
		Vector data = SanPingGuanLiJDBC.getASPMassege(obj);
		//��ǰ��Ʒ�����ݷ��������
		spLeiBie.setText(data.get(24).toString());
		spId.setText(data.get(0).toString());
		spId.setEditable(false);
		
		spName.setText(data.get(1).toString());
		
		spTiaoMa.setText(data.get(4).toString());
		
		spGuiGe.setText(data.get(9).toString());
		spDangWei.setSelectedItem(data.get(5));
		
		spKuChun.setText(data.get(11).toString());
		spColor.setSelectedItem(data.get(10).toString());
		spJingPrice.setText(data.get(7).toString());
		spShouPrice.setText(data.get(8).toString());
		if(data.get(24).toString().equals("1")){
			spUseDate.setSelected(true);
		}else{
			spUseDate.setSelected(false);
		}
		
		spBaoZhiQi.setText("100");
		spProductor.setText(data.get(20).toString());
	
		if(data.get(21) ==null){
			sp_bz.setText("");
		}else{
			sp_bz.setText(data.get(21).toString());
		}
		
		spZheKou.setText(data.get(13).toString());
		
		if(data.get(12).toString().equals("1")){
			spIsTeJia.setSelected(true);
		}else{
			spIsTeJia.setSelected(false);
		}
		
		
		if(data.get(18).toString().equals("1")){
			useYes.setSelected(true);
			
		}else{
			useNo.setSelected(true);
		
		}
				
		spTejia.setText(data.get(15).toString());
		spHuiYuanTejia.setText(data.get(14).toString());
		haveTeJia.setSelected(true);
		try {
			dateFrom.setSelectedDate(DateConventer.strToDate(
					data.get(16).toString(), "yyyy-MM-dd"));
			
			dateTo.setSelectedDate(DateConventer.strToDate(
					data.get(17).toString(), "yyyy-MM-dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
    }
	
	private void init(){
		this.setSize(new Dimension(500,500));
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
	    JPanel centerPane = initPane();
	    mainPane.add(centerPane,BorderLayout.CENTER);
	    
	    //�Ϸ����ƿ�
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		JButton okBtn = new JButton("ȷ��");
		okBtn.addActionListener(new AtlerSPOKAction(this));
		JButton cancerBtn = new JButton("ȡ��");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				AtlerShangPingDialog.this.dispose();
			}
			
		});
		southPane.add(okBtn);
		southPane.add(cancerBtn);
		mainPane.add(southPane,BorderLayout.SOUTH);
		return mainPane;
	}
	
	private JPanel initPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel leftUpPane = initLeftUpPane();
		JPanel leftDownPane = initLeftDownPane();
		
		pane.add(leftUpPane);
		pane.add(leftDownPane,BorderLayout.SOUTH);
		

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
	    spLeiBie.setText("����ѡ�����");
	    spLeiBie.setEditable(false);
	    tmpPane.add(tmpLab);
	    tmpPane.add(spLeiBie);
	    tmpPane.add(choiceBtn);
	    spLeiBie.addFocusListener(new FocusListener(){

			public void focusGained(FocusEvent arg0) {
				
			}

			public void focusLost(FocusEvent arg0) {
				
			}
	    	
	    });
	    choiceBtn.addMouseListener(
	    		new ChoiceSPLBAction(this,spLeiBie,false,new JTextField()));
	    
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
	    pane.add(tmpPane);
	    
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
	    pane.add(tmpPane);
	    
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
