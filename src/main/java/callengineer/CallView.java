package callengineer;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="CallView_table")
public class CallView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long paymentId;
        private Long engineerId;
        private String address;
        private String engineerStatus;
        private String paymentStatus;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(Long paymentId) {
            this.paymentId = paymentId;
        }
        public Long getEngineerId() {
            return engineerId;
        }

        public void setEngineerId(Long engineerId) {
            this.engineerId = engineerId;
        }
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
        public String getEngineerStatus() {
            return engineerStatus;
        }

        public void setEngineerStatus(String engineerStatus) {
            this.engineerStatus = engineerStatus;
        }
        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

}