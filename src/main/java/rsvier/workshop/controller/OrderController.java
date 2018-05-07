package rsvier.workshop.controller;

import java.util.*;

import rsvier.workshop.dao.*;
import rsvier.workshop.domain.*;
import rsvier.workshop.view.*;

public class OrderController extends Controller {

	private OrderView orderView = new OrderView();
	private OrderDAO orderDao = new OrderDAOImp();
	private CustomerController customerController = new CustomerController();

	@Override
	public void runView() {
		orderView.printHeaderMessage();
		orderView.printMenuMessage();
		orderMenuSwitch(orderView.getIntInput());
	}

	public void orderMenuSwitch(int menuNumber) {

		switch (menuNumber) {

		case 1: // Search order

			selectOrderSearchMenuSwitch();

			break;
		case 2: // Place order
			break;
		case 0: // Go back to previous menu

		default:
			orderView.printMenuInputIsWrong();
			runView();
		}
	}

	public void updateOrDeleteOrderSwitch(Order order) {

		if(order == null) {
			orderView.printOrderNotFound();
			runView();

		}	else {

			orderView.printAskUserToUpdateOrDeleteProduct();
			int menuNumber = orderView.getIntInput();

			switch (menuNumber) {

				case 1:// Update order

				case 2: // Delete order

				case 0:// Go back to previous Menu

				default:
					orderView.printMenuInputIsWrong();
					runView();

			}
		}
	}

	public void selectOrderSearchMenuSwitch() {

		orderView.printAskSelectOrder();
		int menuNumber = orderView.getIntInput();

		switch (menuNumber) {
		case 1:// search by order ID
			updateOrDeleteOrderSwitch(searchOrderByOrderId());
			break;
		case 2:// search by customer last name
			updateOrDeleteOrderSwitch(searchOrderByLastName(customerController.searchCustomerByLastName()));
			break;
		case 0: // back to previous menu
			break;
		default: // back to this same menu
			break;
		}
	}

	// Search order by Lastname
	public Order searchOrderByLastName(Person person) {

		List<Order> orderList = null;

		if (person == null) {
			runView();
		} else {

			orderList = orderDao.getAllOrdersFromPerson(person);

			if (orderList.size() == 0) {
				return null;
			}

			if (orderList.size() == 1) {
				System.out.println(orderList.get(0).toString());

				return orderList.get(0);

			} else {

				for (int i = 1; i < orderList.size(); i++) {
					System.out.println("No. " + i + " : " + orderList.get(i - 1).toString());
				}
			}

		}

		return orderList.get(selectOrder() - 1);
	}

	public int selectOrder() {

		orderView.printAskSelectOrder();

		return orderView.getIntInput();
	}

	// Search order by OrderId
	public Order searchOrderByOrderId() {

		orderView.printAskOrderId();

		return orderDao.getOrderById(orderView.getIntInput());
	}

}