package Jac.mbs.AS.BerettaRadici.dao;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import Jac.mbs.AS.BerettaRadici.entity.Pedaggio;
import Jac.mbs.AS.BerettaRadici.util.HibernateUtil;


public abstract class PedaggioDao {

	private static final Logger log = LogManager.getLogger (PedaggioDao.class);

	public abstract List<Pedaggio> findByValidDate(Date date);

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

	public Pedaggio findDocumentoById(int idMulta) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			return session.find(Pedaggio.class, idMulta);
		}
	}


	public List<Pedaggio> findAll() {

		log.debug("try to find all entities");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			NativeQuery<Pedaggio> query = session.createNativeQuery("select * from item", Pedaggio.class);
	
			List<Pedaggio> list = query.list();
			
			log.debug("found [" + list.size() + "] entities");
			
			return list;
		}
	}
	
	public List<Pedaggio> findLimitResults(int firstIndex, int pageSize) {
		
		log.debug("try to find subset [" + firstIndex + ", "+ pageSize + "]");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			NativeQuery<Pedaggio> query = session.createNativeQuery("select * from item", Pedaggio.class);
	
			query.setFirstResult(firstIndex);
			query.setMaxResults(pageSize);
			
			List<Pedaggio> list = query.list();
			
			log.debug("found [" + list.size() + "] entities");
			
			return list;
		}

	}

	public void save(Pedaggio item) {

		log.debug("try to save item " + item);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			try {

				session.persist(item);
				tx.commit();
				log.debug("item saved");
				
			} catch(Exception e) {
				log.error("Error saving item", e);
				tx.rollback();
			}
		}
	}

	public void update(Pedaggio item) {

		log.debug("try to update item " + item);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			try {
				
				session.update(item);
				tx.commit();
				log.debug("item updated");
				
			} catch(Exception e) {
				log.error("Error updating item", e);
				tx.rollback();
			}
		}
	}

	public void delete(Pedaggio item) {

		log.debug("try to delete item " + item);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			try {
				
				session.delete(item);
				tx.commit();
				log.debug("item deleted");
				
			} catch(Exception e) {
				log.error("Error deleting item", e);
				tx.rollback();
			}
		}		
	}

}
