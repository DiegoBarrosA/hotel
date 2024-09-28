package com.aburaya.hotel.api.request;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomUpdateRequest {
    
   @NotNull
   @Size(min = 3, max = 10)
   @Pattern(regexp = "^[a-zA-Z0-9._-]+$")
   private String name;
   private Integer beds;

}
