import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class CPUUtils {
    public static final ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
	
	// Get CPU time in nanoseconds.
    public static long getCpuTime( ) {
//      ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
            bean.getCurrentThreadCpuTime( ) : 0L;
    }

    // Get user time in nanoseconds. 
    public static long getUserTime( ) {
//      ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
            bean.getCurrentThreadUserTime( ) : 0L;
    }

    // Get system time in nanoseconds. 
    public static long getSystemTime( ) {
//      ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
            (bean.getCurrentThreadCpuTime( ) - bean.getCurrentThreadUserTime( )) : 0L;
    }
    
    public static void main(String args[]){
    	ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
    	System.out.println(bean.isThreadCpuTimeSupported());
    	System.out.println(bean.isCurrentThreadCpuTimeSupported());
    	System.out.println(bean.isObjectMonitorUsageSupported());
    	System.out.println(bean.isObjectMonitorUsageSupported());
    	System.out.println(bean.isThreadCpuTimeSupported());
    	System.out.println(bean.isThreadContentionMonitoringEnabled());
    	System.out.println(bean.isThreadCpuTimeEnabled());
    }
}
