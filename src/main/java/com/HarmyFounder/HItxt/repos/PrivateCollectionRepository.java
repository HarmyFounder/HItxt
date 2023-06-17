package com.HarmyFounder.HItxt.repos;

import com.HarmyFounder.HItxt.models.PrivateCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateCollectionRepository extends JpaRepository<PrivateCollection,Long> {
}
