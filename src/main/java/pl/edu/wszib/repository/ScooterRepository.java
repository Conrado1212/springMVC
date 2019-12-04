package pl.edu.wszib.repository;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import pl.edu.wszib.model.Scooter;
import java.util.List;

@Component
public class ScooterRepository {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static void addScooter(Scooter scooter){
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.save(scooter);
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();
        }finally{
            session.close();
        }
    }
    public  static  Scooter getScooter(int Id){
        Session session = factory.openSession();

        Scooter scooter =
                (Scooter) session.createQuery("FROM pl.edu.wszib.model.Scooter WHERE id = " + Id).uniqueResult();

        session.close();
        return scooter;
    }
    public static void getUpdate(int Id,Scooter scooter){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.get(Scooter.class,Id);

            session.update(scooter);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally{
            session.close();
        }
    }

    public static void  removeScooterId(int Id){
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Scooter scooter =
                    (Scooter) session.get(Scooter.class, Id);
            session.delete(scooter);
            //wiecej operacji
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();//wycofanie czynnosci
        }finally {
            session.close();
        }
    }
    public static List<Scooter> getAllScooterXiaomi() {
        Session session = factory.openSession();

        List<Scooter> allScooterXiomi =
                session.createQuery("FROM pl.edu.wszib.model.Scooter Where brand = 'Xiaomi'").list();

        return allScooterXiomi;
    }

    public static List<Scooter> getAllScooters() {
        Session session = factory.openSession();

        List<Scooter> allScooter = session.createQuery("FROM pl.edu.wszib.model.Scooter ").list();

        return allScooter;
    }

    public static List<Scooter> getAllScooterFiat() {
        Session session = factory.openSession();

        List<Scooter> allScooterFiat =
                session.createQuery("FROM pl.edu.wszib.model.Scooter Where brand = 'Fiat'").list();

        return allScooterFiat;

    }
}
