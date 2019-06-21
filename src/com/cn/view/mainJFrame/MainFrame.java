package com.cn.view.mainJFrame;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import com.cn.control.kuchunframe.KuCunBDAction;
import com.cn.control.mianframe.*;
import com.cn.control.systemframe.*;
import com.cn.dao.MFrameJDBC;
import com.cn.util.GBC;
import com.cn.util.Log;
import com.cn.util.TimeThread;
import com.cn.view.jinhuoJFrame.*;
import com.cn.view.kuchunJFrame.*;
import com.cn.view.richangJFrame.Customer_Manage.Customer_Manage;
import com.cn.view.richangJFrame.Guote_Manage.Quote_Manage;
import com.cn.view.richangJFrame.Salesman_Manage.Salesman_Manage;
import com.cn.view.richangJFrame.Supplier_Manage.Supplier_Manage;
import com.cn.view.systemJFrame.*;
import com.cn.view.tongjiJFrame.*;
import com.cn.view.toolbar.HelpDialog;
import com.cn.view.toolbar.RemaindDialog;
import com.cn.view.xiaoshouJFrame.POS.POSDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;

/**
 * �÷���������һ�������棬������������߸�JButton�ֱ�Ϊ������������ݲ�ѯ�����۷�����
 * ����ѯ���������ѣ�����������˳�ϵͳ�����߸���ť������������ı��ߣ�����������ѡ�
 * �ֱ�Ϊ�������������۹���������ͳ�Ʊ����ճ�����ϵͳ���á�
 * @param st
 */

public class MainFrame extends JFrame {
	
	 private static final long serialVersionUID = 1L;
     //�����
	 Cursor mouseHand = new Cursor(Cursor.HAND_CURSOR);
	 
	 //����ʱ�Ƿ��Զ�������Ʒ��������Ϣ
	 private boolean isRemindWhenStart = false;
	 //��ǰ��½�û���
	 private String user;
	 
	//==========�������Ϲ���============//
	 private JButton huangban;
	 private JButton chaXun;
	 private JButton kuChu;
	 private JButton remind;
	 private JButton help;
	 private JButton exit;
	 
 
	//==========�ɹ��������============//
	//�ɹ�����
     JButton cgBtn;
     //�ɹ��˻�
     JButton cgtBtn;
     //��������
     JButton ghswlzwBtn;
     //�ɹ����ݲ�ѯ
     JButton cgdjBtn;
     //��ǰ����ѯ
     JButton dckcBtn; 
     
	//==========���۹������============//
	 //��Ʒ����
     JButton spxsBtn;
     //�˿��˻�
     JButton gkthBtn ;
     //��������
     JButton khwlzwBtn;
     //���۵��ݲ�ѯ
     JButton xsdjBtn;
     //��ǰ����ѯ
     JButton dqkcBtn;
     //POS����ͳ��
     JButton posBtn;
	 
	 //==========���������============//
	 //������
     JButton kctbBtn;
     //�������
     JButton cfkbBtn;
     //��汨��
     JButton kcbyBtn;
     //����̵�
     JButton kcpdBtn;
     //���䶯
     JButton kcbdBtn;
     //��汨��
     JButton kcbjBtn;
	 
	 //==========ͳ�Ʊ������============//
	 //��Ӧ��ͳ��
     JButton gystjBtn;
     //��Ʒ�ɹ�ͳ��
     JButton spcgtjBtn;
     //ҵ��Ա�ɹ�ͳ��
     JButton ywycgBtn;
     //���ɱ�ͳ��
     JButton kccbBtn;
     //���䶯��
     JButton kcbdtBtn;
     //�ͻ�����ͳ��
     JButton khxstjBtn;
     //ҵ��Ա����ͳ��
     JButton ywyxsBtn;
     //��Ʒ����ͳ��
     JButton spxstjBtn;
     //��Ʒ��������
     JButton spxsphBtn;
	 
	 //==========�ճ��������============//
     //��Ӧ�̹���
     JButton gysglBtn;
     //ҵ��Ա����
     JButton ywyglBtn;
     //�ͻ��ۺϹ���
     JButton khzhglBtn;
     //���۹���
     JButton bjglBtn;
     //==========ϵͳ����============//
     
     JButton spglBtn;
     JButton ghsszBtn;
     JButton czysjBtn;
     JButton hygljBtn;
     JButton stszBtn;
     JButton ckszBtn;
     JButton khszBtn;
     JButton ygszBtn;
     JButton sptjBtn;
     JButton stwhBtn;
   //=============================//
	//ѡ����,������
	private JTabbedPane mainDaoHang; 
	//��ʾʱ��
	JLabel timeLabe;
	
    public JButton getHuangban(){
		return huangban;
	}
    
	public MainFrame(String st,String user){
    	   super(st);
    	   this.user = user;//SubstanceCremeLookAndFeel   SubstanceMangoLookAndFeel
    	   try {    //SubstanceOfficeBlue2007LookAndFeel
   			UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceCremeLookAndFeel");
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
    	TimeThread.printTime(timeLabe);
    	   
    }
   	/**
   	 * ��½����
   	 */
       private void init(){	
    	  
    	   this.setSize(900,600);
    	   this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	   this.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent arg0) {
				int choice =  JOptionPane.showConfirmDialog(MainFrame.this,
						" ��   / ��  ��  ��  ϵ  ͳ  ","�˳�����",
		        		 JOptionPane.YES_NO_OPTION, 3);
			     if(choice == JOptionPane.YES_OPTION){
			    	 Log.traceLog( "  ����Ա  ",user," �˳��˹���ϵͳ");
			    	 Log.closeStream();
			    	 System.exit(2);
			     }
			}
    	   });
    	   this.setLocationRelativeTo(null);

	       //�ı����Ͻǵ�ͼ��  
		   Toolkit tool = Toolkit.getDefaultToolkit();
		   Image image = tool.getImage("res/smallIcon/titlerth.png");
		   
		   this.setIconImage(image);
		   JPanel deskBack = new JPanel(){ 
            public void paintComponent(Graphics g){ 
                g.drawImage(new ImageIcon("res/BackImage/ethty.jpg").getImage(), 0, 0, null); 
                super.paintComponent(g); 
            } 
           }; 
           deskBack.setOpaque(false);
          
           deskBack.setLayout(new BorderLayout());
    	   
    	   deskBack.add(addToolPane(),BorderLayout.NORTH);
    	   
    	   deskBack.add(initTabbedPane());
    	   
    	   deskBack.add(addSouthPane(),BorderLayout.SOUTH);
    	   
    	   this.add(deskBack);
    	   mainDaoHang.requestFocus();
    	   mainDaoHang.setSelectedIndex(1);
    	  
           //���
    	   this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	   
    	   InitPrivate.initPrivate(this);
    	   initTabblePane();
    	   this.setVisible(true);
    	   initData();
    	   
       }
       /**
        * ���ܿ��Ƶĳ�ʹ��
        */
       private void  initData(){
    	   
    	   String isRemind = MFrameJDBC.getIsTodayRemind();
    	   if(isRemind.equals("1")){
    		   new RemaindDialog(this,"��������",true).setVisible(true);
    	   }
    	  
    	   
    	   //����Ϊ�������ļ�
    	 /*  AudioClip wav = null; 
           try{  wav=JApplet.newAudioClip(Class.forName("SoundTest").getResource("xxx.wav")); 
            wav.play(); 
           }catch(ClassNotFoundException e){
        	   
           } 
           wav.play();    
           try {
			Thread.sleep(4000);
           } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
           }
           wav.stop(); 
           try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wav.loop();*/
    	 
    	   /*java.net.URL file1 = getClass().getResource("xxx.wav"); 
    	   AudioClip sound1 = java.applet.Applet.newAudioClip(file1); 
    	   sound1.play();*/
    	 //sound1.loop();
    	 //sound1.stop();
       }
      
       
       /*
        * 
 	   * �������Ĵ���
 	   */
 	  private JPanel addToolPane(){
 		    JPanel toolPane = new JPanel(){
 		    	public void paintComponent(Graphics g){ 
                    g.drawImage(new ImageIcon("res/BackImage/boderback.jpg").getImage(), 0, 0, null); 
                    super.paintComponent(g); 
                }
 		    }; 
 		    
 		    toolPane.setBorder(BorderFactory.createRaisedBevelBorder());
 	        toolPane.setOpaque(false);
 	        
 			toolPane.setLayout(new FlowLayout(FlowLayout.LEFT,35,5));
 			
 		    huangban = new JButton("�������",new ImageIcon("res/smallIcon/02.png"));
 			huangban.addActionListener(new HuangBanAction(this));
 		    huangban.setMargin(new Insets(0,0,0,0));
 		    huangban.setCursor(mouseHand);
 			ToolBarMouseListener ml = new ToolBarMouseListener(this);
 			huangban.setHorizontalTextPosition(SwingConstants.CENTER);
 			huangban.setVerticalTextPosition(SwingConstants.BOTTOM);
 			huangban.setFont(new Font("Serif",Font.BOLD,15));
 			huangban.addMouseListener(ml);
 			
 			chaXun = new JButton("���ݲ�ѯ",new ImageIcon("res/smallIcon/xx12.png"));
 			chaXun.setMargin(new Insets(0,0,0,0));
 			chaXun.addActionListener(new DangJuAction(this));
 			chaXun.setHorizontalTextPosition(SwingConstants.CENTER);
 			chaXun.setVerticalTextPosition(SwingConstants.BOTTOM);
 			chaXun.setFont(new Font("Serif",Font.BOLD,15));
 			chaXun.setCursor(mouseHand);
 			chaXun.addMouseListener(ml);
 			
 			kuChu = new JButton("����ѯ",new ImageIcon("res/smallIcon/kuc.png"));
 			kuChu.setMargin(new Insets(0,0,0,0));
 			kuChu.addActionListener(new KuChunFindAction(this));
 			kuChu.setHorizontalTextPosition(SwingConstants.CENTER);
 			kuChu.setVerticalTextPosition(SwingConstants.BOTTOM);
 			kuChu.setFont(new Font("Serif",Font.BOLD,15));
 			kuChu.addMouseListener(ml);
 			kuChu.setCursor(mouseHand);
 			remind = new JButton("��������",new ImageIcon("res/smallIcon/remind11751.png"));
 			remind.setMargin(new Insets(0,0,0,0));
 			remind.addActionListener(new ToDayRemaindLisetener(this));
 			remind.setHorizontalTextPosition(SwingConstants.CENTER);
 			remind.setVerticalTextPosition(SwingConstants.BOTTOM);
 			remind.setFont(new Font("Serif",Font.BOLD,15));
 			remind.addMouseListener(ml);
 			remind.setCursor(mouseHand);
 			help = new JButton("ϵͳ����",new ImageIcon("res/smallIcon/13.png"));
 			help.setMargin(new Insets(0,0,0,0));
 			help.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new HelpDialog(MainFrame.this,"�����ĵ�");
				}
 			});
 			help.setHorizontalTextPosition(SwingConstants.CENTER);
 			help.setVerticalTextPosition(SwingConstants.BOTTOM);
 			help.setFont(new Font("Serif",Font.BOLD,15));
 			help.addMouseListener(ml);
 			help.setCursor(mouseHand);
 			
 			exit = new JButton("�˳�ϵͳ",new ImageIcon("res/smallIcon/09.png"));
 			exit.setMargin(new Insets(0,0,0,0));
 			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					int choice =  JOptionPane.showConfirmDialog(MainFrame.this,
							" ��   / ��  ��  ��  ϵ  ͳ  ","�˳�����",
			        		 JOptionPane.YES_NO_OPTION, 3);
				     if(choice == JOptionPane.YES_OPTION){
				    	 Log.traceLog( "  �û�  ",user," �˳��˹���ϵͳ");
				    	 Log.closeStream();
				    	 System.exit(2);
				     }
				}
 			});
 			exit.setMnemonic(KeyEvent.VK_F4);
 			exit.setHorizontalTextPosition(SwingConstants.CENTER);
 			exit.setVerticalTextPosition(SwingConstants.BOTTOM);
 			exit.setFont(new Font("Serif",Font.BOLD,15));
 			exit.addMouseListener(ml);
 			exit.setCursor(mouseHand);
 			
 			toolPane.add(huangban);
 			toolPane.add(chaXun);
 			toolPane.add(kuChu);
 			toolPane.add(remind);
 			toolPane.add(help);
 			toolPane.add(exit);
 			
 			JPanel namePane = new JPanel();
 			//namePane.setLayout(null);
 			//namePane.setBounds(0, 0, 400, 100);
 			//namePane.setOpaque(false);
 	 		JLabel labe = new JLabel("�������۹���ϵͳ");
 	 		labe.setForeground(Color.blue);
 	 		labe.setFont(new Font("�����п�",Font.PLAIN,50));
 	 		//labe.setBounds(-100, 0, 300, 100);
 	 		//new Thread(new NameThread(labe)).start();
 	 		//namePane.add(labe);
 	 		//namePane.setBorder(new LineBorder(Color.gray));
 	 		toolPane.add(labe);
 			
 			return toolPane;
 	  }
       /**
        * �÷�����ʼ������ѡ�������ձ�ǩ������ӵ�JTabbedPane��
        * ������һ��JTabbedPane
        * @return JTabbedPane
        */
       private JTabbedPane initTabbedPane() { 
    	  
    	   JLabel nullJ11,nullJ22,nullJ33,nullJ44,nullJ55,nullJ66,nullJ67;  //���������ǩ�������䵱����ѡ�֮��ļ��
    	   mainDaoHang=new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
    	   //��ʼ��JTabbedPane�����䲼��
    	   //jt.setBorder(new LineBorder(new Color(87,131,178),5,true));//���ñ߿�
 
    	    nullJ11=new JLabel();
     	    nullJ22=new JLabel();
     	    nullJ33=new JLabel();
     	    nullJ44=new JLabel();
     	    nullJ55=new JLabel();
     	    nullJ66=new JLabel();
     	    nullJ67=new JLabel();
     	    mainDaoHang.add(nullJ66);
     	    mainDaoHang.addTab("��������", new ImageIcon("res/smallIcon/web .png"), initPane1());   	
     	    mainDaoHang.add(nullJ11);
     	    mainDaoHang.addTab("���۹���", new ImageIcon("res/smallIcon/web (11).png"), initPane2());
     	    mainDaoHang.add(nullJ22);
     	    mainDaoHang.addTab("������", new ImageIcon("res/smallIcon/web (3).png"), initPane3());  
     	    mainDaoHang.add(nullJ33);
     	    mainDaoHang.addTab("����ͳ��", new ImageIcon("res/smallIcon/tongji.png"), initPane4()); 
     	    mainDaoHang.add(nullJ44);
     	    mainDaoHang.addTab("�ճ�����", new ImageIcon("res/smallIcon/web3.png"), initPane5());
     	    mainDaoHang.add(nullJ55);
     	    mainDaoHang.addTab("ϵͳ����", new ImageIcon("res/smallIcon/setting.png"), initPane6());
     	    mainDaoHang.add(nullJ67);
    	    
     	    mainDaoHang.setFont(new Font("Serif",Font.BOLD,20));
     	    mainDaoHang.setEnabledAt(0, false);
     	    mainDaoHang.setEnabledAt(2, false);
     	    mainDaoHang.setEnabledAt(4, false);
     	    mainDaoHang.setEnabledAt(6, false);
     	    mainDaoHang.setEnabledAt(8, false);
     	    mainDaoHang.setEnabledAt(10, false);
     	    mainDaoHang.setEnabledAt(12, false);
    	 
    	    return mainDaoHang;
    	   }
       
        /**
         *ѡ��ĳ�ʼ��,�Թ���ԱȨ�޵�����
         */
         private void initTabblePane(){
        	//mainDaoHang.remove(1);
      	    //mainDaoHang.setEnabledAt(1, false);
      	    // mainDaoHang.setEnabledAt(3, false);
      	    // mainDaoHang.setVisible(false);
      	    String[] quanXian = MFrameJDBC.getPrivateForUser(user);
      	    //�ı����Ĳ���Ȩ
      	    for(int i= 0 ;i< quanXian.length;i++) {
      	    	if(!quanXian[i].equals("��")){
      	    		mainDaoHang.setEnabledAt((i*2)+1, false);
      	    	}
      	    }
      	    //ȷ������
      	    for(int i= 0 ;i< mainDaoHang .getTabCount();i++){
      	    	if(mainDaoHang.isEnabledAt(i)){
      	    		mainDaoHang.setSelectedIndex(i);
      	    		return;
      	    	}
      	    }
         }
       
       /*
        * �����������
        */
       private JPanel initPane1(){
    	   
    	   JPanel pane1 = new JPanel();
    	   pane1.setBorder(BorderFactory.createRaisedBevelBorder());
           pane1.setLayout(new BorderLayout());
           ToolBarMouseListener ml = new ToolBarMouseListener(this);
           GridBagLayout layout = new GridBagLayout();
           JPanel pane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/ethty.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           pane.setOpaque(false);
           
           pane.setLayout(layout);
           
           JLabel backlabel = new JLabel(new ImageIcon("res/buttonIcon/jhglbook.png"));
           layout.setConstraints(backlabel, new GBC(1, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(0, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(2, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           
           
           //�ɹ�����
           cgBtn = new JButton(new ImageIcon("res/buttonIcon/caibtn2.png"));
           //JButton cgBtn = new JButton("�ɹ�����");
           cgBtn.setCursor(mouseHand);
           cgBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(cgBtn, new GBC(0, 1,1,1).setInsets(5,5,5,40));
           cgBtn.addMouseListener(ml);
           cgBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CaiGouJinHuo(MainFrame.this,"�ɹ�����",true);
			   }
           });
           pane.add(cgBtn);
           
           //�ɹ��˻�
           cgtBtn = new JButton(new ImageIcon("res/buttonIcon/thbtn.png"));
           cgtBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(cgtBtn, new GBC(0,3,1,1).setInsets(5,5,5,40));
           cgtBtn.addMouseListener(ml);
           cgtBtn.setCursor(mouseHand);
           cgtBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CaiGouTuiHuo(MainFrame.this,"�ɹ��˻�",true);
			   }
           });
           pane.add(cgtBtn);
           //��������
           ghswlzwBtn = new JButton(new ImageIcon("res/buttonIcon/wlzwbtn.png"));
           ghswlzwBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(ghswlzwBtn, new GBC(2,1,1,1).setInsets(5,40,5,5));
           ghswlzwBtn.addMouseListener(ml);
           ghswlzwBtn.setCursor(mouseHand);
           ghswlzwBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new WangLaiZhangWu(MainFrame.this,"��������(������)",true);
			   }
           });
           
           pane.add(ghswlzwBtn);
           //�ɹ����ݲ�ѯ
           cgdjBtn = new JButton(new ImageIcon("res/buttonIcon/cgdjcxbtn.png"));
           cgdjBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(cgdjBtn, new GBC(2,2,1,1).setInsets(5,40,5,5));
           cgdjBtn.addMouseListener(ml);
           cgdjBtn.setCursor(mouseHand);
           cgdjBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CaiGouDanJuChaXun(MainFrame.this,"�ɹ����ݲ�ѯ",true);
			   }
           });
           pane.add(cgdjBtn);
           //��ǰ����ѯ
           dckcBtn = new JButton(new ImageIcon("res/buttonIcon/dqkcbtn.png"));
           dckcBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(dckcBtn, new GBC(2,3,1,1).setInsets(5,40,5,5));
           dckcBtn.addMouseListener(ml);
           dckcBtn.setCursor(mouseHand);
           dckcBtn.addActionListener(new KuCunBDAction(this));
           pane.add(dckcBtn);
           
           //�հ׵Ĳ���
           JLabel label = new JLabel();
           
           label = new JLabel(new ImageIcon("res/smallIcon/123.png"));
           layout.setConstraints(label, new GBC(0,2,1,1).setInsets(5,40,5,5));
           pane.add(label);
           //���Ĳֿ�
           JButton ckBtn = new JButton(new ImageIcon("res/buttonIcon/1.png"));
           layout.setConstraints(ckBtn, new GBC(1, 1,1,3).setInsets(5,40,5,40));
           ckBtn.setCursor(mouseHand);
           ckBtn.setMargin(new Insets(0,0,0,0));
           ckBtn.addMouseListener(ml);
           ckBtn.addActionListener(new KuCunBDAction(this));
           pane.add(ckBtn);
           //���ͨ��
           JPanel southPane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/boderback.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           southPane.setOpaque(false);
           
           southPane.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
           southPane.setFont(new Font("Serif",Font.BOLD,20));
       
          
           JButton spBtn = new JButton("��Ʒ��Ϣ  ",new ImageIcon("res/smallIcon/to001.png"));
     
           spBtn.addActionListener(new SanPingGLAction(this));
           
           JButton ghSsetBtn = new JButton("����������  ",new ImageIcon("res/smallIcon/to001.png"));
           ghSsetBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new GongHuoShang(MainFrame.this,"����������");
			   }
           });
           ghSsetBtn.setCursor(mouseHand);
           
           JButton ckSetBtn = new JButton("�ֿ�����  ",new ImageIcon("res/smallIcon/to001.png"));
           ckSetBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CangKuSheZhi(MainFrame.this,"�ֿ�����");
			   }
           });
           ckSetBtn.setCursor(mouseHand);
           
           JButton workerBtn = new JButton("Ա����Ϣ  ",new ImageIcon("res/smallIcon/to001.png"));
           workerBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new WorkSet(MainFrame.this,"Ա������");
			   }
           });
           workerBtn.setCursor(mouseHand);
           
           spBtn.addMouseListener(ml);
           ghSsetBtn.addMouseListener(ml);
           ckSetBtn.addMouseListener(ml);
           workerBtn.addMouseListener(ml);
           
           //Label���ڲ�������
           southPane.add(new JLabel());
           southPane.add(spBtn);
           southPane.add(new JLabel());
           southPane.add(ghSsetBtn);
           southPane.add(new JLabel());
           southPane.add(ckSetBtn);
           southPane.add(new JLabel());
           southPane.add(workerBtn);
           southPane.add(new JLabel());
           
   	       pane1.add(pane,BorderLayout.CENTER);
   	      
   	       pane1.add(southPane,BorderLayout.SOUTH);
   	       return pane1;
       }
       /*
        * ���۹������
        */
       private JPanel initPane2(){
    	   JPanel pane1 = new JPanel();
    	   pane1.setBorder(BorderFactory.createRaisedBevelBorder());
           pane1.setLayout(new BorderLayout());
           ToolBarMouseListener ml = new ToolBarMouseListener(this);
           GridBagLayout layout = new GridBagLayout();
           JPanel pane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/ethty.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           pane.setOpaque(false);
           
           pane.setLayout(layout);
           
           JLabel backlabel = new JLabel(new ImageIcon("res/buttonIcon/xsglbook.png"));
           layout.setConstraints(backlabel, new GBC(1, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(0, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(2, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           //��Ʒ����
           spxsBtn = new JButton(new ImageIcon("res/buttonIcon/spxsbtn.png"));
           spxsBtn.setCursor(mouseHand);
           spxsBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(spxsBtn, new GBC(0, 1,1,1).setInsets(5,5,5,40));
           spxsBtn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 new ShangPinXiaoShouDialog(MainFrame.this,"��Ʒ����",true);
			 }
        	   
           });
           
           spxsBtn.addMouseListener(ml);
           pane.add(spxsBtn);
           //�˿��˻�
           gkthBtn = new JButton(new ImageIcon("res/buttonIcon/gkthbtn.png"));
           gkthBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(gkthBtn, new GBC(0,2,1,1).setInsets(5,5,5,40));
           gkthBtn.setCursor(mouseHand);
           gkthBtn.addActionListener(new ActionListener(){
  			 public void actionPerformed(ActionEvent e) {
  				new GuKeTuiHuoDialog(MainFrame.this,"�˿��˻�",true);
  			 }
          	   
           });
           gkthBtn.addMouseListener(ml);
           pane.add(gkthBtn);
           //��������
           khwlzwBtn = new JButton(new ImageIcon("res/buttonIcon/wlzwbtn.png"));
           khwlzwBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(khwlzwBtn, new GBC(0,3,1,1).setInsets(5,5,5,40));
           khwlzwBtn.setCursor(mouseHand);
           khwlzwBtn.addActionListener(new ActionListener(){
    			 public void actionPerformed(ActionEvent e) {
    				 new KeHuXiaoShouMainFrame(MainFrame.this,"��������(�ͻ�)",true);
    			 }
           });
           khwlzwBtn.addMouseListener(ml);
           pane.add(khwlzwBtn);
           //���۵��ݲ�ѯ
           xsdjBtn = new JButton(new ImageIcon("res/buttonIcon/xsdjcxbtn.png"));
           xsdjBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(xsdjBtn, new GBC(2,1,1,1).setInsets(5,40,5,5));
           xsdjBtn.setCursor(mouseHand);
           xsdjBtn.addActionListener(new ActionListener(){
  			 public void actionPerformed(ActionEvent e) {
  				 new DanJuChaXunDialog(MainFrame.this,"���۵��ݲ�ѯ",true);
  			 }
           });
           xsdjBtn.addMouseListener(ml);
           pane.add(xsdjBtn);
           //��ǰ����ѯ
           dqkcBtn = new JButton(new ImageIcon("res/buttonIcon/dqkccxbtn.png"));
           dqkcBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(dqkcBtn, new GBC(2,2,1,1).setInsets(5,40,5,5));
           dqkcBtn.addMouseListener(ml);
           dqkcBtn.setCursor(mouseHand);
           dqkcBtn.addActionListener(new KuCunBDAction(this));
           pane.add(dqkcBtn);
           //POS����ͳ��
           posBtn = new JButton(new ImageIcon("res/buttonIcon/postjbtn.png"));
           posBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(posBtn, new GBC(2,3,1,1).setInsets(5,40,5,5));
           posBtn.setCursor(mouseHand);
           posBtn.addActionListener(new ActionListener(){
    			 public void actionPerformed(ActionEvent e) {
    				 new POSDialog(MainFrame.this,"POS����ͳ��",true);
    			 }
             });
           posBtn.addMouseListener(ml);
           pane.add(posBtn);
           
           //���Ĳֿ�
           JButton ckBtn = new JButton(new ImageIcon("res/buttonIcon/1.png"));
           layout.setConstraints(ckBtn, new GBC(1, 1,1,3).setInsets(5,40,5,40));
           ckBtn.addMouseListener(ml);
           ckBtn.setCursor(mouseHand);
           ckBtn.setMargin(new Insets(0,0,0,0));
           ckBtn.addActionListener(new KuCunBDAction(this));
           pane.add(ckBtn);
           
           //���ͨ��
           JPanel southPane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/boderback.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           southPane.setOpaque(false);
           
           southPane.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
           southPane.setFont(new Font("Serif",Font.BOLD,20));
           
           JButton spBtn = new JButton("��Ʒ��Ϣ  ",new ImageIcon("res/smallIcon/to001.png"));
           spBtn.setCursor(mouseHand);
           spBtn.addActionListener(new SanPingGLAction(this));
           JButton ghSsetBtn = new JButton("�ͻ�����  ",new ImageIcon("res/smallIcon/to001.png"));
           ghSsetBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CustomerSet(MainFrame.this,"  �ͻ���Ϣ");
			   }
           });
           ghSsetBtn.setCursor(mouseHand);
           JButton ckSetBtn = new JButton("�ֿ�����  ",new ImageIcon("res/smallIcon/to001.png"));
           ckSetBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CangKuSheZhi(MainFrame.this,"�ֿ�����");
			   }
           });
           ckSetBtn.setCursor(mouseHand);
           JButton workerBtn = new JButton("Ա����Ϣ  ",new ImageIcon("res/smallIcon/to001.png"));
           workerBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new WorkSet(MainFrame.this,"Ա������");
			   }
           });
           workerBtn.setCursor(mouseHand);
           
           spBtn.addMouseListener(ml);
           ghSsetBtn.addMouseListener(ml);
           ckSetBtn.addMouseListener(ml);
           workerBtn.addMouseListener(ml);
           
           //Label���ڲ�������
           southPane.add(new JLabel());
           southPane.add(spBtn);
           southPane.add(new JLabel());
           southPane.add(ghSsetBtn);
           southPane.add(new JLabel());
           southPane.add(ckSetBtn);
           southPane.add(new JLabel());
           southPane.add(workerBtn);
           southPane.add(new JLabel());
           
   	       pane1.add(pane,BorderLayout.CENTER);
   	      
   	       pane1.add(southPane,BorderLayout.SOUTH);
   	       return pane1;
       }
       /*
        * ������
        */
       private JPanel initPane3(){
    	   JPanel pane1 = new JPanel();
    	   pane1.setBorder(BorderFactory.createRaisedBevelBorder());
           pane1.setLayout(new BorderLayout());
           ToolBarMouseListener ml = new ToolBarMouseListener(this);
           GridBagLayout layout = new GridBagLayout();
           JPanel pane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/ethty.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           
           pane.setOpaque(false);
           
           pane.setLayout(layout);
           
           JLabel backlabel = new JLabel(new ImageIcon("res/buttonIcon/kcglbook.png"));
           layout.setConstraints(backlabel, new GBC(1, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(0, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(2, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
   
           //������
           kctbBtn = new JButton(new ImageIcon("res/buttonIcon/kctbbtn.png"));
           kctbBtn.setCursor(mouseHand);
           kctbBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(kctbBtn, new GBC(0,1,1,1).setInsets(5,5,5,40));
           kctbBtn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent arg0) {
				 new KucunDiaobo(MainFrame.this,"������",true);
			}
        	   
           });
           kctbBtn.addMouseListener(ml);
           pane.add(kctbBtn);
           //�������
           cfkbBtn = new JButton(new ImageIcon("res/buttonIcon/cfkbbtn.png"));
           cfkbBtn.setMargin(new Insets(0,0,0,0));
           cfkbBtn.setCursor(mouseHand);
           layout.setConstraints(cfkbBtn, new GBC(0,2,1,1).setInsets(5,5,5,40));
           cfkbBtn.addActionListener(new ActionListener(){
  			 public void actionPerformed(ActionEvent arg0) {
  				new ChaifenKunbang(MainFrame.this,"�������",true);
  			}
          	   
             });
           cfkbBtn.addMouseListener(ml);
           pane.add(cfkbBtn);
           //��汨��
           kcbyBtn = new JButton(new ImageIcon("res/buttonIcon/bsbybtn.png"));
           kcbyBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(kcbyBtn, new GBC(0,3,1,1).setInsets(5,5,5,40));
           kcbyBtn.setCursor(mouseHand);
           kcbyBtn.addActionListener(new ActionListener(){
  			 public void actionPerformed(ActionEvent arg0) {
  				new BaosunBaoyi(MainFrame.this,"������",true);
  			}
          	   
             });
           kcbyBtn.addMouseListener(ml);
           pane.add(kcbyBtn);
           //����̵�
           kcpdBtn = new JButton(new ImageIcon("res/buttonIcon/kcpdbtn.png"));
           kcpdBtn.setMargin(new Insets(0,0,0,0));
           kcpdBtn.setCursor(mouseHand);
           layout.setConstraints(kcpdBtn, new GBC(2,1,1,1).setInsets(5,40,5,5));
           kcpdBtn.addActionListener(new ActionListener(){
    			 public void actionPerformed(ActionEvent arg0) {
    				 new KucunPandian(MainFrame.this,"����̵�",true);
    			}
            	   
           });
           kcpdBtn.addMouseListener(ml);
           pane.add(kcpdBtn);
           //���䶯
           kcbdBtn = new JButton(new ImageIcon("res/buttonIcon/kcbdbtn.png"));
           kcbdBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(kcbdBtn, new GBC(2,2,1,1).setInsets(5,40,5,5));
           kcbdBtn.setCursor(mouseHand);
           kcbdBtn.addMouseListener(ml);
           kcbdBtn.addActionListener(new KuCunBDAction(this));
           pane.add(kcbdBtn);
           //��汨��
           kcbjBtn = new JButton(new ImageIcon("res/buttonIcon/kcbjbtn.png"));
           kcbjBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(kcbjBtn, new GBC(2,3,1,1).setInsets(5,40,5,5));
           kcbjBtn.setCursor(mouseHand);
           kcbjBtn.addActionListener(new ActionListener(){
  			 public void actionPerformed(ActionEvent arg0) {
  				new KucunBaojin(MainFrame.this,"��澯��",true);
  			}
          	   
         });
           kcbjBtn.addMouseListener(ml);
           pane.add(kcbjBtn);
           //�ֿ�
           JButton ckBtn = new JButton(new ImageIcon("res/buttonIcon/1.png"));
           layout.setConstraints(ckBtn, new GBC(1, 1,1,3).setInsets(5,40,5,40));
           ckBtn.setMargin(new Insets(0,0,0,0));
           ckBtn.setCursor(mouseHand);
           ckBtn.addMouseListener(ml);
           ckBtn.addActionListener(new KuCunBDAction(this));
           pane.add(ckBtn);
           
           //���ͨ��
           JPanel southPane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/boderback.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           southPane.setOpaque(false);
           southPane.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
           southPane.setFont(new Font("Serif",Font.BOLD,20));
           
           JButton spBtn = new JButton("��Ʒ��Ϣ  ",new ImageIcon("res/smallIcon/to001.png"));
           spBtn.setCursor(mouseHand);
           spBtn.addActionListener(new SanPingGLAction(this));
           JButton ckSetBtn = new JButton("�ֿ�����  ",new ImageIcon("res/smallIcon/to001.png"));
           ckSetBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CangKuSheZhi(MainFrame.this,"�ֿ�����");
			   }
           });
           ckSetBtn.setCursor(mouseHand);
           JButton workerBtn = new JButton("�ɱ�ͳ��  ",new ImageIcon("res/smallIcon/to001.png"));
           workerBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new KuCunMainFrame(MainFrame.this,"���ɱ�ͳ��",true);
			   }
           });
           workerBtn.setCursor(mouseHand);
           spBtn.addMouseListener(ml);
           ckSetBtn.addMouseListener(ml);
           workerBtn.addMouseListener(ml);
           
           //Label���ڲ�������
           southPane.add(new JLabel());
           southPane.add(spBtn);
           southPane.add(new JLabel());
           southPane.add(new JLabel());
           southPane.add(ckSetBtn);
           southPane.add(new JLabel());
           southPane.add(workerBtn);
           southPane.add(new JLabel());
           
   	       pane1.add(pane,BorderLayout.CENTER);
   	      
   	       pane1.add(southPane,BorderLayout.SOUTH);
   	       return pane1;
       }
       /*
        * ����ͳ�����
        */
       private JPanel initPane4(){
    	   JPanel pane1 = new JPanel();
    	   pane1.setBorder(BorderFactory.createRaisedBevelBorder());
           pane1.setLayout(new BorderLayout());
           ToolBarMouseListener ml = new ToolBarMouseListener(this);
           GridBagLayout layout = new GridBagLayout();
           JPanel pane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/ethty.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           pane.setOpaque(false);
           
           pane.setLayout(layout);
           
           JLabel backlabel = new JLabel(new ImageIcon("res/buttonIcon/bbtjbook.png"));
           layout.setConstraints(backlabel, new GBC(1, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(0, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(2, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           //��Ӧ��ͳ��
           gystjBtn = new JButton(new ImageIcon("res/buttonIcon/gystjbtn.png"));
           gystjBtn.setMargin(new Insets(0,0,0,0));
           gystjBtn.setCursor(mouseHand);
           layout.setConstraints(gystjBtn, new GBC(0, 1,1,1).setInsets(5,40,5,40));
           gystjBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new WangLaiZhangWu(MainFrame.this,"��������(������)",true);
			   }
           });
           gystjBtn.addMouseListener(ml);
           pane.add(gystjBtn);
           

           //��Ʒ�ɹ�ͳ��
           spcgtjBtn = new JButton(new ImageIcon("res/buttonIcon/spcgtjbtn.png"));
           spcgtjBtn.setMargin(new Insets(0,0,0,0));
           spcgtjBtn.setCursor(mouseHand);
           layout.setConstraints(spcgtjBtn, new GBC(0,2,1,1).setInsets(5,40,5,40));
           spcgtjBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new ShangPingCaiGouMainFrame(MainFrame.this,"��Ʒ�ɹ�ͳ��",true);
			   }
           });
           spcgtjBtn.addMouseListener(ml);
           pane.add(spcgtjBtn);
           //ҵ��Ա�ɹ�ͳ��
           ywycgBtn = new JButton(new ImageIcon("res/buttonIcon/ywycgbtn.png"));
           ywycgBtn.setMargin(new Insets(0,0,0,0));
           ywycgBtn.setCursor(mouseHand);
           layout.setConstraints(ywycgBtn, new GBC(0,3,1,1).setInsets(5,40,5,40));
           ywycgBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CaiGouTongJiMainFrame(MainFrame.this,"ҵ��Ա�ɹ�ͳ��",true);
			   }
           });
           ywycgBtn.addMouseListener(ml);
           pane.add(ywycgBtn);
           //���ɱ�ͳ��
           kccbBtn = new JButton(new ImageIcon("res/buttonIcon/kccbtjbtn.png"));
           kccbBtn.setMargin(new Insets(0,0,0,0));
           kccbBtn.setCursor(mouseHand);
           layout.setConstraints(kccbBtn, new GBC(0,4,1,1).setInsets(5,40,5,40));
           kccbBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new KuCunMainFrame(MainFrame.this,"���ɱ�ͳ��",true);
			   }
           });
           kccbBtn.addMouseListener(ml);
           pane.add(kccbBtn);
           //���䶯��
           kcbdtBtn = new JButton(new ImageIcon("res/buttonIcon/kcbdbtn.png"));
           kcbdtBtn.setMargin(new Insets(0,0,0,0));
           kcbdtBtn.setCursor(mouseHand);
           layout.setConstraints(kcbdtBtn, new GBC(1,1,1,1).setInsets(5,40,5,40));
           kcbdtBtn.addMouseListener(ml);
           kcbdtBtn.addActionListener(new KuCunBDAction(this));
           pane.add(kcbdtBtn);
           //�ͻ�����ͳ��
           khxstjBtn = new JButton(new ImageIcon("res/buttonIcon/khxstjbtn.png"));
           khxstjBtn.setMargin(new Insets(0,0,0,0));
           khxstjBtn.setCursor(mouseHand);
           layout.setConstraints(khxstjBtn, new GBC(2,1,1,1).setInsets(5,40,5,40));
           khxstjBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new KeHuXiaoShouMainFrame(MainFrame.this,"�ͻ�����ͳ��",true);
			   }
           });
           khxstjBtn.addMouseListener(ml);
           pane.add(khxstjBtn);
           //ҵ��Ա����ͳ��
           ywyxsBtn = new JButton(new ImageIcon("res/buttonIcon/yywxstjbtn.png"));
           ywyxsBtn.setMargin(new Insets(0,0,0,0));
           ywyxsBtn.setCursor(mouseHand);
           layout.setConstraints(ywyxsBtn, new GBC(2,2,1,1).setInsets(5,40,5,40));
           ywyxsBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new YeWuYuanMainFrame(MainFrame.this,"ҵ��Ա����ͳ��",true);
			   }
           });
           ywyxsBtn.addMouseListener(ml);
           pane.add(ywyxsBtn);
           //��Ʒ����ͳ��
           spxstjBtn = new JButton(new ImageIcon("res/buttonIcon/spxstjbtn.png"));
           spxstjBtn.setMargin(new Insets(0,0,0,0));
           spxstjBtn.setCursor(mouseHand);
           layout.setConstraints(spxstjBtn, new GBC(2,3,1,1).setInsets(5,40,5,40));
           spxstjBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new GoodsXiaoShouTongJi(MainFrame.this,"��Ʒ����ͳ��",true);
			   }
           });
           spxstjBtn.addMouseListener(ml);
           pane.add(spxstjBtn);
           //��Ʒ��������
           spxsphBtn = new JButton(new ImageIcon("res/buttonIcon/spxsphbtn.png"));
           spxsphBtn.setMargin(new Insets(0,0,0,0));
           spxsphBtn.setCursor(mouseHand);
           layout.setConstraints(spxsphBtn, new GBC(2,4,1,1).setInsets(5,40,5,40));
           spxsphBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new XiaoShouMainFrame(MainFrame.this,"��Ʒ��������",true);
			   }
           });
           spxsphBtn.addMouseListener(ml);
           pane.add(spxsphBtn);
           //�м�ͼ��,��Ʒ���
           JButton ckBtn = new JButton(new ImageIcon("res/buttonIcon/1.png"));
           layout.setConstraints(ckBtn, new GBC(1, 2,1,3).setInsets(5,40,5,40));
           ckBtn.setCursor(mouseHand);
           ckBtn.setMargin(new Insets(0,0,0,0));
           ckBtn.addMouseListener(ml);
           ckBtn.addActionListener(new KuCunBDAction(this));
           pane.add(ckBtn);
    
   	       pane1.add(pane,BorderLayout.CENTER);
   	      
   	       return pane1;
       }
       /*
        * �ճ��������
        */
       private JPanel initPane5(){
    	   JPanel pane1 = new JPanel();
    	   pane1.setBorder(BorderFactory.createRaisedBevelBorder());
           pane1.setLayout(new BorderLayout());
           ToolBarMouseListener ml = new ToolBarMouseListener(this);
           GridBagLayout layout = new GridBagLayout();
           JPanel pane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/ethty.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           pane.setOpaque(false);
           
           pane.setLayout(layout);
           
           JLabel backlabel = new JLabel(new ImageIcon("res/buttonIcon/rcglbook.png"));
           layout.setConstraints(backlabel, new GBC(1, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(0, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(2, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           //��Ӧ�̹���
           gysglBtn = new JButton(new ImageIcon("res/buttonIcon/gysglbtn.png"));
           gysglBtn.setMargin(new Insets(0,0,0,0));
           gysglBtn.setCursor(mouseHand);
           layout.setConstraints(gysglBtn, new GBC(0, 1,1,1).setInsets(40,40,40,40));
           gysglBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				new Supplier_Manage(MainFrame.this,"�����̹���",true);
			}
           });
           

           
           gysglBtn.addMouseListener(ml);
           pane.add(gysglBtn);
           //ҵ��Ա����
           ywyglBtn = new JButton(new ImageIcon("res/buttonIcon/ywyglbtn.png"));
           ywyglBtn.setMargin(new Insets(0,0,0,0));
           ywyglBtn.setCursor(mouseHand);
           layout.setConstraints(ywyglBtn, new GBC(0,2,1,1).setInsets(40,40,40,40));
           ywyglBtn.addActionListener(new ActionListener(){

   			public void actionPerformed(ActionEvent arg0) {
   				new Salesman_Manage(MainFrame.this,"ҵ��Ա����",true);
   			}
           	   
           });
           ywyglBtn.addMouseListener(ml);
           pane.add(ywyglBtn);
           //�ͻ��ۺϹ���
           khzhglBtn = new JButton(new ImageIcon("res/buttonIcon/khzhglbtn.png"));
           khzhglBtn.setMargin(new Insets(0,0,0,0));
           khzhglBtn.setCursor(mouseHand);
           layout.setConstraints(khzhglBtn, new GBC(2,1,1,1).setInsets(40,40,40,40));
           khzhglBtn.addActionListener(new ActionListener(){

      			public void actionPerformed(ActionEvent arg0) {
      				new Customer_Manage(MainFrame.this,"�ͻ��ۺϹ���",true);
      			}
              	   
           });
           khzhglBtn.addMouseListener(ml);
           pane.add(khzhglBtn);
           //���۹���
           bjglBtn = new JButton(new ImageIcon("res/buttonIcon/bjtlbtn.png"));
           bjglBtn.setMargin(new Insets(0,0,0,0));
           bjglBtn.setCursor(mouseHand);
           bjglBtn.addActionListener(new ActionListener(){

     			public void actionPerformed(ActionEvent arg0) {
     				new Quote_Manage(MainFrame.this,"���۹���",true);
     			}
             	   
          });
           layout.setConstraints(bjglBtn, new GBC(2,2,1,1).setInsets(40,40,40,40));
           bjglBtn.addMouseListener(ml);
           pane.add(bjglBtn);
           
           //�м����Ʒ�ֿ�ͼ��
           JButton ckBtn = new JButton(new ImageIcon("res/buttonIcon/1.png"));
           layout.setConstraints(ckBtn, new GBC(1, 1,1,2).setInsets(40,40,40,40));
           ckBtn.setCursor(mouseHand);
           ckBtn.setMargin(new Insets(0,0,0,0));
           ckBtn.addMouseListener(ml);
           ckBtn.addActionListener(new KuCunBDAction(this));
           pane.add(ckBtn);
           
   	       pane1.add(pane,BorderLayout.CENTER);
   	       return pane1;
       }
       /*
        * ϵͳ�������
        */
       private JPanel initPane6(){
    	   JPanel pane1 = new JPanel();
    	   pane1.setBorder(BorderFactory.createRaisedBevelBorder());
           pane1.setLayout(new BorderLayout());
           ToolBarMouseListener ml = new ToolBarMouseListener(this);
           GridBagLayout layout = new GridBagLayout();
           JPanel pane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/ethty.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           pane.setOpaque(false);
           
           pane.setLayout(layout);
           
           JLabel backlabel = new JLabel(new ImageIcon("res/buttonIcon/stxzbook.png"));
           layout.setConstraints(backlabel, new GBC(1, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(0, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);
           
           backlabel = new JLabel(new ImageIcon("res/buttonIcon/todown.png"));
           layout.setConstraints(backlabel, new GBC(2, 0,1,1).setInsets(0,10,20,10));
           pane.add(backlabel);

           //��Ʒ����
           spglBtn = new JButton(new ImageIcon("res/buttonIcon/spglbtn.png"));
           spglBtn.setCursor(mouseHand);
           spglBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(spglBtn, new GBC(0, 1,1,1).setInsets(5,40,5,40));
           spglBtn.addActionListener(new SanPingGLAction(this));
           spglBtn.addMouseListener(ml);
           pane.add(spglBtn);
           //����������
           ghsszBtn = new JButton(new ImageIcon("res/buttonIcon/ghsszbtn.png"));
           ghsszBtn.setMargin(new Insets(0,0,0,0));
           ghsszBtn.setCursor(mouseHand);
           layout.setConstraints(ghsszBtn, new GBC(0,2,1,1).setInsets(5,40,5,40));
           ghsszBtn.setBackground(new Color(255,192,203));//------------
           ghsszBtn.addActionListener(new ActionListener(){

   			public void actionPerformed(ActionEvent e) {
   			  new GongHuoShang(MainFrame.this,"����������");
   			}
           	   
              });
              
           ghsszBtn.addMouseListener(ml);
           pane.add(ghsszBtn);
           //����Ա����
           czysjBtn = new JButton(new ImageIcon("res/buttonIcon/czysz.png"));
           czysjBtn.setCursor(mouseHand);
           czysjBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(czysjBtn, new GBC(0,3,1,1).setInsets(5,40,5,40));
           czysjBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new OperatorSet(MainFrame.this,"����Ա����");
			}
        	   
           });
           
           czysjBtn.addMouseListener(ml);
           pane.add(czysjBtn);
           //��Ա����
           hygljBtn = new JButton(new ImageIcon("res/buttonIcon/huglbtn.png"));
           hygljBtn.setCursor(mouseHand);
           hygljBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(hygljBtn, new GBC(0,4,1,1).setInsets(5,40,5,40));
           hygljBtn.addMouseListener(ml);
           hygljBtn.addActionListener(new STSZHuiYuanGuanLiAction(this));
           pane.add(hygljBtn);
           //ϵͳ����
           stszBtn = new JButton(new ImageIcon("res/buttonIcon/stszbtn.png"));
           stszBtn.setMargin(new Insets(0,0,0,0));
           stszBtn.setCursor(mouseHand);
           layout.setConstraints(stszBtn, new GBC(0,5,1,1).setInsets(5,40,5,40));
           stszBtn.addMouseListener(ml);
           stszBtn.addActionListener(new SystemSetOtherAction(this));
           pane.add(stszBtn);
           //�ֿ�����
           ckszBtn = new JButton(new ImageIcon("res/buttonIcon/ckszbtn.png"));
           ckszBtn.setCursor(mouseHand);
           ckszBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(ckszBtn, new GBC(2, 1,1,1).setInsets(5,40,5,40));
           ckszBtn.addActionListener(new ActionListener(){

   			public void actionPerformed(ActionEvent e) {
   				new CangKuSheZhi(MainFrame.this,"�ֿ�����");
   			}
           	   
              });
           ckszBtn.addMouseListener(ml);
           pane.add(ckszBtn);
           //�ͻ�����
           khszBtn = new JButton(new ImageIcon("res/buttonIcon/khszbtn.png"));
           khszBtn.setCursor(mouseHand);
           khszBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(khszBtn, new GBC(2,2,1,1).setInsets(5,40,5,40));
           khszBtn.addActionListener(new ActionListener(){
      			public void actionPerformed(ActionEvent e) {
      				new CustomerSet(MainFrame.this,"  �ͻ���Ϣ");
      			}
           });
           khszBtn.addMouseListener(ml);
           pane.add(khszBtn);
           //Ա������
           ygszBtn = new JButton(new ImageIcon("res/buttonIcon/ygszbtn.png"));
           ygszBtn.setCursor(mouseHand);
           ygszBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(ygszBtn, new GBC(2,3,1,1).setInsets(5,40,5,40));
           ygszBtn.addActionListener(new ActionListener(){
     			public void actionPerformed(ActionEvent e) {
     				new WorkSet(MainFrame.this,"Ա������");
     			}
             	   
          });
           ygszBtn.addMouseListener(ml);
           pane.add(ygszBtn);
           //��Ʒ����
           sptjBtn = new JButton(new ImageIcon("res/buttonIcon/sptjbtn.png"));
           sptjBtn.setCursor(mouseHand);
           sptjBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(sptjBtn, new GBC(2,4,1,1).setInsets(5,40,5,40));
           sptjBtn.addMouseListener(ml);
           sptjBtn.addActionListener(new ShangPingTJAction(this));
           pane.add(sptjBtn);
           //�м�ͼ��,��Ʒ���
           JLabel ckLab = new JLabel(new ImageIcon("res/buttonIcon/Security_010.png"));
           layout.setConstraints(ckLab, new GBC(1, 1,1,5).setInsets(5,40,5,40));

           pane.add(ckLab);
           
           //ϵͳά��
           stwhBtn = new JButton(new ImageIcon("res/buttonIcon/spwhbtn.png"));
           stwhBtn.setMargin(new Insets(0,0,0,0));
           stwhBtn.setCursor(mouseHand);
           layout.setConstraints(stwhBtn, new GBC(2, 5,1,1).setInsets(5,40,5,40));
           stwhBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				new SystemWeiHuFrame(MainFrame.this,"ϵͳά��",true);
			}
        	   
           });
           stwhBtn.addMouseListener(ml);
           pane.add(stwhBtn);
    
   	       pane1.add(pane,BorderLayout.CENTER);
   	      
   	       return pane1;
       }
       /*
 	   * ״̬���Ľ���
 	   */
 	  private JPanel addSouthPane(){
 		 
 		  
           JPanel southPane = new JPanel();
           southPane.setBorder(BorderFactory.createRaisedBevelBorder());
           southPane.setLayout(new GridLayout(1,4,2,2));
 		 
          JPanel tmpPane = new JPanel();
          tmpPane.setLayout(null);
          tmpPane.setBounds(0, 0, 300, 30);
          tmpPane.setOpaque(false);
 		  JLabel labe = new JLabel("���й���ϵͳ     ������Ŀ������");
 		  labe.setFont(new Font("ff",Font.PLAIN,15));
 		  labe.setBounds(-100, 0, 250, 30);
 		  new Thread(new TeamThread(labe)).start();
 		  tmpPane.add(labe);
 		  tmpPane.setBorder(new LineBorder(Color.gray));
 		  southPane.add(tmpPane);
 		 
 		 
 		 
 		  labe = new JLabel("����Ա:"+user);
 		  labe.setBorder(new LineBorder(Color.gray));
 		  labe.setFont(new Font("ff",Font.PLAIN,15));
 		  southPane.add(labe);
 		 
 		  
 		  labe = new JLabel("������վ    www.wudiqiren.com");
 		  labe.setFont(new Font("ff",Font.PLAIN,15));
 		  labe.setBorder(new LineBorder(Color.gray));
 		  southPane.add(labe);
 		  
 		  timeLabe = new JLabel();
 		  timeLabe.setBorder(new LineBorder(Color.gray));
 		  southPane.add(timeLabe);
 		  return southPane;
 	  }
 	  
 	  /*
 	   * ���涯̬����
 	   */
 	  class TeamThread implements Runnable{
 		JLabel lab = null;
 		TeamThread(JLabel lab){
 			this.lab = lab;
 		}
		public void run() {
			Point p = lab.getLocation();
			int x = p.x,y = p.y;
			while(true){
				x+=1;
				lab.setLocation(x,y);
				//MainFrame.this.validate();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(x >350){
					x = -200;
				}
			}
		}
 		  
 	  }
 	  
 	 /*
 	   * ���涯̬����
 	   */
 	  class NameThread implements Runnable{
 		JLabel lab = null;
 		NameThread(JLabel lab){
 			this.lab = lab;
 		}
		public void run() {
			Point p = lab.getLocation();
			int x = p.x,y = p.y;
			while(true){
				x+=1;
				lab.setLocation(x,y);
				//MainFrame.this.validate();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(x >350){
					x = -200;
				}
			}
		}
 		  
 	  }
 	  
       public static void main(String args[]){
    	   new MainFrame("���˳������۹���ϵͳ  ���ð�","admin");
       }

	public String getUser() {
		return user;
	}

}
