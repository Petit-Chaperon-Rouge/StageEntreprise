package org.stageentrp.repositories;

import org.stageentrp.utils.SessionHibernate;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

//<T> rend la classe générique / T sera remplacer par une Entity
public abstract class MySQLRepository<T> {

    /**
     * Permet de récupérer un object
     * @param id int
     * @return Element
     */
    public T get(int id, Class<T> type) {
        Session session = SessionHibernate.currentSession();
        return session.get(type, id);     // (classe de l'entity, id)
    }

    /**
     * Permet de sauvegarder un object
     * @param {T} object
     */
    public void save(T object){
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }

    /**
     * Permet de recuperer une liste d'objects
     * @return List
     */
    public List<T> getAll(Class<T> type) {
        Session session = SessionHibernate.currentSession();
        // On récupère le builder pour construire notre requete
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        // On commence a construire la reqest en indiquant la class cible
        CriteriaQuery query = criteriaBuilder.createQuery(type);
        Root<T> root = query.from(type);
        // On continue la construction de la request avec le FROM
        CriteriaQuery<T> all = query.select(root);
        // On récup toute la request
        TypedQuery<T> allQuery = session.createQuery(all);
        // On execute la request
        return allQuery.getResultList();
    }

    /**
     * Permet de supprimer un object
     * @param object
     */
    public void delete(T object){
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }

    /**
     * Permet de mettre à jour un object
     * @param object
     */
    public void update(T object){
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }
}
