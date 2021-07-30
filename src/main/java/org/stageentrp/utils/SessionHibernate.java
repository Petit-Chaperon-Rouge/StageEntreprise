package org.stageentrp.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.util.Date;

public class SessionHibernate {
    // Je place une session dans un Thread
    public static final ThreadLocal<Session> threadSession = new ThreadLocal<>();
    public static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    static {
        try {
            System.out.println(new Date() + " : Initialisation de la session");
            // Récuperer la configuration d'hibernate
            // Dans le fichier hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();
            // On instancie un serviceRegistry
            // Gérer la conf d'hibernate sur notre session
            serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            // On instancie notre session factory
            // Créer des sessions
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode Static qui permet de recuperer une session
     * @return {Session}
     */
    public static Session currentSession()  {
        // Je récupère la session du Thread en cours
        Session session = (Session) threadSession.get();
        // Si je n'ai pas de Session
        if (session == null) {
            System.out.println("Je n'ai pas de session active");
            // J'ouvre une session avec mon objet SessionFactory
            System.out.println("J'ouvre une nouvelle session");
            session = sessionFactory.openSession();
            // Je l'injecte dans le Thread en cours
            System.out.println("J'injecte ma session dans mon Thread en cours");
            threadSession.set(session);
        }
        // je retourne ma session
        System.out.println("J'ai bien récupéré ma session");
        return session;
    }

    /**
     * Methode static pour fermer une session
     */
    public static void closeSession() {
        // Je récupère la session du Thread en cours
        Session session = (Session) threadSession.get();
        // Si j'ai une Session, je la ferme
        if (session != null) session.close();
        // Je set à null mon Thread en cours
        threadSession.set(null);
        System.out.println("J'ai bien fermé ma session");
    }

}
