package Mock;

import Model.Stock;
import java.io.IOException;
import org.jsoup.nodes.Document;
import org.mockito.Mock;

public class StockMock {
    
    @Mock
    private static Document doc;
    
    public static Stock mockStock() throws IOException{
        Stock stock = new Stock();
        stock.setAvgCust(Double.NaN, 0);
        stock.setAvgCust(Double.NaN, 0);
        stock.setDoc(doc);
        stock.setMarcketValue(doc);
        stock.setMoneyEarned(Double.MIN_VALUE);
        stock.setName("PETR4");
        stock.setStockQtd(0);
        stock.setTotalPrice(Double.MAX_VALUE, 0);
        return stock;
    }
            
}
