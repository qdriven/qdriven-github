package io.qdriven.github.exception;

/**
 * @author Patrick
 **/
public class GithubConnectException extends RuntimeException{
    public GithubConnectException() {
        super();
    }

    public GithubConnectException(String message) {
        super(message);
    }

    public GithubConnectException(String message, Throwable cause) {
        super(message, cause);
    }

    public GithubConnectException(Throwable cause) {
        super(cause);
    }

    protected GithubConnectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
