package com.oguiller.springboot;

        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Normally any unhandled exception thrown when processing a web-request causes the server to return
 * an HTTP 500 response. However, any exception that you write yourself can be annotated with
 * the @ResponseStatus annotation (which supports all the HTTP status codes defined by the HTTP
 * specification). When an annotated exception is thrown from a controller method, and not handled
 * elsewhere, it will automatically cause the appropriate HTTP response to be returned with the
 * specified status-code.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Book") // 404
public class BookNotFoundException extends RuntimeException {}
