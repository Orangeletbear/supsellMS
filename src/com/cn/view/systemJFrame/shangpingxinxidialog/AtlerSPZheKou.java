package com.cn.view.systemJFrame.shangpingxinxidialog;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.model.AllTableModel;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
/**
 * 商品折扣对话框
 * @author finey
 *
 */
public class AtlerSPZheKou extends JDialog {

	//商品折扣
	private JTextField spZK = new JTextField(15);
	public AtlerSPZheKou(ShangPingGuangLiFrame frame,String title,boolean model){
		super(frame,title,model);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setSize(new Dimension(300,200));
        this.add(createPane());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);//窗体居中
        this.setResizable(false);
	}
	private JPanel createPane(){
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(4,1));
		
		JPanel tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,5,10));
		JLabel lab = new JLabel("0.9 为九折，1 为不打折");
		lab.setForeground(Color.red);
		tmpPane.add(lab);
		pan.add(tmpPane);
		
		int row = ((ShangPingGuangLiFrame)(this.getOwner())).getSptable().getSelectedRow(); 
		AllTableModel model = ((ShangPingGuangLiFrame)(this.getOwner())).getTableModel();
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,5,10));
		lab = new JLabel("所选商品:");
		tmpPane.add(lab);
		tmpPane.add(new JLabel(model.getValueAt(row, 1).toString()));
		pan.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,5,10));
		lab = new JLabel("销售折扣:");
		tmpPane.add(lab);
		tmpPane.add(spZK);
		pan.add(tmpPane);
		
		tmpPane = new JPanel();
		tmpPane.setLayout(new FlowLayout(FlowLayout.LEFT,50,10));
		JButton OKBtn = new JButton("保  存");
		OKBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				int row = ((ShangPingGuangLiFrame)(AtlerSPZheKou.this.getOwner())).getSptable().getSelectedRow(); 
				AllTableModel model = ((ShangPingGuangLiFrame)(AtlerSPZheKou.this.getOwner())).getTableModel();
				
			    String spId = model.getValueAt(row, 0).toString();
			    String spzk =spZK.getText();
			    float zk = new Float(spzk).floatValue();
			    if(zk < 0 || zk > 1){
			    	JOptionPane.showMessageDialog(
			    			AtlerSPZheKou.this, "折扣数据不正确,应为(0-1.0)");
			    	return;
			    }
			    
			    boolean isChange = SanPingGuanLiJDBC.atlerSPZheKou(spzk, spId);
			    if(isChange == true){
			       	 JOptionPane.showMessageDialog(null,"修改成功");
			       	dispose();
			        }else{
			       	 JOptionPane.showMessageDialog(null,"注: 修改失败,请注意数据是否正确");
			       	 dispose();
			        }   
			    
			}
			
		});
		JButton exitBtn =new JButton("退  出");
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		tmpPane.add(OKBtn);
		tmpPane.add(exitBtn);
		pan.add(tmpPane);
		
		return pan;
	}
	
}
