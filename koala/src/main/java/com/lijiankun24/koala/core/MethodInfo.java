package com.lijiankun24.koala.core;

import org.objectweb.asm.Type;

import java.util.Locale;

/**
 * Cost.java
 * <p>
 * Created by lijiankun03 on 2018/8/25.
 */
public class MethodInfo {

    private static final String OUTPUT_FORMAT = "The method's name is %s ,the cost is %dms and the result is ";

    private String mClassName;          // 类名
    private String mMethodName;         // 方法名
    private String mMethodDesc;         // 方法描述符
    private Object mResult;             // 返回结果
    private long mCost;                 // 方法执行耗时

    @Override
    public String toString() {
        return String.format(Locale.CHINA, OUTPUT_FORMAT, getMethodName(), mCost) + mResult;
    }

    private String getMethodName() {
        StringBuilder msg = new StringBuilder();
        Type[] argumentTypes = Type.getArgumentTypes(mMethodDesc);
        msg.append('(');
        for (int i = 0; i < argumentTypes.length; i++) {
            msg.append(argumentTypes[i].getClassName());
            if (i != argumentTypes.length - 1) {
                msg.append(", ");
            }
        }
        msg.append(')');
        mMethodName = mMethodName.replace("/", ".");
        mMethodName = mClassName + "#" + mMethodName + msg.toString();
        return mMethodName;
    }

    /**
     * @param className 设置类名
     */
    public void setClassName(String className) {
        mClassName = className;
    }

    /**
     * @param methodName 设置方法名
     */
    public void setMethodName(String methodName) {
        mMethodName = methodName;
    }

    /**
     * @param cost 设置方法执行耗时
     */
    public void setCost(long cost) {
        this.mCost = cost;
    }

    /**
     * @param result 设置方法执行结果
     */
    public void setResult(Object result) {
        this.mResult = result;
    }

    /**
     * @param methodDesc 设置方法描述符
     */
    public void setMethodDesc(String methodDesc) {
        this.mMethodDesc = methodDesc;
    }
}
