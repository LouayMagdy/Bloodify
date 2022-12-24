package com.bloodify.backend.Chat.model.entities;

import java.io.Serializable;

import com.bloodify.backend.AccountManagement.model.entities.User;
import com.bloodify.backend.UserRequests.model.entities.Post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EqualsAndHashCode
@Entity
public class Chat implements Serializable {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer chatID;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "postID")
    private Post post;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userID")
    private User donor;

    public Chat(int chatID, Post post, User donor) {
        this.chatID = chatID;
        this.post = post;
        this.donor = donor;
    }

}
