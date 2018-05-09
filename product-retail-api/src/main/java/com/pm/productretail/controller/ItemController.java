package com.pm.productretail.controller;

import com.pm.productretail.dto.ItemDto;
import com.pm.productretail.dto.response.ItemInfoResponseDto;
import com.pm.productretail.dto.response.ItemResponseDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.service.ItemService;
import com.pm.productretail.service.SecurityService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController extends ResponseCreator {

    @Autowired
    ItemService itemService;

    @Autowired
    SecurityService securityService;

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> addItem(@RequestBody ItemDto itemDto) {
        itemService.addNewItem(itemDto);
        return createGoodResponse();
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/item/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return createGoodResponse();
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/item/{name}/{page}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<ItemResponseDto>>> findItemByName(@PathVariable String name, @PathVariable Integer page) {
        List<ItemResponseDto> itemList = itemService.getAllItemsByName(name, page);
        return createGoodResponse(itemList);
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<ItemInfoResponseDto>> getItemById(@PathVariable Long id) {
        AppUser currentUser = securityService.getCurrentUser();
        return createGoodResponse(itemService.getItemInfo(id, currentUser.getDepartment()));
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/items/{page}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<ItemResponseDto>>> getItemsPage(@PathVariable int page) {
        return createGoodResponse(itemService.getPage(page));
    }

}
