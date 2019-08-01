package etc.one;

public abstract class StockExchange implements Cloneable {
    @Override
    public StockExchange clone() throws CloneNotSupportedException {
        return (StockExchange) super.clone();
    }

    public abstract String getStockExchange();
    
    public abstract void setStockExchange(String str);
}
