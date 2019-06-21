package com.cn.view.kuchunJFrame.kucunpandian;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cn.control.kuchunframe.kucunpandian.KunCunPanDianChaXunAction;
import com.cn.dao.MFrameJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.kuchun.KCPDModel;
import com.cn.util.JDatePicker;
import com.cn.view.kuchunJFrame.KucunPandian;

public class KCPD_GaoJiChaXunDialog extends JDialog {
	private KucunPandian dialog;
	
	private JDatePicker dateFrom;
	private JDatePicker dateTo;
	private JComboBox comboCK;
	private JComboBox comboCZY;
	private JButton btnYes;
	private JButton btnNo;

	public KCPD_GaoJiChaXunDialog (KucunPandian dialog,String title,boolean b){
		super(dialog,title,b);
		this.dialog = dialog;
		init();
	}
	
	//////////////////////////////
	
	public KucunPandian getDialog() {
		return dialog;
	}

	public JDatePicker getDateFrom() {
		return dateFrom;
	}

	public JDatePicker getDateTo() {
		return dateTo;
	}

	public JComboBox getComboCK() {
		return comboCK;
	}

	public JComboBox getComboCZY() {
		return comboCZY;
	}

	public JButton getBtnYes() {
		return btnYes;
	}

	public JButton getBtnNo() {
		return btnNo;
	}

	private void init(){
		this.setSize(240,260);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(add());
	}
	
	private JPanel add(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(5,1));
		
		JPanel jpanel1 = new JPanel();
		JLabel label1 = new JLabel("查询日期：");
		label1.setPreferredSize(new Dimension(100,20));
		dateFrom = new JDatePicker();
		dateFrom.setPreferredSize(new Dimension(100,20));
		dateFrom.setEditable(false);
		jpanel1.add(label1);
		jpanel1.add(dateFrom);
		
		JPanel jpanel2 = new JPanel();
		JLabel label2 = new JLabel("至：");
		label2.setPreferredSize(new Dimension(100,20));
		dateTo = new JDatePicker();
		dateTo.setPreferredSize(new Dimension(100,20));
		dateTo.setEditable(false);
		jpanel2.add(label2);
		jpanel2.add(dateTo);
		
		JPanel jpanel3 = new JPanel();
		JLabel label3 = new JLabel("查询仓库：");
		label3.setPreferredSize(new Dimension(100,20));
		comboCK = new JComboBox(JDBCCuCunFind.getCanKuData());
		comboCK.setPreferredSize(new Dimension(100,20));
		jpanel3.add(label3);
		jpanel3.add(comboCK);
		
		JPanel jpanel4 = new JPanel();
		JLabel label4 = new JLabel("操作员：");
		label4.setPreferredSize(new Dimension(100,20));
		comboCZY = new JComboBox(MFrameJDBC.getUser());
		comboCZY.setPreferredSize(new Dimension(100,20));
		jpanel4.add(label4);
		jpanel4.add(comboCZY);
		
		JPanel jpanel5 = new JPanel();
		btnYes = new JButton("确定");
		btnNo = new JButton("取消");
		jpanel5.add(btnYes);
		jpanel5.add(btnNo);
		{
			btnYes.addActionListener(new KunCunPanDianChaXunAction(this));
			btnNo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					KCPD_GaoJiChaXunDialog.this.dispose();
				}
			});
		}
		
		{
			jpanel.add(jpanel1);
			jpanel.add(jpanel2);
			jpanel.add(jpanel3);
			jpanel.add(jpanel4);
			jpanel.add(jpanel5);
		}
		return jpanel;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new KCPD_GaoJiChaXunDialog(null,"盘点高级查询",true).setVisible(true);
	}
}
