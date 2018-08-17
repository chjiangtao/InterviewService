package service;

import bean.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserImpl implements UserService {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(UserEntity user) {
        Session s=sessionFactory.openSession();
        Transaction tx=s.beginTransaction();
        s.save(user);
        tx.commit();
    }

    @Override
    public void read(int id) {
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        UserEntity user=session.get(UserEntity.class,id);
        System.out.println(user.getName()+"   "+user.getPassword());
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
}
