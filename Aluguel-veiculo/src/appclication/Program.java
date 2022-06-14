package appclication;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import Model.entitites.Carrental;
import Model.entitites.Vehicle;
import Model.services.BrazilTaxService;
import Model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
        Scanner  sc = new Scanner (System.in);
        SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy HH:ss");  
        
        
        
        System.out.println("Enter rental data");
        System.out.println("Car model :");
        String carModel = sc.nextLine();
        System.out.println("Pickup (dd/MM/yy hh:ss):");
        Date start = (Date) sdf.parse(sc.nextLine());
        System.out.println("Return (dd/MM/yy hh:ss):");
        Date finish = (Date) sdf.parse(sc.nextLine());
        
        
        Carrental cr = new Carrental(start, finish, new Vehicle ( carModel));
        
        
        System.out.println("enter price per hours");
        double pricePerHour = sc.nextDouble();
        
        System.out.println("enter price per day");
        double pricePerDay = sc.nextDouble();
        
        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());        
        
        rentalService.processInvoice(cr);
        
         System.out.println("INVOICE");
         System.out.println("Basic payment: " + String.format("%.2f, cr.getInvoice().getBasicPayment()")); 
         System.out.println("Tax payment: " + String.format("%.2f, cr.getInvoice().getTax()")); 
         System.out.println("Basic payment: " + String.format("%.2f, cr.getInvoice().getTotalPayment()")); 
        
        sc.close();
      
	}

}

