package com.learn.gt.crypto.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletAmount {

    private Long beforeDecimalPoint;
    private Long afterDecimalPoint;

    public static WalletAmount valueOf(String amount){
        WalletAmount walletAmount = null;
        String[] values = amount.split(":");
        walletAmount.beforeDecimalPoint = Long.valueOf(values[0]);
        walletAmount.afterDecimalPoint = Long.valueOf(values[1]);
        return walletAmount;
    }

    public static WalletAmount valueOf(BigDecimal amount){
        return WalletAmount.valueOf(amount.toString());
    }

    public void add(WalletAmount walletAmount){
        this.afterDecimalPoint += walletAmount.afterDecimalPoint;
        if(this.afterDecimalPoint > 99999999){
            this.beforeDecimalPoint++;
            this.afterDecimalPoint = Long.valueOf(0);
        }
        this.beforeDecimalPoint += walletAmount.beforeDecimalPoint;

    }

    public void substract(WalletAmount walletAmount){
        this.beforeDecimalPoint -= walletAmount.beforeDecimalPoint;
        this.afterDecimalPoint -= walletAmount.afterDecimalPoint;
    }

    @Override
    public String toString(){
        return new String(beforeDecimalPoint.toString() + "." + afterDecimalPoint.toString());
    }

    public BigDecimal toBigDecimal(){
        return new BigDecimal(this.toString());
    }


}
