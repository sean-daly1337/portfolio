package com.lit.reactive.systems.flowapiassessment.operators;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapper<T, R> extends SubmissionPublisher<R>  implements Flow.Processor<T, R> {
    private Flow.Subscription subscription;
    private final Function<T, Stream<R>> function;


    public FlatMapper(Function<T,Stream<R>> flatMappingFunction){
        super();
        this.function =flatMappingFunction;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        Stream<R> flatMapStream = function.apply(item);
        flatMapStream.forEach(this::submit);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        closeExceptionally(throwable);
    }

    @Override
    public void onComplete() {
        close();
        System.out.println("Mapper completed");
    }
}
