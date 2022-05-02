package optum.health.dtc.salesforce.model;

import java.io.Serializable;

public class User implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Employee data;
    private Object support;

    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
        this.data = data;
    }

    public Object getSupport() {
        return support;
    }

    public void setSupport(Object support) {
        this.support = support;
    }
}
