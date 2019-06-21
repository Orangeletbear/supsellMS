package com.cn.control.tongjiframe.KuCunTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import com.cn.dao.tongji.KuCunTongJi.KuCunJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.view.tongjiJFrame.KuCunMainFrame;

public class KuCunListener implements ActionListener {
	private KuCunMainFrame frame;
	Vector KuCunColumn;
	Vector NextColumn=new Vector();
	Vector NextTwoColumn=new Vector();
	Vector NextThreeColumn=new Vector();
	Vector NextFourColumn=new Vector();

   public KuCunListener(KuCunMainFrame frame){
	 this.frame=frame;
 }

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	KuCunColumn = KuCunJDBC.getKuCunData(frame.getJs1().getValue()+"-"+frame.getJs2().getValue()+"-01",frame.getJs3().getValue()+"-"+frame.getJs4().getValue()+"-01");
	if("所有仓库".equals(frame.getCangKu().getSelectedItem().toString())){
	    frame.getDtm().setDataVector(KuCunColumn,AllTableModel.getVectorFromObj(tongJiModel.kuCunNames));
	    frame.getJiLu().setText("记录数: "+KuCunColumn.size());
	}
	if("酒库".equals(frame.getCangKu().getSelectedItem().toString())){
		Vector KuCunColumn1=KuCunJDBC.getKuCunData(frame.getJs1().getValue()+"-"+frame.getJs2().getValue()+"-01",frame.getJs3().getValue()+"-"+frame.getJs4().getValue()+"-01");
		for(int i=0;i<KuCunColumn1.size();i++){
			if("酒库".equals(((Vector) KuCunColumn1.get(i)).get(1))){
				NextColumn.add(KuCunColumn1.get(i));
				 frame.getJiLu().setText("记录数: "+KuCunColumn1.size());
			}
		}
		frame.getDtm().setDataVector(NextColumn,
				AllTableModel.getVectorFromObj(tongJiModel.kuCunNames));
	}
	if("主仓库".equals(frame.getCangKu().getSelectedItem().toString())){
		Vector KuCunColumn2=KuCunJDBC.getKuCunData(frame.getJs1().getValue()+"-"+frame.getJs2().getValue()+"-01",frame.getJs3().getValue()+"-"+frame.getJs4().getValue()+"-01");
		for(int i=0;i<KuCunColumn2.size();i++){
			if("主仓库".equals(((Vector) KuCunColumn2.get(i)).get(1))){
				NextTwoColumn.add(KuCunColumn2.get(i));
				 frame.getJiLu().setText("记录数: "+KuCunColumn2.size());
			}
		}
		frame.getDtm().setDataVector(NextTwoColumn,
				AllTableModel.getVectorFromObj(tongJiModel.kuCunNames));
	}
	if("饮料仓库".equals(frame.getCangKu().getSelectedItem().toString())){
		Vector KuCunColumn3=KuCunJDBC.getKuCunData(frame.getJs1().getValue()+"-"+frame.getJs2().getValue()+"-01",frame.getJs3().getValue()+"-"+frame.getJs4().getValue()+"-01");
		for(int i=0;i<KuCunColumn3.size();i++){
			if("饮料仓库".equals(((Vector) KuCunColumn3.get(i)).get(1))){
				NextThreeColumn.add(KuCunColumn3.get(i));
				 frame.getJiLu().setText("记录数: "+KuCunColumn3.size());
			}
		}
		frame.getDtm().setDataVector(NextThreeColumn,
				AllTableModel.getVectorFromObj(tongJiModel.kuCunNames));
		
	}
	if("食品仓库".equals(frame.getCangKu().getSelectedItem().toString())){
		Vector KuCunColumn4=KuCunJDBC.getKuCunData(frame.getJs1().getValue()+"-"+frame.getJs2().getValue()+"-01",frame.getJs3().getValue()+"-"+frame.getJs4().getValue()+"-01");
		for(int i=0;i<KuCunColumn4.size();i++){
			if("食品仓库".equals(((Vector) KuCunColumn4.get(i)).get(1))){
				NextFourColumn.add(KuCunColumn4.get(i));
				 frame.getJiLu().setText("记录数: "+KuCunColumn4.size());
			}
		}
		frame.getDtm().setDataVector(NextFourColumn,
				AllTableModel.getVectorFromObj(tongJiModel.kuCunNames));
		
	}
}
}


