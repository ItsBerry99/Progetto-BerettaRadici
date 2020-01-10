package Jac.mbs.AS.BerettaRadici;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Jac.mbs.AS.BerettaRadici.dao.PedaggioDao;
import Jac.mbs.AS.BerettaRadici.dao2.MacchinaDao;
import Jac.mbs.AS.BerettaRadici.entity.Pedaggio;
import Jac.mbs.AS.BerettaRadici.entity2.Macchina;
import Jac.mbs.AS.BerettaRadici.service.PedaggioService;
import Jac.mbs.AS.BerettaRadici.service2.MacchinaService;
import Jac.mbs.AS.BerettaRadici.util.HibernateUtil;
import Jac.mbs.AS.BerettaRadici.util.PedaggioFactory;

import Jac.mbs.AS.BerettaRadici.Pattern.Eventi;

public class MainApp {

	private static final Logger log = LogManager.getLogger(MainApp.class);

	public static void main(String[] args) {

		log.info("App Started");

		HibernateUtil.getSessionFactory();

		do {

			System.out.println("Scegliere la funzione: \n");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();

			switch (s) {
			case "1": {

				System.out.println("Test connessione");
				PedaggioDao dao = PedaggioFactory.createPedaggioNativeDao();

				boolean test = dao.testConnessione();
				if (test) {

					log.info("Test OK");
				}

				break;
			}

			case "2": {

				System.out.println("crea la multa: \n");

				Pedaggio item = createItemFromUserInput();

				PedaggioService service = new PedaggioService();
				service.saveItem(item);

				break;

			}
			case "3": {

				System.out.println("inserisci la macchina: \n");

				Macchina item2 = createItemFromUserInput2();

				MacchinaService service = new MacchinaService();
				service.saveItem2(item2);

				break;

			}
			case "4": {


				System.out.println("Verifica Passaggio Auto");
				
				new Eventi("Gestione degli eventi");
			
				System.out.println("Inserisci auto appena passata: ");
				Scanner in3 = new Scanner(System.in);
			    String t1 = in3.nextLine();

				Controllo(t1);

				break;

			}

			}

		} while (true);

	}

	private static Pedaggio createItemFromUserInput() {

		Pedaggio item = new Pedaggio();
		MacchinaService mdao = new MacchinaService();
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		System.out.print("imposta la targa della macchina multata: \n");
		Macchina m = new Macchina();
		m = mdao.findItemById2(in.nextLine());
		item.setTarga(m);

		System.out.print("imposta la stazione: \n");
		item.setStazione(in.nextLine());

		return item;
	}

	private static Macchina createItemFromUserInput2() {

		Macchina item = new Macchina();

		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);

		System.out.print("Inserisci la targa: ");
		item.setTarga(in.nextLine());

		System.out.print("Inserisci il modello: ");
		item.setModello(in.nextLine());

		System.out.print("Inseririsci la marca: ");
		item.setMarca(in.nextLine());

		System.out.print("Inserisci il telepass: ");
		item.setTelepass(in.nextBoolean());

		return item;
	}

	private static void stampaMenu() {

		log.info("1) Test Connessione (API JDBC)");
		log.info("2) Stampa lista documenti (API JDBC)");
		log.info("3) Crea documento (Hibernate)");
		log.info("4) Elimina documento (Hibernate)");
		log.info("5) Stampa somma delle pagine nella tabella");
		log.info("Altro) Esci");
	}

	public static Pedaggio Controllo(String t1) {
		MacchinaService service= new MacchinaService();
		Macchina temp = service.findItemById2(t1);
		if(temp instanceof Macchina)
		{			
			if(temp.getTelepass()==true) {
				System.out.println("la macchina possiede il telepass, perciò non viene multata");
				
			}
			else {
				System.out.println("la macchina non ha il telepass perciò sarà, multata");
			}
			
			
		}
		return null;
	}


}
