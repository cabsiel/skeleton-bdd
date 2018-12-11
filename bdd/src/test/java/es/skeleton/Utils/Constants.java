package es.skeleton.Utils;

/**
* <h1> Constant Class</h1>
* This class is used to store the Constants used on Test.
* <p>
* Here we store the URL, paths, Constants values... all type of data that never change during the test execution and have to be global for all classes
*
* @author  Navio Cabanillas, Joaquin
* @version 1.0
* @since   2016-07-04
*/
public class Constants {
    
    
    /** 
     * @param URL_STKMLMDEMO "http://stkmspdemo.stacks-cis.ct/stk-cas-web/login" environment 
     */
    public static final String URL_ENVIRONMENT = "";
    
    
    
    /** 
     * @param Log4j_FILE Constant with the name of the lof4j file 
     * @param locatorXML_FILE Constant with the name of the xml file
     * @param BrowserXXX Constant with the name of the browser
     * @param flagBlockCreateFolder. This variable will be used like a flag to control the creation of the folder per test case executed.
     * @param folderName. Variable to store the name of the test case folder created, and save the screenshots generate on his folder.
     */
    public static final String Log4j_FILE = "log4j.xml";
    public static final String BrowserFirefox = "Firefox";
    public static final String BrowserChrome = "Chrome";
    public static final String BrowserIE = "IE";
    public static boolean flagBlockCreateFolder = false;
    public static String folderName;
    public static final String pathXML = "Resources/LocatorsXML/";

   
}