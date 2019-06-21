package com.cn.view.xiaoshouJFrame.shangpinxiaoshou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.xiaoshouframe.shangpinxiaoshuo.DataPickerAlterAction;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.ShangPinXiaoShou_SureAction;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCFindGoodsInfo;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.shangpinxiaoshou.XiaoShouCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.util.PrintTableData;
import com.cn.view.toolbar.TableCulomnModel;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AddXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.AlterXiaoShouGoodsDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.KeHuWind;

/**
 * ��Ʒ���۶Ի���
 * @author Administrator
 *
 */
public class ShangPinXiaoShouDialog extends JDialog {
	
	private JPanel mainPanel = new JPanel();
	
	//��������ϲ������
	//private JPanel topPanel ;
	//���ű�ǩ
	private JLabel danHaoLabel = new JLabel("");
	//�ͻ������ı���
	private JTextField  keHuText = new JTextField(10);
	//��ѯ�ͻ���ť
    private JButton keHuButton = new JButton(new ImageIcon("res/AcionIcon/3.jpg"));
    //�ֿ�Box
    private ComboBoxModel cangKuModel ;
	private JComboBox cangKuBox ;
	//
	
	//ʱ��
	private JDatePicker dataPicker =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
   //�����Ʒ��ť
	private JButton addButton = new JButton("�����Ʒ(F2)");
	//�޸���Ʒ��ť
	private JButton alterButton = new JButton("�޸���Ʒ(F3)");
	//ɾ����Ʒ��ť
	private JButton deleteButton = new JButton("ɾ����Ʒ(F4)");
	
	//�������밴ť
	private JButton daoRuButton = new JButton("���뵼��(F7)");
	
	//������
    private JTable table;

	//��ű���е�����
	Vector<Vector> data  = new Vector<Vector>();
	
	private AllTableModel tableModel ;
	//Ӧ�ս���ı���
	private JTextField yingShouText = new JTextField(6);
	//ʵ�ս���ı���
	private JTextField shiShouText = new JTextField(6);
	//������Box
	private JComboBox jingBanBox ;
	private ComboBoxModel jinBanModel;
	//��ѯ�����˰�ť
	private JButton jingBanButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//ԭʼ�����ı���
	private JTextField danHaoText = new JTextField(10);
	//��ע�ı���
	private JTextField beiZhuText = new JTextField(20);
	//�鿴��ע��Ϣ��ť
	private JButton beiZhuButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
	//ȷ����ť
	private JButton sureButton = new JButton("ȷ��");
	//�˳���ť
	private JButton tuiChuButton = new JButton("�˳�");
	
	//�޲ι��췽��
	public ShangPinXiaoShouDialog(){
		
	}
	//���ι��췽��
	public ShangPinXiaoShouDialog(JFrame frame,String title,boolean modal){
		super(frame,title,modal);
		
		init();
		
	}
	public void init() {
		
		this.setSize(680, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initMainPanel();
		this.add(mainPanel);
		
		this.setVisible(true);
		
	}
	
	public void initMainPanel(){
		JPanel northPane = new JPanel();
		northPane.add(new JLabel("                                     "));
		northPane.add(new JLabel("��Ʒ����"));
		northPane.add(new JLabel("                                  "));
		JLabel label = new JLabel("����:");
		northPane.add(label);
		northPane.add(danHaoLabel);
		 try {
				
			 String date = DateConventer.dateToStr(dataPicker.getSelectedDate(),"yyyy-MM-dd");
			 String s = date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
			 ArrayList dan = JDBCFindGoodsInfo.danJu(date);
			 ArrayList sd = new ArrayList();
			 for(int i = 0;i < dan.size();i++){
				 String dan1 = dan.get(i).toString();
				 if(dan1.substring(2, 10).equals(s)){	 
					 sd.add(dan1);
				 }
			 }
			//���������ڵ������պ����ڵ��쵥�ݺŵ�˳����Ϊ���ݺ�
			 if(sd.size()==0){
				danHaoLabel.setText("XS"+s+"0001") ;
				
			 }else{
				 int max = 0;
				 String h = null;
				 for(int i = 0;i< sd.size();i++){
					    max = Integer.parseInt(sd.get(0).toString().substring(11, 14));
					 
			        	if(Integer.parseInt(sd.get(i).toString().substring(11, 14)) > max){
			        		max = Integer.parseInt(sd.get(i).toString().substring(11, 14));
			        	}
			        	
			    }
				 if(max>0 && max+1<10){
		        		h = "000"+(max+1);
		        	}else if(max+1>9 && max+1<100){
		        		h = "00"+(max+1);
		        	}else if(max+1 >99&& max+1< 1000){
		        		h = "0"+(max+1);
		        	}else {
		        		h = ""+(max+1);
		        	}
				 //����
				danHaoLabel.setText("XS"+s+h) ;
		      }	} catch (ParseException e2) {
					
					e2.printStackTrace();
				}
		
		danHaoLabel.setForeground(Color.RED);
		
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(northPane,BorderLayout.NORTH);
		mainPanel.add(createNorthPane(),BorderLayout.CENTER);
		 	
		
	}
	/**
	 * 
	 * @return
	 */
	public JPanel createNorthPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		
		
		JPanel panel1 = new JPanel();
		FlowLayout layout =new FlowLayout(FlowLayout.LEFT);
		panel1.setBorder(new LineBorder(Color.GRAY));
		layout.setHgap(15);
		panel1.setLayout(layout);
		panel1.add(new JLabel("�ͻ�����:"));
		panel1.add(keHuText);
		keHuButton.setMargin(new Insets(0,0,0,0));
	
		keHuButton.addMouseListener(new MouseAdapter(){
			
		
			public void mouseClicked(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
			    int y = arg0.getYOnScreen();
			    
				new KeHuWind(ShangPinXiaoShouDialog.this).setLocation(x-190,y-20);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});


	
		panel1.add(keHuButton);	
		panel1.add(new JLabel("�����ֿ�:"));
		cangKuModel = new DefaultComboBoxModel(JDBCGetInfo.getCangKuData());
		cangKuBox= new JComboBox(cangKuModel);
		panel1.add(cangKuBox);
		panel1.add(new JLabel("��������:"));
		panel1.add(dataPicker);
		dataPicker.addActionListener(new DataPickerAlterAction(this));
		dataPicker.setEditable(false);//����Ϊ���ɱ༭;
		
		JPanel southPane = new JPanel();
		southPane.setBorder(new LineBorder(Color.GRAY));
		southPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		southPane.add(new JLabel("��ע:"));
		southPane.add(beiZhuText);
		beiZhuButton.setMargin(new Insets(0,0,0,0));
		southPane.add(beiZhuButton);
	    southPane.add(new JLabel("                               "));
		southPane.add(sureButton);
		sureButton.addActionListener(new ShangPinXiaoShou_SureAction(this));
		southPane.add(tuiChuButton);
		
		tuiChuButton.addActionListener(new ActionListener(){
		          public void actionPerformed(ActionEvent e) {
				
		        	  if(tableModel.getRowCount() == 0){
		        			dispose();
		        	  }else{
		        		  int n = JOptionPane.showOptionDialog(ShangPinXiaoShouDialog.this,
		        			 "��ǰ���ݻ�û���棬�Ƿ��˳���", "ϵͳ��ʾ", 
		        			 JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null,null);
		        		  if(n == JOptionPane.YES_OPTION){
		        			  dispose();
		        		  }else {
		        			  
		        		  }
		        	  }
				    
				}
 				
 			});
		
		pane.add(panel1,BorderLayout.NORTH);
		pane.add(createCenterPane (),BorderLayout.CENTER);
		pane.add(southPane,BorderLayout.SOUTH);
		
		return pane;
	}
	
	/**
	 * ��ʼ���м����
	 * @return
	 */
	public JPanel createCenterPane () {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		northPanel.add(addButton);
		addButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			new AddXiaoShouGoodsDialog(ShangPinXiaoShouDialog.this,"������Ʒ(��Ʒ����)");
			}
			
		});
		alterButton.setVisible(false);
		alterButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new AlterXiaoShouGoodsDialog(ShangPinXiaoShouDialog.this,"��Ʒ��Ϣ");
				
			}
			
		});
		deleteButton.setVisible(false);
		northPanel.add(alterButton);
		northPanel.add(deleteButton);
		deleteButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showOptionDialog(ShangPinXiaoShouDialog.this, "�Ƿ�Ҫɾ������Ʒ��Ϣ!", "ϵͳ��ʾ", 
						  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
			    if(n == JOptionPane.YES_OPTION){
			    	int row = table.getSelectedRow();
			    	tableModel.removeRow(row);
			    }
			}
			
		});
		northPanel.add(daoRuButton);
		
		daoRuButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", table, 
						XiaoShouCulomnModel.columnNames);
			}
			
		});
		JPanel southPanel = new JPanel();
		
		southPanel.setBorder(new LineBorder(Color.GRAY));
		southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		southPanel.add(new JLabel("Ӧ�ս��:"));
		southPanel.add(yingShouText);
		southPanel.add(new JLabel("ʵ�ս��:"));
		southPanel.add(shiShouText);
		southPanel.add(new JLabel("������:"));
		jinBanModel = new DefaultComboBoxModel(JDBCGetInfo.getJingBanRenData());
		jingBanBox = new JComboBox(jinBanModel);
		southPanel.add(jingBanBox);
		jingBanButton.setMargin(new Insets(0,0,0,0));
		southPanel.add(jingBanButton);
		southPanel.add(new JLabel("ԭʼ����:"));
		southPanel.add(danHaoText);
		
		JPanel center = new JPanel();
		tableModel = new AllTableModel(data,
				            AllTableModel.getVectorFromObj(XiaoShouCulomnModel.columnNames));
	    table = new JTable(tableModel);
	
		JScrollPane scroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 2){
					new AlterXiaoShouGoodsDialog(ShangPinXiaoShouDialog.this,"��Ʒ��Ϣ");
				}
			}
		});
		
		
		table.setPreferredScrollableViewportSize(new Dimension(670,356));//���̶���С
		center.add(scroll);
		center.setOpaque(true);
		
		pane.add(northPanel,BorderLayout.NORTH);
		pane.add(center,BorderLayout.CENTER);
		pane.add(southPanel,BorderLayout.SOUTH);
		
		return pane;
	}
	
	public JLabel getDanHaoLabel() {
		return danHaoLabel;
	}
	public JTextField getKeHuText() {
		return keHuText;
	}
	public ComboBoxModel getCangKuModel() {
		return cangKuModel;
	}
	public JComboBox getCangKuBox() {
		return cangKuBox;
	}

	public Vector<Vector> getData() {
		return data;
	}
	public JDatePicker getDataPicker() {
		return dataPicker;
	}
	public JTable getTable() {
		return table;
	}
	public AllTableModel getTableModel() {
		return tableModel;
	}
	public JTextField getYingShouText() {
		return yingShouText;
	}
	public JTextField getShiShouText() {
		return shiShouText;
	}
	public JComboBox getJingBanBox() {
		return jingBanBox;
	}
	public JButton getAlterButton() {
		return alterButton;
	}
	public JButton getDeleteButton() {
		return deleteButton;
	}
	public ComboBoxModel getJinBanModel() {
		return jinBanModel;
	}
	public JTextField getDanHaoText() {
		return danHaoText;
	}
	public JTextField getBeiZhuText() {
		return beiZhuText;
	}
	//������
	public static void main(String[] args) {
		new ShangPinXiaoShouDialog(null,"��Ʒ����",true);
		

	}

}

