package Jac.mbs.AS.BerettaRadici.util;

import Jac.mbs.AS.BerettaRadici.dao.PedaggioCriteriaDao;
import Jac.mbs.AS.BerettaRadici.dao.PedaggioDao;
import Jac.mbs.AS.BerettaRadici.dao.PedaggioHQLDao;
import Jac.mbs.AS.BerettaRadici.dao.PedaggioNativeDao;

public class PedaggioFactory {

	public static PedaggioDao createPedaggioNativeDao() {
		
		return new PedaggioNativeDao();
	}
	
	public static PedaggioDao createPedaggioHQLDao() {
	
		return new PedaggioHQLDao();
	}
	
	public static PedaggioDao createPedaggioCriteriaDao() {
		
		return new PedaggioCriteriaDao();
	}
}
