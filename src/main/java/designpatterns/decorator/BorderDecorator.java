package designpatterns.decorator;

public class BorderDecorator extends Decorator {

	public BorderDecorator(GraphicalComponent next) {
		super(next);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint() {
		System.out.println("Could have rendered border here...");
		super.paint();
		System.out.println("Should probably render the border here...");
	}

}
