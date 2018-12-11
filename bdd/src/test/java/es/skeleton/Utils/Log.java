package es.skeleton.Utils;

import org.apache.log4j.Logger;

/**
* <h1> Log Class</h1>
* Log Creator
* <p>
* This class create will update the log file.
* 
* @author  Navio Cabanillas, Joaquin
* @version 1.0
* @since   2016-06-05
*/

public class Log {

		/**
	   * This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite 
	   * @param log -> Initialize Log4j logs
	   */
		private static Logger Log = Logger.getLogger(Log.class.getName());//

 
	   /**
	   * This method is to print log for the beginning of the test case, as we usually run so many test cases as a test suite 
	   * @param sTestCaseName is the name of the Test Case that the system is updating the log
	   */
		public static void startTestCase(String sTestCaseName){

			Log.info("****************************************************************************************");

			Log.info("****************************************************************************************");

			Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");

			Log.info("****************************************************************************************");

			Log.info("****************************************************************************************");

		}

		
		/**
		 * This method is to print log for the ending of the test case 
		 * @param sTestCaseName is the name of the Test Case that the system is updating the log
		 */
		public static void endTestCase(String sTestCaseName){

			Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

			Log.info("X");

			Log.info("X");

			Log.info("X");

			Log.info("X");

		}

		/**
		 * This method is to print a info message about the current test case 
		 * @param message is the variable where we send the text that will be write in the log file
		 */
		public static void info(String message) {

			Log.info("[OK] "+message);

		}

		
		/**
		 * This method is to print a warn message about the current test case 
		 * @param message is the variable where we send the text that will be write in the log file
		 */
		public static void warn(String message) {

			Log.warn(message);

		}

		/**
		 * This method is to print an error message about the current test case 
		 * @param message is the variable where we send the text that will be write in the log file
		 */
		public static void error(String message) {

			Log.error("[KO] "+message);

		}

		/**
		 * This method is to print a fatal error message about the current test case 
		 * @param message is the variable where we send the text that will be write in the log file
		 */
		public static void fatal(String message) {

			Log.fatal(message);

		}
		
		/**
		 * @param message is the variable where we send the text that will be write in the log file
		 */
		public static void debug(String message) {

			Log.debug(message);

		}
		//*****************************************************************************************	
		//*****************************************************************************************	
		/**
		* This method is to print log for the beginning of the test case, as we usually run so many test cases as a test suite 
		* @param sTestCaseName is the name of the Test Case that the system is updating the log
		*/
		public static void startTestScenario(String testScenarioName){
			Log.info("****************************************************************************************");
			Log.info("*******************                 "+testScenarioName+ "       *******************");
			Log.info("****************************************************************************************");
		}		
		//*****************************************************************************************	
		//*****************************************************************************************	
		
		/**
		* This method is to print log for the beginning of the test case, as we usually run so many test cases as a test suite 
		* @param sTestCaseName is the name of the Test Case that the system is updating the log
		*/
		public static void endTestScenario(String testScenarioName){
			Log.info("*******************End of Scenario: "+testScenarioName+ "       *******************");
			Log.info("****************************************************************************************");
			Log.info("****************************************************************************************");
		}		
		//*****************************************************************************************	
		//*****************************************************************************************			


}