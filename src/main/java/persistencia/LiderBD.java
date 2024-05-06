package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StandardStaxDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import dominio.Lider;

public class LiderBD  {

	private static ArrayList<Lider> lista = new ArrayList<Lider>();
   
	private static final String CAMINHO = "C:\\Users\\Usuario\\Desktop\\lideres.xml";
	//private static String caminho ="C:\\Users\\Usuario\\Desktop\\";

	
	public static void inserir(Lider novoLider) {
		lerXml();
		lista.add(novoLider);
		salvarXml();
	}
	
	public static void alterar(Lider liderAlterado) {
		excluir(liderAlterado.getCpf());
		inserir(liderAlterado);
		
	}
	
	
	public static void excluir(String cpf) {
		lerXml();
		for(int i=0; i<lista.size(); i++)
		{
			Lider cadaLider = lista.get(i);
			if (cadaLider.getCpf().equals(cpf)) {
				lista.remove(i);
				break;
			}
		}
		salvarXml();
		
	}
	
	public static ArrayList<Lider> listar() {
		lerXml();
		return lista;
	}
	
	
    public static void lerXml() {
        
        XStream xstream = new XStream();
        
        File arquivo = new File(CAMINHO);
        
        
		String xmlAll="";
		char theChar;
		
        if (arquivo.exists()) {
            FileInputStream fis = null;
			try {
				fis = new FileInputStream(arquivo);
			
		
				int data = fis.read();
				while (data!=-1) {
					theChar = (char) data;
					xmlAll=xmlAll+theChar;
					data = fis.read();
				}
				fis.close();
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
			//lista = new ArrayList<>();
			List<Lider> listaTemp = (List<Lider>) xstream.fromXML(xmlAll);
			
		//	lista = listaTemp;
			
            //lista = (ArrayList<Lider>) xstream.fromXML(xmlAll);
        }
        else {
         lista = new ArrayList<>();
        //System.out.println("Deu erro!");
    }

}
	
	public static void salvarXml() {
		XStream xstream = new XStream();
		xstream.alias("lider",Lider.class);
		try {
			FileWriter escritor= new FileWriter(CAMINHO);
			escritor.write(xstream.toXML(lista));
			escritor.close();
					
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
