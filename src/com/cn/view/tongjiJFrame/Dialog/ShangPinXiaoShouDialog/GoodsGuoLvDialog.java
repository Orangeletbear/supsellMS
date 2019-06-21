package com.cn.view.tongjiJFrame.Dialog.ShangPinXiaoShouDialog;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cn.dao.pos.POSJDBC;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
import com.cn.view.tongjiJFrame.CaiGouTongJiMainFrame;
import com.cn.view.tongjiJFrame.GoodsXiaoShouTongJi;
import com.cn.view.tongjiJFrame.Dialog.CaiGouTongJiCheckDialog;
import com.cn.view.tongjiJFrame.Dialog.GBC;
import com.cn.view.tongjiJFrame.Dialog.TongJiGongHuoShangDialog;



public class GoodsGuoLvDialog extends JDialog implements ActionListener {
    GoodsXiaoShouTongJi frame;
    JLabel gongHuoShang,cangKu,jingBanRen,danJu,danJuLable;//��ʾ������Ϣ��JLabel
	JButton queDing,tuiChu,chaXun; //ȷ�����˳��Ͳ�ѯ��ť
	JTextField showT;    //���������������
	JComboBox cangKuBox,jingBanRenBox;//3��JComboBox
	/**
	 * �÷������û��ṩ��ӵ������ݵĴ��ڣ�������4��JLabel��3��JComboBox,
	 * ��1��JTextField�Լ�3����ť���ֱ�Ϊȡ����ȷ��,��ѯ��
	 * @param frame
	 * @param title
	 * @param modal
	 */
      public GoodsGuoLvDialog(GoodsXiaoShouTongJi frame,String title,boolean modal){
    	  super(frame,title,modal);
    	  this.frame=frame;
    	  init();
      }
      private void init(){
    	  this.setSize(300, 300);
    	  this.setLocationRelativeTo(null);  //�����������
    	  /*
    	   * ���������ʵ���������
    	   */
    	  JPanel jp=new JPanel();
    	  jp.setLayout(new GridBagLayout());
    	  gongHuoShang=new JLabel("�ͻ�����:");
    	  cangKu=new JLabel("�ֿ�����");
    	  jingBanRen=new JLabel("������");
    	  danJu=new JLabel("��������");
    	  showT=new JTextField();
    	  showT.setPreferredSize(new Dimension(100,20));
    	  cangKuBox=new JComboBox(JDBCCuCunFind.getCanKuData());
    	  cangKuBox.addItem("���вֿ�");
    	  cangKuBox.setSelectedItem("���вֿ�");
    	  
    	  cangKuBox.setPreferredSize(new Dimension(100,20));
    	  jingBanRenBox=new JComboBox(POSJDBC.getAllWorker());
    	  jingBanRenBox.addItem("����ҵ��Ա");
    	  jingBanRenBox.setSelectedItem("����ҵ��Ա");
    	  
    	  jingBanRenBox.setPreferredSize(new Dimension(100,20));
    	  danJuLable=new JLabel("���۵�");
    	  danJuLable.setPreferredSize(new Dimension(100,20));
    	  queDing=new JButton("ȷ��");
    	  tuiChu=new JButton("�˳�");
    	  chaXun=new JButton(new ImageIcon("res\\AcionIcon\\search.png"));
    	  chaXun.setMargin(new Insets(0,0,0,0));
    	  jp.add(gongHuoShang,new GBC(0,0).setInsets(5, 5, 5, 5));
    	  jp.add(showT,new GBC(1,0).setInsets(5, 5, 5, 5));
    	  jp.add(chaXun,new GBC(2,0).setInsets(5, 5, 5, 5));
    	  jp.add(cangKu,new GBC(0,1).setInsets(5, 5, 5, 5));
    	  jp.add(cangKuBox,new GBC(1,1).setInsets(5, 5, 5, 5));
    	  jp.add(jingBanRen,new GBC(0,2).setInsets(5, 5, 5, 5));
    	  jp.add(jingBanRenBox,new GBC(1,2).setInsets(5, 5, 5, 5));
    	  jp.add(danJu,new GBC(0,3).setInsets(5, 5, 5, 5));
    	  jp.add(danJuLable,new GBC(1,3).setInsets(5, 5, 5, 5));
    	  jp.add(queDing,new GBC(0,4).setInsets(5, 5, 5, 5));
    	  jp.add(tuiChu,new GBC(2,4).setInsets(5, 5, 5, 5));
    	  chaXun.addActionListener(this);
    	  tuiChu.addActionListener(this);
    	  queDing.addActionListener(this);
    	  this.add(jp);
    	  this.setVisible(true);
      }
      public Vector getChaZhaoXinxi(){
    	  String sql=null;
          Vector data = new Vector();
      	  Connection conn = JDBCTool.getConnection();
    	    Statement st = null;
    		ResultSet  rs = null;
    		try {
    			String keHu=showT.getText();
    			String cangKu=cangKuBox.getSelectedItem().toString();
    	      	String jingBanRen=jingBanRenBox.getSelectedItem().toString();
    	      	String date1=DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate());
    	      	String date2=DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate());
    	      	if("���вֿ�".equals(cangKu)&&"����ҵ��Ա".equals(jingBanRen)){
    	      		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id  and kh_Id=xs_khId  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and kh_name='"+keHu+"'";
    	      	}
    	     	else if(!"���вֿ�".equals(cangKu)&&"����ҵ��Ա".equals(jingBanRen)){
    	     		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo,tb_ckinfo "+
                    "where xs_Id=xsd_dh and xs_chName=ck_id and sp_Id=xsd_Id  and kh_Id=xs_khId  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and kh_name='"+keHu+"' and ck_name='"+cangKu+"'";
			       
    	      	}
    	      	else if("���вֿ�".equals(cangKu)&&!"����ҵ��Ա".equals(jingBanRen)){
    	      		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo "+
                    "where xs_Id=xsd_dh and sp_Id=xsd_Id  and kh_Id=xs_khId  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and kh_name='"+keHu+"' and xs_jbr='"+jingBanRen+"'";
    	      	}
    	      	else if(!"���вֿ�".equals(cangKu)&&!"����ҵ��Ա".equals(jingBanRen)){
    	      		sql =" select xsd_dh,xs_xsdate,xsd_Id,sp_name,sp_sccs,sp_dw,sp_sj,xsd_num,(sp_sj*xsd_num)," +
					"round(((sp_sj-sp_jj)*xsd_num),2),round((((sp_sj-sp_jj)*xsd_num)/(sp_sj*xsd_num)),2) " +
					",xs_jbr, xs_chName,kh_name,sp_ggxh,sp_color,sp_sccs  " +
					"from tb_sell_main,tb_sell_detail,tb_spinfo,tb_khinfo,tb_ckinfo "+
                    "where xs_Id=xsd_dh and xs_chName=ck_id and sp_Id=xsd_Id  and kh_Id=xs_khId  and to_date('"+date1+"','YYYY-MM-DD')-"+
					"tb_sell_main.xs_xsdate<0 and to_date('"+date2+"','YYYY-MM-DD') - " +
					"tb_sell_main.xs_xsdate>0 and kh_name='"+keHu+"' and ck_name='"+cangKu+"' and xs_jbr='"+jingBanRen+"'";
    	      	}
    			  st = conn.createStatement();
    				rs = st.executeQuery(sql);
    				//��ȡ���е�����
    				int columnCount = rs.getMetaData().getColumnCount();
    				while(rs.next()){
    					Vector tmp = new Vector();
    					for(int column = 1;column<=columnCount;column++){
    						tmp.add(rs.getObject(column));
    					}
    			    data.add(tmp);
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
    			
    		} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
    			JDBCTool.freeResorse(rs, st, conn);
    		}
      	
      	return data;
      }
	public void actionPerformed(ActionEvent e) {
         if(e.getSource()==chaXun){
        	 new KeHuJDialog(GoodsGuoLvDialog.this,"��ѯ�ͻ�",true);
         }	
         if(e.getSource()==tuiChu){
        	 this.dispose();
         }
         if(e.getSource()==queDing){
        	frame.getDtm1().setDataVector(getChaZhaoXinxi(), AllTableModel.getVectorFromObj(tongJiModel.dtm1Names));
        	this.dispose();
         }
         
	}
	public JTextField getShowT() {
		return showT;
	}
      
}
