package com.duzj.staging.base.myaspect;

import com.duzj.staging.base.annotation.WebLog;
import org.apache.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author duzj
 * @create 2019-06-12 13:11
 */
@Aspect
@Component
//@Profile({"dev", "test"})
public class WebLogAcpect {
    private final org.apache.log4j.Logger logger = LogManager.getLogger(this.getClass());

    /** 换行符 */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /** 以自定义 @WebLog 注解为切点 */
    @Pointcut("@annotation(com.duzj.staging.base.annotation.WebLog)")
    public void webLog() {}

    /**
     * 在切点之前织入
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        try{
            // 开始打印请求日志
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            // 获取 @WebLog 注解的描述信息
            String methodDescription = getAspectLogDescription(joinPoint);

            // 打印描述信息
            StringBuffer sb = new StringBuffer(methodDescription);
            sb.append(":");
            sb.append(Arrays.toString(joinPoint.getArgs()));
            logger.info(sb);
        }catch (Exception e){
            logger.error("异常类:"+ Arrays.toString(e.getStackTrace())+",异常原因:"+e.getMessage());
        }finally {

        }
    }

    /**
     * 在切点之后织入
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
        // 接口结束后换行，方便分割查看
        //logger.info("=========================================== End ===========================================" + LINE_SEPARATOR);
    }

    /**
     * 返回参数记录
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("返回内容 : " + ret);
    }


 /*   *//**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     *//*
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        logger.info("Response Args  : {}",JSONObject.parseObject(String.valueOf(result)));
        // 执行耗时
        logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }*/


    /**
     * 获取切面注解的描述
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(WebLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }


}
