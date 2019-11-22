package AFCProg;



public class AEFCreator {
	/**
	* Cette classe responsable sur les trois opérations accordées au partie action
	*/
		protected AEF choice(AEF a ,AEF b){
        /** methode utilisé pour générer la table de transition resultante d'une opération ~ i.e. choix */
	    int i,j;
	    
	     
	    AEF temp;
		temp = new AEF(a.nbState + b.nbState -1);
	      
	         // on commence par creer un etat initial commun
	         for(j=0;j<a.nbState;j++)   
	         {
	             temp.matrice[0][j]=a.matrice[0][j];  
	         }
	         for(j=a.nbState;j<a.nbState+b.nbState-1;j++)  
	         {
	             temp.matrice[0][j]=b.matrice[0][j-a.nbState+1];
	             
	         }
	         
	         
	         //on recopier les autres etats intermédiaires        
	         
	         for(i=1;i<a.nbState+b.nbState-1;i++)
	         {
	             for(j=0;j<a.nbState+b.nbState-1;j++)
	             {   // 1ere automate
	                 if (i<a.nbState)   
	                 {    
	                                 
	                     if (j<a.nbState)  temp.matrice[i][j]=a.matrice[i][j];   
	                     
	                     else  temp.matrice[i][j]=0;                           
	                     
	                 }
	                 else // 2eme automate
	                 {
	                         if  (j<a.nbState) temp.matrice[i][j]=0;
	                         
	                         else { 
	                             temp.matrice[i][j]=b.matrice[i-(a.nbState-1)][j-(a.nbState-1)];
	                             }
	                 }    
	                 
	             }
	         }
	         
	         
	     //on change l'etat final
	         
	         for(i=0;i<a.nbState + b.nbState -1;i++)
	         {
	             for(j=0;j<a.nbState + b.nbState -1;j++)
	             {
	                 if ( (j==b.EtatFin+(a.nbState-1)) && (temp.matrice[i][j]!=0) ) 
	                 {
	                    temp.matrice[i][a.EtatFin]=temp.matrice[i][j]; 
	                    temp.matrice[i][j]=0 ;
	                 }
	                 
	                if (j > b.EtatFin+(a.nbState-1)) temp.matrice[i][j-1]=temp.matrice[i][j];
	                if (i > b.EtatFin+(a.nbState-1))  temp.matrice[i-1][j]=temp.matrice[i][j] ;
	             }
	         }
			temp.EtatFin = a.EtatFin;
	        temp.nbState--;
			return temp;    
	             
	}
	
	
		protected AEF sequence(AEF a ,AEF b){
        /** methode utilisé pour générer la table de transition resultante d'une opération ; i.e. séquence */

        int i,j;
        AEF temp;
		temp = new AEF(a.nbState + b.nbState);
        
        
         // d'abord on recopie la premiere table      
        for(i=0;i<temp.nbState-1;i++){
            for(j=0;j<temp.nbState-1;j++){
                if (i<a.nbState) {
                    if (j<a.nbState) temp.matrice[i][j]=a.matrice[i][j];
                    else {if (i==a.EtatFin)  temp.matrice[a.EtatFin][j]=b.matrice[0][j-a.nbState+1];   
                          else temp.matrice[i][j]=0;}
                // puis l'état final de a devenue l'etat initial de b        
                    
                }else {
                    if (j==a.EtatFin) 
                    	temp.matrice[i][a.EtatFin]=b.matrice[i-a.nbState+1][0]; 
                    else {if  (j<a.nbState-1) temp.matrice[i][j]=0;
                          else temp.matrice[i][j]=b.matrice[i-a.nbState+1][j-a.nbState+1];}
                }    
                // et on termine par l'ajout des états de b
            }
        }
        temp.nbState --;
        temp.EtatFin = temp.nbState-1;
        return temp;
        
    }    
    

	
	 protected AEF alternative(AEF a ,AEF b){
	/** methode utilisé pour générer la table de transition resultante d'une opération + i.e. alternative */

         AEF temp;
		 temp = new AEF(a.nbState + b.nbState);
		 
		 /** premiere table de transition **/
		 for(int i=0;i< a.nbState;i++){
			 for(int j=0;j< a.nbState;j++){

			 temp.matrice[i][j] = a.matrice[i][j];
			 
			 }
		 }
		 
		 /** meme état initial **/
		 for (int i=1;i<b.nbState;i++){
		 temp.matrice[0][a.nbState+i-1]=b.matrice[0][i];
		 b.matrice[0][i]=0;
		 }

		 /** 2eme table de transition **/
		 for(int i=1;i< b.nbState;i++){
			 for(int j=1;j< b.nbState;j++){

			 temp.matrice[a.nbState+i-1][a.nbState+j-1] = b.matrice[i][j];
			 }
		 }
		 
		 
		 /** les etats finaux **/
		 
			 temp.matrice[a.EtatFin][temp.nbState-1]=-1;
			 temp.matrice[b.EtatFin+a.nbState-1][temp.nbState-1]=-1;
     		 temp.EtatFin=temp.nbState-1;
		 
		 return temp;
	 }
	 
	 
	
	
}
