package rsvier.workshop.controller;

import rsvier.workshop.domain.*;
import rsvier.workshop.view.EmployeeView;
import rsvier.workshop.controller.MainController.TypeOfController;
import rsvier.workshop.view.View;

public class EmployeeController extends Controller{
	
	private EmployeeView employeeView = new EmployeeView();
	
	
	@Override
	public void runView() {
		
		employeeView.printHeaderMessage();
		employeeView.printMenuMessage();
		employeeMenuSwitch(employeeView.getIntInput());
		
	}

	
	public void  employeeMenuSwitch(int menuNumber) {
		
		switch (menuNumber) {

			case 1:	//Klanten beheren
					MainController.setController(TypeOfController.CUSTOMER);
					break;

			case 2: //producten beheren
					MainController.setController(TypeOfController.PRODUCT);
					break;
			
			case 3:	//bestellingen beheren
				MainController.setController(TypeOfController.ORDER);
					break;
			case 0:	//Exit Menu
					
					MainController.setController(TypeOfController.MAINMENU);
			
					break;
			
			default:
					employeeView.printMenuInputIsWrong();
					runView();
				
					break;
		}
	}
}
