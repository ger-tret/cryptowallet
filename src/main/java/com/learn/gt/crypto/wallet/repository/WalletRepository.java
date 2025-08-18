package com.learn.gt.crypto.wallet.repository;

import com.learn.gt.crypto.wallet.model.WalletMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<WalletMetadata, UUID> {
}
