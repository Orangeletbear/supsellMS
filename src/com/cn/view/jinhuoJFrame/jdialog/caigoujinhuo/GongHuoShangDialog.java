package com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cn.dao.jinhuo.GongHuoShangJDBC;
import com.cn.model.AllTableModel;
import com.cn.view.jinhuoJFrame.CaiGouJinHuo;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.systemJFrame.GongHuoShang;
import com.cn.view.systemJFrame.GongHuo.AddSuply;

/**
 * 采购进货中供货商后面那个放大镜按钮所触发的window
 * @author Administrator
 *
 */
public class GongHuoShangDialog extends JDialog {
	/*
	 * 父窗口
	 */
	private CaiGouJinHuo fuChuangKou;
	//center组件
	private AllTableModel ATM;//表model
	private JTable table;
	private Vector data = new Vector();
	private JTextField chazhaogonghuoshang;
	//south
	
	public GongHuoShangDialog(JDialog dialog,String title,boolean model){
		super(dialog,title,model);
		this.fuChuangKou = (CaiGouJinHuo)dialog;
		this.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				data = GongHuoShangJDBC.getGongHuoShang();
				ATM.setDataVector(data,
						ColumnNames.gonghuoshang_columnNames );
			}
		});
		init();
	}
	private void init(){
		this.setSize(600, 280);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		
		this.add(new JScrollPane(center_Pane()),BorderLayout.CENTER);
		this.add(south_Pane(),BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
//center
  private JTable center_Pane(){
	  ATM = new AllTableModel(data,ColumnNames.gonghuoshang_columnNames);
	  table = new JTable(ATM);
	  table.addMouseListener(new MouseAdapter(){

		public void mouseClicked(MouseEvent e) {
			int i = table.getSelectedRow();
			Vector hangData = (Vector)data.get(i);
			String gonghuoshang = (String)hangData.get(1);
			if(e.getClickCount() == 1){//这里就必须关联到确定button，判断是否设置了textField
				fuChuangKou.getGongHuoShang().setText(gonghuoshang);
 			}
			if(e.getClickCount() == 2){
				fuChuangKou.getGongHuoShang().setText(gonghuoshang);
				GongHuoShangDialog.this.dispose();
			}
		}

	  });
	  return table;
  }	
	
//south
  private JPanel south_Pane(){
	  JPanel north = new JPanel();
	  //查找供货商
	  JLabel label1 = new JLabel("查找供货商(f2)：");
	  chazhaogonghuoshang = new JTextField(10);
	  chazhaogonghuoshang.getDocument().addDocumentListener(new DocumentListener(){
		  /*
		   * 通过输入的变化，来查找适合的供货商数据
		   */
		public void changedUpdate(DocumentEvent e) {
		}
		public void insertUpdate(DocumentEvent e) {
			data = GongHuoShangJDBC.getSome(chazhaogonghuoshang.getText());
			ATM.setDataVector(data, ColumnNames.gonghuoshang_columnNames);
		}
		public void removeUpdate(DocumentEvent e) {
			if(chazhaogonghuoshang.getText().equals("")){
				data = GongHuoShangJDBC.getSome(chazhaogonghuoshang.getText());
				ATM.setDataVector(data, 
						ColumnNames.gonghuoshang_columnNames);
			}else{
				data = GongHuoShangJDBC.getSome(chazhaogonghuoshang.getText());
				ATM.setDataVector(data, ColumnNames.gonghuoshang_columnNames);
			}
		}
	  });
	  
	  
	  //新增或修改供货商
	  JButton xiugai = new JButton("新增或修改供货商(f9)");
	  xiugai.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
			new GongHuoShang(GongHuoShangDialog.this,/////////////////
					"新增或修改供货商" );
		  }
	  });
	  
	  //确定
	  JButton queding = new JButton("确定(f5)");
	  queding.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			if(!fuChuangKou.getGongHuoShang().getText().equals("")){
				GongHuoShangDialog.this.dispose();
			}
		}
		  
	  });
	 
	  
	  //退出
	  JButton tuichu = new JButton("退出(f4)");
	  tuichu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GongHuoShangDialog.this.dispose();
			}
		});
	  
	  
	  north.setLayout(new FlowLayout(FlowLayout.LEFT));//布局靠左
	  north.setBorder(new LineBorder(Color.BLACK,1) );//边框
	  north.add(label1);
	  north.add(chazhaogonghuoshang);
	  north.add(xiugai);
	  north.add(queding);
	  north.add(tuichu);
	  return north;
  }	
	
  
  public static void main(String[] args){
	  new GongHuoShangDialog((JDialog)null,"供货商",true);
  }
	

}
