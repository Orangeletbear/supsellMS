package com.cn.view.systemJFrame.Operator.privateTree;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;

import com.cn.model.kuchun.KunCunDefaultTreeCellRenderer;

public class RightTree {

	public JTree createTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("所有权限");
		
		// ---------------------------采购管理
		DefaultMutableTreeNode cg_Management = createNode(root, "采购管理");
		
		DefaultMutableTreeNode cgjh = createNode(
				cg_Management, "采购进货");
		DefaultMutableTreeNode cgth = createNode(
				cg_Management, "采购退货");
		DefaultMutableTreeNode ghswlzw = createNode(
				cg_Management, "往来账务");
		DefaultMutableTreeNode cgthcx = createNode(
				cg_Management, "采购/退货查询");
		DefaultMutableTreeNode cg_kccx = createNode(
				cg_Management, "库存查询");
		DefaultMutableTreeNode yxckjj = createNode(
				cg_Management, "允许查看进价");

		// ---------------------------销售管理
		DefaultMutableTreeNode sell_management = createNode(root, "销售管理");
		
		DefaultMutableTreeNode sp_sell =createNode(
				sell_management,"商品销售");
		
		DefaultMutableTreeNode sp_back = createNode(
				sell_management, "顾客退货");
		
		DefaultMutableTreeNode khwlzw =createNode(
				sell_management,"往来账务");
		
		DefaultMutableTreeNode xs_thcx = createNode(
				sell_management, "销售/退货查询");
		DefaultMutableTreeNode xs_kccx =createNode(
				sell_management,"库存查询");
		
		DefaultMutableTreeNode POS_xs_find = createNode(
				sell_management, "POS销售统计");
		
		// ---------------------------库存管理
		DefaultMutableTreeNode chuCun_Manager = createNode(root, "库存管理");
		
		DefaultMutableTreeNode kctb = createNode(
				chuCun_Manager, "库存调拔");
		DefaultMutableTreeNode kcpd = createNode(
				chuCun_Manager, "库存盘点");
		DefaultMutableTreeNode kcbybs = createNode(
				chuCun_Manager,"库存报损报溢");
		DefaultMutableTreeNode kcbj = createNode(
				chuCun_Manager,"库存报警");
		DefaultMutableTreeNode kccfkb = createNode(
				chuCun_Manager,"折分捆绑");
		
		// ---------------------------统计报表
		DefaultMutableTreeNode baoBiaoTongJi = createNode(root,
				"统计报表");

		DefaultMutableTreeNode ghs_tj = createNode(
				baoBiaoTongJi, "供应商供货统计");
		DefaultMutableTreeNode sp_cg_tj = createNode(
				baoBiaoTongJi, "商品采购统计");
		DefaultMutableTreeNode ywy_cg_tj = createNode(
				baoBiaoTongJi, "业务员采购统计");
		DefaultMutableTreeNode kh_xs_tj = createNode(
				baoBiaoTongJi, "客户销售统计");
		DefaultMutableTreeNode sp_xs_tj = createNode(
				baoBiaoTongJi, "商品销售统计");
		DefaultMutableTreeNode ywy_xs_tj = createNode(
				baoBiaoTongJi, "业务员销售统计");
		DefaultMutableTreeNode kcbd_find = createNode(
				baoBiaoTongJi, "库存商品变动查询");
		DefaultMutableTreeNode kc_cb_tj = createNode(
				baoBiaoTongJi, "库存成本统计");
		DefaultMutableTreeNode sp_csph_tj = createNode(
				baoBiaoTongJi, "商品销售排行");
		
		
		
		// ---------------------------日常管理
		DefaultMutableTreeNode riChan_management = createNode(root, "日常管理");
		
		DefaultMutableTreeNode ghs_manager = createNode(
				riChan_management,"供货商管理");
		DefaultMutableTreeNode kh_manager = createNode(
				riChan_management, "客户管理");
		DefaultMutableTreeNode ywy_manager = createNode(
				riChan_management,"业务员管理");
		DefaultMutableTreeNode by_manager = createNode(
				riChan_management, "报价管理");

		
		
		// ---------------------------其它操作
		DefaultMutableTreeNode system_management = createNode(root, "系统设置");
		
		DefaultMutableTreeNode find_sp_ma = createNode(
				system_management,"查看商品信息");
		DefaultMutableTreeNode ghs_xx = createNode(
				system_management, "供货商信息");
		DefaultMutableTreeNode kh_xx = createNode(
				system_management,"客户信息");
		DefaultMutableTreeNode yg_xx = createNode(
				system_management, "员工信息");
		DefaultMutableTreeNode ck_xx = createNode(
				system_management,"仓库设置");
		DefaultMutableTreeNode czy_xx = createNode(
				system_management, "操作员设置");
		DefaultMutableTreeNode systemSet = createNode(
				system_management,"系统设置");
		DefaultMutableTreeNode bakeData = createNode(
				system_management, "数据备份与恢复");
		DefaultMutableTreeNode loodLog = createNode(
				system_management, "查看日志");
		DefaultMutableTreeNode sp_tj = createNode(
				system_management,"商品调价");
		DefaultMutableTreeNode addSP = createNode(
				system_management, "增加商品");
		DefaultMutableTreeNode dele_sp = createNode(
				system_management,"修改删除商品");
		DefaultMutableTreeNode hygl = createNode(
				system_management, "会员管理");
		DefaultMutableTreeNode ckdj = createNode(
				system_management,"查看单据");
		DefaultMutableTreeNode kccx = createNode(
				system_management, "库存查询");
		
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

