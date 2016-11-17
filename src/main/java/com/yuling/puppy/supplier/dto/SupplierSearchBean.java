package com.yuling.puppy.supplier.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by yangyongli on 25/10/2016.
 */
public class SupplierSearchBean implements Serializable {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("code", code)
            .append("name", name)
            .toString();
    }
}
