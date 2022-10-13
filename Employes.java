/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
/*"Nous avons un nouvel employé : "
"Montant de la prime souhaitée par "
"  A voyagé "
" jours et apporté "
"  A corrigé "
"  A mené à bien "*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Employe{

	private final String nom;
	private double revenu;
	private int tauxOccupation;
	private double prime=0;

	public Employe(String nom,double revenu){
		this.nom=nom;
		this.revenu=revenu;
		this.tauxOccupation=100;
		System.out.print("Nous avons un nouvel employé : "+getNom()+",");
	}

	public Employe(String nom,double revenu,int tauxOccupation){
		this.nom=nom;
		this.revenu=revenu;
		if(tauxOccupation<=10){
			this.tauxOccupation=10;
		}else if(tauxOccupation>=100){
			this.tauxOccupation=100;
		}else{
			this.tauxOccupation=tauxOccupation;
		}
		System.out.print("Nous avons un nouvel employé : "+getNom()+",");
	}
	
	public String getNom(){
		return nom;
	}
	public double getRevenu(){
		return revenu;
	}
	public int getTauxOccupation() {
        	return tauxOccupation;
    	}
	public double getPrime(){
		return prime;
	}

	
	public double revenuAnnuel(){
		int nombreMoisAnnee = 12;
		double result=nombreMoisAnnee*getRevenu()*getTauxOccupation()/100+getPrime();
		return result;
	}

	public void demandePrime() {
	    final double PRIME_COEFFICIENT=0.02;
		Scanner clavier=new Scanner(System.in);
		double prime=0;
		double primeMax= PRIME_COEFFICIENT*revenuAnnuel();
		boolean state=false;
		String input;
		int i=1;
		do{
			System.out.println("Montant de la prime souhaitée par "+getNom()+" ?");
			try{
            input=clavier.nextLine();
            prime=Double.parseDouble(input);
			//prime=(double)clavier.nextDouble();
			if(prime<=primeMax && prime>=0){
				this.prime=prime;
				state=true;
			}else{
				System.out.println("Trop cher!");
				clavier.nextLine();
			}
		
			}catch(Exception ex){
				System.out.println("Vous devez introduire un nombre!");
				clavier.nextLine();
			}
			i++;
		}while(state==false&&i<=5);

	}
	
	@Override
	public String toString(){
		
		String str;
        	str=getNom() + " :" + "\n";
        	str+="  Taux d'occupation : " + getTauxOccupation() + "%. Salaire annuel : " + String.format("%.2f",revenuAnnuel()) + " francs";

        	if (getPrime() !=0){
            		str+=String.format(", Prime : %.2f", getPrime()) + ".\n";
        	} else {
            		str+=". \n";
        	}
        	return str;
	}



}

class Manager extends Employe{
	public static final int FACTEUR_GAIN_CLIENT=500;
	public static final int  FACTEUR_GAIN_VOYAGE=100;
	//un nombre de jours voyagés et un nombre de nouveaux clients apportés
	//new Manager("Serge Legrand", 7456, 30, 4 )
	private int nbJoursVoyage;
	private int nbClients;
	
	public Manager(String nom,double revenu,int nbJoursVoyage,int nbClients){
		super(nom,revenu);
		this.nbJoursVoyage=nbJoursVoyage;
		this.nbClients=nbClients;
		System.out.println(" c'est un manager.");
	}

	public Manager(String nom,double revenu,int nbJoursVoyage,int nbClients,int tauxOccupation){
		super(nom,revenu,tauxOccupation);
		this.nbJoursVoyage=nbJoursVoyage;
		this.nbClients=nbClients;
		System.out.println(" c'est un manager.");
	}

	public int getNbJoursVoyage(){
		return nbJoursVoyage;
	}
	public int getNbClients(){
		return nbClients;
	}
	@Override
	public double revenuAnnuel(){
		double result= super.revenuAnnuel()+FACTEUR_GAIN_CLIENT*getNbClients()+FACTEUR_GAIN_VOYAGE*getNbJoursVoyage();
		return result;
	}
	@Override
	public String toString(){
		return super.toString()+"  A voyagé "+getNbJoursVoyage()+" jours et apporté "+getNbClients() + " nouveaux clients.";
	}
}

class Testeur extends Employe{
	public static final int FACTEUR_GAIN_ERREURS=10;
	//new Testeur("Pierre Lelong", 5456, 124, 50 )
	private int nbErreursTraitees;
	public Testeur(String nom,double revenu,int nbErreursTraitees){
		super(nom,revenu);
		this.nbErreursTraitees=nbErreursTraitees;
		System.out.println(" c'est un testeur.");
	}

	public Testeur(String nom,double revenu,int nbErreursTraitees,int tauxOccupation){
		super(nom,revenu,tauxOccupation);
		this.nbErreursTraitees=nbErreursTraitees;
		System.out.println(" c'est un testeur.");
	}

	public int getNbErreursTraitees(){
		return nbErreursTraitees;
	}
	@Override
	public double revenuAnnuel(){
		double result=super.revenuAnnuel()+FACTEUR_GAIN_ERREURS*getNbErreursTraitees();
		return result;
	}
	@Override
	public String toString(){
		return super.toString()+"  A corrigé "+getNbErreursTraitees()+" erreurs.";
	}
	
}

class Programmeur extends Employe{
	public static final int FACTEUR_GAIN_PROJETS=200;
	//new Programmeur("Paul Lepetit" , 6456, 3, 75 )
	private int nbProjetsAcheves;

	public Programmeur(String nom,double revenu,int nbProjetsAcheves){
		super(nom,revenu);
		this.nbProjetsAcheves=nbProjetsAcheves;
		System.out.println(" c'est un programmeur.");
	}

	public Programmeur(String nom,double revenu,int nbProjetsAcheves,int tauxOccupation){
		super(nom,revenu,tauxOccupation);
		this.nbProjetsAcheves=nbProjetsAcheves;
		System.out.println(" c'est un programmeur.");
	}

	public int getNbProjetsAcheves(){
		return nbProjetsAcheves;
	}
	@Override
	public double revenuAnnuel(){
		double result=super.revenuAnnuel()+FACTEUR_GAIN_PROJETS*getNbProjetsAcheves();
		return result;
	}
	@Override
	public String toString(){
		return super.toString()+"  A mené à bien "+getNbProjetsAcheves()+" projets";
	}


}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Employes {
    public static void main(String[] args) {

        List<Employe> staff = new ArrayList<Employe>();

        // TEST PARTIE 1:

        System.out.println("Test partie 1 : ");
        staff.add(new Manager("Serge Legrand", 7456, 30, 4 ));
        staff.add(new Programmeur("Paul Lepetit" , 6456, 3, 75 ));
        staff.add(new Testeur("Pierre Lelong", 5456, 124, 50 ));

        System.out.println("Affichage des employés : ");
        for (Employe modele : staff) {
            System.out.println(modele);
        }
        // FIN TEST PARTIE 1
        // TEST PARTIE 2
        System.out.println("Test partie 2 : ");

        staff.get(0).demandePrime();

        System.out.println("Affichage après demande de prime : ");
        System.out.println(staff.get(0));

        // FIN TEST PARTIE 2
    }
}

