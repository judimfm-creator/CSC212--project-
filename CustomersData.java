import java.io.File;
import java.util.Scanner;

public class customersData {
    
    public static Scanner input = new Scanner (System.in);
    public static LinkedList<Customer> customers = new LinkedList<Customer> ();
   
    public LinkedList<Customer> getcustomersData ( )
    {
        return customers;
    }

    public customersData(String fileName)
    {
            try{
                File docsfile = new File(fileName);
                Scanner reader = new Scanner (docsfile);
                String line = reader.nextLine();
                
                while(reader.hasNext())
                {
                    line = reader.nextLine();
                    String [] data = line.split(","); 
                    Customer customer = new Customer(Integer.parseInt(data[0]),data[1], data[2] );
                    customers.insert(customer);
                }
                reader.close();
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    }
  
public void RegisterCustomer()
{
    Customer customer = new Customer ();

    System.out.println("Enter customer ID : ");
    customer.setCustomerId(input.nextInt());
    
    while (checkCustomerID(customer.getCustomerId()))
    {
        System.out.println("Please try agian, ID is already available: ");
        customer.setCustomerId(input.nextInt());
    }    
    
    System.out.println("Enter customer Name : ");
    String name = input.nextLine();
    name = input.nextLine();
    customer.setName(name);
    
    System.out.println("Enter customer Email : ");
    customer.setEmail(input.nextLine());

    customers.insert(customer);
}
    
public void OrderHistory()
{
        if (customers.empty())
        {
            System.out.println("empty customer data");
        }
        else
        {
            System.out.println("Enter customer ID: ");
            int customerID = input.nextInt();
            
            boolean found = false;
            
            customers.findFirst();
            for ( int i = 0 ; i < customers.size() ; i ++ )
            {
                if (customers.retrieve().getCustomerId() == customerID)
                {
                    found = true;
                    break;
                }
                customers.findNext();
            }
            
            if (found )
            {
                LinkedList<Integer> orders = customers.retrieve().getOrders();
                if (orders.empty())
                    System.out.println("Couldn't find order history " + customers.retrieve().getCustomerId());
                else
                {
                    System.out.println("Order History");
                    orders.findFirst();
                    for ( int u = 0 ; u < orders.size() ; u++)
                    {
                        System.out.println(orders.retrieve());
                        orders.findNext();
                    }
                 }
            }
            else
                System.out.println("Couldn't find customer ID");
        }
        
    }
    
    public boolean checkCustomerID( int customerID )
    {
        boolean found = false;
        if (! customers.empty())
        {
            customers.findFirst();
            while (!customers.last())
            {
                if (customers.retrieve().getCustomerId() == customerID)
                    found = true;
                customers.findNext();
            }
            if (customers.retrieve().getCustomerId() == customerID)
                found = true;
        }
        return found ;
    }
        
    public Customer getCustomerID()
    {
        if (customers.empty())
        {
            System.out.println("Empty customers data");
        }
        else
        {
            System.out.println("Enter customer ID: ");
            int customerID = input.nextInt();
            
            boolean found = false;
            
            customers.findFirst();
            while (!customers.last())
            {
                if (customers.retrieve().getCustomerId() == customerID)
                {
                    found = true;
                    break;
                }
                customers.findNext();
            }
            if (customers.retrieve().getCustomerId() == customerID)
                found = true;
        
            if (found )
                return customers.retrieve();
        }
        System.out.println("Couldn't find customer ID");
        return null;
    }
}
