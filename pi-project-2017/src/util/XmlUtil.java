package util;

import java.io.File;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlUtil {

	private final String tagXml = "palavra";
	private final String caminhoXML = "/home/guilherme/eclipse-workspace/tags.xml";

	@SuppressWarnings("unchecked")
	public List<String> retornaPalavrasXml() {

		File file = new File(caminhoXML);

		return (List<String>) lerXML().fromXML(file);

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

}
