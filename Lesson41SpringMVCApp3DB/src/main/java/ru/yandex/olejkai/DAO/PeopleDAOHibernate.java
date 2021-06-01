package ru.yandex.olejkai.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.yandex.olejkai.model.People;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Qualifier("hibernate")
public class PeopleDAOHibernate implements PeopleDAO {

    //    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPeople(People people) {

    }

    /*@Override
    public void deletePeople(People people) {

    }

    @Override
    public People getPeople(People people) {
        return null;
    }*/

    @Override
    public People getPeopleByID(int id) {
        People people;
        try (Session session = sessionFactory.openSession()) {
            people = session.get(People.class, id);
        }
        return people;
//        return null;
    }

    @Override
    public void deletePeopleByID(int id) {

    }

    @Override
    public List<People> getAllPeople() {

        return sessionFactory.getCurrentSession().createQuery("from People").list();
       /* List<People> peopleList;
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery cq = sessionFactory
                    .getCurrentSession()
                    .getCriteriaBuilder()
                    .createQuery(People.class);
            Root<People> root = cq.from(People.class);
            cq.select(root);
            peopleList = session.createQuery(cq)
                    .getResultList();
        }
        return peopleList;*/
    }

    @Override
    public void updatePeople(People peopleForUpdate, People peopleFromUpdate) {

    }

    @Override
    public int getMaxId() {
        return 0;
    }
}
