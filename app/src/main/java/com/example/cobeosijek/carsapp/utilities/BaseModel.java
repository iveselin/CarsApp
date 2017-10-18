package com.example.cobeosijek.carsapp.utilities;

import java.io.Serializable;

/**
 * Created by cobeosijek on 18/10/2017.
 */

public class BaseModel implements Serializable {
    protected String getValueOrEmpty(String string) {
        return (string != null) ? string : "";
    }
}
