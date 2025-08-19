package com.learn.gt.crypto.wallet.service.mapper;

import com.learn.gt.crypto.wallet.dto.WalletMetadataDto;
import com.learn.gt.crypto.wallet.model.WalletAmount;
import com.learn.gt.crypto.wallet.model.WalletMetadata;
import org.springframework.stereotype.Service;

@Service
public class WalletMapper {
    private final Mapper<WalletMetadata, WalletMetadataDto> entityToDto =
            entity -> new WalletMetadataDto(entity.getWalletId(),
                    entity.getPassword(),
                    entity.getAmount());
    private final Mapper<WalletMetadataDto, WalletMetadata> dtoToEntity =
            dto -> new WalletMetadata(dto.getWalletId(),
                    dto.getPassword(),
                    dto.getAmount());

    public Mapper<WalletMetadata, WalletMetadataDto> mapperEntityToDto(){
        return entityToDto;
    }

    public Mapper<WalletMetadataDto, WalletMetadata> mapperDtoToEntity(){
        return dtoToEntity;
    }
}
