package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCFindGoodsInfo;
import com.cn.util.DateConventer;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;

public class DatePickerAlterAction implements ActionListener {

	private GuKeTuiHuoDialog dialog;
	
	public DatePickerAlterAction(GuKeTuiHuoDialog dialog){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		 try {
				
			 String date = DateConventer.dateToStr(dialog.getDataPicker().getSelectedDate(),"yyyy-MM-dd");
			 String s = date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
			 ArrayList dan = JDBCFindGoodsInfo.danJu(date);
			 ArrayList sd = new ArrayList();
			 for(int i = 0;i < dan.size();i++){
				 String dan1 = dan.get(i).toString();
				 if(dan1.substring(4, 12).equals(s)){	 
					 sd.add(dan1);
				 }
			 }
			//以销售日期的年月日和它在当天单据号的顺序作为单据号
			 if(sd.size()==0){
				dialog.getDanHaoLabel().setText("XS"+s+"0001") ;
				
			 }else{
				 int max = 0;
				 String h = null;
				 for(int i = 0;i< sd.size();i++){
					    max = Integer.parseInt(sd.get(0).toString().substring(11, 14));
					 
			        	if(Integer.parseInt(sd.get(i).toString().substring(11, 14)) > max){
			        		max = Integer.parseInt(sd.get(i).toString().substring(11, 14));
			        	}
			        	if(max>0 && max<10){
			        		h = "000"+(max+1);
			        	}else if(max>9 && max<100){
			        		h = "00"+(max+1);
			        	}else if(max >99&& max< 1000){
			        		h = "0"+(max+1);
			        	}else {
			        		h = ""+(max+1);
			        	}
			    }
				 //单号
				dialog.getDanHaoLabel().setText("XS"+s+h) ;
		      }
			
		} catch (ParseException e2) {
			
			e2.printStackTrace();
		}
		 
	}

}
