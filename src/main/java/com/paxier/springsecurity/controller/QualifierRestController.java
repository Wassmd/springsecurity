package com.paxier.springsecurity.controller;

import com.paxier.springsecurity.service.QualifiersDemoInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/qualifier")
public class QualifierRestController {
    private final QualifiersDemoInterface qualifiersDemoInterface;

    public QualifierRestController(@Qualifier("QualifierServiceDemo2") QualifiersDemoInterface qualifiersDemoInterface) {
        this.qualifiersDemoInterface = qualifiersDemoInterface;
    }

    @RequestMapping("/print-something")
    public void print() {
        qualifiersDemoInterface.printSomething("Hello World");
    }
}
