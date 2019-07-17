package designpatterns.decorator;

public class MainDecorator {

	public static void main(String[] args) {
		//GraphicalComponent tf = construct2LineTB();
		GraphicalComponent tf = constructHCAndersenPoem();
		
		//Add a border to text field component
		tf = new BorderDecorator(tf);
		tf.paint();
	}
	
	private static GraphicalComponent construct2LineTB() {
		GraphicalComponent tf = new TextField();
		tf = tf.addContent("To move, to breadth, to fly, to float,");
		tf = tf.addContent("To gain all while you give,");
		return tf;
	}

	private static GraphicalComponent constructHCAndersenPoem() {
		GraphicalComponent tf = new TextField();
		tf = tf.addContent("To move, to breadth, to fly, to float,");
		tf = tf.addContent("To gain all while you give,");
		tf = tf.addContent("To roam the roads of lands remote,");
		tf = tf.addContent("To travel is to leave,");
		tf = tf.addContent("-- H.C. Andersen");

		return tf;
	}

}
