import java.util.Scanner;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Tirelire{
	private double montant;
	//une m�thode getMontant retournant le montant de la tirelire;
	public double getMontant() {
		return this.montant;
	}
	
	//� une m�thode afficher affichant les donn�es de la tirelire sous le format
	//suivant :
	
	//� Vous etes sans le sou.
	//si la tirelire ne contient pas d�argent (les accents on �t� d�lib�r�ment
	//omis pour �viter les probl�mes d�encodage)
	//� Vous avez : <montant> euros dans votre tirelire.
	//dans le cas contraire (o� <montant> est le montant de la tirelire, affich� sans formattage particulier)
	public void afficher() {
		if(getMontant()==0) {
			System.out.println("Vous etes sans le sou.");
		}else {
			System.out.println("Vous avez : "+this.getMontant()+ " euros dans votre tirelire.");
		}
	}
	
	//� une m�thode secouer affichant sur le terminal le message Bing bing,
	//suivi d�un saut de ligne, dans le cas o� la tirelire contient de l�argent, et
	//qui n�affiche rien sinon;
	public void secouer() {
		if(getMontant()!=0) {
			System.out.println("Bing bing");
		}
			
	}
	
	//� la m�thode remplir mettant un montant donn� en param�tre (double)
	//dans la tirelire. Seuls les montant positifs seront accept�s (dans le cas
	//contraire on ne fait rien);
	
	public void remplir(double montant) {
		if(montant >0) {
			this.montant+=montant;		
		}	
	}
	//� une m�thode vider (re)intialisant le montant de la tirelire � z�ro;
	public void vider() {
		this.montant=0.0;
	}
	//� une m�thode puiser permettant de puiser dans la tirelire un montant
	//donn� en param�tre. Si le montant est n�gatif il sera ignor�. Si le montant
	//en argument est plus grand que le montant disponible, la tirelire est alors
	//vid�e. La m�thode puiser ne retourne rien
	
	public void puiser(double montant) {
		if(montant>=0) {
			if(montant>=getMontant()) {
				this.vider();
			}else {
				this.montant-=montant;
				
			}
		}
	}
	//� une m�thode calculerSolde qui retourne la diff�rence 
	//entre le montant de la tirelire et le budget que l�on souhaite d�penser (un double). 
	//Si le budget est n�gatif (ou nul), 
	//la m�thode calculerSolde doit retourner le montant de la tirelire.
	
	public double calculerSolde(double budget) {
		if(budget<=0) {
			return this.getMontant();
			
		}else {
			return this.getMontant()-budget;
		}	
	}
	
	
	

	
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
public class TestTirelire {

    public static void main(String[] args) {
        Tirelire piggy = new Tirelire();

        piggy.vider();
        piggy.secouer();
        piggy.afficher();

        piggy.puiser(20.0);
        piggy.secouer();
        piggy.afficher();

        piggy.remplir(550.0);
        piggy.secouer();
        piggy.afficher();

        piggy.puiser(10.0);
        piggy.puiser(5.0);
        piggy.afficher();

        System.out.println();

        // le budget de vos vacances de r�ves.
        double budget;
        Scanner clavier = new Scanner(System.in);

        System.out.println("Donnez le budget de vos vacances : ");
        budget = clavier.nextDouble();

        // ce qui resterait dans la tirelire apr�s les
        // vacances
        double solde = piggy.calculerSolde(budget);

        if (solde >= 0) {
            System.out.println("Vous etes assez riche pour partir en vacances !");
            System.out.print(" il vous restera " + solde + " euros");
            System.out.print(" a la rentree \n");
            piggy.puiser(budget);
        }

        else {
            System.out.print("Il vous manque " + (-solde) + " euros");
            System.out.print(" pour partir en vacances !\n");
        }
        clavier.close();
    }
}
