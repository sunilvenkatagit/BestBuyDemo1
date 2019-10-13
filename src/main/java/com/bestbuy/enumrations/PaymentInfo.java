package com.bestbuy.enumrations;

public enum PaymentInfo {

	CARD_NUMBER("4537 3390 6359 8989"), MONTH("03"), YEAR("2024"), CVV("438");

	private String value;

	private PaymentInfo(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}