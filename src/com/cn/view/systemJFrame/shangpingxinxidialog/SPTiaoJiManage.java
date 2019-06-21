package com.cn.view.systemJFrame.shangpingxinxidialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.control.systemframe.sanpingtiaojia.SanPingTiaoJiOKBtn;
import com.cn.dao.system.SanPingTiaoJiJDBC;
import com.cn.model.AllTableModel;
import com.cn.util.JDatePicker;
import com.cn.view.systemJFrame.SanpinTiaoJiaJFrame;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
/*
 * ��Ʒ���۶Ի���
 */
public class SPTiaoJiManage extends JDialog {


	//��Ʒ���
	JTextField spId = new JTextField(15);
	//��Ʒ��
	JTextField spName = new JTextField(15);
	//��ƷԤ�����
	JTextField spJingPrice = new JTextField(15);
	//��ƷԤ���ۼ�
	JTextField spShouPrice = new JTextField(15);
	//��Ʒ�ۿ�
	JTextField spZheKou = new JTextField(15);
	//��Ʒ�Ƿ��ؼ�
	JCheckBox spIsTeJia = new JCheckBox("��Ʒ���ؼ���Ʒ");
	//��Ʒ�ؼ�
	JTextField spTePrice = new JTextField(15);
	//��Ʒ��Ա��
	JTextField huiYuanTePrice = new JTextField(15);
	//����Ʒֹͣͣ��
	JCheckBox spUse = new JCheckBox("����Ʒֹͣͣ��");
	//����Ʒ�м�������
	JCheckBox haveTeJia = new JCheckBox("����Ʒ���ؼ�����");
	//��������
	private JDatePicker dateFrom;
	private JDatePicker dateTo;
	
	public JTextField getSpId() {
		return spId;
	}
	public JTextField getSpName() {
		return spName;
	}
	public JTextField getSpJingPrice() {
		return spJingPrice;
	}
	public JTextField getSpShouPrice() {
		return spShouPrice;
	}
	public JTextField getSpZheKou() {
		return spZheKou;
	}
	public JCheckBox getSpIsTeJia() {
		return spIsTeJia;
	}
	public JTextField getSpTePrice() {
		return spTePrice;
	}
	public JTextField getHuiYuanTePrice() {
		return huiYuanTePrice;
	}
	public JCheckBox getSpUse() {
		return spUse;
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
	public SPTiaoJiManage(ShangPingGuangLiFrame frame,String title){
		super(frame,title,true);
		init();
		initSPGuangLiData();
		this.setVisible(true);
	}
	public SPTiaoJiManage(SanpinTiaoJiaJFrame frame,String title){
		super(frame,title,true);
		init();
		initSPTiaoJiaData();
		this.setVisible(true);
	}
	/*
	 * ��Ʒ�������ݳ�ʼ��
	 */
	private void initSPGuangLiData(){
		
		ShangPingGuangLiFrame frame = (ShangPingGuangLiFrame)this.getOwner();
		
		int row = frame.getSptable().getSelectedRow(); 
		AllTableModel model = frame.getTableModel();
		
    	updateData(model.getValueAt(row, 0).toString());
    	
		
	}
	
	/*
	 * ��Ʒ�������ݳ�ʼ��
	 */
	private void initSPTiaoJiaData(){
		//ȡ����ѡ�������е�����
		SanpinTiaoJiaJFrame frame = (SanpinTiaoJiaJFrame)this.getOwner();
		
		int row = frame.getSptable().getSelectedRow(); 
		AllTableModel model = frame.getTableModel();

		updateData(model.getValueAt(row, 0).toString());

	}
	/**
	 * ���ݼ��ص�����
	 * @param data
	 */
	
	private void updateData(String  tablespId){
		Vector data = SanPingTiaoJiJDBC.getAData(tablespId);
		
		spId.setText(data.get(0).toString());
    	spId.setEditable(false);
    	
    	spName.setText(data.get(1).toString());
    	spName.setEditable(false);
    
    	spJingPrice.setText(data.get(7).toString());
    	
    	spShouPrice.setText(data.get(8).toString());
    	spZheKou.setText(data.get(13).toString());
    	
    	if("1".equals(data.get(18).toString())){
    		spUse.setSelected(true);
    	}else{
    		spUse.setSelected(false);
    	}
    	spTePrice.setText(data.get(15).toString());
    	huiYuanTePrice.setText(data.get(14).toString());
    	
    	if("1".equals(data.get(12).toString())){
    		haveTeJia.setSelected(true);
    	}else{
    		haveTeJia.setSelected(false);
    	}
	}
	
	
	private void init(){
		this.setSize(new Dimension(400,450));
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
		okBtn.addActionListener(new SanPingTiaoJiOKBtn(this));
		JButton cancerBtn = new JButton("ȡ��");
		cancerBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				SPTiaoJiManage.this.dispose();
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
		
		JPanel upPane = initUpPane();
		JPanel centerPane = initCenterPane();
		JPanel downPane = initDownPane();
		
		pane.add(upPane,BorderLayout.NORTH);
		
		pane.add(downPane,BorderLayout.SOUTH);
		pane.add(centerPane,BorderLayout.CENTER);
		
		return pane;
	}
	//�������
	private JPanel initUpPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(4,2));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel tmpLab = new JLabel("��Ʒ���: ");
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
	    tmpLab = new JLabel("Ԥ�����: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spJingPrice);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("Ԥ���ۼ�: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spShouPrice);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��Ʒ�ۿ�: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spZheKou);
	    pane.add(tmpPane);
		
	    pane.add(spUse);
	    
	    pane.setBorder(new TitledBorder("��Ʒ��Ϣ"));
		return pane;
	}
	//�м����
	private JPanel initCenterPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(3,2));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel tmpLab = new JLabel("��Ʒ�ؼ�: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(spTePrice);
	    pane.add(tmpPane);
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��Ա�ؼ�: ");
	    tmpPane.add(tmpLab);
	    tmpPane.add(huiYuanTePrice);
	    pane.add(tmpPane);

	    pane.add(spIsTeJia);
	    spIsTeJia.setSelected(true);
	    spIsTeJia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(((JCheckBox)arg0.getSource()).isSelected()){
					SPTiaoJiManage.this.spTePrice.setEnabled(true);
					SPTiaoJiManage.this.huiYuanTePrice.setEnabled(true);
					SPTiaoJiManage.this.haveTeJia.setEnabled(true);
					
				}else{
					SPTiaoJiManage.this.spTePrice.setEnabled(false);
					SPTiaoJiManage.this.huiYuanTePrice.setEnabled(false);
					SPTiaoJiManage.this.haveTeJia.setEnabled(false);
				}
			}
	    });
	    
	    pane.add(haveTeJia);
	    haveTeJia.setSelected(true);
	    haveTeJia.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(((JCheckBox)arg0.getSource()).isSelected()){
					SPTiaoJiManage.this.dateFrom.setEnabled(true);
					SPTiaoJiManage.this.dateTo.setEnabled(true);
				}else{
					SPTiaoJiManage.this.dateFrom.setEnabled(false);
					SPTiaoJiManage.this.dateTo.setEnabled(false);
					
				}
			}
	    	
	    });
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("���޴�: ");
	    tmpPane.add(tmpLab);
	    dateFrom=new JDatePicker(JDatePicker.STYLE_CN_DATE);
	    tmpPane.add(dateFrom);
	    pane.add(tmpPane);
	    
	    
	    tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    tmpLab = new JLabel("��: ");
	    tmpPane.add(tmpLab);
	    dateTo =new JDatePicker(JDatePicker.STYLE_CN_DATE);
	    tmpPane.add(dateTo);
	    pane.add(tmpPane);

		pane.setBorder(new TitledBorder("�ؼ���Ʒ"));
		return pane;
	}
	/*
	 * �������
	 */
	private JPanel initDownPane(){
		JPanel pane = new JPanel();
		JButton daZheBtn = new JButton("�������");
		JLabel lab = new JLabel("�������ĵ��۲����������Ҫ��,���Խ��е������");
		lab.setForeground(Color.red);
		
		pane.add(daZheBtn);
		pane.add(lab);
	    
		pane.setBorder(new TitledBorder("�������"));
		pane.setPreferredSize(new Dimension(390,100));
		return pane;
	}
	public static void main(String[] args) {
		
	}

}
