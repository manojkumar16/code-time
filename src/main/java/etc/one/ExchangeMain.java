package etc.one;

public class ExchangeMain {
    public static void main( String[] args ) throws CloneNotSupportedException {
        StockExchange bse = new BombayStockExchange( "BSE" );
        //StockExchange nse = new NationalStockExchange( "NSE" );

        System.out.println( bse.getStockExchange() );
        //System.out.println( nse.getStockExchange() );

        StockExchange bse2 = bse.clone();
        
        bse2.setStockExchange( "BSE2" );
        
        System.out.println( bse.getStockExchange() );
        System.out.println( bse2.getStockExchange() );
    }
}
