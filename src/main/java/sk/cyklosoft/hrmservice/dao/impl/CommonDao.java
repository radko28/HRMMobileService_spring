package sk.cyklosoft.hrmservice.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class CommonDao {
	 @SuppressWarnings("deprecation")
	protected HibernateTemplate hibernateTemplate = null;

	 @SuppressWarnings("deprecation")
	@Autowired
	 public void setSessionFactory(SessionFactory sessionFactory) {
		 hibernateTemplate = new HibernateTemplate(sessionFactory);
	 }
}
