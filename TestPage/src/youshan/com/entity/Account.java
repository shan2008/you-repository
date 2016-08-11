package youshan.com.entity;

public class Account {
   private int id; //idºÅ
   private String sname;//Ãû×Ö
   private Double money;
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public Double getMoney() {
	return money;
}
public void setMoney(Double money) {
	this.money = money;
}
@Override
public String toString() {
	return "[ id="+id+" sname="+sname+ " money="+money+"]";
} 
   
	
	
}
