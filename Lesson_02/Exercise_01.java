package Lesson_02.Exercise_01;

import java.time.LocalDate;
import java.util.List;

public class Exercise_01 {
    public sealed interface KycStatus
            permits KycStatus.Verified,
            KycStatus.Pending,
            KycStatus.Rejected,
            AppealableStatus {

        record Verified(String customerId, LocalDate approvedOn)
                implements KycStatus {
        }

        record Pending(String customerId, String missingDoc)
                implements KycStatus {
        }

        record Rejected(String customerId, String reason)
                implements KycStatus {
        }
    }

    static String describe(KycStatus s) {
        return switch (s) {

            case KycStatus.Verified v -> "KYC Verified for " + v.customerId + " : approved on" + v.approvedOn;

            case KycStatus.Pending p -> "KYC Pending for " + p.customerId + " : missing " + p.missingDoc;

            case KycStatus.Rejected r -> "KYC Rejected for " + r.customerId + ": reason " + r.reason;

            case AppealableStatus a -> "Appealable status, reason: " + a.appealReason();
        };
    }

    static void main(String[] args) {

        List<KycStatus> statuses = List.of(
                new KycStatus.Verified("C-001", LocalDate.of(2026, 5, 10)),
                new KycStatus.Pending("C-002", "Passport"),
                new KycStatus.Rejected("C-003", "Address mismatch"),
                new ReviewRequest("C-003", "Address mismatch")
        );

        for (KycStatus s : statuses) {
            System.out.println(describe(s));
        }
    }

    /*class CustomStatus implements KycStatus {
    }*/

    non-sealed interface AppealableStatus extends KycStatus {

        String appealReason();
    }

    static class ReviewRequest implements AppealableStatus {
        private final String customerId;
        private final String appealReason;

        public ReviewRequest(String customerId, String appealReason) {
            this.customerId = customerId;
            this.appealReason = appealReason;
        }

        @Override
        public String appealReason() {
            return appealReason;
        }

        public String getCustomerId() {
            return customerId;
        }
    }
}
