package com.imaginnovate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
@QuarkusMain
public class ResourceManagerApp {
    public static void main(String[] args) {
        System.out.println("ResourceManagerApp. project");
        Quarkus.run(args);
    }
}
