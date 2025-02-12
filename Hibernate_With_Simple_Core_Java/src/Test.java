import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        // Load Hibernate Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Product.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        
        // Open Hibernate Session
        Session session = sessionFactory.openSession();
        
        // Creating Product Object
        Product product = new Product(101, "Milk", 100, 2, "1-1-1", "2-2-2");
        
        // Start Transaction
        session.beginTransaction();
        
        // Save Object
        session.save(product);
        
        // Commit Transaction
        session.getTransaction().commit();
        
        // Close Session
        session.close();
        sessionFactory.close();

        System.out.println("Product inserted successfully!");
    }
}
