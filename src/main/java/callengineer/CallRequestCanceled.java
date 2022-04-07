package callengineer;


public class CallRequestCanceled extends AbstractEvent {

    private Long id;
    private Long engineerId;

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public Long getengineerId() {
        return engineerId;
    }

    public void setengineerId(Long engineerId) {
        this.engineerId = engineerId;
    }
}
