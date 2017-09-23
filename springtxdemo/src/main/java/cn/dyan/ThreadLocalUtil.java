package cn.dyan;

import java.lang.reflect.Field;

/**
 * Created by zzt on 2017/9/23.
 */
public class ThreadLocalUtil {
    public static void dumphreadLocals() throws NoSuchFieldException, IllegalAccessException {
        Thread thread = Thread.currentThread();
        Field threadlocalsField = Thread.class.getDeclaredField("threadLocals");
        threadlocalsField.setAccessible(true);
        Object threadLocalTable = threadlocalsField.get(thread);

    }
}
