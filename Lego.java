/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
class Piece{
	private String nom;


	public Piece(String nom){
		this.nom=nom;
	}
	public String getNom(){
		return this.nom;
	}

	public String toString(){	
		return this.getNom();
	}

}

class Composant{
	private Piece piece;
	private int quantite;
	
	public Composant(Piece piece,int quantite){
		this.piece=piece;
		this.quantite=quantite;	
	}

	public Piece getPiece(){
		return this.piece;
	}

	public int getQuantite(){
		return this.quantite;
	}




}

class Simple extends Piece{
	private String orientation="aucune";
	

	public Simple(String nom){
		super(nom);	
	}

	public Simple(String nom,String orientation){
		super(nom);	
		this.orientation=orientation;
	}

	public String getOrientation(){
		return this.orientation;
	}

	public String toString(){
		if(this.orientation=="aucune"){
			return super.toString();
		}else{
			return super.toString()+" "+this.orientation;
		}	
	}
}




class Composee extends Piece{
	//private int taille;
	private int tailleMax;
	private ArrayList <Piece> listePieces;

	public Composee(String nom,int tailleMax ){
		super(nom);
		this.tailleMax=tailleMax;
		listePieces=new ArrayList<Piece>();
	}

	public int taille(){
		return this.listePieces.size();
	}

	public int tailleMax(){
		return this.tailleMax;
	}

	public void construire(Piece p){
		int size=this.taille();
		if(size<this.tailleMax){
			this.listePieces.add(p);
		}else{
			System.out.println("Construction impossible");
		}

	}

	public String toString(){
		String s=super.toString()+" (";
		for(Piece p: listePieces){
			if(listePieces.indexOf(p)==listePieces.size()-1){
				s+=p.toString();
			}else{
				
				s+=p.toString()+",";
			}
		}
		s+=")";
		return s;
	
	}
 

}


class Construction{

	private int taille;
	private int tailleMax;
	private ArrayList <Piece> listeConstruct;
	private ArrayList <Integer> tailleConstruct;
	//private Map<Integer,Piece> listeConstruct;  
	
	
	public Construction(int tailleMax){
		this.tailleMax=tailleMax;
		listeConstruct=new ArrayList<Piece>();
		tailleConstruct=new ArrayList<Integer>();
		//listeConstruct=new HashMap<Integer,Piece>();
	}
	public int taille(){
		//int taille;
		//for(int nb:tailleConstruct) {
			//taille+=nb;
		//}
		//return taille;
		return this.listeConstruct.size();
	}
	public int tailleMax(){
		return this.tailleMax;
	}
	public void ajouterComposant(Piece p,int nb){

		if(this.taille<this.tailleMax){
		    //if(this.taille+nb<=this.tailleMax){
    		  
    		        this.listeConstruct.add(p);
    		        this.tailleConstruct.add(nb);
    		        //listeConstruct.put(nb,p);
    		    
		    //}else{
		       // System.out.println("Ajout de composant impossible");
		   // }
			
		}else{
			System.out.println("Ajout de composant impossible");
		}		
	}
	public String toString(){
		String s="";
		Piece p;
		//String.valueOf(p.taille())
		//int t;
		for(int i=0;i<listeConstruct.size();i++){
 		   // if(listeConstruct.get(i)==)
		     p=listeConstruct.get(i);
		     taille=tailleConstruct.get(i);
            s+=p.toString()+" (quantite "+taille+ ")\n";
			
		}
		//for(Piece p: listeConstruct){
// 			s+=p.toString()+" (quantite "+ ")\n";

// 		}

        //for (Map.Entry<Integer,Piece> e : listeConstruct.entrySet()){
            //ystem.out.println("Key: " + e.getKey()
                            //   + " Value: " + e.getValue());
            //    p=e.getValue();  
              //  s+=p.toString()+" (quantite "+e.getKey()+ ")\n";
                               
                               
        //}
       
		return s;


	}






}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // déclare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}