package com.giyu.GamingClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.giyu.GamingClub.entities.Member;
@Repository
public interface GameRepository extends JpaRepository<Member, Integer>{

}
