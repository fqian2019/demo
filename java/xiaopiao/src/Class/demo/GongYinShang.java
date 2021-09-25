package Class.demo;

import java.util.HashMap;

/**
 * ��Ӧ��Ʒ��Ϣ
 * ��Ӧ�����ƣ�Company,  ��Ӧ��Ʒ���ƣ�Pname,  ��Ӧ��Ʒ�Ƽ۵�λ:Pdetail
 * ��Ӧ��Ʒ������Pnum,   ��Ӧ��Ʒ��ţ� Pno(ֵ��Ψһ��),    ��Ӧ��Ʒ���ۣ�price,  ��Ӧ����ϵ��ʽ��Ptel*/
public class GongYinShang {
private String Company;
private String Pname;
private String Pdetail;
private double Pnum;
private String Pno;
private double Price;
private String Ptel;
public GongYinShang() {
	super();
}
public GongYinShang(String pno, String pname, String pdetail, double pnum,
		 double price, String ptel,String company) {
	super();
	Company = company;
	Pname = pname;
	Pdetail = pdetail;
	Pnum = pnum;
	Pno = pno;
	Price = price;
	Ptel = ptel;
}
public String getCompany() {
	return Company;
}
public void setCompany(String company) {
	Company = company;
}
public String getPname() {
	return Pname;
}
public void setPname(String pname) {
	Pname = pname;
}
public String getPdetail() {
	return Pdetail;
}
public void setPdetail(String pdetail) {
	Pdetail = pdetail;
}
public double getPnum() {
	return Pnum;
}
public void setPnum(double pnum) {
	Pnum = pnum;
}
public String getPno() {
	return Pno;
}
public void setPno(String pno) {
	Pno = pno;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}
public String getPtel() {
	return Ptel;
}
public void setPtel(String ptel) {
	Ptel = ptel;
}

/*��дtoString����*/
@Override
public String toString() {
	return "��Ӧ��Ʒ��Ϣ�� [��Ʒ��ţ�" + Pno+", ��Ʒ���ƣ�" + Pname
			+ ", ��Ʒ������" + Pdetail + ", ��Ʒ������" + Pnum +  
			", ��Ʒ�۸�" + Price + ", ��Ӧ����ϵ��ʽ��" + Ptel + ",��Ӧ�����ƣ�" + Company + "]";
}
/*��дhashCode����
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;	
	result = prime * result + ((Pno == null) ? 0 : Pno.hashCode());	
	return result;
}*/
/*public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Company == null) ? 0 : Company.hashCode());
	result = prime * result + ((Pdetail == null) ? 0 : Pdetail.hashCode());
	result = prime * result + ((Pname == null) ? 0 : Pname.hashCode());
	result = prime * result + ((Pno == null) ? 0 : Pno.hashCode());
	result = prime * result + Pnum;
	long temp;
	temp = Double.doubleToLongBits(Price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((Ptel == null) ? 0 : Ptel.hashCode());
	return result;
}*/
/*��дequals����
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	GongYinShang other = (GongYinShang) obj;
	if (Company == null) {
		if (other.Company != null)
			return false;
	} else if (!Company.equals(other.Company))
		return false;
	if (Pdetail == null) {
		if (other.Pdetail != null)
			return false;
	} else if (!Pdetail.equals(other.Pdetail))
		return false;
	if (Pname == null) {
		if (other.Pname != null)
			return false;
	} else if (!Pname.equals(other.Pname))
		return false;
	if (Pno == null) {
		if (other.Pno != null)
			return false;
	} else if (!Pno.equals(other.Pno))
		return false;
	if (Pnum != other.Pnum)
		return false;
	if (Double.doubleToLongBits(Price) != Double.doubleToLongBits(other.Price))
		return false;
	if (Ptel == null) {
		if (other.Ptel != null)
			return false;
	} else if (!Ptel.equals(other.Ptel))
		return false;
	return true;
}
*/
}
