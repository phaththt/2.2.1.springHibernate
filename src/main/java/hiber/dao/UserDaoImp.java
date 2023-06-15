package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @SuppressWarnings("unchecked")
   @Override
   public User getUserByCar(String model, int series) {
      String str = ("from User user where user.empCar.model = :model and user.empCar.series = :series");
      TypedQuery<User> typedQuery = sessionFactory.getCurrentSession()
              .createQuery(str);
              typedQuery.setParameter("model", model).setParameter("series", series);
      return typedQuery.setMaxResults(1).getSingleResult();
   }

}
