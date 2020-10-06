package oss;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="Activation_table")
public class Activation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String customerName;
    private String address;
    private String phoneNumber;
    private Integer internetCount;
    private Integer tvCount;
    private String equipmentId;
    private String activationState;

    @PostPersist
    public void onPostPersist(){
        if(this.getActivationState().equals("InitiateActivation")) {
            ActivationCompleted activationCompleted = new ActivationCompleted();
            BeanUtils.copyProperties(this, activationCompleted);
            activationCompleted.publishAfterCommit();

            //Following code causes dependency to external APIs
            // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

            oss.external.Scheduling scheduling = new oss.external.Scheduling();
            // mappings goes here
            scheduling.setOrderId(this.getOrderId());
            scheduling.setCustomerName(this.getCustomerName());
            scheduling.setAddress(this.getAddress());
            scheduling.setPhoneNumber(this.getPhoneNumber());
            scheduling.setInternetCount(this.getInternetCount());
            scheduling.setTvCount(this.getTvCount());
            scheduling.setEquipmentId(this.getEquipmentId());
            scheduling.setScheduleState("InitiateSchedule");

            ActivationApplication.applicationContext.getBean(oss.external.SchedulingService.class)
                    .initiateSchedule(scheduling);
        }else {
            System.out.println("#################### Unknown Command is Called ####################");
        }
    }

    @PostUpdate
    public void onPostUpdate(){
        if(this.getActivationState().equals("CancelActivation")) {
            ActivationCancelled activationCancelled = new ActivationCancelled();
            BeanUtils.copyProperties(this, activationCancelled);
            activationCancelled.publishAfterCommit();
            System.out.println("#################### CancelActivation Event has been published ####################");
        }else if(this.getActivationState().equals("RevertActivation")){
            System.out.println("#################### RevertActivation Command has been Completed ####################");
        }else {
            System.out.println("#################### Unknown Command is Called ####################");
        }
    }


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
    public String getActivationState() {
        return activationState;
    }
    public void setActivationState(String activationState) {
        this.activationState = activationState;
    }




}
