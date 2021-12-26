package com.citizen.setter.domain.repository;

import com.citizen.setter.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
