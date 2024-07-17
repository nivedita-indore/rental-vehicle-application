/*
 * package com.vehicle_rental_agency.entity;
 * 
 * import jakarta.persistence.Column; import jakarta.persistence.Entity; import
 * jakarta.persistence.EnumType; import jakarta.persistence.Enumerated; import
 * jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType; import jakarta.persistence.Id; import
 * jakarta.persistence.Table; import lombok.AllArgsConstructor; import
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
 * @Table(name = "roles") public class RoleDetails {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
 * 
 * @Enumerated(EnumType.STRING)
 * 
 * @Column(length = 20) private RoleDetails name;
 * 
 * 
 * public RoleDetails() { }
 * 
 * public RoleDetails(Integer id, RoleDetails name) { super(); this.id = id;
 * this.name = name; }
 * 
 * public Integer getId() { return id; }
 * 
 * public void setId(Integer id) { this.id = id; }
 * 
 * public RoleDetails getName() { return name; }
 * 
 * public void setName(RoleDetails name) { this.name = name; }
 * 
 * }
 */