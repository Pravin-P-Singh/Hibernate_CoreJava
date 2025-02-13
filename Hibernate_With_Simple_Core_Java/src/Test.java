import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        // Load Hibernate Configuration
        Configuration cfg = new Configuration();
        
        //cfg.configure()- ye sirf point out karta hai ki kaunsi file read karni hai(here it points to hibernate.cfg.xml) for configuration of hibernate
        //addAnnotatedClass() - Jinka relation table ke sath banana hai us entity class ko yaha mention karo
        //database mai class ban jata hai table aur class ke variables ban jate hai column
        cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Product.class);
        
        //buildSessionFactory() - jo bhi cfg file point out hui hai use build karo
        //build hote time vo sari properties read hoti hai hibernate.cfg.xml ki aur isi ke according configuration kiya jata hai
        //jo configuration banta hai usi ko nam de diya sessionFactory
        //ab sessionFactory ko database ke bare mai sab pata hai
        //sessionFactory database se associated hai
        //sessionFactory ko pata hai user kya, hai password kya hai,kis database mai entry karna hai ,etc (hint :: hibernate.cfg.xml).
        //buildSessionFactory() - ye internally connection banake diya hai
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        
        // Open Hibernate Session
        //session ko bhi ab database ke bare mai sab information ajayegi kyuki vo sessionFactory ka hi istemal kar rha hai
        //sessionFactory mai already database ki information hai - user,password,kis format mai query generate karni hai, etc
        Session session = sessionFactory.openSession();
        
        // Creating Product Object
        Product product = new Product(101, "Milk", 100, 2, "1-1-1", "2-2-2");
        
        // Start Transaction
        session.beginTransaction();
        
        // Save Object
        //save matlab insert karna hai database mai
        //session kaha se nikla? - sessionFactory se ! Aur sessionFactory ko to pata hai sare database configurations
        //Dialect - MySQL8Dialect - Isse pata chalta hai ki query kisme banani hai (here it is for insert query) hibernate ko
        
        session.save(product);
        
        // Commit Transaction
        session.getTransaction().commit();
        
        // Close Session
        session.close();
        sessionFactory.close();

        System.out.println("Product inserted successfully!");
    }
}
