package com.cn.view.login;

import javax.swing.JOptionPane;

import com.cn.dao.loginandmainframe.JDBCLoginInformation;
import com.cn.dao.loginandmainframe.LoginDialogVO;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.posmainJFrame.POSFrame;

/**
 * 登陆验证部份
 * @author Administrator
 *
 */
public class LoginConfirmation {
	
       public static void loginConfirm(LoginDialog dialog){
    	   
    	   //用户名为空则提示
    		if(dialog.getTextfieldName().
    				getSelectedItem().toString().length()==0 
    				
    				|| dialog.getPassword().getPassword().length==0){
    			JOptionPane.showMessageDialog(dialog,"用户名/密码 不能为空,请输入重新");
    		}else{
    			//界面输入的用户名传入JDBC层
    			LoginDialogVO objVO = JDBCLoginInformation.compareUser(
    					dialog.getTextfieldName().getSelectedItem().toString());
    					
    			if(objVO.userName==null){
    				JOptionPane.showMessageDialog(dialog,"该用户名不存在!");
    			}else{
    				//密码正确否
    				if(objVO.password.equals(new String(dialog.getPassword().getPassword()))){
    					if(dialog.isHowDo()==true){
    						Log.traceLog( "  用户  ",objVO.userName," 登陆了管理系统");
    						new MainFrame("超市销售管理系统  试用版",objVO.userName);
    						
    						dialog.dispose();
    					}else{
    						MainFrame frame = dialog.getFrame();
    						if(objVO.userName.equals(frame.getUser())){
    							JOptionPane.showMessageDialog(dialog,"该用户名正在处于登录状态!");
    							return;
    						}
    						frame.dispose();
    						Log.traceLog( "  用户  ",objVO.userName," 登陆了管理系统");
    						new MainFrame("超市销售管理系统  试用版",objVO.userName);
    						dialog.dispose();
    					}
    				}else{
    					JOptionPane.showMessageDialog(dialog,"密码错误,请重新输入!");
    					dialog.getPassword().selectAll();
    					
    				}
    			}
    		}
    	   
       }
       /**
        * 客户端
        * @param dialog
        */
       public static void posLoginConfirm(LoginPosFrame dialog){
    	   
    	 //用户名为空则提示
    		if(dialog.getUserdName().getSelectedItem().toString().length()==0 
    				|| dialog.getPassword().getPassword().length==0){
    			JOptionPane.showMessageDialog(dialog,"用户名/密码 不能为空,请输入重新");
    		}else{
    			//界面输入的用户名密码传入JDBC层
    			boolean isRight = JDBCLoginInformation.compareUser(
    			dialog.getUserdName().getSelectedItem().toString(),
    			dialog.getPassword().getPassword());		
    			
    			if(isRight == true){
    				new POSFrame("超市POS端销售管理系统 试用版",dialog.getUserdName().getSelectedItem().toString());
    				dialog.dispose();
    				
    			}else{
    				JOptionPane.showMessageDialog(dialog,"密码错误,请重新输入!");
    				dialog.getPassword().selectAll();
    			}
    			
    			
    			
    		}
       }
}
