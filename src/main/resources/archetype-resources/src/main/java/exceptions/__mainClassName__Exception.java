#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exceptions;

public class ${mainClassName}Exception extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public ${mainClassName}Exception() {
        super();
    }

    public ${mainClassName}Exception(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ${mainClassName}Exception(final String message) {
        super(message);
    }

    public ${mainClassName}Exception(final Throwable cause) {
        super(cause);
    }
}
