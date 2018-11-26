package com.home.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *   VM args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=H:\error
 */
public class HeapOOM
{
    static class HeapObject
    {}

    public static void main(String[] args) {
         List<OOMTest.OMMObject> list = new ArrayList<>();
         while(true)
         {
             list.add(new OOMTest.OMMObject());
         }
    }
}
