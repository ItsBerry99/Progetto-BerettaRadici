package Jac.mbs.AS.BerettaRadici.service2;


import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import Jac.mbs.AS.BerettaRadici.dao2.MacchinaDao;
import Jac.mbs.AS.BerettaRadici.entity2.Macchina;
import Jac.mbs.AS.BerettaRadici.util.MacchinaFactory;


public class MacchinaService {

//	private ItemDao dao = DaoFactory.createItemNativeDao();
//	private ItemDao dao = DaoFactory.createItemCriteriaDao();
	private MacchinaDao dao = MacchinaFactory.createMacchinaHQLDao();

	public Macchina findItemById2(String id) {
		return dao.findMacchinaById2(id);
	}

	public List<Macchina> findAll2() {
		return dao.findAll2();
	}

	public List<Macchina> findByValidDate2(Date date) {
		
		return dao.findByValidDate2(date);
	}

	public List<Macchina> findLimitResults2(int firstIndex, int pageSize) {

		return dao.findLimitResults2(firstIndex, pageSize);
	}

	public void saveItem2(Macchina item2) {
		
		item2.setValidFrom(new Date());
		item2.setValidTo(DateUtils.addDays(new Date(), 100));
		
		item2.setCreationUser("system");
		item2.setCreationTime(new Date());
		
		dao.save2(item2);
	}

	
}
