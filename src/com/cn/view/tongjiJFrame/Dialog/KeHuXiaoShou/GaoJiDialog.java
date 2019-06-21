package com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;
import com.cn.view.tongjiJFrame.Dialog.GBC;

public class GaoJiDialog extends JDialog implements ActionListener {
	KeHuXiaoShouMainFrame frame; //主窗口
    JLabel mingCheng,kaiDanDate;//这几个JLable用来标示单号，开单日期，应付金额和实付金额
    JTextField jt;
    JButton queDing,tuiChu;
    /**
     * 该方法用来显示商品的一些基本信息，包括若干个JLabel和一个JTable
     */
     public GaoJiDialog(KeHuXiaoShouMainFrame frame,String title,boolean modal){
   	  super(frame,title,modal);
   	  this.frame=frame;
   	  init();
     }
     private void init(){
    	 this.setSize(250,220);
    	 this.setLocationRelativeTo(null);
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new GridBagLayout());
    	 jp.add(new JLabel("以下是您所选择的查询条件："),new GBC(0,0,2,1).setInsets(5, 2, 5, 2));
    	 jp.add(new JLabel("查询时间"),new GBC(0,1).setInsets(5, 2, 5, 2));
    	 try {
			kaiDanDate=new JLabel(DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate())+"至"+
					DateConventer.dateToStr(frame.getDatePickerTo3().getSelectedDate()));
			kaiDanDate.setForeground(Color.red);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jp.add(kaiDanDate,new GBC(1,1).setInsets(5, 2, 5, 2));
		jp.add(new JLabel("客户名称"),new GBC(0,2).setInsets(5, 2, 5, 2));
		mingCheng=new JLabel(frame.getKeHuNames1().getText());
		mingCheng.setPreferredSize(new Dimension(100,20));
		mingCheng.setBorder(new LineBorder(Color.red));
		jp.add(mingCheng,new GBC(1,2).setInsets(5, 2, 5, 2));
		jp.add(new JLabel("请在下面输入你要查询的信息"),new GBC(0,3,2,1).setInsets(5, 2, 5, 2));
		jp.add(new JLabel("查询信息"),new GBC(0,4).setInsets(5, 2, 5, 2));
		jt=new JTextField();
		jt.setPreferredSize(new Dimension(100,20));
		jp.add(jt,new GBC(1,4).setInsets(5, 2, 5, 2));
		queDing=new JButton("确定");
		tuiChu=new JButton("退出");
		jp.add(queDing,new GBC(0,5).setInsets(5, 2, 5, 2));
		jp.add(tuiChu,new GBC(1,5).setInsets(5, 2, 5, 2));
		queDing.addActionListener(this);
		tuiChu.addActionListener(this);
		this.add(jp);
		this.setVisible(true);
     }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tuiChu){
			this.dispose();
		}
		else{
			Vector data = new Vector();
	    	Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
		try{	
			String	sql="select sp_id,sp_name,sp_dw,xsd_num,xsd_szje,sp_ggxh,sp_color," +
    		"sp_sccs,xs_bz from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo where xs_id=xsd_dh "+
        " and  sp_id=xsd_id and kh_id=xs_khid and to_date('"+DateConventer.dateToStr(frame.getDatePickerTo2().getSelectedDate())+"','YYYY-MM-DD')-"+
		" tb_sell_main.xs_xsdate<0 and to_date('"+DateConventer.dateToStr(frame.getDatePickerTo3().getSelectedDate())+"','YYYY-MM-DD') - " +
		" tb_sell_main.xs_xsdate>0 and (sp_name like '%"+jt.getText()+"%' or sp_id like '%"+jt.getText()+"%' )" +
				" and kh_name like '%"+mingCheng.getText()+"%'";
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
		    frame.getHuiZongDtm().setDataVector(data, AllTableModel.getVectorFromObj(tongJiModel.huiZongNames1));
		}
		
	} catch (SQLException e1) {
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
		
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} finally{
		JDBCTool.freeResorse(rs, st, conn);
		this.dispose();
	}
  }
 }
}
