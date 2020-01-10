package Jac.mbs.AS.BerettaRadici.dao2;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import Jac.mbs.AS.BerettaRadici.entity2.Macchina;
import Jac.mbs.AS.BerettaRadici.util.HibernateUtil;


public class MacchinaCriteriaDao extends MacchinaDao {

	@Override
	public List<Macchina> findByValidDate2(Date date) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Macchina> criteria = criteriaBuilder.createQuery(Macchina.class);
			
			Root<Macchina> root = criteria.from(Macchina.class);
			criteria.select(root);
			criteria.where(criteriaBuilder.between(criteriaBuilder.literal(date), root.<Date>get("validFrom"), root.<Date>get("validTo")));
			
			return session.createQuery(criteria).getResultList();
		}
		
	}

}