package oss.external;

public class Scheduling {

    private Long id;
    private Long orderId;
    private String customerName;
    private String address;
    private String phoneNumber;
    private Integer internetCount;
    private Integer tvCount;
    private String equipmentId;
    private String visitDateTime;
    private String scheduleState;

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
    public String getVisitDateTime() {
        return visitDateTime;
    }
    public void setVisitDateTime(String visitDateTime) {
        this.visitDateTime = visitDateTime;
    }
    public String getScheduleState() {
        return scheduleState;
    }
    public void setScheduleState(String scheduleState) {
        this.scheduleState = scheduleState;
    }

}
