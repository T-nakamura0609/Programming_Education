package main.goods;

public class GoodsFactory {
	private int max; // 最大在庫数
	private int now; // 現在在庫数

	private String name;
	private Integer price;
	private String infometion;

	public GoodsFactory(String name, Integer price, String infometion) {
		this.name = name;
		this.price = price;
		this.infometion = infometion;
		max = 10;
		now = max;
	}

	public GoodsFactory(int max, String name, Integer price, String infometion) {
		this(name, price, infometion);
		this.max = max;
		this.now = this.max;
	}



	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

	public int getMax() {
		return max;
	}

	public int getNow() {
		return now;
	}

	public String getGoodsInfo() {
		return " | " + price + " | " + name + " |";
	}

	public String getGoodsInfo(int num) {
		return "| " + num + " | " + price + " | " + name + " |";
	}

	public Goods createGoods() {
		now--; // 在庫数減算
		return new Goods() {

			@Override
			public String open() {
				// TODO 自動生成されたメソッド・スタブ
				return infometion;
			}

			@Override
			public Integer getPrice() {
				// TODO 自動生成されたメソッド・スタブ
				return price;
			}

			@Override
			public String getName() {
				// TODO 自動生成されたメソッド・スタブ
				return name;
			}

			@Override
			public String getGoodsInfo() {
				// TODO 自動生成されたメソッド・スタブ
				return " | " + price + " | " + name + " |";
			}
		};
	}

}
