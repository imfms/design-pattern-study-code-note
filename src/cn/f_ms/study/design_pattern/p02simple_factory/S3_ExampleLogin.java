package cn.f_ms.study.design_pattern.p02simple_factory;

/**
 * 实例-登录
 *
 * @author f_ms
 * @date 18-8-25
 */
public class S3_ExampleLogin {

    public static class UserInfo {
        String id;
        String password;
    }

    public interface UserDao {
        UserInfo findUserById(String userId);
    }

    public static class JdbcUserDao implements UserDao {
        @Override
        public UserInfo findUserById(String userId) {
            UserInfo userInfo = new UserInfo();
            userInfo.id = userId;
            userInfo.password = "password";
            return userInfo;
        }
    }

    public static class HibernateUserDao implements UserDao {
        @Override
        public UserInfo findUserById(String userId) {
            UserInfo userInfo = new UserInfo();
            userInfo.id = userId;
            userInfo.password = "password";
            return userInfo;
        }
    }

    public static class UserDaoFactory {
        public static UserDao createUserDao(String type) {
            switch (type) {
                case "jdbc":
                    return new JdbcUserDao();
                case "hibernate":
                    return new HibernateUserDao();
                default:
                    throw new RuntimeException("unknown type");
            }
        }
    }

    public static class LoginAction {
       private UserDao userDao;

        public LoginAction(String daoType) {
            userDao = UserDaoFactory.createUserDao(daoType);
        }

        public boolean login(String userId, String password) {
            return userDao.findUserById(userId).password.equals(password);
        }
    }

   public static void main(String[] args) {
       String userId = "1";
       String password = "password";

       boolean result = new LoginAction("jdbc").login(userId, password);
       System.out.println("login status: " + result);
   }

}
