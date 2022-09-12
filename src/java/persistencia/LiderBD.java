package persistencia;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import dominio.Lider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;

public class LiderBD {

    private static ArrayList<Lider> lista = new ArrayList<>();

    private static final String CAMINHO = "C:\\Users\\Celso\\Desktop\\lideres.xml";

    public static void inserir(Lider novoLider) throws Exception {
        lerXml();
        lista.add(novoLider);
        salvarXml();
    }

    public static void alterar(Lider liderAlterado) throws Exception {
        excluir(liderAlterado.getCpf());
        inserir(liderAlterado);
    }

    public static void excluir(String cpf) {
        for (int i = 0; i < lista.size(); i++) {
            Lider cadaLider = lista.get(i);
            if (cadaLider.getCpf().equals(cpf)) {
                lista.remove(i);
                break;
            }
        }
        salvarXml();
    }

    public static ArrayList<Lider> listar() {
        return lista;
    }

        public static void lerXml() throws Exception {
                      
            XStream xstream = new XStream(new DomDriver("UTF-8"));
            
            File arquivo = new File(CAMINHO);
            
            if (arquivo.exists()) {
                FileInputStream fis = new FileInputStream(arquivo);
                lista = (ArrayList<Lider>) xstream.fromXML(fis);
            }
            else {
             lista = new ArrayList<>();
            //System.out.println("Deu erro!");
        }

    }


public static void salvarXml() {
     XStream xstream = new XStream();
     xstream

.alias("lider", Lider.class  

);
     try {
         FileWriter escritor = new FileWriter(CAMINHO);
         escritor.write(xstream.toXML(lista));
         escritor.close();
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
     }
   }
}
