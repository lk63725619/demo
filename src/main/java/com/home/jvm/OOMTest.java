package com.home.jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMTest
{
    static class OMMObject {
        public byte[] placeholder = new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException
    {
        List<OMMObject> list = new ArrayList<OMMObject>();

        for (int i= 0 ; i< num ; i++)
        {
            Thread.sleep(50);
            list.add(new OMMObject());
        }
    }


    public static void main(String[] args) throws  Exception{

        fillHeap(2000);
        System.gc();

    }

}
