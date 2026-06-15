package com.finess.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private Activity_Type activityType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
     private Map<String,Object> additionalmatrics;
    
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false, foreignKey = @ForeignKey(name = "fk_activity_user"))
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "activity" , cascade = CascadeType.ALL ,  orphanRemoval = true )
    @JsonIgnore
    private List<Recommadation> recommadations = new ArrayList<>();

   private Integer duration;
   private Integer CaloriesBurened;
   private LocalDateTime  Startedat;

   @UpdateTimestamp
    private LocalDateTime updatedat;

    @CreationTimestamp
    private LocalDateTime createdat;



}
