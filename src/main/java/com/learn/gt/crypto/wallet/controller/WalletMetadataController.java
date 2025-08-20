package com.learn.gt.crypto.wallet.controller;

import com.learn.gt.crypto.wallet.dto.WalletMetadataDto;
import com.learn.gt.crypto.wallet.model.WalletAmount;
import com.learn.gt.crypto.wallet.model.WalletMetadata;
import com.learn.gt.crypto.wallet.service.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/wallets")
public class WalletMetadataController {

    private WalletServiceImpl walletService;

    @Autowired
    public WalletMetadataController(WalletServiceImpl walletService){
        this.walletService = walletService;
    }

    @PostMapping("/open")
    public ResponseEntity<UUID> createNewWallet(@RequestBody String password){
        return ResponseEntity.ok(walletService.createWallet(new WalletMetadataDto(password)));
    }

    @PostMapping("/transfer")
    public ResponseEntity<UUID> transferSumFromWalletToWallet(@RequestBody WalletMetadataDto walletMetadataDtoFrom, @RequestBody WalletMetadataDto walletMetadataDtoTo, @RequestParam WalletAmount amount){
        return ResponseEntity.ok((walletService.transferFromWalletToWallet(
                        walletMetadataDtoFrom.getWalletId(),
                        walletMetadataDtoTo.getWalletId(),
                        amount)));
    }

    @GetMapping("/balance")
    public ResponseEntity<WalletAmount> checkWalletBalance(@RequestBody WalletMetadataDto walletMetadataDto){
        return ResponseEntity.ok(walletService.findWalletAndCheckBalance(walletMetadataDto.getWalletId()));
    }

    @PutMapping("/add")
    public ResponseEntity<UUID> addSumToWallet(UUID walletId, WalletAmount amount){
        return ResponseEntity.ok(walletService.addToWallet(walletId, amount));
    }

    @PutMapping("/reduce")
    public ResponseEntity<UUID> reduceSumInWallet(UUID walletId, WalletAmount amount){
        return ResponseEntity.ok(walletService.subtractFromWallet(walletId, amount));
    }
}
