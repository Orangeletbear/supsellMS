package com.cn.view.tongjiJFrame.Dialog;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBC extends GridBagConstraints {
  public GBC() {
    
  }
  
  public GBC(int gridx, int gridy) {
    this.gridx = gridx;
    this.gridy = gridy;
  }
  
  public GBC(int gridx, int gridy, int gridWidth, int gridHeight) {
    this(gridx, gridy);
    this.gridwidth = gridWidth;
    this.gridheight = gridHeight;
  }
  
  public GBC setFill(int fill) {
    this.fill = fill;
    return this;
  }
  
  public GBC setInsets(int top, int left, int bottom, int right) {
    this.insets = new Insets(top, left, bottom, right);
    return this;
  }
  
  public GBC setWeight(int weightx, int weighty) {
    this.weightx = weightx;
    this.weighty = weighty;
    return this;
  }
  
}
