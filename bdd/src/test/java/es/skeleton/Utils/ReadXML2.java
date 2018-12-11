package es.skeleton.Utils;
/**
* <h1>Read XML File</h1>
* 
* <p>
* This class is created to extract the data to execute the test case.
* The main goal is to have a xml file where we have stored the name of the elements, the type and the value.
* If the developers change the type or the value of the element, we don't have to update the test class
* 
* 
*
* @author  Navio Cabanillas, Joaquin
* @version 1.0
* @since   2016-06-05
*/
import java.io.File;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


public class ReadXML2 {
	
	/**
	* This method is to read and extract the data of the XML file
	*/
	public static String[] readXML(String XMLPath, String tag)
	{
		SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File(Constants.pathXML + XMLPath);
	    try
	    {  
	        Document document = (Document) builder.build( xmlFile );
	        Element rootNode = document.getRootElement();
	 
	        List list = rootNode.getChildren();
	      
	        for ( int i = 0; i < list.size(); i++ )
	        {
	            Element tabla = (Element) list.get(i);
	            List lista_campos = tabla.getChildren();
	          
	            for ( int j = 0; j < lista_campos.size(); j++ )
	            {
	            	Element campo = (Element)lista_campos.get( j );
	                if(campo.getName().equals(tag))
	                {
	                	String type = campo.getChildTextTrim("type");
	                	String value = campo.getChildTextTrim("value");
	                	if ( campo.getChildTextTrim("iframe") != null ){
	                		String iframe = campo.getChildTextTrim("iframe") ;
	                		return new String[] {type, value, iframe};
	                	}
	                	 return new String[] {type, value};
	                }               
	            }
	        }
	      
	        return null;
	    }
	    catch (Exception e)
	    {
	    	//TO DO:
	    	return null;
	    }
	}
	

}
