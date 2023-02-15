package entity;

public class Product {
	private int id;
	private String name;
	private int categoryId;
	private int stock;
	private String description;
	private double price;
	private String img;

	public Product() {
		super();
	}

	public Product(int id, String name, int categoryId, int stock, String description, double price, String img) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.stock = stock;
		this.description = description;
		this.price = price;
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
