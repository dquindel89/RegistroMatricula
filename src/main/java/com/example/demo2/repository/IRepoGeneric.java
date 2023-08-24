package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepoGeneric<T, ID> extends JpaRepository<T, ID> {
}
