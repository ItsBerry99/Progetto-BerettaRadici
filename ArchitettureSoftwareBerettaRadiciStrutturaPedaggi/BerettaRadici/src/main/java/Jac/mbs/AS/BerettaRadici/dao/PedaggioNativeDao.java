package Jac.mbs.AS.BerettaRadici.dao;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import Jac.mbs.AS.BerettaRadici.entity.Pedaggio;
import Jac.mbs.AS.BerettaRadici.util.HibernateUtil;


public class PedaggioNativeDao extends PedaggioDao {

	private static final Logger log = LogManager.getLogger(PedaggioNativeDao.class); 
	
	public List<Pedaggio> findByValidDate(Date date) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			NativeQuery<Pedaggio> query = session
					.createNativeQuery("select * from item where ? between validFrom and validTo", Pedaggio.class);

			query.setParameter(1, date);

			List<Pedaggio> list = query.list();

			log.debug("found [" + list.size() + "] entities");

			return list;

		}
	}

}
