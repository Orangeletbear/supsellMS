package com.cn.view.systemJFrame;

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
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeModel;

import com.cn.control.systemframe.sanpingxinxi.AtlerShangPingAction;
import com.cn.control.systemframe.sanpingxinxi.SPFindAction;
import com.cn.control.systemframe.sanpingxinxi.SelectTreeAction;
import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KuCunKunCBDCulomns;
import com.cn.model.kuchun.KunCunDefaultTreeCellRenderer;
import com.cn.model.system.MyTableCellRender;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.util.InitTreePane;
import com.cn.util.Log;
import com.cn.util.PrintTableData;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.shangpingxinxidialog.AddShangPingDialog;
import com.cn.view.systemJFrame.shangpingxinxidialog.AtlerSPZheKou;
import com.cn.view.systemJFrame.shangpingxinxidialog.AtlerShangPingDialog;
import com.cn.view.systemJFrame.shangpingxinxidialog.SPTiaoJiManage;
/*
 * ϵͳ�����������Ʒ��Ϣ����
 */
public class ShangPingGuangLiFrame extends JDialog {
	//��
	AllTableModel tableModel;
	private JTable sptable;
	//��Ʒ����
	private JTextField spmcfield ;
	//�����ϱ��
	private JTextField spbhfield ;
	
	//��Ʒ�������ṹ
	private JTree tree;
	//
	JPopupMenu  popMenu = new JPopupMenu();
	
	public AllTableModel getTableModel() {
		return tableModel;
	}
	public JTable getSptable() {
		return sptable;
	}
	public JTextField getSpmcfield() {
		return spmcfield;
	}
	public JTextField getSpbhfield() {
		return spbhfield;
	}
	public JTree getTree() {
		return tree;
	}
	public ShangPingGuangLiFrame(JFrame frame,String title) {
		super(frame,title,true);
		init();
		initDataFromDB();
		this.setVisible(true);
		
	}
	/**
	 * ���ݳ�ʼ��
	 */
	public void initDataFromDB(){
		//�����ݿ�ȡ������
	       Vector data = SanPingGuanLiJDBC.getSPBaseMassege("�������", "");
	       //���½�������
	       this.getTableModel().setDataVector(data,
	    		   AllTableModel.getVectorFromObj(SPTJTableCulomns.SPTLColumnName));
	      //������Ⱦ������
		    TableCellRenderer cellRenderer = new MyTableCellRender();
			//����ÿ�е���Ⱦ��
		    for(int i = 0; i < SPTJTableCulomns.SPTLColumnName.length; i++) {
		    	sptable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
		    }
	
	
	}
	//���ڳ�ʹ��
	public void init(){
		this.setSize(new Dimension(950,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		initPopupMenu();
		this.add(createPane());
		//this.pack();
		this.setResizable(false);
	}
	
	private void initPopupMenu(){
		
		JMenuItem item1 = new JMenuItem("������Ʒ");
		JMenuItem item2 = new JMenuItem("�����۸�");
		JMenuItem item3 = new JMenuItem("�޸��ۿ�");
		JMenuItem item4 = new JMenuItem("�������");
		popMenu.add(item1);
		popMenu.add(item2);
		popMenu.addSeparator();
		popMenu.add(item3);
		popMenu.add(item4);
		item1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int row = getSptable().getSelectedRow(); 
				String spId = getTableModel().getValueAt(row, 0).toString();
			    boolean isChange = SanPingGuanLiJDBC.jinYongSP(spId);
			    if(isChange == true){
			       	 JOptionPane.showMessageDialog(null,"���óɹ�");
			       	 MainFrame mframe = (MainFrame)ShangPingGuangLiFrame.this.getOwner();
			       	 
			       	 String user = mframe.getUser();
			       	 Log.traceLog(" ����Ա  ",user,"  ��������Ʒ "+getTableModel().getValueAt(row, 1));
			        }else{
			       	 JOptionPane.showMessageDialog(null,"ע: ����Ʒ���ɽ���");
			        } 
			}
		});
		
		item2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(ShangPingGuangLiFrame.this.getSptable().getSelectedRowCount()==1){
					new SPTiaoJiManage(ShangPingGuangLiFrame.this,"���۹���");
					initDataFromDB();
				}else{
					JOptionPane.showMessageDialog(
							ShangPingGuangLiFrame.this, "��ѡ��һ����Ʒ����");
				}
			}
		});
		item3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(ShangPingGuangLiFrame.this.getSptable().getSelectedRowCount()==1){
					new AtlerSPZheKou(ShangPingGuangLiFrame.this,"�ۿ��޸�",true);
					initDataFromDB();
				}else{
					JOptionPane.showMessageDialog(
							ShangPingGuangLiFrame.this, "��ѡ��һ����Ʒ����");
				}
			}
		});
	}
	
	//�������
	private JPanel createPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		//�ֱ����
		JSplitPane splitPane = new JSplitPane();
		//����������
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new BorderLayout(2,2));
		leftPane.setBorder(new TitledBorder("��Ʒ���"));
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		northPane.add(new JLabel("�������"));
		
		spmcfield = new JTextField(10);
		northPane.add(spmcfield);
		
		leftPane.add(northPane,BorderLayout.NORTH);
		InitTreePane tmp = new InitTreePane(tree);
		tree = tmp.getTree();
		
		leftPane.add(tmp.getPane(),BorderLayout.CENTER);
		splitPane.setLeftComponent(leftPane);
		
        tree.addMouseListener(new SelectTreeAction(this));
        
		//�ұ����Ľ���
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		rightPane.setBorder(new TitledBorder("��Ʒ�б�"));
		
		rightPane.add(initPaneToolPane(),BorderLayout.NORTH);
		
		JPanel rightCenterPane = new JPanel();
		rightCenterPane.setLayout(new BorderLayout());
	    JPanel northPane1 = new JPanel();
		JLabel lab1 = new JLabel("��Ʒ��� : ");
		spbhfield = new JTextField(14);
		JButton sptnBtn = new JButton("��ѯ");
		sptnBtn.addActionListener(new SPFindAction(this));
		JCheckBox selectAll = new JCheckBox("ȫѡ��Ʒ(Ctrl+A)");
		selectAll.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(((JCheckBox)arg0.getSource()).isSelected()){
					ShangPingGuangLiFrame.this.getSptable().selectAll();
				}else{
					ShangPingGuangLiFrame.this.getSptable().clearSelection();
				}
			}
			
		});
		
		northPane1.add(lab1);
		northPane1.add(spbhfield);
		northPane1.add(sptnBtn);
		northPane1.add(selectAll);
		lab1 = new JLabel("              ��ʾ:  ��ɫ����Ϊ������Ʒ");
		lab1.setForeground(Color.red);
		northPane1.add(lab1);
		
		
		rightCenterPane.add(northPane1,BorderLayout.NORTH);
		
		JPanel tablePane = new JPanel();
		
		tableModel = new AllTableModel(SPTJTableCulomns.data,SPTJTableCulomns.SPTLColumnName);
		//�½�һ�����
		sptable = new JTable(tableModel);
		
		//���̶���С
		sptable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
		//���Ϊ true��������������߽��ڵ���������
		tablePane.setOpaque(true);

		final MouseInputListener mouseInputListener = getMouseInputListener(sptable);//�������Ҽ�ѡ����
        //�һ�����ѡ�����
		sptable.addMouseListener(mouseInputListener);

		//sptable.addMouseMotionListener(mouseInputListener);
		//����Զ�����
		sptable.setAutoCreateRowSorter(true);
		sptable.setComponentPopupMenu(popMenu);
		sptable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() == 2){
					int row = getSptable().getSelectedRow();
					String obj = getTableModel().getValueAt(row, 0).toString();
					
					new AtlerShangPingDialog(ShangPingGuangLiFrame.this,"�޸���Ʒ",true,obj);
				}
			}
		});
		//��һ��������
		
		tablePane.add(new JScrollPane(sptable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ),BorderLayout.CENTER);
		
		rightCenterPane.add(new JScrollPane(tablePane));
		
		rightPane.add(rightCenterPane);
		
		splitPane.setRightComponent(rightPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(200);
		//splitPane.setDividerSize(0);
		mainPane.add(splitPane);
		return mainPane;
	}
	
	
	 /*

     * �������Ҽ�����ѡ�����������ʾ�Ҽ��˵�

     */

    private static MouseInputListener getMouseInputListener(final JTable jTable){

       return new MouseInputListener() {

           public void mouseClicked(MouseEvent e) {
              processEvent(e);

           }
           public void mousePressed(MouseEvent e) {

              processEvent(e);

           }
           public void mouseReleased(MouseEvent e) {

              processEvent(e);

              /*if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0

                     && !e.isControlDown() && !e.isShiftDown()) {

//                popupMenu.show(tableLyz, e.getX(), e.getY());//�Ҽ��˵���ʾ

              }*/
           }
           public void mouseEntered(MouseEvent e) {

              processEvent(e);

           }
           public void mouseExited(MouseEvent e) {
              processEvent(e);
           }
           public void mouseDragged(MouseEvent e) {
              processEvent(e);

           }
           public void mouseMoved(MouseEvent e) {
              processEvent(e);
           }
           private void processEvent(MouseEvent e) {

              if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
                  int modifiers = e.getModifiers();

                  modifiers -= MouseEvent.BUTTON3_MASK;

                  modifiers |= MouseEvent.BUTTON1_MASK;

                  MouseEvent ne = new MouseEvent(e.getComponent(), e.getID(),

                         e.getWhen(), modifiers, e.getX(), e.getY(), 
                         e.getClickCount(), false);

                  jTable.dispatchEvent(ne);
              }
           }

       };

    }
	
	
	//���������
	private JPanel initPaneToolPane(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		//������Ʒ
		JButton zjspBtn = new JButton(new ImageIcon("res/AcionIcon/add.jpg"));
		zjspBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				new AddShangPingDialog(ShangPingGuangLiFrame.this,"������Ʒ",true);
			}
			
		});
		zjspBtn.setMargin(new Insets(0,0,0,0));
		//�޸���Ʒ
		JButton xgBtn = new JButton(new ImageIcon("res/AcionIcon/atler.jpg"));
		xgBtn.addActionListener(new AtlerShangPingAction(this));
		xgBtn.setMargin(new Insets(0,0,0,0));
		//ɾ����Ʒ
		JButton scBtn = new JButton(new ImageIcon("res/AcionIcon/delete.jpg"));
		scBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(ShangPingGuangLiFrame.this.getSptable().getSelectedColumnCount()!=1){
					JOptionPane.showMessageDialog(null,"����ѡ��һ������");
					return;
				}
		        int choice =  JOptionPane.showConfirmDialog(
		        		ShangPingGuangLiFrame.this, "����ɾ���󽫲��ָܻ����Ƿ�ɾ����","ɾ������",
		        		 JOptionPane.YES_NO_OPTION, 1);
		          //��ȷ��ɾ������
			     if(choice == JOptionPane.YES_OPTION){
			    	 int row = ShangPingGuangLiFrame.this.getSptable().
			    	             getSelectedRow();
			    	 
			    	 String obj = ShangPingGuangLiFrame.this.getTableModel()
			    	           .getValueAt(row, 0).toString();
			    	 
			    	 if(SanPingGuanLiJDBC.deleteData(obj)){
			    		 JOptionPane.showMessageDialog(null,"���ݳɹ�ɾ��");
			    		 initDataFromDB();
			    	 }else{
			    		 JOptionPane.showMessageDialog(null,"����Ʒ����ҵ����ɾ��");
			    	 }
			     }
			}
			
		});
		scBtn.setMargin(new Insets(0,0,0,0));
		//����
		JButton tjBtn = new JButton(new ImageIcon("res/AcionIcon/changeprice.jpg"));
		tjBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(ShangPingGuangLiFrame.this.getSptable().getSelectedRowCount()==1){
					new SPTiaoJiManage(ShangPingGuangLiFrame.this,"���۹���");
					initDataFromDB();
					
				}else{
					JOptionPane.showMessageDialog(
							ShangPingGuangLiFrame.this, "��ѡ��һ����Ա����");
				}
			}
		});
		tjBtn.setMargin(new Insets(0,0,0,0));
		//�ۿ�
		JButton zkBtn = new JButton(new ImageIcon("res/AcionIcon/discont.jpg"));
		zkBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(ShangPingGuangLiFrame.this.getSptable().getSelectedRowCount()==1){
					new AtlerSPZheKou(ShangPingGuangLiFrame.this,"�ۿ��޸�",true);
					initDataFromDB();
					
				}else{
					JOptionPane.showMessageDialog(
							ShangPingGuangLiFrame.this, "��ѡ��һ����Ա����");
				}
			}
		});
		
		zkBtn.setMargin(new Insets(0,0,0,0));
		//��ѯ����
		JButton cxglBtn = new JButton(new ImageIcon("res/AcionIcon/chakanguolv.jpg"));
		cxglBtn.setMargin(new Insets(0,0,0,0));
		//����
		JButton importSp = new JButton(new ImageIcon("res/AcionIcon/import.jpg"));
		importSp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PrintTableData.printTableData("abt.xls", sptable, 
						SPTJTableCulomns.SPTLColumnName);
			}
			
		});
		importSp.setMargin(new Insets(0,0,0,0));
		//����
		JButton export = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
		export.setMargin(new Insets(0,0,0,0));
		
		//�˳�
		JButton exitBtn = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		exitBtn.setMargin(new Insets(0,0,0,0));
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ShangPingGuangLiFrame.this.dispose();
			}
			
		});
		
		pane.add(zjspBtn);
		pane.add(xgBtn);
		pane.add(scBtn);
		pane.add(tjBtn);
		pane.add(zkBtn);
		pane.add(cxglBtn);
		pane.add(importSp);
		pane.add(export);
		pane.add(exitBtn);
		
		
		
		return pane;
	}

	
	public static void main(String[] args) {
	     new ShangPingGuangLiFrame((JFrame)null,"��Ʒ��Ϣ");
	}

}
