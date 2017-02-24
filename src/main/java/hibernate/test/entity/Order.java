package hibernate.test.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/*
 * Order Entity - maps to ORDERS table
 */
@Getter
@Setter
@Entity(name = "ORDERS") 
public class Order {
	
	@Id 
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "TOTAL_PRICE", precision = 2)
	private double totPrice;
	
	@Column(name = "OREDER_DESC")
	private String orderDesc;
	
	@Column(name = "ORDER_DATE")  
	private Date orderDt;	
	
    @OneToOne(mappedBy="order", targetEntity = Invoice.class, optional=false, cascade=CascadeType.ALL)
	private Invoice invoice;
	
	@ManyToOne(optional = false, targetEntity = Customer.class)
	@JoinColumn(name = "CUST_ID", referencedColumnName = "ID")
	private Customer customer;

	@ManyToMany(targetEntity = Product.class, fetch=FetchType.EAGER)
	@JoinTable(name="ORDER_DETAIL",
			   joinColumns= @JoinColumn(name="ORDER_ID", referencedColumnName="ID"),
	           inverseJoinColumns= @JoinColumn(name="PROD_ID", referencedColumnName="ID")
	)
	private List<Product> productList;
	
	@Version
	@Column(name = "LAST_UPDATED_TIME")
	private Date updatedTime;

	@Override
	public String toString() {
		return "Order{" + "orderId=" + id + "'}'";
	}
}
