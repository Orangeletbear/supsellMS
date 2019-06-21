package com.cn.util;


import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBC extends GridBagConstraints {
  public GBC() {
    
  }
  //组件左上角的起点
  public GBC(int gridx, int gridy) {
    this.gridx = gridx;
    this.gridy = gridy;
  }
  //构造左上角的起点和行列占的单元数
  public GBC(int gridx, int gridy, int gridWidth, int gridHeight) {
    this(gridx, gridy);
    this.gridwidth = gridWidth;
    this.gridheight = gridHeight;
  }
  //埴充多大空间,,默认为组件大小
  public GBC setFill(int fill) {
    this.fill = fill;
    return this;
  }
  //设置各组件间的距离
  public GBC setInsets(int top, int left, int bottom, int right) {
    this.insets = new Insets(top, left, bottom, right);
    return this;
  }
  //设置哪边来填满整个窗口
  public GBC setWeight(int weightx, int weighty) {
    this.weightx = weightx;
    this.weighty = weighty;
    return this;
  }
  
}
