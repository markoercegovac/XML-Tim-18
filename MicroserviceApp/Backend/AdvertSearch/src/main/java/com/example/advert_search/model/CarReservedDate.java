package com.example.advert_search.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class CarReservedDate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long carReservedDateId;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column
    private Date startOfAdvert;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column
    private Date endOfAdvert;



    public CarReservedDate(Date datep1, Date datek1) {
        this.startOfAdvert=datep1;
        this.endOfAdvert=datek1;
    }
}
