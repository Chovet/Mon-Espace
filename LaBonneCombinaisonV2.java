/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la.bonne.combinaison.v2;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Loïc Chovet
 */
public class LaBonneCombinaisonV2 {
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        //Temps avant l'arrivé de la police 3 minute et 20 sec
        Timer timer = new Timer();
        MyTask Time = new MyTask();
        
        timer.scheduleAtFixedRate(Time,0,200);
        

        //Information sur la difficulté
        int choix;      
        Scanner sc = new Scanner(System.in);
        System.out.println("Aide: 0-100/Facile 0-1000/Moyen ?/Difficile");
        System.out.println("Bonjour agent, saisissez le chiffre correspondant à la difficulté...");
        do{
            System.out.println("1/Facile 2/Moyen 3/Difficile");
            choix = sc.nextInt();
        }
        while (choix >3);
        
        //Combinaison du coffre   
        int combinaison;
        int mystere;
        int erreur=0;
        int essais;
        Random rand = new Random();
        System.out.println("Vous devez saisir votre combinaison en trois fois.");
    
     for ( combinaison = 1; combinaison <= 3; combinaison++){
        System.out.println("Veuillez entrer la combinaison n° " + combinaison);
        
         for (mystere = 1; mystere <=3; mystere++){
            
            switch (choix) {
                //De 0-100 pour facile
                case 1:
                    mystere = rand.nextInt(101);
                    break;
                //De 0-1000 pour moyen et difficile
                case 2: case 3:
                    mystere = rand.nextInt(1001);
                    break;
                 default:
                    break;
            }
            
    switch (choix)
    {
        //Pour la difficuté facile et moyen 
        case 1: case 2:
     do{
            System.out.print(":");
            essais = sc.nextInt();
            
            if (essais<mystere){
                System.out.println("C'est plus ! ");
                erreur++;    
            }
            else
            
            if (essais>mystere){
                System.out.println("C'est moins ! ");
                erreur++;
            }
            else
                
            {
                System.out.println("Vous avez trouvé la combinaison n° " + combinaison + " Total " + erreur + " essais !");
            }
        }
        while(essais!=mystere);
     break;
     
        //Pour la difficulté difficile
        case 3:
        do{
            System.out.print(":");
            essais = sc.nextInt();
            
            if (erreur==14){
                System.out.println("Police plus un geste !");
                System.exit(0);  
            }
            else
            
            if (essais<mystere){
                System.out.println("C'est plus ! ");
                erreur++;    
            }
            else
            
            if (essais>mystere){
                System.out.println("C'est moins ! ");
                erreur++;
            }
            else
           
            {
                System.out.println("Vous avez trouvé la combinaison n° " + combinaison + " Total " + erreur + " essais !");
            }
        }
        while(essais!=mystere);
    break; 
     }

        }
    }

         System.out.println("Excellent travail agent !");
         System.out.println("Vous avez déverrouillé le coffre sans avoir attirer les ennuis");
         
    System.exit(0);
    
}        
}

//Alarme silencieuse
    class MyTask extends TimerTask {
        private int times = 0;
        public void run() {
        times++;
        if (times == 1000) {
            System.out.println("Police plus un geste !");
            System.exit(0);
        }       
    }
}
    
