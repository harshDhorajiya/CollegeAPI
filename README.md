# CollegeAPI
APIs for getting college details 


using System; 
using System.Collections.Generic; 
using System.Collections;
class Test {
  
  public static void addflight(Dictionary<int, List<string>> flights){
      
      Console.WriteLine("Enter Flight-id ");
      int id=  Convert.ToInt32( Console.ReadLine() );
      
      if(flights.ContainsKey(id))
      {
          Console.WriteLine("Flight-id allready exist!!"); 
          return; 
      } 
      
      List<string> details = new List<string>(5); 
      Console.WriteLine("Enter Flight name"); 
      details.Add(Console.ReadLine());
      Console.WriteLine("Enter Flight destination ");
      details.Add(Console.ReadLine());
      Console.WriteLine("Enter Flight arrival ");
      details.Add(Console.ReadLine());
      Console.WriteLine("Enter Flight duration ");
      details.Add(Console.ReadLine());
      
      flights.Add(id,details);
      
  } 

     public static void display(Dictionary<int, List<string>> flights){  
         
         foreach ( KeyValuePair<int, List<string>> ele in flights){
          Console.WriteLine(ele.Key);  
          foreach ( string item in ele.Value )
          Console.Write(item+" ");
          
     }
     }
     
     
  static void Main() {
  
    Dictionary<int, List<string>> flights =  
                       new Dictionary<int, List<string>>(); 
  
  
     while(true){
         
         addflight(flights); 
         addflight(flights); 
         addflight(flights); 
         
         display(flights); 
         
     }
  
  }
}

