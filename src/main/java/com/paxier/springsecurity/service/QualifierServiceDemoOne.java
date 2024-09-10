package com.paxier.springsecurity.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("QualifierServiceDemo1")
public class QualifierServiceDemoOne implements QualifiersDemoInterface {
    @Override
    public void printSomething(String message) {
        System.out.println("QualifierServiceDemoOne: " + message);
    }
}
