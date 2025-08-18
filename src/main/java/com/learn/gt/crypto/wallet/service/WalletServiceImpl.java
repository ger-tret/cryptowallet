package com.learn.gt.crypto.wallet.service;

import com.learn.gt.crypto.wallet.dto.WalletMetadataDto;
import com.learn.gt.crypto.wallet.model.WalletMetadata;
import com.learn.gt.crypto.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {

    private WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    @Override
    public UUID createWallet(WalletMetadataDto walletMetadataDto) {
        return null;
    }

    @Override
    public WalletMetadata findWallet(UUID id) {
        return null;
    }


}
