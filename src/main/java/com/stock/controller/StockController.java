package com.stock.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stock.bean.HDFSInfo;

import com.stock.service.StockService;

@Controller
@RequestMapping(value = "/stocks")
public class StockController {
	@Autowired
	 private StockService stockService;
	@Autowired
	HDFSInfo hdfsInfo;
	
	@RequestMapping(value = "/getStockPriceOpen", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getStockPriceOpen() throws SQLException
			 {	
		return stockService.getStockPriceOpen();
	}

	/*@RequestMapping(value = "/getStockPriceHigh", method = RequestMethod.GET)
	public @ResponseBody List<StockPriceHigh> getStockPriceHigh() throws SQLException
			 {	
		return stockService.getStockPriceHigh();
	}*/
	@RequestMapping(value = "/getStockPriceHigh", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getStockPriceHigh() throws SQLException
			 {	
		return stockService.getStockPriceHigh();
	}
	/*@RequestMapping(value = "/getStockPriceLow", method = RequestMethod.GET)
	public @ResponseBody List<StockPriceLow> getStockPriceLow() throws SQLException
			 {	
		return stockService.getStockPriceLow();
	}*/
	@RequestMapping(value = "/getStockPriceLow", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getStockPriceLow() throws SQLException
			 {	
		return stockService.getStockPriceLow();
	}
	@RequestMapping(value = "/getAllPrice", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getAllPrice() throws SQLException
			 {	
		return stockService.getAllPrice();
	}
	
	@RequestMapping(value = "/getLogin", method = RequestMethod.GET)
	public @ResponseBody boolean validateUser(@RequestParam("username") String username,
			@RequestParam("password") String password) throws IOException, SQLException {
		return stockService.getLogin(username, password);
	}
	/*@RequestMapping(value = "/getLogin", method = RequestMethod.GET)
	public @ResponseBody List<Login> getLogin()  throws IOException, SQLException {
		return stockService.getLogin();
	}*/
	
	@RequestMapping(value = "/getTableData", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getTableData()  throws SQLException {
		return stockService.getTableData();
	}
	@RequestMapping(value = "/getAllDate", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getAllDate(@RequestParam("companyname") String companyname) throws SQLException
			 {	
		return stockService.getAllDate(companyname);
	}
	@RequestMapping(value = "/getAllCompany", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getAllCompany() throws SQLException
			 {	
		return stockService.getAllCompany();
	}
	@RequestMapping(value = "/getAllStockPriceOpen", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getAllStockPriceOpen(@RequestParam("companyname") String companyname) throws SQLException
			 {	
		return stockService.getAllStockPriceOpen(companyname);
	}
	@RequestMapping(value = "/getAllStockPriceHigh", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getAllStockPriceHigh(@RequestParam("companyname") String companyname) throws SQLException
			 {	
		return stockService.getAllStockPriceHigh(companyname);
	}
	@RequestMapping(value = "/getAllStockPriceLow", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getAllStockPriceLow(@RequestParam("companyname") String companyname) throws SQLException
			 {	
		return stockService.getAllStockPriceLow(companyname);
	}
	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public @ResponseBody void submit(@RequestParam("company") String company,@RequestParam("stock_price_open") String stock_price_open,@RequestParam("stock_price_high") String stock_price_high,@RequestParam("stock_price_low") String stock_price_low)  throws SQLException {
		stockService.submit(company,stock_price_open,stock_price_high,stock_price_low);
	}
	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public @ResponseBody String getFileContain(HttpServletRequest request, @RequestParam("filename") String filename,
			@RequestParam("file") MultipartFile file) throws IOException {
		String path = hdfsInfo.getSchemaPath() + "/";
		if(! new File(path).exists())
        {
            new File(path).mkdir();
        }
		String filePath = path + "/" +filename;
		File dest = new File(filePath);
		file.transferTo(dest);
		//System.out.println("Absolute Path : " + dest.getAbsolutePath());
		return dest.getAbsolutePath();
	}

	/*@RequestMapping(value = "/registerFile", method = RequestMethod.GET)
	public @ResponseBody String loadCsv(@RequestParam("csvFileName") String csvFileName,@RequestParam("path")String path)
			
			throws  IOException, SQLException {
		return stockService.createAndLoad(path,csvFileName);
	}*/
		
}
