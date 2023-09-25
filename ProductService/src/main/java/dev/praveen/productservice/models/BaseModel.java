package dev.praveen.productservice.models;

import lombok.*;

import java.util.Date;


@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date deletedAt;
    private Date updatedAt;
    private boolean isdeleted;

}
