package com.example.java.jottings.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<SpiInterface> load = ServiceLoader.load(SpiInterface.class);
        load.forEach(x -> {
            x.doWork();
        });

        Iterator<SpiInterface> it = load.iterator();
        while (it.hasNext()) {
            it.next().doWork();
        }
    }
}
