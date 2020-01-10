package Jac.mbs.AS.BerettaRadici.dao2;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import Jac.mbs.AS.BerettaRadici.entity2.Macchina;
import Jac.mbs.AS.BerettaRadici.util.HibernateUtil;


public abstract class MacchinaDao {

	private static final Logger log = LogManager.getLogger (MacchinaDao.class);

	public abstract List<Macchina> findByValidDate2(Date date);

	public boolean testConnessione() {
		
		log.debug("try to open session");

		boolean result = false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		
			if (session != null) {
				result = true;
			}
		}
		log.debug("result " + result);
		
		return result;
	}

	public Macchina findMacchinaById2(String id) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			return session.find(Macchina.class, id);
		}
	}


	public List<Macchina> findAll2() {

		log.debug("try to find all entities");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			NativeQuery<Macchina> query = session.createNativeQuery("select * from item", Macchina.class);
	
			List<Macchina> list = query.list();
			
			log.debug("found [" + list.size() + "] entities");
			
			return list;
		}
	}
	
	public List<Macchina> findLimitResults2(int firstIndex, int pageSize) {
		
		log.debug("try to find subset [" + firstIndex + ", "+ pageSize + "]");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			NativeQuery<Macchina> query = session.createNativeQuery("select * from item", Macchina.class);
	
			query.setFirstResult(firstIndex);
			query.setMaxResults(pageSize);
			
			List<Macchina> list = query.list();
			
			log.debug("found [" + list.size() + "] entities");
			
			return list;
		}

	}

	public void save2(Macchina item2) {

		log.debug("try to save item " + item2);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			try {

				session.persist(item2);
				tx.commit();
				log.debug("item saved");
				
			} catch(Exception e) {
				log.error("Error saving item", e);
				tx.rollback();
			}
		}
	}

	public void update2(Macchina item2) {

		log.debug("try to update item " + item2);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			try {
				
				session.update(item2);
				tx.commit();
				log.debug("item updated");
				
			} catch(Exception e) {
				log.error("Error updating item", e);
				tx.rollback();
			}
		}
	}

	public void delete2(Macchina item2) {

		log.debug("try to delete item " + item2);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			try {
				
				session.delete(item2);
				tx.commit();
				log.debug("item deleted");
				
			} catch(Exception e) {
				log.error("Error deleting item", e);
				tx.rollback();
			}
		}		
	}

}