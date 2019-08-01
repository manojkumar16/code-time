package etc.one;

public class BombayStockExchange extends StockExchange {

    StockExchange bse = null;

    String str = null;

    public BombayStockExchange( String str ) {
        this.str = str;
    }

    @Override
    public String getStockExchange() {
        return this.str;
    }

    @Override
    public void setStockExchange(String str) {
        this.str = str;
    }
}
