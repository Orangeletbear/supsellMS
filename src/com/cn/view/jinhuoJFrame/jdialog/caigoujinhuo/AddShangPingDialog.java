package com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import com.cn.control.jinhuoframe.caigoujinhuo.AddMouseAdapterRIGHT;
import com.cn.control.jinhuoframe.caigoujinhuo.AddShangPinMouseAdapt;
import com.cn.control.jinhuoframe.caigoujinhuo.LaoShangPinTianJiaListener;
import com.cn.control.jinhuoframe.caigoujinhuo.TreeMouseListener;
import com.cn.dao.jinhuo.Tb_spinfonameJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.util.InitTreePane;
import com.cn.view.jinhuoJFrame.CaiGouJinHuo;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
/**
 * �������Ʒ��Ӱ�ť���ֵĶԻ���
 *
 */
public class AddShangPingDialog extends JDialog {
	private CaiGouJinHuo caiGouJinHuo;//�����򸸴��ڷ�������
	
//	����򸸴��ڷ��ص�һ������,һ��һ���ļ�
	private Vector<Vector> YiPi_data = new Vector<Vector>();
	
//��Ʒ�б�1,��߱��
	private AllTableModel ATM;
	private Vector LeftData = new Vector();//��߱�����
	JTable splbtable;//��ߵ�һ�����ı�
	
//�ұ������
	private AllTableModel ATM1;
	private JTable splbtable1;
	
	//���ڽ���Ʒ��Ϣ�ɹ�������ʾ���ұ������еĴ��data��Vector����ʵ�ֲ�����ӡ�
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	

	//��Ʒ�嵥,�������
	private JTable spqdtable;
	private Vector spqdtable_data = new Vector();
	private Vector spqdtable_columnName = ColumnNames.spqdtable_columnName;
	private AllTableModel splb_tableModel;
	//��ѯ���ƻ���
	private JTextField spbhfield ;
	
	public JTable getSplbtable() {
		return splbtable;
	}

	//��Ʒ�������ṹ
	private JTree tree;
	
	
	public AddShangPingDialog(CaiGouJinHuo dialog, String title){
		super(dialog,title,true);
		
		//һ��addSanPingDialog��Ӧ�ó�ʼ������߱�������
		this.addWindowListener(new LaoShangPinTianJiaListener(this));
		//����������
		this.caiGouJinHuo = dialog;
		init();
	}
	
	
	//------------------------------------------------
	private void init(){
		this.setSize(new Dimension(950,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.add(createPane());
		//this.pack();
		this.setResizable(false);
		this.setVisible(true);
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
		JButton addBtn = new JButton("������ѡ��Ʒ��F8��");
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(spbhfield.getText().equals("")){
					JOptionPane.showMessageDialog(AddShangPingDialog.this,
					"��������Ʒ��Ż�����!");
					return;
				}
				Vector shangpin = Tb_spinfonameJDBC.find(spbhfield.getText());
				if(shangpin.isEmpty()){
					JOptionPane.showMessageDialog(AddShangPingDialog.this,
					"�ֿ����޸���Ʒ��Ϣ!");
					return;
				}
				String spid = ((Vector)shangpin.get(0)).get(0).toString();
				int i = 0;
				for(Object tmp : LeftData){
					if( ((Vector)tmp).get(0).equals(spid)){//����ѡ����Ϊ��һ��
						splbtable.setRowSelectionInterval(i,i); 
						new  ShangPinXinXi(AddShangPingDialog.this,
								"��Ʒ��Ϣ���ɹ�������",true);
					}else{
						i++;
					}
				}
					
			}
			
		});
		
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
         
         ATM = new AllTableModel(LeftData,ColumnNames.splbtable1_colunm);
         splbtable = new JTable(ATM);
         
         //�������¼����ݱ�������Ϣnew��һ����Ʒ��Ϣdilog������ʼ����dialog
         splbtable.addMouseListener(new AddShangPinMouseAdapt(this));
         
         //���̶���С
         splbtable.setPreferredScrollableViewportSize(new Dimension(1500, 350));
 		 //���Ϊ true��������������߽��ڵ���������
         splbtable.setOpaque(true);
 		//����Զ�����
         splbtable.setAutoCreateRowSorter(true);
 		//��һ��������
         pane.add(new JScrollPane(splbtable));
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
			
			InitTreePane tmptree = new InitTreePane(tree);
			tree = tmptree.getTree();
			tree.addMouseListener(new TreeMouseListener(this));
			leftPane.add(new JScrollPane(tmptree.getPane()),
					BorderLayout.CENTER);
			splitPane.setLeftComponent(leftPane);
		
			JPanel rightPane = new JPanel();
			rightPane.setLayout(new BorderLayout());
			
			JPanel tablePane = new JPanel();
			
			splb_tableModel = new AllTableModel(spqdtable_data,
					spqdtable_columnName);
			//�½�һ�����
			spqdtable = new JTable(splb_tableModel);
			spqdtable.addMouseListener(new MouseAdapter(){
			  public void mouseClicked(MouseEvent e) {
			    if(e.getClickCount()==2 ){
				  int i = spqdtable.getSelectedRow();
				  if(i == -1){ return;}
				  String spid = ((Vector)spqdtable_data.get(i)).get(0).toString(); 
				  
				  int jishu = 0;//ѡ����
				  for(Object tmp : LeftData){
					String argspid = ((Vector)tmp).get(0).toString();
					if(spid.equals(argspid)){
						splbtable.setRowSelectionInterval(jishu,jishu); 
						break;
					}else{
						jishu ++;
					}
				  }	 
				  
				  new ShangPinXinXi(AddShangPingDialog.this,
									"��Ʒ��Ϣ���ɹ�������",true);
						}
					} 
				
				
			});
			//���̶���С
			spqdtable.setPreferredScrollableViewportSize(new Dimension(360, 450));
			//���Ϊ true��������������߽��ڵ���������
			tablePane.setOpaque(true);
			//����Զ�����
			spqdtable.setAutoCreateRowSorter(true);
			//��һ��������
			tablePane.add(new JScrollPane(spqdtable,
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
		
		
		ATM1 = new AllTableModel(data,ColumnNames.splbtable1_colunm);
		splbtable1 = new JTable(ATM1);
		splbtable1.addMouseListener(new AddMouseAdapterRIGHT(this));//��ӱ��˫��������
	
		
        //���̶���С
        splbtable1.setPreferredScrollableViewportSize(new Dimension(1500, 350));
		 //���Ϊ true��������������߽��ڵ���������
        splbtable1.setOpaque(true);
		//����Զ�����
        splbtable1.setAutoCreateRowSorter(true);
		//��һ��������
        rightPane.add(new JScrollPane(splbtable1));
        
        JPanel btnPane = new JPanel();
        btnPane.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        //
        JButton aterBtn = new JButton("�޸�(F3)");
        aterBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(splbtable1.getSelectedRow() == -1){
					return;
				}
				new ShangPinXinXi2(AddShangPingDialog.this,"���޸ģ���Ʒ��Ϣ",true);
			}
        	
        });
        
        //
        JButton deleteBtn = new JButton("ɾ��(Del)");
        deleteBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(splbtable1.getSelectedRow() != -1){
					data.remove(splbtable1.getSelectedRow());//ȥ��ѡ���е�����
				
					//ȥ����ɹ����������洫����������
					YiPi_data.remove(splbtable1.getSelectedRow());
				
					//ˢ�±�
					AddShangPingDialog.this.getATM1().setDataVector(
							data, ColumnNames.splbtable1_colunm);
				}
			}
        	
        });
        //
        JButton okBtn = new JButton("ȷ��(F5)");
        okBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//������һ��һ�еļӹ�ȥ
				for(Vector tmp : YiPi_data){
					caiGouJinHuo.getCaiGouJinHuo_data().add(tmp);
				}
				//ˢ�±�������
				caiGouJinHuo.getATM().setDataVector(
						caiGouJinHuo.getCaiGouJinHuo_data(),ColumnNames.caiGouJinHuo_columns);
				//����Ӧ�������ʵ�����
				Vector<Vector> huoqujine = caiGouJinHuo.getCaiGouJinHuo_data();
				float argJinE = 0;
				for(Vector tmp : huoqujine){
					argJinE = argJinE + Float.parseFloat(tmp.get(7).toString());
				}
				caiGouJinHuo.getYingFuJinE().setText(""+argJinE);
				caiGouJinHuo.getShiFuJinE().setText(""+argJinE);
				AddShangPingDialog.this.dispose();
			}
        	
        });
        //
        JButton canncerBtn = new JButton("ȡ��(F4)");
        canncerBtn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
				AddShangPingDialog.this.dispose();
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
	
	public static void main(String[] args) {
		new AddShangPingDialog((CaiGouJinHuo)null,"������Ʒ");
	}

	public AllTableModel getATM() {
		return ATM;
	}

	public AllTableModel getATM1() {
		return ATM1;
	}


	public JTable getSplbtable1() {
		return splbtable1;
	}

	public Vector<Vector<Object>> getData() {
		return data;
	}


	public Vector<Vector> getYiPi_data() {
		return YiPi_data;
	}


	public CaiGouJinHuo getCaiGouJinHuo() {
		return caiGouJinHuo;
	}

	public JTextField getSpbhfield() {
		return spbhfield;
	}


	public JTable getSpqdtable() {
		return spqdtable;
	}


	public JTree getTree() {
		return tree;
	}


	public Vector getLeftData() {
		return LeftData;
	}


	public void setLeftData(Vector leftData) {
		LeftData = leftData;
	}


	public AllTableModel getSplb_tableModel() {
		return splb_tableModel;
	}

	
	public Vector getSpqdtable_columnName() {
		return spqdtable_columnName;
	}
	
	
	public Vector getSpqdtable_data() {
		return spqdtable_data;
	}
	
	
	public void setSpqdtable_data(Vector spqdtable_data) {
		this.spqdtable_data = spqdtable_data;
	}








	
}
