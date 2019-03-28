package mytest;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.OnTimer;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.Self;

/**
 * @Description
 * @Author will
 * @Date 2019/3/28 0028 上午 10:00
 */
@BTrace(unsafe = true)
public class Debug {

  @OnMethod(clazz = "com.ccb.ds.controller.DsDataSrcController", method = "all", location = @Location(Kind.RETURN))
  public static void run(@Self Object self, @Duration long time, @Return AnyType type) {

    BTraceUtils.println("=============cost time :" + time);

  }

  @OnTimer(1000)
  public static void show() {
    BTraceUtils.println("af");
  }
}
