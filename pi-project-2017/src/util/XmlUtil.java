package util;

import java.io.File;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



/**configuraçoes do arquivo xml
 * ex de xml:
 * <list>
 * <key>keyword</key>
 * <key>keyword</key>
 * .....
 * </list>
 * 
 * **/
public class XmlUtil {

	private  String tagXml ;
	private  String caminhoXML ;

	
	@SuppressWarnings("unchecked")
	public List<String> retornaPalavrasXml() {
	
		return (List<String>) lerXML().fromXML(new File(caminhoXML));

	}

	/*este metodo apenas tem as funçoes que lê um arquivo xml*/
	private XStream lerXML() {

		XStream stream = null;
		try {

			stream = new XStream(new DomDriver());
			stream.alias(tagXml, String.class);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return stream;

	}

	

	public void setTagXml(String tagXml) {
		this.tagXml = tagXml;
	}


	public void setCaminhoXML(String caminhoXML) {
		this.caminhoXML = caminhoXML;
	}
	
	
	
	

}
