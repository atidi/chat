package com.company.exception;

public class ImageStoreException extends RuntimeException {
    public ImageStoreException() {
        super();
    }

    public ImageStoreException(String imageName) {
        super( imageName);
    }

    public ImageStoreException(String imageName, Throwable cause) {
        super(imageName, cause);
    }

}