package main.machine;

public class CoinControlImpl implements CoinControl {

	private Integer totalCoin;

	public CoinControlImpl() {
		// TODO 自動生成されたコンストラクター・スタブ
		totalCoin = 0;
	}

	@Override
	public void inputCoin(Integer coin) {
		// TODO 自動生成されたメソッド・スタブ
		totalCoin += coin;
	}

	@Override
	public void subCoin(Integer coin) {
		// TODO 自動生成されたメソッド・スタブ
		totalCoin -= coin;
	}

	@Override
	public Integer getTotalCoin() {
		// TODO 自動生成されたメソッド・スタブ
		return this.totalCoin;
	}

	@Override
	public Boolean isBuy(Integer price) {
		// TODO 自動生成されたメソッド・スタブ
		if(totalCoin >= price) {
			return true;
		}
		return false;
	}

	@Override
	public void RejectCoin() {
		// TODO 自動生成されたメソッド・スタブ
		totalCoin = 0;

	}



}
