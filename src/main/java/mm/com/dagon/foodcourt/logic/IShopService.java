package mm.com.dagon.foodcourt.logic;

import mm.com.dagon.foodcourt.payload.request.ShopCreateDTO;
import mm.com.dagon.foodcourt.payload.request.ShopUpdateDTO;
import org.springframework.http.ResponseEntity;

public interface IShopService {

    ResponseEntity<?> createShop(ShopCreateDTO createDTO);

    ResponseEntity<?> getShopById(String id);

    ResponseEntity<?> getAllShops();

    ResponseEntity<?> updateShop(String id,ShopUpdateDTO updateDTO) throws Exception;

    ResponseEntity<?> deleteShop(String id);
}
