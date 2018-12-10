package com.administration.StudentAdministration.Services.SearchServices;

public class SearchCriteria {

    private Object value;
    private String Key;
    private String Operation;




    public String getOperation()
    {
        return Operation;
    }

    public void setOperation(String operation)
    {
        Operation = operation;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public String getKey()
    {
        return Key;
    }

    public void setKey(String key)
    {
        Key = key;
    }
}


