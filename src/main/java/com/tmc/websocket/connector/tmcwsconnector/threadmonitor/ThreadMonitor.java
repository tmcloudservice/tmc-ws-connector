package com.tmc.websocket.connector.tmcwsconnector.threadmonitor;

import java.lang.management.ManagementFactory;

public class ThreadMonitor {

    public void showThreadStatus(Thread thrd)
    {
        System.out.println(thrd.getName()
                + "  Alive:=" + thrd.isAlive()
                + " State:=" + thrd.getState()
                + "Java Beans Threads counter =  " + ManagementFactory.getThreadMXBean().getThreadCount()
                + "Java Threads active count" + Thread.activeCount());
    }
}
