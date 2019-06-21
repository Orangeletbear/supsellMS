package com.cn.control.systemframe;
/**
 * ���ս���Ի����ϵ�
 * ȷ����ť����Ӧ�ļ�����
 */
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.system.JDBCNianZhongJieSuan;
import com.cn.model.AllTableModel;
import com.cn.model.system.NianJieTabelColumns;
import com.cn.util.Log;
import com.cn.view.systemJFrame.XiTongWeiHu.NianZhongJieSuanDialog;
import com.cn.dao.system.JDBCDeleteAllData;


public class NianZhongJieSuan_SureAction implements ActionListener {

	private NianZhongJieSuanDialog dialog;
	
	public NianZhongJieSuan_SureAction( NianZhongJieSuanDialog dialog){
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		String year = dialog.getJsp().getValue().toString();
	   int n = JOptionPane.showOptionDialog(dialog, "ȷ��Ҫ�������ս�����", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION
			, JOptionPane.QUESTION_MESSAGE, null, null, null);

	    if(n == JOptionPane.YES_OPTION){
	    //���ж��Ƿ���ڸ���������Ϣ
	    if(JDBCDeleteAllData.getData(year).equals(new Vector())){
         //	�����ʾ�ڱ���ϵ�����
	    	Vector data = new Vector();
	      //�������
	    	
	    	data.add(year);
	    //��������
	        Calendar   cal   =   Calendar.getInstance(); 
	    	String today = new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime()); 
	    	data.add(today);
	    //�ɹ���Ϣ
	    	ArrayList list = JDBCNianZhongJieSuan.getCaiGouData(year);
	    	for(int i = 0;i<list.size(); i++){
	    		if(list.get(i) == null){
	    			data.add(0);
	    		}else{
	    			data.add(list.get(i));
	    		}
	    		
	    	}
	    	
	     //������Ϣ
	    	list = JDBCNianZhongJieSuan.getXiaoShouData(year);
	    	
	    	for(int i = 0;i<list.size(); i++){
	    		
	    		if(list.get(i) == null){
	    			data.add(0);
	    		}else{
	    			data.add(list.get(i));
	    		}
	    		
	    	}
	     //������Ϣ
	       list = JDBCNianZhongJieSuan.getDiaoBoData(year);
	    	
	    	for(int i = 0;i<list.size(); i++){
	    		if(list.get(i) == null){
	    			data.add(0);
	    		}else{
	    			data.add(list.get(i));
	    		}
	    		
	    	}
	    	
	    //������Ϣ
	    	 list = JDBCNianZhongJieSuan.getBaoSunData(year);
		    	
		    	for(int i = 0;i<list.size(); i++){
		    		
		    		if(list.get(i) == null){
		    			data.add(0);
		    		}else{
		    			data.add(list.get(i));
		    		}
		    		
		    	}
	    	
	     //������Ϣ
		    	 list = JDBCNianZhongJieSuan.getBaoYiData(year);
			    	
			    	for(int i = 0;i<list.size(); i++){
			    		
			    		if(list.get(i) == null){
			    			data.add(0);
			    		}else{
			    			data.add(list.get(i));
			    		}
			    		
			    	}
	       //��������ʾ�������� 
			Vector data2 = JDBCDeleteAllData.getData();
			//dialog.getMainData().add(data);
			 data2.add(data);
	    	/*dialog.getTableModel().setDataVector(dialog.getMainData(), 
	    			AllTableModel.getVectorFromObj(NianJieTabelColumns.coulumns));
	    	*/
			 dialog.getTableModel().setDataVector(data2, 
		    			AllTableModel.getVectorFromObj(NianJieTabelColumns.coulumns));
		    	
	    	//ɾ��ĳ������ݿ�������Ӫҵ��Ϣ
	    	JDBCDeleteAllData.delete_cgd_Data(year);
	    	
	    
	    	//�����ݿ��в������ս�����Ϣ
	    	JDBCDeleteAllData.insertData(data);
	    	
	    	//д����־��Ϣ
	    	String user =dialog.getDialog().getFrame().getUser();
	    	 Log.traceLog( "  ����Ա  ",user," ������ "+year+" ������ս���");
	    	
	    }else {
	    	JOptionPane.showMessageDialog(dialog, ""+year+"�Ѿ�������ˣ������ظ����㣡");
	    }
		
	     }else{
		
	     }
	}
	
	public static void main(String [] args){
		
	}

}
