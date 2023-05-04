package mm.com.dagon.foodcourt.logic;

import mm.com.dagon.foodcourt.payload.request.MenuCreateDTO;
import mm.com.dagon.foodcourt.payload.request.MenuUpdateDTO;
import org.springframework.http.ResponseEntity;

public interface IMenuService {

    ResponseEntity<?> createMenu(MenuCreateDTO createDTO);

    ResponseEntity<?> getMenuById(String id);

    ResponseEntity<?> getAllMenus();

    ResponseEntity<?> getAllMenusForOneShop(String id);

    ResponseEntity<?> updateMenu(String id, MenuUpdateDTO updateDTO) throws Exception;

    ResponseEntity<?> deleteMenu(String id);
}
