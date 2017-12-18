package sk.cyklosoft.hrmservice.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import sk.cyklosoft.hrmservice.dao.SportDao;
import sk.cyklosoft.hrmservice.model.HRMData;
import sk.cyklosoft.hrmservice.util.SportType;
import sk.cyklosoft.hrmservice.util.TrainType;
import sk.cyklosoft.hrmservice.vo.SportActivity;

@Repository("sportDao")
public class SportDaoImpl extends CommonDao implements SportDao {

	@SuppressWarnings("deprecation")
	@Override
	public void setTrainingDataIndoorCyclo(final HRMData hrm) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				session.save(hrm);
				return null;
			}
		});
	}

	@Override
	public SportActivity getTrainingDataRun(String username, SportType runnig,
			TrainType trainType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HRMData getTrainingDataIndoorCyclo(final String username, final SportType sportType) {
		@SuppressWarnings({ "unchecked", "deprecation" })
		HRMData result = hibernateTemplate.execute(new HibernateCallback<HRMData>() {

			@Override
			public HRMData doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(HRMData.class,"hrmdata");
				criteria.createAlias("hrmdata.users", "users");
				criteria.add(Restrictions.eq("users.username", username));
				criteria.add(Restrictions.eq("hrmdata.sportActivity", sportType));
				criteria.addOrder(Order.desc("hrmdata.datetime"));
				criteria.setMaxResults(1);
				return (HRMData)criteria.uniqueResult();
	          }
	      });

		 return result;
	}

	@Override
	public List<HRMData> getTrainingStatisticList(final String username,
			final SportType sportType, final DateTime dateFrom, final DateTime dateTo) {
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<HRMData> result = (List<HRMData>) hibernateTemplate.execute(new HibernateCallback<List<HRMData>>() {

			@Override
			public List<HRMData> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(HRMData.class,"hrmdata");
				criteria.createAlias("hrmdata.users", "users");
				criteria.add(Restrictions.between("hrmdata.datetime", dateFrom, dateTo));
				criteria.add(Restrictions.eq("users.username", username));
				criteria.add(Restrictions.eq("hrmdata.sportActivity", sportType));
				criteria.addOrder(Order.asc("hrmdata.datetime"));
				return (List<HRMData>)criteria.list();
	          }
	      });

		 return result;
	}

	@Override
	public void setTrainingDataRun(String username, SportType runnig,
			long datetime, double hrm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HRMData getCurrentHRM(String username, SportType sportType) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(final String username) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(HRMData.class,"hrmdata");
				criteria.createAlias("hrmdata.users", "users");
				criteria.add(Restrictions.eq("users.username", username));
                List<HRMData> HRMDataList = criteria.list();
                for(HRMData hrmData : HRMDataList) {
                	session.delete(hrmData);
                }
				return null;
			}
		});

	}

	@SuppressWarnings("deprecation")
	@Override
	public void delete(final String username, final SportType sportType, final DateTime dateFrom,
			final DateTime dateTo) {
		
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(HRMData.class,"hrmdata");
				criteria.createAlias("hrmdata.users", "users");
				criteria.add(Restrictions.between("hrmdata.datetime", dateFrom, dateTo));
				criteria.add(Restrictions.eq("users.username", username));
				criteria.add(Restrictions.eq("hrmdata.sportActivity", sportType));
                List<HRMData> HRMDataList = criteria.list();
                for(HRMData hrmData : HRMDataList) {
                	session.delete(hrmData);
                }
				return null;
			}
		});
	}

}
