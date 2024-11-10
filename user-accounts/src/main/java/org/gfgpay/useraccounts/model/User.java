package org.gfgpay.useraccounts.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@With
@Builder
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String name;

    private String phone;

    private String password;

    private String email;


}
