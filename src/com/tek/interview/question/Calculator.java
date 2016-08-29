package com.tek.interview.question;

import java.util.Map;

class Calculator {

	public static double rounding(double value) {
		//Modified to round to 2 decimal places
		return ( Math.round(value*100.0)/100.0);
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			
			Order r = entry.getValue();

			// Iterate through the items in the order
			for (OrderLine orderLine :r.getOrderLines()) {
                // Print out the item's total price
                System.out.println(orderLine.getItem().getDescription() + ": " + orderLine.getItem().getTotalPrice());
            }

            // Print out the total taxes
            System.out.println("Sales Tax: " + r.getTax());

            // Print out the total amount
            System.out.println("Total: " + r.getTotalPrice());
            grandtotal += r.getTotalPrice();
        }
		System.out.println("Sum of orders: " + rounding(grandtotal));
			
	}
}
