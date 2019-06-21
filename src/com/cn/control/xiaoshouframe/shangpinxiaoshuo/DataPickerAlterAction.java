package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCFindGoodsInfo;
import com.cn.util.DateConventer;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;
/**
 * ��Ʒ���۶Ի����е�DataPicker�ı�ʱ��ʱ��Ӧ�ļ�����
 * ��ʱ��ı�ʱ�������۵��ŵ�ǰ��λ��Ҳ���ı�
 * @author Administrator
 *
 */
public class DataPickerAlterAction implements ActionListener {

	private ShangPinXiaoShouDialog dialog;
	
	public DataPickerAlterAction(ShangPinXiaoShouDialog dialog) {
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
			//���������ڵ������պ����ڵ��쵥�ݺŵ�˳����Ϊ���ݺ�
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
				 //����
				dialog.getDanHaoLabel().setText("XS"+s+h) ;
		      }
			
		} catch (ParseException e2) {
			
			e2.printStackTrace();
		}
		 
	}

}
