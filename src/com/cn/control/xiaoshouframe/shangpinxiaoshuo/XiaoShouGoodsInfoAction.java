package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.border.TitledBorder;

import com.cn.dao.xiaoshou.guketuihuo.AddGoodsInfoFind;
import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCFindGoodsInfo;
import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog.XiaoShouGoodsInfo;
/**
 * ��Ʒ��Ϣ����Ʒ���ۣ�
 * �Ի����ʱ��Ӧ�ļ�����
 * @author Administrator
 *
 */
public class XiaoShouGoodsInfoAction extends WindowAdapter {

	private XiaoShouGoodsInfo dialog;
	String keHuName;
	int row;
	
	public XiaoShouGoodsInfoAction(XiaoShouGoodsInfo dialog,String keHuName,int row){
		this.dialog = dialog;
		this.keHuName = keHuName;
		this.row = row;
	}
	
	//�����ʱ�ʹ�������
	public void windowOpened(WindowEvent e){

		Vector data = JDBCFindGoodsInfo.getData();
		//�����Ϸ�����Ϣ
	//	Vector data = JDBCDanJuFind.getGoodsData(keHuName);
		//System.out.println(data);
	
		dialog.getGoodId().setText(""+((Vector)data.get(row)).get(0));
		dialog.getGoodId().setForeground(Color.BLUE);
		
		dialog.getGoodName().setText(""+((Vector)data.get(row)).get(1));
		dialog.getGoodName().setForeground(Color.RED);
		
		dialog.getDanWei().setText(""+((Vector)data.get(row)).get(2));
		dialog.getDanWei().setForeground(Color.BLUE);
		
		dialog.getXingHao().setText(""+((Vector)data.get(row)).get(3));
		dialog.getXingHao().setForeground(Color.BLUE);
		
		dialog.getColor().setText(""+((Vector)data.get(row)).get(4));
		dialog.getColor().setForeground(Color.BLUE);
		
		dialog.getKuCun().setText(""+((Vector)data.get(row)).get(6));
		dialog.getKuCun().setForeground(Color.RED);
		
		dialog.getShuLiang().setText(""+1);
		dialog.getShuLiang().setForeground(Color.RED);
		
		dialog.getCanKaoShouJia().setText(""+((Vector)data.get(row)).get(5));
		dialog.getCanKaoShouJia().setForeground(Color.RED);
		
		dialog.getDaZhe().setText(""+1.0);
		dialog.getDaZhe().setForeground(Color.BLUE);
		
		dialog.getDanJia().setText(""+((Vector)data.get(row)).get(5));
		dialog.getDanJia().setForeground(Color.BLUE);
		
		dialog.getZje().setText(""+((Vector)data.get(row)).get(5));
		dialog.getZje().setForeground(Color.BLUE);
		//���ñ�����
	     dialog.getBiaoGePanel().setBorder(new TitledBorder(""+keHuName+"���Ѹ���Ʒ��¼"));
		
	     //����GoodsInfoDialog�ı����Ϣ
		
		 String spName = ((Vector)data.get(row)).get(1).toString();
		 Vector data2 =null;
	
		 data2= AddGoodsInfoFind.getData(keHuName, spName);
		 /* dialog.getTableModel().setDataVector(data2,
				      AllTableModel.getVectorFromObj(DialogCulomnModel.columNames));*/
		 if(data2.size() > 0){
			 dialog.getTableModel().setDataVector(data2,
				      AllTableModel.getVectorFromObj(DialogCulomnModel.columNames));
			dialog.getTable().requestFocus();
			dialog.getTable().setRowSelectionInterval(0, 0);
			 
			 
		 }
		
	}
	
}
