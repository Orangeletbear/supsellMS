package com.cn.view.systemJFrame.XiTongWeiHu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.cn.dao.system.miMaJDBC;
import com.cn.util.JDBCTool;

/**
 * ȷ��
 * @author Administrator
 *
 */
public class SecretOK {
     public static void secretOK(MiMaDialog frame){
    	 String miMa=miMaJDBC.getData(frame.getCzy().getText());
  	   String xinMiMa=new String(frame.getXinMa().getPassword());
  	   if(!miMa.equals(new String(frame.getChuShi().getPassword()))){
  		   JOptionPane joptionP= new JOptionPane();
     		//chaZhaoB.add(joptionP);
     		JOptionPane.showMessageDialog(frame, "��ʼ������󣡣�");
     		joptionP.setVisible(true);
  	   }
  	   if(!(new String(frame.getXinMa().getPassword())).equals(
  			   new String(frame.getYanZheng().getPassword()))){
  		   
  		   JOptionPane joptionP= new JOptionPane();
        		//chaZhaoB.add(joptionP);
        		JOptionPane.showMessageDialog(frame, "����������֤���벻һ�£���");
        		joptionP.setVisible(true);
  	   }
  	   if(miMa.equals(new String(frame.getChuShi().getPassword()))&&
  			   (new String(frame.getXinMa().getPassword())).equals(
  					   new String(frame.getYanZheng().getPassword()))){
  		   
  		   String sql = "update tb_usernofo set user_psw='"+xinMiMa+
  		   "' where user_name='"+frame.getCzy().getText()+"'";
  		 	Connection conn = JDBCTool.getConnection();
			    Statement st = null;
			    conn=JDBCTool.getConnection();
			    try {
					st=conn.createStatement();
					st.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					JDBCTool.freeResouse(st, conn);
				}
  		   JOptionPane joptionP= new JOptionPane();
       		//chaZhaoB.add(joptionP);
       		JOptionPane.showMessageDialog(frame, "�����޸ĳɹ�����");
       		joptionP.setVisible(true);
       		frame.dispose();
  	   }
  		   
     }
     
}
