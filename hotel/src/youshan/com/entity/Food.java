package youshan.com.entity;

public class Food {
	
	/*CREATE TABLE food(
  id INT PRIMARY KEY AUTO_INCREMENT,
  foodName VARCHAR(20),
  foodType_id INT,      -- 外籍到菜系别
  price DOUBLE,
  vipprice DOUBLE,    -- VIP价格
  remark VARCHAR(100), -- 菜的介绍
  img VARCHAR(100),   -- 菜的图片
  CONSTRAINT fk_food_foodType_id FOREIGN KEY(foodType_id) REFERENCES foodType(id)
  
  );
  */
	int id;
	String foodName;
    int foodType_id;//菜的派别 
    double price;//菜的价格
    double vipprice;//会员价
    String remark;//菜的详细介绍
    String img;//保存图片的路径
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodType_id() {
		return foodType_id;
	}
	public void setFoodType_id(int foodType_id) {
		this.foodType_id = foodType_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVipprice() {
		return vipprice;
	}
	public void setVipprice(double vipprice) {
		this.vipprice = vipprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
    
    

}
