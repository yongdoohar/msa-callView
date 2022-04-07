package callengineer;

import callengineer.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CallViewViewHandler {


    @Autowired
    private CallViewRepository callViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCallRequested_then_CREATE_1 (@Payload CallRequested callRequested) {
        try {

            if (!callRequested.validate()) return;

            // view 객체 생성
            CallView callView = new CallView();
            // view 객체에 이벤트의 Value 를 set 함
            callView.setId(callRequested.getId());
            callView.setEngineerId(callRequested.getEngineerId());
            callView.setAddress(callRequested.getAddress());
            // view 레파지 토리에 save
            callViewRepository.save(callView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenBusinessTripStarted_then_UPDATE_1(@Payload BusinessTripStarted businessTripStarted) {
        try {
            if (!businessTripStarted.validate()) return;
                // view 객체 조회
            Optional<CallView> callViewOptional = callViewRepository.findById(businessTripStarted.getCallId());

            if( callViewOptional.isPresent()) {
                 CallView callView = callViewOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 callView.setEngineerStatus(businessTripStarted.getStatus());
                // view 레파지 토리에 save
                 callViewRepository.save(callView);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_2(@Payload PaymentApproved paymentApproved) {
        try {
            if (!paymentApproved.validate()) return;
                // view 객체 조회
            Optional<CallView> callViewOptional = callViewRepository.findById(paymentApproved.getCallId());

            if( callViewOptional.isPresent()) {
                 CallView callView = callViewOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 callView.setPaymentStatus(paymentApproved.getStatus());
                // view 레파지 토리에 save
                 callViewRepository.save(callView);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCallRequestCanceled_then_UPDATE_3(@Payload CallRequestCanceled callRequestCanceled) {
        try {
            if (!callRequestCanceled.validate()) return;
                // view 객체 조회
            Optional<CallView> callViewOptional = callViewRepository.findById(callRequestCanceled.getid());

            if( callViewOptional.isPresent()) {
                 CallView callView = callViewOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 callView.setPaymentStatus("0");
                // view 레파지 토리에 save
                 callViewRepository.save(callView);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

