package org.codehaus.httpcache4j.resolver;

import org.codehaus.httpcache4j.Headers;
import org.codehaus.httpcache4j.payload.Payload;

import java.io.InputStream;

/**
 * Creates a payload from the response. Most users will want to use the
 * DefaultPayloadCreator in the core project.
 * This is expected to be used with the ResponseResolver.
 *
 * @author <a href="mailto:erlend@hamnaberg.net">Erlend Hamnaberg</a>
 */
public interface PayloadCreator {
    /**
     * Creates a payload useable by the response.
     *
     * @param headers the headers to determine cacheablity
     * @param stream  the stream to create the payload from.
     * @return the created payload
     */
    Payload createPayload(Headers headers, InputStream stream);
}
