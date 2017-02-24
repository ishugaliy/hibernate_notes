package hibernate.test.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/*
 * PRODUCT Entity - maps to PRODUCT table
 */
@Getter @Setter
@Entity(name = "PRODUCT") 
public class Product {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long prodId;
	
	@Column(name = "PROD_NAME", nullable = false,length = 50)
	private String prodName;
	
	@Column(name = "PROD_DESC", length = 200)
	private String prodDescription;
	
	@Column(name = "REGULAR_PRICE", precision = 2)
	private String price;
	
	@Column(name = "LAST_UPDATED_TIME")
	private Date updatedTime;
	
	@ManyToMany(targetEntity = Order.class, mappedBy="productList", fetch=FetchType.EAGER)
	private List<Order> orderList;

	public String toString() {
       StringBuffer sb = new StringBuffer();
       sb.append("prodId : " + prodId);
       sb.append("   prodName : " + prodName);
       sb.append("   prodDescription : " + prodDescription);
       sb.append("   price : " + price);
       return sb.toString();
    }
}
