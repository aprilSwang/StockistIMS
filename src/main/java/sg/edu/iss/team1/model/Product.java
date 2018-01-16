package sg.edu.iss.team1.model;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int partNumber;
	private int unitPrice;
	private int quantity;
	private String description;
	private String color;
	private String dimension;
	private String manufacturer;
	private int reorderLevel;
	private int minReorderQnty;
	private String supplierName;
	private String shelfLocation;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int partNumber, int unitPrice, int quantity, String description, String color, String dimension,
			String manufacturer, int reorderLevel, int minReorderQnty, String supplierName, String shelfLocation) {
		super();
		this.partNumber = partNumber;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.description = description;
		this.color = color;
		this.dimension = dimension;
		this.manufacturer = manufacturer;
		this.reorderLevel = reorderLevel;
		this.minReorderQnty = minReorderQnty;
		this.supplierName = supplierName;
		this.shelfLocation = shelfLocation;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public int getMinReorderQnty() {
		return minReorderQnty;
	}

	public void setMinReorderQnty(int minReorderQnty) {
		this.minReorderQnty = minReorderQnty;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (partNumber != other.partNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [partNumber=" + partNumber + ", unitPrice=" + unitPrice + ", quantity=" + quantity
				+ ", description=" + description + ", color=" + color + ", dimension=" + dimension + ", manufacturer="
				+ manufacturer + ", reorderLevel=" + reorderLevel + ", minReorderQnty=" + minReorderQnty
				+ ", supplierName=" + supplierName + ", shelfLocation=" + shelfLocation + "]";
	}

}
