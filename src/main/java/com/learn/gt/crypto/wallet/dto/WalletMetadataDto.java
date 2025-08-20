package com.learn.gt.crypto.wallet.dto;

import com.learn.gt.crypto.wallet.model.WalletAmount;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletMetadataDto {

    @Id
    private UUID walletId;

    @NotNull
    private String password;

    private WalletAmount amount;

    public WalletMetadataDto(String password){
        this.walletId = UUID.randomUUID();
        this.password = password;
        this.amount = WalletAmount.valueOf("0.0");
    }
}
