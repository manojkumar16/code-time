package designpatterns.facade;

public class ComputerFacade {
	private CPU processor;
	private Memory ram;
	private HardDrive hd;

	public ComputerFacade() {
		this.processor = new CPU();
		this.ram = new Memory();
		this.hd = new HardDrive();
	}

	public void start() {
		long BOOT_ADDRESS = 12345678l;
		long BOOT_SECTOR = 88888l;
		int SECTOR_SIZE = 1024;

		processor.freeze();
		ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
		processor.jump(BOOT_ADDRESS);
		processor.execute();
	}
}
