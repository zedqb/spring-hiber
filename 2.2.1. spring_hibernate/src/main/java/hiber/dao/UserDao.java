package hiber.dao;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface UserDao {

   @Transactional
   void add(User user);

   List<User> listUsers();

   User findUserByCar(String model, int series);

   void save(User user);
}
