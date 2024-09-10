package com.paxier.springsecurity.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("QualifierServiceDemo2")
public class QualifierServiceDemoSecond implements QualifiersDemoInterface {
    @Override
    public void printSomething(String message) {
        System.out.println("QualifierServiceDemoSecond: " + message);
    }
}
