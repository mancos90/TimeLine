package me.mancos.utils;

/**
 * Created by mancos on 2017/3/17.
 * 上午10:16
 * TODO:
 */


public class ExceptionCrashHandler implements Thread.UncaughtExceptionHandler {

    private static ExceptionCrashHandler instance;

    public ExceptionCrashHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public synchronized static ExceptionCrashHandler getInstance() {
        if (instance == null) {
            instance = new ExceptionCrashHandler();
        }
        return instance;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        throwable.printStackTrace();
//        Log.e("捕获异常:", "uncaughtException, thread: " + thread
//                + " name: " + thread.getName() + " id: " + thread.getId() + "exception: "
//                + throwable);
    }


}
