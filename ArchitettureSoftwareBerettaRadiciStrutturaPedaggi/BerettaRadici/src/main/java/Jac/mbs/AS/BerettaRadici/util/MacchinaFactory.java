package Jac.mbs.AS.BerettaRadici.util;

import Jac.mbs.AS.BerettaRadici.dao2.MacchinaCriteriaDao;
import Jac.mbs.AS.BerettaRadici.dao2.MacchinaDao;
import Jac.mbs.AS.BerettaRadici.dao2.MacchinaHQLDao;
import Jac.mbs.AS.BerettaRadici.dao2.MacchinaNativeDao;

public class MacchinaFactory {

	public static MacchinaDao createMacchinaNativeDao() {
		
		return new MacchinaNativeDao();
	}
	
	public static MacchinaDao createMacchinaHQLDao() {
	
		return new MacchinaHQLDao();
	}
	
	public static MacchinaDao createMacchinaCriteriaDao() {
		
		return new MacchinaCriteriaDao();
	}
}
