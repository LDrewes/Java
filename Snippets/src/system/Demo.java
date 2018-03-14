package system;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * How to retreive system information
 * See http://java.sun.com/j2se/1.5.0/docs/api/java/lang/management/ManagementFactory.html
 * @author drewes
 *
 */
public class Demo {

	public static void main(String[] args) {
		long diskSize = new File("/").getTotalSpace();
        String userName = System.getProperty("user.name");
        long maxMemory = Runtime.getRuntime().maxMemory();
        long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
        
        System.out.println("Size of C:="+diskSize+" Bytes (" + diskSize/1073741824.0+ "GB)");
        System.out.println("Runtime MaxMemory="+maxMemory + " Bytes (" + maxMemory/1073741824.0+ "GB)");
        System.out.println("User Name="+userName);

        System.out.println("RAM Size="+memorySize+" Bytes (" + memorySize/1073741824.0+ "GB)");
	}

}
