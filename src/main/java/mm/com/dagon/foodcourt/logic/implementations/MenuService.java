package mm.com.dagon.foodcourt.logic.implementations;


import lombok.extern.slf4j.Slf4j;
import mm.com.dagon.foodcourt.database.model.Menu;
import mm.com.dagon.foodcourt.database.repo.MenuRepository;
import mm.com.dagon.foodcourt.logic.IMenuService;
import mm.com.dagon.foodcourt.payload.request.MenuCreateDTO;
import mm.com.dagon.foodcourt.payload.request.MenuUpdateDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static mm.com.dagon.foodcourt.payload.response.ResponseFactory.*;

@Service
public class MenuService implements IMenuService {

    private final MenuRepository menuRepository;

    private final ModelMapper modelMapper;

    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<?> createMenu(MenuCreateDTO createDTO) {
        try {
            Menu menu = modelMapper.map(createDTO, Menu.class);
            menuRepository.save(menu);
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("menuId", menu.getId());
            return onSuccessWithMessage(responseMap, "000", "Menu successfully created");
        } catch (Exception e) {
            return onFailDefault();
        }
    }

    public ResponseEntity<?> getMenuById(String id) {
        try {
            Optional<Menu> menuOptional = menuRepository.findById(id);
            return onSuccessWithMessage(menuOptional.orElse(null), "000", "Menu detail data fetched");
        } catch (Exception e) {
            return onFailDefault();
        }
    }

    public ResponseEntity<?> getAllMenus() {
        try {
            List<Menu> menuList = menuRepository.findAll();
            return onSuccessWithMessage(menuList, "000", "Menu data fetched");
        } catch (Exception e) {
            return onFailDefault();
        }
    }

    public ResponseEntity<?> getAllMenusForOneShop(String id) {
        try {
            List<Menu> menuList = menuRepository.findByShopId(id);
            return onSuccessWithMessage(menuList, "000", "Menu data fetched");
        } catch (Exception e) {
            return onFailDefault();
        }
    }


    public ResponseEntity<?> updateMenu(String id, MenuUpdateDTO updateDTO) throws Exception {
        Menu menu = menuRepository.findById(id).orElse(null);
        if (menu == null) {
            return onFailWithMessage("198", "Menu with the given id cannot be found");
        }
        modelMapper.map(updateDTO, menu);
        menuRepository.save(menu);
        return onSuccessWithMessage(menu, "000", "Successfully updated menu");
    }

    public ResponseEntity<?> deleteMenu(String id) {
        if (menuRepository.existsById(id)) {
            menuRepository.deleteById(id);
            return onSuccessWithMessage(null, "001", "Menu deleted");
        } else {
            return onFailWithMessage("198", "Menu with the given id cannot be found");
        }
    }
}
