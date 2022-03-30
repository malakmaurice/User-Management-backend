package com.example.user_management.repository;

import com.example.user_management.entity.SearchCriateria;
import com.example.user_management.entity.Status;
import com.example.user_management.entity.User;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserReposotoryImp implements customUserReposotory{
    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<User> search(SearchCriateria searchCriateria) {
        Session currentSession =entityManager.unwrap(Session.class);

        String hql ="select u from User u where u.userID>=1";
        if(searchCriateria.getSearchField()!=null){
            hql+=" and u.userName like :searchfield";
        }if(searchCriateria.getUserGroup()!=null && !searchCriateria.getUserGroup().equals(Status.Any)){
            hql+=" and u.userStatus =:groupfield";
        }
        Query theQuery=currentSession.createQuery(hql,User.class);
        if(searchCriateria.getSearchField()!=null){
            theQuery.setParameter("searchfield","%"+searchCriateria.getSearchField()+"%");
        }

        if(searchCriateria.getUserGroup()!=null && !searchCriateria.getUserGroup().equals(Status.Any)){
            theQuery.setParameter("groupfield",searchCriateria.getUserGroup());;
        }

        return theQuery.getResultList();
    }
}
