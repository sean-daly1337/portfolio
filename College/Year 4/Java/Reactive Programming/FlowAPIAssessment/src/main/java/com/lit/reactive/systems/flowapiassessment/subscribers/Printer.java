package com.lit.reactive.systems.flowapiassessment.subscribers;

import java.util.concurrent.Flow;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Printer implements Flow.Subscriber<String> {

    private Flow.Subscription subscription;

    static final int requestSize = 10;
    int received  = 0;
    int total = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(requestSize);
    }

    @Override
    public void onNext(String item) {
        received ++;
        total++;
        System.out.println("N : "+received+ " : " + item);
        if(received % requestSize == 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
            subscription.request(requestSize);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error : "+throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Printer successful completion. Received: "+received);
    }
}
