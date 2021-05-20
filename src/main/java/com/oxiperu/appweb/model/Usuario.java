package com.oxiperu.appweb.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_user")

public class Usuario {
    @Id
    @Column(name = "user_id")
        private String userID;
        private String password;

        public String getUserID() {
            return password;
        }
        public void setUserID(String userID) {
            this.password = userID;
        }
        
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
}
