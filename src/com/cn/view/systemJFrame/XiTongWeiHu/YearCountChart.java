package com.cn.view.systemJFrame.XiTongWeiHu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 * �����ͼ��Ի���
 * @author finey
 *
 */
public class YearCountChart extends JDialog {    
         
	private NianZhongJieSuanDialog frame;
	private float [] chartData;
	private int[] numData;
	
	public YearCountChart(NianZhongJieSuanDialog dialog,
			String title,int[] numdata,float [] data){
	    
		super(dialog,title,true);
		this.chartData = data;
		this.numData= numdata;
		this.frame = dialog;
		init();
	}
	
	public void init(){
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(cretePane());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	private JPanel cretePane(){
		
	 JPanel allPane = new JPanel();	
     
      allPane.setLayout(new GridLayout(2,1));
      allPane.add(createChartNum());
      allPane.add(createChartMoney());

	  return allPane;
		
	}
	/**
	 * ����ͼ��
	 * @return
	 */
    private JPanel createChartNum(){
    	
        JPanel pane = new JPanel();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        
        String spName = "��       ��      Ʒ      ��      ��       ��      ��     ��      ��";
        
        dataset.addValue(numData[0], "�ɹ���", spName);
        dataset.addValue(numData[1], "�ɹ��˻���", spName);
        dataset.addValue(numData[2], "�ɹ��ϼ�", spName);    
        
        dataset.addValue(numData[3], "���۵���", spName);
        dataset.addValue(numData[4], "�����˻���", spName);
        dataset.addValue(numData[5], "���ۺϼ�", spName);    
        
        
        dataset.addValue(numData[6], "���ε���", spName);  
        dataset.addValue(numData[7], "��������", spName);  
        
        dataset.addValue(numData[8], "������", spName);  
        dataset.addValue(numData[9], "��������", spName);  
        
        dataset.addValue(numData[10], "���絥��", spName);  
        dataset.addValue(numData[11], "��������", spName);  
        /*   
        	��PlotOrientation.VERTICAL�ĳ�PlotOrientation.HORIZONTAL����״ͼ�����ˮƽ��   
           
        	ʹ��createBarChart3D�ͻ�������ά��״ͼ��   
           
        */   
        JFreeChart chart = ChartFactory.createBarChart3D(    
                "����--����������--ͼ��",                    // ����    
                "��Ʒ�ܻ�",                      // ��������    
                "��Ʒ����",                     // ��������    
                dataset,                    // ����    
                PlotOrientation.VERTICAL,   // ʹ�ô�ֱ��״ͼ    
                true,                       // �Ƿ�ʹ��legend    
                false,                      // �Ƿ�ʹ��tooltip    
                false                       // �Ƿ�ʹ��url����    

                );    
        
        chart.getTitle().setFont(new Font("����", Font.BOLD,16));
        //chart.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11)); 
        /*------���������˵ײ��������������-----------*/ 
        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 14)); 
        
        CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();
        
        domainAxis.setTickLabelFont(new Font("����", Font.BOLD,14));
        //X����
        domainAxis.setLabelFont(new Font("����", Font.BOLD,14));
        
        
        ValueAxis numberaxis = chart.getCategoryPlot().getRangeAxis(); 
        numberaxis.setTickLabelFont(new Font("����", Font.BOLD, 14));  
        numberaxis.setLabelFont(new Font("����", Font.BOLD, 14));  
        
        CategoryPlot plot = chart.getCategoryPlot();//���ͼ���������
        
        
        //����ͼ�������ͺ���org.jfree.chart.axis.CategoryAxis
        //domainAxis.setLowerMargin(0.1);//���þ���ͼƬ��˾����ʱΪ10%
        //domainAxis.setUpperMargin(0.1);//���þ���ͼƬ�Ҷ˾����ʱΪ�ٷ�֮10
        domainAxis.setCategoryLabelPositionOffset(10);//ͼ��������ǩ�ľ���(10����)
        domainAxis.setCategoryMargin(0.2);//�����ǩ֮��ľ���20%
        //domainAxis.setMaximumCategoryLabelLines(1);
        //domainAxis.setMaximumCategoryLabelWidthRatio(0);

        //�趨���ӵ�����
        org.jfree.chart.axis.ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setUpperMargin(0.1);//������ߵ�һ������ͼƬ���˵ľ���(�������10%)
        
        
      //����ͼ�����ɫ
        org.jfree.chart.renderer.category.BarRenderer3D renderer;
        renderer = new org.jfree.chart.renderer.category.BarRenderer3D();
        renderer.setBaseOutlinePaint(Color.red);
        renderer.setSeriesPaint(0, new Color(0, 255, 255));//�ƻ����ӵ���ɫΪ��ɫ
        renderer.setSeriesOutlinePaint(0,Color.BLACK);//�߿�Ϊ��ɫ
        renderer.setSeriesPaint(1, new Color(0, 255, 0));//ʵ�����ӵ���ɫΪ��ɫ
        renderer.setSeriesOutlinePaint(1,Color.red);//�߿�Ϊ��ɫ
        renderer.setItemMargin(0.25);//�������Ӽ��Ϊ����10%
        //��ʾÿ��������ֵ�����޸ĸ���ֵ����������
        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelFont(new Font("����",Font.BOLD,12));//12�ź���Ӵ�
        renderer.setItemLabelPaint(Color.black);//����Ϊ��ɫ
        renderer.setItemLabelsVisible(true);
        plot.setRenderer(renderer);//ʹ��������Ƶ�Ч��
   	  pane.setLayout(new BorderLayout());	 
   	  pane.add(new ChartPanel(chart));
   	  pane.setBorder(new TitledBorder("��Ʒ������ͳ��"));
   	  return pane;
    }
    /**
	 * ��Ǯͼ��
	 * @return
	 */
    private JPanel createChartMoney(){
    	
        JPanel pane = new JPanel();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        
        String spName = "��       ��      Ʒ      ��      ��      ֧       ��       ��      ��";
        
        dataset.addValue(numData[2], "�ɹ��ϼ�", spName);
        dataset.addValue(chartData[0], "�ɹ��ܽ��", spName);   
        
        dataset.addValue(numData[5], "���ۺϼ�", spName);
        dataset.addValue(chartData[1], "�����ܽ��", spName);
     
         
        
        dataset.addValue(numData[9], "��������", spName);  
        dataset.addValue(chartData[2], "�����ܽ��", spName);  
        
        dataset.addValue(numData[11], "��������", spName);  
        dataset.addValue(chartData[3], "�����ܽ��", spName);  
        /*   
        	��PlotOrientation.VERTICAL�ĳ�PlotOrientation.HORIZONTAL����״ͼ�����ˮƽ��   
           
        	ʹ��createBarChart3D�ͻ�������ά��״ͼ��   
           
        */   
        JFreeChart chart = ChartFactory.createBarChart3D(    
                "����--�������--ͼ��",                    // ����    
                "��Ʒ�ܻ�",                      // ��������    
                "��Ʒ�������",                     // ��������    
                dataset,                    // ����    
                PlotOrientation.VERTICAL,   // ʹ�ô�ֱ��״ͼ    
                true,                       // �Ƿ�ʹ��legend    
                false,                      // �Ƿ�ʹ��tooltip    
                false                       // �Ƿ�ʹ��url����    

                );    
        
        chart.getTitle().setFont(new Font("����", Font.BOLD,16));
        //chart.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11)); 
        /*------���������˵ײ��������������-----------*/ 
        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 14)); 
        
        CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();
        
        domainAxis.setTickLabelFont(new Font("����", Font.BOLD,14));
        //X����
        domainAxis.setLabelFont(new Font("����", Font.BOLD,14));
        
        
        ValueAxis numberaxis = chart.getCategoryPlot().getRangeAxis(); 
        numberaxis.setTickLabelFont(new Font("����", Font.BOLD, 14));  
        numberaxis.setLabelFont(new Font("����", Font.BOLD, 14));  
        
        CategoryPlot plot = chart.getCategoryPlot();//���ͼ���������
        
        
        //����ͼ�������ͺ���org.jfree.chart.axis.CategoryAxis
        //domainAxis.setLowerMargin(0.1);//���þ���ͼƬ��˾����ʱΪ10%
        //domainAxis.setUpperMargin(0.1);//���þ���ͼƬ�Ҷ˾����ʱΪ�ٷ�֮10
        //domainAxis.setCategoryLabelPositionOffset(10);//ͼ��������ǩ�ľ���(10����)
        //domainAxis.setCategoryMargin(0.2);//�����ǩ֮��ľ���20%
        //domainAxis.setMaximumCategoryLabelLines(1);
        //domainAxis.setMaximumCategoryLabelWidthRatio(0);

        //�趨���ӵ�����
        org.jfree.chart.axis.ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setUpperMargin(0.1);//������ߵ�һ������ͼƬ���˵ľ���(�������10%)
        
        
      //����ͼ�����ɫ
        org.jfree.chart.renderer.category.BarRenderer3D renderer;
        renderer = new org.jfree.chart.renderer.category.BarRenderer3D();
        renderer.setBaseOutlinePaint(Color.red);
        renderer.setSeriesPaint(0, new Color(0, 255, 255));//�ƻ����ӵ���ɫΪ��ɫ
        renderer.setSeriesOutlinePaint(0,Color.BLACK);//�߿�Ϊ��ɫ
        renderer.setSeriesPaint(1, new Color(0, 255, 0));//ʵ�����ӵ���ɫΪ��ɫ
        renderer.setSeriesOutlinePaint(1,Color.red);//�߿�Ϊ��ɫ
        renderer.setItemMargin(0.3);//�������Ӽ��Ϊ����10%
        //��ʾÿ��������ֵ�����޸ĸ���ֵ����������
        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelFont(new Font("����",Font.BOLD,12));//12�ź���Ӵ�
        renderer.setItemLabelPaint(Color.black);//����Ϊ��ɫ
        renderer.setItemLabelsVisible(true);
        plot.setRenderer(renderer);//ʹ��������Ƶ�Ч��
        
   	  pane.setLayout(new BorderLayout());	 
   	  pane.add(new ChartPanel(chart));
   	  pane.setBorder(new TitledBorder("��Ʒ���ͳ��"));
   	  return pane;
    }
    
    public static void main(String [] args){
    	new YearCountChart(null,"",new int[]{},new float[]{});
    }
   
}   

