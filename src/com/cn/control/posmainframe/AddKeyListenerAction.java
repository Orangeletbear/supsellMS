package com.cn.control.posmainframe;
/**
 * POS �����ϵĿ�ݼ�����
 */
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.model.pos.POSTableModel;
import com.cn.view.posmainJFrame.ChangeNumberDialog;
import com.cn.view.posmainJFrame.ChangePrice;
import com.cn.view.posmainJFrame.ChangeZheKouDialog;
import com.cn.view.posmainJFrame.CheckOut;
import com.cn.view.posmainJFrame.POSFrame;
import com.cn.view.posmainJFrame.SelectHuiYuanDialog;

/**
 * @author finey
 *
 */
public class AddKeyListenerAction implements KeyListener {
	private POSFrame frame;
	
	public AddKeyListenerAction(POSFrame frame){
		this.frame = frame;
	}

	public void keyPressed(KeyEvent k) {
	    
		if(k.getKeyCode()==KeyEvent.VK_F5){
			if(frame.getTable().getRowCount() == 0){
				
			}else{
				new CheckOut(frame,"����",true);
			}
            
     	   
        }else if(k.getKeyCode() == KeyEvent.VK_F1){
        	if(frame.getPane().isVisible()){
        		frame.getHelpBtn().setIcon(new ImageIcon("res/smallIcon/blue_up.gif"));
        		frame.getHelpBtn().setText("��ʾ����(F1)");
        		frame.getHelpBtn().setMargin(new Insets(0,0,0,0));
        		frame.getHelpBtn().setFont(new Font("Serif",Font.BOLD,15));
        		frame.getPane().setVisible(false);
        		frame.repaint();
 	       
 	       }else{
 	    	  frame.getHelpBtn().setIcon(new ImageIcon("res/smallIcon/blue_down.gif"));
 	    	  frame.getHelpBtn().setText("���ذ���(F1)");
 	    	  frame.getHelpBtn().setMargin(new Insets(0,0,0,0));
 	    	  frame.getHelpBtn().setFont(new Font("Serif",Font.BOLD,15));
 	    	  frame.getPane().setVisible(true);
 	    	  frame.repaint();
 	       }
        	
        	
        	
        }else if(k.getKeyCode() == KeyEvent.VK_F6){
        	if(frame.getTable().getRowCount() == 0){
        		JOptionPane.showMessageDialog(frame,"�б���û��ѡ����Ʒ�ļ�¼,�����޸ģ�", 
        				"ϵͳ��ʾ", JOptionPane.PLAIN_MESSAGE);
        	}else{
        		new ChangeZheKouDialog(frame,"�޸��ۿ�");
        		
        	}
        }else if(k.getKeyCode() == KeyEvent.VK_F7){
        	if(frame.getTable().getRowCount() == 0){
        	
        	}else {
        		//new ChangePrice(frame,"�޸ĵ���");
        		ChangePrice.getInstance(frame,"�޸ĵ���");
        	}
        }else if(k.getKeyCode() == KeyEvent.VK_F8){
        	if(frame.getTable().getRowCount() == 0){
        		JOptionPane.showMessageDialog(frame,"�б���û��ѡ����Ʒ�ļ�¼,�����޸ģ�", 
        				"ϵͳ��ʾ", JOptionPane.PLAIN_MESSAGE);
        	}else {
        		new ChangeNumberDialog(frame,"�޸�����");
        	}
        }else if(k.getKeyCode() == KeyEvent.VK_DELETE){
        	if(frame.getTable().getRowCount() == 0){
        	
        	}else {
        	    int row = frame.getTable().getSelectedRow();
        	    
        	    frame.getAll().setText(String.valueOf(Float.parseFloat(frame.getAll().getText())
        	    		    - Float.parseFloat(frame.getMode().getValueAt(row, 8).toString())));
        	    frame.getMode().removeRow(row);
        	}
        }else if(k.getKeyCode() == KeyEvent.VK_END){
        	if(frame.getTable().getRowCount() == 0){
        	
        	}else { 
        		int n = JOptionPane.showOptionDialog(frame, "�Ƿ�ɾ��ȫ����¼", "ϵͳ��ʾ", 
        				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        		if(n == JOptionPane.YES_OPTION){
        			frame.getData().removeAllElements();
        			frame.repaint();
        			/*frame.getMode().setDataVector(new Vector(),
        					 AllTableModel.getVectorFromObj(POSTableModel.culomn) );*/
        			 frame.getAll().setText("0.0");
        		}else{
        			
        		}
        	   
        	}
        }else if(k.getKeyCode() == KeyEvent.VK_INSERT){
        	if(frame.getTable().getRowCount() == 0){
        	     
        	}else { 
        	   new SelectHuiYuanDialog(frame,"ѡ���Ա");
        	}
        }else if(k.getKeyCode() == KeyEvent.VK_F9){
        	if(frame.getTable().getRowCount() == 0){
             frame.getChangKuBox().requestFocus();
        	}else { 
        	   JOptionPane.showMessageDialog(frame, 
        			     "����״̬�²��ɸ��Ĳֿ�", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
        	}
        }else if(k.getKeyCode() == KeyEvent.VK_F4){
        	if(frame.getTable().getRowCount() == 0){
        		frame.getDgBox().requestFocus();
        		
        	}else{
        		  JOptionPane.showMessageDialog(frame, 
         			     "����״̬�²��ɸ��ĵ���Ա", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
        	}
        }else if(k.getSource().equals(frame.getDgBox())){
        	if(k.getKeyCode() == KeyEvent.VK_DOWN){
    			frame.getDgBox().setSelectedIndex(frame.getDgBox().getSelectedIndex()+1);
    		}else if(k.getKeyCode() == KeyEvent.VK_UP){
    			frame.getDgBox().setSelectedIndex(frame.getDgBox().getSelectedIndex()-1);
    		}else if(k.getKeyCode() == 10){
    			frame.getSpField().requestFocus();
    		}
        }else if(k.getSource().equals(frame.getChangKuBox())){
        	if(k.getKeyCode() == KeyEvent.VK_DOWN){
        		if(frame.getChangKuBox().getSelectedIndex() == frame.getChangKuBox().getItemCount()){
        			return;
        		}
    			frame.getChangKuBox().setSelectedIndex(frame.getChangKuBox().getSelectedIndex()+1);
    		}else if(k.getKeyCode() == KeyEvent.VK_UP){
    			if(frame.getChangKuBox().getSelectedIndex() == 0){
        			return;
        		}
    			frame.getChangKuBox().setSelectedIndex(frame.getChangKuBox().getSelectedIndex()-1);
    		}else if(k.getKeyCode() == 10){
    			frame.getSpField().requestFocus();
    		}
        }else if(k.getKeyCode() == KeyEvent.VK_DOWN){
        	if(frame.getTable().getSelectedRow() == frame.getTable().getRowCount()-1){
        		return;
        	}
        	if(frame.getTable().getSelectedRow() == -1){
        		return;
        	}
        	frame.getTable().setRowSelectionInterval(
      	    		frame.getTable().getSelectedRow()+1, frame.getTable().getSelectedRow()+1);
        }else if(k.getKeyCode() == KeyEvent.VK_UP){
        	if(frame.getTable().getSelectedRow() == 0){
        		return;
        	}
        	if(frame.getTable().getSelectedRow() == -1){
        		return;
        	}
        	frame.getTable().setRowSelectionInterval(
      	    		frame.getTable().getSelectedRow()-1, frame.getTable().getSelectedRow()-1);
        }
	}

	public void keyReleased(KeyEvent k) {

	}

	public void keyTyped(KeyEvent k) {
	
           
	}

}
