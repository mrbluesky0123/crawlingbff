//package toy.mrbluesky.crawlingbff.exception;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//
//public class BaseException extends RuntimeException {
//
//    private static final Logger log = LoggerFactory.getLogger("Error");
//    private static final Logger logRoot = LoggerFactory.getLogger(BaseException.class);
//
//    private String message;
//    private HttpStatus httpStatus;
//    public BaseException(String message) {
//        this(message, null);
//    }
//
//    public BaseException(Exception e) {
//        this(e.getMessage(), null);
//    }
//
//    public BaseException(String message, Exception e) {
//        this(message, HttpStatus.INTERNAL_SERVER_ERROR, e);
//    }
//
//    public BaseException(HttpStatus httpStatus, String message) {
//        this(message, httpStatus, null);
//    }
//
//    public BaseException(String message, HttpStatus httpStatus, Exception e) {
//        super(message);
//        this.message = message;
//        this.httpStatus = httpStatus;
//
//        //==========================================================================
//        // Main Message Print
//        //==========================================================================
//        StringBuilder sb = new StringBuilder();
//        sb.append("Error Message: ").append(message);
//
//        //==========================================================================
//        // Stack Trace
//        //==========================================================================
//        try {
//            if (e != null) {
//                log.error("{}", sb.toString(), e);
//
//            } else {
//
//                sb.append("\n");
//
//                StackTraceElement[] sts = new Throwable().getStackTrace();
//
//                for (int idx = 0; idx < sts.length; idx++) {
//                    StackTraceElement st = sts[idx];
//
//                    if (idx == 0) {
//                        sb.append("");
//                    } else {
//                        sb.append("\tat ");
//                    }
//                    sb.append(st.getClassName() + "." + st.getMethodName() + ":" + st.getLineNumber());
//                    sb.append("\n");
//                }
//
//                log.error(sb.toString());
//            }
//
//        } catch (Exception ee) {
//            log.error("{}", "Stack Trace Logic Error, There is a Critical Error occurred..", ee);
//        }
//
//    }
//
//}
