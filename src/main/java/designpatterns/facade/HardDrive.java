package designpatterns.facade;

public class HardDrive {

	public byte[] read(long lba, int size) {
		System.out.println("HardDrive read...");
		return null;
	}

}
