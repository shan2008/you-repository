package youshan.com.entity;

public class Food {
	
	/*CREATE TABLE food(
  id INT PRIMARY KEY AUTO_INCREMENT,
  foodName VARCHAR(20),
  foodType_id INT,      -- �⼮����ϵ��
  price DOUBLE,
  vipprice DOUBLE,    -- VIP�۸�
  remark VARCHAR(100), -- �˵Ľ���
  img VARCHAR(100),   -- �˵�ͼƬ
  CONSTRAINT fk_food_foodType_id FOREIGN KEY(foodType_id) REFERENCES foodType(id)
  
  );
  */
	int id;
	String foodName;
    int foodType_id;//�˵��ɱ� 
    double price;//�˵ļ۸�
    double vipprice;//��Ա��
    String remark;//�˵���ϸ����
    String img;//����ͼƬ��·��
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
