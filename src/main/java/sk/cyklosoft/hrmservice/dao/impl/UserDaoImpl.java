package sk.cyklosoft.hrmservice.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import sk.cyklosoft.hrmservice.dao.UserDao;
import sk.cyklosoft.hrmservice.model.User;
import sk.cyklosoft.hrmservice.util.SportType;

@Repository("userDao")
public class UserDaoImpl extends CommonDao implements UserDao {

	@SuppressWarnings("deprecation")
	@Override
	public void register(final User user) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				session.save(user);
				return null;
			}
		});
		
	}
	
    @Override
    public User findUserByUsername(final String username) {
        @SuppressWarnings({ "unchecked", "deprecation" })
        User result = hibernateTemplate.execute(new HibernateCallback<User>() {

            @Override
            public User doInHibernate(Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(User.class);
                criteria.add(Restrictions.eq("username", username));
                return (User)criteria.uniqueResult();
            }
        });

        return result;
    }


	
	@Override
	public SportType getCurrentActivity(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(String username, SportType sportType) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(final User user) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				session.delete(user);
				return null;
			}
		});
		
	}

	@Override
	public List<User> findAllUsers() {
        @SuppressWarnings({ "unchecked", "deprecation" })
        List<User> result = hibernateTemplate.execute(new HibernateCallback<List<User>>() {

            @Override
           public List<User> doInHibernate(Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(User.class);
                return (List<User>)criteria.list();
         }
        });
       return result;
	}

    @Override
    public User findUserById(final Long userId) {
        @SuppressWarnings({ "unchecked", "deprecation" })
        User result = hibernateTemplate.execute(new HibernateCallback<User>() {

            @Override
            public User doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(User.class);
                criteria.add(Restrictions.eq("id", userId));
                return (User)criteria.uniqueResult();
            }
        });

        return result;
    }

	@SuppressWarnings("deprecation")
    @Override
    public void update(final User user) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.update(user);
                return null;
            }
        });
    }

    
}
