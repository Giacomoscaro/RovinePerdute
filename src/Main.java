import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws XMLStreamException {
		Reader r=null;
    	try {
			r = new Reader("./fileXML/PgAr_Map_10000.xml");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        ArrayList<Citta> mappa = r.leggi_mappa(); // legge le città dal file di input
        RovineManager m = new RovineManager(mappa);
        ArrayList<Citta> p1 = m.calcola_peso_team1(m.getLista_citta()); // percorso per il team 1
        ArrayList<Citta> p2 = m.calcola_peso_team2(m.getLista_citta()); // percorso per il team 2
        Writer w = new Writer("./fileXML/percorsiRovine.xml");
        w.scrivi_percorsi(p1, p2);
    }
}