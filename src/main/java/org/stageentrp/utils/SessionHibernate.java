package org.stageentrp.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class SessionHibernate {
    //Je place une session dans un Thread
    public static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    public static SessionFactory sessionfactory;
    private static StandardServiceRegistry serviceRegistry;

    static{
        try{
            System.out.println(new Date() + " : initialisation de la session");
            //recup la config d'hibernate dans le fichier hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();
            //On enregistre un service registry
            //Pour gérer la conf d'hibernate par rapport à notre session
            serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            //On instancie notre session factory
            //Pour créer des sessions
            sessionfactory = configuration.buildSessionFactory(serviceRegistry);


        } catch(Throwable e){
            e.printStackTrace();
        }
    }

    /**
     * Methode static qui permet de récupérer une session
     * @return Session
     */
    public static Session currentSession(){
        //Je recup la session du thread en cours
        Session session = (Session) threadSession.get();
        //Si je n'ai pas de session
        if(session == null){
            System.out.println("Je n'ai pas de session active");
            //J'ouvre une session avec mon obj sessionfactory
            System.out.println("J'ouvre une nouvelle session");
            session = sessionfactory.openSession();
            //Je l'injecte dans le thread en cours
            System.out.println("J'injecte ma session dans mon thread en cours");
            threadSession.set(session);
        }
        //Je retourne ma session
        System.out.println("J'ai bien récuperer ma session");
        return session;

    }

    /**
     * Méthode static pour fermer une session
     */
    public static void closeSession(){
        //Je recup la session en Thread en cours
        Session session = (Session) threadSession.get();
        //Si j'ai une session, je la ferme
        if(session != null) session.close();
        //Je set à null mon Thread en cours
        threadSession.set(null);
        System.out.println("J'ai bien fermé ma session");
    }
}
