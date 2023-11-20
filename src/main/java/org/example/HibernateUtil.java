package org.example;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.io.File;

public class HibernateUtil {

//     private static final SessionFactory sessionFactory = buildSessionFactory();
//
//     private static SessionFactory buildSessionFactory(){
//           try {
//               return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
//           }   catch (Throwable e) {
//                    System.err.println("Initial sessionFactory creation failed" + e);
//                    throw new ExceptionInInitializerError(e);
//           }
//     }
//
//     public static SessionFactory getSessionFactory(){return sessionFactory;}
//
//     public static void shutdown(){
//          getSessionFactory().close();
//     }

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
