package main.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.exeption.VendingExeption;
import main.goods.Goods;
import main.menue.CommandMenue;

/**
 * 自販機本体
 * @author nakamuratakasi
 *
 */
public class MachineMain {

	private VendMachine venmachine;
	private CoinControl coinctrl;

	public MachineMain() {

	}


	public void setVenmachine(VendMachine venmachine) {
		this.venmachine = venmachine;
	}


	public void setCoinctrl(CoinControl coinctrl) {
		this.coinctrl = coinctrl;
	}


	public void menuMain() {
		// コマンド選択
		boolean flg = true;
		while(flg) {
			CommandMenue cmd = command();
			switch(cmd) {
			case Exit:
				//
				flg = false;
				break;

			case ChoiceItem:
				Goods item = choiceItem();
				if(item != null) {
					openItem(item);
				}

				break;
			case InputCoin:
				coinCommand();
				break;

			}
		}

	}

	/**
	 * 操作選択
	 * @return
	 */
	private CommandMenue command() {
		// 商品一覧表示
		System.out.println("################");
		System.out.println("");

		System.out.println("### 操作を選んでください ###");
		System.out.println("0:終了する");
		System.out.println("1:入金する");
		System.out.println("2:商品を選ぶ");
		System.out.println("3:商品管理");
		System.out.print(">");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer reslt=null;
		try {
			String str = br.readLine();
			reslt = Integer.valueOf(str);
		} catch (IOException e) {
			e.printStackTrace();
			return CommandMenue.Exit;
		}

		switch(reslt) {
		case 0: return CommandMenue.Exit;
		case 1: return CommandMenue.InputCoin;
		case 2: return CommandMenue.ChoiceItem;
		case 3: return CommandMenue.Maintenance;
		default: return CommandMenue.Exit;
		}
	}

	/**
	 * 入金処理
	 */
	private void coinCommand() {
		System.out.println("");
		System.out.println("### 入金額を入れてください ###");
		System.out.print(">");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer reslt=0;
		try {
			String str = br.readLine();
			reslt = Integer.valueOf(str);
		} catch (IOException e) {
			e.printStackTrace();
			reslt=0;
		}catch(NumberFormatException ne) {
			System.out.println("### 数字を入力してください！ ###");
			reslt=0;
		}
		coinctrl.inputCoin(reslt);

		System.out.println("現在の入金額は" + coinctrl.getTotalCoin() + "円です");

	}

	/**
	 * 商品選択
	 * @return
	 */
	private Goods choiceItem() {
		Integer item;

		while (true) {
			System.out.println("### 商品を選んでください ###");
			System.out.println("0:選択をやめる");
			System.out.println("################");
			int num = 1;
			for (String iteminfo : venmachine.getGoodsListMessage()) {
				System.out.println(iteminfo);
			}
			System.out.println("################");
			System.out.println("現在の入金額は" + coinctrl.getTotalCoin() + "円です");
			System.out.print(">");
			// コンソール入力
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String str = br.readLine();
				item = Integer.valueOf(str);
			} catch (IOException e) {
				e.printStackTrace();
				item = 0;
			} catch (NumberFormatException e) {
				item = 0;
			}
			if (item == 0) {
				// 商品選択とりやめ
				return null;
			}

			try {
				Goods goods = venmachine.getGoods(item);
				return goods;
			} catch (VendingExeption e) {
				// 商品を選べなかった場合は再度商品選択へ戻る
				System.out.println(e.getMessage());
				System.out.println();
			}
		}

	}

	// 商品開封
	private void openItem(Goods goods) {
		while (true) {
			int item;
			System.out.println("選んだ商品はこれです:" + goods.getName());
			System.out.println("### 商品をあけますか？ ###");
			System.out.println("0:あけない");
			System.out.println("1:あける");
			System.out.print(">");
			// コンソール入力
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String str = br.readLine();
				item = Integer.valueOf(str);
			} catch (IOException e) {
				e.printStackTrace();
				item=0;
			} catch (NumberFormatException e) {
				item=0;
			}

			if (item == 0) {
				// 商品選択とりやめ
				return;
			}else if(item == 1) {
				System.out.println("中身は:" + goods.open());
				return;
			}
		}

	}
	
	private void maintenance() {
		// 現在の在庫数一覧表示
		// 補充したい商品選択
		// 補充
	}

}
