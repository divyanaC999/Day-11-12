package com.stockmanagement;

public class StockReport {
	MyList<Stock> list;

	StockDataAndPrintReport stockDataAndPrintReport = new StockDataAndPrintReport();

	public static void main(String[] args) {
		StockDataAndPrintReport.getStockData();
		StockDataAndPrintReport.printReport();
	}
}
