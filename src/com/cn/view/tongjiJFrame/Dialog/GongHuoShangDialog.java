package com.cn.view.tongjiJFrame.Dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.model.AllTableModel;
import com.cn.util.JDBCTool;

public class GongHuoShangDialog extends JDialog implements ActionListener {
	ShangPinCaiGouCheckDialog dialog;
	JButton chaZhao,queDing,tuiChu;
	JLabel show;
	JTextField showText;
	JTable gongHuoShangTable;
	DefaultTableModel gongHuoDtm;
	String gongHuoNames[]={"���","����������","��ϵ��","��ϵ�绰","��ϵ��ַ"};
	String gongHuoColumn[][];                   //�������еĸ�����Ķ���
    public GongHuoShangDialog(ShangPinCaiGouCheckDialog dialog,String title,boolean b){
    	super(dialog,title,b);
    	this.dialog=dialog;
    	init();
    }
    private void init(){
    	this.setSize(400,300);
    	this.setLocationRelativeTo(null);//�����������
    	JPanel jp=new JPanel();
    	jp.setLayout(new BorderLayout());  //���ֵ�����
    	gongHuoDtm=new AllTableModel(gongHuoColumn,gongHuoNames);
    	gongHuoDtm.isCellEditable(0, 0);
    	gongHuoDtm.setDataVector(getGongHuoShang(), AllTableModel.getVectorFromObj(gongHuoNames));
    	gongHuoShangTable=new JTable(gongHuoDtm);
    	gongHuoShangTable.requestFocus();
    	gongHuoShangTable.setRowSelectionInterval(0, 0);
    	JScrollPane js=new JScrollPane(gongHuoShangTable); //��Ĵ���
    	
    	chaZhao=new JButton("����");
    	queDing=new JButton("ȷ��");
    	tuiChu=new JButton("�˳�");
    	show=new JLabel("������������ ");
    	showText=new JTextField();
    	showText.setPreferredSize(new Dimension(80,20));
    	showText.setBorder(new LineBorder(Color.lightGray));//��ť�Ͳ�ѯ��Ϣ�Ķ���
    	JPanel lablePane=new JPanel();
    	lablePane.setLayout(new FlowLayout(FlowLayout.LEFT));
    	lablePane.add(show);
    	lablePane.add(showText);
    	lablePane.add(chaZhao);
    	lablePane.add(queDing);
    	lablePane.add(tuiChu);
    	chaZhao.addActionListener(this);
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
    public Vector getGongHuoShang(){
      String sql="select ghs_id,ghs_name,ghs_lxr,ghs_tell,ghs_address from tb_ghsinfo";
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
    /*
     * ������Ϣ�Ĳ�ѯ
     */
    public Vector getChaZhaoXinxi(){
    	String name=showText.getText();
        String sql="select ghs_id,ghs_name,ghs_lxr,ghs_tell,ghs_address from tb_ghsinfo where " +
        		" (ghs_id like '%"+name+"%' or ghs_name like '%"+name+"%')";
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
    /*
     * ��������ʵ��
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
	public void actionPerformed(ActionEvent e) {
             if(e.getSource()==tuiChu){
            	 this.dispose();
             }		
             if(e.getSource()==queDing){
            	//System.out.println(gongHuoDtm.getValueAt(gongHuoShangTable.getSelectedRow(), 0).toString()+"xzj");
            	 dialog.getShowT().setText(gongHuoDtm.getValueAt(gongHuoShangTable.getSelectedRow(), 1).toString());
            	 this.dispose();
             }
             if(e.getSource()==chaZhao){
            		gongHuoDtm.setDataVector(getChaZhaoXinxi(), AllTableModel.getVectorFromObj(gongHuoNames));
            		gongHuoShangTable.requestFocus();
            		gongHuoShangTable.setRowSelectionInterval(0, 0);
             }
	}
}
