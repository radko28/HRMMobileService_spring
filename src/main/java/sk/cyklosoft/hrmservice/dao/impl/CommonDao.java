package sk.cyklosoft.hrmservice.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class CommonDao {
	protected HibernateTemplate hibernateTemplate = null;

	@Autowired
	 public void setSessionFactory(SessionFactory sessionFactory) {
		 hibernateTemplate = new HibernateTemplate(sessionFactory);
	 }
}
