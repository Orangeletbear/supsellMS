package com.cn.view.systemJFrame.Operator.privateTree;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;

import com.cn.model.kuchun.KunCunDefaultTreeCellRenderer;

public class RightTree {

	public JTree createTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("����Ȩ��");
		
		// ---------------------------�ɹ�����
		DefaultMutableTreeNode cg_Management = createNode(root, "�ɹ�����");
		
		DefaultMutableTreeNode cgjh = createNode(
				cg_Management, "�ɹ�����");
		DefaultMutableTreeNode cgth = createNode(
				cg_Management, "�ɹ��˻�");
		DefaultMutableTreeNode ghswlzw = createNode(
				cg_Management, "��������");
		DefaultMutableTreeNode cgthcx = createNode(
				cg_Management, "�ɹ�/�˻���ѯ");
		DefaultMutableTreeNode cg_kccx = createNode(
				cg_Management, "����ѯ");
		DefaultMutableTreeNode yxckjj = createNode(
				cg_Management, "����鿴����");

		// ---------------------------���۹���
		DefaultMutableTreeNode sell_management = createNode(root, "���۹���");
		
		DefaultMutableTreeNode sp_sell =createNode(
				sell_management,"��Ʒ����");
		
		DefaultMutableTreeNode sp_back = createNode(
				sell_management, "�˿��˻�");
		
		DefaultMutableTreeNode khwlzw =createNode(
				sell_management,"��������");
		
		DefaultMutableTreeNode xs_thcx = createNode(
				sell_management, "����/�˻���ѯ");
		DefaultMutableTreeNode xs_kccx =createNode(
				sell_management,"����ѯ");
		
		DefaultMutableTreeNode POS_xs_find = createNode(
				sell_management, "POS����ͳ��");
		
		// ---------------------------������
		DefaultMutableTreeNode chuCun_Manager = createNode(root, "������");
		
		DefaultMutableTreeNode kctb = createNode(
				chuCun_Manager, "������");
		DefaultMutableTreeNode kcpd = createNode(
				chuCun_Manager, "����̵�");
		DefaultMutableTreeNode kcbybs = createNode(
				chuCun_Manager,"��汨����");
		DefaultMutableTreeNode kcbj = createNode(
				chuCun_Manager,"��汨��");
		DefaultMutableTreeNode kccfkb = createNode(
				chuCun_Manager,"�۷�����");
		
		// ---------------------------ͳ�Ʊ���
		DefaultMutableTreeNode baoBiaoTongJi = createNode(root,
				"ͳ�Ʊ���");

		DefaultMutableTreeNode ghs_tj = createNode(
				baoBiaoTongJi, "��Ӧ�̹���ͳ��");
		DefaultMutableTreeNode sp_cg_tj = createNode(
				baoBiaoTongJi, "��Ʒ�ɹ�ͳ��");
		DefaultMutableTreeNode ywy_cg_tj = createNode(
				baoBiaoTongJi, "ҵ��Ա�ɹ�ͳ��");
		DefaultMutableTreeNode kh_xs_tj = createNode(
				baoBiaoTongJi, "�ͻ�����ͳ��");
		DefaultMutableTreeNode sp_xs_tj = createNode(
				baoBiaoTongJi, "��Ʒ����ͳ��");
		DefaultMutableTreeNode ywy_xs_tj = createNode(
				baoBiaoTongJi, "ҵ��Ա����ͳ��");
		DefaultMutableTreeNode kcbd_find = createNode(
				baoBiaoTongJi, "�����Ʒ�䶯��ѯ");
		DefaultMutableTreeNode kc_cb_tj = createNode(
				baoBiaoTongJi, "���ɱ�ͳ��");
		DefaultMutableTreeNode sp_csph_tj = createNode(
				baoBiaoTongJi, "��Ʒ��������");
		
		
		
		// ---------------------------�ճ�����
		DefaultMutableTreeNode riChan_management = createNode(root, "�ճ�����");
		
		DefaultMutableTreeNode ghs_manager = createNode(
				riChan_management,"�����̹���");
		DefaultMutableTreeNode kh_manager = createNode(
				riChan_management, "�ͻ�����");
		DefaultMutableTreeNode ywy_manager = createNode(
				riChan_management,"ҵ��Ա����");
		DefaultMutableTreeNode by_manager = createNode(
				riChan_management, "���۹���");

		
		
		// ---------------------------��������
		DefaultMutableTreeNode system_management = createNode(root, "ϵͳ����");
		
		DefaultMutableTreeNode find_sp_ma = createNode(
				system_management,"�鿴��Ʒ��Ϣ");
		DefaultMutableTreeNode ghs_xx = createNode(
				system_management, "��������Ϣ");
		DefaultMutableTreeNode kh_xx = createNode(
				system_management,"�ͻ���Ϣ");
		DefaultMutableTreeNode yg_xx = createNode(
				system_management, "Ա����Ϣ");
		DefaultMutableTreeNode ck_xx = createNode(
				system_management,"�ֿ�����");
		DefaultMutableTreeNode czy_xx = createNode(
				system_management, "����Ա����");
		DefaultMutableTreeNode systemSet = createNode(
				system_management,"ϵͳ����");
		DefaultMutableTreeNode bakeData = createNode(
				system_management, "���ݱ�����ָ�");
		DefaultMutableTreeNode loodLog = createNode(
				system_management, "�鿴��־");
		DefaultMutableTreeNode sp_tj = createNode(
				system_management,"��Ʒ����");
		DefaultMutableTreeNode addSP = createNode(
				system_management, "������Ʒ");
		DefaultMutableTreeNode dele_sp = createNode(
				system_management,"�޸�ɾ����Ʒ");
		DefaultMutableTreeNode hygl = createNode(
				system_management, "��Ա����");
		DefaultMutableTreeNode ckdj = createNode(
				system_management,"�鿴����");
		DefaultMutableTreeNode kccx = createNode(
				system_management, "����ѯ");
		
		JTree tree = new JTree(root);
		
		PrivateTreeDefaultTreeCellRenderer render = new PrivateTreeDefaultTreeCellRenderer();
	    
		tree.setCellRenderer(render);
	    
	    tree.setCellEditor(new DefaultTreeCellEditor(tree, render) {
	        
	    });
		
		return tree;

	}

	private DefaultMutableTreeNode createNode(DefaultMutableTreeNode node,
			String subNodeName) {
		DefaultMutableTreeNode subNode = new DefaultMutableTreeNode(subNodeName);
		node.add(subNode);
		return subNode;
	}
}

