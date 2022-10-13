class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	private int poids;
	private String couleur;
	private int age;
	private int esperanceVie;
	private boolean clonee;
	
	public Souris(int poids,String couleur,int age,int esperanceVie){
		this.poids=poids;
		this.couleur=couleur;
		this.age=age;
		this.esperanceVie=esperanceVie;
		System.out.println("Une nouvelle souris !");
	}	

	public Souris(int poids,String couleur,int age){
		this.poids=poids;
		this.couleur=couleur;
		this.age=age;
		this.esperanceVie=ESPERANCE_VIE_DEFAUT;
		System.out.println("Une nouvelle souris !");
	}
	public Souris(int poids,String couleur){
		this.poids=poids;
		this.couleur=couleur;
		this.esperanceVie=ESPERANCE_VIE_DEFAUT;
		System.out.println("Une nouvelle souris !");
	}
	public Souris(Souris s){
		this.poids=s.poids;
		this.couleur=s.couleur;
		this.age=s.age;
		this.esperanceVie=(4*s.esperanceVie)/5;
		this.clonee=true;
		System.out.println("Clonage d'une souris !");
	}
	public String toString(){
		String s;
		if(this.clonee){
			s=", clonee, ";
		
		}else {
		    s=" ";
		}
		
		return "Une souris "+couleur+s+ "de "+age+" mois et pesant "+poids+" grammes";
	}
	public void vieillir(){
		this.age+=1;
		if(this.clonee && this.age>this.esperanceVie/2.0){
			this.couleur="verte";		
		}
	}
	public void evolue(){
		this.age=this.esperanceVie;
		if(this.clonee && this.age>this.esperanceVie/2.0){
			this.couleur="verte";		
		}		
	}

}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}