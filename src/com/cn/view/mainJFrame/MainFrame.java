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
 * 该方法创建了一个主界面，主界面里包括七个JButton分别为：换班管理，单据查询，销售分析，
 * 库存查询，今日提醒，软件帮助，退出系统。这七个按钮放置于主界面的北边，还包括六个选项卡
 * 分别为：进货管理，销售管理，库存管理，统计报表，日常管理，系统设置。
 * @param st
 */

public class MainFrame extends JFrame {
	
	 private static final long serialVersionUID = 1L;
     //鼠标手
	 Cursor mouseHand = new Cursor(Cursor.HAND_CURSOR);
	 
	 //启动时是否自动提醒商品报警等信息
	 private boolean isRemindWhenStart = false;
	 //当前登陆用户名
	 private String user;
	 
	//==========工具栏上管理============//
	 private JButton huangban;
	 private JButton chaXun;
	 private JButton kuChu;
	 private JButton remind;
	 private JButton help;
	 private JButton exit;
	 
 
	//==========采购管理面板============//
	//采购进货
     JButton cgBtn;
     //采购退货
     JButton cgtBtn;
     //往来账务
     JButton ghswlzwBtn;
     //采购单据查询
     JButton cgdjBtn;
     //单前库存查询
     JButton dckcBtn; 
     
	//==========销售管理面板============//
	 //商品销售
     JButton spxsBtn;
     //顾客退货
     JButton gkthBtn ;
     //往来账务
     JButton khwlzwBtn;
     //销售单据查询
     JButton xsdjBtn;
     //当前库存查询
     JButton dqkcBtn;
     //POS销售统计
     JButton posBtn;
	 
	 //==========库存管理面板============//
	 //库存调拔
     JButton kctbBtn;
     //拆分捆绑
     JButton cfkbBtn;
     //库存报益
     JButton kcbyBtn;
     //库存盘点
     JButton kcpdBtn;
     //库存变动
     JButton kcbdBtn;
     //库存报警
     JButton kcbjBtn;
	 
	 //==========统计报表面板============//
	 //供应商统计
     JButton gystjBtn;
     //商品采购统计
     JButton spcgtjBtn;
     //业务员采购统计
     JButton ywycgBtn;
     //库存成本统计
     JButton kccbBtn;
     //库存变动表
     JButton kcbdtBtn;
     //客户销售统计
     JButton khxstjBtn;
     //业务员销售统计
     JButton ywyxsBtn;
     //商品销售统计
     JButton spxstjBtn;
     //商品销售排行
     JButton spxsphBtn;
	 
	 //==========日常管理面板============//
     //供应商管理
     JButton gysglBtn;
     //业务员管理
     JButton ywyglBtn;
     //客户综合管理
     JButton khzhglBtn;
     //报价管理
     JButton bjglBtn;
     //==========系统设置============//
     
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
	//选项卡面板,主界面
	private JTabbedPane mainDaoHang; 
	//显示时间
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
   	 * 登陆界面
   	 */
       private void init(){	
    	  
    	   this.setSize(900,600);
    	   this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	   this.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent arg0) {
				int choice =  JOptionPane.showConfirmDialog(MainFrame.this,
						" 是   / 否  退  出  系  统  ","退出警告",
		        		 JOptionPane.YES_NO_OPTION, 3);
			     if(choice == JOptionPane.YES_OPTION){
			    	 Log.traceLog( "  操作员  ",user," 退出了管理系统");
			    	 Log.closeStream();
			    	 System.exit(2);
			     }
			}
    	   });
    	   this.setLocationRelativeTo(null);

	       //改变左上角的图标  
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
    	  
           //最大化
    	   this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	   
    	   InitPrivate.initPrivate(this);
    	   initTabblePane();
    	   this.setVisible(true);
    	   initData();
    	   
       }
       /**
        * 功能控制的初使化
        */
       private void  initData(){
    	   
    	   String isRemind = MFrameJDBC.getIsTodayRemind();
    	   if(isRemind.equals("1")){
    		   new RemaindDialog(this,"今日提醒",true).setVisible(true);
    	   }
    	  
    	   
    	   //如下为放音乐文件
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
 	   * 工具栏的创建
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
 			
 		    huangban = new JButton("换班管理",new ImageIcon("res/smallIcon/02.png"));
 			huangban.addActionListener(new HuangBanAction(this));
 		    huangban.setMargin(new Insets(0,0,0,0));
 		    huangban.setCursor(mouseHand);
 			ToolBarMouseListener ml = new ToolBarMouseListener(this);
 			huangban.setHorizontalTextPosition(SwingConstants.CENTER);
 			huangban.setVerticalTextPosition(SwingConstants.BOTTOM);
 			huangban.setFont(new Font("Serif",Font.BOLD,15));
 			huangban.addMouseListener(ml);
 			
 			chaXun = new JButton("单据查询",new ImageIcon("res/smallIcon/xx12.png"));
 			chaXun.setMargin(new Insets(0,0,0,0));
 			chaXun.addActionListener(new DangJuAction(this));
 			chaXun.setHorizontalTextPosition(SwingConstants.CENTER);
 			chaXun.setVerticalTextPosition(SwingConstants.BOTTOM);
 			chaXun.setFont(new Font("Serif",Font.BOLD,15));
 			chaXun.setCursor(mouseHand);
 			chaXun.addMouseListener(ml);
 			
 			kuChu = new JButton("库存查询",new ImageIcon("res/smallIcon/kuc.png"));
 			kuChu.setMargin(new Insets(0,0,0,0));
 			kuChu.addActionListener(new KuChunFindAction(this));
 			kuChu.setHorizontalTextPosition(SwingConstants.CENTER);
 			kuChu.setVerticalTextPosition(SwingConstants.BOTTOM);
 			kuChu.setFont(new Font("Serif",Font.BOLD,15));
 			kuChu.addMouseListener(ml);
 			kuChu.setCursor(mouseHand);
 			remind = new JButton("今日提醒",new ImageIcon("res/smallIcon/remind11751.png"));
 			remind.setMargin(new Insets(0,0,0,0));
 			remind.addActionListener(new ToDayRemaindLisetener(this));
 			remind.setHorizontalTextPosition(SwingConstants.CENTER);
 			remind.setVerticalTextPosition(SwingConstants.BOTTOM);
 			remind.setFont(new Font("Serif",Font.BOLD,15));
 			remind.addMouseListener(ml);
 			remind.setCursor(mouseHand);
 			help = new JButton("系统帮助",new ImageIcon("res/smallIcon/13.png"));
 			help.setMargin(new Insets(0,0,0,0));
 			help.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new HelpDialog(MainFrame.this,"帮助文档");
				}
 			});
 			help.setHorizontalTextPosition(SwingConstants.CENTER);
 			help.setVerticalTextPosition(SwingConstants.BOTTOM);
 			help.setFont(new Font("Serif",Font.BOLD,15));
 			help.addMouseListener(ml);
 			help.setCursor(mouseHand);
 			
 			exit = new JButton("退出系统",new ImageIcon("res/smallIcon/09.png"));
 			exit.setMargin(new Insets(0,0,0,0));
 			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					int choice =  JOptionPane.showConfirmDialog(MainFrame.this,
							" 是   / 否  退  出  系  统  ","退出警告",
			        		 JOptionPane.YES_NO_OPTION, 3);
				     if(choice == JOptionPane.YES_OPTION){
				    	 Log.traceLog( "  用户  ",user," 退出了管理系统");
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
 	 		JLabel labe = new JLabel("超市销售管理系统");
 	 		labe.setForeground(Color.blue);
 	 		labe.setFont(new Font("华文行楷",Font.PLAIN,50));
 	 		//labe.setBounds(-100, 0, 300, 100);
 	 		//new Thread(new NameThread(labe)).start();
 	 		//namePane.add(labe);
 	 		//namePane.setBorder(new LineBorder(Color.gray));
 	 		toolPane.add(labe);
 			
 			return toolPane;
 	  }
       /**
        * 该方法初始化六个选项卡和五个空标签将其添加到JTabbedPane中
        * 并返回一个JTabbedPane
        * @return JTabbedPane
        */
       private JTabbedPane initTabbedPane() { 
    	  
    	   JLabel nullJ11,nullJ22,nullJ33,nullJ44,nullJ55,nullJ66,nullJ67;  //定义五个标签，用来充当六个选项卡之间的间距
    	   mainDaoHang=new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
    	   //初始化JTabbedPane设置其布局
    	   //jt.setBorder(new LineBorder(new Color(87,131,178),5,true));//设置边框
 
    	    nullJ11=new JLabel();
     	    nullJ22=new JLabel();
     	    nullJ33=new JLabel();
     	    nullJ44=new JLabel();
     	    nullJ55=new JLabel();
     	    nullJ66=new JLabel();
     	    nullJ67=new JLabel();
     	    mainDaoHang.add(nullJ66);
     	    mainDaoHang.addTab("进货管理", new ImageIcon("res/smallIcon/web .png"), initPane1());   	
     	    mainDaoHang.add(nullJ11);
     	    mainDaoHang.addTab("销售管理", new ImageIcon("res/smallIcon/web (11).png"), initPane2());
     	    mainDaoHang.add(nullJ22);
     	    mainDaoHang.addTab("库存管理", new ImageIcon("res/smallIcon/web (3).png"), initPane3());  
     	    mainDaoHang.add(nullJ33);
     	    mainDaoHang.addTab("报表统计", new ImageIcon("res/smallIcon/tongji.png"), initPane4()); 
     	    mainDaoHang.add(nullJ44);
     	    mainDaoHang.addTab("日常管理", new ImageIcon("res/smallIcon/web3.png"), initPane5());
     	    mainDaoHang.add(nullJ55);
     	    mainDaoHang.addTab("系统设置", new ImageIcon("res/smallIcon/setting.png"), initPane6());
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
         *选项卡的初始化,对管理员权限的限制
         */
         private void initTabblePane(){
        	//mainDaoHang.remove(1);
      	    //mainDaoHang.setEnabledAt(1, false);
      	    // mainDaoHang.setEnabledAt(3, false);
      	    // mainDaoHang.setVisible(false);
      	    String[] quanXian = MFrameJDBC.getPrivateForUser(user);
      	    //改变界面的操作权
      	    for(int i= 0 ;i< quanXian.length;i++) {
      	    	if(!quanXian[i].equals("是")){
      	    		mainDaoHang.setEnabledAt((i*2)+1, false);
      	    	}
      	    }
      	    //确定焦点
      	    for(int i= 0 ;i< mainDaoHang .getTabCount();i++){
      	    	if(mainDaoHang.isEnabledAt(i)){
      	    		mainDaoHang.setSelectedIndex(i);
      	    		return;
      	    	}
      	    }
         }
       
       /*
        * 进货管理面板
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
           
           
           
           //采购进货
           cgBtn = new JButton(new ImageIcon("res/buttonIcon/caibtn2.png"));
           //JButton cgBtn = new JButton("采购进货");
           cgBtn.setCursor(mouseHand);
           cgBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(cgBtn, new GBC(0, 1,1,1).setInsets(5,5,5,40));
           cgBtn.addMouseListener(ml);
           cgBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CaiGouJinHuo(MainFrame.this,"采购进货",true);
			   }
           });
           pane.add(cgBtn);
           
           //采购退货
           cgtBtn = new JButton(new ImageIcon("res/buttonIcon/thbtn.png"));
           cgtBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(cgtBtn, new GBC(0,3,1,1).setInsets(5,5,5,40));
           cgtBtn.addMouseListener(ml);
           cgtBtn.setCursor(mouseHand);
           cgtBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CaiGouTuiHuo(MainFrame.this,"采购退货",true);
			   }
           });
           pane.add(cgtBtn);
           //往来账务
           ghswlzwBtn = new JButton(new ImageIcon("res/buttonIcon/wlzwbtn.png"));
           ghswlzwBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(ghswlzwBtn, new GBC(2,1,1,1).setInsets(5,40,5,5));
           ghswlzwBtn.addMouseListener(ml);
           ghswlzwBtn.setCursor(mouseHand);
           ghswlzwBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new WangLaiZhangWu(MainFrame.this,"往来账务(供货商)",true);
			   }
           });
           
           pane.add(ghswlzwBtn);
           //采购单据查询
           cgdjBtn = new JButton(new ImageIcon("res/buttonIcon/cgdjcxbtn.png"));
           cgdjBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(cgdjBtn, new GBC(2,2,1,1).setInsets(5,40,5,5));
           cgdjBtn.addMouseListener(ml);
           cgdjBtn.setCursor(mouseHand);
           cgdjBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CaiGouDanJuChaXun(MainFrame.this,"采购单据查询",true);
			   }
           });
           pane.add(cgdjBtn);
           //单前库存查询
           dckcBtn = new JButton(new ImageIcon("res/buttonIcon/dqkcbtn.png"));
           dckcBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(dckcBtn, new GBC(2,3,1,1).setInsets(5,40,5,5));
           dckcBtn.addMouseListener(ml);
           dckcBtn.setCursor(mouseHand);
           dckcBtn.addActionListener(new KuCunBDAction(this));
           pane.add(dckcBtn);
           
           //空白的补充
           JLabel label = new JLabel();
           
           label = new JLabel(new ImageIcon("res/smallIcon/123.png"));
           layout.setConstraints(label, new GBC(0,2,1,1).setInsets(5,40,5,5));
           pane.add(label);
           //中心仓库
           JButton ckBtn = new JButton(new ImageIcon("res/buttonIcon/1.png"));
           layout.setConstraints(ckBtn, new GBC(1, 1,1,3).setInsets(5,40,5,40));
           ckBtn.setCursor(mouseHand);
           ckBtn.setMargin(new Insets(0,0,0,0));
           ckBtn.addMouseListener(ml);
           ckBtn.addActionListener(new KuCunBDAction(this));
           pane.add(ckBtn);
           //快捷通道
           JPanel southPane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/boderback.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           southPane.setOpaque(false);
           
           southPane.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
           southPane.setFont(new Font("Serif",Font.BOLD,20));
       
          
           JButton spBtn = new JButton("商品信息  ",new ImageIcon("res/smallIcon/to001.png"));
     
           spBtn.addActionListener(new SanPingGLAction(this));
           
           JButton ghSsetBtn = new JButton("供货商设置  ",new ImageIcon("res/smallIcon/to001.png"));
           ghSsetBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new GongHuoShang(MainFrame.this,"供货商设置");
			   }
           });
           ghSsetBtn.setCursor(mouseHand);
           
           JButton ckSetBtn = new JButton("仓库设置  ",new ImageIcon("res/smallIcon/to001.png"));
           ckSetBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CangKuSheZhi(MainFrame.this,"仓库设置");
			   }
           });
           ckSetBtn.setCursor(mouseHand);
           
           JButton workerBtn = new JButton("员工信息  ",new ImageIcon("res/smallIcon/to001.png"));
           workerBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new WorkSet(MainFrame.this,"员工设置");
			   }
           });
           workerBtn.setCursor(mouseHand);
           
           spBtn.addMouseListener(ml);
           ghSsetBtn.addMouseListener(ml);
           ckSetBtn.addMouseListener(ml);
           workerBtn.addMouseListener(ml);
           
           //Label用于补充作用
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
        * 销售管理面板
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
           //商品销售
           spxsBtn = new JButton(new ImageIcon("res/buttonIcon/spxsbtn.png"));
           spxsBtn.setCursor(mouseHand);
           spxsBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(spxsBtn, new GBC(0, 1,1,1).setInsets(5,5,5,40));
           spxsBtn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 new ShangPinXiaoShouDialog(MainFrame.this,"商品销售",true);
			 }
        	   
           });
           
           spxsBtn.addMouseListener(ml);
           pane.add(spxsBtn);
           //顾客退货
           gkthBtn = new JButton(new ImageIcon("res/buttonIcon/gkthbtn.png"));
           gkthBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(gkthBtn, new GBC(0,2,1,1).setInsets(5,5,5,40));
           gkthBtn.setCursor(mouseHand);
           gkthBtn.addActionListener(new ActionListener(){
  			 public void actionPerformed(ActionEvent e) {
  				new GuKeTuiHuoDialog(MainFrame.this,"顾客退货",true);
  			 }
          	   
           });
           gkthBtn.addMouseListener(ml);
           pane.add(gkthBtn);
           //往来账务
           khwlzwBtn = new JButton(new ImageIcon("res/buttonIcon/wlzwbtn.png"));
           khwlzwBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(khwlzwBtn, new GBC(0,3,1,1).setInsets(5,5,5,40));
           khwlzwBtn.setCursor(mouseHand);
           khwlzwBtn.addActionListener(new ActionListener(){
    			 public void actionPerformed(ActionEvent e) {
    				 new KeHuXiaoShouMainFrame(MainFrame.this,"往来账务(客户)",true);
    			 }
           });
           khwlzwBtn.addMouseListener(ml);
           pane.add(khwlzwBtn);
           //销售单据查询
           xsdjBtn = new JButton(new ImageIcon("res/buttonIcon/xsdjcxbtn.png"));
           xsdjBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(xsdjBtn, new GBC(2,1,1,1).setInsets(5,40,5,5));
           xsdjBtn.setCursor(mouseHand);
           xsdjBtn.addActionListener(new ActionListener(){
  			 public void actionPerformed(ActionEvent e) {
  				 new DanJuChaXunDialog(MainFrame.this,"销售单据查询",true);
  			 }
           });
           xsdjBtn.addMouseListener(ml);
           pane.add(xsdjBtn);
           //当前库存查询
           dqkcBtn = new JButton(new ImageIcon("res/buttonIcon/dqkccxbtn.png"));
           dqkcBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(dqkcBtn, new GBC(2,2,1,1).setInsets(5,40,5,5));
           dqkcBtn.addMouseListener(ml);
           dqkcBtn.setCursor(mouseHand);
           dqkcBtn.addActionListener(new KuCunBDAction(this));
           pane.add(dqkcBtn);
           //POS销售统计
           posBtn = new JButton(new ImageIcon("res/buttonIcon/postjbtn.png"));
           posBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(posBtn, new GBC(2,3,1,1).setInsets(5,40,5,5));
           posBtn.setCursor(mouseHand);
           posBtn.addActionListener(new ActionListener(){
    			 public void actionPerformed(ActionEvent e) {
    				 new POSDialog(MainFrame.this,"POS销售统计",true);
    			 }
             });
           posBtn.addMouseListener(ml);
           pane.add(posBtn);
           
           //中心仓库
           JButton ckBtn = new JButton(new ImageIcon("res/buttonIcon/1.png"));
           layout.setConstraints(ckBtn, new GBC(1, 1,1,3).setInsets(5,40,5,40));
           ckBtn.addMouseListener(ml);
           ckBtn.setCursor(mouseHand);
           ckBtn.setMargin(new Insets(0,0,0,0));
           ckBtn.addActionListener(new KuCunBDAction(this));
           pane.add(ckBtn);
           
           //快捷通道
           JPanel southPane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/boderback.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           southPane.setOpaque(false);
           
           southPane.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
           southPane.setFont(new Font("Serif",Font.BOLD,20));
           
           JButton spBtn = new JButton("商品信息  ",new ImageIcon("res/smallIcon/to001.png"));
           spBtn.setCursor(mouseHand);
           spBtn.addActionListener(new SanPingGLAction(this));
           JButton ghSsetBtn = new JButton("客户设置  ",new ImageIcon("res/smallIcon/to001.png"));
           ghSsetBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CustomerSet(MainFrame.this,"  客户信息");
			   }
           });
           ghSsetBtn.setCursor(mouseHand);
           JButton ckSetBtn = new JButton("仓库设置  ",new ImageIcon("res/smallIcon/to001.png"));
           ckSetBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CangKuSheZhi(MainFrame.this,"仓库设置");
			   }
           });
           ckSetBtn.setCursor(mouseHand);
           JButton workerBtn = new JButton("员工信息  ",new ImageIcon("res/smallIcon/to001.png"));
           workerBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new WorkSet(MainFrame.this,"员工设置");
			   }
           });
           workerBtn.setCursor(mouseHand);
           
           spBtn.addMouseListener(ml);
           ghSsetBtn.addMouseListener(ml);
           ckSetBtn.addMouseListener(ml);
           workerBtn.addMouseListener(ml);
           
           //Label用于补充作用
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
        * 库存管理
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
   
           //库存调拔
           kctbBtn = new JButton(new ImageIcon("res/buttonIcon/kctbbtn.png"));
           kctbBtn.setCursor(mouseHand);
           kctbBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(kctbBtn, new GBC(0,1,1,1).setInsets(5,5,5,40));
           kctbBtn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent arg0) {
				 new KucunDiaobo(MainFrame.this,"库存调拨",true);
			}
        	   
           });
           kctbBtn.addMouseListener(ml);
           pane.add(kctbBtn);
           //拆分捆绑
           cfkbBtn = new JButton(new ImageIcon("res/buttonIcon/cfkbbtn.png"));
           cfkbBtn.setMargin(new Insets(0,0,0,0));
           cfkbBtn.setCursor(mouseHand);
           layout.setConstraints(cfkbBtn, new GBC(0,2,1,1).setInsets(5,5,5,40));
           cfkbBtn.addActionListener(new ActionListener(){
  			 public void actionPerformed(ActionEvent arg0) {
  				new ChaifenKunbang(MainFrame.this,"拆分捆绑",true);
  			}
          	   
             });
           cfkbBtn.addMouseListener(ml);
           pane.add(cfkbBtn);
           //库存报益
           kcbyBtn = new JButton(new ImageIcon("res/buttonIcon/bsbybtn.png"));
           kcbyBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(kcbyBtn, new GBC(0,3,1,1).setInsets(5,5,5,40));
           kcbyBtn.setCursor(mouseHand);
           kcbyBtn.addActionListener(new ActionListener(){
  			 public void actionPerformed(ActionEvent arg0) {
  				new BaosunBaoyi(MainFrame.this,"报损报溢",true);
  			}
          	   
             });
           kcbyBtn.addMouseListener(ml);
           pane.add(kcbyBtn);
           //库存盘点
           kcpdBtn = new JButton(new ImageIcon("res/buttonIcon/kcpdbtn.png"));
           kcpdBtn.setMargin(new Insets(0,0,0,0));
           kcpdBtn.setCursor(mouseHand);
           layout.setConstraints(kcpdBtn, new GBC(2,1,1,1).setInsets(5,40,5,5));
           kcpdBtn.addActionListener(new ActionListener(){
    			 public void actionPerformed(ActionEvent arg0) {
    				 new KucunPandian(MainFrame.this,"库存盘点",true);
    			}
            	   
           });
           kcpdBtn.addMouseListener(ml);
           pane.add(kcpdBtn);
           //库存变动
           kcbdBtn = new JButton(new ImageIcon("res/buttonIcon/kcbdbtn.png"));
           kcbdBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(kcbdBtn, new GBC(2,2,1,1).setInsets(5,40,5,5));
           kcbdBtn.setCursor(mouseHand);
           kcbdBtn.addMouseListener(ml);
           kcbdBtn.addActionListener(new KuCunBDAction(this));
           pane.add(kcbdBtn);
           //库存报警
           kcbjBtn = new JButton(new ImageIcon("res/buttonIcon/kcbjbtn.png"));
           kcbjBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(kcbjBtn, new GBC(2,3,1,1).setInsets(5,40,5,5));
           kcbjBtn.setCursor(mouseHand);
           kcbjBtn.addActionListener(new ActionListener(){
  			 public void actionPerformed(ActionEvent arg0) {
  				new KucunBaojin(MainFrame.this,"库存警报",true);
  			}
          	   
         });
           kcbjBtn.addMouseListener(ml);
           pane.add(kcbjBtn);
           //仓库
           JButton ckBtn = new JButton(new ImageIcon("res/buttonIcon/1.png"));
           layout.setConstraints(ckBtn, new GBC(1, 1,1,3).setInsets(5,40,5,40));
           ckBtn.setMargin(new Insets(0,0,0,0));
           ckBtn.setCursor(mouseHand);
           ckBtn.addMouseListener(ml);
           ckBtn.addActionListener(new KuCunBDAction(this));
           pane.add(ckBtn);
           
           //快捷通道
           JPanel southPane = new JPanel(){ 
               public void paintComponent(Graphics g){ 
                   g.drawImage(new ImageIcon("res/BackImage/boderback.jpg").getImage(), 0, 0, null); 
                   super.paintComponent(g); 
               } 
           };
           southPane.setOpaque(false);
           southPane.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
           southPane.setFont(new Font("Serif",Font.BOLD,20));
           
           JButton spBtn = new JButton("商品信息  ",new ImageIcon("res/smallIcon/to001.png"));
           spBtn.setCursor(mouseHand);
           spBtn.addActionListener(new SanPingGLAction(this));
           JButton ckSetBtn = new JButton("仓库设置  ",new ImageIcon("res/smallIcon/to001.png"));
           ckSetBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CangKuSheZhi(MainFrame.this,"仓库设置");
			   }
           });
           ckSetBtn.setCursor(mouseHand);
           JButton workerBtn = new JButton("成本统计  ",new ImageIcon("res/smallIcon/to001.png"));
           workerBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new KuCunMainFrame(MainFrame.this,"库存成本统计",true);
			   }
           });
           workerBtn.setCursor(mouseHand);
           spBtn.addMouseListener(ml);
           ckSetBtn.addMouseListener(ml);
           workerBtn.addMouseListener(ml);
           
           //Label用于补充作用
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
        * 报表统计面板
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
           //供应商统计
           gystjBtn = new JButton(new ImageIcon("res/buttonIcon/gystjbtn.png"));
           gystjBtn.setMargin(new Insets(0,0,0,0));
           gystjBtn.setCursor(mouseHand);
           layout.setConstraints(gystjBtn, new GBC(0, 1,1,1).setInsets(5,40,5,40));
           gystjBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new WangLaiZhangWu(MainFrame.this,"往来账务(供货商)",true);
			   }
           });
           gystjBtn.addMouseListener(ml);
           pane.add(gystjBtn);
           

           //商品采购统计
           spcgtjBtn = new JButton(new ImageIcon("res/buttonIcon/spcgtjbtn.png"));
           spcgtjBtn.setMargin(new Insets(0,0,0,0));
           spcgtjBtn.setCursor(mouseHand);
           layout.setConstraints(spcgtjBtn, new GBC(0,2,1,1).setInsets(5,40,5,40));
           spcgtjBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new ShangPingCaiGouMainFrame(MainFrame.this,"商品采购统计",true);
			   }
           });
           spcgtjBtn.addMouseListener(ml);
           pane.add(spcgtjBtn);
           //业务员采购统计
           ywycgBtn = new JButton(new ImageIcon("res/buttonIcon/ywycgbtn.png"));
           ywycgBtn.setMargin(new Insets(0,0,0,0));
           ywycgBtn.setCursor(mouseHand);
           layout.setConstraints(ywycgBtn, new GBC(0,3,1,1).setInsets(5,40,5,40));
           ywycgBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new CaiGouTongJiMainFrame(MainFrame.this,"业务员采购统计",true);
			   }
           });
           ywycgBtn.addMouseListener(ml);
           pane.add(ywycgBtn);
           //库存成本统计
           kccbBtn = new JButton(new ImageIcon("res/buttonIcon/kccbtjbtn.png"));
           kccbBtn.setMargin(new Insets(0,0,0,0));
           kccbBtn.setCursor(mouseHand);
           layout.setConstraints(kccbBtn, new GBC(0,4,1,1).setInsets(5,40,5,40));
           kccbBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new KuCunMainFrame(MainFrame.this,"库存成本统计",true);
			   }
           });
           kccbBtn.addMouseListener(ml);
           pane.add(kccbBtn);
           //库存变动表
           kcbdtBtn = new JButton(new ImageIcon("res/buttonIcon/kcbdbtn.png"));
           kcbdtBtn.setMargin(new Insets(0,0,0,0));
           kcbdtBtn.setCursor(mouseHand);
           layout.setConstraints(kcbdtBtn, new GBC(1,1,1,1).setInsets(5,40,5,40));
           kcbdtBtn.addMouseListener(ml);
           kcbdtBtn.addActionListener(new KuCunBDAction(this));
           pane.add(kcbdtBtn);
           //客户销售统计
           khxstjBtn = new JButton(new ImageIcon("res/buttonIcon/khxstjbtn.png"));
           khxstjBtn.setMargin(new Insets(0,0,0,0));
           khxstjBtn.setCursor(mouseHand);
           layout.setConstraints(khxstjBtn, new GBC(2,1,1,1).setInsets(5,40,5,40));
           khxstjBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new KeHuXiaoShouMainFrame(MainFrame.this,"客户销售统计",true);
			   }
           });
           khxstjBtn.addMouseListener(ml);
           pane.add(khxstjBtn);
           //业务员销售统计
           ywyxsBtn = new JButton(new ImageIcon("res/buttonIcon/yywxstjbtn.png"));
           ywyxsBtn.setMargin(new Insets(0,0,0,0));
           ywyxsBtn.setCursor(mouseHand);
           layout.setConstraints(ywyxsBtn, new GBC(2,2,1,1).setInsets(5,40,5,40));
           ywyxsBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new YeWuYuanMainFrame(MainFrame.this,"业务员销售统计",true);
			   }
           });
           ywyxsBtn.addMouseListener(ml);
           pane.add(ywyxsBtn);
           //商品销售统计
           spxstjBtn = new JButton(new ImageIcon("res/buttonIcon/spxstjbtn.png"));
           spxstjBtn.setMargin(new Insets(0,0,0,0));
           spxstjBtn.setCursor(mouseHand);
           layout.setConstraints(spxstjBtn, new GBC(2,3,1,1).setInsets(5,40,5,40));
           spxstjBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new GoodsXiaoShouTongJi(MainFrame.this,"商品销售统计",true);
			   }
           });
           spxstjBtn.addMouseListener(ml);
           pane.add(spxstjBtn);
           //商品销售排行
           spxsphBtn = new JButton(new ImageIcon("res/buttonIcon/spxsphbtn.png"));
           spxsphBtn.setMargin(new Insets(0,0,0,0));
           spxsphBtn.setCursor(mouseHand);
           layout.setConstraints(spxsphBtn, new GBC(2,4,1,1).setInsets(5,40,5,40));
           spxsphBtn.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0) {
				   new XiaoShouMainFrame(MainFrame.this,"商品销售排行",true);
			   }
           });
           spxsphBtn.addMouseListener(ml);
           pane.add(spxsphBtn);
           //中间图标,商品库存
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
        * 日常管理面板
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
           //供应商管理
           gysglBtn = new JButton(new ImageIcon("res/buttonIcon/gysglbtn.png"));
           gysglBtn.setMargin(new Insets(0,0,0,0));
           gysglBtn.setCursor(mouseHand);
           layout.setConstraints(gysglBtn, new GBC(0, 1,1,1).setInsets(40,40,40,40));
           gysglBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				new Supplier_Manage(MainFrame.this,"供货商管理",true);
			}
           });
           

           
           gysglBtn.addMouseListener(ml);
           pane.add(gysglBtn);
           //业务员管理
           ywyglBtn = new JButton(new ImageIcon("res/buttonIcon/ywyglbtn.png"));
           ywyglBtn.setMargin(new Insets(0,0,0,0));
           ywyglBtn.setCursor(mouseHand);
           layout.setConstraints(ywyglBtn, new GBC(0,2,1,1).setInsets(40,40,40,40));
           ywyglBtn.addActionListener(new ActionListener(){

   			public void actionPerformed(ActionEvent arg0) {
   				new Salesman_Manage(MainFrame.this,"业务员管理",true);
   			}
           	   
           });
           ywyglBtn.addMouseListener(ml);
           pane.add(ywyglBtn);
           //客户综合管理
           khzhglBtn = new JButton(new ImageIcon("res/buttonIcon/khzhglbtn.png"));
           khzhglBtn.setMargin(new Insets(0,0,0,0));
           khzhglBtn.setCursor(mouseHand);
           layout.setConstraints(khzhglBtn, new GBC(2,1,1,1).setInsets(40,40,40,40));
           khzhglBtn.addActionListener(new ActionListener(){

      			public void actionPerformed(ActionEvent arg0) {
      				new Customer_Manage(MainFrame.this,"客户综合管理",true);
      			}
              	   
           });
           khzhglBtn.addMouseListener(ml);
           pane.add(khzhglBtn);
           //报价管理
           bjglBtn = new JButton(new ImageIcon("res/buttonIcon/bjtlbtn.png"));
           bjglBtn.setMargin(new Insets(0,0,0,0));
           bjglBtn.setCursor(mouseHand);
           bjglBtn.addActionListener(new ActionListener(){

     			public void actionPerformed(ActionEvent arg0) {
     				new Quote_Manage(MainFrame.this,"报价管理",true);
     			}
             	   
          });
           layout.setConstraints(bjglBtn, new GBC(2,2,1,1).setInsets(40,40,40,40));
           bjglBtn.addMouseListener(ml);
           pane.add(bjglBtn);
           
           //中间的商品仓库图标
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
        * 系统设置面板
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

           //商品管理
           spglBtn = new JButton(new ImageIcon("res/buttonIcon/spglbtn.png"));
           spglBtn.setCursor(mouseHand);
           spglBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(spglBtn, new GBC(0, 1,1,1).setInsets(5,40,5,40));
           spglBtn.addActionListener(new SanPingGLAction(this));
           spglBtn.addMouseListener(ml);
           pane.add(spglBtn);
           //供货商设置
           ghsszBtn = new JButton(new ImageIcon("res/buttonIcon/ghsszbtn.png"));
           ghsszBtn.setMargin(new Insets(0,0,0,0));
           ghsszBtn.setCursor(mouseHand);
           layout.setConstraints(ghsszBtn, new GBC(0,2,1,1).setInsets(5,40,5,40));
           ghsszBtn.setBackground(new Color(255,192,203));//------------
           ghsszBtn.addActionListener(new ActionListener(){

   			public void actionPerformed(ActionEvent e) {
   			  new GongHuoShang(MainFrame.this,"供货商设置");
   			}
           	   
              });
              
           ghsszBtn.addMouseListener(ml);
           pane.add(ghsszBtn);
           //操作员设置
           czysjBtn = new JButton(new ImageIcon("res/buttonIcon/czysz.png"));
           czysjBtn.setCursor(mouseHand);
           czysjBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(czysjBtn, new GBC(0,3,1,1).setInsets(5,40,5,40));
           czysjBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new OperatorSet(MainFrame.this,"操作员设置");
			}
        	   
           });
           
           czysjBtn.addMouseListener(ml);
           pane.add(czysjBtn);
           //会员管理
           hygljBtn = new JButton(new ImageIcon("res/buttonIcon/huglbtn.png"));
           hygljBtn.setCursor(mouseHand);
           hygljBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(hygljBtn, new GBC(0,4,1,1).setInsets(5,40,5,40));
           hygljBtn.addMouseListener(ml);
           hygljBtn.addActionListener(new STSZHuiYuanGuanLiAction(this));
           pane.add(hygljBtn);
           //系统设置
           stszBtn = new JButton(new ImageIcon("res/buttonIcon/stszbtn.png"));
           stszBtn.setMargin(new Insets(0,0,0,0));
           stszBtn.setCursor(mouseHand);
           layout.setConstraints(stszBtn, new GBC(0,5,1,1).setInsets(5,40,5,40));
           stszBtn.addMouseListener(ml);
           stszBtn.addActionListener(new SystemSetOtherAction(this));
           pane.add(stszBtn);
           //仓库设置
           ckszBtn = new JButton(new ImageIcon("res/buttonIcon/ckszbtn.png"));
           ckszBtn.setCursor(mouseHand);
           ckszBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(ckszBtn, new GBC(2, 1,1,1).setInsets(5,40,5,40));
           ckszBtn.addActionListener(new ActionListener(){

   			public void actionPerformed(ActionEvent e) {
   				new CangKuSheZhi(MainFrame.this,"仓库设置");
   			}
           	   
              });
           ckszBtn.addMouseListener(ml);
           pane.add(ckszBtn);
           //客户设置
           khszBtn = new JButton(new ImageIcon("res/buttonIcon/khszbtn.png"));
           khszBtn.setCursor(mouseHand);
           khszBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(khszBtn, new GBC(2,2,1,1).setInsets(5,40,5,40));
           khszBtn.addActionListener(new ActionListener(){
      			public void actionPerformed(ActionEvent e) {
      				new CustomerSet(MainFrame.this,"  客户信息");
      			}
           });
           khszBtn.addMouseListener(ml);
           pane.add(khszBtn);
           //员工设置
           ygszBtn = new JButton(new ImageIcon("res/buttonIcon/ygszbtn.png"));
           ygszBtn.setCursor(mouseHand);
           ygszBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(ygszBtn, new GBC(2,3,1,1).setInsets(5,40,5,40));
           ygszBtn.addActionListener(new ActionListener(){
     			public void actionPerformed(ActionEvent e) {
     				new WorkSet(MainFrame.this,"员工设置");
     			}
             	   
          });
           ygszBtn.addMouseListener(ml);
           pane.add(ygszBtn);
           //商品调价
           sptjBtn = new JButton(new ImageIcon("res/buttonIcon/sptjbtn.png"));
           sptjBtn.setCursor(mouseHand);
           sptjBtn.setMargin(new Insets(0,0,0,0));
           layout.setConstraints(sptjBtn, new GBC(2,4,1,1).setInsets(5,40,5,40));
           sptjBtn.addMouseListener(ml);
           sptjBtn.addActionListener(new ShangPingTJAction(this));
           pane.add(sptjBtn);
           //中间图标,商品库存
           JLabel ckLab = new JLabel(new ImageIcon("res/buttonIcon/Security_010.png"));
           layout.setConstraints(ckLab, new GBC(1, 1,1,5).setInsets(5,40,5,40));

           pane.add(ckLab);
           
           //系统维护
           stwhBtn = new JButton(new ImageIcon("res/buttonIcon/spwhbtn.png"));
           stwhBtn.setMargin(new Insets(0,0,0,0));
           stwhBtn.setCursor(mouseHand);
           layout.setConstraints(stwhBtn, new GBC(2, 5,1,1).setInsets(5,40,5,40));
           stwhBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				new SystemWeiHuFrame(MainFrame.this,"系统维护",true);
			}
        	   
           });
           stwhBtn.addMouseListener(ml);
           pane.add(stwhBtn);
    
   	       pane1.add(pane,BorderLayout.CENTER);
   	      
   	       return pane1;
       }
       /*
 	   * 状态栏的建立
 	   */
 	  private JPanel addSouthPane(){
 		 
 		  
           JPanel southPane = new JPanel();
           southPane.setBorder(BorderFactory.createRaisedBevelBorder());
           southPane.setLayout(new GridLayout(1,4,2,2));
 		 
          JPanel tmpPane = new JPanel();
          tmpPane.setLayout(null);
          tmpPane.setBounds(0, 0, 300, 30);
          tmpPane.setOpaque(false);
 		  JLabel labe = new JLabel("超市管理系统     七人项目开发组");
 		  labe.setFont(new Font("ff",Font.PLAIN,15));
 		  labe.setBounds(-100, 0, 250, 30);
 		  new Thread(new TeamThread(labe)).start();
 		  tmpPane.add(labe);
 		  tmpPane.setBorder(new LineBorder(Color.gray));
 		  southPane.add(tmpPane);
 		 
 		 
 		 
 		  labe = new JLabel("操作员:"+user);
 		  labe.setBorder(new LineBorder(Color.gray));
 		  labe.setFont(new Font("ff",Font.PLAIN,15));
 		  southPane.add(labe);
 		 
 		  
 		  labe = new JLabel("帮助网站    www.wudiqiren.com");
 		  labe.setFont(new Font("ff",Font.PLAIN,15));
 		  labe.setBorder(new LineBorder(Color.gray));
 		  southPane.add(labe);
 		  
 		  timeLabe = new JLabel();
 		  timeLabe.setBorder(new LineBorder(Color.gray));
 		  southPane.add(timeLabe);
 		  return southPane;
 	  }
 	  
 	  /*
 	   * 界面动态控制
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
 	   * 界面动态控制
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
    	   new MainFrame("七人超市销售管理系统  试用版","admin");
       }

	public String getUser() {
		return user;
	}

}
