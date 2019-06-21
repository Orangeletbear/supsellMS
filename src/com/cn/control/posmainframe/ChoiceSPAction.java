package com.cn.control.posmainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.pos.POSJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.pos.POSTableModel;
import com.cn.view.posmainJFrame.POSFrame;
/**
 * 输入商品的文本区监听器
 * @author Administrator
 *
 */
public class ChoiceSPAction implements ActionListener {
    
	POSFrame frame;
	
	public ChoiceSPAction(POSFrame frame) {
		this.frame = frame;
		
	}

	public void actionPerformed(ActionEvent e) {
		
		 String spID = frame.getSpField().getText();
		 Vector data = POSJDBC.getSPMassage(frame.getChangKuBox().
				 getSelectedItem().toString(),spID);
		 if(data.size() ==0){
			 JOptionPane.showMessageDialog(null, "该仓库中不存在该商品,请选其它仓库");
			 frame.getSpField().setText("");
			 return;
		 }
		 if(data.size()==1){
			 frame.getMultPane().setVisible(true);
			 frame.getSpData().add(data.get(0));
			 
			 String ID = ((Vector)(frame.getSpData().get(0))).get(0).toString();
			 frame.getData().add(POSJDBC.getCirterSPMassege(frame.getChangKuBox().
					 getSelectedItem().toString(),frame.getNum(),ID));
			 /*frame.getTable().requestFocus();
			 frame.getTable().setRowSelectionInterval(frame.getSpData().size()-1, 0);*/
			 String currentMoney =   ((Vector) frame.getData().
		  	    		get(frame.getData().size()-1)).get(8).toString();
			 
			 float tmpM = new Float(currentMoney).floatValue();
		  	    float tmpM1 = new Float(frame.getAll().getText());
		  	    
		  	    tmpM = tmpM1+ tmpM;
		  	    frame.getAll().setText(""+tmpM);
		  	    
			 frame.setNum(frame.getNum()+1);
			 frame.validate();
			 frame.getSpData().removeAllElements();
			 frame.getMultPane().setVisible(false);
			 
			 frame.getTable().setRowSelectionInterval(
					 frame.getData().size()-1, frame.getData().size()-1);
			 frame.getSpField().setText("");
			 
			 frame.repaint();
		 }else{
			 /*for(int i = 0;i<data.size();i++){
				 System.out.print(i+"  ");
				 frame.getSpData().add(data.get(i));
			 }*/
			 frame.getMultMode().setDataVector(data, 
					AllTableModel.getVectorFromObj(POSTableModel.MultiSPCulomns));
			 
			 frame.getMultTable().requestFocus();
			 frame.getMultTable().setRowSelectionInterval(0, 0);
			 //frame.getSpField().requestFocus(false);
			 frame.getMultPane().setVisible(true);
			 //frame.getSpField().setText("");
			 frame.repaint();
			 frame.getMultPane().setVisible(true);
		 }
		 
		

         //frame.getMultTable()
	}

}
