package com.beecloud.spi.impl;

import com.beecloud.spi.SpiService;

/**
 * @Author: senne
 * @Date: 2019/6/27 14:25
 * @Version 1.0
 */
public class SpiService2 implements SpiService {
    @Override
    public String excute() {
        return "SpiImpl2 Hello";
    }
}
