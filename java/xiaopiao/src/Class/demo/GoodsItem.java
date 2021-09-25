package Class.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**货物对象，成员变量（货号: Goods_No、名称:Goods_Name、单价:Goods_Price、数量:Goods_Num、计价单位:Goods_Pe、金额:Goods_SumPrice）
         *  功能方法（）*/
public class GoodsItem {
	/*定义成员属性，初始化成员变量，提供接口供外部访问*/
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

/*功能方法*/

static LinkedList<GoodsItem> ListGoods=new LinkedList<>();//存放打印购物商品信息的集合
static double PayIn=0.0;//存放付款金额

/**购物结账菜单方法
 * 
 * @param hp ：供应商品信息的集合
 * @param ad ：收银员账号
 */
public void menu(HashMap<GongYinShang,String> hp,String ad){//将库存的物品和收银员账号传过来
	ListGoods.clear();//每次进入购物模块清空购物商品集合里的信息
	Scanner sc9=new Scanner(System.in);	
	while(true)
	{			
		boolean b=false;//退出购物模块的标志
		System.out.println("\n购物账单管理模块：——————————————————————————————————————\n");
		System.out.println("\n请选择：    1、输入购买物品信息      2、打印购物小票       3、退出模块       4、退出系统\n");		
		try{
			int n=sc9.nextInt();			 
			switch(n){
			case 1:PayIn=GoodsInput(hp,ad);break;//输入购买物品信息的方法，将库存的物品、购买的物品，收银员账号传过去
			case 2:GoodsPrint(ad,PayIn);break;//打印购物小票的方法，将存放购买物品的集合和收银员账号传过去
			case 3:b=true;break;//退出购物模块
			case 4:Quit();break;//退出系统
			default:System.out.println("请输入1-4之间的数据选择服务！");break;
			}
			if(b)
				break;
		}catch(Exception e){
			System.out.println("您输入的数据不合法，请重新输入menu！");
			sc9.next();
		}	
		
	}
}
/**输入购买物品信息的方法
 * @param hp ；供应商品信息的集合
 * @param ad ：收银员账号
 * @return  ：付款金额
 */
public double GoodsInput(HashMap<GongYinShang,String> hp,String ad){	
Scanner sc10=new Scanner(System.in);
System.out.println("\n请输入结账物品信息：（物品编号，物品数量）,以quit结束输入\n");
String goods;//存放输入的物品信息
double inmo;//存放输入的付款金额
double sumP=0.0;//存放商品的累计金额
while(true)
 {		
	try{ 
	  goods=sc10.next();	  	  		
	 boolean b=false;//判断输入的商品在供应商品中是否存在的标志
	 if(goods.equals("quit"))//当输入quit结束购买商品信息的输入时执行此if代码块
	 {
		if(sumP==0.0)
		{
			System.out.println("您本次还未录入购买商品的数据信息！\n");
			return sumP;			
		}
		 System.out.println("您本次购买的物品数据共有：    "+ListGoods.size()+"   条");	
		Scanner sc11=new Scanner(System.in);
		/*输入付款金额，当输入的付款金额合法时结束此while代码块的执行*/
		while(true)
		{
			 inmo=-1.0;
		    try{
		    	System.out.println("您本次购物的累计金额为："+sumP+"  元,  请输入付款金额:\n");
		    	 inmo=sc11.nextDouble();
		    	 if(inmo<sumP)
		    	 {
		    		 System.out.println("输入的付款金额不能小于"+sumP+"元，请重新输入!\n");
		    		 continue; 
		    	 }
		    	 else
		    		 System.out.println("付款完成，购买成功!\n");
		    	 if(inmo!=-1.0)
				    	break;
			    }catch(Exception e){
			    	System.out.println("非法输入！");
			    	sc11.next();
			    }		    		
		 }		
		return inmo;	
	 }

	 String[] goods1=goods.split(",");	//将输入的字符串以逗号拆分出商品编号和商品数量存放到goods1字符串数组中	 
	 /*遍历存放供应物品的集合*/	
	 for (GongYinShang hpKey : hp.keySet()) 
	 {		 		 
			if(goods1[0].equals(hpKey.getPno()))//当输入的物品编号在库存中存在时执行if里面的代码块，将输入的商品存放到打印购物商品的集合中
			{
				b=true;//当输入的商品在供应商品中存在时的标志
				double gmsl=Integer.parseInt(goods1[1]);//存放输入的物品购买数量
				double kc=hpKey.getPnum();//存放物品库存数量
				if(gmsl<=kc)//当购买数量小于等于库存时执行此if代码块
				{   boolean k=false;//判断添加的商品在要打印的商品集合中是否存在的标志
				
					/*遍历存放打印购物商品的集合，查找要存入的的商品编号是否已经添加到打印购物商品的集合中，
					 * 如果已经添加了，则直接累加此商品编号的购买数量和商品累计金额*/
					for(GoodsItem gtm:ListGoods)
					{
						if(goods1[0].equals(gtm.getGoods_No()))
						{
							k=true;  gtm.setGoods_Num(gtm.getGoods_Num()+gmsl);
							gtm.setGoods_SumPrice(gtm.getGoods_SumPrice()+gmsl*gtm.getGoods_Price());
							break;
						}
					}
					/*当遍历完打印购物商品的集合时，k=false时，
					 * 表示要添加的商品编号在打印购物商品的集合中没有查找到，则将其添加到集合中去*/
					if(!k)
					{
						ListGoods.add(new GoodsItem(goods1[0],hpKey.getPname(),hpKey.getPrice(),gmsl,hpKey.getPdetail(),gmsl*hpKey.getPrice()));									   	
					}
					sumP+=gmsl*hpKey.getPrice();//购买商品后累计购物金额
					hpKey.setPnum(hpKey.getPnum()-gmsl);//购买后修改商品库存量								
				}
				else
				{
					System.out.println(goods1[0]+"  号物品库存量不足,最多只能购买"+hpKey.getPnum()+hpKey.getPdetail()+"\n");
					break;
				}
			}			
	 }
	 if(!b)//当遍历完供应物品的集合，b=false时，表示要打印的商品信息没有在供应物品的集合中没有查找到，给出提示输出
	 {
			System.out.println("\n您输入的商品不存在！\n");
			continue;
	 }
	}catch(Exception e){
		System.out.println("您输入的结账物品的数据不合法！\n");
		sc10.next();
	}
  }

}
/**打印购物小票的方法
 * 
 * @param ad ：收银员账号
 * @param inmo ：付款金额
 */
public  void GoodsPrint(String ad,double inmo){	
if(ListGoods.size()==0)	
 {
	System.out.println("打印物品信息为空，请输入购买物品信息后再打印\n");
	//Quit();
 }
else
 {	
	/*票头部分*/	
	System.out.println("收银员："+ad);
	StringBuilder pt=new StringBuilder();
	pt.append("            欢     迎     光      临                          \n");
	pt.append("    品    名              售 价      数 量      金 额      \n");
	pt.append("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ __ _ _ _ _ _\n");
	
	double sum=0.0;//购买商品的总金额
	double count=0.0;//购买商品的总数量			
	/*票体部分，遍历要打印的购买商品的集合*/
	for(GoodsItem gt:ListGoods)
	{		
		sum+=gt.getGoods_SumPrice();//累加商品的金额
		count+=gt.getGoods_Num();//累加商品的数量	
		
		/*通过StringBuilder的append方法拼接字符串，将每条商品的打印数据拼接起来*/
		pt.append(gt.getGoods_Name()).append("                    ").append(gt.Goods_Price).append(" * ").append(gt.getGoods_Num()).append("\n");
		pt.append("(").append(gt.Goods_No).append("      )=               ").append(gt.Goods_SumPrice).append("\n");
		
	}
	
	/*票尾部分*/	    	
			Date date=new Date();
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd-001-01-989     hh:mm:ss");
		    String date1=sdf.format(date);			
			pt.append("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ __ _ _ _ _ _\n").append(ListGoods.size()).append("   项商品    ").append("  共计：  ");
			pt.append(count).append("  件\n").append("总计：  ").append(sum).append("\n实付：  ").append(inmo).append("        找零:    ");	
			pt.append(inmo-sum).append("\n").append(date1).append("\n").append("凭此小票换取发票！");
			System.out.println(pt.toString());
			OutSb(pt.toString());	//	  调用小票输出方法
 }
}
/**
 * 将小票信息输出到一个word文件中
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
 * 退出系统的方法
 */
public void Quit(){
	System.out.println("——————————————————————————欢迎再次使用超市购物小票系统———————————————————————————————");
	System.exit(0);
}
}
