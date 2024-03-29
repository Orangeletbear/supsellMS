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

public class TongJiGongHuoShangDialog extends JDialog implements ActionListener {
	CaiGouTongJiCheckDialog dialog;
	JButton chaZhao,queDing,tuiChu;
	JLabel show;
	JTextField showText;
	JTable gongHuoShangTable;
	DefaultTableModel gongHuoDtm;
	String gongHuoNames[]={"编号","供货商名称","联系人","联系电话","联系地址"};
	String gongHuoColumn[][];                   //主界面中的各组件的定义
    public TongJiGongHuoShangDialog(CaiGouTongJiCheckDialog dialog,String title,boolean b){
    	super(dialog,title,b);
    	this.dialog=dialog;
    	init();
    }
    private void init(){
    	this.setSize(400,300);
    	this.setLocationRelativeTo(null);//主界面的设置
    	JPanel jp=new JPanel();
    	jp.setLayout(new BorderLayout());  //布局的设置
    	gongHuoDtm=new AllTableModel(gongHuoColumn,gongHuoNames);
    	gongHuoDtm.isCellEditable(0, 0);
    	gongHuoDtm.setDataVector(getGongHuoShang(), AllTableModel.getVectorFromObj(gongHuoNames));
    	gongHuoShangTable=new JTable(gongHuoDtm);
    	gongHuoShangTable.requestFocus();
    	gongHuoShangTable.setRowSelectionInterval(0, 0);
    	JScrollPane js=new JScrollPane(gongHuoShangTable); //表的创建
    	
    	chaZhao=new JButton("查找");
    	queDing=new JButton("确定");
    	tuiChu=new JButton("退出");
    	show=new JLabel("供货商名或编号 ");
    	showText=new JTextField();
    	showText.setPreferredSize(new Dimension(80,20));
    	showText.setBorder(new LineBorder(Color.lightGray));//按钮和查询信息的定义
    	JPanel lablePane=new JPanel();
    	lablePane.setLayout(new FlowLayout(FlowLayout.LEFT));
    	lablePane.add(show);
    	lablePane.add(showText);
    	lablePane.add(chaZhao);
    	lablePane.add(queDing);
    	lablePane.add(tuiChu);
    	chaZhao.addActionListener(this);
    	queDing.addActionListener(this);
    	tuiChu.addActionListener(this);   //监听器的添加
    	jp.add(lablePane,BorderLayout.SOUTH);
    	jp.add(js);
    	this.add(jp);
    	this.setVisible(true);
    	
    }
    /*
     * 商品表中数据的查询
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
				//获取表中的列数
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
			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}
  	
  	return data;
  }
    /*
     * 查找信息的查询
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
  				//获取表中的列数
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
  			JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
  			
  		} finally{
  			JDBCTool.freeResorse(rs, st, conn);
  		}
    	
    	return data;
    }
    /*
     * 监听器的实现
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
