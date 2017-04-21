package com.stock.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockPriceHigh {
	private String stock_price_high;
	private Integer count;
	
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonCreator
	 public StockPriceHigh( @JsonProperty("stock_price_high") String stock_price_high, @JsonProperty("count") Integer count)
	    {

	  this.stock_price_high = stock_price_high;
	  this.count=count;
	 
	 
	 }

	 public StockPriceHigh() {

	 }
	 public String toString() {
		  StringBuilder str = new StringBuilder();

		  str.append(" stock_price_high:- " + getStock_price_high());
		  str.append("count" +getCount());
		  
		 

		  return str.toString();
		 }
	
	
	public String getStock_price_high() {
		return stock_price_high;
	}

	public void setStock_price_high(String stock_price_high) {
		this.stock_price_high = stock_price_high;
	}

}
