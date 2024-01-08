package hello.springmvc.basic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@Controller 를 쓰면 spring의 view resolver, adapter 뷰 이름으로 인식, 그래서 뷰를 찾고 뷰가 렌더 된다.
// @RestController를 쓰면 Http 메시지 바디에 바로 입 . rest Api에서는 핵심
@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        //log.trace(" info trace={}" + name); 차이는 결과는 같지만 +는 연산자라 해당 log level 이 아니여도 "info trace ={} spring" 라는 연산이 일어난다
        //실제로는 필요없는 log level이여도 연산은 일어난다 log뿐 아니라 이 내용은 !연산! 가 이루어진다 라는게 핵심 알아두기
        log.trace(" info trace={}", name);

        // log level 종류 및 순서대로
        log.trace(" info trace={}", name);
        log.debug(" info debug={}", name);
        log.info(" info log={}", name);
        log.warn(" info warn={}", name);
        log.error(" info error={}", name);

        return "ok";

    }
}
