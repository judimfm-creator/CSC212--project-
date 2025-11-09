import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Order {
    int orderId;
    int customerReference;
    LinkedList <Integer> products = new LinkedList <Integer> ();  
    double totalPrice;
    LocalDate date;
    String status;

   public Order() {
    this(0, 0, new Integer[0], 0.0, LocalDate.now().toString(), "");
   }

    public Order(int orderId, int customerReference, Integer [] productIDs, double totalPrice, String date, String status) {
        this.orderId = orderId;
        this.customerReference = customerReference;
        this.totalPrice = totalPrice;
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date = LocalDate.parse(date);//, formatter);
        this.status = status;
        
        //for (int i = 0 ; i < pids.length ; i++)
          //  products.insert(pids[i]);
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerReference() {
        return customerReference;
    }

    public LinkedList<Integer> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerReference(int customerReference) {
        this.customerReference = customerReference;
    }

    public void setProducts(int productIDs) {
        this.products.insert(productIDs);
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addProduct (Integer product )
    {
        products.insert(product);
    }

    public boolean removeReview( Integer rev)
    {
        if ( ! products.empty())
        {
            products.findFirst();
            while(products.last())
            {
                if (products.retrieve() == rev)
                {
                    products.remove();
                    return true;
                }
                else
                    products.findNext();
            }
            if (products.retrieve() == P)
            {
                products.remove();
                return true;
            }
        }
        return false;
    }
   
    @Override
    public String toString() {
        retrurn {" + "orderId=" + orderId +
            ", customer Reference=" + customerReference 
                + ",total price=" + totalPrice 
                + " , status =" + status
                + ", date =" + date;
        if ( ! products.empty())
        {
            str += "(products List" ;
            products.findFirst();
            while(! products.last())
            {
                str += products.retrieve() + " ";
                products.findNext();
            }
            str += products.retrieve() + " )";
        }
        str +=  " }";
        return str;        
    }

}
