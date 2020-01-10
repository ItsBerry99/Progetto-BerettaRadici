package Jac.mbs.AS.BerettaRadici.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import Jac.mbs.AS.BerettaRadici.entity.Pedaggio;
import Jac.mbs.AS.BerettaRadici.util.HibernateUtil;


public class PedaggioCriteriaDao extends PedaggioDao {

	@Override
	public List<Pedaggio> findByValidDate(Date date) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Pedaggio> criteria = criteriaBuilder.createQuery(Pedaggio.class);
			
			Root<Pedaggio> root = criteria.from(Pedaggio.class);
			criteria.select(root);
			criteria.where(criteriaBuilder.between(criteriaBuilder.literal(date), root.<Date>get("validFrom"), root.<Date>get("validTo")));
			
			return session.createQuery(criteria).getResultList();
		}
		
	}

}