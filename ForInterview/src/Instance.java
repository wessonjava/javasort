/**
 * volatile 单例模式
 * @author wesson
 */
public class Instance {
    private volatile static Instance instance;

    private Instance() {

    }

    public static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }
}
