package com.bloodify.backend.UserRequests.service.entities;

import com.bloodify.backend.AccountManagement.model.entities.User;
import com.bloodify.backend.UserRequests.model.entities.Post;
import com.bloodify.backend.UserRequests.service.interfaces.CompatiblePosts;
import com.bloodify.backend.UserRequests.service.interfaces.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompatiblePostsImp implements CompatiblePosts {
    @Autowired
    private PostDao postDAO;

    double distance(double lat1, double long1, double lat2, double long2) {
//      Radius of the earth
        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(long2 - long1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }

    List<Post> getAllPostsMatchingBloodType(String bloodType) {
        return this.postDAO.getAllBloodTypePosts(bloodType);
    }

    boolean isPostMatchingUserDistance(User user, Post post, double threshold) {
        double longUser = user.getLongitude();
        double latUser = user.getLatitude();

        double longInst = post.getInstitution().getLongitude();
        double latInst = post.getInstitution().getLatitude();

        return distance(latUser, longUser, latInst, longInst) < threshold;
    }

    public List<Post> allPostsMatching (User user, double threshold) {
        String bloodType = user.getBloodType();
        List<Post> matchingBloodType = getAllPostsMatchingBloodType(bloodType);
        List<Post> compatiblePosts = new ArrayList<>();
        for(Post p: matchingBloodType) {
            if(isPostMatchingUserDistance(user, p, threshold))
                compatiblePosts.add(p);
        }
        return compatiblePosts;
    }

}
