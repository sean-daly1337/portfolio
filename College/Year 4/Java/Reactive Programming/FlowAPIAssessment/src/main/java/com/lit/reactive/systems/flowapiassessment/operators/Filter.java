package com.lit.reactive.systems.flowapiassessment.operators;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Predicate;

public class Filter extends SubmissionPublisher<String> implements Flow.Processor<String, String> {

    private Flow.Subscription subscription;
    private final Predicate<String> predicate;

    public Filter(Predicate<String> predicate) {
        this.predicate = predicate;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        if (predicate.test(item)) {
            submit(item);
        }
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        closeExceptionally(throwable);
    }

    @Override
    public void onComplete() {
        close();
        System.out.println("Emitter successful completion!");
    }


}
