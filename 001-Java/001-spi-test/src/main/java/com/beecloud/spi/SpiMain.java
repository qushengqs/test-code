package com.beecloud.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author: senne
 * @Date: 2019/6/27 14:25
 * @Version 1.0
 */
public class SpiMain {

    public static void main(String[] args) {
        ServiceLoader<SpiService> loaders = ServiceLoader.load(SpiService.class);

        Iterator<SpiService> spiServices = loaders.iterator();
        while (spiServices.hasNext()) {
            SpiService spiService = spiServices.next();
            System.out.println(spiService.excute());
        }
    }
}
