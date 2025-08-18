package com.learn.gt.crypto.wallet.service;

import com.learn.gt.crypto.wallet.dto.WalletMetadataDto;
import com.learn.gt.crypto.wallet.model.WalletMetadata;

import java.util.UUID;

public interface WalletService {
    UUID createWallet(WalletMetadataDto walletMetadataDto);
    WalletMetadata findWallet(UUID id);

}
