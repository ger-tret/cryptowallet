package com.learn.gt.crypto.wallet.service;

import com.learn.gt.crypto.wallet.dto.WalletMetadataDto;
import com.learn.gt.crypto.wallet.model.WalletAmount;
import com.learn.gt.crypto.wallet.model.WalletMetadata;

import java.util.UUID;

public interface WalletService {
    UUID createWallet(WalletMetadataDto walletMetadataDto);
    WalletMetadata findWallet(UUID id);
    UUID addToWallet(UUID id, WalletAmount amount);
    UUID subtractFromWallet(UUID id, WalletAmount amount);
    UUID transferFromWalletToWallet(UUID fromId, UUID toId, WalletAmount amount);
    WalletAmount findWalletAndCheckBalance(UUID walletId);
}
