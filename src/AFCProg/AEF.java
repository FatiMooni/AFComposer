package AFCProg;

public class AEF {
	

		int EtatFin ;
		int [][] matrice ;
		int nbState;
		
		AEF(int length){
			this.nbState = length;
			this.matrice = new int [length][length];
		}
		
		
		
        public AEF GenerateBasic(int action){
        	/*Save save = Save.instance();
        	int act =save.getState(action);*/
        	AEF temp = new AEF(2);
        	temp.matrice[0][1]= action;
        	temp.EtatFin=1;
        	return temp;
        }
	

}
