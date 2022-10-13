/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;
class Vehicule{
	private String nom;
	private double vitesseMax;
	private int poidsMax;
	private int carburant;
	public Vehicule(){
		this.nom="Anonyme";
		this.vitesseMax=130.0;
		this.poidsMax=1000;
		this.carburant=0;
	}
        // les arguments du constructeurs sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
	public Vehicule(String nom,double vitesseMax,int poidsMax,int carburant){
		this.nom=nom;
		this.vitesseMax=vitesseMax;
		this.poidsMax=poidsMax;
		this.carburant=carburant;
	}
	
	public String toString(){
		return getNom()+" -> vitesse max = "+getVitesseMax()+" km/h, poids = "+getPoids()+" kg";
	}

	private double performance(){
		return (vitesseMax/poidsMax);

	}
	public double getPerformance(){
		return performance();

	}
	
	public boolean meilleur(Vehicule autreVehicule){	
			return this.performance()>autreVehicule.getPerformance();
	}
	public String getNom(){
		return nom;
	}
	public double getVitesseMax(){
		return vitesseMax;
	}
	public int getPoids(){
		return poidsMax;
	}
	public int getCarburant(){
		return carburant;
	}
	public boolean estDeuxRoues(){
		return false;
	}
}

class Voiture extends Vehicule{
	
	private String categorie;
	// les trois premiers arguments sont dans l'ordre:
    // le nom, la vitesse, le poids, le carburant
    // le dernier argument indique la categorie
	public Voiture(String nom,double vitesseMax,int poidsMax,int carburant,String categorie){
		super(nom,vitesseMax,poidsMax,carburant);
		this.categorie=categorie;
	}
	public String getCategorie() {
		return categorie;
	}
	public String toString() {
		return getNom()+" -> vitesse max = "+getVitesseMax()+" km/h, poids = "+getPoids()+" kg, Voiture de "+getCategorie();	
	}
	
}
class Moto extends Vehicule{
	
	private boolean sideCar;
    // les trois premiers arguments sont dans l'ordre:
    // le nom, la vitesse, le poids, le carburant
    // le dernier argument indique la presence d'un sidecar
	public Moto(String nom,double vitesseMax,int poidsMax,int carburant){
		super(nom,vitesseMax,poidsMax,carburant);
		this.sideCar=false;
	}
	public Moto(String nom,double vitesseMax,int poidsMax,int carburant,boolean sideCar){
		super(nom,vitesseMax,poidsMax,carburant);
		this.sideCar=sideCar;
	}
	public String toString() {
		String str;
		str=getNom()+" -> vitesse max = "+getVitesseMax()+" km/h, poids = "+getPoids()+" kg, Moto";
		if(sideCar) {
			str+=", avec sidecar";
		}
		return str;
	}
	public boolean getSideCar(){
		return sideCar;
	}
	public boolean estDeuxRoues(){
		return !sideCar;
	}
	
}

abstract class Rallye{

	public abstract boolean check();
}
class GrandPrix extends Rallye{

	private ArrayList<Vehicule> vehicules;
	public GrandPrix(){
		vehicules=new ArrayList<Vehicule>();
	}


	public void ajouter(Vehicule vehicule){
		//boolean vehiculeType=this.estDeuxRoues(vehicule);
		//if(vehiculeType==false){
			vehicules.add(vehicule);
		//}
	}

	public boolean check() {
		boolean possedeDeuxR = false;
		boolean nonDeuxR = false;
		for (Vehicule vehicule: vehicules){
			if (vehicule.estDeuxRoues()){
				possedeDeuxR = true;
			}
			else{
				nonDeuxR = true;
			}
		}
		return (possedeDeuxR != nonDeuxR);
	}

	public void run(int tours){
		ArrayList<Vehicule> ligneArrivee = new ArrayList<Vehicule>();
		Vehicule v;
		v=null;
		int carburant;
		int i=0;
		if(check()==false){
			System.out.println("Pas de Grand Prix\n");
			return;		
		}else{
			for(Vehicule vehicule:vehicules){
				carburant=vehicule.getCarburant() -tours;
				if(carburant>0){
					ligneArrivee.add(vehicule);
				}
			}
			if (ligneArrivee.size() == 0) {
				System.out.println("Elimination de tous les vehicules");
				return;
			}
			//if (ligneArrivee.size() == 1) {
				//System.out.println("Le gagnant du grand prix est :");
				//System.out.println(ligneArrivee.get(i).toString());
				//return;
			//}else{
    			while (i<ligneArrivee.size()-1){
    				Vehicule v1,v2;
    				v1=ligneArrivee.get(i);
    				v2=ligneArrivee.get(i+1);
    				if(v1.meilleur(v2)){
    					v=v1;
    				}else{
    					v=v2;
    				}
    			
    				i++;
    			}
    			System.out.println("Le gagnant du grand prix est :");
				System.out.println(v.toString());
				
			//}
			
		}

	}

}




/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class Course {

    public static void main(String[] args) {

        // PARTIE 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        Vehicule v0 = new Vehicule();
        System.out.println(v0);

        // les arguments du constructeurs sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        Vehicule v1 = new Vehicule("Ferrari", 300.0, 800, 30);
        Vehicule v2 = new Vehicule("Renault Clio", 180.0, 1000, 20);
        System.out.println();
        System.out.println(v1);
        System.out.println();
        System.out.println(v2);

        if (v1.meilleur(v2)) {
            System.out.println("Le premier vehicule est meilleur que le second");
        } else {
            System.out.println("Le second vehicule est meilleur que le premier");
        }
        // FIN PARTIE 1

        // PARTIE2
        System.out.println();
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la presence d'un sidecar
        Moto m1 = new Moto("Honda", 200.0, 250, 15, true);
        Moto m2 = new Moto("Kawasaki", 280.0, 180, 10);
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la categorie
        Voiture vt1 = new Voiture("Lamborghini", 320, 1200, 40, "course");
        Voiture vt2 = new Voiture("BMW", 190, 2000, 35, "tourisme");
        System.out.println(vt1);
        System.out.println();
        System.out.println(vt2);
        System.out.println();
        // FIN PARTIE 2

        // PARTIE 3
        System.out.println();
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        GrandPrix gp1 = new GrandPrix();
        gp1.ajouter(v1);
        gp1.ajouter(v2);
        System.out.println(gp1.check());

        GrandPrix gp2 = new GrandPrix();
        gp2.ajouter(vt1);
        gp2.ajouter(vt2);
        gp2.ajouter(m2);
        System.out.println(gp2.check());

        GrandPrix gp3 = new GrandPrix();
        gp3.ajouter(vt1);
        gp3.ajouter(vt2);
        gp3.ajouter(m1);
        System.out.println(gp3.check());

        GrandPrix gp4 = new GrandPrix();
        gp4.ajouter(m1);
        gp4.ajouter(m2);
        System.out.println(gp4.check());
        // FIN PARTIE 3

        // PARTIE 4
        System.out.println();
        System.out.println("Test partie 4 : ");
        System.out.println("----------------");
        GrandPrix gp5 = new GrandPrix();
        gp5.ajouter(vt1);
        gp5.ajouter(vt2);

        System.out.println("Premiere course :");
        gp5.run(11);
        System.out.println();

        System.out.println("Deuxieme  course :");
        gp3.run(40);
        System.out.println();

        System.out.println("Troisieme  course :");
        gp2.run(11);
        // FIN PARTIE 4
    }
}
