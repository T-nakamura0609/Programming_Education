package main.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.exeption.NoItemExeption;
import main.exeption.NoMoneyExeption;
import main.exeption.OutOfStockExeption;
import main.exeption.VendingExeption;
import main.goods.Goods;
import main.goods.GoodsFactory;

public class StockManagerImpl implements VendMachine {
	List<GoodsFactory> goodslist;	// 商品ストック
	private CoinControl coinman;

	public StockManagerImpl() {
		// TODO 自動生成されたコンストラクター・スタブ
		goodslist = new ArrayList<GoodsFactory>();
	}

	public void setCoinman(CoinControl coinman) {
		this.coinman = coinman;
	}

	@Override
	public List<Goods> getGoodsList() {
		// TODO 自動生成されたメソッド・スタブ
		List<Goods> list = new ArrayList<>();
		for(GoodsFactory hoge: goodslist) {
			list.add( hoge.createGoods());
		}
		return list;
	}

//	@Deprecated
	@Override
	public List<String> getGoodsListMessage(){
		List<String> msglist = new ArrayList<>();
		// 添字をつけた商品リストメッセージ作成
		int num=1;
		for(GoodsFactory hoge: goodslist) {
			msglist.add(hoge.getGoodsInfo(num++));
		}
		return msglist;
	}

	@Override
	public Goods getGoods(Integer itemNum) throws VendingExeption {

		try {
			GoodsFactory factory = goodslist.get(itemNum-1);
			// 該当アイテム在庫確認
			if(factory.getNow() <= 0) {
				// 在庫切れ
				throw new OutOfStockExeption();
			}

			// 金額確認
			if(!this.coinman.isBuy(factory.getPrice())) {
				// 残高不足
				throw new NoMoneyExeption();
			}

			// 商品排出
			coinman.subCoin(factory.getPrice());
			return factory.createGoods();

		} catch (IndexOutOfBoundsException e) {
			// 選択対象外
			throw new NoItemExeption();
		}
	}

	public void addFactory(GoodsFactory factory) {
		goodslist.add(factory);
	}

	private Map getfactoryinfo(GoodsFactory factory){

		return null;
	}

	public enum ItemInfo{
		NAME,
		PRICE,
		STOCK_NUM
	}

}
