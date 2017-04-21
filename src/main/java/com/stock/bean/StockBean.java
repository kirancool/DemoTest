package com.stock.bean;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockBean {
	private String stock_price_open;
	private String count;
	
	
 public String getCount() {
		return count;
	}

	public void setCount(String emp1) {
		this.count = emp1;
	}

@JsonCreator
 public StockBean( @JsonProperty("stock_price_open") String stock_price_open, @JsonProperty("count") String count)
    {

  this.stock_price_open = stock_price_open;
  this.count=count;
 
 
 }

 public StockBean() {

 }


 
 
 @Override
 public String toString() {
  StringBuilder str = new StringBuilder();

  str.append(" stock_price_open:- " + getStock_price_open());
  str.append("count" +getCount());
  
 

  return str.toString();
 }


public String getStock_price_open() {
	return stock_price_open;
}

public void setStock_price_open(String stock_price_open) {
	this.stock_price_open = stock_price_open;
}


}