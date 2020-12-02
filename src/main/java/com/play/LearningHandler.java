package com.play;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;
import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.function.aws.proxy.MicronautLambdaHandler;

public class LearningHandler extends MicronautLambdaHandler {
    public LearningHandler() throws ContainerInitializationException {
    }

    public LearningHandler(ApplicationContextBuilder applicationContextBuilder) throws ContainerInitializationException {
        super(applicationContextBuilder);
    }

    @Override
    public AwsProxyResponse handleRequest(AwsProxyRequest input, Context context) {
        return super.handleRequest(input, context);
    }
}
