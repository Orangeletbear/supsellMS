package com.cn.control.posmainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import com.cn.dao.pos.POSJDBC;
import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.view.posmainJFrame.POSFrame;
/**
 * 当有多种商品满足要求时，选择指定的一种
 * @author Administrator
 *
 */
public class MultiSPChiceAction extends MouseAdapter implements KeyListener {
	
	private POSFrame frame;
	
	public MultiSPChiceAction(POSFrame frame) {
		
	    this.frame = frame;
	}

	

	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount() ==2){
			GetSPToTable();
		}
	
	}
    /**
     * 一个公共块
     * 将从选择区确定的商品放到确定区
     */
	private void GetSPToTable(){
		
		int row = frame.getMultTable().getSelectedRow();

  	    String ID = frame.getMultMode().getValueAt(row, 0).toString();
  	  
  	    Vector data = HuiYuanXinGLJDBC.getHuiYuanXiaoFeiMingxi(ID);
  	  
  	    frame.getData().add(POSJDBC.getCirterSPMassege(frame.getChangKuBox().
				 getSelectedItem().toString(),frame.getNum(),ID));
  	    
  	    String currentMoney =   ((Vector) frame.getData().
  	    		get(frame.getData().size()-1)).get(8).toString();
  	    
  	    float tmpM = new Float(currentMoney).floatValue();
  	    float tmpM1 = new Float(frame.getAll().getText());
  	    
  	    tmpM = tmpM1+ tmpM;
  	    frame.getAll().setText(""+tmpM);
  	    
  	    frame.setNum(frame.getNum()+1);
  	    frame.getSpData().removeAllElements();
  	    frame.getMultPane().setVisible(false);
  	    
  	  
  	    frame.getTable().setRowSelectionInterval(
  	    		frame.getData().size()-1, frame.getData().size()-1);
  	    frame.getSpField().setText("");
  	    frame.repaint();
	}

	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() ==10){
			GetSPToTable();
		}
		if(arg0.getKeyCode() ==27){
			frame.getSpData().removeAllElements();
	  	    frame.getMultPane().setVisible(false);
		}
		
	}

	public void keyReleased(KeyEvent arg0) {
		//GetSPToTable();
	}

	public void keyTyped(KeyEvent arg0) {
		//GetSPToTable();
	}

}
