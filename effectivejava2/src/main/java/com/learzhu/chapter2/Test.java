package com.learzhu.chapter2;

/**
 * Test.java是EffectiveJava的测试规则2的类。
 *
 * @author 祝杭鹏
 * @version 1.0 2017/1/17
 */
public class Test {
    public static void main(String args[]) {
        //将提供者注册到内存中
        Services.registerDefaultProvider(DEFAULT_PROVIDER);
        Services.registerProvider("comp", COMP_PROVIDER);
        Services.registerProvider("armed", ARMED_PROVIDER);

        //客户端实际调用
        IService iService1 = Services.newInstance();
        IService iService2 = Services.newInstance("comp");
        IService iService3 = Services.newInstance("armed");

        System.out.printf("%s,%s,%s%n", iService1, iService2, iService3);
    }

    //提供获取提供者的方法
    public static IProvider DEFAULT_PROVIDER = new IProvider() {
        @Override
        public IService newService() {
            return new IService() {
                @Override
                public String toString() {
                    return "Default IService";
                }
            };
        }
    };

    public static IProvider COMP_PROVIDER = new IProvider() {
        @Override
        public IService newService() {
            return new IService() {
                @Override
                public String toString() {
                    return "Complementary service";
                }
            };
        }
    };

    public static IProvider ARMED_PROVIDER = new IProvider() {
        @Override
        public IService newService() {
            return new IService() {
                @Override
                public String toString() {
                    return "Armed service";
                }
            };
        }
    };
}
