package oss;

import oss.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyHandler{

    @Autowired
    ActivationRepository activationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelled_CancelActivation(@Payload OrderCancelled orderCancelled){

        if(orderCancelled.isMe()){
            List<Activation> activationList = activationRepository.findByOrderId(orderCancelled.getId());
            for(Activation activation : activationList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                activation.setActivationState("CancelActivation");
                // view 레파지 토리에 save
                activationRepository.save(activation);
            }

            System.out.println("##### listener CancelActivation : " + orderCancelled.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverFieldWorkFailed_RevertActivation(@Payload FieldWorkFailed fieldWorkFailed){

        if(fieldWorkFailed.isMe()){
            List<Activation> activationList = activationRepository.findByOrderId(fieldWorkFailed.getOrderId());
            for(Activation activation : activationList){
                activation.setActivationState("RevertActivation");
                activationRepository.save(activation);
            }

            System.out.println("##### listener RevertActivation : " + fieldWorkFailed.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderPlaced_InitiateActivation(@Payload OrderPlaced orderPlaced){

        if(orderPlaced.isMe()){
            Activation activation = new Activation();
            activation.setOrderId(orderPlaced.getId());
            activation.setCustomerName(orderPlaced.getCustomerName());
            activation.setAddress(orderPlaced.getAddress());
            activation.setPhoneNumber(orderPlaced.getPhoneNumber());
            activation.setInternetCount(orderPlaced.getInternetCount());
            activation.setTvCount(orderPlaced.getTvCount());
            Integer equipmentIdMaker = (int)(Math.random()*100);
            activation.setEquipmentId(String.valueOf(equipmentIdMaker));
            activation.setActivationState("InitiateActivation");

            activationRepository.save(activation);

            System.out.println("##### listener InitiateActivation : " + orderPlaced.toJson());
        }
    }

}
