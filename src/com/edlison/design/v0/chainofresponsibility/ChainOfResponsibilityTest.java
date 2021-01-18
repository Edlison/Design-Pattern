package com.edlison.design.v0.chainofresponsibility;

// 责任链模式
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOk(true).loggedIn(true).build(); // 请求顺序应该与处理顺序相同 否则会出现错误

        RequestFrequentHandler handlerA = new RequestFrequentHandler(new RequestLoggingHandler(null));
        RequestLoggingHandler handlerB = new RequestLoggingHandler(new RequestFrequentHandler(null));

        if (handlerA.process(request)) {
            System.out.println("HandlerA Success!");
        }

        if (handlerB.process(request)) {
            System.out.println("HandlerB Success!");
        }
    }
}

class Request {
    private boolean loggedIn;
    private boolean frequentOk;
    private boolean permits;
    private boolean containSensitiveWords;
    private String requestBody;

    public Request(boolean loggedIn, boolean frequentOk, boolean permits, boolean containSensitiveWords) {
        this.loggedIn = loggedIn;
        this.frequentOk = frequentOk;
        this.permits = permits;
        this.containSensitiveWords = containSensitiveWords;
    }

    static class RequestBuilder {
        private boolean loggedIn;
        private boolean frequentOk;
        private boolean permits;
        private boolean containSensitiveWords;

        RequestBuilder loggedIn(boolean loggedIn) {
            this.loggedIn = loggedIn;
            return this;
        }

        RequestBuilder frequentOk(boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }

        RequestBuilder permits(boolean permits) {
            this.permits = permits;
            return this;
        }

        RequestBuilder containSensitiveWords(boolean containSensitiveWords) {
            this.containSensitiveWords = containSensitiveWords;
            return this;
        }

        public Request build() {
            Request request = new Request(loggedIn, frequentOk, permits, containSensitiveWords);
            return request;
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public boolean isPermits() {
        return permits;
    }

    public boolean isContainSensitiveWords() {
        return containSensitiveWords;
    }
}

abstract class Handler {
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class RequestFrequentHandler extends Handler {

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {

        System.out.println("访问频率控制.");

        if (request.isFrequentOk()) {
            Handler next = getNext();

            if (next == null) return true;

            return next.process(request);
        }

        return false;
    }
}

class RequestLoggingHandler extends Handler {

    public RequestLoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {

        System.out.println("登陆检验.");

        if (request.isLoggedIn()) {
            Handler next = getNext();

            if (next == null) return true;

            return next.process(request);
        }

        return false;
    }
}

// 应用场景
// 一个请求的处理需要多个对象当中的一个或几个协作处理

// 优点
// 1. 请求的发送者和接受者解藕
// 2. 可以控制执行顺序
// 3. 符合开闭原则和单一职责原则