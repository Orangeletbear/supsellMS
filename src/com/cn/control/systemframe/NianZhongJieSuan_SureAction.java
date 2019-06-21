package com.cn.control.systemframe;
/**
 * 年终结算对话框上的
 * 确定按钮所对应的监听器
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
	   int n = JOptionPane.showOptionDialog(dialog, "确定要进行年终结算吗？", "系统提示", JOptionPane.YES_NO_OPTION
			, JOptionPane.QUESTION_MESSAGE, null, null, null);

	    if(n == JOptionPane.YES_OPTION){
	    //先判断是否存在该年的年结信息
	    if(JDBCDeleteAllData.getData(year).equals(new Vector())){
         //	存放显示在表格上的数据
	    	Vector data = new Vector();
	      //结算年份
	    	
	    	data.add(year);
	    //结算日期
	        Calendar   cal   =   Calendar.getInstance(); 
	    	String today = new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime()); 
	    	data.add(today);
	    //采购信息
	    	ArrayList list = JDBCNianZhongJieSuan.getCaiGouData(year);
	    	for(int i = 0;i<list.size(); i++){
	    		if(list.get(i) == null){
	    			data.add(0);
	    		}else{
	    			data.add(list.get(i));
	    		}
	    		
	    	}
	    	
	     //销售信息
	    	list = JDBCNianZhongJieSuan.getXiaoShouData(year);
	    	
	    	for(int i = 0;i<list.size(); i++){
	    		
	    		if(list.get(i) == null){
	    			data.add(0);
	    		}else{
	    			data.add(list.get(i));
	    		}
	    		
	    	}
	     //调拨信息
	       list = JDBCNianZhongJieSuan.getDiaoBoData(year);
	    	
	    	for(int i = 0;i<list.size(); i++){
	    		if(list.get(i) == null){
	    			data.add(0);
	    		}else{
	    			data.add(list.get(i));
	    		}
	    		
	    	}
	    	
	    //报损信息
	    	 list = JDBCNianZhongJieSuan.getBaoSunData(year);
		    	
		    	for(int i = 0;i<list.size(); i++){
		    		
		    		if(list.get(i) == null){
		    			data.add(0);
		    		}else{
		    			data.add(list.get(i));
		    		}
		    		
		    	}
	    	
	     //报溢信息
		    	 list = JDBCNianZhongJieSuan.getBaoYiData(year);
			    	
			    	for(int i = 0;i<list.size(); i++){
			    		
			    		if(list.get(i) == null){
			    			data.add(0);
			    		}else{
			    			data.add(list.get(i));
			    		}
			    		
			    	}
	       //将数据显示到界面上 
			Vector data2 = JDBCDeleteAllData.getData();
			//dialog.getMainData().add(data);
			 data2.add(data);
	    	/*dialog.getTableModel().setDataVector(dialog.getMainData(), 
	    			AllTableModel.getVectorFromObj(NianJieTabelColumns.coulumns));
	    	*/
			 dialog.getTableModel().setDataVector(data2, 
		    			AllTableModel.getVectorFromObj(NianJieTabelColumns.coulumns));
		    	
	    	//删除某年的数据库中所有营业信息
	    	JDBCDeleteAllData.delete_cgd_Data(year);
	    	
	    
	    	//向数据库中插入年终结算信息
	    	JDBCDeleteAllData.insertData(data);
	    	
	    	//写入日志信息
	    	String user =dialog.getDialog().getFrame().getUser();
	    	 Log.traceLog( "  操作员  ",user," 进行了 "+year+" 年的年终结算");
	    	
	    }else {
	    	JOptionPane.showMessageDialog(dialog, ""+year+"已经结算过了，不能重复结算！");
	    }
		
	     }else{
		
	     }
	}
	
	public static void main(String [] args){
		
	}

}
