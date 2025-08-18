package com.learn.gt.crypto.wallet.controller;

import com.learn.gt.crypto.wallet.dto.WalletMetadataDto;
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
    public ResponseEntity<UUID> createNewWallet(@RequestBody WalletMetadataDto walletMetadataDto){
        return ResponseEntity.ok(walletService.createWallet(walletMetadataDto));
    }

    @PostMapping("/transfer")
    public ResponseEntity<UUID> transferSumFromWalletToWallet(){
        return
    }

    @GetMapping("/balance")
    public ResponseEntity<UUID> checkWalletBalance(){

    }

    @PutMapping("/add")
    public ResponseEntity<UUID> addSumToWallet(){

    }

    @PutMapping("/reduce")
    public ResponseEntity<UUID> reduceSumInWallet(){

    }
}
