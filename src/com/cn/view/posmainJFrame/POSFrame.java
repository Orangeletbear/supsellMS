package com.cn.view.posmainJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.cn.control.posmainframe.AddKeyListenerAction;
import com.cn.control.posmainframe.ChoiceSPAction;
import com.cn.control.posmainframe.HelpToolAction;
import com.cn.control.posmainframe.MultiSPChiceAction;
import com.cn.control.posmainframe.SetFontDialogAction;
import com.cn.dao.pos.JDBC_POS_GetInfo;
import com.cn.dao.pos.POSJDBC;
import com.cn.dao.pos.POScrk_JDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.pos.POSTableModel;
import com.cn.util.DateConventer;
import com.cn.util.GetCurentTime;
import com.cn.util.Log;
import com.cn.util.TimeThread;
import com.cn.view.login.LoginPosFrame;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.toolbar.TableCulomnModel;
/**
 * POS�ͻ����շѹ���
 * �ɶ�������
 * @author finey
 *
 */
public class POSFrame extends JFrame {
	//��һ���˵��е��Ӳ˵�
	JMenuItem fromatSet; 
	JMenuItem print;
	JMenuItem printSet;
	JMenuItem changePSW;
	JMenuItem printSmall;
	JMenuItem findStop;
	JMenuItem passageSet;
	JMenuItem luKuang ;
	JMenuItem chuKuang;
	JMenuItem tuiHuo;
	JMenuItem exit;
	
	//�ڶ����˵��е��Ӳ˵�
	JCheckBoxMenuItem chaiShe;
	JCheckBoxMenuItem heiBai;
	//��Ʒȷ�����ж�������Ʒ
	private int num = 1;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	//��Ʒ�б���
	private JPanel multPane;
	Vector spData = new Vector();
	AllTableModel multMode = null;
	
    JTable multTable = null;
    	
	// ��Ʒ�б���
	Vector data = new Vector();
	public void setSpData(Vector spData) {
		this.spData = spData;
	}

	public void setData(Vector data) {
		this.data = data;
	}

	public Vector getData() {
		return data;
	}
	AllTableModel mode = null;
	JPanel paneInput;
    JTable table = null;
    public void setTable(JTable table) {
		this.table = table;
	}
	//������ʾ
    JLabel idField;
    //����Ա�û���
    JLabel nameField;
    //ѡ�񵼹�Ա
    JComboBox dgBox;
    //ѡ��ֿ�
    JComboBox changKuBox;
    //��Ա����
    private JLabel hyName = new JLabel();
    public JComboBox getDgBox() {
		return dgBox;
	}

	public JComboBox getChangKuBox() {
		return changKuBox;
	}
	//�������
    JPanel helpPane;
    //ʱ��
    JLabel timeLabel = new JLabel();
    public JLabel getTimeLabel() {
		return timeLabel;
	}
    Dimension screenD = Toolkit.getDefaultToolkit().getScreenSize();
	//����Pane
    JPanel pane = new JPanel();
    
    //������ť
    JButton helpBtn;
    //��ǰPOS����Ա
    private String user;
    //������Ʒ���
    JTextField spField ;
    
    
    JLabel all;
    
    public AllTableModel getMode() {
		return mode;
	}

	public AllTableModel getMultMode() {
		return multMode;
	}

	public JPanel getMultPane() {
		return multPane;
	}

	public JTable getMultTable() {
		return multTable;
	}

	public JLabel getNameField() {
		return nameField;
	}

	public Vector getSpData() {
		return spData;
	}

	public JTable getTable() {
		return table;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public JPanel getHelpPane() {
		return helpPane;
	}

	public void setHelpPane(JPanel helpPane) {
		this.helpPane = helpPane;
	}

	public JButton getHelpBtn() {
		return helpBtn;
	}

	public void setHelpBtn(JButton helpBtn) {
		this.helpBtn = helpBtn;
	}

	public POSFrame(String title , String user){
		
		super(title);
		this.user = user;
		//�ı����Ͻǵ�ͼ��  
		   Toolkit tool = Toolkit.getDefaultToolkit();
		   Image image = tool.getImage("res/smallIcon/titlerth.png");
		   this.setIconImage(image);
		   
		try {
   			UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceModerateLookAndFeel");
   		} catch (ClassNotFoundException e) {
   			e.printStackTrace();
   		} catch (InstantiationException e) {
   			e.printStackTrace();
   		} catch (IllegalAccessException e) {
   			e.printStackTrace();
   		} catch (UnsupportedLookAndFeelException e) {
   			e.printStackTrace();
   		}
		init();
	}
	
	private void init(){
		
		this.setSize(screenD.width,screenD.height-30);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 this.addWindowListener(new WindowAdapter(){

				public void windowClosing(WindowEvent arg0) {
					int choice =  JOptionPane.showConfirmDialog(null,
							" ��   / ��  ��  ��  ϵ  ͳ  ","�˳�����",
			        		 JOptionPane.YES_NO_OPTION, 3);
				     if(choice == JOptionPane.YES_OPTION){
				    	 System.exit(2);
				     }
				}
	    	   });
		this.setJMenuBar(createMenuBar());//�����˵���
        this.add(createPane());  //�����м����
        
		TimeThread.printTime(timeLabel);
		
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        paneInput.requestFocus();
        spField.setText("");
       
      //  this.addKeyListener(new AddKeyListenerAction(this));
        //spField.setText("ffff");
		this.setVisible(true);
		

	}
	
	/*
	 * �����˵���
	 */
	private JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu xiTong = new JMenu("ϵͳ����");  //ϵͳ����
		JMenu view = new JMenu("��ʾ���");  //��ʾ���
		
		fromatSet = new JMenuItem("��Ʒ�б���������");
		fromatSet.addActionListener(new SetFontDialogAction(this));
		print = new JMenuItem("��ӡ��ǰ����Ա��ϸ");
		printSet = new JMenuItem("��ӡ����");
		printSet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new PrintSetDialog(POSFrame.this,"��ӡ����",true);
			}
		});
		changePSW = new JMenuItem("�޸�����");
		changePSW.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new ChangePasswordDialog(POSFrame.this,"��ӡ����",true);
			}
		});
		passageSet = new JMenuItem("��������");
		passageSet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new KeXianSetDialog(POSFrame.this,"��������",true);
			}
		});
		printSmall = new JMenuItem("����СƱ");
		findStop = new JMenuItem("���˲�ѯ");
		luKuang = new JMenuItem("���");
		luKuang.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new POSLuKuangDialog(POSFrame.this,"���",true);
				
			}
			
		});
		chuKuang = new JMenuItem("����");
		chuKuang.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new POSChuKuangDialog(POSFrame.this,"����",true);
			}
			
		});
		
		tuiHuo = new JMenuItem("�˻�");
		
		tuiHuo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				if(table.getRowCount() == 0){
					new POSTuiHuoDialog(POSFrame.this,"�˻�",true);
				}else{
					JOptionPane.showMessageDialog(POSFrame.this, "ϵͳ��������״̬�������˻�", 
							"ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE, null);
				}
				
			}
			});
		exit = new JMenuItem("�˳�");
		exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					int choice =  JOptionPane.showConfirmDialog(null,
							" ��   / ��  ��  ��  ϵ  ͳ  ","�˳�����",
			        		 JOptionPane.YES_NO_OPTION, 3);
				     if(choice == JOptionPane.YES_OPTION){
				    	 System.exit(2);
				     }
				}
 			});
		xiTong.add(fromatSet);
		xiTong.add(print);
		xiTong.addSeparator();
		xiTong.add(printSet);
		xiTong.add(changePSW);
		xiTong.addSeparator();
		xiTong.add(printSmall);
		xiTong.add(passageSet);
		xiTong.add(findStop);
		xiTong.addSeparator();
		xiTong.add(luKuang);
		xiTong.add(chuKuang);
		xiTong.addSeparator();
		xiTong.add(tuiHuo);
		xiTong.add(exit);
		
		//����һ����ť��
		ButtonGroup grop = new ButtonGroup();
		chaiShe = new JCheckBoxMenuItem("��ɫ");
		heiBai = new JCheckBoxMenuItem("�ڰ�");
		chaiShe.setSelected(true);
		grop.add(chaiShe);
		grop.add(heiBai);
		//����˵���
		view.add(chaiShe);
		view.add(heiBai);
		
		
		menuBar.add(xiTong);
		menuBar.add(view);

		return menuBar;
	}
	
	
	
	/*
	 * ���м����
	 */
	private JPanel createPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel northPane = initNorthPane();
		
		JPanel centerPane = initCenterPane();
		
		JPanel southPane = initSouthPane();
		
		pane.add(northPane,BorderLayout.NORTH);
		pane.add(centerPane,BorderLayout.CENTER);
		pane.add(southPane,BorderLayout.SOUTH);

		return pane;
	}
	/*
	 * ѡ�����Ľ���
	 */
	private JPanel initNorthPane(){
        
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		JLabel name = new JLabel("������Ŀ������ ");
		name.setFont(new Font("�����п�",Font.BOLD,20));
		JLabel id = new JLabel("���ݺ�: ");
	
		idField = new JLabel();
		idField.setText(getDanJuNumner());
	
		idField.setForeground(Color.red);
		JLabel posName = new JLabel("����Ա :");
		nameField = new JLabel();
		nameField.setText(user);
		nameField.setForeground(Color.red);
		JLabel lblab = new JLabel("����Ա: ");
		
		dgBox = new JComboBox(POSJDBC.getAllWorker());
		dgBox.addItem("����");
		dgBox.setMaximumRowCount(4);
		dgBox.addKeyListener(new AddKeyListenerAction(this));
		JLabel changKu = new JLabel("ѡ��ֿ�: ");
		changKuBox = new JComboBox(JDBCCuCunFind.getCanKuData());
		changKuBox.addKeyListener(new AddKeyListenerAction(this));
		pane.add(name);
		pane.add(id);
		pane.add(idField);
		pane.add(posName);
		pane.add(nameField);
		pane.add(lblab);
		pane.add(dgBox);
		pane.add(changKu);
		pane.add(changKuBox);

		pane.setBorder(new LineBorder(Color.gray));
		return pane;
	}
	
	private String getDanJuNumner(){
		String date = DateConventer.dateToStr(new Date());

	    String s = date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
		
		ArrayList dan = JDBC_POS_GetInfo.get_pos_xs_id(date);
		
		 ArrayList sd = new ArrayList();
		 for(int i = 0;i < dan.size();i++){
			 String dan1 = dan.get(i).toString();
		
			 if(dan1.substring(2, 10).equals(s)){	 
				 sd.add(dan1);
			 }
		 }
		
		//��ϵͳ���ڵ������պ����ڵ��쵥�ݺŵ�˳����Ϊ���ݺ�
		 if(sd.size()==0){
			
			 return "XS"+s+"0001";
			
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
			 return "XS"+s+h ;
	      }	 
		
	}
	
	//��Ʒ�����Ľ���
	private JPanel initCenterPane(){
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());

        JPanel tablePane = new JPanel();
        tablePane.setLayout(new BorderLayout());
        
        JPanel inTablePane = new JPanel();
        inTablePane.setLayout(new BorderLayout());
        
        //������
        mode = new AllTableModel(
        	data,AllTableModel.getVectorFromObj(POSTableModel.culomn));
        
        table = new JTable(mode);
		table.setFont(new Font("����",Font.PLAIN,22));
		table.addKeyListener(new AddKeyListenerAction(this));
		table.setRowHeight(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		inTablePane.add(new JScrollPane(table),BorderLayout.CENTER);
		table.setDragEnabled(false);
		table.removeMouseListener(new MouseAdapter(){});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//������(ѡ����Ʒ��)
		multPane = new JPanel();
		multPane.setLayout(new BorderLayout());
	
		multMode = new AllTableModel(
	        	spData,AllTableModel.getVectorFromObj(POSTableModel.MultiSPCulomns));
	        
	    multTable = new JTable(multMode);
	    multTable.setPreferredScrollableViewportSize(new Dimension(1100,150));
	    multPane.add(new JScrollPane(multTable));
	    multPane.setVisible(false);
	    multTable.setFont(new Font("����",Font.PLAIN,16));
	    multTable.setRowHeight(25);
	    multTable.setDragEnabled(true);
	    MultiSPChiceAction l = new MultiSPChiceAction(this);
	    multTable.addMouseListener(l);
	    multTable.addKeyListener(l);
	    inTablePane.add(multPane,BorderLayout.SOUTH);
	    multPane.setBorder(new TitledBorder("ѡ�������Ʒ"));
	    tablePane.add(inTablePane,BorderLayout.CENTER);
		
		paneInput = new JPanel();
		paneInput.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		JLabel icon = new JLabel(new ImageIcon("res/smallIcon/01.png"));
		JLabel input = new JLabel("��������Ʒ���:");
		input.setFont(new Font("����",Font.BOLD,20));
		spField = new JTextField(20);
		spField.addKeyListener(new AddKeyListenerAction(POSFrame.this));
		spField.addActionListener(new ChoiceSPAction(this));
		
		spField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				 POSFrame.this.getSpData().removeAllElements();
				 multPane.setVisible(false);
			}
			public void focusLost(FocusEvent e) {
				
			}
			
		});
		
		JLabel allMoney = new JLabel("�ܼƽ��: ");
		allMoney.setFont(new Font("����",Font.BOLD,20));
		all = new JLabel("0.0  Ԫ");
		
		float money = 0;
		//System.out.println(frame == null);
		for(int i = 0;i < table.getRowCount();i++){
			money = money + Float.parseFloat(mode.getValueAt(i, 8).toString());
		}
		all.setText(String.valueOf(money));
		all.setFont(new Font("����",Font.BOLD,20));
		all.setForeground(Color.red);
		all.setPreferredSize(new Dimension(100,30));
		
		helpBtn = new JButton();
		helpBtn.setIcon(new ImageIcon("res/smallIcon/blue_down.gif"));
		helpBtn.setText("���ذ���(F1)");
		helpBtn.setMargin(new Insets(0,0,0,0));
		helpBtn.setFont(new Font("����",Font.BOLD,15));
		helpBtn.addActionListener(new HelpToolAction(this));
		KeyStroke stroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,ActionEvent.CTRL_MASK,true);
		
		/*helpBtn.registerKeyboardAction(
				new HelpToolAction(this),stroke1,helpBtn.WHEN_IN_FOCUSED_WINDOW); */
		
		spField.setFont(new Font("����",Font.BOLD,20));
		paneInput.add(icon);
		paneInput.add(input);
		paneInput.add(spField);
		paneInput.add(allMoney);
		paneInput.add(all);
		paneInput.add(helpBtn);
		JLabel hyId = new JLabel("��Ա���:");
		hyId.setFont(new Font("����",Font.BOLD,20));
		paneInput.add(hyId);
		paneInput.add(hyName);
		hyName.setFont(new Font("����",Font.BOLD,20));
		//Ĭ�Ͽͻ�Ϊ��ͨ�ͻ�
		hyName.setText("h007");
		tablePane.add(paneInput,BorderLayout.SOUTH);
		paneInput.setBackground(new Color(255,235,147));
		
		pane.add(tablePane,BorderLayout.CENTER);
		
		JPanel helpPane = initHelpPane();
		pane.add(helpPane,BorderLayout.SOUTH);
		pane.setOpaque(true);
		return pane;
	}
	/*
	 * ������������
	 */
	private JPanel initHelpPane(){
		pane = new JPanel();
		pane.setBackground(new Color(100,100,150));
		pane.setLayout(new GridLayout(2,7));
		JPanel inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lab1 = new JLabel("�������:");
		JLabel lab2 = new JLabel("/��F5");
		lab2.setDisplayedMnemonic(KeyEvent.VK_F5);
		lab2.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab2);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("�޸��ۿ�:");
		JLabel labx = new JLabel("*��F6");
		labx.setDisplayedMnemonic(KeyEvent.VK_F6);
		labx.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(labx);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("�޸ĵ��ۣ�");
		JLabel lab_xgdj = new JLabel("-��F7");
		lab_xgdj.setDisplayedMnemonic(KeyEvent.VK_F7);
		lab_xgdj.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_xgdj);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("�޸�������");
		JLabel lab_xgsl = new JLabel("+��F8");
		lab_xgsl.setDisplayedMnemonic(KeyEvent.VK_F8);
		lab_xgsl.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_xgsl);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("ɾ����ǰ��");
		JLabel scdq = new JLabel("Delete");
		scdq.setDisplayedMnemonic(KeyEvent.VK_DELETE);
		scdq.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(scdq);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("ɾ��ȫ��: ");
		JLabel lab_scqb = new JLabel("End");
		lab_scqb.setDisplayedMnemonic(KeyEvent.VK_END);
		lab_scqb.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_scqb);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("ѡ���Ա: ");
		JLabel lab_xzhy = new JLabel("Insert");
		lab_xzhy.setDisplayedMnemonic(KeyEvent.VK_INSERT);
		lab_xzhy.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_xzhy);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("��Ǯ��: ");
		JLabel lab_dkqx = new JLabel("Home");
		lab_dkqx.setDisplayedMnemonic(KeyEvent.VK_HOME);
		lab_dkqx.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_dkqx);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("�ҵ����: ");
		JLabel lab_gdjg = new JLabel("PageUp");
		lab_gdjg.setDisplayedMnemonic(KeyEvent.VK_PAGE_UP);
		lab_gdjg.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_gdjg);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("�˿��˻�: ");
		JLabel lab_gkth = new JLabel("PageDown");
		lab_gkth.setDisplayedMnemonic(KeyEvent.VK_PAGE_DOWN);
		lab_gkth.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_gkth);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("���ཻ��: ");
		JLabel lab_hbjj = new JLabel("F2");
		lab_hbjj.setDisplayedMnemonic(KeyEvent.VK_F2);
		lab_hbjj.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_hbjj);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("������Ļ: ");
		JLabel lab_sdpm = new JLabel("F3");
		lab_sdpm.setDisplayedMnemonic(KeyEvent.VK_F3);
		lab_sdpm.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_sdpm);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("ѡ�񵼹�: ");
		JLabel lab_xzdg = new JLabel("F4");
		lab_xzdg.setDisplayedMnemonic(KeyEvent.VK_F4);
		lab_xzdg.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_xzdg);
		pane.add(inPane);
		
		inPane = new JPanel();
		inPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		lab1 = new JLabel("ѡ��ֿ�: ");
		JLabel lab_xzck = new JLabel("F9");
		lab_xzck.setDisplayedMnemonic(KeyEvent.VK_F9);
		lab_xzck.setForeground(Color.blue);
		inPane.add(lab1);
		inPane.add(lab_xzck);
		pane.add(inPane);
		return pane;
	}
	//״̬���Ľ���
	private JPanel  initSouthPane(){
          JPanel pane = new JPanel();
          pane.setLayout(new GridLayout(1,2,2,2));
        
		  JPanel left = new JPanel();
		  left.setLayout(new GridLayout(1,4,2,2));
		  
		  JLabel labe = new JLabel("�޵�������Ŀ��");
		  labe.setFont(new Font("",Font.PLAIN,12));
		  labe.setBorder(new LineBorder(Color.gray));
		  left.add(labe);
		  
		  labe = new JLabel("ϵͳ״̬");
		  labe.setFont(new Font("ff",Font.PLAIN,12));
		  labe.setBorder(new LineBorder(Color.gray));
		  left.add(labe);
		  
		  timeLabel.setBorder(new LineBorder(Color.gray));
		  timeLabel.setFont(new Font("ff",Font.PLAIN,12));
		  left.add(timeLabel);
		  
		  labe = new JLabel("����POS�û�: "+user);
		  labe.setFont(new Font("ff",Font.PLAIN,12));
		  labe.setBorder(new LineBorder(Color.gray));
		  left.add(labe);
		  
		  JPanel right = new JPanel();
		  right.setLayout(new GridLayout(1,4,2,2));
		  
		  labe = new JLabel("������վ    www.wudiqiren.com      ");
		  labe.setFont(new Font("ff",Font.PLAIN,15));
		  labe.setBorder(new LineBorder(Color.gray));
		  right.add(labe);
		  
		  timeLabel.setBorder(new LineBorder(Color.gray));
		  timeLabel.setFont(new Font("ff",Font.PLAIN,15));
		  right.add(timeLabel);
		  
		  pane.add(left);
		  pane.add(right);
		

		return pane;
	}
	public JPanel getPane() {
		return pane;
	}

	public JMenuItem getFromatSet() {
		return fromatSet;
	}

	public JMenuItem getFindStop() {
		return findStop;
	}

	public JMenuItem getLuKuang() {
		return luKuang;
	}

	public JMenuItem getChuKuang() {
		return chuKuang;
	}

	public JCheckBoxMenuItem getChaiShe() {
		return chaiShe;
	}

	public JCheckBoxMenuItem getHeiBai() {
		return heiBai;
	}

	public JLabel getIdField() {
		return idField;
	}

	public Dimension getScreenD() {
		return screenD;
	}

	public JLabel getAll() {
		return all;
	}

	public JLabel getHyName() {
		return hyName;
	}

	public void setPane(JPanel pane) {
		this.pane = pane;
	}
  public static void main(String[] args){
	  new POSFrame("���й���ϵͳPOS���Ѷ˵�½����","POS");
  }

public JTextField getSpField() {
	return spField;
}
}
