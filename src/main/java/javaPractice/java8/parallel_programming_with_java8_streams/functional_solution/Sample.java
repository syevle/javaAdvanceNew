package javaPractice.java8.parallel_programming_with_java8_streams.functional_solution;

import javaPractice.java8.lets_get_lazy.efficiency.StockInfo;
import javaPractice.java8.lets_get_lazy.efficiency.StockUtil;
import javaPractice.java8.lets_get_lazy.efficiency.Tickers;
import javaPractice.java8.lets_get_lazy.efficiency.Timeit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Sample {                                        
  public static void processImperative(List<String> symbols) {
    List<StockInfo> stocks = new ArrayList<>();
    
    for(String symbol : symbols) {
      stocks.add(StockUtil.getPrice(symbol));
    }                                     
    
    List<StockInfo> stocksLT500 = new ArrayList<>();
    for(StockInfo stock : stocks) {
      if(StockUtil.isPriceLessThan(500).test(stock))
        stocksLT500.add(stock);
    }                          
    
    StockInfo highPriced = dummy;
    for(StockInfo stock : stocksLT500) {
      highPriced = StockUtil.pickHigh(stock, highPriced);
    }                                                    
    
    System.out.println(highPriced);
  }
  
  public static void processFunctional(Stream<String> symbols) {
    System.out.println(
      symbols.map(StockUtil::getPrice)
             .filter(StockUtil.isPriceLessThan(500))
             .reduce(dummy, StockUtil::pickHigh));
  } 
  
  static StockInfo dummy = new StockInfo("", 0.0);  
  
  public static void main(String[] args) {
    //Given a list of ticker symbols, get me the ticker and the price for the
    //highest priced ticker, but only those less than $500.
    
    //Timeit.code(() -> processImperative(Tickers.symbols));
    
    Timeit.code(() -> processFunctional(Tickers.symbols.stream()));
  }              
}










