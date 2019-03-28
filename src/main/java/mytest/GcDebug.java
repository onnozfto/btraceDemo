package mytest;

import static com.sun.btrace.BTraceUtils.jstack;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

/**
 * @Description
 * @Author will
 * @Date 2019/3/28 0028 上午 10:54
 */
@BTrace
public class GcDebug {

  @OnMethod(clazz = "java.lang.System", method = "gc")
  public static void onSystemGC() {
    BTraceUtils.println("entry System.gc()");
    jstack();

  }

}
