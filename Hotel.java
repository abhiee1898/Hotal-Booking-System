import java.util.Scanner;

class Hotel
{
    static Holder hotel_ob=new Holder();
    static Scanner sc = new Scanner(System.in);
    static void CustDetails(int i,int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null; 
        String gender2="";
        System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT + "\nEnter customer name: " + ConsoleColors.RESET);
        name = sc.next();
        System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT + "Enter contact number: " + ConsoleColors.RESET);
        contact=sc.next();
        System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT + "Enter gender: " + ConsoleColors.RESET);
        gender = sc.next();
        if(i<3)
        {
        System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT + "Enter second customer name: " + ConsoleColors.RESET);
        name2 = sc.next();
        System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT + "Enter contact number: " + ConsoleColors.RESET);
        contact2=sc.next();
        System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT + "Enter gender: " + ConsoleColors.RESET);
        gender2 = sc.next();
        }      
        
          switch (i) {
            case 1:hotel_ob.luxury_doublerrom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 2:hotel_ob.deluxe_doublerrom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 3:hotel_ob.luxury_singleerrom[rn]=new Singleroom(name,contact,gender);
                break;
            case 4:hotel_ob.deluxe_singleerrom[rn]=new Singleroom(name,contact,gender);
                break;
            default:System.out.println(ConsoleColors.RED_BOLD + "Wrong option" + ConsoleColors.RESET);
                break;
        }
    }
    
    static void bookroom(int i)
    {
        int j;
        int rn;
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\nChoose room number from : " + ConsoleColors.RESET);
        switch (i) {
            case 1:
                for(j=0;j<hotel_ob.luxury_doublerrom.length;j++)
                {
                    if(hotel_ob.luxury_doublerrom[j]==null)
                    {
                        System.out.print(j+1+",");
                    }
                }
                System.out.print(ConsoleColors.BLUE_BOLD + "\nEnter room number: " + ConsoleColors.RESET);
                try{
                rn=sc.nextInt();
                rn--;
                if(hotel_ob.luxury_doublerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println(ConsoleColors.RED_BOLD + "Invalid Option" + ConsoleColors.RESET);
                    return;
                }
                break;
            case 2:
                 for(j=0;j<hotel_ob.deluxe_doublerrom.length;j++)
                {
                    if(hotel_ob.deluxe_doublerrom[j]==null)
                    {
                        System.out.print(j+11+",");
                    }
                }
                System.out.print(ConsoleColors.BLUE_BOLD + "\nEnter room number: " + ConsoleColors.RESET);
                try{
                rn=sc.nextInt();
                rn=rn-11;
                if(hotel_ob.deluxe_doublerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println(ConsoleColors.RED_BOLD + "Invalid Option" + ConsoleColors.RESET);
                    return;
                }
                break;
            case 3:
                  for(j=0;j<hotel_ob.luxury_singleerrom.length;j++)
                {
                    if(hotel_ob.luxury_singleerrom[j]==null)
                    {
                        System.out.print(j+31+",");
                    }
                }
                System.out.print(ConsoleColors.BLUE_BOLD + "\nEnter room number: " + ConsoleColors.RESET);
                try{
                rn=sc.nextInt();
                rn=rn-31;
                if(hotel_ob.luxury_singleerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println(ConsoleColors.RED_BOLD + "Invalid Option" + ConsoleColors.RESET);
                    return;
                }
                break;
            case 4:
                  for(j=0;j<hotel_ob.deluxe_singleerrom.length;j++)
                {
                    if(hotel_ob.deluxe_singleerrom[j]==null)
                    {
                        System.out.print(j+41+",");
                    }
                }
                System.out.print(ConsoleColors.BLUE_BOLD + "\nEnter room number: " + ConsoleColors.RESET);
                try{
                rn=sc.nextInt();
                rn=rn-41;
                if(hotel_ob.deluxe_singleerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                   System.out.println(ConsoleColors.RED_BOLD + "Invalid Option" + ConsoleColors.RESET);
                    return;
                }
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD + "Enter valid option" + ConsoleColors.RESET);
                break;
        }
        System.out.println(ConsoleColors.GREEN_BOLD + "Room Booked" + ConsoleColors.RESET);
    }
    
    static void features(int i)
    {
        switch (i) {
            case 1:System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 " + ConsoleColors.RESET);
                break;
            case 2:System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  " + ConsoleColors.RESET);
                break;
            case 3:System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  " + ConsoleColors.RESET);
                break;
            case 4:System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 " + ConsoleColors.RESET);
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD + "Enter valid option" + ConsoleColors.RESET);
                break;
        }
    }
    
    static void availability(int i)
    {
      int j,count=0;
        switch (i) {
            case 1:
                for(j=0;j<10;j++)
                {
                    if(hotel_ob.luxury_doublerrom[j]==null)
                        count++;
                }
                break;
            case 2:
                for(j=0;j<hotel_ob.deluxe_doublerrom.length;j++)
                {
                    if(hotel_ob.deluxe_doublerrom[j]==null)
                        count++;
                }
                break;
            case 3:
                for(j=0;j<hotel_ob.luxury_singleerrom.length;j++)
                {
                    if(hotel_ob.luxury_singleerrom[j]==null)
                        count++;
                }
                break;
            case 4:
                for(j=0;j<hotel_ob.deluxe_singleerrom.length;j++)
                {
                    if(hotel_ob.deluxe_singleerrom[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD + "Enter valid option" + ConsoleColors.RESET);
                break;
        }
        System.out.println("Number of rooms available : "+count);
    }
    
    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println(ConsoleColors.PURPLE_BOLD + "\n*******" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW_BOLD +" Bill:- " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD + "\n*******" + ConsoleColors.RESET);
               
        switch(rtype)
        {
            case 1:
                amount+=4000;
                    System.out.println(ConsoleColors.BLUE_BOLD + "\nRoom Charge - "+4000 + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE_BOLD + "\n===============" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD + "Food Charges:- " + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE_BOLD + "===============" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.BLUE_BOLD + "Item   Quantity    Price" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE_BOLD + "-------------------------" + ConsoleColors.RESET);
                    for(Food obb:hotel_ob.luxury_doublerrom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                    
                break;
            case 2:amount+=3000;
                    System.out.println(ConsoleColors.BLUE_BOLD + "Room Charge - "+3000 + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD + "\nFood Charges:- " + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE_BOLD + "===============" + ConsoleColors.RESET);
                     System.out.println(ConsoleColors.BLUE_BOLD + "Item   Quantity    Price" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE_BOLD + "-------------------------" + ConsoleColors.RESET);
                    for(Food obb:hotel_ob.deluxe_doublerrom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            case 3:amount+=2200;
                    System.out.println(ConsoleColors.BLUE_BOLD + "Room Charge - "+2200 + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD + "\nFood Charges:- " + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE_BOLD + "===============" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD + "Item   Quantity    Price" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE_BOLD + "-------------------------" + ConsoleColors.RESET);
                    for(Food obb:hotel_ob.luxury_singleerrom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            case 4:amount+=1200;
                    System.out.println(ConsoleColors.BLUE_BOLD + "Room Charge - "+1200 + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD + "\nFood Charges:- " + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE_BOLD + "===============" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLUE_BOLD + "Item   Quantity    Price" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE_BOLD + "-------------------------" + ConsoleColors.RESET);
                    for(Food obb: hotel_ob.deluxe_singleerrom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price);
                    }
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD + "Not valid" + ConsoleColors.RESET);
        }
        System.out.println(ConsoleColors.GREEN_BOLD + "\nTotal Amount- "+amount + ConsoleColors.RESET);
    }
    
    static void deallocate(int rn,int rtype)
    {
        int j;
        char w;
        switch (rtype) {
            case 1:               
                if(hotel_ob.luxury_doublerrom[rn]!=null)
                    System.out.println(ConsoleColors.BLUE_BOLD + "Room used by " + ConsoleColors.RESET + ConsoleColors.GREEN_BOLD + hotel_ob.luxury_doublerrom[rn].name + ConsoleColors.RESET);                
                else 
                {    
                    System.out.println(ConsoleColors.RED_BOLD + "Empty Already" + ConsoleColors.RESET);
                        return;
                }
                System.out.print(ConsoleColors.YELLOW_BOLD + "Do you want to checkout ?(y/n) -> " + ConsoleColors.RESET);
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.luxury_doublerrom[rn]=null;
                    System.out.println(ConsoleColors.GREEN_BOLD + "Deallocated succesfully" + ConsoleColors.RESET);
                }
                
                break;
            case 2:
                if(hotel_ob.deluxe_doublerrom[rn]!=null)
                    System.out.println(ConsoleColors.BLUE_BOLD + "Room used by " + ConsoleColors.RESET + ConsoleColors.GREEN_BOLD + hotel_ob.deluxe_doublerrom[rn].name + ConsoleColors.RESET);                
                else 
                {    
                    System.out.println(ConsoleColors.RED_BOLD + "Empty Already" + ConsoleColors.RESET);
                        return;
                }
                System.out.print(ConsoleColors.YELLOW_BOLD + "Do you want to checkout ?(y/n) -> " + ConsoleColors.RESET);
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.deluxe_doublerrom[rn]=null;
                    System.out.println(ConsoleColors.GREEN_BOLD + "Deallocated succesfully" + ConsoleColors.RESET);
                }
                 
                break;
            case 3:
                if(hotel_ob.luxury_singleerrom[rn]!=null)
                    System.out.println(ConsoleColors.BLUE_BOLD + "Room used by " + ConsoleColors.RESET + ConsoleColors.GREEN_BOLD + hotel_ob.luxury_singleerrom[rn].name + ConsoleColors.RESET);                
                else 
                 {    
                    System.out.println(ConsoleColors.RED_BOLD + "Empty Already" + ConsoleColors.RESET);
                        return;
                }
                System.out.print(ConsoleColors.YELLOW_BOLD + "Do you want to checkout ? (y/n) -> " + ConsoleColors.RESET);
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.luxury_singleerrom[rn]=null;
                    System.out.println(ConsoleColors.GREEN_BOLD + "Deallocated succesfully" + ConsoleColors.RESET);
                }
                
                break;
            case 4:
                if(hotel_ob.deluxe_singleerrom[rn]!=null)
                    System.out.println(ConsoleColors.BLUE_BOLD + "Room used by " + ConsoleColors.RESET + ConsoleColors.GREEN_BOLD + hotel_ob.deluxe_singleerrom[rn].name + ConsoleColors.RESET);                
                else 
                 {    
                    System.out.println(ConsoleColors.RED_BOLD + "Empty Already" + ConsoleColors.RESET);
                        return;
                }
                System.out.print(ConsoleColors.YELLOW_BOLD + "Do you want to checkout ? (y/n) -> " + ConsoleColors.RESET);
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.deluxe_singleerrom[rn]=null;
                    System.out.println(ConsoleColors.GREEN_BOLD + "Deallocated succesfully" + ConsoleColors.RESET);
                }
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD + "\nEnter valid option : " + ConsoleColors.RESET);
                break;
        }
    }
    
    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
         try{
            System.out.print(ConsoleColors.PURPLE_BOLD + "\n==========\n   Menu:  \n==========\n\n" + ConsoleColors.RESET);
             System.out.println(ConsoleColors.CYAN_BOLD + "1.Sandwich\tRs.30\n2.Pasta\t\tRs.40\n3.Noodles\tRs.50\n4.Coke\t\tRs.30\n" + ConsoleColors.RESET);
        do
        {
            System.out.print(ConsoleColors.PURPLE_BOLD + "Enter the foodId to order: " + ConsoleColors.RESET);
            i = sc.nextInt();
            System.out.print(ConsoleColors.BLUE_BOLD + "Quantity- " + ConsoleColors.RESET);
            q=sc.nextInt();
           
              switch(rtype){
            case 1: hotel_ob.luxury_doublerrom[rn].food.add(new Food(i,q));
                break;
            case 2: hotel_ob.deluxe_doublerrom[rn].food.add(new Food(i,q));
                break;
            case 3: hotel_ob.luxury_singleerrom[rn].food.add(new Food(i,q));
                break;
            case 4: hotel_ob.deluxe_singleerrom[rn].food.add(new Food(i,q));
                break;                                                 
        }
              System.out.print(ConsoleColors.YELLOW_BOLD +"Do you want to order anything else ? (y/n) -> " + ConsoleColors.RESET);
              wish=sc.next().charAt(0); 
        }while(wish=='y'||wish=='Y');  
        }
         catch(NullPointerException e)
            {
                System.out.println(ConsoleColors.RED_BOLD + "\nRoom not booked" + ConsoleColors.RESET);
            }
         catch(Exception e)
         {
             System.out.println(ConsoleColors.RED_BOLD + "Cannot be done" + ConsoleColors.RESET);
         }
    }
}