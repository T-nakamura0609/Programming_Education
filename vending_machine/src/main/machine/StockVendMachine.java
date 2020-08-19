package main.machine;

import java.util.List;

public interface StockVendMachine extends VendMachine {


	/**
	 * 商品リストを返す
	 * @return 商品リスト
	 */
	List<String> getGoodsListMessage();
}
