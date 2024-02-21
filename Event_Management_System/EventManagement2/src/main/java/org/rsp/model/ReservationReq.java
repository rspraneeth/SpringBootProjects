package org.rsp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReservationReq {
    private Integer userId;
    private Integer eventId;
    private Integer tickets;
}
