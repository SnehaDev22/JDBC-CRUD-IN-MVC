package View;

import java.sql.SQLException;
import java.util.Scanner;

import Controller.Control;

public class Menu {
	Control ct=new Control();
	boolean loop=true;
	Scanner s=new Scanner(System.in);
	
	void menu() throws ClassNotFoundException, SQLException
	{ 
		while(loop){
	 System.out.println();	
	 System.out.println(" **************Menu**************");
	 System.out.println("1.Add");
	 System.out.println("2.Show");
	 System.out.println("3.Search");
	 System.out.println("4.Update");
	 System.out.println("5.Delete");
	 System.out.println("6.Exit");
	 
	  System.out.println("Choice : ");
	  int choice=Integer.parseInt(s.nextLine());
	  
	switch(choice)
	  {
	  case 1:
		ct.add();  
	  break;
	  
	  case 2:
	 ct.show();	  
	  break;
	  
	  case 3:
		ct.search();  
	  break;
	  
	  case 4:
		ct.update();  
	  break;
	  
	  case 5:
		 ct.delete(); 
	  break;
	  case 6:
		  loop=false; 
		  System.out.println("Bye..........Bye.........");
		  break;  
		 
		  
		default:
			System.out.println("Entered wrong input");
			  System.out.println("Enter choice again");
			break;
			
		
			  
	  }
	}
	}
}
