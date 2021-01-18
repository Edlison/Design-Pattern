package com.edlison.design.v0.isp;

// 接口隔离原则
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {

    }
}

class User {

}

interface IUser {
    void registerUser(User user);
    void deleteUser();

}

class DefaultUser implements IUser {
    MsgSender msgSender;

    @Override
    public void registerUser(User user) {
        // ...
    }

    @Override
    public void deleteUser() {
        // ...
    }

    public void sms() {
        msgSender.sms("130xxxxxxxx");
    }
}

interface MsgSender {   // 不同的功能 与用户接口区分
    void sms(String mobileNumber);
}

class DefaultMsgSender implements MsgSender {

    @Override
    public void sms(String mobileNumber) {
        // ...
    }
}

class ActivityService {
    MsgSender msgSender;

    public void test() {
        msgSender.sms("130xxxxxxxx");
    }
}

// 接口隔离原则
// 客户端不应该强迫依赖其不需要的接口

// 实践参考以下原则：
// 1. 对于接口来说，一个接口承担了与它无关的接口定义，则该接口违反了接口隔离原则。对无关接口进行剥离，实现接口瘦身。
// 2. 对于共同的功能来说，应该戏份功能点，按需添加。而不是定义一个大而全的接口，强迫子类去实现。