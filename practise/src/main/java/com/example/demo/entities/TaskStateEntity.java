package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task_state")
public class TaskStateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long taskId;
    private Long ordinal;
    @Column(unique = true)
    private String name;
    private Instant createdAt = Instant.now();
    @Builder.Default
    @OneToMany
    @JoinColumn(name = "id",referencedColumnName = "id")
    private List<TaskEntity> tasks = new ArrayList<>();
}
