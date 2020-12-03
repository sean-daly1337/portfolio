package com.lit.reactive.systems.flowapiassessment.operators;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Emitter extends SubmissionPublisher<String> implements Flow.Processor<String, String>{

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
        System.out.println("Received : [ "+received+" ] :"+item);
        if(received==requestSize){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
            received=0;
            subscription.request(requestSize);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error : "+throwable.getMessage());
    }

    @Override
    public void onComplete() {
        close();
        System.out.println("Emitter Successful Completion: "+total);
    }
}
