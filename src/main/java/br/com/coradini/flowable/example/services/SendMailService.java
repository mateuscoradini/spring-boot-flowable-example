package br.com.coradini.flowable.example.services;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class SendMailService implements JavaDelegate {

    public void execute(DelegateExecution delegateExecution) {
        System.out.println("Sending rejection mail to author.");
    }
}
