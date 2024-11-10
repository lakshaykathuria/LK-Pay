package org.lkpay.useraccounts.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@With
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID accountId;

    @OneToOne
    private User user;

    @Builder.Default
    private Double balance = 0.0;

    @Builder.Default
    private Instant createdAt = Instant.now();

    @Builder.Default
    private Boolean kycComplete = false;

}
