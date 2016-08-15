package youshan.entity;

public class Account {
	private int id;
	private String sname;
	private double money;
	public Account(int id, String sname, double money) {
		super();
		this.id = id;
		this.sname = sname;
		this.money = money;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
	
		return "{id="+id+",sname="+sname+",money="+money+"}";
	}
	
	
	

}
