package main.machine;

import java.util.List;

import main.exeption.VendingExeption;
import main.goods.Goods;

public interface VendMachine {

	// 商品関連
	/**
	 * 商品の一覧を返す
	 * @return
	 */
	public List<Goods> getGoodsList();

	/**
	 * 選択した番号の商品を返す
	 * @param itemNum
	 * @return
	 * @throws VendingExeption
	 */
	public Goods getGoods(Integer itemNum) throws VendingExeption;

	/**
	 * 商品リストを返す
	 * @return 商品リスト
	 */
	List<String> getGoodsListMessage();
}
