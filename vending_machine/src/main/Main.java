package main;

import main.machine.CoinControl;
import main.machine.CoinControlImpl;
import main.machine.MachineMain;
import main.machine.VendMachine;
import main.machine.VendMachineImpl;

public class Main {

	public static void main(String args[]) {
		Main main = new Main();
		main.prgMain();
	}

	private void prgMain() {
		VendMachine vmachine = new VendMachineImpl();
		CoinControl cctrl = new CoinControlImpl();
		MachineMain machine = new MachineMain();

		machine.setCoinctrl(cctrl);
		machine.setVenmachine(vmachine);

		System.out.println("### 自販機プログラム開始 ###");
		machine.menuMain();
		System.out.println("### 自販機プログラム終了 ###");
	}
}
