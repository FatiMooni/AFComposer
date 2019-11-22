package AFCProg;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class SaveFiles {
	
	 FileWriter writer ;
	 BufferedWriter buffer ;	
	
	 void CreateAEFile ( AEF automate , String filename )  
	 {
		 int i,j ;
		 int [][] matrice= automate.matrice ;
         try {
        	 writer = new FileWriter(filename+".aef");
             buffer = new BufferedWriter(this.writer);
				 buffer.write( "This file represent the final transition table :") ;
				 buffer.newLine();
				 buffer.write( "+----------------------------------------------+") ;
				 buffer.newLine();
			
			 	 buffer.write("   ") ;
				 for(i=0;i<automate.nbState ;i++)
	              {
					 buffer.write("S"+i+"|") ;
	              }
                 buffer.newLine() ;
			 	 for(i=0;i<automate.nbState ;i++)
	              {
					     buffer.write("S"+i+"| ") ;
				         for(j=0;j<matrice.length;j++)
				         {   
							 
				        	 buffer.write(Integer.toString(matrice[i][j])+"  ") ;	 
				         }
	                     buffer.newLine() ;
	              } 
			
				   
				 buffer.newLine();
				 buffer.write( "+----------------------------------------------+") ;
				 buffer.newLine();
				 buffer.write( " --> The intersection numbers represent actions") ;
				 buffer.newLine();
				 buffer.write( " --> for more details check AEFTable_"+filename+" file") ;
				 buffer.newLine();
				 buffer.write( "+----------------------------------------------+") ;

			
		      } catch (IOException e) {
		     	           e.printStackTrace();
		      }
         finally {

 		  	try {

 				if (this.buffer!= null)
 					this.buffer.close();

 				if (this.writer != null)
 					this.writer.close();

 			} catch (IOException ex) {

 				ex.printStackTrace();

 			}	 
	     }
	 }

	 void CreateActionsFile ( HashMap <Integer,String> list , String filename )  
	 {
		 int i,j ;
       
		 Set set3=list.entrySet();
         Iterator iterator3 = set3.iterator();
       
         try {
        	 writer = new FileWriter(filename+".act");
             buffer = new BufferedWriter(this.writer);
				 buffer.write( "This file represent the correspendance between actions and integers used in the transation table :") ;
				 buffer.newLine();
				 buffer.write( "+------------------------------------------------------------------------------------------------+") ;
				 buffer.newLine();
				 buffer.write("indice is: -1 & its action is: epsilon (empty transition)") ;
                 buffer.newLine() ;
			     while(iterator3.hasNext()) {
          Map.Entry mentry3 = (Map.Entry)iterator3.next();
		  buffer.write("indice is: "+mentry3.getKey() + " & its action is: "+mentry3.getValue()) ;
          buffer.newLine() ;
                 }
			 	
		      } catch (IOException e) {
		     	           e.printStackTrace();
		      }
         finally {

 		  	try {

 				if (this.buffer!= null)
 					this.buffer.close();

 				if (this.writer != null)
 					this.writer.close();

 			} catch (IOException ex) {

 				ex.printStackTrace();

 			}	 
	     }
	 }



}

