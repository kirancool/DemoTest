package com.stock.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockPriceLow {
	private String stock_price_low;
	private Integer count;
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonCreator
	 public StockPriceLow( @JsonProperty("stock_price_low") String stock_price_low,@JsonProperty("count") Integer count)
	    {

	  this.stock_price_low = stock_price_low;
	  this.count=count;
	 
	 
	 }

	 public StockPriceLow() {

	 }
	 public String toString() {
		  StringBuilder str = new StringBuilder();

		  str.append(" stock_price_low:- " + getStock_price_low());
		  str.append("count" +getCount());
		  
		 

		  return str.toString();
		 }
	 
	public String getStock_price_low() {
		return stock_price_low;
	}

	public void setStock_price_low(String stock_price_low) {
		this.stock_price_low = stock_price_low;
	}

}
