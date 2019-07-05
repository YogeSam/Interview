package patterns.structural.visitor;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputerPartsTest {

	@Test
	public void testLaptopAssembly() {
		ComputerParts laptop = new ComputerParts();
		laptop.add(new MousePart());
		laptop.add(new KeyboardPart());
		String strAssembled = laptop.getAssembled();
		assert(strAssembled.length() > 0 && strAssembled.indexOf("Mouse") >= 0 && strAssembled.indexOf("Keyboard") >= 0);
	}

	@Test
	public void testDesktopAssembly() {
		ComputerParts desktop = new ComputerParts();
		desktop.add(new MousePart());
		desktop.add(new KeyboardPart());
		desktop.add(new MonitorPart());
		String strAssembled = desktop.getAssembled();
		assert(strAssembled.length() > 0 && strAssembled.indexOf("Mouse") >= 0 && strAssembled.indexOf("Keyboard") >= 0 && strAssembled.indexOf("Monitor") >= 0);
	}
	
}
