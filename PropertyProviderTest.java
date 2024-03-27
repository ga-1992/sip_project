package com.sip.core.property.loader.utils.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.sip.core.property.loader.utils.PropertyProviderFactory;
import com.sip.core.property.loader.utils.PropertyProviderIntf;

public class PropertyProviderTest {

	public PropertyProviderTest() {
	}

	@ClassRule
	public static TemporaryFolder temporaryFolder = new TemporaryFolder();

	@BeforeClass
	public static void setUpClass() {

		try {
			Properties properties = new Properties();
			properties.setProperty("lms_switch_site_user_create", "on");
			properties.setProperty("create-site-user-header-keys", "LmsEndPoint|UserName|Password");
			properties.setProperty("create-site-user-lms-endpoint",
					"http://CTSINTBMVDCE7/LMSServices/UserManagement.svc");
			properties.setProperty("create-site-user-lms-username", "lmssuperadmin");
			properties.setProperty("create-site-user-lms-password", "");
			properties.setProperty("lms-message-user-exists", "User already Exist");

			temporaryFolder.create();
			File file = temporaryFolder.newFile("lms-general-config.properties");

			// File file = new File(tempDir, "lms-general-config.properties");

			FileOutputStream fileOut = new FileOutputStream(file);
			properties.store(fileOut, "Favorite Things");
			fileOut.close();
			System.setProperty("lms-general-config_properties", file.getAbsolutePath());
			System.setProperty("CLOUD_CONNECTOR_MASTER_PASSWORD", "xrK2w66Vt10SuUo+OyVxp3nfKk9KTYM6vXWs7kZQ3wA=");
		} catch (Exception e) {
		}

	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {
	}

	@Test
	public void testPropertyProvider() {
		/*
		 * PropertyProviderIntf fileProperty = PropertyProviderFactory.getFileProperty(
		 * "com/cts/gto/cloud/connector/core/test/test.properties"); String wsdl =
		 * fileProperty.getValue("wsdl"); System.out.println("wsdl="+wsdl);
		 * 
		 * fileProperty = PropertyProviderFactory.getFileProperty(
		 * "com/cts/gto/cloud/connector/core/test/test.properties"); String xsd =
		 * fileProperty.getValue("xsd"); System.out.println("xsd="+xsd);
		 * 
		 * Properties props = System.getProperties();
		 * props.setProperty(IConstants.DEFAULTS.PROPERTY_ENCRYPTION.
		 * SYSTEM_PROPERTY_NAME, "W6CK+O8CTpWJ8yeU+WsWMBZYbcqfIxQ9");
		 * 
		 * fileProperty = PropertyProviderFactory.getFileProperty(
		 * "com/cts/gto/cloud/connector/core/test/test.properties"); String soap =
		 * fileProperty.getValue("soap"); System.out.println("soap="+soap);
		 * assertEquals("Decryption Failure..........",
		 * "http://schemas.xmlsoap.org/wsdl/soap/", soap);
		 */

		String configurationLocation = System.getProperty("lms-general-config_properties");
		PropertyProviderIntf fileProperty = PropertyProviderFactory.getFileProperty(configurationLocation,
				"CLOUD_CONNECTOR_MASTER_PASSWORD");
		System.out.println(fileProperty.getValue("create-site-user-header-keys"));

	}
}
