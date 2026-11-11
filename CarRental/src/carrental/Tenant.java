package carrental;

public class Tenant{

    private int tenantId;
    private String tenantName;

    public Tenant(int tenantId, String tenantName) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
    }

    public String getTenantName() {
        return tenantName;
    }
    
    public int getTenantId() {
        return tenantId;
    }
    
    public void setTenantName(String tenantName)
    {
        this.tenantName = tenantName;
    }
    
    public void setTenantId(int tenantId)
    {
        this.tenantId = tenantId;
    }
}
