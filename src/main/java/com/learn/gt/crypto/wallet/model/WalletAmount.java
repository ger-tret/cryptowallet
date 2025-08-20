package com.learn.gt.crypto.wallet.model;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletAmount implements Serializable {

    private Long beforeDecimalPoint;
    private Long afterDecimalPoint;

    public static WalletAmount valueOf(String amount){;
        String[] values = amount.split("[.]");
        return new WalletAmount(Long.valueOf(values[0]), Long.valueOf(values[1]));
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
