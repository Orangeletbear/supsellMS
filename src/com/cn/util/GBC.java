package com.cn.util;


import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBC extends GridBagConstraints {
  public GBC() {
    
  }
  //������Ͻǵ����
  public GBC(int gridx, int gridy) {
    this.gridx = gridx;
    this.gridy = gridy;
  }
  //�������Ͻǵ���������ռ�ĵ�Ԫ��
  public GBC(int gridx, int gridy, int gridWidth, int gridHeight) {
    this(gridx, gridy);
    this.gridwidth = gridWidth;
    this.gridheight = gridHeight;
  }
  //������ռ�,,Ĭ��Ϊ�����С
  public GBC setFill(int fill) {
    this.fill = fill;
    return this;
  }
  //���ø������ľ���
  public GBC setInsets(int top, int left, int bottom, int right) {
    this.insets = new Insets(top, left, bottom, right);
    return this;
  }
  //�����ı���������������
  public GBC setWeight(int weightx, int weighty) {
    this.weightx = weightx;
    this.weighty = weighty;
    return this;
  }
  
}
