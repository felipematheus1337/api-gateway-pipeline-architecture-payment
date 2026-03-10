package com.pipeline.service.application.workflow.filters;

public interface Filter<T> {

    void apply(T t);
}
