package com.tek.interview.question;

import java.util.ArrayList;
import java.util.List;

class Order {

	private List<OrderLine> orderLines = new ArrayList<>();

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public void add(OrderLine o) throws Exception {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(o);
	}

	public int size() {
		return orderLines.size();
	}

	public OrderLine get(int i) {
		return orderLines.get(i);
	}

	public void clear() {
		this.orderLines.clear();
	}
	
	//Moved the logic to calculate tax from Calculator class to Order class
    //since it is done on Order
	public Double getTax() {
        Double tax = 0d;
        for(OrderLine or : orderLines){
            tax = tax + or.getItem().getTax();
        }
        return Calculator.rounding(tax);
    }

	//Moved the logic to calculate total price from Calculator class to Order class
    //since it is done on Order
    public Double getTotalPrice() {
        Double totalPrice = 0d;
        for(OrderLine or : orderLines){
            totalPrice = totalPrice + or.getItem().getTotalPrice();
        }
        return Calculator.rounding(totalPrice);
    }
}
