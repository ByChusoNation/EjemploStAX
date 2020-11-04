package practicaempleados;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class Prc3 {
	public static final String ELEMENTO_SALARIO = "salario";
    public static final String ELEMENTO_NOMBRE = "nombre";
    public static <E> void main(String[] args) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        XMLStreamReader xmlsr = xmlif.createXMLStreamReader(new FileReader("C:/JAVAPROYECTS/DIS/practica3/empleados.xml"));
        ArrayList<String> nombres = new ArrayList<String>();
        String tag = null;
        String salario = null;
        String nombre = null;
        int eventType;
        System.out.println("[Iniciando el documento]");
        while (xmlsr.hasNext()){
            eventType = xmlsr.next();
            switch(eventType){
                case XMLEvent.START_ELEMENT:
                    tag = xmlsr.getLocalName();
                    if(tag.equals(ELEMENTO_NOMBRE)){
                        nombre = xmlsr.getElementText();
                    }else if(tag.equals(ELEMENTO_SALARIO)){
                        salario = xmlsr.getElementText();
                        if(Integer.parseInt(salario) >= 30000)
                            nombres.add(nombre);
                    }
                    break;
                case XMLEvent.END_DOCUMENT:
                    System.out.println("[Fin del documento]");
                    break;
            }
        }
        System.out.println("Los empleados con un salario mayor a 30000 son: "+nombres);
    }
}
