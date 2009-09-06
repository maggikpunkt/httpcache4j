/*
 * Copyright (c) 2009. The Codehaus. All Rights Reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.codehaus.httpcache4j.resolver;

import org.codehaus.httpcache4j.*;
import org.codehaus.httpcache4j.payload.Payload;
import org.codehaus.httpcache4j.payload.InputStreamPayload;

import java.io.InputStream;

/**
 * @author <a href="mailto:hamnis@codehaus.org">Erlend Hamnaberg</a>
 * @version $Revision: #5 $ $Date: 2008/09/15 $
 */
public final class ResponseCreator {
    public HTTPResponse createResponse(final Status status, final Headers responseHeaders, final InputStream stream) {
        Header contentTypeHeader = responseHeaders.getFirstHeader(HeaderConstants.CONTENT_TYPE);
        MIMEType type = contentTypeHeader != null ? MIMEType.valueOf(contentTypeHeader.getValue()) : MIMEType.APPLICATION_OCTET_STREAM;
        Payload payload = null;
        if (status.isBodyContentAllowed()) {
            if (stream != null) {
                payload = new InputStreamPayload(stream, type);
            }
        }
        return new HTTPResponse(payload, status, responseHeaders);
    }    
}
