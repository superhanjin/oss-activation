package oss;

public class ActivationCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String customerName;
    private String address;
    private String phoneNumber;
    private Integer internetCount;
    private Integer tvCount;
    private String equipmentId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Integer getInternetCount() {
        return internetCount;
    }
    public void setInternetCount(Integer internetCount) {
        this.internetCount = internetCount;
    }
    public Integer getTvCount() {
        return tvCount;
    }
    public void setTvCount(Integer tvCount) {
        this.tvCount = tvCount;
    }
    public String getEquipmentId() {
        return equipmentId;
    }
    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }
}