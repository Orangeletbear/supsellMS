package com.cn.view.systemJFrame.XiTongWeiHu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.cn.control.systemframe.NianZhongJieSuan_SureAction;
import com.cn.model.AllTableModel;
import com.cn.model.system.NianJieTabelColumns;
import com.cn.view.systemJFrame.SystemWeiHuFrame;
import com.cn.dao.system.JDBCDeleteAllData;
public class NianZhongJieSuanDialog extends JDialog {

	private SystemWeiHuFrame dialog;
	//结算年份
	private JSpinner jsp;
	//结算起始时间
	private JLabel qiShiShiJian = new JLabel();
	//结算结束时间
	private JLabel jieShuShiJian = new JLabel();
	
	//确定按钮
	private JButton sureButton = new JButton("确定");
	//导出按钮
	private JButton exportButton = new JButton("导出");
	//图表显示
	private JButton chartPrint = new JButton("图表");
	//退出按钮
	private JButton exitButton = new JButton("退出");
	
	//结算表
	JTable table ;
	//存放表格中的数据
	private Vector mainData = new Vector();
	

	AllTableModel tableModel;
	
	public NianZhongJieSuanDialog(SystemWeiHuFrame dialog,String title){
		super(dialog,title,true);
		this.dialog = dialog;
		init();
	}
	
	public void init(){
		this.add(createPane());
		this.setSize(820,500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//打开界面时就显示已经存在的年终结算信息
		this.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				Vector data = JDBCDeleteAllData.getData();
				tableModel.setDataVector(data, AllTableModel.getVectorFromObj(
						NianJieTabelColumns.coulumns));
			}
		});
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public JPanel createPane(){
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		//---------------------------------
		JPanel northPane = new JPanel();
		northPane.setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		center.add(new JLabel(new ImageIcon("res/AcionIcon/4.jpg")));
		
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.LEFT,20,1));
		south.add(new JLabel("结算年份:"));
		jsp=new JSpinner(new SpinnerNumberModel(2010,0,2999,1));
		
		 Calendar   cal   =   Calendar.getInstance(); 
    	 final String today = new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime()); 
    	 final int year = cal.get(Calendar.YEAR); 
    	
		jsp.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent e) {
				
				qiShiShiJian.setText(jsp.getValue().toString()+"-01-01");
				if(Integer.parseInt(jsp.getValue().toString())< year){
					jieShuShiJian.setText(jsp.getValue().toString()+"-12-31");
				}else if(Integer.parseInt(jsp.getValue().toString())== year){
					jieShuShiJian.setText(today);
			   }else{
				   jsp.setValue(year);
			   }
			}	
	 });
		south.add(jsp);
		south.add(new JLabel("结算时间:"));
		qiShiShiJian.setText(jsp.getValue().toString()+"-01-01");
		south.add(qiShiShiJian);
		jieShuShiJian.setText(today);
		south.add(new JLabel("至:"));
		south.add(jieShuShiJian);
		south.add(sureButton);
		sureButton.addActionListener(new NianZhongJieSuan_SureAction(this));
		south.add(exportButton);
		south.add(chartPrint);
	
		south.add(exitButton);
		//显示图表监听器
		chartPrint.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				int [] data = new int[12];
				
		        float [] moneyData = new float[4];
		        
		        //取出该年信息
				Vector dbData = getTableSelectedData();
				
				if(dbData.size() == 0){
					JOptionPane.showMessageDialog(null,"请选一条数据");
					return;
				}
				
				moneyData[0] = new Float(dbData.get(5).toString()).floatValue();
				moneyData[1] = new Float(dbData.get(9).toString()).floatValue();
				moneyData[2] = new Float(dbData.get(14).toString()).floatValue();
				moneyData[3] = new Float(dbData.get(17).toString()).floatValue();

				data[0] = new Integer(dbData.get(2).toString()).intValue();
				data[1] = new Integer(dbData.get(3).toString()).intValue();
				data[2] = new Integer(dbData.get(4).toString()).intValue();
				data[3] = new Integer(dbData.get(6).toString()).intValue();
				data[4] = new Integer(dbData.get(7).toString()).intValue();
				data[5] = new Integer(dbData.get(8).toString()).intValue();
				data[6] = new Integer(dbData.get(10).toString()).intValue();
				data[7] = new Integer(dbData.get(11).toString()).intValue();
				data[8] = new Integer(dbData.get(12).toString()).intValue();
				data[9] = new Integer(dbData.get(13).toString()).intValue();
				data[10] = new Integer(dbData.get(15).toString()).intValue();
				data[11] = new Integer(dbData.get(16).toString()).intValue();
				
				new YearCountChart(
						NianZhongJieSuanDialog.this,dbData.get(0).toString()+" 年终结算图表",
						data,moneyData);
			}
			
		});
		
		exitButton.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
	    northPane.add(center,BorderLayout.CENTER);
	    northPane.add(south,BorderLayout.SOUTH);
		
		//---------------------------------
		JPanel centerPane = new JPanel();
		
		tableModel = new AllTableModel(mainData,
				AllTableModel.getVectorFromObj(NianJieTabelColumns.coulumns));
		table = new JTable(tableModel);
		for(int i = 0 ; i < 18;i++){
			 table.getColumnModel().getColumn(i).setPreferredWidth(200);
		}
		 
		table.setAutoCreateRowSorter(true);
		table.setPreferredScrollableViewportSize(new Dimension(1500,400));
	    table.setOpaque(true);
		JScrollPane  scroll = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		
		centerPane.add(scroll);
		
		mainPanel.add(northPane,BorderLayout.NORTH);
		mainPanel.add(new JScrollPane(centerPane),BorderLayout.CENTER);
		
		return mainPanel;
	}
	/**
	 * 取出选定表的一行数据
	 * @return
	 */
	 private Vector getTableSelectedData(){
		 Vector data = new Vector();
		 int row = table.getSelectedRow();
		 if(row ==-1){
			 return data;
		 }
		 for(int i = 0;i<tableModel.getColumnCount();i++){
			 data.add(tableModel.getValueAt(row, i));
		 }

		 return data;
	 }
    
	public JSpinner getJsp() {
		return jsp;
	}

	public JLabel getQiShiShiJian() {
		return qiShiShiJian;
	}

	public JLabel getJieShuShiJian() {
		return jieShuShiJian;
	}

	public JTable getTable() {
		return table;
	}
	public Vector getMainData() {
		return mainData;
	}

	public AllTableModel getTableModel() {
		return tableModel;
	}

	public static void main(String[] args) {
		new NianZhongJieSuanDialog(null,"");

	}

	public SystemWeiHuFrame getDialog() {
		return dialog;
	}

}
