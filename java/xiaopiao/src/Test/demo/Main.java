package Test.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import Class.demo.GongYinShang;
import Class.demo.GoodsItem;
/**
 * 系统主界面
 */
public class Main {
	static HashMap<GongYinShang,String> hp=new HashMap<>();//存放供应商品的信息
	/**初始化供应商品的信息
	 * 
	 * @return
	 */
	public static HashMap<GongYinShang,String> Init_GongYin()
	{		
		hp.put(new GongYinShang("1001","2B铅笔","支",500.0,2.0,"13214254677","晨光办公文具"), "2013-02-03");
		hp.put(new GongYinShang("2001","猕猴桃","千克",2000.66,10.0,"15268954679","陕西猕猴桃"), "2015-12-08");
		hp.put(new GongYinShang("2002","葡萄干","千克",5000.7,19.0,"18234253625","新疆葡萄干"), "2014-05-06");
		hp.put(new GongYinShang("1004","毛巾","张",6500,26.0,"13214201024","洁丽雅毛巾"), "2014-08-10");
		hp.put(new GongYinShang("1005","面包","个",5000,5.0,"15114252222","达利园面包"), "2018-12-03");
		hp.put(new GongYinShang("1006","西瓜","千克",1500.5,6.0,"13614254227","麒麟瓜"), "2018-12-15");
		hp.put(new GongYinShang("1007","牙膏","支",500,12.0,"15524254670","黑人牙膏"), "2016-11-23");
		hp.put(new GongYinShang("1008","杯子","个",800,21.0,"13614254477","希诺水杯"), "2016-07-02");
		hp.put(new GongYinShang("1009","热水袋","个",500,45.0,"18314254655","泉力热水袋"), "2017-08-04");
		hp.put(new GongYinShang("10010","牛奶","箱",500,79.0,"15514254333","特仑苏牛奶"), "2018-12-30");
		return hp;
	}
	/**判断从键盘上输入的商品编号在库存里是否已经存在同样的商品编号
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
	/**根据商品编号查找库存商品信息，查找成功后可以对其进行修改和删除操作
	 * 
	 */
	public static void Seek_GongYin(){
		Scanner sc1=new Scanner(System.in);
		while(true)
		{
			System.out.println("请输入商品编号查询商品信息,结束查找请输入quit：——————————————————\n");
			boolean b=true;//判断商品是否查找成功的标志
			try{
				String sp=sc1.nextLine();//存放输入的商品编号
				if(sp.equals("quit"))//当输入quit时结束查找，跳出循环
					break;
				/*遍历库存商品信息*/
				for(GongYinShang gy:hp.keySet())
				{
					if(gy.getPno().equals(sp))//当满足条件时表示查找成功，打印商品信息，提示用户修改或删除供应商品信息
					{
						String dateValue=hp.get(gy);  
						b=false;
						System.out.println("商品编号："+gy.getPno()+",商品名称："+gy.getPname()+",商品描述："+gy.getPdetail()+",商品数量："+gy.getPnum()+",商品价格："+gy.getPrice()+",供应商联系方式："+gy.getPtel()+",供应商名称："+gy.getCompany()+",入库时间："+dateValue);
					    System.out.println("修改或删除本条数据信息？   1、修改       2、删除    \n");
					    Scanner sc2=new Scanner(System.in);
					    try{
					    	int n=sc2.nextInt();
					    	if(n==1)
					    	{
					    		Update_GongYin(sp);//调用修改商品信息的方法，将商品号传过去
					    		break;
					    	}
  	
					    	else if(n==2)
					    	{
					    		Delete_GongYin(sp);//调用删除商品信息的方法，将商品号传过去
					    		break;
					    	}					    					    						    		
					    	else
					    	{
					    		System.out.println("没有此选项！\n");
					    		break;
					    	}					    		
					    	
					    }catch(Exception e)
					    {
					    	System.out.println("您输入的修改选择数据不合法，请重新输入！\n");
					    	sc2.next();
					    }
					}
				}
				if(b)
				{
					System.out.println("您输入的商品编号没有查找到!\n");
				}
			}catch(Exception e )
			{
				System.out.println("您输入的查找数据不合法，请重新输入！\n");
		    	sc1.next();
			}			
		}		
	}
	
	/**根据商品编号修改商品数据信息
	 * 
	 * @param sp
	 */
	public static void Update_GongYin(String sp){		
		Scanner sc3=new Scanner(System.in);
		boolean b=false;//修改商品信息是否成功的标志
		while(true)
		{
			System.out.println("您要修改的商品是编号为：  "+sp+"   退出修改请输入quit\n");
			System.out.println("请输入修改数据（商品名称，商品计价单位，商品数量，商品价格，供应商联系方式,供应商名称）\n");
		try{
			String str=sc3.nextLine();
			if(str.equals("quit"))
			{
				break;
			}
			String[] gy_update=str.split(",");//将输入的修改商品信息以逗号将商品参数拆分出来存放到字符串数组中
			String pnumGex="0|([1-9][0-9]{0,16})|(([1-9][0-9]{0,10})+\\.([0-9]\\d{0,5}))|(0+\\.([0-9]\\d{0,5}))";//浮点型数据的正则（最长16位）,小数点保留5位			
			if(!gy_update[2].matches(pnumGex)||gy_update[3].matches(pnumGex))
			{
				System.out.println("商品数量和单价输入不合法！\n");
				continue;
			}																	
			String ptelGex="1[358]\\d{9}";//手机号正则表达式
			if(!gy_update[4].matches(ptelGex))//判断输入的手机号与正则表达式是否匹配
			{
				System.out.println("供应商联系号码输入不合法！请重新输入完整合法的数据\n");
				continue;
			}	
			/*遍历供应商品信息的集合，查找到要修改的商品编号，修改商品参数，修改后跳出for循环*/
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
				System.out.println("修改成功！\n");
				break;
			}
		}catch(Exception e)
		{
			System.out.println("您输入的修改数据不合法，请重新输入！\n");
			sc3.next();
		}
	  }
	}	
	
	/**根据商品编号删除商品数据信息
	 * 
	 * @param sp
	 */
	public static void Delete_GongYin(String sp)
	{
		System.out.println("确定要删除？  Y、是       N、否\n");
		Scanner sc4=new Scanner(System.in);
		try{
			String sn=sc4.next();
			if(sn.equals("Y"))
			{
				/*遍历供应商品信息，查找到要删除的商品编号，将商品删除，跳出for循环*/
				for(GongYinShang gys:hp.keySet())
				{
					if(gys.getPno().equals(sp))
					{																	
						hp.remove(gys);						
						break;
					}
				}
				System.out.println("删除成功!\n");
			}
			else if(sn.equals("N"))
			{
				System.out.println("已取消删除！\n");
			}
			else
				System.out.println("没有此选项！\n");
		}catch(Exception e){
			System.out.println("您输入的数据不合法！\n");
			sc4.next();
		}
	}
	

	/**添加供应商品信息
	 * 
	 */
	public static void TianJia_GongYin() {												              		
		System.out.println("请输入供应商品信息：（商品编号，商品名称，商品计价单位，商品数量，商品价格，供应商联系方式,供应商名称）,以quit结束输入");									
				do{
					Scanner sc5=new Scanner(System.in);
					try{
				    String gyxx=sc5.nextLine();//存放从键盘上输入的商品信息
				    if(gyxx.equals("quit"))	//当用户输入quit时，退出添加商品的循环模块
				    {
				    	System.out.println("添加完成!");
				    	break;	
				    }				    				    
					String[] gy=gyxx.split(",");//拆分商品信息字符串，将拆分后的商品参数存放到字符串数组中
					String pno=gy[0];//商品编号
					if(!IsExis(pno))//如果输入的商品编号已经存在库存商品集合中，则不添加商品信息，进行下一次的添加商品循环操作
					{
						System.out.println("您输入的商品编号已经添加了，请不要重复添加!\n");
						continue;
					}
					else//商品编号没有添加到供应商品集合中则添加商品
					{
						String pname=gy[1];//商品名称
						String pdetail=gy[2];//商品计价单位
						String pnumGex="0|([1-9][0-9]{0,16})|(([1-9][0-9]{0,10})+\\.([0-9]\\d{0,5}))|(0+\\.([0-9]\\d{0,5}))";//浮点型数据的正则（最长16位）,小数点保留5位						
						if(!(gy[3].matches(pnumGex)||gy[4].matches(pnumGex)))
						{
							System.out.println("商品数量和单价输入不合法！\n");
							continue;
						}
						double pnum=Double.parseDouble(gy[3]);//商品数量
						double price=Double.parseDouble(gy[4]);	//商品单价											
						String ptel=gy[5];	//供应商联系号码
						String ptelGex="1[358]\\d{9}";//手机号正则表达式
						if(!ptel.matches(ptelGex))//供应商号码不匹配正则时则不添加商品，结束本次商品添加操作，进行下一次商品的添加
						{
							System.out.println("供应商联系号码输入不合法！请重新输入完整合法的数据\n");
							continue;
						}
						String company=gy[6];//供应商名称
						/*添加商品的日期*/
						Date da=new Date();
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						String dat=sdf.format(da);
						/*添加供应商品到集合中*/
				        hp.put(new GongYinShang( pno, pname, pdetail, pnum, price, ptel,company),dat);
					}					
					
					}catch(Exception e){
						System.out.println("输入不完整!");
						//sc5.next();//sc定义在循环之内可以省略？
					}		
				  }while(true);				
							
	}
	

	/**查看供应商品信息
	 * 
	 */
public static void show_GongYin(){
	System.out.println("供应商品信息：    共   "+hp.size()+"  条数据");
	for (GongYinShang hpKey : hp.keySet()) {
		String dateValue = hp.get(hpKey);
System.out.println("——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");			
System.out.println("商品编号："+hpKey.getPno()+",商品名称："+hpKey.getPname()+",商品描述："+hpKey.getPdetail()+",商品数量："+hpKey.getPnum()+",商品价格："+hpKey.getPrice()+",供应商联系方式："+hpKey.getPtel()+",供应商名称："+hpKey.getCompany()+",入库时间："+dateValue);
		}	
}

/**系统入口界面
 * 
 */
public static void welcome(){
	Init_GongYin();//初始化供应商品信息
	Scanner sc6=new Scanner(System.in);
	while(true)
	{
		System.out.println("**************************************************************************************");	
	    System.out.println("\n********欢迎使用超市购物小票系统*********");
	    System.out.println("\n请选择： 1、收银员账号登陆            2、退出系统");
	    System.out.println("\n**************************************************************************************");	
	    
	    try{
	    	
		    int cho=sc6.nextInt();
		    if(cho==1)
		    {
		    	Login_ad();	//登陆收银员账号的方法
		    	break;
		    }
		    else if(cho==2)
		    {
		    	Quit();//退出系统的方法
		    }
		    else
		    	System.out.println("输入错误！请输入1或者2选择服务：\n");
		    
	    }catch(Exception e){
	    	System.out.println("输入数据不合法！请输入数字1或者2：\n");
	    	sc6.next();
	    }    
	}    
}	

/**退出系统的方法
 * 
 */
	public static void Quit() {
   System.out.println("欢迎再次使用超市购物小票系统————————————————————————————————————————");	
   System.exit(0);
}
	
	/**账单管理模块的方法
	 * 
	 * @param ad  ：收银员账号
	 */
	public static void Bill_menu(String ad) {
		GoodsItem gt=new GoodsItem();//实例化一个商品对象
		gt.menu(hp,ad);//调用账单模块的方法
}
	
	/**供应商品信息管理模块的方法
	 * 
	 * @param ad  ：收银员账号
	 */
	public static void GongYin_menu(String ad) {
		 Scanner sc7=new Scanner(System.in);
		while(true)
		{
		  boolean b=false;//是否退出本模块的标志
			System.out.println("\n供应商品信息管理模块————————————————————————————————————————————————\n");	
		  System.out.println("请选择：    1、查看商品信息         2、添加商品信息        3、查找商品       4、退出模块 \n");
		 
		  try{
			  int n=sc7.nextInt();
			  switch(n)
			  {
			  case 1:show_GongYin();break;        //查看商品信息
			  case 2:TianJia_GongYin();break;		//添加供应商品信息
			  case 3:Seek_GongYin();break;          //查找商品信息
			  case 4:b=true;break;                  //退出本模块
			  default: System.out.println("请输入1-4之间的数据选择服务！\n");break;
			  }	
			  if(b)
				  break;
		  }catch(Exception e){
			  System.out.println("输入不合法，请输入数字!");
			  sc7.next();
		  }		  
		}
}
	
	/**登陆收银员账号
	 * 
	 */
	public static void Login_ad() {
	HashMap<String,String> user_a=new HashMap<>();//存放收银员登陆账号和密码
	/*三个收银员账号都可以登陆*/
	user_a.put("zhangsan", "123");
	user_a.put("lisi", "456");
	user_a.put("wanger", "789");
	int count=3;//存放输入账号和密码的错误次数，用户只有三次的输入机会	
	Scanner sc8=new Scanner(System.in);
	do{					
		if(count==0)
		{
			System.out.println("你输入的错误次数已达上限，请稍后再试！\n");
			welcome();//输入错误三次后回到欢迎界面
			break;
		}
		else
		{			
			 boolean b=false;//判断输入的账号和密码是否与集合中的账号密码一致
			System.out.println("请输入收银员账号和密码（输入格式：账号，密码）：——————————————————————————————————\n");
			String admin=sc8.nextLine();//存放用户输入的账号和密码
			String[] ad=admin.split(",");//根据逗号拆分账号和密码存放到字符串数组中  
			/*遍历存放账号和密码的集合，判断集合中的账号和密码是否与键盘上输入的一致*/
			for(String ha:user_a.keySet())
			{
				String Value=user_a.get(ha);  
				if(ha.equals(ad[0])&&Value.equals(ad[1]))
				{
					count=0; b=true;//当键盘上输入的账号和密码与集合中某一个账号和密码一致时，登陆成功，将错误次数清零，查找标志赋值为true
					System.out.println("欢迎您，"+ad[0]+"  登陆成功————————————————————————————————");
					/*当收银员账号登陆成功后，进入主界面选择服务模块*/
					while(true)						
				    {
				    System.out.println("\n请选择服务模块：     1、供应商品信息管理模块          2、账单管理模块           3、退出系统\n");
				    try{				    	
					    int No=sc8.nextInt();
					    switch(No){
					    case 1:  GongYin_menu( ad[0]);  break;//当用户输入1时，调用供应商品信息管理模块的方法,将收银员账号传过去
					    case 2:  Bill_menu(ad[0]);  break;//当用户输入2时，调用账单管理模块的方法,将收银员账号传过去					   
					    case 3:  Quit();    break;//当用户输入4时，调用退出系统的方法
					    default: System.out.println("输入错误！请输入1-3的数字选择服务：\n");break;
					    } 					    
				    }catch(Exception e){
				    	System.out.println("输入数据不合法！请输入数字选择服务模块：\n");
				    	sc8.next();
				    }
				  }
				}
			}
			if(!b)
			{
				// count++;
				System.out.println("账号或密码错误！您还有"+(--count)+"次输入账号的机会\n"); 
			}
		}	
	}while(true);		
}
	public static void main(String[] args) {
		
		welcome();         //欢迎界面
	    
	}

}
