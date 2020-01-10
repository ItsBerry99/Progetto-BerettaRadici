package Jac.mbs.AS.BerettaRadici.dao;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Jac.mbs.AS.BerettaRadici.entity.Pedaggio;
import Jac.mbs.AS.BerettaRadici.util.HibernateUtil;


public class PedaggioHQLDao extends PedaggioDao {

	private static final Logger log = LogManager.getLogger(PedaggioHQLDao.class);
	
	@Override
	public List<Pedaggio> findByValidDate(Date date) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Query<Pedaggio> query = session
					.createQuery("from Item where :data between validFrom and validTo", Pedaggio.class);

			query.setParameter("data", date);
			
			List<Pedaggio> list = query.list();

			log.debug("found [" + list.size() + "] entities");

			return list;

		}	
	
	}

}
