package main.machine;

public interface CoinControl {

	// 入金関連
	/**
	 * 入金処理
	 * @param coin
	 */
	void inputCoin(Integer coin);

	/**
	 * 出金処理
	 * @param coin
	 */
	void subCoin(Integer coin);

	/**
	 * @return 現在の投入金額を返す
	 */
	Integer getTotalCoin();

	/**
	 * 金額リセット(お釣りを返す)
	 */
	public void RejectCoin();

	/**
	 * 入金額が購入可能額を満たしているか判定
	 * @param price
	 * @return 購入可能ならtrueを返す
	 */
	Boolean isBuy(Integer price);

}