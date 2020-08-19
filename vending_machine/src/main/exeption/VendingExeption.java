package main.exeption;

public abstract class VendingExeption extends Throwable{
	private String message;

	protected VendingExeption(String msg) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.message = msg;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
