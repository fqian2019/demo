package Test.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import Class.demo.GongYinShang;
import Class.demo.GoodsItem;
/**
 * ϵͳ������
 */
public class Main {
	static HashMap<GongYinShang,String> hp=new HashMap<>();//��Ź�Ӧ��Ʒ����Ϣ
	/**��ʼ����Ӧ��Ʒ����Ϣ
	 * 
	 * @return
	 */
	public static HashMap<GongYinShang,String> Init_GongYin()
	{		
		hp.put(new GongYinShang("1001","2BǦ��","֧",500.0,2.0,"13214254677","����칫�ľ�"), "2013-02-03");
		hp.put(new GongYinShang("2001","⨺���","ǧ��",2000.66,10.0,"15268954679","����⨺���"), "2015-12-08");
		hp.put(new GongYinShang("2002","���Ѹ�","ǧ��",5000.7,19.0,"18234253625","�½����Ѹ�"), "2014-05-06");
		hp.put(new GongYinShang("1004","ë��","��",6500,26.0,"13214201024","������ë��"), "2014-08-10");
		hp.put(new GongYinShang("1005","���","��",5000,5.0,"15114252222","����԰���"), "2018-12-03");
		hp.put(new GongYinShang("1006","����","ǧ��",1500.5,6.0,"13614254227","�����"), "2018-12-15");
		hp.put(new GongYinShang("1007","����","֧",500,12.0,"15524254670","��������"), "2016-11-23");
		hp.put(new GongYinShang("1008","����","��",800,21.0,"13614254477","ϣŵˮ��"), "2016-07-02");
		hp.put(new GongYinShang("1009","��ˮ��","��",500,45.0,"18314254655","Ȫ����ˮ��"), "2017-08-04");
		hp.put(new GongYinShang("10010","ţ��","��",500,79.0,"15514254333","������ţ��"), "2018-12-30");
		return hp;
	}
	/**�жϴӼ������������Ʒ����ڿ�����Ƿ��Ѿ�����ͬ������Ʒ���
	 * 
	 * @param pno
	 * @return
	 */
	public static boolean IsExis(String pno){
		boolean b=true;
		for(GongYinShang gy:hp.keySet() )
		{
			if(gy.getPno().equals(pno))
			{
				b=false;
				break;
			}
		}
		return b;
	}
	/**������Ʒ��Ų��ҿ����Ʒ��Ϣ�����ҳɹ�����Զ�������޸ĺ�ɾ������
	 * 
	 */
	public static void Seek_GongYin(){
		Scanner sc1=new Scanner(System.in);
		while(true)
		{
			System.out.println("��������Ʒ��Ų�ѯ��Ʒ��Ϣ,��������������quit��������������������������������������\n");
			boolean b=true;//�ж���Ʒ�Ƿ���ҳɹ��ı�־
			try{
				String sp=sc1.nextLine();//����������Ʒ���
				if(sp.equals("quit"))//������quitʱ�������ң�����ѭ��
					break;
				/*���������Ʒ��Ϣ*/
				for(GongYinShang gy:hp.keySet())
				{
					if(gy.getPno().equals(sp))//����������ʱ��ʾ���ҳɹ�����ӡ��Ʒ��Ϣ����ʾ�û��޸Ļ�ɾ����Ӧ��Ʒ��Ϣ
					{
						String dateValue=hp.get(gy);  
						b=false;
						System.out.println("��Ʒ��ţ�"+gy.getPno()+",��Ʒ���ƣ�"+gy.getPname()+",��Ʒ������"+gy.getPdetail()+",��Ʒ������"+gy.getPnum()+",��Ʒ�۸�"+gy.getPrice()+",��Ӧ����ϵ��ʽ��"+gy.getPtel()+",��Ӧ�����ƣ�"+gy.getCompany()+",���ʱ�䣺"+dateValue);
					    System.out.println("�޸Ļ�ɾ������������Ϣ��   1���޸�       2��ɾ��    \n");
					    Scanner sc2=new Scanner(System.in);
					    try{
					    	int n=sc2.nextInt();
					    	if(n==1)
					    	{
					    		Update_GongYin(sp);//�����޸���Ʒ��Ϣ�ķ���������Ʒ�Ŵ���ȥ
					    		break;
					    	}
  	
					    	else if(n==2)
					    	{
					    		Delete_GongYin(sp);//����ɾ����Ʒ��Ϣ�ķ���������Ʒ�Ŵ���ȥ
					    		break;
					    	}					    					    						    		
					    	else
					    	{
					    		System.out.println("û�д�ѡ�\n");
					    		break;
					    	}					    		
					    	
					    }catch(Exception e)
					    {
					    	System.out.println("��������޸�ѡ�����ݲ��Ϸ������������룡\n");
					    	sc2.next();
					    }
					}
				}
				if(b)
				{
					System.out.println("���������Ʒ���û�в��ҵ�!\n");
				}
			}catch(Exception e )
			{
				System.out.println("������Ĳ������ݲ��Ϸ������������룡\n");
		    	sc1.next();
			}			
		}		
	}
	
	/**������Ʒ����޸���Ʒ������Ϣ
	 * 
	 * @param sp
	 */
	public static void Update_GongYin(String sp){		
		Scanner sc3=new Scanner(System.in);
		boolean b=false;//�޸���Ʒ��Ϣ�Ƿ�ɹ��ı�־
		while(true)
		{
			System.out.println("��Ҫ�޸ĵ���Ʒ�Ǳ��Ϊ��  "+sp+"   �˳��޸�������quit\n");
			System.out.println("�������޸����ݣ���Ʒ���ƣ���Ʒ�Ƽ۵�λ����Ʒ��������Ʒ�۸񣬹�Ӧ����ϵ��ʽ,��Ӧ�����ƣ�\n");
		try{
			String str=sc3.nextLine();
			if(str.equals("quit"))
			{
				break;
			}
			String[] gy_update=str.split(",");//��������޸���Ʒ��Ϣ�Զ��Ž���Ʒ������ֳ�����ŵ��ַ���������
			String pnumGex="0|([1-9][0-9]{0,16})|(([1-9][0-9]{0,10})+\\.([0-9]\\d{0,5}))|(0+\\.([0-9]\\d{0,5}))";//���������ݵ������16λ��,С���㱣��5λ			
			if(!gy_update[2].matches(pnumGex)||gy_update[3].matches(pnumGex))
			{
				System.out.println("��Ʒ�����͵������벻�Ϸ���\n");
				continue;
			}																	
			String ptelGex="1[358]\\d{9}";//�ֻ���������ʽ
			if(!gy_update[4].matches(ptelGex))//�ж�������ֻ�����������ʽ�Ƿ�ƥ��
			{
				System.out.println("��Ӧ����ϵ�������벻�Ϸ������������������Ϸ�������\n");
				continue;
			}	
			/*������Ӧ��Ʒ��Ϣ�ļ��ϣ����ҵ�Ҫ�޸ĵ���Ʒ��ţ��޸���Ʒ�������޸ĺ�����forѭ��*/
			for(GongYinShang gys:hp.keySet())
			{
				if(gys.getPno().equals(sp))
				{
					gys.setPname(gy_update[0]);   gys.setPdetail(gy_update[1]);					
					gys.setPnum(Double.parseDouble(gy_update[2]));
					gys.setPrice(Double.parseDouble(gy_update[3]));
					gys.setPtel(gy_update[4]);    gys.setCompany(gy_update[5]);									
					b=true;
					break;
				}
			}
			if(b)
			{
				System.out.println("�޸ĳɹ���\n");
				break;
			}
		}catch(Exception e)
		{
			System.out.println("��������޸����ݲ��Ϸ������������룡\n");
			sc3.next();
		}
	  }
	}	
	
	/**������Ʒ���ɾ����Ʒ������Ϣ
	 * 
	 * @param sp
	 */
	public static void Delete_GongYin(String sp)
	{
		System.out.println("ȷ��Ҫɾ����  Y����       N����\n");
		Scanner sc4=new Scanner(System.in);
		try{
			String sn=sc4.next();
			if(sn.equals("Y"))
			{
				/*������Ӧ��Ʒ��Ϣ�����ҵ�Ҫɾ������Ʒ��ţ�����Ʒɾ��������forѭ��*/
				for(GongYinShang gys:hp.keySet())
				{
					if(gys.getPno().equals(sp))
					{																	
						hp.remove(gys);						
						break;
					}
				}
				System.out.println("ɾ���ɹ�!\n");
			}
			else if(sn.equals("N"))
			{
				System.out.println("��ȡ��ɾ����\n");
			}
			else
				System.out.println("û�д�ѡ�\n");
		}catch(Exception e){
			System.out.println("����������ݲ��Ϸ���\n");
			sc4.next();
		}
	}
	

	/**��ӹ�Ӧ��Ʒ��Ϣ
	 * 
	 */
	public static void TianJia_GongYin() {												              		
		System.out.println("�����빩Ӧ��Ʒ��Ϣ������Ʒ��ţ���Ʒ���ƣ���Ʒ�Ƽ۵�λ����Ʒ��������Ʒ�۸񣬹�Ӧ����ϵ��ʽ,��Ӧ�����ƣ�,��quit��������");									
				do{
					Scanner sc5=new Scanner(System.in);
					try{
				    String gyxx=sc5.nextLine();//��ŴӼ������������Ʒ��Ϣ
				    if(gyxx.equals("quit"))	//���û�����quitʱ���˳������Ʒ��ѭ��ģ��
				    {
				    	System.out.println("������!");
				    	break;	
				    }				    				    
					String[] gy=gyxx.split(",");//�����Ʒ��Ϣ�ַ���������ֺ����Ʒ������ŵ��ַ���������
					String pno=gy[0];//��Ʒ���
					if(!IsExis(pno))//����������Ʒ����Ѿ����ڿ����Ʒ�����У��������Ʒ��Ϣ��������һ�ε������Ʒѭ������
					{
						System.out.println("���������Ʒ����Ѿ�����ˣ��벻Ҫ�ظ����!\n");
						continue;
					}
					else//��Ʒ���û����ӵ���Ӧ��Ʒ�������������Ʒ
					{
						String pname=gy[1];//��Ʒ����
						String pdetail=gy[2];//��Ʒ�Ƽ۵�λ
						String pnumGex="0|([1-9][0-9]{0,16})|(([1-9][0-9]{0,10})+\\.([0-9]\\d{0,5}))|(0+\\.([0-9]\\d{0,5}))";//���������ݵ������16λ��,С���㱣��5λ						
						if(!(gy[3].matches(pnumGex)||gy[4].matches(pnumGex)))
						{
							System.out.println("��Ʒ�����͵������벻�Ϸ���\n");
							continue;
						}
						double pnum=Double.parseDouble(gy[3]);//��Ʒ����
						double price=Double.parseDouble(gy[4]);	//��Ʒ����											
						String ptel=gy[5];	//��Ӧ����ϵ����
						String ptelGex="1[358]\\d{9}";//�ֻ���������ʽ
						if(!ptel.matches(ptelGex))//��Ӧ�̺��벻ƥ������ʱ�������Ʒ������������Ʒ��Ӳ�����������һ����Ʒ�����
						{
							System.out.println("��Ӧ����ϵ�������벻�Ϸ������������������Ϸ�������\n");
							continue;
						}
						String company=gy[6];//��Ӧ������
						/*�����Ʒ������*/
						Date da=new Date();
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						String dat=sdf.format(da);
						/*��ӹ�Ӧ��Ʒ��������*/
				        hp.put(new GongYinShang( pno, pname, pdetail, pnum, price, ptel,company),dat);
					}					
					
					}catch(Exception e){
						System.out.println("���벻����!");
						//sc5.next();//sc������ѭ��֮�ڿ���ʡ�ԣ�
					}		
				  }while(true);				
							
	}
	

	/**�鿴��Ӧ��Ʒ��Ϣ
	 * 
	 */
public static void show_GongYin(){
	System.out.println("��Ӧ��Ʒ��Ϣ��    ��   "+hp.size()+"  ������");
	for (GongYinShang hpKey : hp.keySet()) {
		String dateValue = hp.get(hpKey);
System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");			
System.out.println("��Ʒ��ţ�"+hpKey.getPno()+",��Ʒ���ƣ�"+hpKey.getPname()+",��Ʒ������"+hpKey.getPdetail()+",��Ʒ������"+hpKey.getPnum()+",��Ʒ�۸�"+hpKey.getPrice()+",��Ӧ����ϵ��ʽ��"+hpKey.getPtel()+",��Ӧ�����ƣ�"+hpKey.getCompany()+",���ʱ�䣺"+dateValue);
		}	
}

/**ϵͳ��ڽ���
 * 
 */
public static void welcome(){
	Init_GongYin();//��ʼ����Ӧ��Ʒ��Ϣ
	Scanner sc6=new Scanner(System.in);
	while(true)
	{
		System.out.println("**************************************************************************************");	
	    System.out.println("\n********��ӭʹ�ó��й���СƱϵͳ*********");
	    System.out.println("\n��ѡ�� 1������Ա�˺ŵ�½            2���˳�ϵͳ");
	    System.out.println("\n**************************************************************************************");	
	    
	    try{
	    	
		    int cho=sc6.nextInt();
		    if(cho==1)
		    {
		    	Login_ad();	//��½����Ա�˺ŵķ���
		    	break;
		    }
		    else if(cho==2)
		    {
		    	Quit();//�˳�ϵͳ�ķ���
		    }
		    else
		    	System.out.println("�������������1����2ѡ�����\n");
		    
	    }catch(Exception e){
	    	System.out.println("�������ݲ��Ϸ�������������1����2��\n");
	    	sc6.next();
	    }    
	}    
}	

/**�˳�ϵͳ�ķ���
 * 
 */
	public static void Quit() {
   System.out.println("��ӭ�ٴ�ʹ�ó��й���СƱϵͳ��������������������������������������������������������������������������������");	
   System.exit(0);
}
	
	/**�˵�����ģ��ķ���
	 * 
	 * @param ad  ������Ա�˺�
	 */
	public static void Bill_menu(String ad) {
		GoodsItem gt=new GoodsItem();//ʵ����һ����Ʒ����
		gt.menu(hp,ad);//�����˵�ģ��ķ���
}
	
	/**��Ӧ��Ʒ��Ϣ����ģ��ķ���
	 * 
	 * @param ad  ������Ա�˺�
	 */
	public static void GongYin_menu(String ad) {
		 Scanner sc7=new Scanner(System.in);
		while(true)
		{
		  boolean b=false;//�Ƿ��˳���ģ��ı�־
			System.out.println("\n��Ӧ��Ʒ��Ϣ����ģ�顪����������������������������������������������������������������������������������������������\n");	
		  System.out.println("��ѡ��    1���鿴��Ʒ��Ϣ         2�������Ʒ��Ϣ        3��������Ʒ       4���˳�ģ�� \n");
		 
		  try{
			  int n=sc7.nextInt();
			  switch(n)
			  {
			  case 1:show_GongYin();break;        //�鿴��Ʒ��Ϣ
			  case 2:TianJia_GongYin();break;		//��ӹ�Ӧ��Ʒ��Ϣ
			  case 3:Seek_GongYin();break;          //������Ʒ��Ϣ
			  case 4:b=true;break;                  //�˳���ģ��
			  default: System.out.println("������1-4֮�������ѡ�����\n");break;
			  }	
			  if(b)
				  break;
		  }catch(Exception e){
			  System.out.println("���벻�Ϸ�������������!");
			  sc7.next();
		  }		  
		}
}
	
	/**��½����Ա�˺�
	 * 
	 */
	public static void Login_ad() {
	HashMap<String,String> user_a=new HashMap<>();//�������Ա��½�˺ź�����
	/*��������Ա�˺Ŷ����Ե�½*/
	user_a.put("zhangsan", "123");
	user_a.put("lisi", "456");
	user_a.put("wanger", "789");
	int count=3;//��������˺ź�����Ĵ���������û�ֻ�����ε��������	
	Scanner sc8=new Scanner(System.in);
	do{					
		if(count==0)
		{
			System.out.println("������Ĵ�������Ѵ����ޣ����Ժ����ԣ�\n");
			welcome();//����������κ�ص���ӭ����
			break;
		}
		else
		{			
			 boolean b=false;//�ж�������˺ź������Ƿ��뼯���е��˺�����һ��
			System.out.println("����������Ա�˺ź����루�����ʽ���˺ţ����룩����������������������������������������������������������������������\n");
			String admin=sc8.nextLine();//����û�������˺ź�����
			String[] ad=admin.split(",");//���ݶ��Ų���˺ź������ŵ��ַ���������  
			/*��������˺ź�����ļ��ϣ��жϼ����е��˺ź������Ƿ�������������һ��*/
			for(String ha:user_a.keySet())
			{
				String Value=user_a.get(ha);  
				if(ha.equals(ad[0])&&Value.equals(ad[1]))
				{
					count=0; b=true;//��������������˺ź������뼯����ĳһ���˺ź�����һ��ʱ����½�ɹ���������������㣬���ұ�־��ֵΪtrue
					System.out.println("��ӭ����"+ad[0]+"  ��½�ɹ�����������������������������������������������������������������");
					/*������Ա�˺ŵ�½�ɹ��󣬽���������ѡ�����ģ��*/
					while(true)						
				    {
				    System.out.println("\n��ѡ�����ģ�飺     1����Ӧ��Ʒ��Ϣ����ģ��          2���˵�����ģ��           3���˳�ϵͳ\n");
				    try{				    	
					    int No=sc8.nextInt();
					    switch(No){
					    case 1:  GongYin_menu( ad[0]);  break;//���û�����1ʱ�����ù�Ӧ��Ʒ��Ϣ����ģ��ķ���,������Ա�˺Ŵ���ȥ
					    case 2:  Bill_menu(ad[0]);  break;//���û�����2ʱ�������˵�����ģ��ķ���,������Ա�˺Ŵ���ȥ					   
					    case 3:  Quit();    break;//���û�����4ʱ�������˳�ϵͳ�ķ���
					    default: System.out.println("�������������1-3������ѡ�����\n");break;
					    } 					    
				    }catch(Exception e){
				    	System.out.println("�������ݲ��Ϸ�������������ѡ�����ģ�飺\n");
				    	sc8.next();
				    }
				  }
				}
			}
			if(!b)
			{
				// count++;
				System.out.println("�˺Ż��������������"+(--count)+"�������˺ŵĻ���\n"); 
			}
		}	
	}while(true);		
}
	public static void main(String[] args) {
		
		welcome();         //��ӭ����
	    
	}

}
