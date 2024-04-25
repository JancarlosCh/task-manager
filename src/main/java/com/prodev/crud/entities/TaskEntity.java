package com.prodev.crud.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "task_id")
  private Long taskId;

  @Column(name = "task_name", nullable = false)
  private String taskName;

  @Column(name = "task_description", nullable = false)
  private String taskDescription;

  @Column(name = "is_complete", nullable = false)
  private Boolean isComplete;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @Column()
  private Timestamp createdAt;

  @Column()
  private Timestamp updatedAt;
}
