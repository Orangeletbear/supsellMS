package com.cn.view.login;

import javax.swing.JOptionPane;

import com.cn.dao.loginandmainframe.JDBCLoginInformation;
import com.cn.dao.loginandmainframe.LoginDialogVO;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.posmainJFrame.POSFrame;

/**
 * ��½��֤����
 * @author Administrator
 *
 */
public class LoginConfirmation {
	
       public static void loginConfirm(LoginDialog dialog){
    	   
    	   //�û���Ϊ������ʾ
    		if(dialog.getTextfieldName().
    				getSelectedItem().toString().length()==0 
    				
    				|| dialog.getPassword().getPassword().length==0){
    			JOptionPane.showMessageDialog(dialog,"�û���/���� ����Ϊ��,����������");
    		}else{
    			//����������û�������JDBC��
    			LoginDialogVO objVO = JDBCLoginInformation.compareUser(
    					dialog.getTextfieldName().getSelectedItem().toString());
    					
    			if(objVO.userName==null){
    				JOptionPane.showMessageDialog(dialog,"���û���������!");
    			}else{
    				//������ȷ��
    				if(objVO.password.equals(new String(dialog.getPassword().getPassword()))){
    					if(dialog.isHowDo()==true){
    						Log.traceLog( "  �û�  ",objVO.userName," ��½�˹���ϵͳ");
    						new MainFrame("�������۹���ϵͳ  ���ð�",objVO.userName);
    						
    						dialog.dispose();
    					}else{
    						MainFrame frame = dialog.getFrame();
    						if(objVO.userName.equals(frame.getUser())){
    							JOptionPane.showMessageDialog(dialog,"���û������ڴ��ڵ�¼״̬!");
    							return;
    						}
    						frame.dispose();
    						Log.traceLog( "  �û�  ",objVO.userName," ��½�˹���ϵͳ");
    						new MainFrame("�������۹���ϵͳ  ���ð�",objVO.userName);
    						dialog.dispose();
    					}
    				}else{
    					JOptionPane.showMessageDialog(dialog,"�������,����������!");
    					dialog.getPassword().selectAll();
    					
    				}
    			}
    		}
    	   
       }
       /**
        * �ͻ���
        * @param dialog
        */
       public static void posLoginConfirm(LoginPosFrame dialog){
    	   
    	 //�û���Ϊ������ʾ
    		if(dialog.getUserdName().getSelectedItem().toString().length()==0 
    				|| dialog.getPassword().getPassword().length==0){
    			JOptionPane.showMessageDialog(dialog,"�û���/���� ����Ϊ��,����������");
    		}else{
    			//����������û������봫��JDBC��
    			boolean isRight = JDBCLoginInformation.compareUser(
    			dialog.getUserdName().getSelectedItem().toString(),
    			dialog.getPassword().getPassword());		
    			
    			if(isRight == true){
    				new POSFrame("����POS�����۹���ϵͳ ���ð�",dialog.getUserdName().getSelectedItem().toString());
    				dialog.dispose();
    				
    			}else{
    				JOptionPane.showMessageDialog(dialog,"�������,����������!");
    				dialog.getPassword().selectAll();
    			}
    			
    			
    			
    		}
       }
}
