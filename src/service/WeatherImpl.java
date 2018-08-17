package service;

import bean.WeatherEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WeatherImpl implements WeatherService {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public WeatherEntity getWeather(String city) {
//        String hql="from weather where city=?";
        Session s=sessionFactory.openSession();
        Transaction tr=s.beginTransaction();
        CriteriaBuilder crb=s.getCriteriaBuilder();
        CriteriaQuery<WeatherEntity> query=crb.createQuery(WeatherEntity.class);
        Root<WeatherEntity> root=query.from(WeatherEntity.class);
        query.select(root);
        query.where(crb.like(root.get("city"),city));
        List<WeatherEntity> lists=s.createQuery(query).getResultList();
        WeatherEntity WeatherEntity=lists.get(0);
        tr.commit();
        return null;
//        return WeatherEntity;
    }

    @Override
    public void saveWeather(WeatherEntity weather) {
        Session s=sessionFactory.openSession();
        Transaction tx=s.beginTransaction();
        s.save(weather);
        tx.commit();
    }

    @Override
    public void deleteWeather(String city) {

    }

    @Override
    public void updateWeather(WeatherEntity weather) {

    }
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
}
