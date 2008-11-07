package org.codehaus.httpcache4j.payload;

import org.apache.commons.lang.Validate;

import org.codehaus.httpcache4j.MIMEType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FilePayload implements Payload {
    protected File file;
    private MIMEType mimeType;

    public FilePayload(File file, MIMEType mimeType) {
        Validate.notNull(file, "File may not be null");
        Validate.notNull(mimeType, "Mime type may not be null");
        this.file = file;
        this.mimeType = mimeType;
    }

    public MIMEType getMimeType() {
        return mimeType;
    }

    public InputStream getInputStream() {
        try {
            return new FileInputStream(file);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public boolean isAvailable() {
        return file.exists() && file.canRead();
    }

    public boolean isTransient() {
        return false;
    }
}