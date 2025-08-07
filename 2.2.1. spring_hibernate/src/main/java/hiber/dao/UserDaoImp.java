package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Transactional
   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = (TypedQuery<User>) sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User findUserByCar(String model, int series) {
      String query = "SELECT u FROM User u WHERE u.car.model = :model AND u.car.series = :series";
      return sessionFactory.getCurrentSession()
              .createQuery(query, User.class)
              .setParameter("model", model)
              .setParameter("series", series)
              .setMaxResults(1)
              .uniqueResult();
   }

   @Override
   public void save(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
}
