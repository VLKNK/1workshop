package rsvier.workshop.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Order {

	/*
	 * Order has an id, a customer, a total price and a orderdateTime we are
	 * thinking of adding a ArrayList<OrderLine> orderLine; to hold all the
	 * orderliness that are being made by the customer. not sure if it will work yet
	 * we gonna ask jeroen.
	 * 
	 */

	private int orderId;
	private List<OrderLine> totalOrderLines;
	/*
	 * Thought of saving all the OrderLines of 1 order inside of this private List.
	 * Maybe its a ArrayList or LinkedList(Set,Map), When implementing this in the
	 * DAO the idea is to loop true all orderLines, get the Price add it all to one
	 * variable an then add that to the TotalPrice in the Order class. Still need to
	 * think about this, Help me EVA &EVY :D
	 */
	private Customer customer;
	private BigDecimal totalPrice;
	private LocalDateTime orderDateTime = LocalDateTime.now();

	private Order(OrderBuilder builder) {
		this.orderId = builder.orderId;
		this.totalOrderLines = builder.totalOrderLines;
		this.customer = builder.customer;
		this.totalPrice = builder.totalPrice;
		this.orderDateTime = builder.orderDateTime;

	}

	public class OrderBuilder {

		private int orderId;
		private List<OrderLine> totalOrderLines;
		private Customer customer;
		private BigDecimal totalPrice;
		private LocalDateTime orderDateTime = LocalDateTime.now();

		public OrderBuilder() {

		}

		public OrderBuilder id(int orderId) {
			this.orderId = orderId;
			return this;
		}

		public OrderBuilder totalOrderLines(List<OrderLine> totalOrderLines) {
			this.totalOrderLines = totalOrderLines;
			return this;
		}

		public OrderBuilder customer(Customer customer) {
			this.customer = customer;
			return this;
		}

		public OrderBuilder totalPrice(BigDecimal totalPrice) {
			this.totalPrice = totalPrice;
			return this;
		}

		public OrderBuilder orderDateTime(LocalDateTime orderDateTime) {
			this.orderDateTime = orderDateTime;
			return this;
		}

		public Order build() {
			return new Order(this);
		}
	}

	public int getOrderId() {
		return orderId;
	}

	public List<OrderLine> getOrderLine() {
		return totalOrderLines;
	}

	public Customer getCustomer() {
		return customer;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public String getOrderDateTime() {
		return orderDateTime.toString();
	}

	// Override the toString method from the Object class.

	@Override
	public String toString() {
		return getOrderId() + " " + getOrderLine() + getCustomer().getLastName() + getCustomer().getName() + " "
				+ getTotalPrice() + " " + getOrderDateTime();
	}

}