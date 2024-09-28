package com.aburaya.hotel.api.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RoomCreateRequest {
   
   @NotNull
   @Size(max = 150)
   private String name;



}