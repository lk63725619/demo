package com.home.javaUtils;
import org.slf4j.Logger;


public class TimeReporter
{
    private Logger logger;
    private long startTime;


    public TimeReporter(Logger logger)
    {
        this.logger = logger;
    }

    public TimeReporter()
    {
    }

    public void start()
    {
        startTime = System.currentTimeMillis();
        if(null != logger)
        {
            logger.info(" timeReport start : ");
        }
        System.out.println(" timeReport start : ");
    }

    public void stop(String methodName)
    {
        if(null != logger)
        {
            logger.info(" execute "+methodName+" spend time : "+ (System.currentTimeMillis()-startTime) + "ms" );
        }

        System.out.println(" execute "+methodName+" spend time : "+ (System.currentTimeMillis()-startTime) + "ms" );
        startTime = System.currentTimeMillis();
    }


}
