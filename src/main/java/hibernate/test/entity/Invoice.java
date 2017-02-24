package hibernate.test.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import javax.persistence.*;

/*
 * INVOICE Entity - maps to ORDER_INVOICE table
 */
@ToString
@Getter
@Setter
@Entity(name = "ORDER_INVOICE") 
public class Invoice {
	
	@Id //signifies the primary key
	@Column(name = "INVOICE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long invoiceId;

	@Column(name = "AMOUNT_DUE", precision = 2)
	private double amountDue;
	
	@Column(name = "DATE_RAISED")  
	private Date orderRaisedDt;

	@Column(name = "DATE_SETTLED")  
	private Date orderSettledDt;
	
	@Column(name = "DATE_CANCELLED")  
	private Date orderCancelledDt;
	
	@Version
	@Column(name = "LAST_UPDATED_TIME")
	private Date updatedTime;

	@OneToOne(optional=false, targetEntity = Order.class)
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
	private Order order;
	
	public String toString() {
       StringBuffer sb = new StringBuffer();
       sb.append("   invoiceId : " + invoiceId);
       sb.append("   amtDue : " + amountDue);
       sb.append("   orderRaisedDt : " + orderRaisedDt);
       sb.append("   orderSettledDt : " + orderSettledDt);
       sb.append("   orderCancelledDt : " + orderCancelledDt);
       sb.append("   updatedTime : " + updatedTime);
       return sb.toString();
   }
}
