package com.learn.gt.crypto.wallet.service;

import com.learn.gt.crypto.wallet.dto.WalletMetadataDto;
import com.learn.gt.crypto.wallet.model.WalletAmount;
import com.learn.gt.crypto.wallet.model.WalletMetadata;
import com.learn.gt.crypto.wallet.repository.WalletRepository;
import com.learn.gt.crypto.wallet.service.mapper.WalletMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {

    private WalletRepository walletRepository;

    private WalletMapper walletMapper;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository, WalletMapper walletMapper){
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    @Transactional
    public UUID createWallet(WalletMetadataDto walletMetadataDto) {
//        if(walletRepository.findById(walletMetadataDto.getWalletId()).isPresent()){
//            throw new RuntimeException("Wallet for that ID=" + walletMetadataDto.getWalletId() + "already exists");
//        }
            return walletRepository.save(walletMapper.mapperDtoToEntity().map(walletMetadataDto)).getWalletId();
    }

    @Override
    @Transactional
    public WalletMetadata findWallet(UUID walletId) {
        return walletRepository.findById(walletId).orElseThrow();
    }

    @Override
    @Transactional
    public WalletAmount findWalletAndCheckBalance(UUID walletId){
        var targetWallet =  walletRepository.findById(walletId).orElseThrow();
        return targetWallet.getAmount();
    }

    @Override
    @Transactional
    public UUID addToWallet(UUID id, WalletAmount amount) {
        WalletMetadata updatedWalletMetadata = walletRepository.findById(id).orElseThrow();
        updatedWalletMetadata.getAmount().add(amount);
        return walletRepository.save(updatedWalletMetadata).getWalletId();
    }

    @Override
    @Transactional
    public UUID subtractFromWallet(UUID id, WalletAmount amount) {
        var updatedWalletMetadata = walletRepository.findById(id).orElseThrow();
        updatedWalletMetadata.getAmount().substract(amount);
        return walletRepository.save(updatedWalletMetadata).getWalletId();
    }

    @Override
    @Transactional
    public UUID transferFromWalletToWallet(UUID fromId, UUID toId, WalletAmount amount) {
        var fromWallet = walletRepository.findById(fromId).orElseThrow();
        var toWallet = walletRepository.findById(toId).orElseThrow();
        try {
            fromWallet.getAmount().substract(amount);
            toWallet.getAmount().add(amount);
            walletRepository.save(fromWallet);
            return walletRepository.save(toWallet).getWalletId();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }



}
