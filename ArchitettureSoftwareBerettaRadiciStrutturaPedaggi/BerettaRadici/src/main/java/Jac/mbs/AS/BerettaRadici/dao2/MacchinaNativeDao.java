package Jac.mbs.AS.BerettaRadici.dao2;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import Jac.mbs.AS.BerettaRadici.entity2.Macchina;
import Jac.mbs.AS.BerettaRadici.util.HibernateUtil;


public class MacchinaNativeDao extends MacchinaDao {

	private static final Logger log = LogManager.getLogger(MacchinaNativeDao.class); 
	
	public List<Macchina> findByValidDate2(Date date) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			NativeQuery<Macchina> query = session
					.createNativeQuery("select * from item where ? between validFrom and validTo", Macchina.class);

			query.setParameter(1, date);

			List<Macchina> list = query.list();

			log.debug("found [" + list.size() + "] entities");

			return list;

		}
	}

}


