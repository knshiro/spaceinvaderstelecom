public class ArrayPerso {

	public Chose[] tableau; 
	
	ArrayPerso(){
		tableau= new Chose[200];
		}
	
	
	void add(int i,Chose c){
		
		tableau[i]=c;
	}
	
	Chose get(int i){
		return tableau[i];
	}
	
	
}
