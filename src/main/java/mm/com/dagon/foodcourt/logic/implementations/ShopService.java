package mm.com.dagon.foodcourt.logic.implementations;

import lombok.extern.slf4j.Slf4j;
import mm.com.dagon.foodcourt.database.model.Shop;
import mm.com.dagon.foodcourt.database.repo.ShopRepository;
import mm.com.dagon.foodcourt.logic.IShopService;
import mm.com.dagon.foodcourt.payload.request.ShopCreateDTO;
import mm.com.dagon.foodcourt.payload.request.ShopUpdateDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static mm.com.dagon.foodcourt.payload.response.ResponseFactory.*;

@Service
@Slf4j
public class ShopService implements IShopService {

    private final ShopRepository shopRepository;

    private final ModelMapper modelMapper;

    public ShopService(ShopRepository shopRepository, ModelMapper modelMapper) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<?> createShop(ShopCreateDTO createDTO) {
        try {
            Shop shop = modelMapper.map(createDTO, Shop.class);
            shopRepository.save(shop);
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("shopId", shop.getId());
            return onSuccessWithMessage(responseMap, "000", "Shop successfully created");
        } catch (Exception e) {
            return onFailDefault();
        }
    }

    public ResponseEntity<?> getShopById(String id) {
        try {
            Optional<Shop> shopOptional = shopRepository.findById(id);
            return onSuccessWithMessage(shopOptional.orElse(null), "000", "Shop detail data fetched");
        } catch (Exception e) {
            return onFailDefault();
        }
    }

    public ResponseEntity<?> getAllShops() {
        try {
            List<Shop> shopList = shopRepository.findAll();
            return onSuccessWithMessage(shopList, "000", "Shop data fetched");
        } catch (Exception e) {
            return onFailDefault();
        }
    }

    public ResponseEntity<?> updateShop(String id, ShopUpdateDTO updateDTO) throws Exception {
        Shop shop = shopRepository.findById(id).orElse(null);
        if (shop == null) {
            return onFailWithMessage("198", "Shop with the given id cannot be found");
        }
        modelMapper.map(updateDTO, shop);
        shopRepository.save(shop);
        return onSuccessWithMessage(shop, "000", "Successfully updated shop");
    }

    public ResponseEntity<?> deleteShop(String id) {
        if (shopRepository.existsById(id)) {
            shopRepository.deleteById(id);
            return onSuccessWithMessage(null, "001", "Shop deleted");
        } else {
            return onFailWithMessage("198", "Shop with the given id cannot be found");
        }
    }

}
