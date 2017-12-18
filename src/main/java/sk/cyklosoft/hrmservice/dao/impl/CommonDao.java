package sk.cyklosoft.hrmservice.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class CommonDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected HibernateTemplate hibernateTemplate = null;

	@Autowired
	 public void setSessionFactory(SessionFactory sessionFactory) {
		 hibernateTemplate = new HibernateTemplate(sessionFactory);
	 }
}
