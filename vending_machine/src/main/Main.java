package main;

import main.goods.GoodsFactory;
import main.machine.CoinControl;
import main.machine.CoinControlImpl;
import main.machine.MachineMain;
import main.machine.StockManagerImpl;

public class Main {

	public static void main(String args[]) {
		Main main = new Main();
		main.prgMain();
	}

	private void prgMain() {
		CoinControl cctrl = new CoinControlImpl();

//		VendMachine vmachine = new VendMachineImpl();
		StockManagerImpl vmachine = new StockManagerImpl();
		vmachine.addFactory(new GoodsFactory("コーラ", 120, "爽やかなひととき"));
		vmachine.addFactory(new GoodsFactory("ファンタ", 150, "スカっと爽やか"));
		vmachine.addFactory(new GoodsFactory("レッドブル", 250, "翼を授ける"));
		vmachine.setCoinman(cctrl);


		MachineMain machine = new MachineMain();

		machine.setCoinctrl(cctrl);
		machine.setVenmachine(vmachine);

		System.out.println("### 自販機プログラム開始 ###");
		machine.menuMain();
		System.out.println("### 自販機プログラム終了 ###");
	}
}
