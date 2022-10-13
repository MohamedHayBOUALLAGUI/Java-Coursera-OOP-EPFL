import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	// Completer la classe Auteur ici

	private String nom;
	private boolean prix;
	public Auteur(String nom,boolean prix){
		this.nom=nom;
		this.prix=prix;
	}
	public String getNom(){
		return this.nom;
	}
	public boolean getPrix(){
		return this.prix;
	}


}

class Oeuvre
{
 	// Completer la classe Oeuvre ici
	
	private String titre;
	private String langue="francais";
	private Auteur auteur;
	public Oeuvre(String titre,Auteur a,String langue){
		this.titre=titre;
		this.auteur=a;
		this.langue=langue;
	}
	public Oeuvre(String titre,Auteur a){
		this.titre=titre;
		this.auteur=a;
	}
	public String getTitre(){
		return this.titre;
	}
	public Auteur getAuteur(){
		return this.auteur;
	}
	public String getLangue(){
		return this.langue;
	}
	public void afficher(){
		System.out.println(titre+", "+auteur.getNom()+", en "+langue);
	}
	
	public boolean equals(Oeuvre o){
		if(o==null){
			return false;
		}else{
			return (this.titre.equals(o.getTitre()) && this.langue.equals(o.getLangue()) && this.auteur.equals(o.getAuteur()));
		}
	
	}

	
}




// completer les autres classes ici
class Exemplaire{
	private Oeuvre oeuvre;
	public Exemplaire(Oeuvre o){
		this.oeuvre=o;
		System.out.println("Nouvel exemplaire -> "+o.getTitre()+", "+o.getAuteur().getNom()+", en "+o.getLangue());
	}
	public Exemplaire(Exemplaire e){
		//if(this.oeuvre==e.getOeuvre()){
		    this.oeuvre=e.getOeuvre();
			System.out.println("Copie d'un exemplaire de -> "+this.oeuvre.getTitre()+", "+this.oeuvre.getAuteur().getNom()+", en "+this.oeuvre.getLangue());
		//}
	}
	public Oeuvre getOeuvre(){
		return this.oeuvre;
	}
	public void afficher(){
		System.out.println("Un exemplaire de "+this.oeuvre.getTitre()+", "+this.oeuvre.getAuteur().getNom()+", en "+this.oeuvre.getLangue());
	}


}

class Bibliotheque{
	private String nom;
	private ArrayList<Exemplaire> exemplaires;
	public Bibliotheque(String nom){
		exemplaires=new ArrayList<>();
		this.nom=nom;
		System.out.println("La bibliotheque "+this.nom+" est ouverte !");
	}
	public String getNom(){
		return this.nom;
	}
	public int getNbExemplaires(){
		return this.exemplaires.size();
	}
	public void stocker(Oeuvre o,int nbrExemplaire){
		
		for(int i=0;i<nbrExemplaire;i++){
			this.exemplaires.add(new Exemplaire(o));

		}
	}
	public void stocker(Oeuvre o){	
		this.exemplaires.add(new Exemplaire(o));
	}
	public ArrayList <Exemplaire> listerExemplaires(String langue){
		ArrayList<Exemplaire> exemplairesFiltres=new ArrayList<>();
		String lang;
		for(Exemplaire e:this.exemplaires){
			lang=e.getOeuvre().getLangue();
			//System.out.println();
			if(langue.equals(lang)){
				//e.afficher();
				//System.out.println();
				exemplairesFiltres.add(e);

			}

		}
			
		
		return exemplairesFiltres;

	}
	public ArrayList <Exemplaire> listerExemplaires(){
		
		
			//for(Exemplaire e:this.exemplaires){
				//e.afficher();
				//System.out.println();
			//}
			

		
		return exemplaires;

	}
	
	public int compterExemplaires(Oeuvre o){
		int nbExemplaires=0;
		for(Exemplaire e:this.exemplaires){
			Oeuvre oeuvre=e.getOeuvre();
			if(o.equals(oeuvre)){
				nbExemplaires+=1;
			}
		}
		
		return nbExemplaires;
		
	}

	public void afficherAuteur(boolean prix){
		Oeuvre o;
		Auteur auteur;
		for(Exemplaire e:this.exemplaires){
		    o=e.getOeuvre();
		    auteur=o.getAuteur();
			boolean prixAuteur=auteur.getPrix();
			if(prix){
				if(prixAuteur){	
					System.out.println(auteur.getNom());
				}
			}else{
				if(prixAuteur==false){	
					System.out.println(auteur.getNom());
				}				
			}
		}		

	}
	public void afficherAuteur(){
	    Oeuvre o;
	    Auteur auteur;
	    for(Exemplaire e:this.exemplaires){
		    o=e.getOeuvre();
		    auteur=o.getAuteur();
			boolean prixAuteur=auteur.getPrix();
			if(prixAuteur){	
					System.out.println(auteur.getNom());
			}
			
	    }
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

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}
