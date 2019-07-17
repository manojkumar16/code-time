package etc;

public class NationalStockExchange extends StockExchange {
    StockExchange nse = null;

    private String str;

    public NationalStockExchange( String str ) {
        this.str = str;
    }

    @Override
    public String getStockExchange() {
        return this.str;
    }

    @Override
    public void setStockExchange( String str ) {
        this.str = str;
    }
}
