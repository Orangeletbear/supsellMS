package com.cn.view.xiaoshouJFrame.guketuihuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.control.xiaoshouframe.guketuihuo.ChaZhaoKeHuButtonAction;
import com.cn.control.xiaoshouframe.guketuihuo.DatePickerAlterAction;
import com.cn.control.xiaoshouframe.guketuihuo.GaoJiChaXunAction;
import com.cn.control.xiaoshouframe.guketuihuo.GuKeTuiHuoSureAction;
import com.cn.control.xiaoshouframe.guketuihuo.TuiHuoDanJuFindAction;
import com.cn.control.xiaoshouframe.guketuihuo.TuiHuoMouseListener;
import com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun.ZhengDanTuiHuoAction;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.dao.xiaoshou.guketuihuo.JDBCTuiHuoDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AlterGoodsDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;

/**
 * �˿��˻��Ի���
 * @author Administrator
 *
 */
public class GuKeTuiHuoDialog extends JDialog{
	
	    /**
	     * ��һ��ѡ��ϵ����
	     */
	
	   private MainFrame  mainFrame;
	   private JPanel guKeTuiHuoPane = new JPanel();
		
		//�˿��˻�ѡ��Ĺ˿��˻���ǩ
		private JLabel topicLabel  = new JLabel("�˿��˻�");
		//�˿��˻�ѡ��ĵ��ű�ǩ
		
		private JLabel danHaoLabel = new JLabel("");
		//�ͻ����Ʊ�ǩ
		private JLabel nameLabel = new JLabel("�ͻ�����:");
		//�ͻ��ı���
		private JTextField  keHuText1 = new JTextField(15);
	
		//��ѯ�ͻ���ť
		private JButton keHuButton = new JButton(new ImageIcon("res/AcionIcon/3.jpg"));
		//�ջ��ֿ��ǩ
		private JLabel shouHuoCangKuLabel = new JLabel("�ջ��ֿ�:");
		//�ֿ�Box
		
		private DefaultComboBoxModel cangKuModel ;
		private JComboBox cangKuBox ;
		//�������ڱ�ǩ
		private JLabel riQiLabel = new JLabel("��������:");
		//ʱ��
		private JDatePicker dataPicker =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		//
		private JLabel infoLabel = new JLabel("");
		//����˻���Ʒ��ť
		private JButton addButton = new JButton("����˻���Ʒ(F2)");
		//�޸���Ʒ��Ʒ��ť
		private JButton alterButton = new JButton("�޸���Ʒ(F3)");
		//ɾ����Ʒ��Ʒ��ť
		private JButton deleteButton = new JButton("ɾ����Ʒ(F4)");
		//�����˻���ť
		private JButton tuiHuoButton = new JButton("�����˻�(F7)");
		
		//��������²������

	    private JTable table;
	    
	    
	    private DanJuChaXunDialog dialog = ZhengDanTuiHuoAction.getDialog() ;
	   

		private AllTableModel tableModel;
		
		//Ӧ�˽���ǩ
		private JLabel yingTuiMoneyLabel = new JLabel("Ӧ�˽��:");
		//Ӧ�˽���ı���
		private JTextField yingTuiText = new JTextField(15);
		//ʵ�ս���ǩ
		private JLabel shiTuiMoneyLabel = new JLabel("ʵ�˽��:");
		//ʵ�ս���ı���
		private JTextField shiTuiText = new JTextField(15);
		//�����˱�ǩ
		private JLabel jingBanRenLabel = new JLabel("������:");
		//������Box
		private JComboBox jingBanBox ;
		private DefaultComboBoxModel jinBanModel;
		
		//��ű���е�����
		Vector<Vector> data  = new Vector<Vector>();
		//��ѯ�����˰�ť
		private JButton jingBanButton = new JButton(new ImageIcon("res/AcionIcon/1.jpg"));
		//��ע��ǩ
		private JLabel beiZhuLabel = new JLabel("��ע:");
		//��ע�ı���
		private JTextField beiZhuText = new JTextField(40);
		//�鿴��ע��ť
		private JButton beiZhuButton = new JButton(new ImageIcon("res/AcionIcon/1.jpg"));
		//ȷ����ť
		private JButton sureButton = new JButton("ȷ��");
		//�˳���ť
		private JButton tuiChuButton1 = new JButton("�˳�");
		
		/**
		 * �ڶ���ѡ��ϵ����
		 */
		
		private JPanel tuiHuoChaXunPane = new JPanel();
//		�˻���ѯ���ĸ߼���ѯ��ť
		private JButton chaXunButton = new JButton(new ImageIcon("res/AcionIcon/advanceFind.jpg"));
		//�˻���ѯ���Ĳ鿴���ݰ�ť
		private JButton chaKanButton = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
		//�˻���ѯ���ĵ�����ť
		private JButton daoChuButton = new JButton(new ImageIcon("res/AcionIcon/daochu.jpg"));
		//�˻���ѯ�����˳���ť
		private JButton tuiChuButton = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
	    //����ʱ��
		private JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
		private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
		
		//�鿴ʱ�䰴ť
		private JButton shiJianButton = new JButton(new ImageIcon("res/AcionIcon/2.jpg"));
		//�ͻ��ı���
		private JTextField keHuText = new JTextField(15);
		//��ѯ��ť
		private JButton chaXun = new JButton("��ѯ(F2)");
		
		private JRadioButton danJuBiao = new JRadioButton("���ݱ�");
		
		//��һ�����
		private JTable danJuTable;
		private AllTableModel danJuModel;
		
		//�ڶ������
		
		private JTable xiangXiTable ;	
		private AllTableModel xiangXiModel;
		
		private JLabel information = new JLabel("");
		

		public GuKeTuiHuoDialog(MainFrame  mainFrame,String title,boolean model) {
			super(mainFrame,title,model);
			this.mainFrame  = mainFrame;
			init();
			this.setVisible(true);
			
		}
	    

	/*  //��ʼ��ʱ������ 
	    public GuKeTuiHuoDialog(JDialog dialog,String title,boolean model) {
			super(dialog,title,model);
			init();
		
			this.setVisible(true);
			
		}*/
	   
	    //��ʼ��ʱ������ 
	    public GuKeTuiHuoDialog(JDialog dialog,String title,boolean model,boolean isaddData) {
			super(dialog,title,model);
			init();
			addData();
		//	this.setVisible(true);
			
		}
		/**
		 * ��ʼ���˿��˻��Ի���
		 */
		public void init(){
			
			this.setSize(800, 550);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
		
			this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			//�رմ����¼�
			GuKeTuiHuoDialog.this.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
				
					 if(tableModel.getRowCount() == 0){
		        			dispose();
		        	  }else{
		        		  int n = JOptionPane.showOptionDialog(GuKeTuiHuoDialog.this,
		        			 "��ǰ���ݻ�û���棬�Ƿ�رմ��ڣ�", "ϵͳ��ʾ", 
		        			 JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE, null, null,null);
		        		  if(n == JOptionPane.YES_OPTION){
		        			  dispose();
		        		  }else {
		        			
		        		  }
		        	  }
				}
			});
			JTabbedPane pane = new JTabbedPane();
			pane.addTab("�˿��˻�",initguKeTuiHuoPane());
			pane.addTab("�˻���ѯ",initTuiHuoChaXunPane());
			this.add(pane);
			
		}

		/**
		 * ��ʼ���˿��˻�ѡ��ϵ������
		 */
		public JPanel initguKeTuiHuoPane(){
			JPanel northPane = new JPanel();
			northPane.add(new JLabel("                                     "));
			northPane.add(topicLabel);
			northPane.add(new JLabel("                                  "));
			northPane.add(new JLabel("����:"));
	        danHaoLabel.setForeground(Color.RED);
			northPane.add(danHaoLabel);
			 try {
					
				 String date = DateConventer.dateToStr(dataPicker.getSelectedDate(),"yyyy-MM-dd");
				 String s = date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
				
				 ArrayList dan = JDBCTuiHuoDanJuFind.danJuId(date);
				
				 ArrayList sd = new ArrayList();
				 for(int i = 0;i < dan.size();i++){
					 String dan1 = dan.get(i).toString();
				
					 if(dan1.substring(2, 10).equals(s)){	 
						 sd.add(dan1);
					 }
				 }
				
				//���������ڵ������պ����ڵ��쵥�ݺŵ�˳����Ϊ���ݺ�
				 if(sd.size()==0){
					danHaoLabel.setText("XT"+s+"0001") ;
					
				 }else{
					 int max = 0;
					 String h = null;
					 for(int i = 0;i< sd.size();i++){
						    max = Integer.parseInt(sd.get(0).toString().substring(11, 14));
						 
				        	if(Integer.parseInt(sd.get(i).toString().substring(11, 14)) > max){
				        		max = Integer.parseInt(sd.get(i).toString().substring(11, 14));
				        		
				        	}
	
				    }
					 if(max+1>0 && max+1<10){
			        		h = "000"+(max+1);
			        	}else if(max+1>9 && max+1<100){
			        		h = "00"+(max+1);
			        	}else if(max+1 >99&& max+1< 1000){
			        		h = "0"+(max+1);
			        	}else {
			        		h = ""+(max+1);
			        	}
					 //����
					danHaoLabel.setText("XT"+s+h) ;
			      }	} catch (ParseException e2) {
						
						e2.printStackTrace();
					}
			
			guKeTuiHuoPane.setLayout(new BorderLayout());
			guKeTuiHuoPane.add(northPane,BorderLayout.NORTH);
			guKeTuiHuoPane.add(createNorthPane(),BorderLayout.CENTER);
			
			return guKeTuiHuoPane;
			
		}
		/**
		 * �������������Ĳ���
		 * @return  �������
		 */
		public JPanel createNorthPane() {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			JPanel northPane = new JPanel();
			
			JPanel north = new JPanel();
			north.setLayout(new GridLayout(2,1));
			north.setBorder(new LineBorder(Color.GRAY));
			
			FlowLayout layout = new FlowLayout(FlowLayout.LEFT,20,3);
			
			northPane.setLayout(layout);
			northPane.add(nameLabel);
			northPane.add(keHuText1);
			keHuButton.setMargin(new Insets(0,0,0,0));
			keHuButton.addMouseListener(new ChaZhaoKeHuButtonAction(this));
			northPane.add(keHuButton);
			northPane.add(shouHuoCangKuLabel);
			
			cangKuModel = new DefaultComboBoxModel(JDBCGetInfo.getCangKuData());
			cangKuBox= new JComboBox(cangKuModel);
			northPane.add(cangKuBox);
			
		
			cangKuBox.addMouseListener(new MouseAdapter(){
				
				public void mouseClicked(MouseEvent e) {
                  if(tableModel.getRowCount()== 0){
						
					}else{
						
						JOptionPane.showMessageDialog(dialog,
								"�˻�״̬ʱ���ܸ��Ĳֿ�����", "ϵͳ��ʾ",  JOptionPane.QUESTION_MESSAGE, null);
						cangKuBox.setEditable(false);
						
					}
					
				}
				
			});
			
			northPane.add(riQiLabel);
			northPane.add(dataPicker);
			dataPicker.addActionListener(new DatePickerAlterAction(this));
			infoLabel.setBorder(new LineBorder(Color.GRAY));
			north.add(northPane);
			north.add(infoLabel);
			
			JPanel southPane = new JPanel();
			southPane.setBorder(new LineBorder(Color.GRAY));
			southPane.setLayout(new FlowLayout(FlowLayout.LEFT));
			southPane.add(beiZhuLabel);
			southPane.add(beiZhuText);
			beiZhuButton.setMargin(new Insets(0,0,0,0));
			southPane.add(beiZhuButton);
		    southPane.add(new JLabel("                               " ));
			southPane.add(sureButton);
			sureButton.addActionListener(new GuKeTuiHuoSureAction(this));
			southPane.add(tuiChuButton1);
			tuiChuButton1.addActionListener(new ActionListener(){
		          public void actionPerformed(ActionEvent e) {
				
		        	  if(tableModel.getRowCount() == 0){
		        			dispose();
		        	  }else{
		        		  int n = JOptionPane.showOptionDialog(GuKeTuiHuoDialog.this,
		        			 "��ǰ���ݻ�û���棬�Ƿ��˳���", "ϵͳ��ʾ", 
		        			 JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null,null);
		        		  if(n == JOptionPane.YES_OPTION){
		        			
		        			  dispose();
		        		  }else {
		        			  
		        		  }
		        	  }
				    
				}
				
			});
			
			pane.add(north,BorderLayout.NORTH);
			pane.add(createCenterPane (),BorderLayout.CENTER);
			pane.add(southPane,BorderLayout.SOUTH);
			
			return pane;
		}
	

		public JButton getKeHuButton() {
			return keHuButton;
		}


		/**
		 * �˿��˻�ѡ��ϵ��м���������Ĳ���
		 * @return �м����
		 */
		public JPanel createCenterPane () {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			
			JPanel northPanel = new JPanel();
			northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			northPanel.add(addButton);
			addButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					new AddTuiHuoGoodsDialog(GuKeTuiHuoDialog.this,"������Ʒ(�����˻�)");
					
				}
				
			});
			
			alterButton.setVisible(false);
			northPanel.add(alterButton);
			alterButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
				
					new AlterGoodsDialog(GuKeTuiHuoDialog.this,"��Ʒ��Ϣ");
				}
				
			});
			deleteButton.setVisible(false);
			northPanel.add(deleteButton);
			deleteButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					int n = JOptionPane.showOptionDialog(dialog, "�Ƿ�Ҫɾ������Ʒ��Ϣ!", "ϵͳ��ʾ", 
							  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
				    if(n == JOptionPane.YES_OPTION){
				    	int row = table.getSelectedRow();
				    	tableModel.removeRow(row);
				    }
				}
				
			});
			northPanel.add(tuiHuoButton);
			tuiHuoButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(tableModel.getRowCount()== 0){
						new DanJuChaXunDialog(GuKeTuiHuoDialog.this,"���۵��ݲ�ѯ",true).setVisible(true);
					}else{
					
						JOptionPane.showMessageDialog(GuKeTuiHuoDialog.this,
								"���ȱ��汾�ε��˻�����!", "ϵͳ��ʾ", JOptionPane.DEFAULT_OPTION, null);
					}
				}
				
			});
            
			JPanel southPanel = new JPanel();
			
			southPanel.setBorder(new LineBorder(Color.GRAY));
			FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
			layout.setHgap(15);
			southPanel.setLayout(layout);
			southPanel.add(yingTuiMoneyLabel);
			southPanel.add(yingTuiText);
			
			yingTuiText.setText("0.0");
			southPanel.add(shiTuiMoneyLabel);
			southPanel.add(shiTuiText);
			shiTuiText.setText("0.0");
			southPanel.add(jingBanRenLabel);
			jinBanModel = new DefaultComboBoxModel(JDBCGetInfo.getJingBanRenData());
			jingBanBox = new JComboBox(jinBanModel);
			southPanel.add(jingBanBox);
			jingBanButton.setMargin(new Insets(0,0,0,0));
			southPanel.add(jingBanButton);
			southPanel.add(new JLabel("                    "));
			
			
			JPanel centerPanel = new JPanel();
			tableModel = new AllTableModel(TuiHuoTabelCulomnModel.obj,
					    TuiHuoTabelCulomnModel.BackColumNames);
			table = new JTable(tableModel);
			JScrollPane scroll = new JScrollPane(table);
			
			table.setAutoCreateRowSorter(true);
		
			table.setPreferredScrollableViewportSize(new Dimension(780,356));//���̶���С
	
			centerPanel.add(scroll);
			
			pane.add(northPanel,BorderLayout.NORTH);
			pane.add(centerPanel,BorderLayout.CENTER);
			pane.add(southPanel,BorderLayout.SOUTH);
			
			return pane;
		}
		
	
		
		public JButton getAlterButton() {
			return alterButton;
		}


		public JButton getDeleteButton() {
			return deleteButton;
		}


		/**
		 * ��ʼ���˻���ѯ���
		 */
		public JPanel initTuiHuoChaXunPane(){
			
			tuiHuoChaXunPane.setLayout(new BorderLayout());
			tuiHuoChaXunPane.add(createNorthPanel(),BorderLayout.NORTH);
			tuiHuoChaXunPane.add(createCenterPanel1(),BorderLayout.CENTER);
		 
			return tuiHuoChaXunPane;
		}
		
		/**
		 * �˻���ѯ���ı������������Ĳ���
		 * @return �������
		 */
		public JPanel createNorthPanel(){
			JPanel northPanel = new JPanel();
			FlowLayout layout =new FlowLayout(FlowLayout.LEFT,25,3);
			northPanel.setLayout(layout);
			
			chaXunButton.setMargin(new Insets(0,0,0,0));
			chaXunButton.addActionListener(new GaoJiChaXunAction(this));
			
			chaKanButton.setMargin(new Insets(0,0,0,0));
			daoChuButton.setMargin(new Insets(0,0,0,0));
			tuiChuButton.setMargin(new Insets(0,0,0,0));
			northPanel.add(chaXunButton);
			northPanel.add(chaKanButton);
			northPanel.add(daoChuButton);
			northPanel.add(tuiChuButton);
			tuiChuButton.addActionListener(new ActionListener(){
		          public void actionPerformed(ActionEvent e) {
				
				    	 dispose();
				}
				
			});
			
		
			
			
			JPanel panel1 = new JPanel();
			JPanel pane1 = new JPanel();
			pane1.add(new JLabel("��������: "));
			pane1.add(dataPicker1);
			pane1.add(new JLabel(" ��   "));
			pane1.add(dataPicker2);
			shiJianButton.setMargin(new Insets(0,0,0,0));
			pane1.add(shiJianButton);
			
		  
			JPanel pane2 = new JPanel();
			pane2.add(new JLabel("�ͻ�/���ݺ�:"));
			pane2.add(keHuText);
			pane2.add(chaXun);
			chaXun.addActionListener(new TuiHuoDanJuFindAction(this));
			panel1.setLayout(new GridLayout(2,1,2,4));
			panel1.add(pane1);
			panel1.add(pane2);
			
			
			northPanel.add(panel1);
			
			return northPanel;
		}
		
		/**
		 * �˻���ѯ�����м����������Ĳ���
		 * @return �м����
		 */
		public JPanel createCenterPanel1(){
			JPanel centerPanel = new JPanel();
			centerPanel.setLayout(new GridLayout(2,1));
			
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			
			JPanel panel2 = new JPanel();
			panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
			panel2.add(new JLabel("���ݵ���ϸ��Ϣ:"));
			panel2.add(information);
			
			panel.add(panel2,BorderLayout.NORTH);
			
			JPanel center = new JPanel();
			xiangXiModel = new AllTableModel(TuiHuoTabelCulomnModel.obj,TuiHuoTabelCulomnModel.DanJuColumnNames);
		    xiangXiTable = new JTable(xiangXiModel);
			JScrollPane scroll = new JScrollPane(xiangXiTable);
			xiangXiTable.setAutoCreateRowSorter(true);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			xiangXiTable.setPreferredScrollableViewportSize(new Dimension(780,356));//���̶���С
			center.add(scroll);
			panel.add(center,BorderLayout.CENTER);
			
		
			JPanel center2 = new JPanel();
			danJuModel = new AllTableModel(TuiHuoTabelCulomnModel.obj,TuiHuoTabelCulomnModel.QueryColumnNames);
		    danJuTable = new JTable(danJuModel);
			JScrollPane scroll2 = new JScrollPane(danJuTable);
			danJuTable.setAutoCreateRowSorter(true);
			danJuTable.addMouseListener(new TuiHuoMouseListener(this,danJuTable.getSelectedRow()));
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			danJuTable.setPreferredScrollableViewportSize(new Dimension(780,356));//���̶���С
			center2.add(scroll2);
			
			
			centerPanel.add(center2);
			centerPanel.add(panel);
			return centerPanel;
		}
		/**
		 * ���˿��˻�ѡ��ϵı��ʼ��ʱ
		 * ��������.������Դ�����۵��ݲ�ѯ�Ի�����
		 * �����۵������
		 */
		public void addData(){
			AllTableModel tableModel = dialog.getTabelModel2();
			table.setModel(tableModel);
		
		}
		
		public JTable getTable() {
			return table;
		}


		public AllTableModel getTableModel() {
			return tableModel;
		}
		public JTextField getKeHuText1() {
			return keHuText1;
		}


		public JTextField getKeHuText() {
			return keHuText;
		}


		public JTable getDanJuTable() {
			return danJuTable;
		}


		public JTable getXiangXiTable() {
			return xiangXiTable;
		}


	    public JLabel getInformation() {
			return information;
		}


		public AllTableModel getDanJuModel() {
			return danJuModel;
		}


		public AllTableModel getXiangXiModel() {
			return xiangXiModel;
		}


		public JDatePicker getDataPicker1() {
			return dataPicker1;
		}


		public JDatePicker getDataPicker2() {
			return dataPicker2;
		}
		public JLabel getInfoLabel() {
			return infoLabel;
		}


		public JComboBox getJingBanBox() {
			return jingBanBox;
		}


		public JTextField getShiTuiText() {
			return shiTuiText;
		}


		public JTextField getYingTuiText() {
			return yingTuiText;
		}
	/*//������
	public static void main(String[] args) {
		new GuKeTuiHuoDialog((JFrame)null,"�˿��˻�",true);
		

	}*/


	public Vector<Vector> getData() {
		return data;
	}


	public JTextField getBeiZhuText() {
		return beiZhuText;
	}


	public JComboBox getCangKuBox() {
		return cangKuBox;
	}


	public JLabel getDanHaoLabel() {
		return danHaoLabel;
	}


	public JDatePicker getDataPicker() {
		return dataPicker;
	}


	public MainFrame getMainFrame() {
		return mainFrame;
	}


}
