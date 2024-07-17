/*
 * package com.vehicle_rental_agency.entity;
 * 
 * import java.util.HashSet; import java.util.Set;
 * 
 * import jakarta.persistence.Entity; import jakarta.persistence.FetchType;
 * import jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType; import jakarta.persistence.Id; import
 * jakarta.persistence.JoinColumn; import jakarta.persistence.JoinTable; import
 * jakarta.persistence.ManyToMany; import jakarta.persistence.Table; import
 * jakarta.persistence.UniqueConstraint; import
 * jakarta.validation.constraints.NotBlank; import
 * jakarta.validation.constraints.Size; import lombok.AllArgsConstructor; import
 * lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
 * 
 * @Data
 * 
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 * 
 * @Builder
 * 
 * @Entity
 * 
 * @Table(name = "users", uniqueConstraints = {
 * 
 * @UniqueConstraint(columnNames = "username"),
 * 
 * @UniqueConstraint(columnNames = "email")}) public class UserDetails {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 * 
 * @NotBlank private String username;
 * 
 * @NotBlank private String email;
 * 
 * @NotBlank private String password;
 * 
 * @ManyToMany(fetch = FetchType.LAZY)
 * 
 * @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name="user_id"),
 * inverseJoinColumns = @JoinColumn(name="role_id")) private Set<RoleDetails>
 * roleDetails= new HashSet<>(); }
 */