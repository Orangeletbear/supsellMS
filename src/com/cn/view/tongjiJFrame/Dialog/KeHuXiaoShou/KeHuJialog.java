package com.cn.view.tongjiJFrame.Dialog.KeHuXiaoShou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.dao.pos.POSJDBC;
import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
import com.cn.util.JDatePicker;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;
import com.cn.view.tongjiJFrame.Dialog.GBC;

public class KeHuJialog extends JDialog implements ActionListener{
	JButton queDing,tuiChu;
	KeHuXiaoShouMainFrame frame;
	JDatePicker datePickerTo;
	JComboBox jingBanRen;
	JLabel danHao;
	JLabel keHu;
	JTextField jinE,shuoMing;
	JLabel keHuName;
     public KeHuJialog(KeHuXiaoShouMainFrame frame,String title,boolean b){
    	 super(frame,title,b);
    	 this.frame=frame;
    	 init();
     }
     private void init(){
    	 this.setSize(400,310);
    	 this.setLocationRelativeTo(this);
    	 JPanel jp=new JPanel();
    	 jp.setLayout(new BorderLayout());
    	 JPanel keHuP=new JPanel();
    	 keHuP.setLayout(new FlowLayout(FlowLayout.CENTER));
    	 keHu= new JLabel("客户名称: ");
    	 keHu.setFont(new Font("宋体",Font.BOLD,20));//设置字体大小及颜色
    	 keHu.setForeground(Color.red);
    	 keHuName= new JLabel(frame.getZhangWuDtm().getValueAt(frame.getZhangWuBiao().getSelectedRow(), 0).toString());
    	 keHuName.setFont(new Font("宋体",Font.BOLD,20));//设置字体大小及颜色
    	 keHuName.setForeground(Color.red);
    	 keHuP.add(keHu);
    	 keHuP.add(keHuName);
    	 JPanel centreP=new JPanel();
    	 centreP.setLayout(new GridBagLayout());
    	 centreP.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
    	 centreP.add(new JLabel("欠款金额"),new GBC(0,0));
    	 centreP.add(new JLabel(frame.getZhangWuDtm().getValueAt(frame.getZhangWuBiao().getSelectedRow(), 6).toString()),new GBC(1,0).setInsets(20, 5, 20, 5));
    	 centreP.add(new JLabel("单号 "),new GBC(2,0));
    	 Date date = new Date();
  	    SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
  	    String time = formatter.format(date);
  	    danHao=new JLabel("fk"+time);
    	 centreP.add(danHao,new GBC(3,0).setInsets(20, 5, 20, 5));
    	 centreP.add(new JLabel("收款金额"),new GBC(0,1));
    	 jinE=new JTextField("0.00");
    	 jinE.setPreferredSize(new Dimension(100,20));
    	 centreP.add(jinE,new GBC(1,1).setInsets(20, 5, 20, 5));
    	 centreP.add(new JLabel("收款日期："),new GBC(2,1));
    	 datePickerTo= new JDatePicker(JDatePicker.STYLE_CN_DATE);
    	 centreP.add(datePickerTo,new GBC(3,1).setInsets(20, 5, 20, 5));
    	 centreP.add(new JLabel("收款方式"),new GBC(0,2));
    	 centreP.add(new JLabel(frame.getZhangWuDtm().getValueAt(frame.getZhangWuBiao().getSelectedRow(), 3).toString()),new GBC(1,2).setInsets(20, 5, 20, 5));
    	 centreP.add(new JLabel("经办人"),new GBC(2,2));
    	 jingBanRen=new JComboBox(POSJDBC.getAllWorker());
    	 centreP.add(jingBanRen,new GBC(3,2).setInsets(20, 5, 20, 5));
    	 centreP.add(new JLabel("附加说明："),new GBC(0,3));
    	 shuoMing=new JTextField();
    	 shuoMing.setPreferredSize(new Dimension(300,20));
    	 shuoMing.setBorder(new LineBorder(Color.LIGHT_GRAY));
    	 centreP.add(shuoMing,new GBC(1,3,3,1));
    	 queDing=new JButton("确定");
    	 centreP.add(queDing,new GBC(1,4).setInsets(5, 0, 0, 0));
    	 tuiChu=new JButton("退出");
    	 centreP.add(tuiChu,new GBC(3,4).setInsets(5, 0, 0, 0));
    	 jp.add(keHuP,BorderLayout.NORTH);
    	 jp.add(centreP);
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
			if(jinE.getText().equals("0.00")){
				 JOptionPane joptionP= new JOptionPane();
	          		JOptionPane.showMessageDialog(this, "金额不能为零 ");
	          		joptionP.setVisible(true); 
			}
			else{
			 int choice =  JOptionPane.showConfirmDialog(this,
						" 单据保存后不可修改，是否确定保存？","退出警告",
		        		 JOptionPane.YES_NO_OPTION, 3);
			     if(choice == JOptionPane.YES_OPTION){
			    	String sql="insert into tb_fkd values(?,?,?,?)";
			    	Connection conn = JDBCTool.getConnection();
			    	PreparedStatement ps = null;
				    conn=JDBCTool.getConnection();
				    try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, danHao.getText());
						ps.setTimestamp(2, DateConventer.strToTimestamp(
								DateConventer.dateToStr(datePickerTo.getSelectedDate()), "yyyy-MM-dd "));
						ps.setString(3, "现金");
						ps.setString(4, jinE.getText());
						ps.executeUpdate();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{
						JDBCTool.freeResouse(ps, conn);
						this.dispose();
					}
			     }
			}
		}
	}
}
