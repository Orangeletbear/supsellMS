package com.cn.model.xiaoshou.postongji;

public interface POSXiaoShouCulomnModel {
	
	//POS����ͳ�ƶԻ����е�������ˮ�˶Ի����ϵ�����ˮ���ϵı���
	public static String[] danJuColumNames = {"��������","���۵���","�ܽ��",
		"���ʽ","�Żݽ��","����Ա","������"};
	
	//POS����ͳ�ƶԻ����е�������ˮ�˶Ի�������Ʒ��ϸ���ϵı���
	public static String[] mingXiColumNames = {"����ʱ��","���ݺ�","��Ա���",
		"��Ա����","��Ʒ���","��Ʒ����","����","������","����","�ܽ��","��λ","����ͺ�","��ɫ","���۱�ע"};
	

	//POS����ͳ�ƶԻ����е�����Ա����ͳ�ƶԻ���������Ա�����ı���
	public static String[] shouYinColumNames = {
		"����Ա���","����Ա����","Ӧ�ս��","ʵ�ս��"};
	

	//POS����ͳ�ƶԻ����е�����Ա����ͳ�ƶԻ���������Ա������ϸ���ϵı���
	public static String[] shouYinMingXiColumNames = {
		"���۵���","��������","Ӧ�ս��","ʵ�ս��"};
	
   //POS����ͳ�ƶԻ����е��ս����Ի�����ϵı���
	public static String[] riJieColumNames = {
		"����","�ս�����","����","���","����Ա"};
	
	//POS����ͳ�ƶԻ������������жԻ�����Ʒ��������ѡ��ı���
    public static String[] goodSalesRankingColumNames = {
    	"��Ʒ���","��Ʒ����","��������","�����۶�","����","ë����(%)"};
	
	
	//POS����ͳ�ƶԻ������������жԻ�������Ա��������ѡ��ı���
     public static String[] salesRankingColumNames = {
    	 "����Ա���","����Ա����","��������","�����۶�","����","ë����(%)"};
	
	
	//POS����ͳ�ƶԻ������������жԻ��������Ʒ�����������ѡ��ı���
	public static String[] categoryColumNames = {
		"�����","�������","��������","�����۶�","����","ë����(%)"};
	  
	
	//POS����ͳ�� ����������Ա����ͳ��---���۵�����Ϣ��ı���
	public static String[] VIPConsumeColumNames = {
		                  "���۵���","��������","��Ա���","��Ա����",
		                  "���ѽ��","���ѷ�ʽ","����Ա","��ע"};
	
	//POS����ͳ�� ����������Ա����ͳ��---���۵�����ϸ��Ϣ��ı���
    public static String[] detailedInfoColumNames = {
    	                   "��Ʒ���","��Ʒ����","����",
    	                   "������","����","�ܽ��","��λ","����ͺ�","��ɫ"};
	
  //POS����ͳ�� ����������Ա����ͳ��---���۵�����ϸ��Ϣ��ı���
    public static String[] goodsInfoColumNames = {
    	                   "��Ʒ���","��Ʒ����","����","���"};
	
    //POS����ͳ�ơ�������������POS��������
    public static String[] chuRuKuanColumNames = {"����","��������","�����"
	               ,"������","��������","����Ա","����Ա"};
    
	//POS����ͳ�ơ�������������
	public static final Object[][] obj={};
}
