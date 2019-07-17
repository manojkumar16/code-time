package designpatterns.decorator;

public class ScrollBarDecorator extends Decorator implements GraphicalComponent {

	public ScrollBarDecorator(GraphicalComponent next) {
		super(next);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint() {
		System.out.println("Rendered the scroll bar...");
		super.paint();
	}
}
