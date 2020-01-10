package Jac.mbs.AS.BerettaRadici.service;


import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import Jac.mbs.AS.BerettaRadici.dao.PedaggioDao;
import Jac.mbs.AS.BerettaRadici.entity.Pedaggio;
import Jac.mbs.AS.BerettaRadici.util.PedaggioFactory;


public class PedaggioService {

//	private ItemDao dao = DaoFactory.createItemNativeDao();
//	private ItemDao dao = DaoFactory.createItemCriteriaDao();
	private PedaggioDao dao = PedaggioFactory.createPedaggioHQLDao();

	public Pedaggio findItemById(int id) {
		return dao.findDocumentoById(id);
	}

	public List<Pedaggio> findAll() {
		return dao.findAll();
	}

	public List<Pedaggio> findByValidDate(Date date) {
		
		return dao.findByValidDate(date);
	}

	public List<Pedaggio> findLimitResults(int firstIndex, int pageSize) {

		return dao.findLimitResults(firstIndex, pageSize);
	}

	public void saveItem(Pedaggio item) {
		
		item.setValidFrom(new Date());
		item.setValidTo(DateUtils.addDays(new Date(), 100));
		
		item.setCreationUser("system");
		item.setCreationTime(new Date());
		
		dao.save(item);
	}

	
}
