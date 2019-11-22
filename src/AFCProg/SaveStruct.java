package AFCProg;

import java.util.HashMap;
import java.util.Map;
public class SaveStruct {

  public  int blockNum;
  public  HashMap <Integer,AEF> Partaef ;

     SaveStruct(){
         this.Partaef = new HashMap <Integer,AEF>();
         this.blockNum = 1000;
     }
}