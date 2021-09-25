package Class.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**������󣬳�Ա����������: Goods_No������:Goods_Name������:Goods_Price������:Goods_Num���Ƽ۵�λ:Goods_Pe�����:Goods_SumPrice��
         *  ���ܷ�������*/
public class GoodsItem {
	/*�����Ա���ԣ���ʼ����Ա�������ṩ�ӿڹ��ⲿ����*/
private String Goods_No;
private String Goods_Name;
private double Goods_Price;
private double Goods_Num;
private String Goods_Pe;
private double Goods_SumPrice;
public GoodsItem(String goods_No, String goods_Name, double goods_Price,
		double goods_Num, String goods_Pe,double goods_SumPrice) {
	super();
	Goods_No = goods_No;
	Goods_Name = goods_Name;
	Goods_Price = goods_Price;
	Goods_Num = goods_Num;
	Goods_Pe = goods_Pe;
	Goods_SumPrice=goods_SumPrice;
}
public GoodsItem() {
	super();
}
public String getGoods_No() {
	return Goods_No;
}
public void setGoods_No(String goods_No) {
	Goods_No = goods_No;
}
public String getGoods_Name() {
	return Goods_Name;
}
public void setGoods_Name(String goods_Name) {
	Goods_Name = goods_Name;
}
public double getGoods_Price() {
	return Goods_Price;
}
public void setGoods_Price(double goods_Price) {
	Goods_Price = goods_Price;
}
public double getGoods_Num() {
	return Goods_Num;
}
public void setGoods_Num(double goods_Num) {
	Goods_Num = goods_Num;
}
public String getGoods_Pe() {
	return Goods_Pe;
}
public void setGoods_Pe(String goods_Pe) {
	Goods_Pe = goods_Pe;
}
public double getGoods_SumPrice(){
	return Goods_SumPrice;
}
public void setGoods_SumPrice(double goods_SumPrice){
	Goods_SumPrice=goods_SumPrice;
}

/*���ܷ���*/

static LinkedList<GoodsItem> ListGoods=new LinkedList<>();//��Ŵ�ӡ������Ʒ��Ϣ�ļ���
static double PayIn=0.0;//��Ÿ�����

/**������˲˵�����
 * 
 * @param hp ����Ӧ��Ʒ��Ϣ�ļ���
 * @param ad ������Ա�˺�
 */
public void menu(HashMap<GongYinShang,String> hp,String ad){//��������Ʒ������Ա�˺Ŵ�����
	ListGoods.clear();//ÿ�ν��빺��ģ����չ�����Ʒ���������Ϣ
	Scanner sc9=new Scanner(System.in);	
	while(true)
	{			
		boolean b=false;//�˳�����ģ��ı�־
		System.out.println("\n�����˵�����ģ�飺����������������������������������������������������������������������������\n");
		System.out.println("\n��ѡ��    1�����빺����Ʒ��Ϣ      2����ӡ����СƱ       3���˳�ģ��       4���˳�ϵͳ\n");		
		try{
			int n=sc9.nextInt();			 
			switch(n){
			case 1:PayIn=GoodsInput(hp,ad);break;//���빺����Ʒ��Ϣ�ķ�������������Ʒ���������Ʒ������Ա�˺Ŵ���ȥ
			case 2:GoodsPrint(ad,PayIn);break;//��ӡ����СƱ�ķ���������Ź�����Ʒ�ļ��Ϻ�����Ա�˺Ŵ���ȥ
			case 3:b=true;break;//�˳�����ģ��
			case 4:Quit();break;//�˳�ϵͳ
			default:System.out.println("������1-4֮�������ѡ�����");break;
			}
			if(b)
				break;
		}catch(Exception e){
			System.out.println("����������ݲ��Ϸ�������������menu��");
			sc9.next();
		}	
		
	}
}
/**���빺����Ʒ��Ϣ�ķ���
 * @param hp ����Ӧ��Ʒ��Ϣ�ļ���
 * @param ad ������Ա�˺�
 * @return  ��������
 */
public double GoodsInput(HashMap<GongYinShang,String> hp,String ad){	
Scanner sc10=new Scanner(System.in);
System.out.println("\n�����������Ʒ��Ϣ������Ʒ��ţ���Ʒ������,��quit��������\n");
String goods;//����������Ʒ��Ϣ
double inmo;//�������ĸ�����
double sumP=0.0;//�����Ʒ���ۼƽ��
while(true)
 {		
	try{ 
	  goods=sc10.next();	  	  		
	 boolean b=false;//�ж��������Ʒ�ڹ�Ӧ��Ʒ���Ƿ���ڵı�־
	 if(goods.equals("quit"))//������quit����������Ʒ��Ϣ������ʱִ�д�if�����
	 {
		if(sumP==0.0)
		{
			System.out.println("�����λ�δ¼�빺����Ʒ��������Ϣ��\n");
			return sumP;			
		}
		 System.out.println("�����ι������Ʒ���ݹ��У�    "+ListGoods.size()+"   ��");	
		Scanner sc11=new Scanner(System.in);
		/*���븶���������ĸ�����Ϸ�ʱ������while������ִ��*/
		while(true)
		{
			 inmo=-1.0;
		    try{
		    	System.out.println("�����ι�����ۼƽ��Ϊ��"+sumP+"  Ԫ,  �����븶����:\n");
		    	 inmo=sc11.nextDouble();
		    	 if(inmo<sumP)
		    	 {
		    		 System.out.println("����ĸ������С��"+sumP+"Ԫ������������!\n");
		    		 continue; 
		    	 }
		    	 else
		    		 System.out.println("������ɣ�����ɹ�!\n");
		    	 if(inmo!=-1.0)
				    	break;
			    }catch(Exception e){
			    	System.out.println("�Ƿ����룡");
			    	sc11.next();
			    }		    		
		 }		
		return inmo;	
	 }

	 String[] goods1=goods.split(",");	//��������ַ����Զ��Ų�ֳ���Ʒ��ź���Ʒ������ŵ�goods1�ַ���������	 
	 /*������Ź�Ӧ��Ʒ�ļ���*/	
	 for (GongYinShang hpKey : hp.keySet()) 
	 {		 		 
			if(goods1[0].equals(hpKey.getPno()))//���������Ʒ����ڿ���д���ʱִ��if����Ĵ���飬���������Ʒ��ŵ���ӡ������Ʒ�ļ�����
			{
				b=true;//���������Ʒ�ڹ�Ӧ��Ʒ�д���ʱ�ı�־
				double gmsl=Integer.parseInt(goods1[1]);//����������Ʒ��������
				double kc=hpKey.getPnum();//�����Ʒ�������
				if(gmsl<=kc)//����������С�ڵ��ڿ��ʱִ�д�if�����
				{   boolean k=false;//�ж���ӵ���Ʒ��Ҫ��ӡ����Ʒ�������Ƿ���ڵı�־
				
					/*������Ŵ�ӡ������Ʒ�ļ��ϣ�����Ҫ����ĵ���Ʒ����Ƿ��Ѿ���ӵ���ӡ������Ʒ�ļ����У�
					 * ����Ѿ�����ˣ���ֱ���ۼӴ���Ʒ��ŵĹ�����������Ʒ�ۼƽ��*/
					for(GoodsItem gtm:ListGoods)
					{
						if(goods1[0].equals(gtm.getGoods_No()))
						{
							k=true;  gtm.setGoods_Num(gtm.getGoods_Num()+gmsl);
							gtm.setGoods_SumPrice(gtm.getGoods_SumPrice()+gmsl*gtm.getGoods_Price());
							break;
						}
					}
					/*���������ӡ������Ʒ�ļ���ʱ��k=falseʱ��
					 * ��ʾҪ��ӵ���Ʒ����ڴ�ӡ������Ʒ�ļ�����û�в��ҵ���������ӵ�������ȥ*/
					if(!k)
					{
						ListGoods.add(new GoodsItem(goods1[0],hpKey.getPname(),hpKey.getPrice(),gmsl,hpKey.getPdetail(),gmsl*hpKey.getPrice()));									   	
					}
					sumP+=gmsl*hpKey.getPrice();//������Ʒ���ۼƹ�����
					hpKey.setPnum(hpKey.getPnum()-gmsl);//������޸���Ʒ�����								
				}
				else
				{
					System.out.println(goods1[0]+"  ����Ʒ���������,���ֻ�ܹ���"+hpKey.getPnum()+hpKey.getPdetail()+"\n");
					break;
				}
			}			
	 }
	 if(!b)//�������깩Ӧ��Ʒ�ļ��ϣ�b=falseʱ����ʾҪ��ӡ����Ʒ��Ϣû���ڹ�Ӧ��Ʒ�ļ�����û�в��ҵ���������ʾ���
	 {
			System.out.println("\n���������Ʒ�����ڣ�\n");
			continue;
	 }
	}catch(Exception e){
		System.out.println("������Ľ�����Ʒ�����ݲ��Ϸ���\n");
		sc10.next();
	}
  }

}
/**��ӡ����СƱ�ķ���
 * 
 * @param ad ������Ա�˺�
 * @param inmo ��������
 */
public  void GoodsPrint(String ad,double inmo){	
if(ListGoods.size()==0)	
 {
	System.out.println("��ӡ��Ʒ��ϢΪ�գ������빺����Ʒ��Ϣ���ٴ�ӡ\n");
	//Quit();
 }
else
 {	
	/*Ʊͷ����*/	
	System.out.println("����Ա��"+ad);
	StringBuilder pt=new StringBuilder();
	pt.append("            ��     ӭ     ��      ��                          \n");
	pt.append("    Ʒ    ��              �� ��      �� ��      �� ��      \n");
	pt.append("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ __ _ _ _ _ _\n");
	
	double sum=0.0;//������Ʒ���ܽ��
	double count=0.0;//������Ʒ��������			
	/*Ʊ�岿�֣�����Ҫ��ӡ�Ĺ�����Ʒ�ļ���*/
	for(GoodsItem gt:ListGoods)
	{		
		sum+=gt.getGoods_SumPrice();//�ۼ���Ʒ�Ľ��
		count+=gt.getGoods_Num();//�ۼ���Ʒ������	
		
		/*ͨ��StringBuilder��append����ƴ���ַ�������ÿ����Ʒ�Ĵ�ӡ����ƴ������*/
		pt.append(gt.getGoods_Name()).append("                    ").append(gt.Goods_Price).append(" * ").append(gt.getGoods_Num()).append("\n");
		pt.append("(").append(gt.Goods_No).append("      )=               ").append(gt.Goods_SumPrice).append("\n");
		
	}
	
	/*Ʊβ����*/	    	
			Date date=new Date();
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd-001-01-989     hh:mm:ss");
		    String date1=sdf.format(date);			
			pt.append("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ __ _ _ _ _ _\n").append(ListGoods.size()).append("   ����Ʒ    ").append("  ���ƣ�  ");
			pt.append(count).append("  ��\n").append("�ܼƣ�  ").append(sum).append("\nʵ����  ").append(inmo).append("        ����:    ");	
			pt.append(inmo-sum).append("\n").append(date1).append("\n").append("ƾ��СƱ��ȡ��Ʊ��");
			System.out.println(pt.toString());
			OutSb(pt.toString());	//	  ����СƱ�������
 }
}
/**
 * ��СƱ��Ϣ�����һ��word�ļ���
 * @param sb
 */
public void OutSb(String sb){	
	FileWriter fw = null;
	File f = new File("a.doc");
	try {
	if(!f.exists()){
	f.createNewFile();
	}
	fw = new FileWriter(f);	
	fw.write(sb.toString());
	fw.close();
	} catch (IOException e) {
	e.printStackTrace();
	}
}

/**
 * �˳�ϵͳ�ķ���
 */
public void Quit(){
	System.out.println("������������������������������������������������������ӭ�ٴ�ʹ�ó��й���СƱϵͳ��������������������������������������������������������������");
	System.exit(0);
}
}
