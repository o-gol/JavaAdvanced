package ru.yandex.olejkai.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import org.jboss.logging.Logger;
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
    private static final Logger LOG=Logger.getLogger(PeopleDAOHibernate.class);


    //    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPeople(People people) {
        if (people.getId() == 0) {
//        if (people.getId() == 0 || people.getId() < People.getGlobId()) {
            People.setGlobId(getMaxId());
            int id = People.getGlobId() + 1;
            People.setGlobId(id);
            people.setId(id);

        }
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(people);
            session.getTransaction().commit();
        }


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
        People people = getPeopleByID(id);
        if (people != null) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.delete(people);
                session.getTransaction().commit();
            }
        }


    }

    @Override
    public List<People> getAllPeople() {

//        return sessionFactory.getCurrentSession().createQuery("from People").list();
        List<People> peopleList;
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
        return peopleList;
    }

    @Override
    public void updatePeople(
            People peopleForUpdate
            , People peopleFromUpdate) {
//        sessionFactory.getCurrentSession().update(peopleFromUpdate);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(peopleFromUpdate);
            session.getTransaction().commit();
        }

    }

    @Override
    public int getMaxId() {
        int max = 0;
        try (Session session = sessionFactory.openSession()) {
            max = (int) session.createQuery("SELECT max(id) from People")
                    .getSingleResult();
        }
        LOG.warn(String.format("now id is %s",max));
        return max;
    }


    public void manySave() {

        People.setGlobId(getMaxId());
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            for (int i = 0; i < 2000; i++) {
                for (int j = 0; j < 100; j++) {
                    People people=new People(String.format("People%s%s", i, j)
                            , String.format("PeopleSurname%s%s", i, j)
                            , i + j
                            , String.format("People%s%s@uyt.yu", i, j)
                    );
                    if (people.getId() == 0) {
//        if (people.getId() == 0 || people.getId() < People.getGlobId()) {
                        int id = People.getGlobId() + 1;
                        People.setGlobId(id);
                        people.setId(id);

                    }
                    session.save(people);
                    LOG.info(String.format("add to db %s",people));
                }

                /*session.flush();
                LOG.warn("do flash");*/
            }
            session.getTransaction().commit();

        }
    }
}
