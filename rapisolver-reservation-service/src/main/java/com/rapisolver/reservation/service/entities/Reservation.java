package com.rapisolver.reservation.service.entities;

import com.rapisolver.reservation.service.enums.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="RESERVATION")
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    private Long userId;

    private Long supplierAttentionId;

    @Column(nullable = false)
    private Date dateRequested;

    @Column(length = 100, nullable = false)
    private String comment;

    @Column
    private StatusOrder status;
}
