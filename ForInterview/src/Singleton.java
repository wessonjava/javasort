/**
 * 单例模式
 *
 * @author wesson
 */
public class Singleton {
    /**
     * 1懒汉模式
     */
    static class Instance1 {
        private volatile static Instance1 instance1;

        //将构造方法私有化，不允许外部直接创建对象
        private Instance1() {
        }

        public static synchronized Instance1 getInstance1() {
            if (instance1 == null) {
                Instance1 instance1 = new Instance1();
            }
            return instance1;
        }
    }

    /**
     * 2饿汉模式
     */
    static class Instance2 {
        private volatile static Instance2 instance2 = new Instance2();

        private Instance2() {
        }

        public static Instance2 getInstance2() {

            return instance2;
        }
    }

    /**
     * 3双重校验锁单例模式
     */
    static class Instance3{
        private volatile static Instance3 instance3;
        private Instance3(){}
        public static Instance3 getInstance3(){
            //判断对象是否已经实例过，否则进入加锁代码
            if(instance3==null){
                //类对象加锁
                synchronized(Instance3.class){
                    if(instance3==null){
                        instance3=new Instance3();
                    }
                }
            }
            return instance3;
        }
    }
}