
import javax.swing.JFrame;

public class Fenetre extends JFrame{
        public Fenetre(){
          this.setTitle("Accueil");
          this.setSize(400, 500);
          this.setLocationRelativeTo(null);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
          this.setVisible(true);
        }
}
