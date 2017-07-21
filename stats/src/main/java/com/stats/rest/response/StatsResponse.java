package com.stats.rest.response;

import java.math.BigInteger;

public class StatsResponse {

	@Override
	public String toString() {
		return "StatsResponse [sum=" + sum + ", avg=" + avg + ", max=" + max + ", min=" + min + ", count=" + count
				+ "]";
	}

	private double sum;

	private double avg;

	private double max;

	private double min;

	private BigInteger count;

	public StatsResponse() {
		// TODO Auto-generated constructor stub
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public BigInteger getCount() {
		return count;
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

}
