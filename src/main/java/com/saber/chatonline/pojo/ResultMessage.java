package com.saber.chatonline.pojo;

import lombok.Data;

@Data
public class ResultMessage {
    private boolean system;
    private Object message;
    private String fromName;
}
