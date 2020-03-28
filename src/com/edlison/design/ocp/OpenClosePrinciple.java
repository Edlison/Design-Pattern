package com.edlison.design.ocp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// 开闭原则
public class OpenClosePrinciple {
    public static void main(String[] args) {
        DiscountStrategy strategy = StrategyContext.getStrategy(UserTypeEnum.NORMAL.getUserType());
        System.out.println(strategy.calculateDiscount(BigDecimal.valueOf(100d)));

        DiscountStrategy strategyOfSuperVIP = StrategyContext.getStrategy(UserTypeEnum.SUPER_VIP.getUserType());
        System.out.println(strategyOfSuperVIP.calculateDiscount(BigDecimal.valueOf(100d)));
    }
}

enum UserTypeEnum {
    NORMAL(1),
    VIP(2),
    SUPER_VIP(3);

    private Integer userType;

    UserTypeEnum(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}

interface DiscountStrategy {
    BigDecimal calculateDiscount(BigDecimal money);
}

class NormalDiscountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal calculateDiscount(BigDecimal money) {
        return money;
    }
}

class VIPDiscountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal calculateDiscount(BigDecimal money) {
        return money.multiply(BigDecimal.valueOf(0.7d));
    }
}

class SuperVIPDiscountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal calculateDiscount(BigDecimal money) {
        return money.multiply(BigDecimal.valueOf(0.5d));
    }
}

class StrategyContext {
    private static Map<Integer, DiscountStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(UserTypeEnum.NORMAL.getUserType(), new NormalDiscountStrategy());
        strategyMap.put(UserTypeEnum.VIP.getUserType(), new VIPDiscountStrategy());
        strategyMap.put(UserTypeEnum.SUPER_VIP.getUserType(), new SuperVIPDiscountStrategy());
    }

    public static DiscountStrategy getStrategy(Integer userType) {
        return strategyMap.get(userType);
    }
}

// 开闭原则
// 说明：软件实体（模块，类，方法等）应该对扩展开放，对修改关闭。
// 开闭原则的目的是为了代码的可扩展，并且避免了对现有代码的修改给软件带来的风险。
// 1. 如果是业务驱动的系统，需要在充分了解业务需求的前提下，才能找到对应的扩展点；如果不确定因素过多，需求变化过快，则可以对一些比较确定的，通过设计扩展点，能明显提升代码稳定性和开发效率的地方进行设计。
// 2. 如果是通用型的技术开发，比如开发通用的框架、组件、类库，你需要考虑技术框架如何背用户使用，考虑功能的升级需要预留的扩展点以及版本之间的兼容问题。
// 3. 即使对系统的业务或者技术框架有足够的了解，也不一定要设计所有的扩展点。为未来可能发生变化的每个地方都预留扩展点，也会给系统带来极大的复杂度。需要综合开发成本、影响范围、实际收益等因素进行考虑。