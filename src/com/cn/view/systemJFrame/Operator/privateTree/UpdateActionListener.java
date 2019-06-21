package com.cn.view.systemJFrame.Operator.privateTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

import com.cn.view.systemJFrame.Operator.privateTree.jtreecheck.CheckTreeManager;
import com.cn.view.systemJFrame.Operator.privateTree.jtreecheck.CheckTreeSelectionModel;
public class UpdateActionListener implements ActionListener {

  private PrivateTree dialog;

  public UpdateActionListener(PrivateTree dialog) {
    this.dialog = dialog;
  }

  public void actionPerformed(ActionEvent e) {
    CheckTreeManager manager = dialog.getCheckTreeManager();
    CheckTreeSelectionModel mode = manager.getSelectionModel();
    TreePath[] paths = mode.getSelectionPaths();
    for (TreePath path : paths) {

      System.out.println(path.getLastPathComponent());
      System.out.println(path);
    }
    JTree tree = dialog.getRightTree();
  }

}

