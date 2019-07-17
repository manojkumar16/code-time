package designpatterns.facade;

public class MainFacade {

	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
        computer.start();
	}

}
