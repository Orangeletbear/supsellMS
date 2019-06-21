package com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.cn.model.AllTableModel;
import com.cn.util.JDBCTool;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;
import com.cn.view.tongjiJFrame.Dialog.YeWuYuanXiaoShou.YeWuCheckDialog;

public class KeHuXinXiDialog extends JDialog implements ActionListener {
	KeHuXiaoShouMainFrame dialog;
	JButton chaZhao,queDing,tuiChu;
	JLabel show;
	JTextField showText;
	JTable keHuTable;
	DefaultTableModel keHuDtm;
	String keHuNames[]={"���","�ͻ�����"};
	String keHuColumn[][];                   //�������еĸ�����Ķ���
    public KeHuXinXiDialog(KeHuXiaoShouMainFrame dialog,String title,boolean b){
    	super(dialog,title,b);
    	this.dialog=dialog;
    	init();
    }
    private void init(){
    	this.setSize(200,200);
    	this.setLocationRelativeTo(null);//�����������
    	JPanel jp=new JPanel();
    	jp.setLayout(new BorderLayout());  //���ֵ�����
    	keHuDtm=new AllTableModel(keHuColumn,keHuNames);
    	keHuDtm.isCellEditable(0, 0);
    	keHuDtm.setDataVector(getKeHuShang(), AllTableModel.getVectorFromObj(keHuNames));
    	keHuTable=new JTable(keHuDtm);
    	keHuTable.requestFocus();
    	keHuTable.setRowSelectionInterval(0, 0);
    	JScrollPane js=new JScrollPane(keHuTable); //��Ĵ���
    	
    	queDing=new JButton("ȷ��");
    	tuiChu=new JButton("�˳�");
    	JPanel lablePane=new JPanel();
    	lablePane.setLayout(new FlowLayout(FlowLayout.LEFT));
    	lablePane.add(queDing);
    	lablePane.add(new JLabel(" "));
    	lablePane.add(tuiChu);
    	queDing.addActionListener(this);
    	tuiChu.addActionListener(this);   //�����������
    	jp.add(lablePane,BorderLayout.SOUTH);
    	jp.add(js);
    	this.add(jp);
    	this.setVisible(true);
    	
    }
    /*
     * ��Ʒ�������ݵĲ�ѯ
     */
    public Vector getKeHuShang(){
      String sql="select kh_id,kh_name from tb_khinfo";
      Vector data = new Vector();
  	  Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		try {
			  st = conn.createStatement();
				rs = st.executeQuery(sql);
				//��ȡ���е�����
				int columnCount = rs.getMetaData().getColumnCount();
				while(rs.next()){
					Vector tmp = new Vector();
					for(int column = 1;column<=columnCount;column++){
						tmp.add(rs.getObject(column));
					}
			    data.add(tmp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
  	
  	return data;
  }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tuiChu){
			this.dispose();
		}
		else{
			dialog.getKeHuNames().setText(keHuDtm.getValueAt(keHuTable.getSelectedRow(), 1).toString());
			this.dispose();
		}
	}
   
}

