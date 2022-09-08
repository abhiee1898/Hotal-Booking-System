import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
        try
        {           
        File f = new File("info.txt");
        if(f.exists())
        {
            FileInputStream fin=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(fin);
            Hotel.hotel_ob=(Holder)ois.readObject();
        }
        Scanner sc = new Scanner(System.in);
        int ch,ch2;
        char wish;
        x:
        do{
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "============= Welcome to Royle Palace  ==============" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "\n1.Display room types\n2.Display rooms availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.BLUE_BOLD + "\nEnter your choice: " + ConsoleColors.RESET);
        ch = sc.nextInt();
        switch(ch){
            case 1: 
                    System.out.println();
                    System.out.println(ConsoleColors.PURPLE_BOLD + "--------------------------------------------" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.YELLOW_BOLD + "    Select Type of Room to check details" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE_BOLD + "--------------------------------------------" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.CYAN_BOLD + "\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n" + ConsoleColors.RESET);
                    System.out.print(ConsoleColors.BLUE_BOLD + "Choose your room type: " + ConsoleColors.RESET);
                    ch2 = sc.nextInt();
                    Hotel.features(ch2);
                break;
            case 2:
                     System.out.println();
                     System.out.println(ConsoleColors.PURPLE_BOLD + "-----------------------------------------------" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.YELLOW_BOLD + "  Select Type of Room to check availability" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.PURPLE_BOLD + "-----------------------------------------------" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.CYAN_BOLD + "\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n" + ConsoleColors.RESET);
                     System.out.print(ConsoleColors.BLUE_BOLD + "Choose your room type: " + ConsoleColors.RESET);
                     ch2 = sc.nextInt();
                     Hotel.availability(ch2);
                break;
            case 3:
                     System.out.println();
                     System.out.println(ConsoleColors.PURPLE_BOLD + "---------------------------------------" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.YELLOW_BOLD + "   Select Type of Room for booking" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.PURPLE_BOLD + "----------------------------------------" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.CYAN_BOLD + "\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n" + ConsoleColors.RESET);
                     System.out.print(ConsoleColors.BLUE_BOLD + "Choose your room type: " + ConsoleColors.RESET);
                     ch2 = sc.nextInt();
                     Hotel.bookroom(ch2);                     
                break;
            case 4:
                     System.out.println();
                     System.out.println(ConsoleColors.PURPLE_BOLD + "---------------------------------------" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.YELLOW_BOLD + "   Select Room no for ordering food" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.PURPLE_BOLD + "----------------------------------------" + ConsoleColors.RESET);
                     System.out.print(ConsoleColors.BLUE_BOLD + "Room Number - " + ConsoleColors.RESET);
                     ch2 = sc.nextInt();
                     if(ch2>60)
                         System.out.println(ConsoleColors.GREEN_BOLD + "Room doesn't exist" + ConsoleColors.RESET);
                     else if(ch2>40)
                         Hotel.order(ch2-41,4);
                     else if(ch2>30)
                         Hotel.order(ch2-31,3);
                     else if(ch2>10)
                         Hotel.order(ch2-11,2);
                     else if(ch2>0)
                         Hotel.order(ch2-1,1);
                     else
                         System.out.println(ConsoleColors.GREEN_BOLD + "Room doesn't exist" + ConsoleColors.RESET);
                     break;
            case 5:                 
                     System.out.println();
                     System.out.println(ConsoleColors.PURPLE_BOLD + "---------------------------------------" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.YELLOW_BOLD + "   Select Room no for checkout" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.PURPLE_BOLD + "----------------------------------------" + ConsoleColors.RESET);
                     System.out.print(ConsoleColors.BLUE_BOLD + "Room Number - " + ConsoleColors.RESET);
                     ch2 = sc.nextInt();
                     if(ch2>60)
                         System.out.println(ConsoleColors.GREEN_BOLD + "Room doesn't exist" + ConsoleColors.RESET);
                     else if(ch2>40)
                         Hotel.deallocate(ch2-41,4);
                     else if(ch2>30)
                         Hotel.deallocate(ch2-31,3);
                     else if(ch2>10)
                         Hotel.deallocate(ch2-11,2);
                     else if(ch2>0)
                         Hotel.deallocate(ch2-1,1);
                     else
                         System.out.println(ConsoleColors.GREEN_BOLD + "Room doesn't exist" + ConsoleColors.RESET);
                     break;
            case 6:break x;
                
        }
           
            System.out.print(ConsoleColors.GREEN_BOLD + "\nContinue : (y/n) -> " + ConsoleColors.RESET);
            wish=sc.next().charAt(0); 
            if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
            {
                System.out.println(ConsoleColors.RED_BOLD + "Invalid Option" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.GREEN_BOLD + "\nContinue : (y/n) -> " + ConsoleColors.RESET);
                System.out.println();
                wish=sc.next().charAt(0); 
            }
            
        }while(wish=='y'||wish=='Y');    
        
        Thread t=new Thread(new Write(Hotel.hotel_ob));
        t.start();
        }        
            catch(Exception e)
            {
                System.out.println(ConsoleColors.RED_BOLD + "Not a valid input" + ConsoleColors.RESET);
            }
    }
}
