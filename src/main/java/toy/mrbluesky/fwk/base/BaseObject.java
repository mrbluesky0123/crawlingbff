package toy.mrbluesky.fwk.base;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseObject {

//    protected static final Logger logError = (Logger) LoggerFactory.getLogger("fileError");

    @Autowired
    protected HttpServletRequest httpServletRequest;
    @Autowired
    protected HttpServletResponse httpServletResponse;

}
