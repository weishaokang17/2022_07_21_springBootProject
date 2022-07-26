package per.wsk.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web controller的异常
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 针对  数学异常 和 空指针异常  跳到login页面
     * @param e
     * @return
     */
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})  //处理异常
    public String handleArithException(Exception e){

        log.error("异常是：{}",e);
        return "login"; //视图地址
    }

}
