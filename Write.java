import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class Write implements Runnable
{
    Holder hotel_ob;
    Write(Holder hotel_ob)
    {
        this.hotel_ob=hotel_ob;
    }
    @Override
    public void run() {
          try{
        FileOutputStream fout=new FileOutputStream("info.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fout);
        oos.writeObject(hotel_ob);
        }
        catch(Exception e)
        {
            System.out.println(ConsoleColors.RED_BOLD + "Error in writing "+ e + ConsoleColors.RESET);
        }         
        
    }
    
}
