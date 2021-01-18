package com.edlison.design.v0.factory.abstractfactory;

public class AbstractFactory {
    public static void main(String[] args) {
        IDataBaseUtils myBatisUtils = new MyBatisUtils();
        IConnection myBatisConnection = myBatisUtils.getConnection();
        myBatisConnection.connect();
        ICommand myBatisCommand = myBatisUtils.getCommand();
        myBatisCommand.command();

        OracleUtils oracleUtils = new OracleUtils();
        IConnection oracleConnection = oracleUtils.getConnection();
        oracleConnection.connect();
        ICommand oracleCommand = oracleUtils.getCommand();
        oracleCommand.command();
    }
}

// 第一个抽象方法
interface IConnection {
    void connect();
}

// 第二个抽象方法
interface ICommand {
    void command();
}

// 相当于多个工厂方法
interface IDataBaseUtils {
    IConnection getConnection();
    ICommand getCommand();
}

// 方法一 产品A实现
class MyBatisConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("MyBatis connect.");
    }
}

// 方法一 产品B实现
class OracleConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("Oracle connect.");
    }
}

// 方法二 产品A实现
class MyBatisCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("MyBatis command.");
    }
}

// 方法二 产品B实现
class OracleCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("Oracle command.");
    }
}

class MyBatisUtils implements IDataBaseUtils {

    @Override
    public IConnection getConnection() {
        return new MyBatisConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MyBatisCommand();
    }
}

class OracleUtils implements IDataBaseUtils {

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}