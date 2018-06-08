package com.followupme.users.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created on June 06, 2018
 * Created by: Badawy Abouads
 *
 * Exception for handling the resources which is not found / 404
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesNotFoundException extends RuntimeException {
    public ResourcesNotFoundException() {
        super();
    }

    public ResourcesNotFoundException(String message) {
        super(message);
    }

    public ResourcesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourcesNotFoundException(Throwable cause) {
        super(cause);
    }
}

