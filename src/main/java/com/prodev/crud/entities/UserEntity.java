package com.prodev.crud.entities;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

@ToString
@EqualsAndHashCode

public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "user_id")
  private Long userId;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(unique = true, nullable = false)
  private String email;

  @Setter
  @Column(unique = true, nullable = false)
  private String password;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<TaskEntity> userTasks;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "updated_at")
  private Timestamp updatedAt;
}
